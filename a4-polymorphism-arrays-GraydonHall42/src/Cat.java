/**
 *
 * Cat is a subclass of Animal.
 *
 * @author Graydon Hall
 *
 */
public class Cat extends Animal implements Trainable{

    /**
     * Cat() constructor sets its kind variable
     */
    public Cat() {
        kind = "cat";
    }

    /**
     * speak() implements the Animal speak() method.
     *  When a cat speaks it says meow.
     */
    public String speak() {
        return "meow";
    }

    /**
     * eat() implements the animal eat() method.
     * @return String carpets since cats eat mice
     */
    public String eat(){
        return "mice";
    }


    /**
     * doATrick() implements the trainable doATrick() method. It returns a string
     * that describes a trick that a dog can do.
     * @return String that demonstrates a trick a cat can do.
     */
    @Override
    public String doATrick() {
        return "I do tricks. I can hang from the drapes.";
    }
}