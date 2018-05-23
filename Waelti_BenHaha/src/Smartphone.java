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
	
	//Icones
	MesIcones contactIcones = new MesIcones("images/contacts.png", "images/contactsOver.png");
	MesIcones settings = new MesIcones("images/settings.png", "images/settingsOver.png");
	MesIcones heure = new MesIcones("images/heure.png", "images/heureOver.png");
	MesIcones photos = new MesIcones("images/Gallery.png", "images/GalleryOver.png");
	MesIcones eteindre = new MesIcones("images/Exit.png", "images/ExitOver.png");
	MesIcones calculatrice = new MesIcones("images/calculatrice.png", "images/calculatriceOver.png");
	MesIcones facebook = new MesIcones("images/facebook.png", "images/facebookOver.png");
	MesIcones launcher = new MesIcones("images/launcher.png", "images/launcherOver.png");
	MesIcones reset = new MesIcones("images/reset.png", "images/resetOver.png");
	
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
	//Déclaration des identifiants pour chaque panel
	JPanel cards = new JPanel (new CardLayout());	
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
		panelBoutonHomeJPanel.add(launcher.getMonIcone(),BorderLayout.CENTER);
		launcher.getMonIcone().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	//Affiche l'écran d'accueil
            	CardLayout cl = (CardLayout)(cards.getLayout());
     		    cl.show(cards, ECRANACCUEIL);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            	//Affiche l'écran d'accueil
	            launcher.getMonIcone().setIcon(launcher.getImageOver());
            }
            @Override
            public void mouseExited(MouseEvent e) {
            	//Affiche l'écran d'accueil
	            launcher.getMonIcone().setIcon(launcher.getImage());
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
		PhotosJPanel classePhotos = new PhotosJPanel(listePhotos);
		cards.add(classePhotos, ECRANPHOTOS);
		cards.add(new Settings (listePhotos),ECRANFONDECRAN);
		cards.add(new Heure(),ECRANHEURE);
		cards.add(new Facebook(),ECRANFACEBOOK);
		
	 
		
		
		
		
		//Ajout des éléments sur l'écran et leur écouteur :
		
		
		//Contacts
		panel.add(contactIcones.getMonIcone());	
		contactIcones.getMonIcone().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	CardLayout cl = (CardLayout)(cards.getLayout());
      		   	cl.show(cards, ECRANCONTACTS);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            	//Affiche l'écran d'accueil
            	contactIcones.getMonIcone().setIcon(contactIcones.getImageOver());
            }
            @Override
            public void mouseExited(MouseEvent e) {
            	//Affiche l'écran d'accueil
            	contactIcones.getMonIcone().setIcon(contactIcones.getImage());
            }
        });	
		
		//Photos
		panel.add(photos.getMonIcone());
		photos.getMonIcone().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	CardLayout cl = (CardLayout)(cards.getLayout());
      		   	cl.show(cards, ECRANPHOTOS);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            	//Affiche l'écran d'accueil
            	photos.getMonIcone().setIcon(photos.getImageOver());
            }
            @Override
            public void mouseExited(MouseEvent e) {
            	//Affiche l'écran d'accueil
            	photos.getMonIcone().setIcon(photos.getImage());
            }
        });
		
		//Calculatrice
		panel.add(calculatrice.getMonIcone());
		calculatrice.getMonIcone().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	CardLayout cl = (CardLayout)(cards.getLayout());
     		    cl.show(cards, ECRANCALCULATRICE);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            	//Affiche l'écran d'accueil
            	calculatrice.getMonIcone().setIcon(calculatrice.getImageOver());
            }
            @Override
            public void mouseExited(MouseEvent e) {
            	//Affiche l'écran d'accueil
            	calculatrice.getMonIcone().setIcon(calculatrice.getImage());
            }
        });
		
		//Horloge
		panel.add(heure.getMonIcone());	
		heure.getMonIcone().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	CardLayout cl = (CardLayout)(cards.getLayout());
       		   	cl.show(cards, ECRANHEURE);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            	//Affiche l'écran d'accueil
            	heure.getMonIcone().setIcon(heure.getImageOver());
            }
            @Override
            public void mouseExited(MouseEvent e) {
            	//Affiche l'écran d'accueil
            	heure.getMonIcone().setIcon(heure.getImage());
            }
        });	
		
		//Facebook
		panel.add(facebook.getMonIcone());	
		facebook.getMonIcone().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	CardLayout cl = (CardLayout)(cards.getLayout());
      		   	cl.show(cards, ECRANFACEBOOK);
      		   	
      		   	
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            	//Affiche l'écran d'accueil
            	facebook.getMonIcone().setIcon(facebook.getImageOver());
            }
            @Override
            public void mouseExited(MouseEvent e) {
            	//Affiche l'écran d'accueil
            	facebook.getMonIcone().setIcon(facebook.getImage());
            }
        });	
		
		//Settings
		panel.add(settings.getMonIcone());	
		settings.getMonIcone().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	CardLayout cl = (CardLayout)(cards.getLayout());
      		   	cl.show(cards, ECRANFONDECRAN);
      		   	
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            	//Affiche l'écran d'accueil
            	settings.getMonIcone().setIcon(settings.getImageOver());
            }
            @Override
            public void mouseExited(MouseEvent e) {
            	//Affiche l'écran d'accueil
            	settings.getMonIcone().setIcon(settings.getImage());
            }
        });	
		
		//Eteindre
		panel.add(eteindre.getMonIcone());	
		eteindre.getMonIcone().addMouseListener(new MouseAdapter() {
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
            	eteindre.getMonIcone().setIcon(eteindre.getImageOver());
            }
            @Override
            public void mouseExited(MouseEvent e) {
            	//Affiche l'écran d'accueil
            	eteindre.getMonIcone().setIcon(eteindre.getImage());
            }
        });
		//Reset images
				panel.add(reset.getMonIcone());	
				reset.getMonIcone().addMouseListener(new MouseAdapter() {
		          
					 public void mouseClicked(MouseEvent e) {
						 
						
						 ArrayList<String> path = new ArrayList<String>();

						 path.add("photos/norvegien.jpg");
						 path.add("photos/art.jpg");
						 path.add("photos/chateau.jpg");
						 path.add("photos/inseparables.jpg");
						 path.add("photos/lac.jpg");
						 path.add("photos/love.jpg");
						 path.add("photos/maisons.jpg");
						 path.add("photos/vacances.jpg");
						 listePhotos.resetListePhotos(path);
						 
			            	
			            	//Enregistre ma liste de photos avant de quitter
			            	try {
								serializeListePhotos(listePhotos);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
			            	
			            	classePhotos.setMesPath(path);
			            	revalidate();
			            	System.exit(1);
			            	dispose();
			            	
			            }
		            @Override
		            public void mouseEntered(MouseEvent e) {
		            	//Affiche l'écran d'accueil
		            	reset.getMonIcone().setIcon(reset.getImageOver());
		            }
		            @Override
		            public void mouseExited(MouseEvent e) {
		            	//Affiche l'écran d'accueil
		            	reset.getMonIcone().setIcon(reset.getImage());
		            }
		        });
	}
	
	//Permet de sérialiser ou de désérialiser mes photos
	
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


		
		
				
			
