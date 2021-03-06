package view;

import logic.Game;
import utils.MyStringUtils;

public class GamePrinter {
	
	Game game;
	int numRows; 
	int numCols;
	IPrintable printable;
	final String space = " ";
	
	public GamePrinter (IPrintable printable, int cols, int rows) {
		this.printable = printable;
		this.numRows = rows;
		this.numCols = cols;
	}
	
	 public String toString() {
		System.out.println(printable.getInfo());
		int cellSize = 7;
		int marginSize = 2;
		String vDelimiter = "|";
		String hDelimiter = "-";
		String intersect = space;
		String vIntersect = space;
		String hIntersect = "-";
		String corner = space;

		String cellDelimiter = MyStringUtils.repeat(hDelimiter, cellSize);

		String rowDelimiter = vIntersect + MyStringUtils.repeat(cellDelimiter + intersect, numCols-1) + cellDelimiter + vIntersect;
		String hEdge =  corner + MyStringUtils.repeat(cellDelimiter + hIntersect, numCols-1) + cellDelimiter + corner;

		String margin = MyStringUtils.repeat(space, marginSize);
		String lineEdge = String.format("%n%s%s%n", margin, hEdge);
		String lineDelimiter = String.format("%n%s%s%n", margin, rowDelimiter);

		StringBuilder str = new StringBuilder();

		str.append(lineEdge);
		//LO QUE NOS INTERESA
		
		for(int i=0; i<numRows; i++) {
		        str.append(margin).append(vDelimiter);
		        for (int j=0; j<numCols; j++) {
		           str.append( MyStringUtils.centre(printable.getPositionToString(j, i), cellSize)).append(vDelimiter);
		        }
		        if (i != numRows - 1) str.append(lineDelimiter);
		        else str.append(lineEdge);   
		}

		return str.toString();
	    }

	}
