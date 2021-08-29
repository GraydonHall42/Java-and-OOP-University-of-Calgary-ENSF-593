public class Wolf extends Animal implements Predator{
    /**
     * speak() returns an appropriate String representing
     * the way a certain kind of animal speaks. It is
     * implemented in the Animal subclasses.
     */
    @Override
    public String speak() {
        return "how-uul";
    }

    /**
     * Wolf() constructor sets its kind variable
     */
    public Wolf() {
        kind = "wolf";
    }

    /**
     * eat() returns an appropriate String representing
     * something the animal eats. It is implemented in the Animal
     * subclass.
     *
     * @return String item the animal eats
     */
    @Override
    public String eat() {
        return "deer";
    }

    /**
     * @param a Animal that we want to know if this animal preys on
     * @return boolean to show if animal preys on specified Animal a
     */
    @Override
    public boolean preysOn(Animal a) {
        // assume our wolf preys on cats and dogs, but not cows.
        if ((a instanceof Cat) || (a instanceof Dog)){
            return true;
        }
        else{
            return false;
        }
    }
}
