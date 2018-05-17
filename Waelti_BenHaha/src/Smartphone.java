import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Smartphone extends JFrame {
	
	//Permettre le déplacement du smartphone
	DeplacementsSmartphone SMMove = new DeplacementsSmartphone(this);
	
	//Contenu de l'écran d'accueil
	private JLabel boutonContacts = new JLabel(new ImageIcon ("images/Contacts.png"));
	private JLabel boutonPhotos = new JLabel(new ImageIcon ("images/Gallery.png"));	
	private JLabel boutonEteindre = new JLabel(new ImageIcon ("images/Exit.png"));	
	private JLabel boutonCalculatrice = new JLabel(new ImageIcon ("images/calculatrice.png"));
	
	//Bouton Home
	private JLabel launcher = new JLabel(new ImageIcon ("images/launcher.png"));	
	
	//Coque du natel
	private  JLabel coqueGaucheNatel = new JLabel(new ImageIcon ("images/gauche.png")); 
	private  JLabel coqueDroitNatel = new JLabel(new ImageIcon ("images/droit.png")); 
	private  JLabel coqueHautNatel = new JLabel(new ImageIcon ("images/haut.png")); 

	//Panel pour l'écran
	private JPanel panel = new JPanel(){
		private BufferedImage background;
		protected void paintComponent(Graphics g){
		      super.paintComponents(g);
		     try {
				background = ImageIO.read(new File("images/backgroundImage.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        g.drawImage( background, 0, 0, null);
		}
	};
	
	//Panel pour le bouton principal
	private JPanel panelBoutonHomeJPanel = new JPanel (){
		private BufferedImage background;
		protected void paintComponent(Graphics g){
		      super.paintComponents(g);
		     try {
				background = ImageIO.read(new File("images/bas.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        g.drawImage( background, 0, 0, null);
		     
		}
	};
	
	//CardLayout me permet de switcher entre les panels
	JPanel cards = new JPanel (new CardLayout());
	
	//Déclaration des identifiants pour chaque panel
	final static String ECRANACCUEIL = "écran d'accueil";
	final static String ECRANCALCULATRICE = "écran calculatrice";
	final static String ECRANPHOTOS = "écran photos";
	final static String ECRANCONTACTS = "écran contacts";

	
	
	
	
	
	
	//Constructeur 	:
	
	public Smartphone (){
			
		//Déplacements smartphone
		addMouseListener(SMMove);
		addMouseMotionListener(SMMove);
	
		//Design
		setSize(525, 900);
		setUndecorated(true);
		setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		Toolkit toolkit = getToolkit();         
		Dimension size = toolkit.getScreenSize();         
		setLocation(size.width/2 - getWidth()/2,    size.height/2 - getHeight()/2);
		
		//Coque du natel :
		add(coqueHautNatel,BorderLayout.NORTH);
		add(coqueDroitNatel,BorderLayout.EAST);
		add(coqueGaucheNatel,BorderLayout.WEST);
		add(panelBoutonHomeJPanel,BorderLayout.SOUTH);
		
		//Bas du natel
		panelBoutonHomeJPanel.setLayout(new BorderLayout());
		panelBoutonHomeJPanel.add(launcher,BorderLayout.CENTER);
		launcher.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	//Affiche l'écran d'accueil
            	CardLayout cl = (CardLayout)(cards.getLayout());
     		    cl.show(cards, ECRANACCUEIL);
            }
        });
		
		//Créé deux boxes vides pour agrandir le bas du natel
		panelBoutonHomeJPanel.setBackground(Color.black);
		panelBoutonHomeJPanel.add(Box.createRigidArea(new Dimension (0,41)),BorderLayout.SOUTH);
		panelBoutonHomeJPanel.add(Box.createRigidArea(new Dimension (0,41)),BorderLayout.NORTH);
		
		//Ecran au centre
		add(cards, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0,3,10,10));
		
		//Ajout des panels au panel CardLayout (jeu de cartes)
		cards.add(panel,ECRANACCUEIL);
		cards.add(new CalculatriceJPanel (),ECRANCALCULATRICE);
		cards.add(new ContactsJPanel(),ECRANCONTACTS);
		cards.add(new PhotosJPanel (), ECRANPHOTOS);
		
		
		
		//Ajout des éléments sur l'écran et leur écouteur :
		
		panel.add(boutonContacts);	
		boutonContacts.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	CardLayout cl = (CardLayout)(cards.getLayout());
      		   	cl.show(cards, ECRANCONTACTS);
            }
        });	
		
		panel.add(boutonPhotos);
		boutonPhotos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	CardLayout cl = (CardLayout)(cards.getLayout());
      		   	cl.show(cards, ECRANPHOTOS);
            }
        });
		
		panel.add(boutonCalculatrice);
		boutonCalculatrice.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	CardLayout cl = (CardLayout)(cards.getLayout());
     		    cl.show(cards, ECRANCALCULATRICE);
            }
        });
		
		panel.add(boutonEteindre);	
		boutonEteindre.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	dispose();
            }
        });
		
	
		//Initialisation des données contacts
		
		
		//Initialisation des données photos
		
		
		
	
	}

	
		
	
}


		
		
				
			
