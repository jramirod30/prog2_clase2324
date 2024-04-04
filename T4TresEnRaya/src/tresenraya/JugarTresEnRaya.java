package tresenraya;
import java.util.Scanner;

import tresenraya.partida.Estado;
import tresenraya.partida.PartidaTresEnRaya;

public class JugarTresEnRaya {

	private static PartidaTresEnRaya partida;

	private static int fila;
	private static int columna;

	private static Scanner teclado = new Scanner(System.in);

	private static void pedirMovimiento() {
		do {
			// pide por teclado fila y columna		
			System.out.print("Dame una fila:");
			fila = teclado.nextInt();
			System.out.print("Dame una columna:");
			columna = teclado.nextInt();
		} while (!partida.esMovimientoValido(fila, columna)); // comprueba que son válidos
	}

	public static void main(String[] args) {
		partida = new PartidaTresEnRaya();
		Estado estado;
		do {
			System.out.println(partida.toString());
			pedirMovimiento();
			partida.realizarMovimiento(fila, columna);
			
			estado = partida.getEstado();
		} while (estado != Estado.GANA_P1 && estado != Estado.GANA_P2 && estado != Estado.EMPATE);
		
		switch(estado) {
			case EMPATE:
				System.out.println("Habéis empatado");
				break;
			case GANA_P1:
				System.out.println("Ha ganado el jugador 1");
				break;
			default:
				System.out.println("Ha ganado el jugador 2");
		}

	}

}

