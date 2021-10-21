import java.awt.Color;
import java.awt.Graphics;

public class Enemy{
    private int x;
    private int y;

    private int width;
    private int height;

    private Color green;
	  private boolean visible;
	  private boolean alive;

    public Enemy(int x, int y){

        this.x = x;
        this.y = y;

        this.width = 50;
        this.height = 50;

        this.green = new Color(0,255,00);
        this.visible = true;
    }



    public void drawMe(Graphics g){

		    if(visible){
			      alive = true;
			      g.setColor(Color.red);
			      g.fillOval(x,y,width,height);
			      g.setColor(Color.white);
			      g.fillOval(x+10, y+10, width-20,height-20);
			      g.setColor(Color.black);
			      g.fillOval(x+20,y+20,width-40,height-40);
        	}
      }


	public boolean checkCollision(Projectile p){
		if(visible){
			//check collision with the projectile
			//if there is a collisoin, make the enemy disappear
			int pX = p.getX();
			int pY = p.getY();
			int pWidth = p.getWidth();
			int pHeight = p.getHeight();

			if(pX + pWidth >= x && pX <= x + width && pY + pHeight >= y &&pY<= y + height){
				visible = false;
				alive = false;
				return true;

			}
		}

		return false;

	}


    public void move(){

		y++;
		if(y>750){
			y = 0;
		}

	}
	public void moveleft(){
		x = x - 2;
	}
	public void subtract1fromy(){
		y--;
	}
	public void moveleft2(){
		x = x-4;
	}

	public void add1toy(){
		y++;
	}

	public int getY(){
		return y;
	}
	public int getX(){
		if(alive == true){
		return x;
		}
		else
		return 800;
	}




}
