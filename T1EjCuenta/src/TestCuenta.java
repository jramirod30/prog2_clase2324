
public class TestCuenta {

	public static void main(String[] args) {
		
		System.out.println(Cuenta.getGastosApertura());
		
		Persona persona = new Persona("Pepe", "4849384Z", 45);
		
		Cuenta cuenta = new Cuenta(100, persona);
		
		System.out.println(cuenta);	
		
		Cuenta.setGastosApertura(20);
		
		Cuenta cuenta1 = new Cuenta(100, persona);
		
		System.out.println(cuenta1);	

		System.out.println(cuenta);	

	}

}
