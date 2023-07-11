import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPanel;

public class calculate implements ActionListener {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculate window = new calculate();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public calculate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	// Initializing button arrays and buttons

	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[8];

	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, equButton, delButton, clrButton;

	// Initializing variables that will hold the entered/result values and the
	// operator sign
	double num1 = 0, num2 = 0, result = 0;
	char operator;
	JTextField textField;
	JPanel panel;

	private void initialize() {

		// setting the frame size and metrics
		frame = new JFrame("Calculator");
		frame.setBounds(100, 100, 477, 644);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(70, 72, 289, 46);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		mulButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Delete");
		clrButton = new JButton("Clear");

		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;

		for (int i = 0; i < 8; i++) {

			functionButtons[i].addActionListener(this);
			functionButtons[i].setFocusable(false);

		}

		for (int i = 0; i < 10; i++) {

			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFocusable(false);

		}

		// sets the bounds and visibilty for the delete and clear buttons

		delButton.setBounds(72, 544, 130, 35);
		delButton.setVisible(true);
		frame.getContentPane().add(delButton);

		clrButton.setBounds(246, 544, 130, 35);
		clrButton.setVisible(true);
		frame.getContentPane().add(clrButton);

		// This panel will hold all the number buttons and operator buttons that the
		// user will use to

		panel = new JPanel();
		panel.setLayout(new GridLayout(4, 4, 10, 10));
		panel.setBounds(70, 176, 289, 347);
		frame.getContentPane().add(panel);

		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);

	}

	// This action listener will allow the numbers and operators to show in the
	// textfield

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		for (int i = 0; i < 10; i++) {

			if (e.getSource() == numberButtons[i]) {

				textField.setText(textField.getText().concat(String.valueOf(i)));

			}

		}

		if (e.getSource() == addButton) {

			num1 = Double.parseDouble(textField.getText());
			operator = '+';
			textField.setText("");
		}

		if (e.getSource() == subButton) {

			num1 = Double.parseDouble(textField.getText());
			operator = '-';
			textField.setText("");
		}

		if (e.getSource() == mulButton) {

			num1 = Double.parseDouble(textField.getText());
			operator = '*';
			textField.setText("");
		}

		if (e.getSource() == divButton) {

			num1 = Double.parseDouble(textField.getText());
			operator = '/';
			textField.setText("");
		}

		if (e.getSource() == equButton) {

			num2 = Double.parseDouble(textField.getText());

			// This switch statement determines which operation the user is using

			switch (operator) {

			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				result = num1 / num2;
				break;

			}

			textField.setText(String.valueOf(result));
			num1 = result;
		}

		if (e.getSource() == clrButton) {

			textField.setText("");
		}


		if (e.getSource() == delButton) {

			String text = textField.getText();
			textField.setText("");
			
			
			for(int i=0; i<text.length()-1;i++) {
			
				textField.setText(textField.getText()+text.charAt(i));
			}
		}

	
		
		
	}


}
