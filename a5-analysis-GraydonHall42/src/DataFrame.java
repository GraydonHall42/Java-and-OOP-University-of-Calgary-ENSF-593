import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Graydon Hall
 *
 */
public class DataFrame {
    private String fileName;

    private String[] headerNames;

    private int numOfRows=-1;
    private int numOfCols =0;

    private double[][] csvData;

    public DataFrame(String fileName) throws IOException {
        this.fileName = fileName;
        String line;

        Scanner s = null;
        s = new Scanner( new File(this.fileName));  // scan in the text file


        while(s.hasNextLine()) {  // while there's more lines to read
            line = s.nextLine();  // read next line
            String[] rowAsString;

            if (numOfRows == -1){  // first line of CSV (headers)
                headerNames = line.split(",");
                numOfCols = headerNames.length;  // number of columns
                csvData = new double[100][numOfCols];
                numOfRows++;
            }
            else{
                rowAsString = line.split(",");
                for (int i=0; i < rowAsString.length; i++) {
                    csvData[numOfRows][i]= Double.parseDouble(rowAsString[i]);
                }
                numOfRows++;
            }
        }

    }
    @Override
    public String toString() {
        // print out headers and  *at most* 10 rows
        String arrayString;
        int max;

        if (numOfRows > 10){
            max = 10;
        } else{
            max = numOfRows;
        }
        var firstNRows = new double[max][numOfCols];
        for (int row=0; row<max; row++){
            for (int col = 0; col< numOfCols; col++){
                firstNRows[row][col] = csvData[row][col];
            }
        }
        arrayString = Arrays.deepToString(firstNRows).replace("], ", "]\n");
        return "" + Arrays.toString(headerNames) + "\n" + arrayString;
    }

    public DataSeries getColumnByIndex(int index){
        var dSeries = new DataSeries(headerNames[index]); // assign label
        for (int row=0; row<numOfRows; row++){
            dSeries.add(csvData[row][index]);
        }
        return dSeries;

    }

    public String[] getHeaderNames() {
        return headerNames;
    }

    public int getNumOfRows() {
        return numOfRows;
    }

    public int getNumOfCols() {
        return numOfCols;
    }

}
