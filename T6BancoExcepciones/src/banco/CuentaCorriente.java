/**
 * 
 */
package banco;

import banco.exception.CantidadIncorrecta;
import banco.exception.SaldoInicialInsuficiente;
import banco.exception.SaldoInsuficiente;

/**
 * @author angel
 *
 */
public class CuentaCorriente {
	private String cliente;
	private double saldo;
	private static double gastosApertura = 10;
	
	/**
	 * Contruye una cuanta bancaria
	 * PRE: saldoInical >= gastosApertura
	 * @throws SaldoInicialInsuficiente 
	 */
	
	public CuentaCorriente(String cliente, double saldoInicial)
			throws SaldoInicialInsuficiente{
		if(saldoInicial<CuentaCorriente.gastosApertura) {
			throw new SaldoInicialInsuficiente("Error, saldo inicial insuficiente");
		}
		saldo = saldoInicial-CuentaCorriente.gastosApertura;
		this.cliente = cliente;
	}
	
	/**
	 * Retira dinero de la cuenta
	 * PRE: cantidad > 0 y cantidad < = saldo
	 * @param cantidad
	 * @throws CantidadIncorrecta 
	 * @throws SaldoInsuficiente 
	 */
	public void sacarDinero (double cantidad) 
			throws CantidadIncorrecta, SaldoInsuficiente{
		if (cantidad <= 0)
			throw new CantidadIncorrecta ("La cantidad introducida debe ser mayor que cero"
					+ " pero se proporcionó: " + cantidad);
		if (cantidad > saldo)
			throw new SaldoInsuficiente ("El saldo es insuficiente, dispone de: " + saldo +
					" solicita: " + cantidad);
		saldo -= cantidad;
		
	}
	
	/**
	 * Ingresa dinero en la cuenta
	 * PRE: cantidad > 0
	 * @param cantidad
	 * @throws CantidadIncorrecta 
	 */
	public void ingresarDinero (double cantidad) throws CantidadIncorrecta {
		if(cantidad<=0)
			throw new CantidadIncorrecta ("La cantidad " + cantidad +
					" es incorrecta, debe ser mayor que cero.");
		saldo+= cantidad;
		
		
	}
	
	/**
	 * Establece los gastos de apertura de la cuenta
	 * PRE: gastos  > = 0
	 * @param gastos
	 * @throws CantidadIncorrecta 
	 */
	public static void setGastosApertura (double gastos) throws CantidadIncorrecta{
		if (gastos < 0)
			throw new CantidadIncorrecta ("La cantidad " + gastos +
					" es incorrecta, debe ser mayor o igual que cero.");
		
		CuentaCorriente.gastosApertura = gastos;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public String getCliente() {
		return cliente;
	}

	public static double getGastosApertura() {
		return gastosApertura;
	}
}
