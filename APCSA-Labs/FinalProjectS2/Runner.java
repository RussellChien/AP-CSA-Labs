import javax.swing.JFrame;
public class Runner{
	public static void main(String [] args){
		JFrame frame = new JFrame("Fight of the Bumblebee");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Screen sc = new Screen();
		frame.add(sc);
		frame.pack();
		frame.setVisible(true);
		sc.animate();
		
	}
}

