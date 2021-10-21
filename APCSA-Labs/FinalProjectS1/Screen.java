import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
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


public class Screen extends JPanel implements KeyListener{

  	private Projectile p1;
	private Projectile[] projectiles;
  	private Ship s1;
  	private Ship p2;
  	private Enemy[] enemies;
	private Enemy[] enemies2;
	public boolean hit = false;
	private int direction = 1;//1 is move up, 2 is move down
	private Stars s2;
	private Stars[] stars;
	private int level = 1;
	private int lives = 3;
	private BufferedImage background1;
	private BufferedImage background2;
	private int scoreCounter = 0;
	private int x;
	private int y;
	private int x1;
	private int y1;
	//private Boss b1;
	private boolean pressed = false;

    public Screen(){

        s1 = new Ship(50,300);
        p2 = new Ship(50, 500);
        //p1 = new Projectile(50,300);
		projectiles = new Projectile[3];
		projectiles[0] = new Projectile(50,300);
		projectiles[1] = new Projectile(50,250);
		projectiles[2] = new Projectile(50,350);

        enemies = new Enemy[3];
		for(int i = 0; i<enemies.length; i++){
			x = (int)(Math.random() * 400 + 600);
			y = (int)(Math.random() * 400 + 100);
			enemies[i] = new Enemy(x,y);
		}
		enemies2 = new Enemy[50];
		for(int i = 0; i<enemies2.length; i++){
			x1 = (int)(Math.random() * 400 + 800);
			y1 = (int)(Math.random() * 400 + 100);
			enemies2[i] = new Enemy(x1,y1);
		}
        s2 = new Stars();
		stars = new Stars[250];
		for(int i = 0; i<stars.length; i++){
			stars[i] = new Stars();
		}
		try {
				background1 = ImageIO.read(new File("images/solarsystem.jpg"));
        }
		catch (IOException e) {
				e.printStackTrace();
		}
		try {
				background2 = ImageIO.read(new File("images/background2.jpg"));
        }
		catch (IOException e) {
				e.printStackTrace();
		}

        setFocusable(true);
        addKeyListener(this);
		}

    public Dimension getPreferredSize() {
        //Sets the size of the panel
        return new Dimension(800,600);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
		Color black = new Color(0,0,0);
		Color red = new Color(255,0,0);

		if(level==1){
			g.drawImage(background1, 0,0, null);
			g.setColor(Color.white);
			for(int i = 0; i<enemies.length; i++){
				enemies[i].drawMe(g);
			}

		}
		if(level==2){
			g.drawImage(background2,0,0,null);
			for(int i = 0; i<enemies2.length; i++){
				enemies2[i].drawMe(g);
			}
		}

		g.setColor(Color.white);
		g.drawString("Level: " + level, 100, 100);
		g.drawString("Lives: " + lives, 100, 150);
		//Draw ship
		s1.drawMe(g);
		p2.drawMe(g);

		//Draw Projectile
		for(int i = 0; i<projectiles.length; i++){
			projectiles[i].drawMe(g);
		}
		for(int i = 0; i<stars.length; i++){
				stars[i].drawMe(g);
		}
		if(level == 3){
			g.setColor(black);
			g.fillRect(0,0,800,600);
			g.setColor(Color.white);
			g.drawString("You win!", 400, 300);
		}
		if(lives <= 0){
			for(int i = 0; i<enemies.length; i++){
				x = (int)(Math.random() * 400 + 600);
				y = (int)(Math.random() * 400 + 100);
			enemies[i] = new Enemy(x,y);
			}
			for(int i = 0; i<enemies2.length; i++){
				x1 = (int)(Math.random() * 400 + 800);
				y1 = (int)(Math.random() * 400 + 100);
			enemies2[i] = new Enemy(x1,y1);
			}
			scoreCounter = 0;
			level = 1;
			lives = 3;
		}


    }

