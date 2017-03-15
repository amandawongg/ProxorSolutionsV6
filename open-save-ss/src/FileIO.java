// FileIOBase.java -- template for FileIO.java.
//
// this file should be modified to implement
// open, save, and save as... commands for SpreadSheet.java
// 
// Do not modify the signatures of these methods.


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.csvreader.*;

public class FileIO {
    public static boolean open(SpreadSheet ss, File file) {
    	System.out.println("Open " + file);
    	try {
			CsvReader cr = new CsvReader(file.toString());
			for (int r = 0; cr.readRecord(); r++) {
				String[] val = cr.getValues();
				for (int c = 0; c < cr.getColumnCount(); c++) {
					ss.setCell(r, c, val[c]);
				}
			}
			cr.close();
			ss.evaluate();
	    	return true;
    	} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		return false;
    }
	
    public static boolean saveAs(SpreadSheet ss, File file) {
    	System.out.println("SaveAs " + file);
    	CsvWriter cw = new CsvWriter(file.toString());
    	try {
        	for (int r = 0; r < ss.maxRows; r++) {
    			for (int c = 0; c < ss.maxCols; c++) {
    				cw.write(ss.getCellFormula(r, c));
    			}
    			cw.endRecord();
    			cw.close();
    		}
        	return true;
		} catch (IOException e) {
		}
		return false;
    }
    
}
