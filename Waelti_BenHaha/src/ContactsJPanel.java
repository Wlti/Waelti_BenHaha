import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;



public class ContactsJPanel extends JPanel{
	private JLabel titre = new JLabel("Contacts");
    private Font font = new Font("Arial",Font.BOLD,25);
   	private JPanel centre;
   	private JPanelPourUnContact contact;
	private JScrollPane scroll;
	private JLabel ajouterContact = new JLabel (new ImageIcon("photos/addContact.png"));
	
	
public ContactsJPanel (ArrayList<Contact> mesContacts){
	centre = new JPanel ();
	for(Contact mContact :mesContacts){
		contact = new JPanelPourUnContact(mContact);
		centre.add(contact);
		
	}
	setLayout(new BorderLayout());
	 add(ajouterContact,BorderLayout.SOUTH);
	 ajouterContact.setFont(font);
	 ajouterContact.setForeground(Color.white);
	 ajouterContact.setHorizontalAlignment((int) CENTER_ALIGNMENT);
	
	setBackground(Color.black);
	centre.setLayout(new GridLayout(0,1,10,20));
	add(titre,BorderLayout.NORTH);
	add(centre,BorderLayout.CENTER);
	titre.setFont(font);
	titre.setForeground(Color.white);
	titre.setHorizontalAlignment((int) CENTER_ALIGNMENT);
	scroll = new JScrollPane(centre);
     add(scroll);
     centre.setBackground(Color.white);
     
    
	
}
}
