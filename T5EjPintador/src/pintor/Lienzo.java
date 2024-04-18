package pintor;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 * 
 */

/**
 * Clase que implementa la interfaz Pintador para el entorno
 * Java/SWING.
 * Se usa un JFrame para crear la ventana de la aplicación 
 * @author agonzalez
 *
 */
public class Lienzo extends JFrame implements Pintador {

	//Se requiere para serializar y desserializar un objeto
	//no es objetp de esta asignatura hablar de esto.
	//Sólo se pone para eliminar un warning
	private static final long serialVersionUID = 1L;
	//Panel sobre el que se va a pintar
	private JPanel jContentPane = null;
	//Con tiene la referencia a la aplicación con capacidad
	//para dibujar usando un pintador
	private GenerarPintado dibuja;


	/**
	 * Constructor del lienzo. Recibe como parámetros 
	 * una instancia de un generador de dibujos
	 * @param nombreApp nombre que aparecerá asociado a la ventana
	 * @param dibuja instancia de una clase que implmente la interfaz GenerarPintado. Se usará pare actualizar el contenido de la ventana
	 */
	public Lienzo(String nombreApp, GenerarPintado dibuja){
		super(nombreApp);
		this.dibuja=dibuja;
		// TODO Auto-generated constructor stub
		initialize();
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Fuerza la salida de la aplicación
	}



	/**
	 * Método que inciliza la ventana. Especifica el tamaño
	 * y asigna a la ventana el panel en el que se va a pintar
	 * 
	 */
	private void initialize() {
		this.setSize(513, 307);
		this.setContentPane(getJContentPane());
	}

	/**
	 * Método auxiliar que retorna una referencia al panel que será necesario para pintar.
	 * Si no existe lo crea.
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
		}
		return jContentPane;
	}

	/**
	 * Método que se llama cada vez que se actualiza el contenido
	 * de la ventana.
	 * Este método usará el servicio del Generador de pintado
	 * para que se pinte lo que corresponda.
	 */
	@Override
	public void paint(Graphics g){
		g.clearRect(0, 0, getJContentPane().getWidth(), getJContentPane().getHeight());
		dibuja.update(this);
	}


	/**
	 * Implementación del Método pintarRecta de la interfaz Pintador
	 * @see Pintador#pintarSegmento(int, int, int, int)
	 */
	@Override
	public void pintarSegmento(int x0, int y0, int xFin, int yFin) {//pintarRecta
		Graphics grafico=jContentPane.getGraphics();
		grafico.drawLine(x0, y0, xFin,yFin);	
	}//pintarRecta


	/**
	 * Implementación del Método pintarRecta de la interfaz Pintador
	 * @see Pintador#pintarSegmento(int, int, int, int, Color)
	 */
	@Override
	public void pintarSegmento(int x0, int y0, int xFin, int yFin, Color color) {//pintarRecta
		Graphics grafico=jContentPane.getGraphics();
		java.awt.Color colorActual= grafico.getColor();
		grafico.setColor(color);
		grafico.drawLine(x0, y0, xFin,yFin);
		grafico.setColor(colorActual);		
	}//pintarRecta
}  

