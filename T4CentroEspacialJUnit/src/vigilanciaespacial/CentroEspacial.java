package vigilanciaespacial;

public class CentroEspacial {
	
	private String identificador;
	private SateliteArtificial[] satelitesSupervisados;
	
	public CentroEspacial(String identificador, SateliteArtificial[] satelitesSupervisados) {
		this.identificador = identificador;
		this.satelitesSupervisados = satelitesSupervisados;
	}
	
	public String getIdentificador() {
		return this.identificador;
	}
	
	public String informacionEstrellas() {
		String resultado="";
		for(int i=0;i<satelitesSupervisados.length;i++) {
			if(!satelitesSupervisados[i].hayAlertaTormentaMagnetica()) 
				resultado += (satelitesSupervisados[i].getEstrella().getIdentificador()+" ("+satelitesSupervisados[i].darTemperatura()+")"+"\n");
			else
				resultado += (satelitesSupervisados[i].getEstrella().getIdentificador()+" ("+satelitesSupervisados[i].darTemperatura()+") "+"ALERTA!\n");
		}
		return resultado;
	}
	
	public boolean comprobarSatelites() {
		boolean estaVacio = (satelitesSupervisados.length == 0);
		boolean hayDuplicados = false;
		for(int i = 0; i < satelitesSupervisados.length && !hayDuplicados; i++) {
			for(int j = i + 1; j < satelitesSupervisados.length && !hayDuplicados; j++) {
				hayDuplicados = satelitesSupervisados[i].esIgual(satelitesSupervisados[j]);
			}
		}
		return !estaVacio && !hayDuplicados;
//		return !(estaVacio || hayDuplicados);
		
	}
	
	
}


