import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Vector;

import com.csvreader.*;

public class WriteHtml {
    public static final String inFileName = "input.csv";
    public static final String outFileName = "output.html";

    public static void main(String[] args) {
        // ... insert code here ...
    	//  Do not change the signature of this method.
    	try {
			CsvReader cr = new CsvReader(inFileName);
			BufferedWriter out = new BufferedWriter(new FileWriter(outFileName));
			
			out.write("<html><head><title>" + inFileName + "</title></head>");
			out.write("<body><table style=' text-align: left;' border='1' cellpadding='2' cellspacing='2'><tbody>");
			
			for (int r = 0; cr.readRecord(); r++) {
				String[] vals = cr.getValues();
				out.write("<tr>");
				for (int c = 0; c < cr.getColumnCount(); c++) {
					out.write("<td>" + EscapeHTML.stringToHTMLString(vals[c]) + "</td>");
				}
				out.write("</tr>");
			}
			
			out.write("</tbody></table><br></body></html>");
			out.close();
			
    	} catch (FileNotFoundException e) {
    		System.out.println("File not found!");
		} catch (IOException e) {
			System.out.println("IO error occured!");
		}
    }
}
