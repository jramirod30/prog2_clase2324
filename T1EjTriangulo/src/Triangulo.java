
public class Triangulo {
	private double base, altura;
	
	public Triangulo(double base1, double altura1){
		base = base1;
		altura = altura1;
	}
	
	public double getBase() {
		return base;
	}
	
	public double getAltura() {
		return altura;
	}
	
	public void setBase(double base1){
		base=base1;
	}
	
	public void setAltura(double altura1) {
		altura=altura1;
	}
	
	public double area() {
		return base*altura/2;
	}
	
	public String toString() {
		return "["+base+" "+altura+"]";
	}
	
	public boolean esIgual(Triangulo triangulo) {
		return base == triangulo.base && altura == triangulo.altura;
	}
	
	public Triangulo(Triangulo tr){
		base=tr.base;
		altura=tr.altura;
	}
}
