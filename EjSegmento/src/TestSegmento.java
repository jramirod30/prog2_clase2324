
public class TestSegmento {

	public static void main(String[] args) {
		Punto p1 = new Punto(2, 3);
		Punto p2 = new Punto(5, 6);
		Segmento segmento1 = new Segmento(p1, p2);
		
		System.out.println(segmento1);
		
		segmento1.desplazar(1, 2);
		
		System.out.println(segmento1);
		
		System.out.println(segmento1.puntoMedio());

		Segmento segmento2 = new Segmento(segmento1);
		
		
	}

}
