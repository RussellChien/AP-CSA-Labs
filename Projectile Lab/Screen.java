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

public class Screen extends JPanel implements KeyListener{
 
    private Projectile p1;
    private Ship s1;
    private Enemy[] enemies;  
	public boolean hit = false;
	private int scoreCounter = 0;
	private int direction = 1;//1 is move up, 2 is move down
	
    public Screen(){
         
        s1 = new Ship(50,300);
        p1 = new Projectile(50,300);
        enemies = new Enemy[10];
		for(int i = 0; i<enemies.length; i++){
			int x = (int)(Math.random() * 400 + 300);
			int y = (int)(Math.random() * 400 + 100) ;
			enemies[i] = new Enemy(x,y);
		}
       

        setFocusable(true);
        addKeyListener(this);
    
 
    public Dimension getPreferredSize() {
        //Sets the size of the panel
        return new Dimension(800,600);
    
     
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(300, 0, 800, 600);
     
		g.setColor(Color.yellow);
		g.fillRect(0,0,300,600);
		
		g.setColor(Color.black);
		g.drawString("Score: " + scoreCounter, 100, 100);
     
     
        //Draw ship
        s1.drawMe(g);
         
        //Draw Projectile
        p1.drawMe(g);
		
		for(int i = 0; i<enemies.length; i++){
			enemies[i].drawMe(g);
		}
 
    } 
	
	public void playHit() {
 
        try {
            URL url = this.getClass().getClassLoader().getResource("cannon.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        
    
	public void playFire() {
 
        try {
            URL url = this.getClass().getClassLoader().getResource("lasergun.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        
    
    public void animate(){
         
        while(true){
            //wait for .01 second
            try {
                Thread.sleep(5);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            
            			
            p1.moveRight();
			//check for a collision between each enemy and the projectile  
			for(int i = 0; i<enemies.length; i++){
				boolean result = enemies[i].checkCollision(p1);
				if(result == true){
					scoreCounter = scoreCounter + 1;
					this.playHit();
					hit = false;
				}
				
			}
			
			
			
			for(int i = 0;i < enemies.length; i++){
			
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
			}
			
            //repaint the graphics drawn
            repaint();
        
 
    
     
    //implement methods of the KeyListener
    public void keyPressed(KeyEvent e) {
 
 
        //key code
        //http://www.cambiaresearch.com/articles/15/javascript-char-codes-key-codes
  
        if (e.getKeyCode()==38){//Up Arrow
            s1.moveUp();        
        
        else if (e.getKeyCode()==40){//Down Arrow
            s1.moveDown();   
        } else if ( e.getKeyCode() == 32 ) { //Spacebar
            //update the position of the projectile to the position of the ship
            p1.setPosition( s1.getX() + 10,  s1.getY() + 20 );
             
            //shoot the projectile
            p1.setVisible(true);
			this.playFire();
             
        
         
        repaint();
 
    
 
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}
