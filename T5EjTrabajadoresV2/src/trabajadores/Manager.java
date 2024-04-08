package trabajadores;

public class Manager extends Employee {

	private double bonus;
	
	public Manager(String nombre, int edad, String nSS, double salary, double bonus) {
		super(nombre, edad, nSS, salary);
		this.bonus = bonus;
	}
	
	@Override
	public String toString() {
		return super.toString() + " " + bonus;
	}

}
