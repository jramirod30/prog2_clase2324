package app;

import vajilla.Vaso;
import java.util.Scanner;

public class PruebaVaso {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Scanner lector = new Scanner(System.in);
		Vaso vaso = new Vaso(10.0);
		vaso.llenar(5.0);
		System.out.println(vaso);
		vaso.llenar(5.0);
		System.out.println(vaso);
		vaso.llenar(5.0);
		System.out.println(vaso);
		vaso.prepararDesayuno(10, 2, 1);
		//lector.close();

	}

}
