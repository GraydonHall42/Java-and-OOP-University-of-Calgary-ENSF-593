# Animals report
Author: Graydon Hall 

## UML class diagram
![Animals UML](AnimalsUML.png)

## Answers to Questions in step 6
Given the classes and interfaces you have defined, which of the following would be valid. Explain. If you don't know the answers, experiment by typing the code into your program and testing it.

a) `Trainable pet1 = new Cow();`<br>
b) `Animal pet2 = new Cat(); System.out.println(pet2.doATrick());`<br>
c) `Animal pet3 = new Cat(); System.out.println( ((Trainable)pet3).doATrick() );`<br>

a) gives an error because the cow class does not implement the trainable interface.<br>
b) also gives an error, that states: <br>
`java: cannot find symbol`<br>
`symbol:   method doATrick()`<br>
`location: variable pet2 of type Animal`<br>
this is because the animal class on it's own does not implement the trainable interface. If we replaced `Animal` 
with `Cat` or `var` the error would dissapear. <br>
c) does not give an error, since pet3 is cast to the trainable interface when the `doATrick()` method is called

## Execution and Testing
![Animals test](AnimalsTest.png)
