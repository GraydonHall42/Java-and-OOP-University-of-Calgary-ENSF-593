import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 
 * Partial implementation of the Stats GUI
 *
 * @author Graydon Hall
 */
public class StatsGUI extends JFrame implements ActionListener {
	private JLabel prompt = new JLabel("Next Grade (press ENTER)");
	private JTextField inField;
	private JTextArea display;
	private JButton reset, displayStats;


	/**
	 * Stats object is used to hold grades, and calculate stats based on grades provided by the user.
	 */
	private Stats stats;

	public StatsGUI(String title) { 

		stats = new Stats();  // instantiate stats object
		
		inField = new JTextField(4);
		inField.addActionListener(this);
		
		display = new JTextArea("", 5, 20);
		
		reset = new JButton("RESET");
		reset.addActionListener(this);
		
		displayStats = new JButton("STATS");
		displayStats.addActionListener(this);

		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(0, 2));
		inputPanel.add(prompt);
		inputPanel.add(inField);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(0, 2));
		buttonPanel.add(displayStats);
		buttonPanel.add(reset);

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add("North", inputPanel);
		contentPane.add("Center", display);
		contentPane.add("South", buttonPanel);

		setSize(500, 200);
		setTitle(title);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == inField) {  // user enters a grade
			int number = Integer.parseInt(inField.getText());  // parse int from grade
			stats.add(number);  // add grade to stats object
			inField.setText("");  // reset text so user can enter another grade
		}
		else if (e.getSource() == displayStats){  // user preses STATS button
			display.setText(stats.toString());  // sorted grades, mean, and median are printed to user.
		}
		else if (e.getSource() == reset){  // RESET button is pressed
			stats = new Stats();  // old stats object is cleared and replaced with new one
			display.setText("");  // old stats are cleared from display area.
		}
	}

	public static void main(String[] args) {
		new StatsGUI("Mean and median");
	}
}
