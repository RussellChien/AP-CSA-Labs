import java.awt.Color;
import java.awt.Graphics;

public class Ship{
    private int x;
    private int y;

    private int width;
    private int height;

    private Color grey;

    public Ship(int x, int y){

        this.x = x;
        this.y = y;

        this.width = 50;
        this.height = 50;

        this.grey = new Color(211,211,211);
    }





    public void drawMe(Graphics g){
        g.setColor(grey);
        g.fillRect(x,y,width,height);
		g.setColor(Color.black);
		g.fillRect(x+10,y+10, width-10, height - 20);
		g.setColor(Color.red);
		g.fillOval(x-15,y-20,width+10,height-30);
		g.fillOval(x-15,y+45,width+10,height-30);

    }

    public void moveUp(){
        y = y - 20;
    }


    public void moveDown(){
        y = y + 20;
    }

    public int getX(){
        return x;
    }


    public int getY(){
        return y;
    }



}
