package multipurpise_application;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;

public class settings implements ActionListener {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					settings window = new settings();
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
	public settings() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	//Initializing togglebuttons
	JToggleButton[] toggleButtons = new JToggleButton[2];

	//Togglebuttons
	JToggleButton onButton, offButton;

	
	calculate c = new calculate();


	public void initialize() {

		//calculator object to call darkMode method

		

		// setting the frame size and metrics

		frame = new JFrame();
		frame.setBounds(100, 100, 470, 693);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		//setting ON and OFF togglebuttons

		onButton = new JToggleButton("ON");
		onButton.setBounds(112, 287, 93, 46);
		frame.getContentPane().add(onButton);

		offButton = new JToggleButton("OFF");
		offButton.setBounds(263, 287, 93, 46);
		frame.getContentPane().add(offButton);

		//adding the togglebuttons to our toggleButtons array

		toggleButtons[0] = onButton;
		toggleButtons[1] = offButton;


		//creating a new button group so that only one togglebutton could be 
		//selected at once

		ButtonGroup b = new ButtonGroup();

		for(int i=0; i<2; i++) {

			toggleButtons[i].addActionListener(this);
			b.add(toggleButtons[i]);
		}

	}

	//actionlisteners for the togglebuttons (calls darkmode method in calculate class)

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub



		if(e.getSource() == onButton) {

			c.darkMode();

		}

		if(e.getSource() == offButton) {


		}
	}

}
