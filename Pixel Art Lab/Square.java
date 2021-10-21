


import java.awt.Graphics;
import java.awt.Color;

public class Square{
	private int red;
	private int green;
	private int blue;

	public Square(int r, int g, int b){
		red = r;
		green = g;
		blue = b;
	}

	public void drawMe(Graphics g, int x, int y){
		//draw the filled box
		g.setColor(new Color(red, green, blue));
		g.fillRect(x,y,50,50);

		//draw the borders
		g.setColor(Color.black);
		g.drawRect(x,y,50,50);

	}

	public void changeColor(int r, int g, int b){
		red = r;
		green = g;
		blue = b;
	}

	public int getRed(){
		return red;
	}

	public int getGreen(){
		return green;
	}

	public int getBlue(){
		return blue;
	}

	public void reset(){
		changeColor(255,255,255);
	}

}
