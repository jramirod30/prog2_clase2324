
public class Segmento {
	private Punto a, b;
	
	public Segmento(Punto a, Punto b) {
		this.a = a;
		this.b = b;		
	}
	
	public double longitud() {
		return Math.sqrt(Math.pow((a.getX() - b.getX()), 2) + 
				Math.pow((a.getY() - b.getY()), 2));
	}
	
	public String toString() {
		return "[" + a + "-" + b + "]";
	}
	
	public void desplazar(double dx, double dy) {
		a.setX(a.getX()+dx);
		a.setY(a.getY()+dy);
		b.setX(b.getX()+dx);
		b.setY(b.getY()+dy);
	}
	
	public Punto puntoMedio() {
		return new Punto ((a.getX()+b.getX())/2,(a.getY()+b.getY())/2);	
	}
	
	public boolean esIgual(Segmento obj) {
		return a.esIgual(obj.a) && b.esIgual(obj.b) || 
				a.esIgual(obj.b) && b.esIgual(obj.a);
	}

	public Segmento(Segmento s) {
		a = new Punto(s.a);
		b = new Punto(s.b);
	}
	
}
