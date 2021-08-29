/**
 * Cow is a subclass of Animal.
 * 
 * @author Graydon Hall
 * 
 */
public class Cow extends Animal {

    /**
     * Cow() constructor sets its kind variable
     */
    public Cow() {
        kind = "cow";
    }

    /**
     * speak() implements the Animal speak() method. 
     *  When a cow speaks it says moo.
     */
    public String speak() {
        return "moo";
    }

    /**
     * eat() implements the animal eat() method.
     * @return String carpets since cows eat hay
     */
    public String eat(){
        return "hay";
    }

}