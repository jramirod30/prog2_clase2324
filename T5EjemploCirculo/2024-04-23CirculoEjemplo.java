/**
 * 
 */
package figuras;

import pintor.FiguraGUI;
import pintor.Pintador;
import punto.Punto;

import java.awt.Color;



/**
 * Define la clase que pinta un círculo en pantalla
 * @author agonzalez
 */
 //Define la clase Circulo que implementa la interfaz FiguraGUI
 //El consturctor recibe un punto como centro y un entero que es el radio
 /* el cÃ¡lculo de los puntos de una circunferencia se peude encontrar en: https://gamedevtraum.com/es/matematica/geometria/circunferencia/
		/*x=r * cos a
		  y= r * sin a
		donde a es el angulo*/
 
 public class Circulo implements FiguraGUI{
	 private Punto[] puntos=new Punto[1000];
	 private Color color;
	 
	 public Circulo(Punto centro, int radio) {
		 for(int i=0; i<100; i++) {
			 puntos[i]=new Punto((float)(centro.getX()+radio*Math.cos(Math.PI*2*i/100)), 
					 (float)(centro.getY()+radio*Math.sin(Math.PI*2*i/100)));
		 }
		 color=Color.black;
	 }
	 
	 public Circulo(Punto centro, int radio, Color color) {
		 
		 for(int i=0; i<100; i++) {
			 puntos[i]=new Punto((float)(centro.getX()+radio*Math.cos(Math.PI*2*i/100)), 
					 (float)(centro.getY()+radio*Math.sin(Math.PI*2*i/100)));
		 }
		 this.color=color;
	 }

	 
	 @Override
	 public void pintate(Pintador pintor) {
		 for(int i=0; i<puntos.length-1; i++) {
			 pintor.pintarSegmento((int)puntos[i].getX(), (int)puntos[i].getY(), (int)puntos[i+1].getX(), 
					 (int)puntos[i+1].getY(), color);
		 }
		 pintor.pintarSegmento(((int)puntos[0].getX()), ((int)puntos[0].getY()), 
				 ((int)puntos[puntos.length-1].getX()), ((int)puntos[puntos.length-1].getY()), color);
	 }

	@Override
	public void desplazar(int despX, int despY) {
		for(int i=0; i<puntos.length; i++) {
			puntos[i].desplazar(despX, despY);
		}
	}
	 
 }
 