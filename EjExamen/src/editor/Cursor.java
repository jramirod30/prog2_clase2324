package editor;

public class Cursor {
	private int line = 0;
	private int column = 0;
	
	public Cursor() {
		
	}
	
	public Cursor(int line, int column) {
		this.column = column;
		this.line = line;
	}
	
	public Cursor(Cursor org) {
		this(org.line, org.column);
	}

	/**
	 * @return the line
	 */
	public int getLine() {
		return line;
	}

	/**
	 * @return the column
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * @param line the line to set
	 */
	public void setLine(int line) {
		this.line = line;
	}

	/**
	 * @param column the column to set
	 */
	public void setColumn(int column) {
		this.column = column;
	}
	
}
