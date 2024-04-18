package pintor;
/**
 * 
 */

/**
 * Interfaz que define los servicios que se deben
 * proporcionar para poder pintar.
 * En este caso se ofrecen los servicios de pintado de rectas
 * @author agonzalez
 *
 */
public interface Pintador {

	/**
	 * Pinta una recta entre el punto (x0,y0) y (xFin,yFin)
	 * @param x0 x del punto en el que se empieza a pintar el segmento
	 * @param y0 y del punto en el que se empieza a pintar el segmento
	 * @param xFin x del punto donde se termina de pintar el segmento
	 * @param yFin y del punto donde se termina de pintar el segmento
	 */
	public void pintarSegmento (int x0, int y0, int xFin, int yFin);
	/**
	 * Pinta una recta entre el punto (x0,y0) y (xFin,yFin) con un color dado
	 * @param x0 x del punto en el que se empieza a pintar el segmento
	 * @param y0 y del punto en el que se empieza a pintar el segmento
	 * @param xFin x del punto donde se termina de pintar el segmento
	 * @param yFin y del punto donde se termina de pintar el segmento
	 * @param color Color que se usará para pintar el segmento
	 */
	public void pintarSegmento (int x0, int y0, int xFin, int yFin, java.awt.Color color);
}
