
public class Libre extends Alumno {
	
	private String[] listaAsignaturas;
	private static float precioPorHora = 10;
	private int noHorasDiarias;
	private static final int PRECIOBASE = 30;

	public Libre(String nombre, int edad, int curso, String nivelAcademico, int noHorasDiarias) {
		super(nombre, edad, curso, nivelAcademico);
		this.noHorasDiarias = noHorasDiarias;
	}
	

	@Override
	public double pagoMensual() {
		return noHorasDiarias * precioPorHora * PRECIOBASE;
	}
	@Override
	public String getAsignaturas() {
		String asignaturas = "";
		for (int i = 0; i<listaAsignaturas.length; i++) {
			asignaturas += listaAsignaturas[i]+ " ";
		}
		return asignaturas;
	}
	
	public void pedirAsignaturas(String[] listaAsignaturas) {
		this.listaAsignaturas = listaAsignaturas;
	}

}
