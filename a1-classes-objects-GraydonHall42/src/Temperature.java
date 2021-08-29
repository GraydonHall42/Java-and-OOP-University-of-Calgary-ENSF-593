import java.text.DecimalFormat;

/**
 * This class represents temperature in units of Fahrenheit, and offers methods for the user
 * to obtain the temperature in units of Celsius and Fahrenheit
 *
 *
 * @author Graydon Hall
 *
 */
public class Temperature {
	/**
	 * Temperature in degrees
	 */
	private double degrees;

	/**
	 * Constructs Temperature object with specified value for degrees in fahrenheit.
	 * @param degrees the temperature in degrees
	 */
	public Temperature(double degrees){
		this.degrees = degrees;
	}

	/**
	 * Returns the temperature in fahrenheit
	 * @return the temperature in units of fahrenheit
	 */
	public double getFahrenheit(){
		return this.degrees;
	}

	/**
	 * Returns the temperature in celsius
	 * @return the temperature in units of celsius.
	 */
	public double getCelsius(){
		return 5 * (this.degrees - 32) /9;
	}

	/**
	 * Method used to test the temperature class
	 * @param args args
	 */
	public static void main(String[] args) {
		DecimalFormat f = new DecimalFormat("##.00");  // created to format returned values
		// found at https://stackoverflow.com/questions/11701399/round-up-to-2-decimal-places-in-java

		// create our two thermometers
		Temperature thermometer1 = new Temperature(20);
		Temperature thermometer2 = new Temperature(98.6);

		// print thermometer 1 results
		System.out.println("The Fahrenheit temperature of " +
				"thermometer1 is " + f.format(thermometer1.getFahrenheit()) + " degrees.");
		System.out.println("The Celsius temperature of " +
				"thermometer1 is " + f.format(thermometer1.getCelsius()) + " degrees.");

		// print thermometer 2 results
		System.out.println("The Fahrenheit temperature of " +
				"thermometer2 is " + f.format(thermometer2.getFahrenheit()) + " degrees.");
		System.out.println("The Celsius temperature of " +
				"thermometer2 is " + f.format(thermometer2.getCelsius()) + " degrees.");
	}

}
