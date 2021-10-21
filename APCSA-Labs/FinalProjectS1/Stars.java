import java.awt.Color;
import java.awt.Graphics;
public class Stars{

     private int x;
	 private int y;
	 private Color white;

	 public Stars(){
		x = (int)(Math.random() * 800);
		y = (int)(Math.random() * 600);
		white = new Color(255,255,255);
	 }

	 public void drawMe(Graphics g){
		 g.setColor(white);
		 g.fillRect(x,y,2,5);
	 }
	 public void move(){
		 x = x-2;

		 if( x < 0){
			 x = 800;
			 y = (int)(Math.random() * 800);

		 }
	 }
}
