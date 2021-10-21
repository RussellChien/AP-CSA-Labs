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
import java.util.ArrayList;


public class Table extends JPanel implements ActionListener{
	ArrayList<Card> deck;
	ArrayList<Card> playerCard;
	ArrayList<Card> dealerCard;
	private JButton pointsBet;
	private JButton hitButton;
	private JButton standButton;
	private JButton newGameButton;

	private boolean newGameVisible;
	private boolean hitVisible;
	private boolean standVisible;
	private int playerCardsOut;
	private int dealerCardsOut;
	private Color black;
	private int x = 100;
	private int y= 100;
	private int deckCardsOut = 0;

	private int dealerHand;
	private int playerHand;

	private int playerWinCount;
	private int dealerWinCount;

	private boolean displayDealerCards;

	private boolean gameOn;

	private boolean displayWinOrLose;




	public Table(){

		gameOn = false;
		displayDealerCards = false;
		displayWinOrLose = false;
		deckCardsOut = 0;
		playerCardsOut = 0;
		dealerCardsOut = 0;
		newGameVisible =true;
		hitVisible = false;
		standVisible = false;
		playerHand = 0;
		dealerHand = 0;
		black = new Color(0,0,0);

		deck = new ArrayList<Card>();
		playerCard = new ArrayList<Card>();
		dealerCard = new ArrayList<Card>();

		newGameButton = new JButton("New Game");
		newGameButton.setBounds(350,400,200,30);
		newGameButton.addActionListener(this);
		this.add(newGameButton);


		standButton = new JButton("Stand");
		standButton.setBounds(350,40,100,30);
		standButton.addActionListener(this);
		this.add(standButton);


		hitButton = new JButton("Hit");
		hitButton.setBounds(450,40,100,30);
		hitButton.addActionListener(this);
		this.add(hitButton);


		deck.add(new Card(2, "2", "hearts"));
		deck.add(new Card(3, "3", "hearts"));
		deck.add(new Card(4, "4", "hearts"));
		deck.add(new Card(5, "5", "hearts"));
		deck.add(new Card(6, "6", "hearts"));
		deck.add(new Card(7, "7", "hearts"));
		deck.add(new Card(8, "8", "hearts"));
		deck.add(new Card(9, "9", "hearts"));
		deck.add(new Card(10, "10", "hearts"));
		deck.add(new Card(10, "J", "hearts"));
		deck.add(new Card(10, "Q", "hearts"));
		deck.add(new Card(10, "K", "hearts"));
		deck.add(new Card(11, "A", "hearts"));
		deck.add(new Card(2, "2", "clubs"));
		deck.add(new Card(3, "3", "clubs"));
		deck.add(new Card(4, "4", "clubs"));
		deck.add(new Card(5, "5", "clubs"));
		deck.add(new Card(6, "6", "clubs"));
		deck.add(new Card(7, "7", "clubs"));
		deck.add(new Card(8, "8", "clubs"));
		deck.add(new Card(9, "9", "clubs"));
		deck.add(new Card(10, "10", "clubs"));
		deck.add(new Card(10, "J", "clubs"));
		deck.add(new Card(10, "Q", "clubs"));
		deck.add(new Card(10, "K", "clubs"));
		deck.add(new Card(11, "A", "clubs"));
		deck.add(new Card(2, "2", "diamonds"));
		deck.add(new Card(3, "3", "diamonds"));
		deck.add(new Card(4, "4", "diamonds"));
		deck.add(new Card(5, "5", "diamonds"));
		deck.add(new Card(6, "6", "diamonds"));
		deck.add(new Card(7, "7", "diamonds"));
		deck.add(new Card(8, "8", "diamonds"));
		deck.add(new Card(9, "9", "diamonds"));
		deck.add(new Card(10, "10", "diamonds"));
		deck.add(new Card(10, "J", "diamonds"));
		deck.add(new Card(10, "Q", "diamonds"));
		deck.add(new Card(10, "K", "diamonds"));
		deck.add(new Card(11, "A", "diamonds"));
		deck.add(new Card(2, "2", "spades"));
		deck.add(new Card(3, "3", "spades"));
		deck.add(new Card(4, "4", "spades"));
		deck.add(new Card(5, "5", "spades"));
		deck.add(new Card(6, "6", "spades"));
		deck.add(new Card(7, "7", "spades"));
		deck.add(new Card(8, "8", "spades"));
		deck.add(new Card(9, "9", "spades"));
		deck.add(new Card(10, "10", "spades"));
		deck.add(new Card(10, "J", "spades"));
		deck.add(new Card(10, "Q", "spades"));
		deck.add(new Card(10, "K", "spades"));
		deck.add(new Card(11, "A", "spades"));

        shuffle();

	}

