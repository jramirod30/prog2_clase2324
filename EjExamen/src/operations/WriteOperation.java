/**
 * 
 */
package operations;

import editor.IEditor;
import exceptions.ErrorInOperation;

/**
 * @author angel
 *
 */
public class WriteOperation implements IOperation {
	private String text;
	/**
	 * 
	 */
	public WriteOperation(String text) {
		this.text = text;
	}

	@Override
	public IOperation exec(IEditor editor) throws ErrorInOperation {
		editor.insertText(text);
		return new DeleteOperation();
	}

}
