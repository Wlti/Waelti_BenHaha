import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;


public class Settings extends JPanel{
	
		
	//Mode Avion
	private JLabel avionImage = new JLabel (new ImageIcon("settings/avion.png"));
	private JLabel avion = new JLabel ("  Mode Avion");
	private JLabel avionOver = new JLabel (new ImageIcon("settings/avionOver.png"));
	
	//Wi-Fi
	private JLabel wifiImage = new JLabel (new ImageIcon("settings/wifi.png"));
	private JLabel wifi = new JLabel ("  Wi-Fi");
	
	//Bluetooth
	private JLabel bluetoothImage = new JLabel (new ImageIcon("settings/bluetooth.png"));
	private JLabel bluetooth = new JLabel ("  Bluetooth");
	
	//Données cellulaires
	private JLabel donneescelImage = new JLabel (new ImageIcon("settings/donnesCel.png"));
	private JLabel donneescel = new JLabel ("  Données cellulaires");
	
	//Partage de connexion
	private JLabel partageconImage = new JLabel (new ImageIcon("settings/partageConnexion.png"));
	private JLabel partagecon = new JLabel ("  Partage connexion");
	
	//Opérateur
	private JLabel opImage = new JLabel (new ImageIcon("settings/operateur.png"));
	private JLabel op = new JLabel ("  Opérateur");
		
	//Fond d'écran
	private JLabel fondImage = new JLabel (new ImageIcon("settings/fondecran.png"));
	private JLabel fond = new JLabel ("  Fond d'écran");
	
	//Général
	private JLabel generalImage = new JLabel (new ImageIcon("settings/general.png"));
	private JLabel general = new JLabel ("  Général");
	
	//Notes
	private JLabel notesImage = new JLabel (new ImageIcon("settings/notes.png"));
	private JLabel notes = new JLabel ("  Notes");
	
	//Notifications
	private JLabel notificationsImage = new JLabel (new ImageIcon("settings/notifications.png"));
	private JLabel notif = new JLabel ("  Notifications");
	
	//Sons
	private JLabel sonsImage = new JLabel (new ImageIcon("settings/sons.png"));
	private JLabel sons = new JLabel ("  Sons");
	
	private JScrollPane scroll;
	
	private Font font = new Font("Arial",Font.BOLD,20);
	
	private JPanel imagesJPanel = new JPanel();

    private JLabel gallerieButton = new JLabel("Settings");
    private ListePhotos listePhotos;

public Settings (ListePhotos listePhotos){
	
	

	setLayout(new BorderLayout());
	add(gallerieButton,BorderLayout.NORTH);
	gallerieButton.setAlignmentX(CENTER_ALIGNMENT);
    gallerieButton.setFont(font);
    gallerieButton.setForeground(Color.white);
    gallerieButton.setHorizontalAlignment((int) CENTER_ALIGNMENT);
    imagesJPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	setBackground(Color.black);
	
	imagesJPanel.setBackground(Color.white);
	imagesJPanel.setLayout(new GridLayout(0,2,10,20));
	
	
	imagesJPanel.add(avionImage);
	avionImage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
	imagesJPanel.add(avion);
	avion.setFont(font);
	
	imagesJPanel.add(wifiImage);
	wifiImage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
	imagesJPanel.add(wifi);
	wifi.setFont(font);
	
	imagesJPanel.add(bluetoothImage);
	bluetoothImage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
	imagesJPanel.add(bluetooth);
	bluetooth.setFont(font);
	
	
	imagesJPanel.add(donneescelImage);
	donneescelImage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
	imagesJPanel.add(donneescel);
	donneescel.setFont(font);
	
	
	imagesJPanel.add(partageconImage);
	partageconImage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
	imagesJPanel.add(partagecon);
	partagecon.setFont(font);
	
	
	imagesJPanel.add(opImage);
	opImage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
	imagesJPanel.add(op);
	op.setFont(font);
	
	imagesJPanel.add(generalImage);
	generalImage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
	imagesJPanel.add(general);
	general.setFont(font);
	
	imagesJPanel.add(notesImage);
	notesImage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
	imagesJPanel.add(notes);
	notes.setFont(font);
	
	imagesJPanel.add(notificationsImage);
	notificationsImage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
	imagesJPanel.add(notif);
	notif.setFont(font);
	
	
	imagesJPanel.add(sonsImage);
	sonsImage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
	imagesJPanel.add(sons);
	sons.setFont(font);
	
	
	imagesJPanel.add(fondImage);
	fondImage.setBorder(BorderFactory.createLineBorder(Color.lightGray));
	fond.setFont(font);
	imagesJPanel.add(fond);

	
	
	
    scroll = new JScrollPane(imagesJPanel);
    add(scroll);
 
	
}

}
