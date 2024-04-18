/**
 * 
 */
package pintor;


/**
 * Clase abstracta que representa los servicios
 * que debería dar la parte Gráfica de una figura.
 * Sería más adecuado utilizar una interface en lugar de una clase abstracta
 * pero dado que en el curos 2013-2014 se retiran las interfaces del temario se opta por esta solución
 * @author agonzalez
 *
 */
public interface FiguraGUI {
	
	/**
	 * Desplaza un elemento en x e y. Lo deplaza despX puntos en X y despY puntos en Y
	 * @param despX puntos en x que debe ser desplazada la figura
	 * @param despY puntos en y que debe ser desplazada la figura
	 */
	public abstract void desplazar (int despX, int despY);
	
	/**
	 * Método que pinta las rectas necesarias para
	 * dibuajar la figura geométrica. Necesita a alguien
	 * que sepa pintar rectas
	 * @param pintor instancia de la clase que sabe pintar rectas
	 */
	public abstract void pintate (Pintador pintor);
	

}
