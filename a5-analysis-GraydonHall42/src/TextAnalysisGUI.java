import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * GUI where a user provides text to be analyzed, and the number of words and sentences in the text are calculated.
 * @author Graydon Hall
 *
 */
public class TextAnalysisGUI extends JFrame implements ActionListener {
	private JLabel prompt;  // prompt for user
	private JLabel outputMessage;  // prompt for user
	private JTextArea inField;  // input field
	private JTextArea display;  // area to display results
	private JButton bClear, bAnalyze;  // buttons to clear the results, and analyze the text
	private TextAnalyzer analyzer;  // object used to analyze the text
	private JScrollPane scrollableInput;  // creates scrollable area when text overflows the given area.


	/**
	 * Constructs the Text Analysis, setting up all the elements.
	 */
	public TextAnalysisGUI() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // ends program when frame is closed


		// Labels
		var labelSize = new Dimension(500,25);  // desired size for labels
		prompt = new JLabel("Enter text to be analyzed");  // prompt for user
		outputMessage = new JLabel("Output Results");  // prompt for user
		prompt.setPreferredSize(labelSize);
		outputMessage.setPreferredSize(labelSize);

		// Input area
		inField = new JTextArea("", 7, 20);
		scrollableInput = new JScrollPane (inField,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// Display results area
		display = new JTextArea("", 5, 20);

		// Buttons
		bClear = new JButton("CLEAR");
		bClear.addActionListener(this);
		bAnalyze = new JButton("ANALYZE");
		bAnalyze.addActionListener(this);

		// Panel for user input area
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new BorderLayout());
		inputPanel.add("North", prompt);
		inputPanel.add("Center", scrollableInput);

		// Panel used to display output
		JPanel outputPanel = new JPanel();
		outputPanel.setLayout(new BorderLayout());
		outputPanel.add("North", outputMessage);
		outputPanel.add("Center", display);

		// Panel to hold buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(0, 2));
		buttonPanel.add(bAnalyze);
		buttonPanel.add(bClear);

		// add our panels to content pane.
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add("North", inputPanel);
		contentPane.add("Center", outputPanel);
		contentPane.add("South", buttonPanel);

		// set size of GUI
		setSize(500, 350);
		setTitle("Text Analyzer GUI");
		setVisible(true);
	}

	/**
	 * Method used to handle events triggered by buttons being pressed.
	 * @param e event which triggers method
	 */
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == bAnalyze){  // analyze button
			analyzer = new TextAnalyzer(inField.getText());  // analyze text, getting word and sentence count
			display.setText(analyzer.toString());
		}
		else if (e.getSource() == bClear){  // clear button is pressed
			// clear input and output area
			inField.setText("");
			display.setText("");
		}
	}

	/**
	 * Main method used to instantiate our GUI
	 * @param args
	 */
	public static void main(String[] args) {
		TextAnalysisGUI textGUI = new TextAnalysisGUI();
	}
}