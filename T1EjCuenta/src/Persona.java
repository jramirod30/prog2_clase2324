
public class Persona {
	private String nombre;
	private String dni;
	private int edad;
	
	public Persona(String nombre, String dni, int edad) {
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
	}
	
	public String toString() {
		return nombre + " " + dni + " " + edad; 
	}
	
	public boolean esIgual(Persona per) {
		return edad == per.edad && nombre.equals(per.nombre) &&
				dni.equals(per.dni);
	}
}
