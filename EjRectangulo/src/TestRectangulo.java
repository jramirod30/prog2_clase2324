
public class TestRectangulo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangulo rectangulo1, rectangulo2;
		
		rectangulo1 = new Rectangulo(3, 5);
		
		System.out.println(rectangulo1.toString());
		
		System.out.println(rectangulo1.area());
		
		rectangulo2 = new Rectangulo(2, 1);
		
		System.out.println(rectangulo2.toString());
		
		System.out.println(rectangulo2.area());
		
		System.out.println("antes lado1 r2:" + rectangulo2.getLado1());
		
		rectangulo2.setLado1(10);
		
		System.out.println("después lado1 r2:" + rectangulo2.getLado1());
		System.out.println("después lado1 r1:" + rectangulo1.getLado1());



	}

}
