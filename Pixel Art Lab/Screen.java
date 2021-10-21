import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.*;
import javax.swing.*;
import java.io.*;
 
 
public class Screen extends JPanel implements ActionListener, MouseListener{
     
	private Square[][] grid;
	private Square[][] colors;
	private JButton reset;
	private JButton save;
	private int red;
	private int green;
	private int blue;
	private boolean color;
	private boolean draw; 
	private BufferedImage myImage;
	
	public Screen(){
		grid = new Square[10][10]; 
		for(int r = 0; r < grid.length; r++){
			for(int c = 0; c < grid[r].length; c++){
				grid[r][c] = new Square(255,255,255);
			}
		}
		
		colors = new Square[4][3];	
		for(int r = 0; r < colors.length; r++){
			for(int c = 0; c < colors[r].length; c++){
				colors[r][c] = new Square(255,255,255);
			}
		}
		
		addMouseListener(this);
		
		reset = new JButton("reset");
		reset.setBounds(650, 300, 100, 50);
		reset.addActionListener(this);
		this.add(reset);
		
		save = new JButton("save");
		save.setBounds(650,400,100,50);
		save.addActionListener(this);
		this.add(save);
		
		colors[0][0].changeColor(0,0,0); //black
		colors[0][1].changeColor(255,255,255); //white
		colors[0][2].changeColor(192,192,192); //grey
		colors[1][0].changeColor(255,0,0); //red
		colors[1][1].changeColor(255,165,0); //orange
		colors[1][2].changeColor(255,255,0); //yellow
		colors[2][0].changeColor(0,255,0); //green
		colors[2][1].changeColor(0,255,255); //greenblue
		colors[2][2].changeColor(0,0,255); //blue
		colors[3][0].changeColor(128,0,128); //purple
		colors[3][1].changeColor(255,0,255); //magenta
		colors[3][2].changeColor(255,192,203); //pink
		
		red = 255; 
		green = 255;
		blue = 255;
		draw = false;
		color = false;
		
		setLayout(null);
		this.setFocusable(true);
	}
     
    public Dimension getPreferredSize(){
        return new Dimension(800,600);
         
    

    public void paintComponent(Graphics g){
        super.paintComponent(g);
			
		int x = 10;
		int y = 10;
		for(int r = 0; r < grid.length; r++){
			for(int c = 0; c < grid[r].length; c++){
				grid[r][c].drawMe(g,x,y);
				x += 50;
			}
			x = 10;
			y += 50;
		}
		
		x = 650;
		y = 10;
		for(int r = 0; r < colors.length; r++){
			for(int c = 0; c < colors[r].length; c++){
				colors[r][c].drawMe(g,x,y);
				x+=50;
			}
			x = 650;
			y += 50;
		}
		repaint();
    
	public void saveImage(String name,String type) {
		BufferedImage image = new BufferedImage(getWidth(),getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = image.createGraphics();
		paint(g2);
		try{
			ImageIO.write(image, type, new File(name+"."+type));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == reset){
			for(int r = 0; r < grid.length; r++){
				for(int c = 0; c < grid[r].length; c++){
					grid[r][c].reset();
				}
			}
		}
		if(e.getSource() == save){
			saveImage("image", "png");
		}
	}
	
	public void update(int x, int y){
		int r = 0;
		int c = 0;
		if(x >= 650 && x <= 800 && y >= 10 && y <= 210)
			color = true;
		else if(x >= 10 && x <= 510 && y >= 10 && y <= 510)
			draw = true;
		if(color){
			r = 4;
			c = 3;
			for(int x1 = x; x1 <= 800; x1+=50){
				c--;
			}
			for(int y1 = y; y1 <= 210; y1+=50){
				r--;
			}
			System.out.println("col: " + c);
			System.out.println("row: " + r);
			color = false; 	
			red = colors[r][c].getRed();
			green = colors[r][c].getGreen();
			blue = colors[r][c].getBlue();
		}
		else if(draw){
			r = 10;
			c = 10;
			for(int x2 = x; x2 <= 510; x2+= 50){
				c--;
			}
			for(int y2 = y; y2 <= 510; y2+=50){
				r--;
			}
			System.out.println("col: " + c);
			System.out.println("row: " + r);
			draw = false;
			grid[r][c].changeColor(red,green,blue);
			
		}
	}
	
	public void mousePressed(MouseEvent e){
		System.out.println("X: " + e.getX() + ", Y: " + e.getY());
		update(e.getX(), e.getY());
		repaint();
			
	}
	
	public void mouseReleased(MouseEvent e) {}
 
    public void mouseEntered(MouseEvent e) {}
 
    public void mouseExited(MouseEvent e) {}
 
    public void mouseClicked(MouseEvent e) {}

     
 

}

