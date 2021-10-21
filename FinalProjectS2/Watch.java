import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class Watch extends Item{
	private BufferedImage itemImg;
	private int x;
	private int y;
	private int width;
	private int height;
	private boolean visible;
	private boolean inInventory;
	public Watch(){
		visible = true;
		inInventory = false; 
		x = 300;
		y = 300;
		try {
            itemImg = ImageIO.read(new File("images/watch.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        width = itemImg.getWidth();
        height = itemImg.getHeight();
	}
	
	public boolean checkCollision(Player p){
		if(visible){
			int pX = p.getX();
			int pY = p.getY();
			int pWidth = p.getWidth();
			int pHeight = p.getHeight();
			if(pX + pWidth >= x && pX <= x + width && pY + pHeight >= y && pY<= y + height){
				visible = false; 
				return true; 
			}
		}
		
		return false;
		
	}
	public void drawMe(Graphics g){
		if(visible){
			g.drawImage(itemImg, x, y, null);
		}
		else if(inInventory){
			g.drawImage(itemImg, x, y, null);
		}

	}
	public void setInventory(boolean a){
		inInventory = a;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
}



