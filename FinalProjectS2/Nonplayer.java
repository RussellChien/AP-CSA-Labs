import java.awt.Graphics;

public abstract class Nonplayer{
	private int x;
	private int y;
	private boolean contact; 
	public Nonplayer(){
		contact = false;
	}
	public abstract boolean checkCollision(Player p);

	public abstract void drawMe(Graphics g);
	
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
	public abstract boolean checkContact();
	
	public abstract void setContact(boolean a);
	
}