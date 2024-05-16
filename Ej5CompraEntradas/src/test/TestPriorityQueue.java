package test;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Assert;
import org.junit.Test;

import list.ArrayList;
import priorityQueue.PriorityQueue;
import priorityQueue.exception.IncorrectPriority;
import queues.IQueue;
import queues.exceptions.EmptyQueueException;

public class TestPriorityQueue {
	private static final String PKG = "priorityQueue.";
	private static final String CLAZZ = PKG + "PriorityQueue";
	private static final int PRIORITIES = 4;
	private final static String[] DATA_SET1_STR= {"One P1", "One P2", "One P3","Two P1","One P4", "Three P1","Two P3","Two P4","Three P4",
                                     "Four P4","Five P4","Six P4"};
	private final static int[] DATA_SET1_INT = { 1, 2, 3 , 1, 4, 1 , 3, 4, 4, 4, 4, 4};
	
	@Test
	public void testEmpty() {
		PriorityQueue<String> priority = new PriorityQueue<String>(TestPriorityQueue.PRIORITIES);
		Assert.assertTrue("Error at the beginning queue must be empty", priority.isEmpty());
		Assert.assertEquals("Error at the beginning there is 0 waiting to be attended", 0, priority.getTotalEsperando());
	}
	
	/**
	 * Test if data add to a priority queue were placed in the correct place
	 */
	@Test
	public void testCreateDataSet1() {
		PriorityQueue<String> priority = new PriorityQueue<String>(TestPriorityQueue.PRIORITIES); 
		ArrayList<IQueue<String>> colaEspera = null;
		try {
			colaEspera = TestPriorityQueue.makesPublic(priority);
			//We gain access to private attribute so we can go to next step
			TestPriorityQueue.addDataSet(priority,TestPriorityQueue.DATA_SET1_STR, TestPriorityQueue.DATA_SET1_INT);
			Assert.assertEquals("Error must be waiting to be attended: " + TestPriorityQueue.DATA_SET1_STR.length, 
					TestPriorityQueue.DATA_SET1_STR.length, priority.getTotalEsperando());
			for (int i = 0; i < TestPriorityQueue.DATA_SET1_STR.length; i++) {
				Assert.assertEquals("Data was no put in correct place", TestPriorityQueue.DATA_SET1_STR[i], 
						colaEspera.get(TestPriorityQueue.DATA_SET1_INT[i]-1).poll());
			}
			
		}catch (IllegalArgumentException | NoSuchFieldException | SecurityException | ClassNotFoundException e) {
			fail("No se ha podido acceder al atributo colaEspera en la clase " + "PriorityQueue");
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IncorrectPriority e) {
			e.printStackTrace();
			fail("Unexpected exception IncorrectPriority");
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unexpected exception IndexOutOfBoundsException");
		} catch (EmptyQueueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unexpected exception EmptyQueueException");
		}
	}
	
	/**
	 * Test if getNext retrieve the elements in the correct order
	 */
	@Test
	public void testGetNext() {
		PriorityQueue<String> priority = new PriorityQueue<String>(TestPriorityQueue.PRIORITIES); 
		try {
			//We gain access to private attribute so we can go to next step
			TestPriorityQueue.addDataSet(priority,TestPriorityQueue.DATA_SET1_STR, TestPriorityQueue.DATA_SET1_INT);
			String [] sortedData= java.util.Arrays.copyOf(TestPriorityQueue.DATA_SET1_STR, TestPriorityQueue.DATA_SET1_STR.length);
			java.util.Arrays.sort(sortedData, (x,y) -> -1 * x.substring(x.length()-2).compareTo(y.substring(y.length()-2)));
			int waiting = sortedData.length;
			for (String nextValue: sortedData) {
				String data = priority.getNext();
				waiting -= 1;
				Assert.assertEquals("Error must be waiting to be attended: " + waiting, 
						waiting, priority.getTotalEsperando());
				Assert.assertEquals("Error data must be equals", 
						nextValue,data);
				
			}
			Assert.assertEquals("Error must be waiting to be attended: " + 0, 
					0, priority.getTotalEsperando());
			Assert.assertTrue("Error queue must be empty", priority.isEmpty());
		}catch (IllegalArgumentException | SecurityException  e) {
			fail("No se ha podido acceder al atributo colaEspera en la clase " + "PriorityQueue");
		} catch (IncorrectPriority e) {
			e.printStackTrace();
			fail("Unexpected exception IncorrectPriority");
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unexpected exception IndexOutOfBoundsException");
		} catch (EmptyQueueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unexpected exception EmptyQueueException");
		}
	}
	
	private static ArrayList<IQueue<String>> makesPublic(PriorityQueue<String> queue)
			throws NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
		Class<?> classPriorityQueue = Class.forName(CLAZZ);
		Field field = classPriorityQueue.getDeclaredField("colaEspera");
		field.setAccessible(true); //makes public colaEspera
		return (ArrayList<IQueue<String>>)field.get(queue);
	}
	
	/***
	 * PRE: data y priority tienen exáctamente el mismoi número de elementos
	 * @param queue
	 * @param data
	 * @param priority
	 * @throws IncorrectPriority 
	 */
	private static void addDataSet(PriorityQueue<String> queue, String[] data, int[] priority) throws IncorrectPriority {
		for (int i = 0; i < data.length ; i++) {
			queue.add(priority[i], data[i]);
		}
	}

}
