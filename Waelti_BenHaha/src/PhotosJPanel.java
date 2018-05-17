import java.awt.*;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.util.*;

import javax.swing.*;
 

public class PhotosJPanel extends JPanel {
	//Images par défaut
	
	 JLabel image1 = new JLabel (new ImageIcon("photos/amazing.jpg"));
     JLabel image2 = new JLabel (new ImageIcon("photos/art.jpg"));
     JLabel image3 = new JLabel (new ImageIcon("photos/chateau.jpg"));
     JLabel image4 = new JLabel (new ImageIcon("photos/fiesta.jpg"));
     JLabel image5 = new JLabel (new ImageIcon("photos/hiver.jpg"));
     JLabel image6 = new JLabel (new ImageIcon("photos/lac.jpg"));
     JLabel image7 = new JLabel (new ImageIcon("photos/love.jpg"));
     JLabel image8 = new JLabel (new ImageIcon("photos/maisons.jpg"));
     JLabel image9 = new JLabel (new ImageIcon("photos/vacances.jpg"));
  
    public PhotosJPanel() {
      setBackground(Color.black);
      setLayout(new FlowLayout());
      setSize(400, 300);
      add(image1);
      add(image2);
      add(image3);
      add(image4);
      add(image5);
      add(image6);
      add(image7);
      add(image8);
      add(image9);
      
         
       
    }
   }



