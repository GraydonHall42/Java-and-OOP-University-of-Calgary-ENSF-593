import java.util.Arrays;
import java.util.Collections;

/**
 * @author Graydon Hall
 *
 */
public class DataSeries implements IBasicStats{

    private String label;
    private double[] data;

    private int count;

    public DataSeries(String label) {
        this.label = label;
        this.data = new double[100];
        this.count = 0;
    }

    public int size() {
        return count;
    }

    public void add(double val){
        data[count] = val;
        count++;
    }

    /**
     * Calculates the min of all data in the dataseries
     *
     * @return min of data
     */
    @Override
    public double getMin() {
        double min = data[0];  // used to track min
        for(int i=0; i<count; i++){
            if (data[i] < min){
                min = data[i];
            }
        }
        return min;  // return min
    }

    /**
     * Calculates the max of all data in the dataseries
     *
     * @return max of data
     */
    @Override
    public double getMax() {
        double max = data[0];
        for(int i=0; i<count; i++){
            if (data[i] > max){
                max = data[i];
            }
        }
        return max;  // return max
    }


    /**
     * Calculates the sum of all data in the dataseries
     *
     * @return sum of all data
     */
    @Override
    public double getSum(){
        double gSum = 0;  // used to track sum of the grades.
        for(int i=0; i<count; i++){
            gSum += (double)data[i];
        }
        return gSum;  // return sum
    }


    /**
     * Calculates the mean of all data in the dataseries
     *
     * @return mean of all data
     */
    @Override
    public double getMean(){
        double gSum = 0;  // used to track sum of the grades.
        for(int i=0; i<count; i++){
            gSum += (double)data[i];
        }
        return gSum/count;  // divide total by count to get mean.
    }

    @Override
    public String toString() {
        String seriesStr  = label;
        int max = count;
        if (max > 10){
            max = 10;
        }
        for (int i=0; i<max; i++){
            seriesStr += "\n" + data[i];
        }
        return seriesStr;

    }
}