	public Dimension getPreferredSize() {
        //Sets the size of the panel
        return new Dimension(1000,600);


    public void paintComponent(Graphics g){
        super.paintComponent(g);
		g.setColor(black);
        g.fillRect(0,0,1000,600);
        for(int i = 0; i<playerCard.size(); i++){
			playerCard.get(i).drawMe(g ,x + i*120 ,y);
		}

		for(int i = 0; i<dealerCard.size(); i++){
			dealerCard.get(i).drawMe(g, x + i*120, y+300);

		}
		if(displayDealerCards == false && dealerCard.size() > 0){
			Color orange = new Color(219,146,28);
			g.setColor(orange);

			g.fillRect(x, y+300,120,150);
		}
		hitButton.setVisible(hitVisible);
		standButton.setVisible(standVisible);
		newGameButton.setVisible(newGameVisible);

		g.setColor(Color.white);
		Font font = new Font("Arial", Font.PLAIN, 20);
		g.setFont(font);
		g.drawString("Player Cards: ", 10, y);
		g.drawString("Dealer Cards: ", 10, y+300);
		g.setFont(font);
		g.drawString("Player Hand: " + getPlayerHand(), 600,y);

		int dealer_value = 0;
		if (displayDealerCards == false) {
			if (dealerCard.size() > 1) {
				dealer_value = dealerCard.get(1).getValue();
			}
		} else {
			dealer_value = getDealerHand();
		}
		g.drawString("Dealer Hand: " + dealer_value, 600, y+300);

		if(displayWinOrLose){
			if(checkWinner() == 0){
				g.drawString("You Win", 500, 300);				//player wins
			}else if (checkWinner() == 1){
				g.drawString("Dealer Wins", 500, 300);
				//dealer wins
			}else if (checkWinner() == -1){
				g.drawString("Stand", 500, 300);
				//tie
			}
		}
		g.drawString("Player Wins: " + playerWinCount, 600,y+50);
		g.drawString("Dealer Wins: " + dealerWinCount, 600, y+350);





	public int getPlayerHand(){
		int numOfAces = 0;
		playerHand = 0;
		for(int i = 0; i<playerCard.size(); i++){
			int currentValue = playerCard.get(i).getValue();
			playerHand = playerHand + currentValue;
			if(currentValue == 11){
				numOfAces += 1;

			}
		}

		if(playerHand <= 21){
			return playerHand;
		}
		for(int i =0; i<numOfAces; i++){
			playerHand -= 10;
			if(playerHand <= 21){
				return playerHand;
			}
		}

		return playerHand;
	}


	public int getDealerHand(){
		int numOfAces = 0;
		dealerHand = 0;
		for(int i = 0; i<dealerCard.size(); i++){
			int currentValue = dealerCard.get(i).getValue();
			dealerHand = dealerHand + currentValue;
			if(currentValue == 11){
				numOfAces += 1;

			}
		}

		if(dealerHand <= 21){
			return dealerHand;
		}
		for(int i =0; i<numOfAces; i++){
			dealerHand -= 10;
			if(dealerHand <= 21){
				return dealerHand;
			}
		}

		return dealerHand;

	}




	public void hitPlayer() {
		playerCard.add(deck.get(deckCardsOut));
		deckCardsOut++;
	}

	public void hitDealer() {
		dealerCard.add(deck.get(deckCardsOut));
		deckCardsOut++;
	}

	public void resetHands() {
		playerCard.clear();
		dealerCard.clear();
	}


	public int checkWinner(){
		//returns one if dealer wins
		// zero if player wins
		// negative one if tie
		if(getPlayerHand() > 21) {
			if (getDealerHand() > 21){
				return -1; // tie
			} else {
				return 1; //dealer wins
			}
		} else if (getDealerHand() > 21) {
			return 0; // player wins
		} else if((21 - getPlayerHand()) < (21 - getDealerHand())){
			return 0; //player wins
		} else if((21 - getDealerHand()) < (21 - getPlayerHand())){
			return 1; //dealer wins
		}
		return -1;
	}

	public boolean checkGameOver(){
		//returns one if dealer wins
		// zero if player wins
		// negative one if tie
		if(getPlayerHand() >= 21 || getDealerHand() > 21) {
			return true;
		}
		return false;

	}

	public void dealerPlay(){
		//write code for dealer to hit or stand
		if(getPlayerHand() > 21){
			return;
		}

		if(getDealerHand() < 17){
			do{
				hitDealer();

			}while(getDealerHand() < 17);
		}

	}



	private void shuffle(){
        //write code to shuffle your deck
        for(int i = 0; i < deck.size() -1; i++){
			int a = (int)(Math.random() * deck.size());
			Card temp = deck.get(i);
			Card temp2 = deck.get(a);
			//deck.remove(i);
			//deck.remove(a);
			deck.set(i, temp2);
			deck.set(a, temp);






	public void newGame() {
		resetHands();
		shuffle();
		deckCardsOut = 0;
		repaint();
		//playerCardsOut = 0;
		//dealerCardsOut = 0;
		newGameVisible =false;
		hitVisible = true;
		standVisible = true;
		displayDealerCards = false;
		displayWinOrLose = false;

		hitPlayer();
		hitPlayer();
		hitDealer();
		hitDealer();

		if (checkGameOver()) {
			standAction();
		}
	}

	public void standAction() {
		displayDealerCards = true;
		dealerPlay();
		if(checkWinner() == 0){
			playerWinCount += 1;
			//player wins
		}else if (checkWinner() == 1){
			dealerWinCount += 1;
			//dealer wins
		}else if (checkWinner() == -1){
			//tie
		}
		displayWinOrLose = true;
		newGameVisible = true;
		standVisible = false;
		hitVisible = false;
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == newGameButton){

			newGame();
			repaint();
		}

		if(e.getSource() == hitButton){
			hitPlayer();
			if (checkGameOver()) {
				standAction();
			}
			repaint();
		}
		if(e.getSource() == standButton){
			standAction();

			repaint();
		}

	}
}
