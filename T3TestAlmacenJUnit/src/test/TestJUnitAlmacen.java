package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tienda.Almacen;

public class TestJUnitAlmacen {

	
	private Almacen almacen;
	
	@Before
	public void setUp() {
		almacen = new Almacen(3);
	}
	
	@Test
	public void testConstructor() {
		//almacen = null;
		
		assertEquals("La pos 0 no contiene 0 unidades", 0, almacen.get(0));
		assertEquals("La pos 1 no contiene 0 unidades", 0, almacen.get(1));
		assertEquals("La pos 2 no contiene 0 unidades", 0, almacen.get(2));
	}
	
	@Test
	public void testRecibirProductos() {
		almacen.recibirProductos(0, 3);
		
		assertEquals("La pos 0 no contiene 3 unidades", 3, almacen.get(0));
		
		almacen.recibirProductos(1, 2);
		
		assertEquals("La pos 1 no contiene 2 unidades", 2, almacen.get(1));
		
		almacen.recibirProductos(0, 1);
		
		assertEquals("La pos 1 no contiene 4 unidades", 4, almacen.get(0));
		
	}
	
	// Presupone que funciona bien el recibirProductos
	@Test
	public void testToString() {
		almacen.recibirProductos(0, 2);
		almacen.recibirProductos(1, 3);
		almacen.recibirProductos(2, 4);	
		
		assertEquals("El string no es correcto", "[2, 3, 4]", almacen.toString());
		
	}
	
	

}
