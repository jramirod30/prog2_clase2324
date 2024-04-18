package pintor;
/**
 * 
 */

/**
 * Define la interfaz que debe implementar todo aquel
 * que quiera pintar algo cuando se requiera actualizar
 * el contenido de une ventana
 * @author agonzalez
 *
 */
public interface GenerarPintado {
	/**
	 * Método al que se llama para que pinte lo que corresponda en el lienzo
	 * Recibe un pintador al que se le darán instrucciones para que pinte
	 * @param pintor instancia que implementa la interfaz Pintador y que se usará para pintar
	 */
	public void update (Pintador pintor);

}
