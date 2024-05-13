/**
 * 
 */
package editor;

import exceptions.ErrorIncorrectCursorPosition;

/**
 * @author angel
 *
 */
public interface IEditor {
	
	public Cursor getCursor();
	
	/**
	 *  PRE: True
	 * Insert text in cursor position and move cursor one position
	 * @param text text to insert
	 */
	public void insertText( String text);
	
	/**
	 * PRE: cursor.column &gt; 0 otherwise 
	 * raise ErrorIncorrectCursorPosition
	 * Deletes text at the current cursor position that previously
	 * was put with an insertText operation
	 */
	public void deleteText() throws ErrorIncorrectCursorPosition;
	
	/**
	 * PRE: cursor.line &gt; 0 otherwise
	 * raise ErrorIncorrectCursorPosition
	 * Delete a line from document
	 */
	public void deleteLine() throws ErrorIncorrectCursorPosition;
	
	/**
	 * PRE: True
	 * Insert a new empty line
	 */
	public void newLine();
	
	/**
	 * PRE: True
	 * Return a string with all document lines
	 * @return
	 */
	public String getDoc();
	
	/**
	 * Retorna el fragmento de texto que se encuentra 
	 * en la posición del cursor
	 * @param cursor
	 * @return
	 */
	public String getText(Cursor cursor);
}
