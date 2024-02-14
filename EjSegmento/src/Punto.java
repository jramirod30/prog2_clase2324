
public class Punto {
	private double x, y;
	
	public Punto(double xo, double yo) { 
		x = xo;
		y = yo; 
	}
	
	public Punto(Punto p) {
		x = p.x;
		y = p.y;
	}

	public String toString() {
		return "(" + x + "," + y + ")" ; 
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setX(double a) {
		x=a;
	}
	public void setY(double b) {
		y=b;
	}
	
	public boolean esIgual(Punto p) {
		return this.x == p.x && this.y == p.y;
	}
}
