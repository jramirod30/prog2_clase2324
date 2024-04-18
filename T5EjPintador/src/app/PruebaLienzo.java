package app;
import javax.swing.SwingUtilities;
//import figuras.Circulo;
//import figuras.Poligono;
import figuras.Rectangulo;
import pintor.FiguraGUI;
import pintor.GenerarPintado;
import pintor.Lienzo;
import pintor.Pintador;
import punto.Punto;

import java.awt.Color;
import java.util.Scanner;

/**
 * Programa que usa las figuras creadas para pintarlas en pantalla
 * Debe implementar la interfaz GenerarPintado
 * @author agonzalez
 *
 */
public class PruebaLienzo implements GenerarPintado{
	//Atributo de clase que contiene todas las figuras que se han de pintar
	private static FiguraGUI[] figuras = new FiguraGUI[6];
	private static PruebaLienzo aplicacion; //Contiene la instancia de la palicacion
	private static Lienzo lienzo; 
	/**
	 * Punto de entrada que crea las figuras, y las mete en el array figuras
	 * 
	 */
	public static void main(String[] args) {
		Punto [] puntos ={new Punto (215.0f, 10.0f), new Punto (350.0f, 10.0f),new Punto (350.5f,180f),new Punto (300.0f,195f)};
		Punto [] puntos2={new Punto (155f,25f), new Punto (200.65f, 200.3f), new Punto (125f,70f)};
		Punto [] puntos3={new Punto (15.0f, 190.0f),new Punto (150.0f, 190.0f),new Punto (150.5f,250f),new Punto (15.0f,250f)};
		figuras[0]= new Rectangulo (new Punto (15.0f, 10.0f), new Punto (150.5f,180f));
		//TODO: Descomentar según se vayan implementando las clases
		//figuras[1] = new Poligono(puntos);
		//figuras [2]= new Poligono(puntos2, Color.RED);
		//figuras[3]=new Circulo (new Punto (60.0f, 60.0f),40);
		//figuras[4]= new Poligono(puntos3, new Color(155,0,150));
		Scanner lector = new Scanner (System.in);
		//Se pide el color para la figura 6
		/*System.out.print("Eintroduce el valor para el rojo (número entero entre 0 y 255): ");
		int red = lector.nextInt();
		System.out.print("Eintroduce el valor para el verde (número entero entre 0 y 255): ");
		int green = lector.nextInt();
		System.out.print("Eintroduce el valor para el azul (número entero entre 0 y 255): ");
		int blue = lector.nextInt();
		figuras[5]=new Circulo (new Punto (155.0f, 65.0f),50, new Color(red,green,blue));*/
		
		aplicacion= new PruebaLienzo();
		//figuras[1] = new Triangulo (new Punto (155f,25f), new Punto (200.65f, 200.3f), new Punto (125f,70f));
		//figuras[2] = new Cuadrilatero (new Punto (115.0f, 10.0f), new Punto (250.0f, 10.0f),new Punto (250.5f,180f),new Punto (200.0f,195f));
		//Se lanza la aplicación gráfica Swing
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				lienzo = new Lienzo ("Ejercicio del pintador",aplicacion);
				lienzo.setLocationRelativeTo(null);
				lienzo.setVisible(true);
			}
		});
		lector = new Scanner (System.in);
		System.out.print("Puntos a desplazar en x:");
		int despX=lector.nextInt();
		System.out.print("Puntos a desplazar en y:");
		int despY=lector.nextInt();
		//Desplazar la figura
		//Desplazar la figura1 x e y puntos 
		figuras[0].desplazar(despX,despY);
		//TODO: Descomentar cuando se temga el poligono
		//Desplazar la figura 2 en sentido inverso al dado por el usuario
		//figuras[2].desplazar(-1*despX, -1*despY);
		//Desplazar la figura
		//actualiar pantalla
		aplicacion.update(lienzo); //No se borra la figura original hay que hacer un clean del área
		//lienzo.repaint(); //Se borra el fondo
		System.out.println ("Main termina, pero la aplicación no\n por que la interfaz se ejecuta en un hilo (thread) aparte");
		lector.close();
	}

	@Override
	public void update(Pintador pintor) {//update
		// TODO Auto-generated method stub
		//pintor.pintarRecta(0, 0, 200, 200);
		for (FiguraGUI figura:figuras )
			if (figura !=null){
				figura.pintate(pintor);
			}

	}//update

}
