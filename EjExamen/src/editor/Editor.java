/**
 * 
 */
package editor;

import exceptions.ErrorInOperation;
import exceptions.ErrorIncorrectCursorPosition;
import exceptions.ErrorNoUndo;
import list.ArrayList;
import list.IList;
import operations.IOperation;



public class Editor implements IEditor {

	private IList<IList<String>> doc;
	private Cursor cursor;
	//TODO add necessary attributes


	public Editor() {
		this.doc = new ArrayList<IList<String>>();
		this.doc.add(0,new ArrayList<>()); //Line 0
		this.cursor = new Cursor();
		//TODO: initialize added attributtes  
		
	}

	@Override
	public Cursor getCursor() {
		return new Cursor(this.cursor);
	}

	@Override
	public void insertText(String text) {
		this.doc.get(this.cursor.getLine()).add(this.cursor.getColumn(), text);
		this.cursor.setColumn(this.cursor.getColumn() + 1);
	}

	@Override
	/**
	 * PRE: cursor.column > 0 otherwise 
	 * raise ErrorIncorrectCursorPosition
	 * Deletes text at the current cursor position that previously
	 * was put with an insertText operation
	 */
	public void deleteText()                     {
		//TODO completes preconditions verifications
		
		this.cursor.setColumn(this.cursor.getColumn() - 1);
		this.doc.get(this.cursor.getLine()).removeElementAt(this.cursor.getColumn());
	}

	/**
	 * PRE: cursor.line > 0 otherwise
	 * raise ErrorIncorrectCursorPosition
	 * Delete a line from document
	 */
	@Override
	public void deleteLine() throws ErrorIncorrectCursorPosition {
		if (this.cursor.getLine() <= 0) {
			throw new ErrorIncorrectCursorPosition("Wrong cursor position for deleting");
		}
		this.doc.removeElementAt(this.cursor.getLine());
		this.cursor.setLine(this.cursor.getLine() - 1);
		if (this.cursor.getLine() > 0 && this.doc.get(this.cursor.getLine() - 1).size() > 0) {
			this.cursor.setColumn(this.doc.get(this.cursor.getLine() - 1).size() - 1);
		}
		else {
			this.cursor.setColumn(0);
		}
	}

	@Override
	public void newLine() {
		this.cursor.setLine(this.cursor.getLine() + 1);
		this.doc.add(this.cursor.getLine(), new ArrayList<String>());
		this.cursor.setColumn(0);
	}


	@Override
	public String getDoc() {
		String docResult = "";
		// TODO completes this method
		
		
		return docResult;
	}

	@Override
	public String getText(Cursor cursor) {
		return this.doc.get(cursor.getLine()).get(cursor.getColumn());
	}

	/**
	 * PRE: True
	 * Process all operations in array and adds the corresponding to inverse operations.
	 * @param operations
	 * @throws ErrorInOperation 
	 */
	public void processOperations(IOperation[] operations)  {
		//TODO: Process operations and keep in mind that these operations may be undone
	}
	
	/**
	 * PRE: there is undo operations otherwise raise ErrorNoUndo
        undo the last operation performed on editor
	 * @throws ErrorInOperation 
	 */
	public void undoOperation()     {
		//TODO: Process next undo operation
	}
}
