
public class Presencial extends Alumno {

	private double matriculaCurso;
	private int noConvocatoria;
	private double plusPorConvocatoria;
	
	private static final int MESES_POR_ANHO = 12;
	
	public Presencial(String nombre, int edad, int curso, String nivelAcademico,
			double matriculaCurso, int noConvocatoria, double plusPorConvocatoria) {
		super(nombre, edad, curso, nivelAcademico);
		this.matriculaCurso = matriculaCurso;
		this.noConvocatoria = noConvocatoria;
		this.plusPorConvocatoria = plusPorConvocatoria;
	}

	@Override
	public double pagoMensual() {
		return (matriculaCurso + plusPorConvocatoria * noConvocatoria) / MESES_POR_ANHO;
	}

	@Override
	public String getAsignaturas() {
		return "todas las del curso " + getCurso();
	}

}
