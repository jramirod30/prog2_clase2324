/**
 * 
 */
package operations;

import editor.IEditor;
import exceptions.ErrorInOperation;
import exceptions.ErrorIncorrectCursorPosition;

/**
 * @author angel
 *
 */
public class DeleteLine implements IOperation {

	/**
	 * 
	 */
	public DeleteLine() {

	}

	@Override
	public IOperation exec(IEditor editor) throws ErrorInOperation {
		try {
			editor.deleteLine();
		} catch (ErrorIncorrectCursorPosition e) {
			throw new ErrorInOperation("deleting line");
		}
		return new NewLine();
	}

}
