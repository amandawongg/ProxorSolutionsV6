import java.util.Arrays;

public class Stats extends StatsCsv {
	private int rows;
	private int cols;
	private String[][] data;
	
	public Stats(int rows, int cols, String[][] data) {
		this.rows = rows;
		this.cols = cols;
		this.data = data;
		computeMedians();
	}
	
	private void computeMedians() {
		sheet[rows][0] = "";
		sheet[rows][1] = "Median";
		
		for (int c = 2; c < cols; c++) {
			int[] column = new int[rows - 1]; 
			for (int r = 1; r < rows; r++) {
				column[r - 1] = Integer.parseInt(sheet[r][c]);
			}
			Arrays.sort(column);
			if (column.length % 2 == 1) {
				sheet[rows][c] = column[column.length / 2] + "";
			} else {
				sheet[rows][c] = (int)Math.ceil((double)(column[column.length / 2] + column[column.length / 2 - 1]) / 2) + "";
			}
		}
	}
}
