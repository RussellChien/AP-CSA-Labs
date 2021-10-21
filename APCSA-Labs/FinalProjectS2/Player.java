import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class Player{
	
	private int x;
	private int y;
	private int width;
	private int height;
	private BufferedImage playerImg;
	
	public Player(){
		x = 100;
		y = 500;
		
		try {
            playerImg = ImageIO.read(new File("images/character.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        width = playerImg.getWidth();
        height = playerImg.getHeight();
	}
	
	public void drawMe(Graphics g){
		g.drawImage(playerImg, x, y, null);
    	} 
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height; 
	}
	public void moveUp(){
		y-=20;
	}
	public void moveDown(){
		y+=20;
	}
	public void moveLeft(){
		x-=20;
	}
	public void moveRight(){
		x+=20;
	}
}


