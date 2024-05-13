/**
 * 
 */
package operations;

import editor.Cursor;
import editor.IEditor;
import exceptions.ErrorInOperation;
import exceptions.ErrorIncorrectCursorPosition;

/**
 * @author angel
 *
 */
public class DeleteOperation implements IOperation {

	/**
	 * 
	 */
	public DeleteOperation() {
		
	}

	@Override
	public IOperation exec(IEditor editor) throws ErrorInOperation {
		Cursor cursor = editor.getCursor();
		cursor.setColumn(cursor.getColumn() -1);
		String text = editor.getText(cursor);
		try {
			editor.deleteText();
			return  new WriteOperation(text);
		} catch (ErrorIncorrectCursorPosition e) {
			throw new ErrorInOperation("Deleting test");
		}	
	}

}
