import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import com.csvreader.CsvReader;

public class ReadFileWriteToConsole {

	private static final String inFile = "in.csv";
	private CsvReader cr;

	public static void main(String args[]) throws IOException {
		// (add code to implement the following)
		// create a ReadFileWriteToConsole object
		// call method below to read the data from inFile
		// call method below to write the data to the console
		// Do not change the signature of this method.
		ReadFileWriteToConsole rwtc = new ReadFileWriteToConsole();
		rwtc.makeSheet();
		rwtc.writeSheet();
		return;
	}

	public String getCell(int row, int col) {
		// return the value of the spreadsheet at the given row and column
		// Do not change the signature of this method.
		if (row > getRowCount() || col > getColCount()) {
			return null;
		}
		try {
			makeSheet();
			for (int r = 0; r < row + 1; r++) {
				cr.readRecord();
			}
			return cr.get(col);
		} catch (IOException e) {
			return null; // <-- fix this to return a proper value
		}
	}

	public int getRowCount() {
		// return the number of rows in the spreadsheet
		// Do not change the signature of this method.
		try {
			makeSheet();
			int RC = 0;
			while (cr.readRecord()) {
				RC++;
			}
			return RC; // <-- fix this to return a proper value

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public int getColCount() {
		// return the number of columns in row
		// Do not change the signature of this method.
		try {
			makeSheet();
			cr.readRecord();
			return cr.getColumnCount();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public void makeSheet() throws IOException {
		// read the data from inFile
		// Do not change the signature of this method.
		cr = new CsvReader(inFile);
		return;
	}

	public void writeSheet() {
		// format data to console
		// Do not change the signature of this method.
		for (int i = 0; i < getRowCount(); i++) {
			for (int j = 0; j < getColCount(); j++) {
				System.out.print("[" + getCell(i, j) + "]");
			}
			System.out.println();
		}
	}
}
