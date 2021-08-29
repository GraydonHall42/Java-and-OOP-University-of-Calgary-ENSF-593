import javax.swing.*; 
import java.awt.*;
import java .awt. event .*;

/**
 * A graphical user interface which takes a user entry for the index of a month, and returns how many days
 * are in that month.
 * @author Graydon Hall
 */
public class MonthJFrame extends JFrame implements ActionListener{

	/**
	 * a field used to obtain user input of what month they are interested in
	 */
	private JTextField inputField;

	/**
	 * display area used to display the number of days in the selected month.
	 */
	private JTextArea display;

	/**
	 * Constructs a graphical user interface where a user can enter the index of a month,
	 * and determine how many days are in that month.
	 * @param title the title of the frame
	 */
	public MonthJFrame(String title)  {
		JLabel prompt = new JLabel("Input a month between 1 and 12 and press return:");  // prompt for user
	
		inputField = new JTextField(10); // space for user input
		inputField.setText("0");  // default value of zero
		inputField.addActionListener( this ); // enables GUI to update when enter button is pressed in input field.
		
		display = new JTextArea (1 ,30);  // area for number of days in month to be displayed.
		
		JPanel panel = new JPanel();  // panel to hold input field and prompt together.
		panel.setLayout(new GridLayout(0,2));  // set so it uses gridlayout
		panel.add(prompt);
		panel.add(inputField);
		
		Container contentPane = getContentPane();  // return content pane of window
		contentPane.setLayout(new BorderLayout());  // use BorderLayout manager
		
		contentPane.add("Center", panel);  // add panel with input and prompt in center
		contentPane.add("South", display);  // add display that shows days in month below that
		
		setTitle(title);  // set window title based on user supplied value
		setSize( 350, 150 );  // window size
		pack();  // pack everything nicely to achieve good formatting
		setVisible(true);  // set window visibility to true.
	
	}

	/**
	 * When user hits enter button after selecting a month, this method is triggered,
	 * the days in the specified month is calculated, and displayed to the user
	 * @param evt the event which our GUI picked up
	 */
	public void actionPerformed(ActionEvent evt)  {
		if ( evt.getSource() == inputField) { // if the action event was enter button being pressed in input field.
			//convert user input to an integer
			int number = Integer.parseInt(inputField.getText());
			int days = Days.howManyDays(number);  // number of days in the month
			
			//TODO: update display with number chosen and days calculated
			display.setText(Integer.toString(days));  // display results to user.
			
		}
	}
	
	public static void main(String[] args) {
		
		//Starting the GUI application
		new MonthJFrame("Days in month");  // title of frame

	}

}
