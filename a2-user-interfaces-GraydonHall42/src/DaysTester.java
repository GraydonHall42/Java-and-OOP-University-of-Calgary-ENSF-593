
/**
 * A class to test the Days class.
 * 
 * Runs through all the months 1 - 12 and prints the number of days.
 * 
 * @author Graydon Hall
 *
 */
public class DaysTester {

	/**
	 * main method, used to test that the Days class correctly returns the correct number of days for
	 * each month.
	 * @param args args
	 */
	public static void main(String[] args) {
		for (int i = 1; i <= 12; i++) {  // for each month of year 1-12
			// print days in that month
			System.out.println("Month " + i + " has " + Days.howManyDays(i) + " days.");
		}
	}

}
