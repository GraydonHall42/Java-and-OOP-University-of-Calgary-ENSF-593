
/**
 *  Animal is an abstract class. It's speak()
 *  method is abstract and meant to be implemented in 
 *  Animal subclasses, such as Dog, Cat.
 *  
 *  @author Graydon Hall
 */
public abstract class Animal {
	
	protected String kind; // Cow, pig, cat, etc.

    /**
     * Animal() default constructor
     */
    public Animal()  {  }

    /**
     * toString() method overrides the Object toString() method.
     */
    public String toString() {
        return "I am a " + kind + " and I go " + speak() + "\n" +
                "I eat " + eat();
    }

    /**
     * speak() returns an appropriate String representing
     *  the way a certain kind of animal speaks. It is 
     *  implemented in the Animal subclasses.
     */
    public abstract String speak();   // Abstract method


    /**
     * eat() returns an appropriate String representing
     * something the animal eats. It is implemented in the Animal
     * subclass.
     * @return String item the animal eats
     */
    public abstract String eat();

    /** 
     * main() creates instances of Animal subclasses and invokes
     *  their speak() methods, illustrating inheritance and 
     *  polymorphism.
     */
	public static void main(String[] args) {
		Animal animal = new Cow();
        System.out.println(animal.toString());
        animal = new Cat();
        System.out.println(animal.toString());
        animal = new Dog();
        System.out.println(animal.toString());

        // testing out tricks
        Trainable pet = new Cat();  // pet implements the trainable interface
        System.out.println(pet.doATrick());
        pet = new Dog();  // pet implements the trainable interface
        System.out.println(pet.doATrick());

        // testing out our wolf (predator)
        Wolf predator = new Wolf();
        System.out.println(predator);
        var cat1 = new Cat();
        var cow1 = new Cow();
        System.out.println("I prey on Cows: " + predator.preysOn(cow1));
        System.out.println("I prey on Cats: " + predator.preysOn(cat1));






//         ******** for questions in part 6: *****
//        Trainable pet1 = new Cow();  // error, because cow does not implement trainable interface.
//
//
//        Animal pet2 = new Cat();
//        System.out.println(pet2.doATrick());
//        // error becasue animal does not on it's own implement the trainable interface. I get an error saying: java: cannot find symbol
//        // symbol:   method doATrick()
//        // location: variable pet2 of type Animal
//
//
//        Animal pet3 = new Cat();
//        System.out.println( ((Trainable)pet3).doATrick() );



	}

}
