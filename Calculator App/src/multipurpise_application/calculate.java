package multipurpise_application;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.plaf.metal.MetalComboBoxIcon;



import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JPanel;

public class calculate implements ActionListener, MouseListener {

	JFrame frame;

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

	// Initializing button arrays, label arrays, labels and buttons

	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton[] menuButtons = new JButton[3];


	//Function Buttons
	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, equButton, delButton, clrButton, negButton;

	//Menu Buttons
	JButton calcButton, convButton, settButton, extButton;



	// Initializing variables that will hold the entered/result values and the
	// operator sign

	double num1 = 0, num2 = 0, result = 0;
	char operator;
	JTextField textField;
	JLabel displayProgress;
	JPanel panel;
	JPanel panel2;

	// sidebar button

	private JButton sidebar;




	private void initialize() {


		// setting the frame size and metrics

		frame = new JFrame("Calculator");
		frame.setBackground(Color.WHITE);
		frame.setForeground(Color.WHITE);
		frame.setBounds(100, 100, 949, 634);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.white);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		//setting texfield size and metrics

		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setEditable(false);
		textField.setBounds(70, 72, 289, 46);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		//this label displays the first number the user uses

		displayProgress = new JLabel();
		displayProgress.setBounds(265, 129, 94, 29);
		displayProgress.setVisible(true);
		frame.getContentPane().add(displayProgress);

		//creating our function buttons

		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("x");
		divButton = new JButton("÷");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("⌫");
		clrButton = new JButton("Clr");
		negButton = new JButton("+/-");

		//adding our function buttons to the functionButtons array

		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;

		// Textfield, Button and Label fonts

		Font textfieldFont = new Font("Copperplate Gothic", Font.BOLD, 20);
		Font buttonFont = new Font("Copperplate Gothic", Font.BOLD, 20);
		Font labelFont = new Font("Copperplate Gothic", Font.ITALIC, 22);

		textField.setFont(textfieldFont);
		displayProgress.setFont(labelFont);

		//Sets the actionlistener and font for the function buttons

		for (int i = 0; i < 9; i++) {

			functionButtons[i].addActionListener(this);
			functionButtons[i].setFocusable(false);
			functionButtons[i].setContentAreaFilled(false);

			for (int z = 0; z < 6; z++) {

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


		// This panel will hold all the number buttons and operator buttons that the user will use to

		panel = new JPanel();
		panel.setLayout(new GridLayout(4, 4, 10, 10));
		panel.setBounds(20, 169, 392, 343);
		panel.setBackground(Color.white);
		frame.getContentPane().add(panel);


		//adding our buttons to our panel

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

		// This option button has a drop down menu which allows user to select different tools

		sidebar = new JButton("≡");
		sidebar.setBounds(-12, 11, 64, 52);
		sidebar.setFocusable(false);
		sidebar.setContentAreaFilled(false);
		sidebar.setFont(new Font("Copperplate Gothic", Font.BOLD, 17));
		sidebar.setBorder(BorderFactory.createEmptyBorder());          
		frame.getContentPane().add(sidebar);



		//This panel displays the sidebar that gives the user access to different tools and the settings button

		panel2 = new JPanel();
		panel2.setBounds(560, 34, 262, 546);
		panel2.setVisible(false);
		panel2.setBackground(Color.white);
		frame.getContentPane().add(panel2);
		panel2.setLayout(null);

		settButton = new JButton(new ImageIcon("media/img/settIcon2.png"));
		settButton.setBounds(10, 483, 67, 52);
		settButton.setContentAreaFilled(false);
		settButton.setBorderPainted(false);
		settButton.setFocusable(false);
		settButton.addMouseListener(this);
		panel2.add(settButton);

		extButton = new JButton(new ImageIcon("media/img/xButton.png"));
		extButton.setBounds(217, 11, 15, 15);
		extButton.setFont(buttonFont);
		extButton.setContentAreaFilled(false);
		extButton.setBorderPainted(false);
		extButton.setFocusable(false);
		extButton.addActionListener(this);
		panel2.add(extButton);





		calcButton = new JButton("Calculator");
		calcButton.setBounds(0, 108, 262, 44);

		convButton = new JButton("Currency Converter");
		convButton.setBounds(0, 187, 262, 44);

		menuButtons[0] = calcButton;
		menuButtons[1] = convButton;


		for(int i=0; i<2; i++) {

			panel2.add(menuButtons[i]);
			menuButtons[i].setVisible(true);
			menuButtons[i].setFocusable(false);
			menuButtons[i].setBorder(BorderFactory.createEmptyBorder());
			menuButtons[i].setBackground(Color.gray);
			menuButtons[i].addMouseListener(this);
		}



		// This action listener makes the contents on the frame nonvisible and makes the sidebar panel visible

		sidebar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// When the menu button is clicked, the panel that holds all the numbers and the rest of the frame are set to non visible


				panel.setVisible(false);
				textField.setVisible(false);
				panel2.setVisible(true);

				for(int i=6; i<9; i++) {

					functionButtons[i].setVisible(false); }

			} });


	}



	// This action listener allows the numbers and operators to show in the
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

		if (e.getSource() == negButton) {

			double Temp = Double.parseDouble(textField.getText());

			Temp *= -1;

			textField.setText(String.valueOf(Temp));
		}

		if (e.getSource() == clrButton) {

			textField.setText("");
			displayProgress.setText("");
		}

		if (e.getSource() == delButton) {

			String text = textField.getText();
			textField.setText("");

			for (int i = 0; i < text.length() - 1; i++) {

				textField.setText(textField.getText() + text.charAt(i));
			}
		}


		if(e.getSource() == extButton) {

			panel.setVisible(true);
			textField.setVisible(true);
			panel2.setVisible(false);

			for(int i=6; i<9; i++) {

				functionButtons[i].setVisible(true);
			}

		}


	}




	// This method changes the theme of the calculator



	public void darkMode() {


		frame.getContentPane().setBackground(Color.black);
		panel.setBackground(Color.DARK_GRAY);

		textField.setBackground(Color.black);

		textField.setForeground(Color.white);

		displayProgress.setForeground(Color.white);

		sidebar.setForeground(Color.white);

		for (int i = 0; i < 9; i++) {

			functionButtons[i].setForeground(Color.white); }

		for (int i = 0; i < 10; i++) {

			numberButtons[i].setForeground(Color.white);

		}

	}



	// MouseListeners for the buttons on the sidebar panel. 

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource() == settButton) {

			settButton.setIcon(new ImageIcon("media/gifs/settGif2.gif"));  

			settings sa = new settings();

			sa.frame.setVisible(true);

		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		for(int i=0; i<2; i++) {

			menuButtons[i].setBackground(Color.gray);
			menuButtons[i].setForeground(null);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

		for(int i=0; i<2; i++) {

			menuButtons[i].setBackground(Color.gray);
			menuButtons[i].setForeground(null);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource() == menuButtons[0]) {

			menuButtons[0].setBackground(Color.DARK_GRAY);
			menuButtons[0].setForeground(Color.white);
		}

		if(e.getSource() == menuButtons[1]) {

			menuButtons[1].setBackground(Color.DARK_GRAY);
			menuButtons[1].setForeground(Color.white);
		}

	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

		for(int i=0; i<2; i++) {

			menuButtons[i].setBackground(Color.gray);
			menuButtons[i].setForeground(null);
		}

	}
}
