package trabajadores;

public class OutsideConsultant extends Worker {

	private double rate;
	private String company;
	private double hours;
	public OutsideConsultant(String nombre, int edad, String nSS, double rate, double hours, String company) {
		super(nombre, edad, nSS);
		this.rate=rate;
		this.company=company;
		this.hours=hours;
	}

	@Override
	public String toString() {
		return super.toString() + " " + rate + " " + company + " " + hours;
	}
}
