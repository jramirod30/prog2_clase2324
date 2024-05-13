/**
 * 
 */
package test;

import editor.Editor;
import exceptions.ErrorInOperation;
import exceptions.ErrorNoUndo;
import operations.*;

/**
 * @author angel
 *
 */
public class MainExam {

	/**
	 * 
	 */
	public MainExam() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IOperation [] operations = {new WriteOperation("hola"), new WriteOperation(" vamos a una nueva línea"),
				new NewLine(), new WriteOperation("en una nueva línea")};
		Editor editor = new Editor();
		try {
			editor.processOperations(operations);
			System.out.print(editor.getDoc());
			System.out.println("<Undo last write>");
			editor.undoOperation();
			System.out.print(editor.getDoc());
		} catch (ErrorInOperation | ErrorNoUndo e) {
			System.err.println("Ubs! Something was wrong");
			e.printStackTrace();
		}

	}

}
