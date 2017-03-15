import java.io.FileNotFoundException;
import java.io.IOException;
import com.csvreader.CsvReader;

public class ReadFileWriteToConsole {
	
	private static final int MAXROW = 3;
	private static final int MAXCOL = 3;
    private static final String inFile = "in.csv";
	   
    public String[][] sheet = new String[MAXROW][MAXCOL];
	   
    public static void main(String args[]) throws IOException {
    	// create a ReadWriteToConsole object
    	//  Do not change the signature of this method.
    	ReadFileWriteToConsole rwtc = new ReadFileWriteToConsole();
    	// invoke readSheet()
    	rwtc.readSheet();
    	// invoke writeSheet()
    	rwtc.writeSheet();
    }	
	   
    public void readSheet() throws IOException {
    	//  Do not change the signature of this method.
    	CsvReader cr = new CsvReader(inFile);
    	for (int r = 0; r < MAXROW; r++) {
			cr.readRecord();
			String[] vals = cr.getValues();
			for (int c = 0; c < MAXCOL; c++) {
				sheet[r][c] = vals[c];
			}
		}
    	cr.close();
	}
    
	public void writeSheet(){
    	//  Do not change the signature of this method.
		for (int r = 0; r < MAXROW; r++) {
			for (int c = 0; c < MAXCOL; c++) {
				System.out.print("[" + sheet[r][c] + "]");
			}
			System.out.println();
		}
	}
}
