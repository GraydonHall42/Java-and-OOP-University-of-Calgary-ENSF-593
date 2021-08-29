/**
 * Provides a method which allows a user to obtain the number of days in a month.
 * @author Graydon Hall
 */
public final class Days {


	/**
	 * Private constructor. Means class cannot be instantiated.
	 */
	private Days() {}

	/**
	 * Method used to return number of days given in a month, based on the months index.
	 * @param monthIndex index from 1-12 corresponding to the month in the year.
	 * @return the number of days in the given month.
	 */
	public static int howManyDays(int monthIndex){
		// Months preceding august...
		// odd numbered months contain 31 days, except for february, which as 28 days
		// starting august, even numbered months have 31 days, odd numbered months have
		if(monthIndex < 8){  // if prior to august...
			if (monthIndex == 2){  // february
				return 28;
			}
			else if (monthIndex % 2 ==0){  // even months = 30 days prior to august
				return 30;
			}
			else {
				return 31;  // odd months = 31 days prior to august
			}
		}
		else{
			if (monthIndex % 2 ==0){  // even months = 31 days august and beyond
				return 31;
			}
			else {
				return 30;  // odd months = 30 days august and beyond
			}
		}
	}
}
