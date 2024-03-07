import java.util.Scanner;

import stacks.StackInteger;
import stacks.exceptions.EmptyStackException;

public class InvertirEntradaEnteros{

	public static void main(String[] args) throws EmptyStackException {
		StackInteger pila = new StackInteger();
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce dato: ");
		int input = scan.nextInt();
		while(input != 0) {
			pila.push(input);
			System.out.println("Introduce dato: ");
			input = scan.nextInt();
		}
		scan.close();
		while(!pila.isEmpty()) {
			System.out.println(pila.pop());
		}

	}

}
