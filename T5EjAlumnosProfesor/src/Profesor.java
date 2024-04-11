
public class Profesor extends Persona {
	
	private String asignatura;
	
	public Profesor(String nombre, int edad, String asignatura) {
		super(nombre, edad);
		this.asignatura = asignatura;
	}

	@Override
	public String toString() {
		return super.toString() + " " + asignatura;
	}
}
