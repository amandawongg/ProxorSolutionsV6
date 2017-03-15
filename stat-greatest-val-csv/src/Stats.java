
public class Stats extends StatsCsv {
	private int rows;
	private int cols;
	private String[][] data;

	public Stats(int rows, int cols, String[][] data) {
		this.rows = rows;
		this.cols = cols;
		this.data = data;
		greatestValue();
	}

	private void greatestValue() {
		sheet[rows][0] = "Greatest";
		sheet[rows][1] = "Value";

		for (int c = 2; c < cols; c++) {
			int prevVal = Integer.parseInt(data[1][c]);
			for (int r = 2; r < rows; r++) {
				int currVal = Integer.parseInt(data[r][c]);
				prevVal = currVal > prevVal ? currVal : prevVal;
			}
			sheet[rows][c] = prevVal + "";
		}
	}
}
