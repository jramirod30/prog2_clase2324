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
public class NewLine implements IOperation {

	/**
	 * 
	 */
	public NewLine() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IOperation exec(IEditor editor) throws ErrorInOperation {
		editor.newLine();
		return new DeleteLine();
	}

}
