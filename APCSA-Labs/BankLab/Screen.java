import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Screen extends JPanel implements ActionListener{

	private Bank c1;
	private Bank c2;
	private Bank c3;
	private JTextField pinInput;
	private JButton checkPinButton;
	private JTextField input;
	private JButton deposit;
	private JButton withdraw;
	private JButton signout;
	private JTextField nameInput;
	private JButton updatename;

	private int correct = 0;

	public Screen(){
		setLayout(null);


		c1 = new Bank("John", 100.99, 1234);
		c2 = new Bank("Jen", 1000.01, 4321);
		c3 = new Bank("Jerry", 50.50, 1111);
		//create the textfield
		pinInput = new JTextField();
		pinInput.setBounds(50, 300, 100, 30);
		add(pinInput);

		checkPinButton = new JButton("Login");
		checkPinButton.setBounds(50, 350, 100, 30);
		checkPinButton.addActionListener(this);
		add(checkPinButton);

		input = new JTextField();
		input.setBounds(250, 300, 250, 30);
		add(input);

		deposit = new JButton("Deposit");
		deposit.setBounds(250, 350, 100, 30);
		deposit.addActionListener(this);
		add(deposit);

		withdraw = new JButton("Withdraw");
		withdraw.setBounds(400, 350, 100, 30);
		withdraw.addActionListener(this);
		add(withdraw);

		signout = new JButton("Sign out");
		signout.setBounds(50, 400, 100, 30);
		signout.addActionListener(this);
		add(signout);

		updatename = new JButton("Update name");
		updatename.setBounds(50, 500, 150, 30);
		updatename.addActionListener(this);
		add(updatename);

		nameInput = new JTextField();
		nameInput.setBounds(50, 450, 150, 30);
		add(nameInput);

		setFocusable(true);
	}

	public Dimension getPreferredSize(){
		return new Dimension(600, 600);
	}

	public void paintComponent (Graphics g){
		super.paintComponent(g);
		Color background = new Color(0, 0, 139);
		Color black = new Color(0,0,0);
		Color blue = new Color(65,105,225);
		Color white = new Color(255,255,255);
		Color yellow = new Color(255, 255, 0);
		Color grey = new Color(192, 192, 192);
		g.setColor(grey);
		g.fillRect(0, 0, 600, 100);
		g.setColor(blue);
		g.drawString("ATM", 290, 50);
		g.setColor(background);
		g.fillRect(0, 100, 600, 500);
		g.setColor(yellow);
		g.fillRect(50, 0, 50, 50);
		g.fillRect(500, 0, 50, 50);
		g.setColor(white);
		g.drawString("Card", 275, 500);
		g.drawString("Cash", 475, 500);
		g.setColor(grey);
		g.fillRect(250, 500, 100, 30);
		g.fillRect(450, 500, 100, 30);
		g.setColor(black);
		g.fillRect(255, 505, 80, 15);
		g.fillRect(455, 505, 80, 15);
		if (correct == 0){
			g.setColor(white);
			g.drawString("Name: " + c1.getName(), 50, 200);
			g.drawString("Balance : " + c1.getBalance(), 50, 220);
			g.drawString("Enter in the amount you want to deposit or withdraw", 250, 250);
			g.drawString("Enter in your pin", 50, 290);
		}
		if (correct == 1){
			g.setColor(white);
			g.drawString("Name: " + c1.getName(), 50, 200);
			g.drawString("Balance : " + c1.getBalance(), 50, 220);
			g.drawString("Enter in the amount you want to deposit or withdraw", 250, 250);

		}
		if (correct == 2){
			g.setColor(white);
			g.drawString("Name: " + c2.getName(), 50, 200);
			g.drawString("Balance : " + c2.getBalance(), 50, 220);
			g.drawString("Enter in the amount you want to deposit or withdraw", 250, 250);
		}
		if (correct == 3){
			g.setColor(white);
			g.drawString("Name: " + c3.getName(), 50, 200);
			g.drawString("Balance : " + c3.getBalance(), 50, 220);
			g.drawString("Enter in the amount you want to deposit or withdraw", 250, 250);
		}

	}

	public void actionPerformed(ActionEvent e){
		if (e.getSource() == checkPinButton){
			//get the pin from the textfield
			String pinText = pinInput.getText();
			int pin = Integer.parseInt(pinText);
			//check to see if the pin is correct
			if (pin == 1234){
				correct = 1;
				c1.checkPin(pin);
			}
			if (pin == 4321){
				correct = 2;
				c2.checkPin(pin);
			}
			if (pin == 1111){
				correct = 3;
				c3.checkPin(pin);
			}
		}
		if (e.getSource() == deposit){
			String depositText = input.getText();
			double deposit = Double.parseDouble(depositText);
			if (correct == 1){
				c1.deposit(deposit);
			}
			if (correct == 2){
				c2.deposit(deposit);
			}
			if (correct == 3){
				c3.deposit(deposit);
			}

		}

		if (e.getSource() == withdraw){
			String withdrawText = input.getText();
			double withdraw = Double.parseDouble(withdrawText);
			if (correct == 1){
				c1.withdraw(withdraw);
			}
			if (correct == 2){
			c2.withdraw(withdraw);
			}
			if (correct == 3){
			c3.withdraw(withdraw);
			}


		}

		if (e.getSource() == signout){
			c1.disableAccess();
			c2.disableAccess();
			c3.disableAccess();
			correct = 0;
		}
		if (e.getSource() == updatename){
			String nameText = nameInput.getText();
			String name = nameText;
			c1.updateName(name);
			if (correct == 1){
				c1.updateName(name);
			}
			if (correct == 2){
				c2.updateName(name);
			}
			if (correct == 3){
				c3.updateName(name);
			}
		}


		repaint(); //redraw the screen
	}


}
