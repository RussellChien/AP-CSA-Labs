import javax.swing.JFrame;
public class Runner{
    public static void main(String args[]){
        Table table = new Table();
        JFrame frame = new JFrame("BlackJack");

        frame.add(table);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
	}
}
