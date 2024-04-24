/**
 * 
 */
package app;

import banco.CuentaCorriente;
import banco.exception.CantidadIncorrecta;
import banco.exception.SaldoInicialInsuficiente;
import banco.exception.SaldoInsuficiente;

/**
 * @author angel
 *
 */
public class GestionCuenta {

	/**
	 * @param args
	 */
	public static void main(String[] args) {//main
		//double [] saldosInciales = {10, 15, -5, 19, 0, 150, 200};
		try {
			CuentaCorriente.setGastosApertura(20);
		} catch (CantidadIncorrecta e1) {
			// Esta exccepción no debería pasar ya que se cumple con la PRE
			e1.printStackTrace();
		}
		CuentaCorriente corriente = null;
		//TODOO se debe controlar las excepciones para que se llegue a abrir una cuenta
		double [] saldosInciales ={19, -5, 20};
		
		//TODO se deben controlar las excepciones y procesar todos los ingresos
		// se debe informar de los errores. 
		double [] ingresar ={151, 90, -30, 90, 80, 180, 30, 30};
		
		//TODO se debe probar a sacar hasta poder efecutar una retirada de fondos.
		//Se debe informar de los errores. 
		double [] retirar = {131, 200, -10, 70, 90, 100};
		
		
		
		if (corriente.getSaldo() == 60) {
			System.out.println("OK");
		}
		else {
			System.out.println("Error");
		}
		
	}//main

}
