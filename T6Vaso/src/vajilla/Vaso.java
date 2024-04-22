package vajilla;

import vajilla.exception.ErrorPrepararDesayuno;
import vajilla.exception.ErrorVasoLLeno;

public class Vaso {
	
	private double capacidadMax;
	private double contenido = 0.0;
	
	public Vaso (double capacidadMax){
		this.capacidadMax = capacidadMax;
	}
	
	public void llenar (double cantidad) throws ErrorVasoLLeno{
		if (contenido+cantidad > capacidadMax){
			throw new ErrorVasoLLeno("Hay sitio para " + 
		              (this.capacidadMax - this.contenido+ " y me han dado: "
			           + cantidad));
		}
		contenido+= cantidad;
		
	}
	
	
	public void prepararDesayuno (double leche, double azucar,
			double colacao) throws ErrorPrepararDesayuno{
		try {
			llenar(leche);
			llenar(azucar);
			llenar(colacao);
		} catch (ErrorVasoLLeno e) {
			this.contenido=0;
			throw new ErrorPrepararDesayuno("No se pudo preparar el desayuno");
			
		}
		
	}
	
	public String toString() {
		return "Vaso [contenido=" + contenido + "]\n";
	}
	
	
	//Gets
	public double getCapacidadMax() {
		return this.capacidadMax;
	}
	

}
