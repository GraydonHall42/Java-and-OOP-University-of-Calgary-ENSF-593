# a2-user-interfaces
Exploring command line and graphical user interfaces.

This assignment has two mandatory parts:
- [1. Days in month](#1-days-in-month)
- [2. Certificate of Deposit](#2-certificate-of-deposit)

and three optional parts (not graded):
- [Leap Year](#optional-leap-year)
- [Temperature GUI](#optional-temperature-gui)
- [Robust Certificate of Deposit](#optional-robust-certificate-of-deposit)

# 1. Days in Month
**Problem Statement**

The months of the year can contain 28, 30, or 31 days. In the months preceding August (the 8th month), the odd numbered months contain 31 days and even numbered months contains 30 days, except for February (the 2nd month), which has 28 days. Beginning in August, however, the even numbered months contain 31 days and the odd numbered months 30 days. Example: September (the 9th month) has 30 days, while December (the 12th month) has 31 days. Implement a Java graphical user interface that prompts the user to enter a number which represents a month of the year, and reports whether that month contains 28, 30, or 31 days.

**GUI Specification**

The Graphical User Interface (GUI) for this project should correspond to the GUI interface of the stub for this lab. The following elements are present:

- The user's input should be handled with a JTextField object.
- The prompt should be handled with a JLabel object.
- The result should be reported with a JTextArea object.

**Design Specifications**

This program should be broken into two classes: `Days` and `MonthJFrame`.

`MonthJFrame` will serve as a user interface. It will prompt the user for a number and then pass that number to the `Days.howManyDays(int)` method , which returns an integer representing the number of days in the month. The GUI will then report the result on the screen. You will be provided with incomplete versions of both of these classes.

Complete implementation of `src/MonthJFrame.java`. Note the following features:
- The GUI class has 2 instance variables, a `JTextField` for user input, and a `JTextArea` to report the result.
- The constructor initializes the GUI's instance variables and adds the GUI objects to the JFrame. Note that the `inputField` is assigned an `ActionListener` to handle its actions. It is in this method that you will add code to compute and report the output to the user.
- The `actionPerformed()` method handles only one event: the event that occurs when the user presses the RETURN or ENTER key in the `inputField`. All other events are ignored. This method gets the user's input, converts it to an int and stores it in the number variable. You need to add code to call the corresponding method to calculate the number of days and update the JTextArea object with the result.
Note how a String input value is converted into an int using the Integer wrapper class:

```java
   number = Integer.parseInt( inputField.getText() );
```

Any value typed into a `JTextField` is represented as a String.

Complete implementation of `src/Days.java`. Note the following features:
- The `Days` class is modeled after the `Math` class. It is declared `final`, which means that it cannot be extended (subclassed). And its constructor is declared `private`, which means that this class cannot be instantiated.
- To complete this class, you must define the `howManyDays(int)` method. This should be `public static` method that takes a single int parameter and returns an integer value.
- Since `howManyDays()` is defined as `static`, it is known as a class method (rather than an instance method). It is associated with the `Days` class itself rather than with any of its instances. Thus, to invoke this method (in a print statement), you would use the following reference:

```java
     System.out.println("There are " + Days.howManyDays(6)
         +" days") ...
```

This is similar to the way you would invoke the `Math.sqrt(25)` method.
It is not necessary to instantiate `Days` in your GUI application.

Complete implementation of `src/DaysTester.java`. This class only has a `main()` method. Its purpose is to test `Days` class by running through all the months 1 - 12 and print the corresponding number of days as reported by `Days` class.

Prior starting implementation, draw a UML diagram for the `MonthJFrame` and `Days` classes. 

**Reporting**

In the markdown file `DaysInMonth.md` add the UML class diagram you drew as an embedded image. Include a screenshot demonstrating successful execution and outputs of `DaysTester`. Include a screenshot of your final GUI and instructions for a new user to use it. 


# 2. Certificate of Deposit
**Problem Statement**

The goal is to solve Exercise 5.7 and 5.8 in Java, Java, Java 3e.

From Exercise 5.7:
A Certificate of Deposit (CD) is an investment instrument that accumulates interest at a given rate for an initial principal over a fixed number of years. The formula for compounding interest is shown in Table 5.11. It assumes that interest is compounded annually. For daily compounding, the annual rate must be divided by 365, and the compounding period must be multiplied by 365, giving: $a = p(1 + r/365)^{365n}$. Implement a `BankCD` class that calculates the maturity value of a CD.

From Exercise 5.8:
Design a command-line user interface to the `BankCD` class that lets the user input principal, interest rate, and years, and reports the CD’s maturity value with both yearly and daily compounding. Use `NumberFormat` objects to display percentages and dollar figures in an appropriate format. The program’s output should look something like the following:

```
 ************************ OUTPUT ********************
 Compare daily and annual compounding for a Bank CD.
  Input CD initial principal, e.g.  1000.55 > 2500
  Input CD interest rate, e.g.  6.5 > 7.8
  Input the number of years to maturity, e.g., 10.5 > 5
 For Principal = $2,500.00 Rate= 7.8% Years= 5.0
  The maturity value compounded yearly is $3,639.43
  The maturity value compounded daily is: $3,692.30
 ************************ OUTPUT ********************
```

**Specification**

A file `src/BankCD.java` is prepared. Elements of the `BankCD` class are outlined in the UML in Fig 5.11 in the book. Briefly:
- Three instance variables `principal`, `rate`, `years` of type double. 
- One constructor taking three parameters to initialize the corresponding instance variables. 
- Two public methods `calcYearly()` and `calcDaily()` returning yearly and daily compound principal for the duration as a double.

The command-line interface is to be implemented in the `run()` method of the `BankCDApp` class (see `src/BankCDApp.java`). This class uses `KeyboardReader` class (already present in `src/KeyboardReader.java`) to prompt, read input and display to standard input and output. Once the inputs are read, calculation is performed using and instance of `BankCD`. Note that `main()` needs to instantiate an object of the `BankCDApp` class and call its `run()` method.

Prior starting implementation, draw a UML diagram showing the relationships and details of `BankCD`, `BankCDApp` and `KeyboardReader` classes. 

**Reporting**

In the markdown file `CertificateOfDeposit.md` add the UML class diagram you drew as an embedded image. Include a screenshot demonstrating successful execution and outputs.

# Optional: Leap Year
The above version of the days in month program does not handle leap years. This is important, a leap year will come up soon.

Similar to `Days`, add a new class `Year` with one static method `isLeapYear(int)` returning `true ` if the year passed as argument is a leap year, `false` if not. A year is a leap year if it is evenly divisible by 4 but not evenly divisible by 100 unless it is also evenly divisible by 400. So 1996 was a leap year. But 1900 was not a leap year because, although it is divisible by 4, it is also divisible by 100 and not by 400. 2000 is a leap year because it is divisible by 400.

Add input elements and logic to the GUI to allow the user to enter the year in addition to the month, and report the correct number of days.

Please copy and rename any files you modify by adding `2` to the file name to not conflict with your initial files.

# Optional: Temperature GUI
Solve Exercise 5.2 in Java, Java, Java 3e.

Following the design for the GUI developed in Chapter 4, implement a GUI to use for testing the `Temperature` class. The GUI should have the layout shown in Figure 5.7.

# Optional: Robust Certificate of Deposit
The above version of the certificate of deposit application is not yet robust against a user entering wrong information. Most importantly, when asked for the principal, a user could enter some text (as string) causing the program to throw an exception. Furthermore, the program should make sure data entered is positive.

Re-design and enhance your program to guard against wrong user input. Please copy and rename any files you modify by adding `2` to the file name to not conflict with your initial files.
