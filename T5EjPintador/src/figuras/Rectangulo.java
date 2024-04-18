/**
 * 
 */
package figuras;

import pintor.FiguraGUI;
import pintor.Pintador;
import punto.Punto;
import anotacion.Programacion2;


@Programacion2 (
		nombreAutor1 = "autor1",
		apellidoAutor1 = "apellidos autor1",
		emailUPMAutor1 = "email upm autor1"
		)

/**
 * Esta clase crea un rectángulo cuya base es paralela al eje X
 * @author agonzalez
 */
public class Rectangulo implements FiguraGUI{

	//Define el punto de la esquina superior izquierda
	private Punto esquinaSuperioIzquierda;
	//Define el punto de la esquina inferior derecha
	private Punto esquinaInferiroDerecha;
	/**
	 * Construye un rectánculo a partir de los dos puntos dados
	 * Se queda con una referencia de los puntos pasados.
	 * No verifica que los cuatro puntos formen un cuadrado
	 * @param esquinaSuperioIzquierda esquina superior izquierda del rectángulo
	 * @param esquinaInferiroDerecha esquina superior derecha del rectángulo
	 */
	public Rectangulo (Punto esquinaSuperioIzquierda, Punto esquinaInferiroDerecha)
	{
		this.esquinaSuperioIzquierda=esquinaSuperioIzquierda;
		this.esquinaInferiroDerecha=esquinaInferiroDerecha;
	}
	
	/**
	 * Implementación específica del método pintate de la clase FiguraGUI
	 */
	@Override
	public void pintate(Pintador pintor) {
		pintor.pintarSegmento((int)this.esquinaSuperioIzquierda.getX(),(int) this.esquinaSuperioIzquierda.getY(),
				(int)this.esquinaInferiroDerecha.getX(), (int)this.esquinaSuperioIzquierda.getY());
		pintor.pintarSegmento((int)this.esquinaInferiroDerecha.getX(),(int) this.esquinaSuperioIzquierda.getY(),
				(int)this.esquinaInferiroDerecha.getX(), (int)this.esquinaInferiroDerecha.getY());
		pintor.pintarSegmento((int)this.esquinaInferiroDerecha.getX(), (int)this.esquinaInferiroDerecha.getY(),
				(int)this.esquinaSuperioIzquierda.getX(), (int)this.esquinaInferiroDerecha.getY());
		pintor.pintarSegmento((int)this.esquinaSuperioIzquierda.getX(), (int)this.esquinaInferiroDerecha.getY(),
				(int)this.esquinaSuperioIzquierda.getX(), (int)this.esquinaSuperioIzquierda.getY());
		
	}

	@Override
	public void desplazar(int despX, int despY) {
		// TODO Auto-generated method stub
		
	}
}