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
public interface IOperation {
	
	/**
	 *This method run the operation and return the corresponding undo operation
	 * @param editor
	 * @return Return the undo operation
	 */
	public IOperation exec( IEditor editor) throws ErrorInOperation;

}
