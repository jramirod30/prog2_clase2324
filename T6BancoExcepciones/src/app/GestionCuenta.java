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
		double [] saldosIniciales ={19, -5, 20, 25};
		for (int i = 0; corriente== null &&
				i < saldosIniciales.length; i++) {
			try {
				corriente = new CuentaCorriente("juan", saldosIniciales[i]);
			} catch (SaldoInicialInsuficiente e) {
				System.err.println(e.getMessage());
			}
		}
		System.out.println("El saldo inicial en la cuenta es: "
		+ corriente.getSaldo());
		//TODO se deben controlar las excepciones y procesar todos los ingresos
		// se debe informar de los errores. 
		double [] ingresar ={151, 90, -30, 90, 80, 180, 30, 30};
		for (int i = 0;i<ingresar.length;i++) {
			try {
				corriente.ingresarDinero(ingresar[i]);
			}
			catch(CantidadIncorrecta e) {
				System.err.println (e.getMessage());
			}
		}
		System.out.println("El saldo inicial en la cuenta es: "
				+ corriente.getSaldo());
		//TODO se debe probar a sacar hasta poder efecutar una retirada de fondos.
		//Se debe informar de los errores. 
		double [] retirar = {131, 200, -10, 70,500, 90, 100};
		for(int i = 0; i<retirar.length;i++) {
			try {
				corriente.sacarDinero(retirar[i]);
				System.out.println("Has retirado con exito:" + retirar[i]);
			} catch (CantidadIncorrecta e) {
				System.err.println(e.getMessage());
			} catch (SaldoInsuficiente e) {
				System.err.println(e.getMessage());
			}
		}
		
		
		if (corriente.getSaldo() == 60) {
			System.out.println("OK");
		}
		else {
			System.out.println("Error");
		}
		
	}//main

}
