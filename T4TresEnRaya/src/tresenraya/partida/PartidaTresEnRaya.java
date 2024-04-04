package tresenraya.partida;
import tresenraya.tableros.Tablero;

public class PartidaTresEnRaya {

	private int noMov;
	private Tablero tablero;
	
	private Estado estado; // juega_p1, juega_p2, gana_p1, gana_p2, empate
	
	private static final char FICHA_P1 = 'X';
	private static final char FICHA_P2 = 'O';
	
	public PartidaTresEnRaya() {
		tablero = new Tablero();		
		estado = Estado.JUEGA_P1;	
		noMov = 0;
	}
	
	public boolean esMovimientoValido(int fila, int columna) {
		return fila<3 && fila>=0 
				&& columna<3 && columna >= 0
				&& tablero.getCasilla(fila, columna) == Tablero.CASILLA_VACIA;
	}
	
	// PRE: movimiento (fila, columna) es válido
	// Elegimos y colocamos la ficha del jugador que tiene el turno en (fila, columna)
	// Actualizamos el estado de la partida: comprobamos si hay empate o ganador
	// En caso contrario, cambia de jugador
	public void realizarMovimiento(int fila, int columna) {
		// Comprobamos la PRE aunque no sea necesario - en un futuro lanzaremos un error (excepción)
		if(esMovimientoValido(fila,columna)) {
			if(estado == Estado.JUEGA_P1)
				tablero.ponerFicha(fila, columna, FICHA_P1);
			else tablero.ponerFicha(fila, columna, FICHA_P2);
			
			noMov++;
			if(hayGanador(fila, columna)) {
				estado = ((estado == Estado.JUEGA_P1) ? Estado.GANA_P1 : Estado.GANA_P2);
			}
			else if (hayEmpate()) {
				estado = Estado.EMPATE;
			}
			else {
				estado = ((estado == Estado.JUEGA_P1) ? Estado.JUEGA_P2 : Estado.JUEGA_P1);
			}
		}
						
	}
	
	private boolean hayGanador(int fila, int columna) {		
		char ficha = this.tablero.getCasilla(fila, columna);
		// Empezamos por la fila
		int j;
		for(j=0; j < 3 && ficha == tablero.getCasilla(fila, j); j++);
		if (j == 3) return true;
		// Comprobamos la columna
		int i;
		for(i=0; i < 3 && ficha == tablero.getCasilla(i, columna); i++);
		if (i == 3) return true;
		// Comprobamos las diagonales
		if(fila == columna) {
			//Comprobar la diagonal principal
			for(i=0; i < 3 && ficha == tablero.getCasilla(i, i); i++);
			if (i == 3) return true;
		}
		if(fila + columna == 2) {
			//Comprobar la diagonal opuesta
			for(i=0; i < 3 && ficha == tablero.getCasilla(i, 2 - i); i++);
			if (i == 3) return true;
		}
		return false;
	}

	private boolean hayEmpate() {	
		return (noMov == 9);
	}

	public Estado getEstado() {
		return estado;
	}
	
	public String toString() {
		return estado + "\n" + tablero.toString();		
	}

}
