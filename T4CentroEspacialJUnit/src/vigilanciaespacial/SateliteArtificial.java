package vigilanciaespacial;
import vigilanciaespacial.estrellas.Estrella;

public class SateliteArtificial {
	
	private static int contador = 0;
	private String identificador;
	private Estrella estrellaMonitorizada;
	private static final double CALCULO_CALOR = 2.1;
	private static final double HAY_TORMENTA = 1000;
	
	public SateliteArtificial (Estrella estrella) {
		contador++;
		this.identificador = "Sat" + contador;
		this.estrellaMonitorizada = estrella;
	}
	
	public String getIdentificador() {
		return identificador;
	}

	public Estrella getEstrella() {
		return estrellaMonitorizada;
	}

	public void setEstrella(Estrella estrella) {
		this.estrellaMonitorizada = estrella;
	}

	public double darTemperatura() {
		return estrellaMonitorizada.getIndiceColor() * CALCULO_CALOR;
	}
	
	public boolean hayAlertaTormentaMagnetica() {
		return estrellaMonitorizada.getCampoMagnetico()>=HAY_TORMENTA;
	}

	public boolean esIgual(SateliteArtificial p) {
		return estrellaMonitorizada.esIgual(p.estrellaMonitorizada);
	}
}
