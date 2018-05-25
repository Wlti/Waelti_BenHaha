import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ContactsJPanel extends JPanel{
	private JLabel titre = new JLabel("Contacts");
    private Font font = new Font("Arial",Font.BOLD,20);
	private JPanel centre;
	
public ContactsJPanel (ArrayList<Contact> mesPanels){

	setLayout(new BorderLayout());
	setBackground(Color.black);
	centre.setLayout(new GridLayout(0,1));
	add(titre,BorderLayout.NORTH);
	add(centre,BorderLayout.CENTER);
	titre.setFont(font);
	for(JPanel j: mesPanels ){
		centre.add(j);
	}
}
}
