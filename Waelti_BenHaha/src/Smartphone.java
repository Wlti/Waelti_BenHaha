import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Smartphone extends JFrame{

	private static final long serialVersionUID = 1L;
	
	//Contenu de l'écran principal
	private JLabel contacts = new JLabel("Contacts");
	JButton boutonContacts = new JButton();
	private JLabel photos = new JLabel("Photos");
	JButton boutonPhotos = new JButton();	
	private JLabel eteindre = new JLabel("Eteindre");
	JButton boutonEteindre = new JButton();	
	private JLabel calculatrice = new JLabel("Calculatrice");
	JButton boutonCalculatrice = new JButton();	
	JButton launcher = new JButton();	
	
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
		
		//Ecran
		panel.setLayout(new FlowLayout());
		
		//Icones
		add(panel, BorderLayout.CENTER);
		boutonContacts.setSize(10, 10);
		panel.add(boutonContacts);
		panel.add(contacts);
		panel.add(boutonPhotos);
		panel.add(photos);
		panel.add(boutonEteindre);
		panel.add(eteindre);
		boutonEteindre.addActionListener(new EteindreSmartphone());
		panel.add(boutonCalculatrice);
		panel.add(calculatrice);
		
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
}
		
		
				
			
