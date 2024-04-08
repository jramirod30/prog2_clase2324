package trabajadores;

public class Employee extends Worker {

	private double salary;
	
	public Employee(String nombre, int edad, String nSS, double salary) {
		super(nombre, edad, nSS);
		this.salary=salary;
	}
	
	@Override
	public String toString() {
		return super.toString() + " " + salary;
	}

}
