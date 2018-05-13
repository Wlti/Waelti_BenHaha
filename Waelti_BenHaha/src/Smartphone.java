import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Smartphone extends JFrame{
	
	//Permettre le déplacement du smartphone
	DeplacementsSmartphone SMMove = new DeplacementsSmartphone(this);
	
	//Contenu de l'écran
	private JLabel boutonContacts = new JLabel(new ImageIcon ("images/Contacts.png"));
	private JLabel boutonPhotos = new JLabel(new ImageIcon ("images/Gallery.png"));	
	private JLabel boutonEteindre = new JLabel(new ImageIcon ("images/Exit.png"));	
	private JLabel boutonCalculatrice = new JLabel(new ImageIcon ("images/calculatrice.png"));
	
	//Bouton principal
	private JLabel launcher = new JLabel(new ImageIcon ("images/launcher.png"));	
	
	//Coque natel
	private  JLabel coqueGaucheNatel = new JLabel(new ImageIcon ("images/gauche.png")); 
	private  JLabel coqueDroitNatel = new JLabel(new ImageIcon ("images/droit.png")); 
	private  JLabel coqueHautNatel = new JLabel(new ImageIcon ("images/haut.png")); 

	//Panel pour l'écran
	private JPanel panel = new JPanel(){
		private BufferedImage background;
		protected void paintComponent(Graphics g){
		      super.paintComponents(g);
		     try {
				background = ImageIO.read(new File("images/fondEcran.png"));
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

	//Constructeur 	
	public Smartphone (){
		//Déplacements smartphone
		addMouseListener(SMMove);
		addMouseMotionListener(SMMove);
		
		//Design
		setSize(525, 900); 
		setResizable(false);
		this.setUndecorated(true);
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
		panelBoutonHomeJPanel.setBackground(Color.black);
		
		//Ecran au centre
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout (2,2));
		panel.setBackground(Color.BLACK);
		panel.add(boutonContacts);		
		boutonContacts.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Affiche les contacts");
            }

        });		
		
		panel.add(boutonPhotos);
		boutonPhotos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Affiche les photos");
            }

        });
		
		panel.add(boutonCalculatrice);
		boutonCalculatrice.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Affiche la calculatrice");
            }

        });
		
		panel.add(boutonEteindre);
		boutonEteindre.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	dispose();
            }

        });
		
		pack();
		
		
	}
		
}


		
		
				
			
