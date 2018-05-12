import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Smartphone extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	//Contenu de l'écran
	private JButton boutonContacts = new JButton(new ImageIcon ("C:/Users/nadin/git/Waelti_BenHaha/images/Contacts.png"));
	private JButton boutonPhotos = new JButton(new ImageIcon ("C:/Users/nadin/git/Waelti_BenHaha/images/Gallery.png"));	
	private JButton boutonEteindre = new JButton(new ImageIcon ("C:/Users/nadin/git/Waelti_BenHaha/images/Exit.png"));	
	private JButton boutonCalculatrice = new JButton(new ImageIcon ("C:/Users/nadin/git/Waelti_BenHaha/images/calculatrice.png"));
	
	//Bouton principal
	private JButton launcher = new JButton(new ImageIcon ("C:/Users/nadin/git/Waelti_BenHaha/images/launcher.png"));	
	
	//Coque natel
	private  JLabel coqueGaucheNatel = new JLabel(new ImageIcon ("C:/Users/nadin/git/Waelti_BenHaha/images/gauche.png")); 
	private  JLabel coqueDroitNatel = new JLabel(new ImageIcon ("C:/Users/nadin/git/Waelti_BenHaha/images/droit.png")); 
	private  JLabel coqueHautNatel = new JLabel(new ImageIcon ("C:/Users/nadin/git/Waelti_BenHaha/images/haut.png")); 
	private  JLabel coqueBasNatel = new JLabel(new ImageIcon ("C:/Users/nadin/git/Waelti_BenHaha/images/bas.png")); 

	//Panel pour l'écran
	private JPanel panel = new JPanel();

	//Constructeur 	
	public Smartphone (){
	
		//Design
		setSize(525, 900); 
		this.setUndecorated(true);
		add(panel, BorderLayout.CENTER);
		panel.setBackground(Color.black);
		Toolkit toolkit = getToolkit();         
		Dimension size = toolkit.getScreenSize();         
		setLocation(size.width/2 - getWidth()/2,    size.height/2 - getHeight()/2);

		//Coque du natel :
		add(coqueHautNatel,BorderLayout.NORTH);
		add(coqueDroitNatel,BorderLayout.EAST);
		add(coqueGaucheNatel,BorderLayout.WEST);
		add(coqueBasNatel,BorderLayout.SOUTH);
		
		//Ecran au centre
		panel.setLayout(new GridLayout (2,2,10,10));
		
		//Icones		
		panel.add(boutonContacts);
		boutonContacts.addActionListener(new AfficherContacts ());
		boutonContacts.setBackground(Color.black);
		boutonContacts.setBorder(null);
		
		panel.add(boutonPhotos);
		boutonPhotos.addActionListener(new AfficherPhotos ());
		boutonPhotos.setBackground(Color.black);
		boutonPhotos.setBorder(null);
		
		panel.add(boutonCalculatrice);
		boutonCalculatrice.addActionListener(new AfficherCalculatrice ());
		boutonCalculatrice.setBackground(Color.black);
		boutonCalculatrice.setBorder(null);
		
		panel.add(boutonEteindre);
		boutonEteindre.addActionListener(new EteindreSmartphone());
		boutonEteindre.setBackground(Color.black);
		boutonEteindre.setBorder(null);
		
	}
	
	//Ecouteurs :
	
		private Object GridLayout(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

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
		
		class MouseLst extends MouseAdapter {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("CLICK");
			}
}
}

		
		
				
			
