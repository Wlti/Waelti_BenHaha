import javax.swing.JPanel;


public class Contact {
	
	//Un contact peut contenir ces donn�es :
	private static final long serialVersionUID = 123456789101112L;
	private String nom;
	private String prenom;
	private String numero;
	private String email;
	private Photo photo;
	private String identifiantUnique;
	
	//Diverses mani�res de construire un contact :
	public Contact(String nom, String prenom, String numero){
		this.nom = nom;
		this.prenom = prenom;
		this.numero = numero;
		this.identifiantUnique = nom+prenom+numero;
	}
	
	public Contact(String nom, String prenom, String numero, String email){
		this.nom = nom;
		this.prenom = prenom;
		this.numero = numero;
		this.email = email;
		this.identifiantUnique = nom+prenom+numero;
	}
	
	public Contact(String nom, String prenom, String numero, String email, Photo photo){
		this.nom = nom;
		this.prenom = prenom;
		this.numero = numero;
		this.email = email;
		this.photo = photo;
		this.identifiantUnique = nom+prenom+numero;
	}
	
	public Contact(String nom, String prenom, String numero, Photo photo){
		this.nom = nom;
		this.prenom = prenom;
		this.numero = numero;
		this.photo = photo;
		this.identifiantUnique = nom+prenom+numero;
	}
	
	
	//ajouter un contact � sa liste de contacts 
	public static void ajouterContact(Contact contact){
		int compteur = 0;		
		boolean contactExisteDeja = false; 		
		//par d�faut, le contact n'existe pas
		//v�rifier s'il existe en parcourant la liste gr�ce � l'identifiant unique (.equals)
		//si oui, dire qu'il existe d�j� et ne pas l'ajouter
		//si non, l'ajouter
	}
	
	public void editerContact(){
		int compteur = 0;
		//retrouver ce contact gr�ce � son identifiant en parcourant la liste de contacts
		//ouvrir une fen�tre d'�dition
		//enregistrer ou annuler
	}
	
	public void supprimerContact(){
		int compteur = 0;
		//le supprimer gr�ce � l'identifiant this.getIdentifiantUnique equals Contact.getIdentifiantUnique
		}
	
	
	
	//Getters & Setters
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

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public String getIdentifiantUnique() {
		return identifiantUnique;
	}

	public void setIdentifiantUnique(String identifiantUnique) {
		this.identifiantUnique = identifiantUnique;
	}
	}
	

