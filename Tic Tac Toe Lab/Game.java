import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Game{
	private int[][] table;
	private int turn;
	private int playerOneWins;
	private int playerTwoWins;
	private boolean buttonVisible;
	
	public Game(){
		table = new int[3][3];
		turn = 0;
		playerOneWins = 0;
		playerTwoWins = 0;
		buttonVisible = true;
	}
	
	public void printTable(){
		for(int r = 0; r < table.length; r++){
			for(int c = 0; c < table[r].length; c++){
				System.out.print(table[r][c]);
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	
	
	public void playX() {
	
        	try {
           		URL url = this.getClass().getClassLoader().getResource("X.wav");
            		Clip clip = AudioSystem.getClip();
            		clip.open(AudioSystem.getAudioInputStream(url));
            		clip.start();
        	} catch (Exception exc) {
            	  	exc.printStackTrace(System.out);
		}
	}
		
    
    
    public void playO() {
	
        try {
            URL url = this.getClass().getClassLoader().getResource("O.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
	}
    }	
    
	
	public void insertXO(int a, int b){
		if(checkFull() == false && checkTicTacToe() != 1 && checkTicTacToe() != 2){
			if(turn%2 == 0){
				System.out.println("Player 1");
				if(a < 100 && b < 100){
					if(table[0][0] == 0){
						table[0][0] = 1;
						this.playX();
						turn++;
					}
				}
				else if(a > 100 && a < 200 && b < 100){
					if(table[0][1] == 0){
						table[0][1] = 1;
						this.playX();
						turn++;
					}
				}
				else if(a > 200 && a < 300 && b < 100){
					if(table[0][2] == 0){
						table[0][2] = 1;
						this.playX();
						turn++;
					}
				}
				else if(a < 100 && b > 100 && b < 200){
					if(table[1][0] == 0){
						table[1][0] = 1;
						this.playX();
						turn++;
					}
				}
				else if(a > 100 && a < 200 && b > 100 && b < 200){
					if(table[1][1] == 0){
						table[1][1] = 1;
						this.playX();
						turn++;
					}
				}
				else if(a > 200 && a < 300 && b > 100 && b < 200){
					if(table[1][2] == 0){
						table[1][2] = 1;
						this.playX();
						turn++;
					}
				}
				else if(a < 100 && b > 200 && b < 300){
					if(table[2][0] == 0){
						table[2][0] = 1;
						this.playX();
						turn++;
					}
				}
				else if(a > 100 && a < 200 && b > 200 && b < 300){
					if(table[2][1] == 0){
						table[2][1] = 1;
						this.playX();
						turn++;
					}
				}
				else if(a > 200 && a < 300 && b > 200 && b < 300){
					if(table[2][2] == 0){
						table[2][2] = 1;
						this.playX();
						turn++;
					}
				}
				
				
			}
			if(turn%2 == 1){
				System.out.println("Player 2");
				if(a < 100 && b < 100){
					if(table[0][0] == 0){
						table[0][0] = 2;
						this.playO();
						turn++;
					}
				}
				else if(a > 100 && a < 200 && b < 100){
					if(table[0][1] == 0){
						table[0][1] = 2;
						this.playO();
						turn++;
					}
				}
				else if(a > 200 && a < 300 && b < 100){
					if(table[0][2] == 0){
						table[0][2] = 2;
						this.playO();
						turn++;
					}
				}
				else if(a < 100 && b > 100 && b < 200){
					if(table[1][0] == 0){
						table[1][0] = 2;
						this.playO();
						turn++;
					}
				}
				else if(a > 100 && a < 200 && b > 100 && b < 200){
					if(table[1][1] == 0){
						table[1][1] = 2;
						this.playO();
						turn++;
					}
				}
				else if(a > 200 && a < 300 && b > 100 && b < 200){
					if(table[1][2] == 0){
						table[1][2] = 2;
						this.playO();
						turn++;
					}
				}
				else if(a < 100 && b > 200 && b < 300){
					if(table[2][0] == 0){
						table[2][0] = 2;
						this.playO();
						turn++;
					}
				}
				else if(a > 100 && a < 200 && b > 200 && b < 300){
					if(table[2][1] == 0){
						table[2][1] = 2;
						this.playO();
						turn++;
					}
				}	
				else if(a > 200 && a < 300 && b > 200 && b < 300){
					if(table[2][2] == 0){
						table[2][2] = 2;
						this.playO();
						turn++;
					}
				}
				
			}
		}
	}
	
	public boolean checkFull(){
		for(int r = 0; r < table.length; r++){
			for(int c = 0; c < table[r].length; c++){
				if(table[r][c] == 0){
					return false;
				}
			}
		}
		return true;	
	}
	
	public int checkTicTacToe(){
		for(int r = 0; r < table.length-2; r++){
			for(int c = 0; c < table[r].length-2; c++){
				if(table[r][c] == 1 && table[r+1][c] == 1 && table[r+2][c] == 1){
					//vertical 1
					return 1;
				}
				else if(table[r][c+1] == 1 && table[r+1][c+1] == 1 && table[r+2][c+1] == 1){
					//vertical 2
					return 1;
				}
				else if(table[r][c+2] == 1 && table[r+1][c+2] == 1 && table[r+2][c+2] == 1){
					//vertical 3
					return 1;
				}
				else if(table[r][c] == 1 && table[r][c+1] == 1 && table[r][c+2] == 1){
					//horizontal 1 
					return 1;
				}
				else if(table[r+1][c] == 1 && table[r+1][c+1] == 1 && table[r+1][c+2] == 1){
					//horizontal 2
					return 1;
				}
				else if(table[r+2][c] == 1 && table[r+2][c+1] == 1 && table[r+2][c+2] == 1){
					//horizontal 3
					return 1;
				}
				else if(table[r][c] == 1 && table[r+1][c+1] == 1 && table[r+2][c+2] == 1){
					//diagonal 1
					return 1; 
				}
				else if(table[r][c+2] == 1 && table[r+1][c+1] == 1 && table[r+2][c] == 1){
					//diagonal 2
					return 1;
				}
				
				if(table[r][c] == 2 && table[r+1][c] == 2 && table[r+2][c] == 2){
					//vertical 1
					return 2;
				}
				else if(table[r][c+1] == 2 && table[r+1][c+1] == 2 && table[r+2][c+1] == 2){
					//vertical 2
					return 2;
				}
				else if(table[r][c+2] == 2 && table[r+1][c+2] == 2 && table[r+2][c+2] == 2){
					//vertical 3
					return 2;
				}
				else if(table[r][c] == 2 && table[r][c+1] == 2 && table[r][c+2] == 2){
					//horizontal 1 
					return 2;
				}
				else if(table[r+1][c] == 2 && table[r+1][c+1] == 2 && table[r+1][c+2] == 2){
					//horizontal 2
					return 2;
				}
				else if(table[r+2][c] == 2 && table[r+2][c+1] == 2 && table[r+2][c+2] == 2){
					//horizontal 3
					return 2;
				}
				else if(table[r][c] == 2 && table[r+1][c+1] == 2 && table[r+2][c+2] == 2){
					//diagonal 1
					return 2; 
				}
				else if(table[r][c+2] == 2 && table[r+1][c+1] == 2 && table[r+2][c] == 2){
					//diagonal 2
					return 2;
				}			
			}
		}
		return 0;
	}
	
	public void CPUPlay(){
		if(checkFull() == false && checkTicTacToe() != 2 && checkTicTacToe() != 1 ){
			for(int r = 0; r < table.length-2; r++){
				for(int c = 0; c < table[r].length-2; c++){
					if(turn%2 == 1){
						if(table[r][c] == 1 && table[r][c+1] == 1 && table[r][c+2] == 0){
							table[r][c+2] = 2;
							turn++;
						}
						else if(table[r][c] == 1 && table[r][c+1] == 0 && table[r][c+2] == 1){
							table[r][c+1] = 2;
							turn++;
						}
						else if(table[r][c] == 0 && table[r][c+1] == 1 && table[r][c+2] == 1){
							table[r][c] = 2;
							turn++;
						}
						else if(table[r+1][c] == 1 && table[r+1][c+1] == 1 && table[r+1][c+2] == 0){
							table[r+1][c+2] = 2;
							turn++;
						}
						else if(table[r+1][c] == 1 && table[r+1][c+1] == 0 && table[r+1][c+2] == 1){
							table[r+1][c+1] = 2;
							turn++;
						}
						else if(table[r+1][c] == 0 && table[r+1][c+1] == 1 && table[r+1][c+2] == 1){
							table[r+1][c] = 2;
							turn++;
						}
						else if(table[r+2][c] == 1 && table[r+2][c+1] == 1 && table[r+2][c+2] == 0){
							table[r+2][c+2] = 2;
							turn++;
						}
						else if(table[r+2][c] == 1 && table[r+2][c+1] == 0 && table[r+2][c+2] == 1){
							table[r+2][c+1] = 2;
							turn++;
						}
						else if(table[r+2][c] == 0 && table[r+2][c+1] == 1 && table[r+2][c+2] == 1){
							table[r+2][c] = 2;
							turn++;
						}
						else if(table[r][c] == 1 && table[r+1][c] == 1 && table[r+2][c] == 0){
							table[r+2][c] = 2;
							turn++;
						}
						else if(table[r][c] == 1 && table[r+1][c] == 0 && table[r+2][c] == 1){
							table[r+1][c] = 2;
							turn++;
						}
						else if(table[r][c] == 0 && table[r+1][c] == 1 && table[r+2][c] == 1){
							table[r][c] = 2;
							turn++;
						}
						else if(table[r][c+1] == 1 && table[r+1][c+1] == 1 && table[r+2][c+1] == 0){
							table[r+2][c+1] = 2;
							turn++;
						}
						else if(table[r][c+1] == 1 && table[r+1][c+1] == 0 && table[r+2][c+1] == 1){
							table[r+1][c+1] = 2;
							turn++;
						}
						else if(table[r][c+1] == 0 && table[r+1][c+1] == 1 && table[r+2][c+1] == 1){
							table[r][c+1] = 2;
							turn++;
						}
						else if(table[r][c+2] == 1 && table[r+1][c+2] == 1 && table[r+2][c+2] == 0){
							table[r+2][c+2] = 2;
							turn++;
						}
						else if(table[r][c+2] == 1 && table[r+1][c+2] == 0 && table[r+2][c+2] == 1){
							table[r+1][c+2] = 2;
							turn++;
						}
						else if(table[r][c+2] == 0 && table[r+1][c+2] == 1 && table[r+2][c+2] == 1){
							table[r][c+2] = 2;
							turn++;
						}
						else if(table[r][c] == 1 && table[r+1][c+1] == 1 && table[r+2][c+2] == 0){
							table[r+2][c+2] = 2;
							turn++;
						}
						else if(table[r][c] == 1 && table[r+1][c+1] == 0 && table[r+2][c+2] == 1){
							table[r+1][c+1] = 2;
							turn++;
						}
						else if(table[r][c] == 0 && table[r+1][c+1] == 1 && table[r+2][c+2] == 1){
							table[r][c] = 2;
							turn++;
						}
						else if(table[r][c+2] == 1 && table[r+1][c+1] == 1 && table[r+2][c] == 0){
							table[r+2][c] = 2;
							turn++;
						}
						else if(table[r][c+2] == 1 && table[r+1][c+1] == 0 && table[r+2][c] == 1){
							table[r+1][c+1] = 2;
							turn++;
						}
						else if(table[r][c+2] == 0 && table[r+1][c+1] == 1 && table[r+2][c] == 1){
							table[r][c+2] = 2;
							turn++;
						}	
						else{
							boolean random = true;
							while(random){
								int random1 = (int)(Math.random()*3);
								int random2 = (int)(Math.random()*3);
								if(table[random1][random2] == 0){
									table[random1][random2] = 2;
									turn++;
									random = false;
								}
							}
						}
							
					} 
				}
				
			}
		} 
	}
	
	public void reset(){
		for(int r = 0; r < table.length; r++){
			for(int c = 0; c < table[r].length; c++){
				table[r][c] = 0;
			}
		}
		turn = 0;
		buttonVisible = true;
	}
	
	public void update(){
		if(checkTicTacToe() == 1){
			playerOneWins++;
			
		}
		else if(checkTicTacToe() == 2){
			playerTwoWins++;
		}
		
		
	}
	
	public int getPlayerOne(){
		return playerOneWins;	
	}
	public int getPlayerTwo(){
		return playerTwoWins;	
	}
	
	public boolean buttons(){
		return buttonVisible;
	}
	
	public void getButton(boolean a){
		buttonVisible = a;
	}
	
	public void drawMe(Graphics g){
		g.setColor(Color.black);
		g.drawRect(0,0,100,100); //box 1
		g.drawRect(100,0,100,100); //box 2
		g.drawRect(200,0,100,100); //box 3
		g.drawRect(0,100,100,100); //box 4
		g.drawRect(0,200,100,100); //box 5
		g.drawRect(100,100,100,100); //box 6
		g.drawRect(200,100,100,100); //box 7
		g.drawRect(100,200,100,100); //box 8
		g.drawRect(200,200,100,100); //box 9
		
		
       
        
		Font game = new Font("Arial", Font.PLAIN, 40);
        g.setFont(game);
        
        //box 1
		if(table[0][0] == 1){
			g.drawString("X", 50, 50);
		}
		else if(table[0][0] == 2){
			g.drawString("O", 50, 50);
		}
		
		//box 2
		if(table[0][1] == 1){
			g.drawString("X", 150, 50);
		}
		else if(table[0][1] == 2){
			g.drawString("O", 150, 50);
		}
		
		//box 3
		if(table[0][2] == 1){
			g.drawString("X", 250, 50);
		}
		else if(table[0][2] == 2){
			g.drawString("O", 250, 50);
		}
		
		//box 4
		if(table[1][0] == 1){
			g.drawString("X", 50, 150);
		}
		else if(table[1][0] == 2){
			g.drawString("O", 50, 150);
		}
		
		//box 5
		if(table[1][1] == 1){
			g.drawString("X", 150, 150);
		}
		else if(table[1][1] == 2){
			g.drawString("O", 150, 150);
		}
		
		//box 6
		if(table[1][2] == 1){
			g.drawString("X", 250, 150);
		}
		else if(table[1][2] == 2){
			g.drawString("O", 250, 150);
		}
		
		//box 7
		if(table[2][0] == 1){
			g.drawString("X", 50, 250);
		}
		else if(table[2][0] == 2){
			g.drawString("O", 50, 250);
		}
		
		//box 8
		if(table[2][1] == 1){
			g.drawString("X", 150, 250);
		}
		else if(table[2][1] == 2){
			g.drawString("O", 150, 250);
		}
		
		//box 9
		if(table[2][2] == 1){
			g.drawString("X", 250, 250);
		}
		else if(table[2][2] == 2){
			g.drawString("O", 250, 250);
		}
		
	}
	

}


