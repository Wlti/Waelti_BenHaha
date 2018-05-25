import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Contact extends JPanel implements Serializable{
	
	//Un contact peut contenir ces données :
	private static final long serialVersionUID = 1L;
	private JLabel nom;
	private JLabel prenom;
	private JLabel numero;
	private JLabel email;
	private JLabel photoProfil = new JLabel(new ImageIcon(""));
	
	//Diverses manières de construire un contact :
	
	public Contact(String nom, String prenom, String numero, String email){
		this.nom = new JLabel(nom);
		this.prenom = new JLabel(prenom);
		this.numero = new JLabel(numero);
		this.email = new JLabel(email);
	}
	
	
	public void editerContact(String nom, String prenom, String numero, String email){
		this.nom = new JLabel(nom);
		this.prenom = new JLabel(prenom);
		this.numero = new JLabel(numero);
		this.email = new JLabel(email);
		
	}
	
	public void supprimerContact(JPanel contact, Contact c){
		remove(contact);
		remove(c);
		revalidate();
		}
	
	
}

