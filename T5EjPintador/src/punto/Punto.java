package punto;


public class Punto {
	private float x;
	private float y;
	
	/**
	 * Constructor de un punto en el plano
	 * @param x coordenada x
	 * @param y coordenada y
	 */
	public Punto(float x, float y) {// constructor
		this.x = x;
		this.y = y;
	}// constructor
	
	/**
	 * Método que desplaza el punto los puntos indicados por despX y despY
	 * @param despX desplazamiento en x del punto
	 * @param despY desplazamiento en y del punto
	 */
	public void desplazar (float despX, float despY) {
		this.x += despX;
		this.y += despY;
	}
	
	/**
	 * Este método indica la distancia entre esta instancia de punto y la dada como parámtros
	 * @param p2 Punto del que se quiere obtener la distancia
	 * @return distancia entre la instancia y el punto p2
	 */
	public double distancia(Punto p2) {
		return Math.sqrt((this.x - p2.getX()) * (this.x - p2.getX())
				+ (this.y - p2.getY()) * (this.y - p2.getY()));
	}

	/**
	 * Este método indica la distancia al origen
	 * @return retorna la distancia al origen.
	 */
	public double distanciaOrigen() {
		return Math.sqrt(Math.pow(x, 2)+
				Math.pow(y, 2));
	}
	
	/**
	 * Indica si el punto es el centro del sistema de coordenadas
	 * @return Retorna cierto si la isntancia se encuetnra en el origen del sistema de coordenadas
	 */
	public boolean esOrigen() {
		return this.x == 0 && this.y == 0;
	}

	/**
	 * 
	 * @return proprociona la componente x del punto
	 */
	public float getX() {
		return this.x;
	}

	/**
	 * 
	 * @return proporciona la componente y del punto
	 */
	public float getY() {
		return this.y;
	}

	


}
