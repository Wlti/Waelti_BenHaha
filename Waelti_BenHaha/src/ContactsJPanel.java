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


public class ContactsJPanel extends JPanel{
	private JLabel titre = new JLabel("Contacts");
    private Font font = new Font("Arial",Font.BOLD,20);
    private JLabel nom;
    private JLabel prenom;
    private JLabel numero;
    private JLabel email;
    private JLabel photoProfil;
	private JPanel centre;
	private JScrollPane scroll;
	private JLabel ajouterContact = new JLabel (new ImageIcon("photos/addContact.png"));
	private JButton supprimer;
	private JButton editer;
	
public ContactsJPanel (ArrayList<Contact> mesContacts){

	setLayout(new BorderLayout());
	 add(ajouterContact,BorderLayout.SOUTH);
	 ajouterContact.setFont(font);
	 ajouterContact.setForeground(Color.white);
	 ajouterContact.setHorizontalAlignment((int) CENTER_ALIGNMENT);
	centre = new JPanel ();
	setBackground(Color.black);
	centre.setLayout(new GridLayout(0,1));
	add(titre,BorderLayout.NORTH);
	add(centre,BorderLayout.CENTER);
	titre.setFont(font);
	titre.setForeground(Color.white);
	titre.setHorizontalAlignment((int) CENTER_ALIGNMENT);
	 scroll = new JScrollPane(centre);
     add(scroll);
     centre.setBackground(Color.white);
     
     
	for(Contact j: mesContacts ){
		centre.add(Box.createRigidArea(new Dimension (0,10)));
		centre.add(this.nom=new JLabel("Nom : "+j.getNom()));
		centre.add(this.prenom=new JLabel("Prenom : "+j.getPrenom()));
		centre.add(this.numero=new JLabel("Tél. : "+j.getNumero()));
		centre.add(this.email=new JLabel("Email : "+j.getEmail()));
		centre.add(this.supprimer=new JButton ("Supprimer"));
		centre.add(this.editer=new JButton("Editer"));
		this.nom.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		this.prenom.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		this.numero.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		this.email.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		centre.add(Box.createRigidArea(new Dimension (0,10)));
	}
	
	
}
}
