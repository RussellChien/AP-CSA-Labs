import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JTextField;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Screen extends JPanel implements KeyListener, ActionListener{
	
	private int quest;
	private int loc;
	private boolean inventory; 
	private boolean start;
	private boolean dialouge; 
	private int count;
	private int x;
	private int y;
	private BufferedImage background1;
	private BufferedImage background2;
	private BufferedImage background3;
	private BufferedImage background4;
	private BufferedImage background5;
	private BufferedImage background6;
	private BufferedImage background7;
	private BufferedImage background8;
	private BufferedImage background9;
	private BufferedImage startScreen;
	JButton startButton;
	ArrayList<Item> items;
	ArrayList<Item> inv;
	ArrayList<String> quest1;
	ArrayList<String> quest2;
	ArrayList<String> quest3;
	Player p;
	Nonplayer mom;
	Nonplayer wannabe;
	Nonplayer host;
	Item sheet;
	Item violin;
	Item stand;
	Item rosin;
	Item violinCase;
	Item watch;
	
	
		
	public Screen(){
		this.setLayout(null);
		
		startButton = new JButton("Start");
		startButton.setBounds(400, 700, 100, 50);
		startButton.addActionListener(this);
		this.add(startButton);

		p = new Player();
		mom = new Mom();
		wannabe = new Wannabe();
		host = new Host();

		loc = 0;
		count = 0;
		x = 200;
		y = 300;
		items = new ArrayList<Item>();
		inv = new ArrayList<Item>();
		quest1 = new ArrayList<String>();
		quest2 = new ArrayList<String>();
		quest3 = new ArrayList<String>();
		quest1.add("Zzzz... huh!? Why aren't you practicing!?"); 
		quest1.add("I want to make a world record mom!");
		quest1.add("What? What record?");
		quest1.add("The world's fastest violinist.");
		quest1.add("...");
		quest1.add("I'm going to play flight of the bumblebee in under a minute!");
		quest1.add("Huh!? What about your Vivaldi violin concerto?");
		quest1.add("Who cares about that??");
		quest1.add("...Well, you better watch out for those ling ling wannabes!");
		quest1.add("Ok...");
		quest1.add("If you get past them, talk to the host person across the street.");
		quest2.add("A ling ling wannabe appeared!");
		quest2.add("You use Vivaldi!");
		quest2.add("It's not very effective...");
		quest2.add("Wannabe uses Saint Saens!");
		quest2.add("It's somewhat effective.");
		quest2.add("You use Mendelssohn!");
		quest2.add("It's not very effective...");
		quest2.add("Wannabe uses Paganini!");
		quest2.add("It's super effective!");
		quest2.add("This is your last chance...");
		quest2.add("You use flight of the bumblebee at 15 notes a second!");
		quest2.add("It's super effective!");
		quest2.add("Phew, that was a workout. Now to find the host..");
		quest3.add("Welcome to studio 10!");
		quest3.add("Thank you, I am a genuis");
		quest3.add("Wow, amazing!");
		quest3.add("So, I will be playing flight of the bumblebee in under a minute");
		quest3.add("Ok, I will start the timer in 3, 2, 1");
		quest3.add("*sacrilegious sounds*");
		quest3.add("58 seconds! Amazing! It's a new world record!");
		try {
            startScreen = ImageIO.read(new File("images/start.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
		try {
            background1 = ImageIO.read(new File("images/background1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            background2 = ImageIO.read(new File("images/background2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
		try {
            background3 = ImageIO.read(new File("images/background3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
		try {
            background4 = ImageIO.read(new File("images/background4.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            background5 = ImageIO.read(new File("images/background5.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            background6 = ImageIO.read(new File("images/background6.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            background7 = ImageIO.read(new File("images/background7.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            background8 = ImageIO.read(new File("images/background8.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            background9 = ImageIO.read(new File("images/background9.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
		violin = new Violin();
		sheet = new Sheet();
		stand = new Stand();
		rosin = new Rosin();
		watch = new Watch();
		violinCase = new ViolinCase();
		quest = 0;
		items.add(stand);
		items.add(sheet);
		items.add(violin);
		items.add(rosin);
		items.add(violinCase);
		items.add(watch);
		inventory = false;
		start = false;
		setFocusable(true);
		addKeyListener(this);
	

		
	}
	public Dimension getPreferredSize() {
        //Sets the size of the panel
        return new Dimension(900,900);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(!start){
        	//instructions
        	g.drawImage(startScreen, 0, 0, null);
        	g.setColor(Color.white);
			Font set = new Font("Arial", Font.PLAIN, 40);
			g.setFont(set);
        	g.drawString("Instructions", 200, 100);
        	g.drawString("WASD to move", 200, 200);
        	g.drawString("Space to continue dialogue", 200, 300);
        	g.drawString("Press i to access inventory", 200, 400);
        	
        }
		if(start){
	   		if(p.getX() > 800){
				loc++;
				p.setX(0);
			}
			else if(p.getY() > 800){
				loc+=10;
				p.setY(0);
			}
			else if(p.getX() < 0){
				loc--;
				p.setX(800);
			}
			else if(p.getY() < 0){
				loc-=10;
				p.setY(800);
			}
			if(loc == 0){
				g.drawImage(background1, 0, 0, null);
			}
			else if(loc == 1){
				g.drawImage(background2, 0 , 0, null);
			}
			else if(loc == 2){
				g.drawImage(background3, 0, 0, null);
			}
			else if(loc == 10){
				g.drawImage(background4, 0, 0, null);
			}
			else if(loc == 11){
				g.drawImage(background5, 0, 0, null);
			}
			else if(loc == 12){
				g.drawImage(background6, 0, 0, null);
			}
			else if(loc == 20){
				g.drawImage(background7, 0, 0, null);
			}
			else if(loc == 21){
				g.drawImage(background8, 0, 0, null);
			}
			else if(loc == 22){
				g.drawImage(background9, 0, 0, null);
			}
			else{
				g.setColor(Color.black);
				Font f = new Font("Arial", Font.PLAIN, 30);
				g.setFont(f);
				g.drawString("Out of bounds", 300, 450);
			}
			p.drawMe(g);

			Font font = new Font("Arial", Font.PLAIN, 18);
			g.setFont(font);
			g.setColor(Color.black);
			g.fillRect(0, 0, 900, 120);
			g.setColor(Color.white);
			if(quest < 4)
				g.drawString("Quest: " + quest + "/3", 600, 20);
			g.setColor(Color.white);

			if(quest==0){
				g.drawString("Go find music and a stand,", 50, 50);
				g.drawString("then talk to your mom about breaking a world record", 50, 80);
			}
			else if(quest == 1){
				g.drawString("Collect rosin and a case", 50, 50);
				g.drawString("Then go find the ling ling wannabe and fight him", 50, 80);
			}
			else if(quest == 2){
				g.drawString("Find a watch and the 24k karot gold electric violin viola hybrid", 50, 50);
				g.drawString("and find the host", 50, 80);
			}
			else if(quest == 3){
				g.setColor(Color.black);
				g.fillRect(0, 0, 900, 900);
				g.setColor(Color.white);
				g.drawString("You win!", 450, 450);
			}
			else{
				quest = 3;
			}
			
			if(loc == 22 && violin.checkVisible() && quest == 2){
				violin.drawMe(g);
			} 
			if(loc == 2 && quest == 0){
				mom.drawMe(g);
			}
			if(stand.checkVisible() && loc == 1 && quest == 0){
				stand.drawMe(g);
			}
			if(sheet.checkVisible() && loc == 10 && quest == 0){
				sheet.drawMe(g);
			}
			if(rosin.checkVisible() && loc == 12 && quest == 1){
				rosin.drawMe(g);
			}
			if(violinCase.checkVisible() && loc == 11 && quest == 1){
				violinCase.drawMe(g);
			}
			if(loc == 20 && quest == 1){
				wannabe.drawMe(g);
			}
			if(loc == 21 && watch.checkVisible() && quest == 2){
				watch.drawMe(g);
			}
			if(loc == 22 && quest == 2){
				host.drawMe(g);
			}
			

			if(dialouge && quest == 0){
				//mom quest
				g.setColor(Color.gray);
				g.fillRect(0, 200, 900, 700);
				if(count==quest1.size()){
					count = 0;
					dialouge = false;
					quest++;
					x = 200;
					y = 300;
					this.completeQuest();
				}
				g.setColor(Color.white);
				g.drawString(quest1.get(count), x, y);
				
			}
			if(dialouge && quest == 1){
				//fight
				g.setColor(Color.gray);
				g.fillRect(0, 200, 900, 700);
				if(count==quest2.size()){
					count = 0;
					dialouge = false;
					quest++;
					x = 200;
					y = 300;
					this.completeQuest();
				}
				g.setColor(Color.white);
				g.drawString(quest2.get(count), x, y);
			}
			if(dialouge && quest == 2){
				g.setColor(Color.gray);
				g.fillRect(0, 200, 900, 700);
				if(count==quest3.size()){
					count = 0;
					dialouge = false;
					quest++;
					x = 200;
					y = 300;
					this.completeQuest();
				}
				g.setColor(Color.white);
				g.drawString(quest3.get(count), x, y);
			}
	
			if(inventory){
				g.setColor(Color.gray);
				g.fillRect(100,50,700,700);
				Font i = new Font("Arial", Font.PLAIN, 40);
				g.setFont(i);
				g.setColor(Color.white);
				g.drawString("Inventory", 350, 100);
				for(Item e : inv){
					e.drawMe(g);
				}
			}

				
			
			
		}
		repaint();


    } 
    
    public void animate(){
    	while(true){
            try {
                Thread.sleep(15);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
        	}
        	
        	if(loc == 22 && violin.checkCollision(p) && quest == 2){
        		System.out.println("Violin");
        		violin.setVisible(false); 
        		for(int i = 0; i < items.size(); i++){
        			if(items.get(i).equals(violin))
						inv.add(items.remove(i));
				}
				violin.setX(100);
				violin.setY(100);
				this.pickUpItem();
				violin.setInventory(true);
        	}

        	if(mom.checkCollision(p) && loc == 2 && quest == 0){
        		System.out.println("mom");
        		mom.setContact(true); 
        		dialouge = true;	
        	}
        	if(loc == 1 && stand.checkCollision(p) && quest == 0){
        		System.out.println("stand");
        		stand.setVisible(false);
        		for(int i = 0; i < items.size(); i++){
        			if(items.get(i).equals(stand))
        		    	inv.add(items.remove(i));
        		}
        		stand.setX(100);
        		stand.setY(300);
        		this.pickUpItem();
        		stand.setInventory(true);


        	}
        	if(loc == 10 && sheet.checkCollision(p) && quest == 0){
        		System.out.println("sheet");
        		sheet.setVisible(false);
        		for(int i = 0; i < items.size(); i++){
        			if(items.get(i).equals(sheet))
        		    	inv.add(items.remove(i));
        		}
        		sheet.setX(100);
        		sheet.setY(500);
        		this.pickUpItem();
        		sheet.setInventory(true);

        	}
        	if(loc == 12 && rosin.checkCollision(p) && quest == 1){
        		System.out.println("rosin");
        		rosin.setVisible(false);
        		for(int i = 0; i < items.size(); i++){
        			if(items.get(i).equals(rosin))
        		    	inv.add(items.remove(i));
        		}
        		rosin.setX(400);
        		rosin.setY(100);
        		this.pickUpItem();
        		rosin.setInventory(true);

        	}
        	if(loc == 11 && violinCase.checkCollision(p) && quest == 1){
        		System.out.println("violin case");
        		violinCase.setVisible(false);
        		for(int i = 0; i < items.size(); i++){
        			if(items.get(i).equals(violinCase))
        		    	inv.add(items.remove(i));
        		}
        		violinCase.setX(400);
        		violinCase.setY(300);
        		this.pickUpItem();
        		violinCase.setInventory(true);

        	}
        	if(wannabe.checkCollision(p) && loc == 20 && quest == 1){
        		System.out.println("wannabe");
        		wannabe.setContact(true);
        		dialouge = true;
        	}   
			if(loc == 21 && watch.checkCollision(p) && quest == 2){
        		System.out.println("watch");
        		watch.setVisible(false);
        		for(int i = 0; i < items.size(); i++){
        			if(items.get(i).equals(watch))
        		    	inv.add(items.remove(i));
        		}
        		watch.setX(700);
        		watch.setY(400);
        		this.pickUpItem();
        		watch.setInventory(true);

        	}	
			if(host.checkCollision(p) && loc == 22 && quest == 2){
				System.out.println("host");
				host.setContact(true);
				dialouge = true;
			}
        	
        repaint();
        }

    }
	public void pickUpItem() {
 
        try {
            URL url = this.getClass().getClassLoader().getResource("sounds/interesting.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }
	public void completeQuest() {
 
        try {
            URL url = this.getClass().getClassLoader().getResource("sounds/amazing.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == startButton){
			start = true; 
			startButton.setVisible(false);
		}

		requestFocus();
		setFocusable(true);
		repaint();		
	}

 
    //implement methods of the KeyListener
    public void keyPressed(KeyEvent e) { 
		if (e.getKeyCode() == 80) {
			if(quest==0){
				sheet.setVisible(false);
				sheet.setInventory(true);
				stand.setVisible(false);
				stand.setInventory(true);
				for(int i = 0; i < items.size(); i++){
        			if(items.get(i).equals(stand))
        		    	inv.add(items.remove(i));
        		}
        		for(int i = 0; i < items.size(); i++){
        			if(items.get(i).equals(sheet))
        		    	inv.add(items.remove(i));
        		}
        		stand.setX(100);
        		stand.setY(300);
        		sheet.setX(100);
        		sheet.setY(500);
			}
			else if(quest==1){
				rosin.setVisible(false);
				rosin.setInventory(true);
				violinCase.setVisible(false);
				violinCase.setInventory(true);
				for(int i = 0; i < items.size(); i++){
        			if(items.get(i).equals(rosin))
        		    	inv.add(items.remove(i));
        		}
        		for(int i = 0; i < items.size(); i++){
        			if(items.get(i).equals(violinCase))
        		    	inv.add(items.remove(i));
        		}
        		rosin.setX(400);
        		rosin.setY(100);
        		violinCase.setX(400);
        		violinCase.setY(450);
				
			}
			else if(quest==2){
				watch.setVisible(false);
				watch.setInventory(true);
				violin.setVisible(false);
				violin.setInventory(true);
				for(int i = 0; i < items.size(); i++){
        			if(items.get(i).equals(watch))
        		    	inv.add(items.remove(i));
        		}
				for(int i = 0; i < items.size(); i++){
        			if(items.get(i).equals(violin))
        		    	inv.add(items.remove(i));
        		}
				watch.setX(700);
        		watch.setY(400);
				violin.setX(100);
				violin.setY(100);
			}
            quest++;
            this.completeQuest();
        }
		else if (e.getKeyCode() == 87) {
            p.moveUp();	
        }
        else if (e.getKeyCode() == 83) {
            p.moveDown();
        }
        else if (e.getKeyCode() == 65) {
            p.moveLeft();
        }
        else if (e.getKeyCode() == 68) {
            p.moveRight();
        }
        else if (e.getKeyCode() == 73){
        	inventory = !inventory; 
        }
        else if (e.getKeyCode() == 32){
        	if(dialouge){
        		count++;
        		y+= 20;
        	}
        	
        }

		repaint();
    }
 
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}













