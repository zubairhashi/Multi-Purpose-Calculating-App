import java.awt.EventQueue;
import java.awt.Font;
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
	JButton[] functionButtons = new JButton[9];

	JButton addButton, subButton, mulButton, divButton ;
	JButton decButton, equButton, delButton, clrButton, negButton;

	// Initializing variables that will hold the entered/result values and the
	// operator sign
	double num1 = 0, num2 = 0, result = 0;
	char operator;
	JTextField textField;
	JLabel displayProgress;
	JPanel panel;

	private void initialize() {

		// setting the frame size and metrics
		frame = new JFrame("Calculator");
		frame.setBackground(Color.WHITE);
		frame.setForeground(Color.WHITE);
		frame.setBounds(100, 100, 477, 644);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.white);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setEditable(false);
		textField.setBounds(70, 72, 289, 46);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		displayProgress = new JLabel();
		displayProgress.setBounds(265, 129, 94, 29);
		displayProgress.setVisible(true);
		frame.getContentPane().add(displayProgress);

		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("x");
		divButton = new JButton("÷");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("⌫");
		clrButton = new JButton("Clr");
		negButton = new JButton("+/-");


		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;

		//Textfield,Button, and Label fonts 
		
		Font textfieldFont = new Font("Copperplate Gothic",Font.BOLD,20);
		Font buttonFont = new Font("Copperplate Gothic",Font.BOLD,20);
		Font labelFont = new Font("Copperplate Gothic", Font.ITALIC,22);
		
		

		textField.setFont(textfieldFont);
		displayProgress.setFont(labelFont);
		
		for (int i = 0; i < 9; i++) {

			functionButtons[i].addActionListener(this);
			functionButtons[i].setFocusable(false);
			functionButtons[i].setContentAreaFilled(false);
			

			
			for(int z=0; z<6; z++) {
				
				functionButtons[z].setFont(buttonFont);
			}
			
		}

		for (int i = 0; i < 10; i++) {

			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFocusable(false);
			numberButtons[i].setContentAreaFilled(false);
			numberButtons[i].setFont(buttonFont);

		}

		// sets the bounds and visibilty for the delete and clear buttons

		delButton.setBounds(369, 72, 82, 46);
		delButton.setFont(textfieldFont);
		delButton.setVisible(true);
		frame.getContentPane().add(delButton);

		clrButton.setBounds(225, 534, 82, 46);
		clrButton.setFont(textfieldFont);
		clrButton.setVisible(true);
		frame.getContentPane().add(clrButton);

		negButton.setBounds(79, 534, 82, 46); 
		negButton.setFont(textfieldFont);
		negButton.setVisible(true);
		frame.getContentPane().add(negButton);




		// This panel will hold all the number buttons and operator buttons that the
		// user will use to

		panel = new JPanel();
		panel.setLayout(new GridLayout(4, 4, 10, 10));
		panel.setBounds(20, 169, 392, 343);
		panel.setBackground(Color.white);
		frame.getContentPane().add(panel);

	
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
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
			displayProgress.setText(String.valueOf(num1) + " +");
			
		}

		if (e.getSource() == subButton) {

			num1 = Double.parseDouble(textField.getText());
			operator = '-';
			textField.setText("");
			displayProgress.setText(String.valueOf(num1) + " -");
		}

		if (e.getSource() == mulButton) {

			num1 = Double.parseDouble(textField.getText());
			operator = '*';
			textField.setText("");
			displayProgress.setText(String.valueOf(num1) + " x");
		}

		if (e.getSource() == divButton) {

			num1 = Double.parseDouble(textField.getText());
			operator = '/';
			textField.setText("");
			displayProgress.setText(String.valueOf(num1) + " ÷");
			
		}

				
		
		
		
		if (e.getSource() == equButton) {

			num2 = Double.parseDouble(textField.getText());
			displayProgress.setText("");

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

		if(e.getSource() == negButton) {

			double Temp = Double.parseDouble(textField.getText());

			Temp*= -1;

			textField.setText(String.valueOf(Temp));
		}

		if (e.getSource() == clrButton) { 

			textField.setText("");
			displayProgress.setText("");
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
