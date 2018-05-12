import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Smartphone extends JFrame{

	
	//Contenu de l'écran principal
	private JLabel contacts = new JLabel("Contacts");
	private JButton boutonContacts = new JButton(new ImageIcon ("C:/Users/nadin/git/Waelti_BenHaha/images/"));
	private JLabel photos = new JLabel("Photos");
	private JButton boutonPhotos = new JButton();	
	private JLabel eteindre = new JLabel("Eteindre");
	private JButton boutonEteindre = new JButton();	
	private JLabel calculatrice = new JLabel("Calculatrice");
	private JButton boutonCalculatrice = new JButton();	
	private JLabel configurationFondEcran = new JLabel("Configuration");
	private JButton boutonConfigurerFondEcran = new JButton();	
	private JButton launcher = new JButton();	
	
	//Coque natel
	private  JLabel coqueGaucheNatel = new JLabel("gauche.png"); 
	private  JLabel coqueDroitNatel = new JLabel("droit.png"); 
	private  JLabel coqueHautNatel = new JLabel("haut.png"); 
	private  JLabel coqueBasNatel = new JLabel("bas.png"); 
	
	private JPanel panel = new JPanel();

	//Constructeur 	
	public Smartphone (){
		
		
		//Coque du natel :
		add(coqueHautNatel,BorderLayout.NORTH);
		add(coqueBasNatel,BorderLayout.SOUTH);
		add(coqueDroitNatel,BorderLayout.EAST);
		add(coqueGaucheNatel,BorderLayout.WEST);
		
		//Ecran au centre
		panel.setLayout(new FlowLayout ());
		
		//Icones
		add(panel, BorderLayout.CENTER);
		panel.add(boutonContacts);
		panel.add(contacts);
		boutonContacts.addActionListener(new AfficherContacts ());
		
		panel.add(boutonPhotos);
		panel.add(photos);
		boutonPhotos.addActionListener(new AfficherPhotos ());
		
		panel.add(boutonCalculatrice);
		panel.add(calculatrice);
		boutonCalculatrice.addActionListener(new AfficherCalculatrice ());
		
		panel.add(boutonConfigurerFondEcran);
		panel.add(configurationFondEcran);
		boutonEteindre.addActionListener(new ConfigurerFondEcran());
		
		panel.add(boutonEteindre);
		panel.add(eteindre);
		boutonEteindre.addActionListener(new EteindreSmartphone());
		
		
		
		
		//Taille du natel :
		setSize(800, 400); 
		
		//Pour que le natel s'affiche au milieu de l'ordinateur :
		Toolkit toolkit = getToolkit();         
		Dimension size = toolkit.getScreenSize();         
		setLocation(size.width/2 - getWidth()/2,    size.height/2 - getHeight()/2);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//Ecouteurs :
	
		class AfficherContacts implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//Affiche ListeContacts au centre
		}}
		
		class AfficherPhotos implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				//Affiche GaleriePhotos au centre
			}
		}
		class AfficherCalculatrice implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				//Affiche Calculatrice au centre
			}
		}
		class EteindreSmartphone implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				//Sauver les données
				
				//Eteindre
				dispose();
			}
		}
		
		class ConfigurerFondEcran implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				//Affiche ListeContacts au centre
			}}
}
		
		
				
			
