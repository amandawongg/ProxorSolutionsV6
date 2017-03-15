// StatsCsv.java -- add greatest values to spreadsheet
//
// This is NOT a working program. This is a "skeleton" that
// should be modified and extended to meet the specifications.

import java.io.IOException;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class StatsCsv {
    
    private static final int MAXROW = 16;
    private static final int MAXCOL = 16;
    private int rowsUsed = 0;
    private int colsUsed = 0;
    private static final String inFile = "Data01.csv";
    private static final String outFile = "Data02.csv"; 
    
    public static String[][] sheet = new String[MAXROW][MAXCOL];
    
    public static void main(String[] args) throws IOException {
        StatsCsv a = new StatsCsv();
        a.readSheet();
        // a.getRows() is the row count before adding greatest values
        Stats s = new Stats(a.getRows(), a.getCols(), a.getData());
        a.setRows(a.getRows() + 1); // because we added a row of greatest values
        a.writeSheet();
    }
    
    public void writeSheet() throws IOException {
    	CsvWriter cw = new CsvWriter(outFile);
    	for (int r = 0; r < getRows(); r++) {
			for (int c = 0; c < getCols(); c++) {
				cw.write(sheet[r][c]);
			}
			cw.endRecord();
		}
    	cw.close();
    }

    public void readSheet() throws IOException {
    	CsvReader cr = new CsvReader(inFile);
    	for (int r = 0; cr.readRecord() && r < MAXROW; r++) {
			String[] vals = cr.getValues();
			rowsUsed++;
    		for (int c = 0; c < cr.getColumnCount() && c < MAXCOL; c++) {
				sheet[r][c] = vals[c];
				colsUsed = cr.getColumnCount();
			}
		}
    	cr.close();
    }

    public int getRows() {
    	return rowsUsed;
    }
    
    public int setRows(int r) {
        rowsUsed = r;
        return rowsUsed;
    }

    public int getCols() {
    	return colsUsed;
    }
    
    public String[][] getData() {
    	return sheet;
    }
}
