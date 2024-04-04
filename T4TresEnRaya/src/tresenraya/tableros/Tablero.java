package tresenraya.tableros;

public class Tablero {
	
	private char[][] tablero;
	public final static char CASILLA_VACIA = ' ';

	public Tablero() {
		tablero = new char[3][3];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				tablero[i][j] = CASILLA_VACIA;
			}
		}
	}
	
	// PRE: La casilla está vacía
	public void ponerFicha(int fila, int col, char ficha) {
		tablero[fila][col] = ficha;
	}
	
	// PRE: La fila y la columna están entre 0 y 2
	public char getCasilla(int fila, int col) {
		return tablero[fila][col];
	}	
	
	public String toString() {
		String salida = "";
		for(int i=0; i<tablero.length; i++) {
			salida += "|";
			for(int j=0; j<tablero[0].length; j++)
				salida += tablero[i][j] + "|";
			salida += "\n";
		}
		
		return salida;
	}
}
