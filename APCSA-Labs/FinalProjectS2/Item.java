import java.awt.Graphics;

public abstract class Item{
	private boolean visible;
	private boolean inInventory;
	private int x;
	private int y;
	public Item(){
		visible = true;
		inInventory = false; 
	}
	
	public abstract boolean checkCollision(Player p);

	public abstract void drawMe(Graphics g);
	
	
	public abstract void setX(int x);
	
	public abstract void setY(int y);
	
	public boolean checkVisible(){
		return visible;
	}
	public boolean checkInventory(){
		return inInventory;
	}
	public void setVisible(boolean a){
		visible = a;
	}
	public abstract void setInventory(boolean a);
}