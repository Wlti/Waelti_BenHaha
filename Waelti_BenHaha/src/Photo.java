
import java.awt.Container;
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
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Photo extends JLabel implements Serializable {

private static final long serialVersionUID = 1L;

private String path;
private ImageIcon image;
private File fichier;
private ListePhotos listePhotos;


//Constructeur
public Photo (String path, ListePhotos listePhotos, JPanel imagesJPanel){
this.listePhotos=listePhotos;
this.path = path;
this.image= new ImageIcon(path);
this.setIcon(image);
setVerticalAlignment((int) CENTER_ALIGNMENT);
setHorizontalAlignment(CENTER);


addMouseListener(new MouseAdapter() {
	 public void mouseClicked(MouseEvent e) {
		 int resultat = JOptionPane.showConfirmDialog(null, "Etes-vous s�r de vouloir supprimer cette image ?");
			if (resultat == JOptionPane.YES_OPTION){
				removePhoto(imagesJPanel);	
			}
		
     }
});
}

public Photo (String path){
	this.path = path;
};

public void removePhoto (JPanel imagesJPanel){
	imagesJPanel.remove(this);
	listePhotos.deletePath(path);
	revalidate();
	imagesJPanel.revalidate();
	
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
