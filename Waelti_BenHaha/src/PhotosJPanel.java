import java.awt.*;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
 

public class PhotosJPanel extends JPanel {
	

	
	//Images par défaut	
	ArrayList <String> mesPath;
	
	
	
	//Ecran
    private JPanel imagesJPanel = new JPanel ();
    private JPanel ajoutJPanel = new JPanel ();
    private JScrollPane scroll;
    private JLabel ajouterImage = new JLabel (new ImageIcon("photos/plus.png"));
    private JLabel ajoutJLabel = new JLabel ("Ajouter une image");
    private JLabel gallerieButton = new JLabel("Gallerie photos");
    private Font font = new Font("Arial",Font.BOLD,20);
     
    public PhotosJPanel(ListePhotos listePhotos) {
    	
    //Design, structure
      setLayout(new BorderLayout());
      setBackground(Color.black);
      add(gallerieButton,BorderLayout.NORTH);
      gallerieButton.setForeground(Color.white);
      gallerieButton.setAlignmentX(CENTER_ALIGNMENT);
      gallerieButton.setFont(font);
      gallerieButton.setHorizontalAlignment((int) CENTER_ALIGNMENT);
      imagesJPanel.setLayout(new GridLayout(0,1,5,5));
      imagesJPanel.setBackground(Color.black);
      add(imagesJPanel,BorderLayout.CENTER);
      
      //ajout des images
      mesPath = listePhotos.getListePhotos();
      
      for(String a:mesPath){
    	  Photo photo = new Photo (a);
    	  imagesJPanel.add(photo);
      }
     
      scroll = new JScrollPane(imagesJPanel);
      add(scroll);
      ajouterImage.setVerticalAlignment((int) CENTER_ALIGNMENT);
      
      
      
      //Ajouter une image
      add(ajoutJPanel,BorderLayout.SOUTH);
     ajoutJPanel.add(ajouterImage);
      ajouterImage.addMouseListener(new MouseAdapter() {
    	  @Override
          public void mouseClicked(MouseEvent e) {
    		  JPanel panel = new JPanel();
    		  panel.setLayout(new BorderLayout()); 
    		  JFileChooser fileopen = new JFileChooser(); 
    		  FileNameExtensionFilter filter = new FileNameExtensionFilter("Images png", "png");  
    		  FileNameExtensionFilter filter2 = new FileNameExtensionFilter("Images jpg", "jpg"); 
    		  fileopen.addChoosableFileFilter(filter); 
    		  fileopen.addChoosableFileFilter(filter2); 
    		  int ret = fileopen.showDialog(panel, "Open file"); 
    		  if (ret == JFileChooser.APPROVE_OPTION) {      
    			  File file = fileopen.getSelectedFile(); 
    			  Photo imagePhoto = new Photo (file);
    			  imagesJPanel.add(imagePhoto);
    			   } 
          }
    	  
	});
      ajoutJLabel.setForeground(Color.white);
      ajoutJLabel.setFont(font);
      ajoutJPanel.add(ajoutJLabel);
      ajoutJPanel.setBackground(Color.black);
      
    }
    
    //Ajouter une image
    public String readFile (File file) { 
    	 
        StringBuffer fileBuffer = null;     
        String fileString = null;      
        String line = null; 
    
        try {        
        	FileReader in = new FileReader (file);        
        	BufferedReader brd = new BufferedReader (in);        
        	fileBuffer = new StringBuffer() ; 
          while ((line = brd.readLine()) != null) {              
        	  fileBuffer.append(line + System.getProperty("line.separator"));        
        	  } 
          in.close();        
          fileString = fileBuffer.toString();      
          }      catch  (IOException e ) 
        {        return null;      
        }      
        return fileString;     
        } 
   
   


}




