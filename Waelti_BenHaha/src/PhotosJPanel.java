import java.awt.*;
import java.awt.List;
import java.awt.event.ActionEvent;
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
		
	private JLabel image1 = new JLabel (new ImageIcon("photos/art.jpg"));
	private JLabel image2 = new JLabel (new ImageIcon("photos/norvegien.jpg"));
	private JLabel image3 = new JLabel (new ImageIcon("photos/chateau.jpg"));
	private JLabel image4 = new JLabel (new ImageIcon("photos/inseparables.jpg"));
	private JLabel image6 = new JLabel (new ImageIcon("photos/lac.jpg"));
	private JLabel image7 = new JLabel (new ImageIcon("photos/love.jpg"));
	private JLabel image8 = new JLabel (new ImageIcon("photos/maisons.jpg"));
	private JLabel image9 = new JLabel (new ImageIcon("photos/vacances.jpg"));
    private JPanel imagesJPanel = new JPanel ();
    private JPanel ajoutJPanel = new JPanel ();
    private JScrollPane scroll;
    private JLabel ajouterImage = new JLabel (new ImageIcon("photos/plus.png"));
    private JLabel ajoutJLabel = new JLabel ("Ajouter une image");
    
     
    public PhotosJPanel() {
      setLayout(new BorderLayout());
      imagesJPanel.setLayout(new GridLayout(0,1,5,5));
      imagesJPanel.setBackground(Color.black);
      add(imagesJPanel,BorderLayout.CENTER);
      imagesJPanel.add(image1);
      imagesJPanel.add(image2);
      imagesJPanel.add(image3);
      imagesJPanel.add(image4);
      imagesJPanel.add(image6);
      imagesJPanel.add(image7);
      imagesJPanel.add(image8);
      imagesJPanel.add(image9);
      scroll = new JScrollPane(imagesJPanel);
      add(scroll);
      ajouterImage.setVerticalAlignment((int) CENTER_ALIGNMENT);
      
      add(ajoutJPanel,BorderLayout.SOUTH);
      ajoutJPanel.add(ajouterImage);
      ajouterImage.addMouseListener(new MouseAdapter() {
    	  @Override
          public void mouseClicked(MouseEvent e) {
          	//Ouvrir un fichier
    		  JTextArea area = null; 
    		  JPanel panel = new JPanel();
    		  panel.setLayout(new BorderLayout());         
    		  ImageIcon open = new ImageIcon("open.png"); 
    	        JToolBar toolbar = new JToolBar();         
    	        JButton openb = new JButton(open); 
    		 
    		  add(panel,this);
    		  JFileChooser fileopen = new JFileChooser(); 
    		  FileNameExtensionFilter filter = new FileNameExtensionFilter("c files", "c");  
    		  fileopen.addChoosableFileFilter(filter); 
    		  int ret = fileopen.showDialog(panel, "Open file"); 
    		  if (ret == JFileChooser.APPROVE_OPTION) {      
    			  File file = fileopen.getSelectedFile();      
    			  String text = readFile(file);      
    			  area.setText(text);  } 
          }
    	  
	});
      ajoutJLabel.setForeground(Color.white);
      ajoutJPanel.add(ajoutJLabel);
      ajoutJPanel.setBackground(Color.black);
      
    }
    public String readFile (File file) { 
    	 
        StringBuffer fileBuffer = null;     
        String fileString = null;      
        String line = null; 
    
        try {        FileReader in = new FileReader (file);        BufferedReader brd = new BufferedReader (in);        fileBuffer = new StringBuffer() ; 
    
          while ((line = brd.readLine()) != null) {              fileBuffer.append(line + System.getProperty("line.separator"));        } 
    
          in.close();        fileString = fileBuffer.toString();      }      catch  (IOException e ) {        return null;      }      return fileString;     } 
   
   }



