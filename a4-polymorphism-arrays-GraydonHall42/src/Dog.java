public class Dog extends Animal implements Trainable{
    /**
     * Dog() constructor sets its kind variable
     */
    public Dog() {
        kind = "dog";
    }

    /**
     * speak() implements the Animal speak() method.
     *  When a Dog speaks it says woof.
     */
    public String speak() {
        return "woof";
    }


    /**
     * eat() implements the animal eat() method.
     * @return String carpets since dogs eat carpets
     */
    public String eat(){
        return "carpets";
    }

    /**
     * doATrick() implements the trainable doATrick() method. It returns a string
     * that describes a trick that a dog can do.
     * @return String that demonstrates a trick a dog can do.
     */
    @Override
    public String doATrick() {
        return "I do tricks. I can shake a paw.";
    }

}
