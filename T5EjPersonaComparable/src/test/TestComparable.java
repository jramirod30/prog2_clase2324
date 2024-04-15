package test;
import personas.Persona;
import fecha.FechaComparable;
import fecha.excepciones.FechaIncorrecta;

public class TestComparable {

	public static void main(String[] args) throws FechaIncorrecta {
		Persona persona1 = new Persona("David", new FechaComparable("3/04/1995"));
		Persona persona2 = new Persona("Clara", new FechaComparable("5/09/2000"));
		Persona persona3 = new Persona("Jose", new FechaComparable("1/01/1992"));
		
		System.out.println(persona1.compareTo(persona2));	
	System.out.println(persona1);
	System.out.println(persona2);
	
	System.out.println(persona1.compareTo(persona3));	
	System.out.println(persona1);
	System.out.println(persona3);


		
	}

}
