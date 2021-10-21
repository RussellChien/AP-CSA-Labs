import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class Mom extends Nonplayer{
	private BufferedImage momImg;
	private int x;
	private int y;
	private int width;
	private int height;
	private boolean contact; 
	public Mom(){
		super();
		x = 700; 
		y = 500;
		contact = false;
		try {
            momImg = ImageIO.read(new File("images/mom.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        width = momImg.getWidth();
        height = momImg.getHeight();
	}
	
	public boolean checkCollision(Player p){
		if(!contact){
			int pX = p.getX();
			int pY = p.getY();
			int pWidth = p.getWidth();
			int pHeight = p.getHeight();
			if(pX + pWidth >= x && pX <= x + width && pY + pHeight >= y && pY<= y + height){
				contact = false; 
				return true; 
			}
		}
		
		return false;
		
	}
	
	public void drawMe(Graphics g){
		g.drawImage(momImg, x, y, null);
	}
	public boolean checkContact(){
		return contact;
	}
	
	public void setContact(boolean a){
		contact = a;
	}

		
	
}