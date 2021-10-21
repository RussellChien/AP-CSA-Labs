import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class Screen extends JPanel implements ActionListener{
 
	SlotMachine sm;
	JButton spinButton;
	JButton bet1;
	JButton bet5;
	JButton bet10;
	int y = 500;
	int win;
	
	public Screen(){
		this.setLayout(null);
		
		spinButton = new JButton("Spin");
		spinButton.setBounds(150, 450, 100, 50);
		spinButton.addActionListener(this);
		this.add(spinButton);
		
		bet1 = new JButton("Bet 1 pt");
		bet1.setBounds(150, 200, 100, 50);
		bet1.addActionListener(this);
		this.add(bet1);
		
		bet5 = new JButton("Bet 5 pt");
		bet5.setBounds(150, 250, 100, 50);
		bet5.addActionListener(this);
		this.add(bet5);
		
		bet10 = new JButton("Bet 10 pt");
		bet10.setBounds(150, 300, 100, 50);
		bet10.addActionListener(this);
		this.add(bet10);
		
		sm = new SlotMachine();
		
		this.setFocusable(true);
	}
 
 
	public Dimension getPreferredSize(){
		return new Dimension(800, 600);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Color red = new Color(255,0,0);
		g.setColor(red);

		g.fillRect(0, y, 100, 100);
		g.fillRect(300, y, 100, 100);
		animate();
		
		sm.drawMe(g);
	}
	
	public void animate(){

		while(sm.win == 1){
			if(y <0){
				y = 500;
			}
			else{
				y--;
			}
			try{
					Thread.sleep(50); 
			}
			catch(InterruptedException ex){
				Thread.currentThread().interrupt();
			}
		}
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == spinButton){
			sm.play();
		}
		if(e.getSource() == bet1){
			sm.bet(1);
		}
		if(e.getSource() == bet5){
			sm.bet(5);
		}
		if(e.getSource() == bet10){
			sm.bet(10);
		}
		repaint();
	}
 
}