	public void playHit() {

        try {
            URL url = this.getClass().getClassLoader().getResource("sounds/cannon.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }


	public void playFire() {

        try {
            URL url = this.getClass().getClassLoader().getResource("sounds/lasergun.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }


	public void playDeath(){
		 try {
            URL url = this.getClass().getClassLoader().getResource("sounds/death.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }

	}
    public void animate(){

        while(true){
            //wait for .01 second
            try {
                Thread.sleep(15);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

		for(int i = 0; i<stars.length; i++){
            stars[i].move();
		}
            projectiles[0].moveRight();
            projectiles[1].moveRight();
            projectiles[2].moveRight();

			//check for a collision between each enemy and the projectile
			if(level == 1){
			for(int i = 0; i<enemies.length; i++){
				boolean result1 = enemies[i].checkCollision(projectiles[0]);
				boolean result2 = enemies[i].checkCollision(projectiles[1]);
				boolean result3 = enemies[i].checkCollision(projectiles[2]);

				if(result1 == true){
					this.playHit();
					hit = false;
					scoreCounter = scoreCounter + 1;
				}
				else if(result2 == true){
					this.playHit();
					hit = false;
					scoreCounter = scoreCounter + 1;
				}
				else if(result3 == true){
					this.playHit();
					hit = false;
					scoreCounter = scoreCounter + 1;
				}
			}
		}


			if(level == 2){

				for(int i = 0; i<enemies2.length; i++){
					boolean result1 = enemies2[i].checkCollision(projectiles[0]);
					boolean result2 = enemies2[i].checkCollision(projectiles[1]);
					boolean result3 = enemies2[i].checkCollision(projectiles[2]);
					if(result1 == true){
						this.playHit();
						hit = false;
						scoreCounter = scoreCounter + 1;
					}
				else if(result2 == true){
						this.playHit();
						hit = false;
						scoreCounter = scoreCounter + 1;
					}
				else if(result3 == true){
						this.playHit();
						hit = false;
						scoreCounter = scoreCounter + 1;
					}
				}
			}
			if(level == 1){
				for(int i = 0; i < enemies.length; i++){
					enemies[i].moveleft();
					if(enemies[i].getX() == 0){
						lives = lives - 1;
						this.playDeath();
						scoreCounter = scoreCounter + 1;

					}


					if(enemies[i].getY() > 560){
						direction = 2;
					}
					else if(enemies[i].getY() < 50){
						direction = 1;
					}
					if(direction == 1){
						enemies[i].add1toy();
					}
					else if(direction == 2){
						enemies[i].subtract1fromy();
					}
					if(scoreCounter == enemies.length){
						level = 2;
					}
					else if(scoreCounter < enemies.length-1 && enemies[i].getX() <= -10 && lives > 0){
						level = 2;
					}
					else if(scoreCounter < enemies.length-2 && enemies[i].getX() <= -10 && lives > 0){
						level = 2;
					}


				}
			}
			if (level == 2){
				for(int i = 0; i < enemies2.length; i++){
					enemies2[i].moveleft2();
					if(enemies2[i].getX() == 1 ||enemies2[i].getX() == 0){
						lives = lives - 1;
						this.playDeath();
						scoreCounter = scoreCounter + 1;
					}
					if(enemies2[i].getY() > 560){
						direction = 2;
					}
					else if(enemies2[i].getY() < 50){
						direction = 1;
					}
					if(direction == 1){
						enemies2[i].add1toy();
					}
					else if(direction == 2){
						enemies2[i].subtract1fromy();
					}
					if(scoreCounter == (enemies2.length + enemies.length)){
						level = 3;
					}
					else if(scoreCounter == (enemies2.length + enemies.length)-1 && enemies2[i].getX() <= -50){
						level = 3;
					}
					else if(scoreCounter == (enemies2.length + enemies.length)-2 && enemies2[i].getX() <= -50){
						level = 3;
					}
					else if(scoreCounter == enemies2.length && pressed == true){
						level = 3;
					}
					else if(scoreCounter == enemies2.length-1 && pressed == true && lives>0){
						level = 3;
					}
					else if(scoreCounter == enemies2.length-2 && pressed == true && lives>0){
						level = 3;
					}

				}
			}

            //repaint the graphics drawn
            repaint();
		}
	}


    //implement methods of the KeyListener
    public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==80){
			level = level + 1;
			pressed = true;
		}

        //key code
        //http://www.cambiaresearch.com/articles/15/javascript-char-codes-key-codes

        if (e.getKeyCode()==38){//Up Arrow
            s1.moveUp();
        }

        else if (e.getKeyCode()==40){//Down Arrow
            s1.moveDown();
        }
		else if ( e.getKeyCode() == 32 ) { //Spacebar
            //update the position of the projectile to the position of the ship
            for(int i = 0; i<projectiles.length; i++){
                projectiles[0].setPosition( s1.getX() + 10, s1.getY() + 20 );
                projectiles[1].setPosition( s1.getX() + 10, s1.getY() + 70 );
                projectiles[2].setPosition( s1.getX() + 10, s1.getY() - 30 );



            //shoot the projectile
            	projectiles[0].setVisible(true);
            	projectiles[1].setVisible(true);
            	projectiles[2].setVisible(true);
            	this.playFire();
            }



        }
        repaint();
	}

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

	}
