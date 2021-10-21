import java.awt.Graphics;
import java.awt.Color;
 
 
public class SlotMachine {
	
	int num1;
	int num2;
	int num3;
	private int balance;
	private int bet;
	private int winnings;
	int action = 0;
	
	public SlotMachine(){
		num1 = 0;
		num2 = 0;
		num3 = 0;
		balance = 100;
		
	}
	
	public void drawMe(Graphics g){
		//colors
		Color blue = new Color(0,0,255);
		Color white = new Color(255,255,255);
		//draw slot machine
		g.setColor(blue);
		g.fillRect(100,100,200,400);
		//draw numbers
		g.setColor(white);
		g.drawString(num1+ " | ", 150, 150);
		g.drawString(num2 + " | ", 200, 150);
		g.drawString(num3 + " | ", 250, 150);
		g.drawString("Balance: " + balance, 150, 400);
	}
	
	public void play(){
		if (action == 1){
		num1 = (int)(Math.random()*9+1);
		num2 = (int)(Math.random()*9+1);
		num3 = (int)(Math.random()*9+1);
		if (num1 == 7 && num2 == 7 && num3 == 7){
			winnings = bet * 100;
			action = 0;
		}
		else if (num1==num2 && num2==num3){
			winnings = bet * 5;
			action = 0;
		}
		else if (num1==num2 || num1==num3 || num2==num3){
			winnings = bet * 2;
			action = 0;
		}
		else{
			winnings = 0;
			action = 0;
		}
		balance = balance + winnings;
		}	
	}
		
	
	public void bet(int b){
		if(balance >=b && action == 0){
		bet = b;
		balance = balance - bet;
		action = 1;
		}
		else{}
		
	}
}
