package vigilanciaespacial.estrellas;

public class Estrella {
	private String identificador;
	private double campoMagnetico;
	private int indiceColor;
	
	private static final double VARIACION_CAMPO = 5.5;
	private static final int VARIACION_COLOR = 1;
	
	public Estrella(String identificador, double campoMagnetico, int indiceColor) {
		this.identificador = identificador;
		this.campoMagnetico = campoMagnetico;
		this.indiceColor = indiceColor;
	}

	public String getIdentificador() {
		return identificador;
	}

	public double getCampoMagnetico() {
		return campoMagnetico;
	}

	public int getIndiceColor() {
		return indiceColor;
	}
	
	public void desplazar() {
		this.campoMagnetico -= VARIACION_CAMPO;
		this.indiceColor -= VARIACION_COLOR;
	}
	
	public boolean esIgual(Estrella estrella) {
		return this.identificador.equals(estrella.getIdentificador());
//				&& this.campoMagnetico == estrella.getCampoMagnetico()
//				&& this.indiceColor == estrella.getIndiceColor();
	}
	
	
}
