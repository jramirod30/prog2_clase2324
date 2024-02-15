
public class Cuenta {
	private double saldo;	
	private static double gastosApertura = 10;	
	private Persona cliente;	

	public Cuenta(double saldo, Persona cliente) {
		this.saldo = saldo - Cuenta.gastosApertura;
		this.cliente = cliente;
	}

	public void setSaldo (double saldo){ 
		this.saldo = saldo;
	}

	public static void setGastosApertura (double gastosA){
		Cuenta.gastosApertura = gastosA;
	}
	
	public static double getGastosApertura() {
		return Cuenta.gastosApertura;
	}

	public String toString(){
		return Cuenta.gastosApertura + " " + saldo + " " + cliente; 
	}

}
