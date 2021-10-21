import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Card {
	private int value;
	private String name;
	private String suit;
	private BufferedImage hearts;
	private BufferedImage spades;
	private BufferedImage diamonds;
	private BufferedImage clubs;


	public Card(int value, String name, String suit){
		this.value = value;
		this.name = name;
		this.suit = suit;

		if(suit.equals("hearts")){
			try{
				hearts = ImageIO.read(new File("images/hearts.png"));
			} catch ( IOException e){
				System.out.println(e);
			}
		}
		if(suit.equals("diamonds")){
			try{
				diamonds = ImageIO.read(new File("images/diamonds.png"));
			} catch ( IOException e){
				System.out.println(e);
			}
		}
		if(suit.equals("spades")){
			try{
				spades = ImageIO.read(new File("images/spades.png"));
			} catch ( IOException e){
				System.out.println(e);
			}
		}
		if(suit.equals("clubs")){
			try{
				clubs = ImageIO.read(new File("images/clubs.png"));
			} catch ( IOException e){
				System.out.println(e);
			}
		}
	}

	public int getValue(){
		return value;
	}



	public void drawMe(Graphics g, int x, int y){
		g.setColor(Color.white);
		g.fillRect(x, y, 120, 150);
		g.setColor(Color.black);
		g.drawRect(x, y, 120, 150);

		Font font = new Font("Arial", Font.PLAIN, 50);
		g.setFont(font);
		if(suit.equals("hearts")){
			g.setColor(Color.red);
			g.drawString(name, x + 30, y + 100);

			g.drawImage(hearts, x+2 , y, null);
		}
		if(suit.equals("spades")){
			g.setColor(Color.black);
			g.drawString(name, x + 30, y + 100);

			g.drawImage(spades, x+2 , y, null);
		}
		if(suit.equals("diamonds")){
			g.setColor(Color.red);
			g.drawString(name, x + 30, y + 100);

			g.drawImage(diamonds, x+2 , y, null);
		}
		if(suit.equals("clubs")){
			g.setColor(Color.black);
			g.drawString(name, x + 30, y + 100);

			g.drawImage(clubs, x+2 , y, null);
		}


	}
}
