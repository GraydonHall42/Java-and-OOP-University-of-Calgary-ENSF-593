
/**
 * Consctructs main application object, used to calculate the square root of a number using Newton's method.
 * The user is prompted to enter a number they want to find the square root of, an initial guess of the square root,
 * along with the maximum acceptable error. The square root is calculated, and the user is presented with the
 * final value, along with the number of iterations required to come to that value.
 *
 *
 * @author Graydon Hall
 *
 */
public class NewtonApp {

	/**
	 * a reader used to give messages to the user, as well as recieve input.
	 */
	private KeyboardReader reader;


	/**
	 * a calculator which utilizes newton's method in order to calculate the squre root of a number, based on
	 * an initial guess, and a maximum specified error. The calculator also keeps track of the number of
	 * iterations required to reach a final answer.
	 */
	private NewtonTester calc;

	/**
	 * Constructs the main application object, while intitializing the reader which will be
	 * used to communicate with the user.
	 */
	public NewtonApp(){
		reader = new KeyboardReader();
	}

	/**
	 * Primary method used to interact with the user. The user is asked to supply a number they want to calculate the
	 * square root of, an initial guess of the square root, as well as the maximum allowable error in the result.
	 * The result is calculated via newton's method, and the answer, as well as the number of iterations required to
	 * obtain it, are then passed to the user.
	 */
	public void run(){

		// obtain input from user.
		reader.prompt("Welcome to Square root Calculator.");
		reader.prompt("\n**Please enter all values as double precision numbers.**");
		reader.prompt("\n    Enter a Number to find the square root of: ");
		double N = reader.getKeyboardDouble();  // number to calculate the square root of.
		reader.prompt("    Enter a max allowable error: ");
		double error = reader.getKeyboardDouble();  // max allowable error in the final answer.
		reader.prompt("    Enter an initial guess: ");
		double guess = reader.getKeyboardDouble();  // users initial guess of the square root.

		calc = new NewtonTester(N, error, guess);  // create calculator based on user input.

		// calculate and present results
		reader.prompt("\n----Results-----");
		reader.prompt("\n    Calculated answer: " + calc.sqrt());
		reader.prompt("\n    Number of iterations required: " + calc.getNumIterations());

	}


	/**
	 * main method used to run our program.
	 *
	 * @param args args
	 */
	public static void main(String[] args) {
		NewtonApp app = new NewtonApp();  // instatiate our app
		app.run();  // run the app.

	}

}
