import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.omg.PortableInterceptor.USER_EXCEPTION;


public class Facebook extends JPanel{

	private JButton f = new JButton ("Facebook");
	private JTextField user = new JTextField();
	private JLabel usertxt = new JLabel("Adresse e-mail ou mobile");
	private JTextField mp = new JTextField();
	private JLabel mptxt = new JLabel("Mot de passe");
	private JButton connect = new JButton ("Se connecter");
	private Font font = new Font("Arial",Font.BOLD,50);
	private Font font2 = new Font("Arial",Font.BOLD,20);
	private JLabel image = new JLabel (new ImageIcon("images/facebookImage.png"));
	private JButton deconnect = new JButton ("Se déconnecter");
	
	private JPanel fbConnect = new JPanel ();
	private JPanel fbJPanel = new JPanel ();
	private JPanel cards = new JPanel ();
	final static String ECRANCONNEXION = "écran de connexion";
	final static String ECRANCONNECTE = "écran connecté";
	
	public Facebook (){
		//Design
		connect.setBackground(Color.green);
		connect.setFont(font2);
		f.setForeground(Color.white);
		f.setFont(font);
		f.setBackground(Color.blue);
		user.setFont(font2);
		mp.setFont(font2);
		setBackground(Color.lightGray);
		user.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		mp.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		usertxt.setFont(font2);
		usertxt.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		mptxt.setFont(font2);
		mptxt.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		deconnect.setFont(font2);
		deconnect.setBackground(Color.black);
		deconnect.setForeground(Color.red);
	
		
		//Ajout des composants
		cards.setLayout(new CardLayout());
		setLayout(new BorderLayout());
		add(cards,BorderLayout.CENTER);
		cards.add(fbConnect,ECRANCONNEXION);
		cards.add(fbJPanel,ECRANCONNECTE);
		fbConnect.setLayout(new GridLayout(0,1));
		fbConnect.add(f);
		fbConnect.add(usertxt);
		fbConnect.add(user);
		fbConnect.add(mptxt);
		fbConnect.add(mp);
		fbConnect.add(mp);
		fbConnect.add(Box.createRigidArea(new Dimension (0,41)));
		fbConnect.add(connect);
		
		
		fbJPanel.setLayout(new BorderLayout());
		fbJPanel.add(image,BorderLayout.CENTER);
		fbJPanel.setBackground(Color.black);
		fbJPanel.add(deconnect,BorderLayout.SOUTH);
		deconnect.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e) {
            	CardLayout cl = (CardLayout)(cards.getLayout());
      		   	cl.show(cards, ECRANCONNEXION);
      		   	user.setText("");
      		   	mp.setText("");
            }
		});
	
		
		//Ecouteur	
		connect.addActionListener(new EcouteurConnect());
		
	}
	
	
	class EcouteurConnect implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
		
			
			if(user.getText().equals("hello@hotmail.com")&&mp.getText().equals("helloWorld")){
				CardLayout cl = (CardLayout)(cards.getLayout());
     		    cl.show(cards, ECRANCONNECTE);
			}
			else{
				if(user.getText().equals("hello@hotmail.com")){
					user.setForeground(Color.green);
				}
				else{
					user.setText("User inconnu");
					user.setForeground(Color.red);
				}
				if(mp.getText().equals("helloWorld")){
					mp.setForeground(Color.green);
				}
				else{
					mp.setText("Mot de passe erroné");
					mp.setForeground(Color.red);
				}
					
			}
			
			
		}
	}
}

			
			
			
			
		


	