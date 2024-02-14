
public class TestTriangulo {

	public static void main(String[] args) {
		Triangulo triangulo1, triangulo2;
		
		triangulo1= new Triangulo(10,5);
		triangulo2= new Triangulo(3,4);
		
		System.out.println(triangulo1.toString());
		
		System.out.println(triangulo2.area());
		triangulo1.setBase(7);
		System.out.println(triangulo1.getBase());
		System.out.println(triangulo2.getAltura());
		
		Triangulo triangulo3 = new Triangulo(3, 4); // igual que triangulo2
		
		System.out.println(triangulo3.esIgual(triangulo2));
		System.out.println(triangulo3 == triangulo2);

		Triangulo triangulo4 = new Triangulo(triangulo3);
		
		System.out.print(triangulo4);
		
		

	}

}
