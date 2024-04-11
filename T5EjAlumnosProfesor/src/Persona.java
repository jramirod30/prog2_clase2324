
public class Persona {
	
	private String nombre;
	private int edad;
	
	public Persona(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}
	
	@Override
	public String toString() {
		return nombre + " " + edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}

}
