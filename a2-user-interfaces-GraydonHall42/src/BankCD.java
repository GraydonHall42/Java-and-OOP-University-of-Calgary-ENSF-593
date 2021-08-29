/**
 * Class representing a certificate of deposit.
 * 
 * @author Graydon Hall
 *
 */
public class BankCD {

    /**
     * principal value of CD
     */
    private double principal;

    /**
     * interest rate value for CD
     */
    private double rate;

    /**
     * years till maturity of CD
     */
    private double years;


    /**
     * constructs our BankCD calculator with specified values for principal,
     * annual interest rate, and years till maturity.
     *
     * @param p principal
     * @param r annual interest rate
     * @param y years till maturityi
     */
    public BankCD(double p, double r, double y){
        this.principal = p;
        this.rate = r;  // divide by 100 for calculation purposes.
        this.years=y;
    }

    /**
     * calculates the value of the CD at maturity, if interest is compound annually
     * @return value of CD at maturity
     */
    public double calcYearly(){
        // based on formula from pages 230/231 of Java Java Java
        return principal * Math.pow((1+rate),years);
    }

    /**
     * calculates the value of the CD at maturity, if interest is compound daily
     * @return value of CD at maturity
     */
    public double calcDaily(){
        // based on formula from pages 230/231 of Java Java Java
        return principal * Math.pow((1+rate/365),years*365);
    }

}
