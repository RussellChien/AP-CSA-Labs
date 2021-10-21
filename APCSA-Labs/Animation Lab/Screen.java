
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension; 
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;


 
public class Screen extends JPanel implements MouseListener {
	
	int sunX;
	int sunY;
	int carX;
	int carY;
	int aX; int aY; int bX; int bY; int cX; int cY; int dX; int dY; int eX; int eY;
	private String notificationText;

    
	public Screen(){
		sunX = 100;
		sunY = 300;
		carX = 700;
		carY = 450;
		aX = 110;
		aY = 350;
		bX = 90;
		bY = 365;
		cX = 100;
		cY = 300;
		dX = 110;
		dY = 315;
		eX = 134;
		eY = 315;
		notificationText = "";
        addMouseListener(this);
	}
	
    public Dimension getPreferredSize(){
        return new Dimension(800,600);
    }
     
    public void paintComponent(Graphics g){
        super.paintComponent(g);
		//colors
		Color yellow = new Color(255,255,0);
		Color green = new Color(0,255,0);
		Color sky = new Color(51, 153, 253);
		Color ground = new Color(255,255, 153);
		Color white = new Color(255,255,255);
		Color lightbrown = new Color(153, 76, 0);
		Color red = new Color(255,0,0); 
		Color black = new Color(0,0,0);
		Color orange = new Color(255,165,0);
		Color tan = new Color(255,190,153);
		//draw ground
		g.setColor(ground);
		g.fillRect(0, 300, 800, 300);
		//draw sky
		g.setColor(sky);
		g.fillRect(0, 0, 800, 300);
		g.setColor(white);
        g.fillOval(200,100,70,40);
		g.fillOval(220,110, 100,60);//cloud1
        g.fillOval(400,95,70,40);
        g.fillOval(420,70,100,60);//cloud2
        g.fillOval(600,120,80,40);
       	g.fillOval(620,125,100,70);//cloud3
		//draw grass
		int grassX = 100;
		while(grassX < 700){
			g.setColor(green);
			g.fillRect(grassX,400,5,20);
			
			grassX = grassX + 10;
		}
		//draw forest
		int forestX = 500;
		while(forestX<800){
			g.setColor(lightbrown);
			g.fillRect(forestX, 250, 10, 50);
			g.setColor(green);
			g.fillOval(forestX - 35, 200, 75, 75);
			forestX = forestX + 50;
		}
		//draw UFO
		g.setColor(black);
		g.fillOval(sunX,sunY,50,50);
		g.fillRect(sunX-20, sunY+20, 60, 20);
		g.fillRect(sunX+10, sunY+20, 60, 20);
		
		
		//draw car
		g.setColor(red);
		g.fillRect(carX, carY, 75, 50);
		g.fillRect(carX-20, carY + 25, 25, 25);
		g.fillRect(carX+75, carY + 25, 25, 25);
		g.setColor(black);
		g.fillOval(carX - 20, carY + 50, 25, 25);
		g.fillOval(carX + 75, carY + 50, 25, 25);
		
		//draw person
		 g.setColor(orange);
		 g.fillRect(aX, aY, 40,70);
         g.fillRect(bX, bY, 80,20);
         g.setColor(tan);
         g.fillOval(cX, cY, 60,60);
		 g.setColor(black);
         g.fillOval(dX, dY, 20,20);
         g.fillOval(eX, eY, 20,20);
	}

	public void animate(){
			while (true){
				
				sunX++;
				if (sunX > 400){
					sunY++;
				}
				else{
				sunY--;
				}
				if (sunX > 800){
					
					sunX = 0;
					sunY = 300;
				}
				carX--;
				if(carX < 0){
					carX = 800;
				}
				
				
						
				

				//slow it down (wait)
				try{
					Thread.sleep(5); //millisecond
				}
				catch(InterruptedException ex){
					Thread.currentThread().interrupt();
				}
				
				//redraw the screen
				repaint();
			}
	}
			
			
	public void mousePressed(MouseEvent e) {
 
        //Print location of x and y
        System.out.println("X: " + e.getX() + ", Y: " + e.getY());
		
 
        //Check if mouse pressed position is in the brown box
        if (e.getX() >= bX && e.getX() <= eX+70 && e.getY() >= cY && e.getY() <= bY+70) {
            notificationText = "You clicked on the person";
			System.out.println(notificationText);
            aX = aX + 10;
        	bX = bX + 10;
        	cX = cX + 10;
        	dX = dX + 10;
        	eX = eX + 10;
        	if (aX > 800 || bX > 800 || cX > 800 || dX > 800 || eX> 800){
        	aX = 110;
			aY = 350;
			bX = 90;
			bY = 365;
			cX = 100;
			cY = 300;
			dX = 110;
			dY = 315;
			eX = 134;
			eY = 315;
        	}
        } else {
            notificationText = "";
        }
 
        repaint();
    }
    

 
    public void mouseReleased(MouseEvent e) {}
 
    public void mouseEntered(MouseEvent e) {}
 
    public void mouseExited(MouseEvent e) {}
 
    public void mouseClicked(MouseEvent e) {}
}



