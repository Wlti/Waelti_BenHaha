import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Contact implements Serializable{
	
	//Un contact peut contenir ces données :
	private static final long serialVersionUID = 1L;
	private String nom;
	private String prenom;
	private String numero;
	private String email;
	private String photoProfil = "C:/Users/nadin/git/Waelti_BenHaha/images/photoProfil.png";
	
	//Diverses manières de construire un contact :
	
	public Contact(String prenom, String nom, String numero, String email){
		this.nom = nom;
		this.prenom = prenom;
		this.numero = numero;
		this.email = email;
	}
	
	
	

	public String getNom() {
		return nom;
	}




	public void setNom(String nom) {
		this.nom = nom;
	}




	public String getPrenom() {
		return prenom;
	}




	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}




	public String getNumero() {
		return numero;
	}




	public void setNumero(String numero) {
		this.numero = numero;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPhotoProfil() {
		return photoProfil;
	}




	public void setPhotoProfil(String photoProfil) {
		this.photoProfil = photoProfil;
	}




	public void editerContact(String prenom, String nom, String numero, String email){
		this.nom = nom;
		this.prenom = prenom;
		this.numero = numero;
		this.email = email;
		
	}
	
	public void supprimerContact(JPanel contact, Contact c){
		contact.remove(contact);
		c.editerContact(null, null, null, null);
		contact.revalidate();
		}
	
	
}

