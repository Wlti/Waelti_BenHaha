import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class Settings extends JPanel{
	//Mode Avion
	private JLabel avionImage = new JLabel (new ImageIcon("photos/avion.png"));
	private JLabel avion = new JLabel ("Mode Avion");
	private JLabel non = new JLabel (new ImageIcon("non/avion.png"));
	
	//Wi-Fi
	private JLabel wifiImage = new JLabel (new ImageIcon("wifi/avion.png"));
	private JLabel wifi = new JLabel ("Mode Avion");
	private JLabel sanswifi = new JLabel ("Non >");
	
	//Wi-Fi
	private JLabel bluetoothImage = new JLabel (new ImageIcon("bluetooth/avion.png"));
	private JLabel bluetooth = new JLabel ("Bluetooth");
	private JLabel sansbluetooth = new JLabel ("Non >");
	
	//Données cellulaires
	private JLabel donneescelImage = new JLabel (new ImageIcon("donnesCel/avion.png"));
	private JLabel donneescel = new JLabel ("Données cellulaires");
	private JLabel donnes = new JLabel (">");
	
	//Partage de connexion
	private JLabel partageconImage = new JLabel (new ImageIcon("partageConnexion/avion.png"));
	private JLabel partagecon = new JLabel ("Partage de connexion");
	private JLabel sanspartage = new JLabel ("Non >");
	
	//Opérateur
	private JLabel opImage = new JLabel (new ImageIcon("operateur/avion.png"));
	private JLabel op = new JLabel ("Opérateur");
	private JLabel operateur = new JLabel ("Swisscom");
		
	//Fond d'écran
	private JLabel fondImage = new JLabel (new ImageIcon("fondEcran/avion.png"));
	private JLabel fond = new JLabel ("Fond d'écran");
	private JLabel fondecran = new JLabel (">");
	
	private JScrollPane scroll;
	
	private Font font = new Font("Arial",Font.BOLD,20);
	
	private JPanel imagesJPanel = new JPanel();

    private JLabel gallerieButton = new JLabel("Settings");

public Settings (){
	setLayout(new BorderLayout());
	add(gallerieButton,BorderLayout.NORTH);
	gallerieButton.setAlignmentX(CENTER_ALIGNMENT);
    gallerieButton.setFont(font);
    gallerieButton.setHorizontalAlignment((int) CENTER_ALIGNMENT);
    
	setBackground(Color.white);
	imagesJPanel.setLayout(new GridLayout(0,3));
	imagesJPanel.add(avionImage);
	imagesJPanel.add(avion);
	imagesJPanel.add(non);
	imagesJPanel.add(wifiImage);
	imagesJPanel.add(wifi);
	imagesJPanel.add(sanswifi);
	imagesJPanel.add(bluetoothImage);
	imagesJPanel.add(bluetooth);
	imagesJPanel.add(sansbluetooth);
	imagesJPanel.add(donneescelImage);
	imagesJPanel.add(donneescel);
	imagesJPanel.add(donnes);
	imagesJPanel.add(partageconImage);
	imagesJPanel.add(partagecon);
	imagesJPanel.add(sanspartage);
	imagesJPanel.add(opImage);
	imagesJPanel.add(op);
	imagesJPanel.add(operateur);
	imagesJPanel.add(fondImage);
	imagesJPanel.add(fond);
	imagesJPanel.add(fondecran);
	
    scroll = new JScrollPane(imagesJPanel);
    add(scroll);
	
}
}
