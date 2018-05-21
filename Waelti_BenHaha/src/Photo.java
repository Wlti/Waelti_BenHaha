
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

private String path;
private ImageIcon image;
private File fichier;


//Constructeur
public Photo (String path){
this.path = path;
this.image= new ImageIcon(path);
this.setIcon(image);
setVerticalAlignment((int) CENTER_ALIGNMENT);
setHorizontalAlignment(CENTER);


addMouseListener(new MouseAdapter() {
	 public void mouseClicked(MouseEvent e) {
	System.out.println("Supprimer l'image");
	
		
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



this.addMouseListener(new MouseAdapter() {
	 public void mouseClicked(MouseEvent e) {
		 setIcon(null);
    }
});
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
