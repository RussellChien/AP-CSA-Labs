import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Table extends JPanel implements ActionListener{

	private Card[] deck;
	private int playerIndex;
	private JButton stand;
	private JButton hit;
	private int points;
	private JButton newgame;
	private int hand;
	//public int hitPressed;
	//private int game;
	private int hitPressed;
	private boolean game = false;


    public Table(){

	points = 20;

	newgame = new JButton("New Game");
	newgame.setBounds(350,400,200,30);
	newgame.addActionListener(this);
	this.add(newgame);


	stand = new JButton("Stand");
        stand.setBounds(-350,40,100,30);
        stand.addActionListener(this);
        this.add(stand);

        hit = new JButton("Hit");
        hit.setBounds(-450,40,100,30);
        hit.addActionListener(this);
       	this.add(hit);
	    
	deck = new Card[52];
	deck[0] = new Card(2, "2", "hearts");
	deck[1] = new Card(3, "3", "hearts");
	deck[2] = new Card(4, "4", "hearts");
	deck[3] = new Card(5, "5", "hearts");
	deck[4] = new Card(6, "6", "hearts");
	deck[5] = new Card(7, "7", "hearts");
	deck[6] = new Card(8, "8", "hearts");
	deck[7] = new Card(9, "9", "hearts");
	deck[8] = new Card(10, "10", "hearts");
	deck[9] = new Card(10, "J", "hearts");
	deck[10] = new Card(10, "Q", "hearts");
	deck[11] = new Card(10, "K", "hearts");
	deck[12] = new Card(11, "A", "hearts");
	deck[13] = new Card(2, "2", "clubs");
	deck[14] = new Card(3, "3", "clubs");
	deck[15] = new Card(4, "4", "clubs");
	deck[16] = new Card(5, "5", "clubs");
	deck[17] = new Card(6, "6", "clubs");
	deck[18] = new Card(7, "7", "clubs");
	deck[19] = new Card(8, "8", "clubs");
	deck[20] = new Card(9, "9", "clubs");
	deck[21] = new Card(10, "10", "clubs");
	deck[22] = new Card(10, "J", "clubs");
	deck[23] = new Card(10, "Q", "clubs");
	deck[24] = new Card(10, "K", "clubs");
	deck[25] = new Card(11, "A", "clubs");
	deck[26] = new Card(2, "2", "diamonds");
	deck[27] = new Card(3, "3", "diamonds");
	deck[28] = new Card(4, "4", "diamonds");
	deck[29] = new Card(5, "5", "diamonds");
	deck[30] = new Card(6, "6", "diamonds");
	deck[31] = new Card(7, "7", "diamonds");
	deck[32] = new Card(8, "8", "diamonds");
	deck[33] = new Card(9, "9", "diamonds");
	deck[34] = new Card(10, "10", "diamonds");
	deck[35] = new Card(10, "J", "diamonds");
	deck[36] = new Card(10, "Q", "diamonds");
	deck[37] = new Card(10, "K", "diamonds");
	deck[38] = new Card(11, "A", "diamonds");
	deck[39] = new Card(2, "2", "spades");
	deck[40] = new Card(3, "3", "spades");
	deck[41] = new Card(4, "4", "spades");
	deck[42] = new Card(5, "5", "spades");
	deck[43] = new Card(6, "6", "spades");
	deck[44] = new Card(7, "7", "spades");
	deck[45] = new Card(8, "8", "spades");
	deck[46] = new Card(9, "9", "spades");
	deck[47] = new Card(10, "10", "spades");
	deck[48] = new Card(10, "J", "spades");
	deck[49] = new Card(10, "Q", "spades");
	deck[50] = new Card(10, "K", "spades");
	deck[51] = new Card(11, "A", "spades");

	playerIndex = 1;


        setLayout(null);
    }



    public Dimension getPreferredSize() {
        //Sets the size of the panel
        return new Dimension(1000,600);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.green);
        g.fillRect(0,0,1000,600);
		Font font = new Font("Arial", Font.PLAIN, 50);

		if(hand == 21){
			game = false;
			g.setColor(Color.white);
			g.setFont(font);
			g.drawString("Blackjack! You win 5 points!", 300, 500);
			points += 5;
			stand.setBounds(-350,40,100,30);
			hit.setBounds(-450,40,100,30);
			newgame.setBounds(350,400,200,30);
			this.playWin();

		}
		else if(hand>21){
			game = false;
			g.setColor(Color.white);
			g.setFont(font);
			g.drawString("Bust! 0 points..", 300, 500);
			stand.setBounds(-350,40,100,30);
			hit.setBounds(-450,40,100,30);
			newgame.setBounds(350,400,200,30);
			this.playLose();


		}
		if(game == true){
		int x = 100;
		int y = 100;
		stand.setBounds(350,40,100,30);
		hit.setBounds(450,40,100,30);
		newgame.setBounds(-350,400,200,30);

			if(playerIndex >= 2){
				deck[0].drawMe(g, x, y);
				x += 80;
				deck[1].drawMe(g,x, y);
				x += 80;
				hand = deck[0].getValue() + deck[1].getValue();
				repaint();

			if(hitPressed == 1){
				x = 100;
				deck[0].drawMe(g, x, y);
				x += 80;
				deck[1].drawMe(g,x, y);
				x += 80;
				deck[2].drawMe(g, x, y);
				x += 80;
				hand = deck[0].getValue() + deck[1].getValue() + deck[2].getValue();
				repaint();
			}

			if(hitPressed == 2){
				x = 100;
				deck[0].drawMe(g, x, y);
				x += 80;
				deck[1].drawMe(g,x, y);
				x += 80;
				deck[2].drawMe(g, x, y);
				x += 80;
				deck[3].drawMe(g, x, y);
				hand = deck[0].getValue() + deck[1].getValue() + deck[2].getValue() + deck[3].getValue();
				repaint();
			}

			if(hitPressed == 3){
				x = 100;
				deck[0].drawMe(g, x, y);
				x += 80;
				deck[1].drawMe(g,x, y);
				x += 80;
				deck[2].drawMe(g, x, y);
				x += 80;
				deck[3].drawMe(g, x, y);
				x += 80;
				deck[4].drawMe(g,x,y);
				hand = deck[0].getValue() + deck[1].getValue() + deck[2].getValue() + deck[3].getValue() + deck[4].getValue();
				repaint();
			}
			if(hitPressed == 4){
				x = 100;
				deck[0].drawMe(g, x, y);
				x += 80;
				deck[1].drawMe(g,x, y);
				x += 80;
				deck[2].drawMe(g, x, y);
				x += 80;
				deck[3].drawMe(g, x, y);
				x += 80;
				deck[4].drawMe(g,x,y);
				x += 80;
				deck[5].drawMe(g,x,y);
				hand = deck[0].getValue() + deck[1].getValue() + deck[2].getValue() + deck[3].getValue() + deck[4].getValue() + deck[5].getValue();
				repaint();
			}
			if(hitPressed == 5){
				x = 100;
				deck[0].drawMe(g, x, y);
				x += 80;
				deck[1].drawMe(g,x, y);
				x += 80;
				deck[2].drawMe(g, x, y);
				x += 80;
				deck[3].drawMe(g, x, y);
				x += 80;
				deck[4].drawMe(g,x,y);
				x += 80;
				deck[5].drawMe(g,x,y);
				x += 80;
				deck[6].drawMe(g,x,y);
				hand = deck[0].getValue() + deck[1].getValue() + deck[2].getValue() + deck[3].getValue() + deck[4].getValue() + deck[5].getValue() + deck[6].getValue();
				repaint();
			}
			if(hitPressed == 6){
				x = 100;
				deck[0].drawMe(g, x, y);
				x += 80;
				deck[1].drawMe(g,x, y);
				x += 80;
				deck[2].drawMe(g, x, y);
				x += 80;
				deck[3].drawMe(g, x, y);
				x += 80;
				deck[4].drawMe(g,x,y);
				x += 80;
				deck[5].drawMe(g,x,y);
				x += 80;
				deck[6].drawMe(g,x,y);
				x+=80;
				deck[7].drawMe(g,x,y);
				hand = deck[0].getValue() + deck[1].getValue() + deck[2].getValue() + deck[3].getValue() + deck[4].getValue() + deck[5].getValue() + deck[6].getValue() + deck[7].getValue();
				repaint();
				}
			}
		}

		else if(game==false){

			if(hand == 20){
				stand.setBounds(-350,40,100,30);
				hit.setBounds(-450,40,100,30);
				newgame.setBounds(350,400,200,30);
				g.setColor(Color.white);
				g.setFont(font);
				g.drawString("You win 3 points!", 300, 500);
				this.playWin();

			}
			else if(hand == 19){

				stand.setBounds(-350,40,100,30);
				hit.setBounds(-450,40,100,30);
				newgame.setBounds(350,400,200,30);
				g.setColor(Color.white);
				g.setFont(font);
				g.drawString("You win 2 points!", 300, 500);
				this.playWin();

			}
			else if(hand == 18 || hand == 17 || hand == 16){

				stand.setBounds(-350,40,100,30);
				hit.setBounds(-450,40,100,30);
				newgame.setBounds(350,400,200,30);
				g.setColor(Color.white);
				g.setFont(font);
				g.drawString("You win 1 point!", 300, 500);
				this.playWin();
			}

		}
		g.setColor(Color.white);
		g.setFont(font);
		g.drawString("Points: " + points, 100, 90);
		g.drawString("Hand: " + hand, 100, 400);
    }





 	public void playHit() {

        	try {
          	    URL url = this.getClass().getClassLoader().getResource("sounds/hit.wav");
          	    Clip clip = AudioSystem.getClip();
         	    clip.open(AudioSystem.getAudioInputStream(url));
        	    clip.start();
       	 	} catch (Exception exc) {
       	            exc.printStackTrace(System.out);
		}
	}


    public void playStand() {

        try {
            URL url = this.getClass().getClassLoader().getResource("sounds/stand.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
	}
    }


    public void playWin() {

        try {
            URL url = this.getClass().getClassLoader().getResource("sounds/win.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
	}
    }


    public void playLose() {

        try {
            URL url = this.getClass().getClassLoader().getResource("sounds/lose.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
	}
    }




    private void shuffle(){
        //write code to shuffle your deck
        for(int i = playerIndex; i < deck.length; i++){
        	int scramble=(int)(Math.random()*deck.length);
			Card temp=deck[scramble];
			deck[scramble]=deck[i];
			deck[i]=temp;
			System.out.println("Shuffled");
	}
    }


    public void actionPerformed(ActionEvent e) {
	if(e.getSource() == hit){
		hitPressed +=1;
		System.out.println("Hit: " + hitPressed);
		playerIndex += 1;
		this.playHit();

	}
	if(e.getSource() == stand){
		System.out.println("Stand");
		this.playStand();
		if(hand == 16 || hand == 17 || hand == 18){
			points+=1;
			game = false;
			this.playStand();
		}
		else if(hand == 19){
			points+=2;
			game = false;
			this.playStand();

		}
		else if(hand == 20){
			points+=3;
			game = false;
			this.playStand();

		}

		System.out.println("New game start: " + game);

		}
		if(e.getSource() == newgame){
			hand = 0;
			shuffle();
			hitPressed = 0;
			playerIndex = 0;
			points = points - 1;
			playerIndex = 2;
			game = true;
			System.out.println("New game start: " + game);

			repaint();

		}
    }
    
}
