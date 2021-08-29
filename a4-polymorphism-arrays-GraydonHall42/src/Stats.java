import java.util.Arrays;

/**
 * Provides data fields and methods to create a Java data-type, which holds up to 100 grades,
 * sorts them, and can also return their mean and median.
 * 
 * @author Graydon Hall
 * 
 */
public class Stats {

	/**
	 * Integer Array that holds grades entered by the user.
	 */
	private int grades[];


	/**
	 * Integer that holds count of number of grades entered in the array.
	 */
	private int count;

	/**
	 * Constructs the Stats object, intitializing the grades array as an empty array with 100 elements, and
	 * setting the count of grades to 0 since none have been entered yet.
	 */
	public Stats() {
		grades = new int[100];  // predefines a 1-D 100 element array
		count = 0;  // counter varialble to count number of entries added.
	}

	/**
	 * INSERTION SORT OF THE FIRST n ELEMENTS OF ARRAY arr 
	 * SEE PAGE 407 TO PAGE 410
	 * FOR A DISCUSSION
	 * 
	 * @param grades
	 * @param count
	 */
	public void sort(int[] grades, int count) {
		int temp, j, k;
		for (j = 1; j < count; j++) {
			temp = grades[j];
			for (k = j - 1; (k >= 0) && (grades[k] > temp); k--) {
				grades[k + 1] = grades[k];
			}
			grades[k + 1] = temp;
		}
	}

	/**
	 * Adds integer grade to grades array, and increments grade counter by 1.
	 * @param grade  grade to be added to grades array
	 */
	public void add(int grade){
		grades[count] = grade;  // insert grade at count
		count++; // increment counter

	}

	/**
	 * Calculates the median of all grades entered by the user
	 *
	 * @return median of all grades entered
	 */
	private double getMedian() {
		sort(grades, count);  // sort the grades

		if (count%2 ==0){  // if even number of grades
			var x = count/2;  // upper bound of halfway point
			return (double)(grades[x] + grades[x-1])/2;  // add middle two values and divide by 2
		} else{  // odd number of entries
			var x = (int)Math.floor(count/2);  // take middle value
			return grades[x];  // return middle grade
		}
	}


	/**
	 * Calculates the mean of all grades entered by the user
	 *
	 * @return mean of all grades entered
	 */
	public double getMean(){
		double gSum = 0;  // used to track sum of the grades.
		for(int i=0; i<count; i++){  // for all grades in array
			gSum += (double)grades[i]; // cast grade to double then add.
		}
		return gSum/count;  // divide total by count to get mean.
	}

	/**
	 * Returns a String which lists sorted grades, median, and mean.
	 *
	 * @return String which lists sorted grades, median, and mean.
	 */
	@Override
	public String toString() {

		int[] gradesEntered = Arrays.copyOfRange(grades, 0, count); // cut off values for grades not entered.

		return 	"grades=" + Arrays.toString(gradesEntered) +  // grades
				"\nmean=" + this.getMean() +  // mean
				"\nmedian=" + this.getMedian();  // median
	}

	/**
	 * Method used to test functionality of the class.
	 * @param args
	 */
	public static void main(String[] args) {

		// test add method
		var x = new Stats();
		for(int i=1; i<=5; i++){
			x.add(i);
		}
		for(int i=1; i<=7; i++){
			x.add(i);
		}

		// test mean() method
		var y = x.getMean();
//		System.out.println(y);

		// test median() method
		var z = x.getMedian();
//		System.out.println(z);

		// test toStrign() method
		System.out.println(x);

	}




}
