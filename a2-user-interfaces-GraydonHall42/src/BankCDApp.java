import java.text.NumberFormat;

/**
 * Class representing command-line interface to compute 
 * yearly and daily compounded certificate of deposit.
 *  
 * @author Graydon Hall
 *
 */
public class BankCDApp {

	/**
	 * used for calculating the CD's value at the time of maturity
	 */
	private BankCD bank;


	/**
	 * Used to communicate with user through the terminal
	 */
	private KeyboardReader reader;


	/**
	 * constructs our BankCDApp class, and itializes the keyboard reader
	 * to interact with the user through the terminal
	 */
	public BankCDApp() {
		reader = new KeyboardReader();
		// initializes it's own instance of the keyboard reader
		// therefore owns or contains relationship
	}

	/**
	 * primary method for obtaining parameters of the CD from the user, and then
	 * presenting it's value at the time of Maturity, based on both annual and daily compounding.
	 */
	public void run() {
		reader.prompt("Compare daily and annual compounding for a Bank CD.");  // general greeting
		reader.prompt("\n    Input CD initial principal (ex. $2,500 = 2500): ");  // prompt of principal
		double principal = reader.getKeyboardDouble();  // get value of principal
		reader.prompt("    Input CD interest rate (ex. 7.8% = 7.8): ");  // prompt for interest rate
		double rate = reader.getKeyboardDouble()/100;  // get value of rate******************************************************************
		reader.prompt("    Input the number of years to maturity: ");  // prompt for number of years
		double years = reader.getKeyboardDouble();  // get value of years till maturity

		bank = new BankCD(principal, rate,years);  // create bank object used for calculations
		double yearyTotal = bank.calcYearly();  // calculate value at maturity if interst compounded yearly
		double dailyTotal = bank.calcDaily();  // calculate value at maturity if interest compounded daily


		// Number formatting:
		NumberFormat currency = NumberFormat.getCurrencyInstance();  // used to format values in currency format
		NumberFormat percent = NumberFormat.getPercentInstance();  // used to format percentage values
		percent.setMaximumFractionDigits(1);  // percents will have 1 decimal place


		// present user entered parameters
		reader.display("For Principal=" + currency.format(principal) +
				", Rate=" + percent.format(rate) +
				", Years= " + String.format("%.1f",years));
		// present final value for annual compounding case
		reader.display("\n    The maturity value compounded yearly is " + currency.format(yearyTotal));

		// present final value for daily compounding case
		reader.display("\n    The maturity value compounded daily is: " + currency.format(dailyTotal));

	}

	public static void main(String[] args) {
		
		BankCDApp app = new BankCDApp();  // create instance of our BankCDApp class
		app.run();  // run main routine.

	}

}
