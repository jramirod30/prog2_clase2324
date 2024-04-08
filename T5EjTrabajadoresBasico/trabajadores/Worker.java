package trabajadores;

public class Worker extends Person {
	
	private String nSS;
	
	public Worker(String nombre, int edad, String nSS) {
		super(nombre, edad);
		
		this.nSS = nSS;
	}

}
