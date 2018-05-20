
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Photo extends JLabel {

private static final long serialVersionUID = 1L;
private String nom;
private String path;
private ImageIcon image;
private File fichier;
private JLabel supprimerJLabel = new JLabel (new ImageIcon("images/edit.png"));

//Constructeur
public Photo (String nom, String path){
this.nom = nom;
this.path = path;
this.image= new ImageIcon(path);
this.setIcon(image);
setVerticalAlignment((int) CENTER_ALIGNMENT);
setHorizontalAlignment(CENTER);

addMouseListener(new MouseAdapter() {
	 public void mouseClicked(MouseEvent e) {
		JLabel ajouter = new JLabel (new ImageIcon("images/edit.png"));
		JLabel supprimer = new JLabel ();
		add(ajouter);
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
    	//Editer photo
		//Supprimer photo
    }
	
});
}
}
