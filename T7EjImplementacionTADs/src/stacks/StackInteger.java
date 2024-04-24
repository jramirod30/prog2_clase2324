package stacks;

import node.Node;
import stacks.exceptions.EmptyStackException;


public class StackInteger
{
	private Node<Integer> head;

	/**
	 * Constructor
	 */
	public StackInteger() {
		head = null;    
	} 

	
	private void remove() throws EmptyStackException 
	{
		if (this.isEmpty())
			throw new EmptyStackException();

		Node<Integer> aux=this.head;
		this.head=aux.next();	   
		//El puntero Aux deja de estar referenciado
		//Por tanto la memoria asignada ser� recuperada
		//cuando el proceso gc se ejecute
	}

	/**
	 * Indica si la pila est� vac�a
	 * <br><B>PRE:</B> Cierto
	 * <br><B>POST:</B> cierto si no quedan elementos en la pila
	 * <br><B>COMPLEJIDAD:</B> O(1)<br>
	 * 
	 */
	public boolean isEmpty ()
	{//Esta_Vacia
		return this.head==null;
	}

	/**
	 * Apila un elemento en la pila; el elemento apilado se coloca como nueva cima
	 * <br><B>PRE:</B> Cierto
	 * <br><B>POST:</B>Pila de entrada con el elemento dado como nueva cima
	 * <br><B>COMPLEJIDAD:</B> O(1)<br>
	 * @param  elemento Referencia a la informaci�n que se va a guardar en la pila. <B> No se saca copia de la informaci�n referenciada</B>
	 */
	public void push (int elemento)
	{        
		this.head= new Node<Integer> (elemento, this.head);        
	}

	/**
	 * Retorna el elemento cima de la pila, sin alterar la pila
	 * <br><B>PRE:</B> la pila no es vac�a
	 * <br><B>POST:</B>Retorna referencia al elemento que ocupa la cima de la pila
	 * <br><B>COMPLEJIDAD:</B> O(1)<br>
	 * @return retorna el elemento cima de la cola. 
	 * @throws EmptyStackException excepci�n que se genera si se viola la precondici�n
	 */
	public int peek () throws EmptyStackException
	{
		if (this.isEmpty())
			throw new EmptyStackException();        
		else
			return this.head.getElem();
	}

	/**
	 * Vac�a el contenido de una pila; Se deja de referenciar a los elementos contenidos en la pila
	 * <br><B>PRE:</B> Cierto
	 * <br><B>POST:</B> la pila est� vac�a
	 * <br><B>COMPLEJIDAD:</B> O(1)<br>
	 */
	public void makeEmpty()
	{//Vaciar
		this.head=null; //En java basta con dejar sin referencia un bloque de memoria
		//para que �ste pueda ser recuperado por el sistema
		//Si se desea forzar la recuperaci�n de forma inmediata de la memoria
		//asignada basta con forzar la entrada del garbage collection:
		System.gc(); /* Esta llamada puede consumir mucha CPU.
		 * lo normal es dejar a la m�quina virtual Java
		 * que la realice cuando lo considere oportuno.
		 */
	}

	/**
	 * Saca el primer elemento de la pila
	 * <br><B>PRE:</B> la pila no est� vac�a
	 * <br><B>POST:</B> Se retorna la referencia al elemento cima de la pila y se extrae esta referencia de la pila
	 * <br><B>COMPLEJIDAD:</B> O(1)<br>
	 * @return saca el elemento cima de la pila y lo retorna. 
	 * @throws EmptyStackException excepci�n que se genera si se viola la precondici�n
	 */
	public int pop() throws EmptyStackException
	{//Sacar_Primero
		int aux=this.peek();
		this.remove();
		return aux;
	}//Sacar_Primero

}