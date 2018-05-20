
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Photo extends JLabel implements Serializable {

private static final long serialVersionUID = 1L;
private String nom;
private String path;
private ImageIcon image;
private File fichier;


//Constructeur
public Photo (String nom, String path){
this.nom = nom;
this.path = path;
this.image= new ImageIcon(path);
this.setIcon(image);
setVerticalAlignment((int) CENTER_ALIGNMENT);
setHorizontalAlignment(CENTER);
try {
	serializePhoto(this);
} catch (IOException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}


addMouseListener(new MouseAdapter() {
	 public void mouseClicked(MouseEvent e) {
	System.out.println("Supprimer l'image");
		setIcon(null);
     }
});
}

//Constructeur
public Photo (File fichier){
this.fichier = fichier;
this.path = fichier.getAbsolutePath();;
this.image= new ImageIcon(path);
this.setIcon(image);
setVerticalAlignment((int) CENTER_ALIGNMENT);
setHorizontalAlignment(CENTER);
try {
	serializePhoto(this);
} catch (IOException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}


this.addMouseListener(new MouseAdapter() {
	 public void mouseClicked(MouseEvent e) {
		 setIcon(null);
    }
});
}

private static void serializePhoto(Photo photo) throws IOException {		
	//enregistre ma photo dans le fichier photo.ser
	FileOutputStream fichier = new FileOutputStream("photoSerialisation/photo.ser");
	BufferedOutputStream bfichier = new BufferedOutputStream (fichier);
	ObjectOutputStream fichierObjectSerialize = new ObjectOutputStream(bfichier);
	fichierObjectSerialize.writeObject(photo); 
	fichierObjectSerialize.close();
}

private static void deserializePhoto(String path)  throws IOException, ClassNotFoundException {		
	//lit la photo enregistrée dans photo.ser
	Photo temporaire;
	FileInputStream fichier = new FileInputStream(path);						
	BufferedInputStream bfichier = new BufferedInputStream (fichier);
	ObjectInputStream lectureObjet = new ObjectInputStream(bfichier);
	temporaire=(Photo) lectureObjet.readObject();
	lectureObjet.close();
	
}


public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getPath() {
	return path;
}

public void setPath(String path) {
	this.path = path;
}

public ImageIcon getImage() {
	return image;
}

public void setImage(ImageIcon image) {
	this.image = image;
}

public File getFichier() {
	return fichier;
}

public void setFichier(File fichier) {
	this.fichier = fichier;
}

}
