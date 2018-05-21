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

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Smartphone extends JFrame implements Serializable{
		
	//Liste de path pour créer les images
	ListePhotos listePhotos;
		
	//Permettre le déplacement du smartphone
	DeplacementsSmartphone SMMove = new DeplacementsSmartphone(this);
	
	//Bouton contact
	private ImageIcon contact = new ImageIcon("images/contacts.png");
	private ImageIcon contactOver = new ImageIcon("images/contactsOver.png");
	private JLabel boutonContacts = new JLabel(contact);
	
	//Bouton reset
	private ImageIcon settings = new ImageIcon("images/settings.png");
	private ImageIcon settingsOver = new ImageIcon("images/settingsOver.png");
	private JLabel boutonSettings = new JLabel(settings);
	
	//Bouton heure
	private ImageIcon heure = new ImageIcon("images/heure.png");
	private ImageIcon heureOver = new ImageIcon("images/heureOver.png");
	private JLabel boutonHeure = new JLabel(heure);
	
	//Bouton photos
	private ImageIcon photos = new ImageIcon("images/Gallery.png");
	private ImageIcon photosOver = new ImageIcon("images/GalleryOver.png");
	private JLabel boutonPhotos = new JLabel(photos);	
	
	//Bouton eteindre
	private ImageIcon eteindre = new ImageIcon("images/Exit.png");
	private ImageIcon eteindreOver = new ImageIcon("images/ExitOver.png");
	private JLabel boutonEteindre = new JLabel(eteindre);	
	
	//Bouton Calculatrice
	private ImageIcon calculatrice = new ImageIcon("images/calculatrice.png");
	private ImageIcon calculatriceOver = new ImageIcon("images/calculatriceOver.png");
	private JLabel boutonCalculatrice = new JLabel(calculatrice);
	
	//Bouton Facebook
	private ImageIcon facebook = new ImageIcon("images/facebook.png");
	private ImageIcon facebookOver = new ImageIcon("images/facebookOver.png");
	private JLabel boutonFacebook = new JLabel(facebook);
	
	//Bouton Home
	private ImageIcon launcherInit = new ImageIcon("images/launcher.png");
	private ImageIcon launcherOver = new ImageIcon("images/launcherOver.png");
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
	final static String ECRANFACEBOOK = "écran facebook";
	final static String ECRANHEURE = "écran heure";
	final static String ECRANFONDECRAN = "écran reset";
	
	
	
	
	
	
	//Constructeur 	:
	
	public Smartphone (){
		
		//Liste de path se trouvant dans le fichier photo.ser
		try {
			listePhotos=deserializeListePhotos("photoSerialisation/photo.ser");
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		//Déplacements smartphone
		addMouseListener(SMMove);
		addMouseMotionListener(SMMove);
	
		//Design
		setSize(525, 900);
		setUndecorated(true);
		setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		
		//Emplacement du natel au milieu
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
            @Override
            public void mouseEntered(MouseEvent e) {
            	//Affiche l'écran d'accueil
	            launcher.setIcon(launcherOver);
            }
            @Override
            public void mouseExited(MouseEvent e) {
            	//Affiche l'écran d'accueil
	            launcher.setIcon(launcherInit);
            }
           
        });
		
		//Créé deux boxes vides pour agrandir le bas du natel
		panelBoutonHomeJPanel.setBackground(Color.black);
		panelBoutonHomeJPanel.add(Box.createRigidArea(new Dimension (0,41)),BorderLayout.SOUTH);
		panelBoutonHomeJPanel.add(Box.createRigidArea(new Dimension (0,41)),BorderLayout.NORTH);
		
		//Ecran au centre (jeu de cartes)
		add(cards, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0,3,10,10));
		
		//Ajout des panels au panel CardLayout (jeu de cartes)
		cards.add(panel,ECRANACCUEIL);
		cards.add(new CalculatriceJPanel (),ECRANCALCULATRICE);
		cards.add(new ContactsJPanel(),ECRANCONTACTS);
		cards.add(new PhotosJPanel (listePhotos), ECRANPHOTOS);
		cards.add(new Settings (listePhotos),ECRANFONDECRAN);
		cards.add(new Heure(),ECRANHEURE);
		cards.add(new Facebook(),ECRANFACEBOOK);
		
	 
		
		
		
		
		//Ajout des éléments sur l'écran et leur écouteur :
		
		
		
		panel.add(boutonContacts);	
		boutonContacts.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	CardLayout cl = (CardLayout)(cards.getLayout());
      		   	cl.show(cards, ECRANCONTACTS);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            	//Affiche l'écran d'accueil
            	boutonContacts.setIcon(contactOver);
            }
            @Override
            public void mouseExited(MouseEvent e) {
            	//Affiche l'écran d'accueil
            	boutonContacts.setIcon(contact);
            }
        });	
		
		panel.add(boutonPhotos);
		boutonPhotos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	CardLayout cl = (CardLayout)(cards.getLayout());
      		   	cl.show(cards, ECRANPHOTOS);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            	//Affiche l'écran d'accueil
            	boutonPhotos.setIcon(photosOver);
            }
            @Override
            public void mouseExited(MouseEvent e) {
            	//Affiche l'écran d'accueil
            	boutonPhotos.setIcon(photos);
            }
        });
		
		panel.add(boutonCalculatrice);
		boutonCalculatrice.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	CardLayout cl = (CardLayout)(cards.getLayout());
     		    cl.show(cards, ECRANCALCULATRICE);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            	//Affiche l'écran d'accueil
            	boutonCalculatrice.setIcon(calculatriceOver);
            }
            @Override
            public void mouseExited(MouseEvent e) {
            	//Affiche l'écran d'accueil
            	boutonCalculatrice.setIcon(calculatrice);
            }
        });
		
		
		panel.add(boutonHeure);	
		boutonHeure.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	CardLayout cl = (CardLayout)(cards.getLayout());
       		   	cl.show(cards, ECRANHEURE);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            	//Affiche l'écran d'accueil
            	boutonHeure.setIcon(heureOver);
            }
            @Override
            public void mouseExited(MouseEvent e) {
            	//Affiche l'écran d'accueil
            	boutonHeure.setIcon(heure);
            }
        });	
		
		panel.add(boutonFacebook);	
		boutonFacebook.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	CardLayout cl = (CardLayout)(cards.getLayout());
      		   	cl.show(cards, ECRANFACEBOOK);
      		   	
      		   	
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            	//Affiche l'écran d'accueil
            	boutonFacebook.setIcon(facebookOver);
            }
            @Override
            public void mouseExited(MouseEvent e) {
            	//Affiche l'écran d'accueil
            	boutonFacebook.setIcon(facebook);
            }
        });	
	
		panel.add(boutonSettings);	
		boutonSettings.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	CardLayout cl = (CardLayout)(cards.getLayout());
      		   	cl.show(cards, ECRANFONDECRAN);
      		   	
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            	//Affiche l'écran d'accueil
            	boutonSettings.setIcon(settingsOver);
            }
            @Override
            public void mouseExited(MouseEvent e) {
            	//Affiche l'écran d'accueil
            	boutonSettings.setIcon(settings);
            }
        });	
		

		panel.add(boutonEteindre);	
		boutonEteindre.addMouseListener(new MouseAdapter() {
            @SuppressWarnings("static-access")
			@Override
            public void mouseClicked(MouseEvent e) {
            	
            	//Enregistre ma liste de photos avant de quitter
            	try {
					serializeListePhotos(listePhotos);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	System.exit(1);
            	dispose();
            	
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            	//Affiche l'écran d'accueil
            	boutonEteindre.setIcon(eteindreOver);
            }
            @Override
            public void mouseExited(MouseEvent e) {
            	//Affiche l'écran d'accueil
            	boutonEteindre.setIcon(eteindre);
            }
        });

	}
	
	//Permet de sérialiser ou désérialiser mes photos
	
	public static void serializeListePhotos(ListePhotos listePhotos) throws IOException {		
		FileOutputStream fichier = new FileOutputStream("photoSerialisation/photo.ser");
		BufferedOutputStream bfichier = new BufferedOutputStream (fichier);
		ObjectOutputStream fichierObjectSerialize = new ObjectOutputStream(bfichier);
		fichierObjectSerialize.writeObject(listePhotos); //je sauve l'objet dans ce fichier 
		fichierObjectSerialize.close();
	}
	public static ListePhotos deserializeListePhotos(String path)  throws IOException, ClassNotFoundException {		//supprimer l'objet enregistré dans le fichier Person.ser
		// TODO Auto-generated method stub
		ListePhotos photo;
		FileInputStream fichier = new FileInputStream(path);						
		BufferedInputStream bfichier = new BufferedInputStream (fichier);
		ObjectInputStream lectureObjet = new ObjectInputStream(bfichier);
		photo=(ListePhotos) lectureObjet.readObject();
		lectureObjet.close();
		return photo;
	}
	
	
	
		
	
}


		
		
				
			
