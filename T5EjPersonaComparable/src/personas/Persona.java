package personas;
import fecha.FechaComparable;


public class Persona implements Comparable<Persona> {
	private String nombre; 
	private FechaComparable fechaNacimiento;
	
	public Persona(String nombre, FechaComparable fechaNacimiento){
		this.nombre = nombre; 
		this.fechaNacimiento = new FechaComparable(fechaNacimiento);
	}
	
	public String toString(){
		return nombre + " " + fechaNacimiento;
	}
	
	@Override
	public int compareTo(Persona otro) {
		return -1 * this.fechaNacimiento.compareTo(otro.fechaNacimiento);
	}
	
		
	
}









