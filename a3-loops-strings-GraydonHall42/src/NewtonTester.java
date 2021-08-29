
/**
 * Provides data fields and method to create a java data-type, representing a calculator that is capable of
 * finding the square root of a number, utilizing Newton's method.
 *
 * @author Grayodn
 *
 */
public class NewtonTester {

    /**
     * number we want to find the square root of.
     */
    private double N;

    /**
     * Allowable error in final result. Equal to the difference between two consecutive Newton computations
     */
    private double maxError;

    /**
     * initial guess of the square root
     */
    private double guess;

    /**
     * number of iterations required to reach a final answer.
     */
    private double numIterations = 0;


    /**
     * @param N number to calculate the squre root of.
     * @param maxError  max allowable error in the final result.
     * @param guess  initial guess of the square root.
     */
    public NewtonTester(double N, double maxError, double guess) {
        this.N = N;
        this.maxError = maxError;
        this.guess = guess;
    }

    /**
     * Calculates the square root of the number N, using Newton's method. Returns the square root, while also
     * keeping track of the required number of iterations required to come to the final result.
     *
     * @return the square root of the number N
     */
    public double sqrt(){

        while(true){
            numIterations++; // increment by one each loop.
            double old_guess = guess;  // store for error computation
            guess = 0.5 * ((N/guess)+guess);  // update guess based on formula

            if (Math.abs(old_guess-guess)<maxError){
                return guess;  // error level acceptable, break out of loop and return answer.
            }
        }
    }

    /**
     * returns the number of iterations required to reach final answer.
     *
     * @return numIterations
     */
    public double getNumIterations() {
        return numIterations;
    }
}
