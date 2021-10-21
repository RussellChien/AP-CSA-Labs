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


public class Screen extends JPanel implements ActionListener{
    private Contact[] contactlist;
    private JTextPane allcontacts;
    private JButton searchfirstname;
    private JButton searchlastname;
    private JButton searchusername;
    private JButton searchdomain;
    private JButton searchdomainextension;
    private JTextField searchinput;
    private JTextPane searchresults;


    public Screen(){

        this.setLayout(null);

        contactlist = new Contact[10];
        contactlist[0] = new Contact("John", "Smith", "john.smith@gmail.com");
        contactlist[1] = new Contact("Jen", "Doe", "jen.doe@gmail.com");
        contactlist[2] = new Contact("George", "Washington", "george.washington@gmail.com");  	contactlist[3] = new Contact("Ben", "Dover", "ben.dover@yahoo.net");
		    contactlist[4] = new Contact("Wren", "Duffy", "wren.duffy@yahoo.net");
		    contactlist[5] = new Contact("Kazuma", "Satou", "kazuma.satou@gmail.com");
		    contactlist[6] = new Contact("Jose", "Go", "jose.go@yahoo.net");
		    contactlist[7] = new Contact("Kirito", "Kun", "kirito.kun@gmail.com");
		    contactlist[8] = new Contact("Akbar", "The Great", "akbur.thegreat@gmail.com");
		    contactlist[9] = new Contact("John", "Cena", "john.cena@gmail.com");


        allcontacts = new JTextPane();
        allcontacts.setBounds(10,120,200,400);
        this.add(allcontacts);
        //add contacts to allcontacts
        String contactstr = "";
        for(int i=0;i<contactlist.length;i++){
            contactstr+=contactlist[i]+"\n";

        allcontacts.setText(contactstr);
        this.setFocusable(true);
        //add search buttons, fields, and result pane
        searchfirstname = new JButton("Search First Name");
        searchfirstname.setBounds(10,0,200,30);
        searchfirstname.addActionListener(this);
        this.add(searchfirstname);

        searchinput = new JTextField();
        searchinput.setBounds(240,50,100,30);
        this.add(searchinput);

        searchlastname = new JButton("Search Last Name");
        searchlastname.setBounds(10,20,200,30);
        searchlastname.addActionListener(this);
        this.add(searchlastname);

        searchusername = new JButton("Search Username");
        searchusername.setBounds(10,40,200,30);
        searchusername.addActionListener(this);
        this.add(searchusername);

        searchdomain = new JButton("Search Domain");
        searchdomain.setBounds(10,60,200,30);
        searchdomain.addActionListener(this);
        this.add(searchdomain);

		    searchdomainextension = new JButton("Search Domain Extension");
        searchdomainextension.setBounds(10,80,200,30);
        searchdomainextension.addActionListener(this);
        this.add(searchdomainextension);


        searchresults = new JTextPane();
        searchresults.setBounds(310,100,200,400);
        this.add(searchresults);
    }

    public Dimension getPreferredSize(){
        //Sets the size of the panel
        return new Dimension(800,600);
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);
    }



    public void actionPerformed(ActionEvent e) {
        //if first search button is pressed
        String contactstr="";
        if(e.getSource()==searchfirstname){
            String firstnamesearch = searchinput.getText();
            for(int i=0;i<contactlist.length;i++){
                if(contactlist[i].getFirstname().equals(firstnamesearch)){
                    contactstr+=contactlist[i]+"\n";
                }
            }
        }

        searchresults.setText(contactstr);

        if(e.getSource()==searchlastname){
            String lastnamesearch = searchinput.getText();
            for(int i=0;i<contactlist.length;i++){
                if(contactlist[i].getLastname().equals(lastnamesearch)){
                    contactstr+=contactlist[i]+"\n";
                }
            }
        }


        searchresults.setText(contactstr);

        if(e.getSource()==searchusername){
            String usernamesearch = searchinput.getText();
            for(int i=0;i<contactlist.length;i++){
                if(contactlist[i].getUsername().equals(usernamesearch)){
                    contactstr+=contactlist[i]+"\n";
                }
            }
        }

        searchresults.setText(contactstr);

        if(e.getSource()==searchdomain){
            String domainsearch = searchinput.getText();
            for(int i=0;i<contactlist.length;i++){
                if(contactlist[i].getDomain().equals(domainsearch)){
                    contactstr+=contactlist[i]+"\n";
                }
            }
        }

        searchresults.setText(contactstr);

        if(e.getSource()==searchdomainextension){
            String domainextensionsearch = searchinput.getText();
            for(int i=0;i<contactlist.length;i++){
                if(contactlist[i].getDomainExtension().equals(domainextensionsearch)){
                    contactstr+=contactlist[i]+"\n";
                }
            }
        }

            searchresults.setText(contactstr);
    }

}
