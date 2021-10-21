
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.Font;

public class Screen extends JPanel implements ActionListener, MouseListener{

	Game game = new Game();
	private JButton newGame;
	private JButton newGameCPU;
	private boolean CPU;
	private int CPUWins;
	private boolean gameOn;
	
	public Screen(){
		CPU = false;
		CPUWins = 0;
		gameOn = false;
		addMouseListener(this);
		newGame = new JButton("New Game");
		newGame.setBounds(50,320,100,50);
		newGame.addActionListener(this);
		this.add(newGame);
		newGameCPU = new JButton("Vs CPU");
		newGameCPU.setBounds(150,320,100,50);
		newGameCPU.addActionListener(this);
		this.add(newGameCPU);
		setLayout(null);
	}
	
	public Dimension getPreferredSize(){
        	return new Dimension(300,600);
	}
    

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.white);
        	g.fillRect(0,0,300,600);
		game.drawMe(g);
		Font info = new Font("Arial", Font.PLAIN, 25);
        	g.setFont(info);
		g.drawString("Player 1 wins: " + game.getPlayerOne(), 50, 400);
		if(CPU){
			g.drawString("CPU wins: " + CPUWins, 50, 500);
		}
		else{
			g.drawString("Player 2 wins: " + game.getPlayerTwo(), 50, 500);
		}
		
		
        	if(game.checkTicTacToe() == 1){
        		g.drawString("Player 1 wins!", 50, 550);
        
			if(CPU){
				if(game.checkTicTacToe() == 2){
					g.drawString("CPU wins!", 50, 550);
				} 
			}
			else if(game.checkTicTacToe() == 2){
        			g.drawString("Player 2 wins!", 50, 550);
        		} 
		}
			
        	if(game.checkTicTacToe() == 0 && game.checkFull() == true){
        		g.drawString("Tie!", 50, 550);
       	 	}       
		newGame.setVisible(game.buttons());
		newGameCPU.setVisible(game.buttons());
	}
	
	
    
    public void playWin() {
	
        try {
            URL url = this.getClass().getClassLoader().getResource("Win.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
	}
    }
		
    
    
    public void playTie() {
	
        try {
            URL url = this.getClass().getClassLoader().getResource("Tie.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
	}
    }
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == newGame){
			game.reset();
			game.getButton(false);
			addMouseListener(this);
			CPU = false;
			gameOn = true;
			repaint();
		}
		if(e.getSource() == newGameCPU){
			game.reset();
			game.getButton(false);
			addMouseListener(this);
			gameOn = true;
			CPU = true;
			repaint();
			
		}
	}
	public void mousePressed(MouseEvent e) {
		System.out.println("X: " + e.getX() + ", Y: " + e.getY());
		if (!gameOn) {
			//game has not started
			return;
		} else {
			//game has started
		}
		
		if(game.checkFull() == false && game.checkTicTacToe() != 1 && game.checkTicTacToe() != 2){
			game.insertXO(e.getX(), e.getY());
			if(game.checkFull() == false && game.checkTicTacToe() != 1 && game.checkTicTacToe() != 2){
				if(CPU){
					game.CPUPlay();
					if (game.checkTicTacToe() == 2) {
						gameOn = false;
						CPUWins++;
					}
				}
			}
		}
		if(game.checkTicTacToe() == 1){
			System.out.println("Player one wins");
			gameOn = false;
			this.playWin();
			game.update();
			game.getButton(true);
			removeMouseListener(this);
		}
		else if(game.checkTicTacToe() == 2){
			System.out.println("Player two wins");
			gameOn = false;
			this.playWin();
			if(!CPU){
				game.update();
			}	
			
			game.getButton(true);
			removeMouseListener(this);
		}
		else if(game.checkTicTacToe() == 0 && game.checkFull() == true){
			System.out.println("Tie");
			this.playTie();
			gameOn = false;
			game.update();
			game.getButton(true);
			removeMouseListener(this);
		}
		repaint();
    
 
    public void mouseReleased(MouseEvent e) {}
 
    public void mouseEntered(MouseEvent e) {}
 
    public void mouseExited(MouseEvent e) {}
 
    public void mouseClicked(MouseEvent e) {}
 
}
