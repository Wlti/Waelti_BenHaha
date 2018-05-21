import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Facebook extends JPanel{

	private JButton f = new JButton ("Facebook");
	private JTextField user = new JTextField();
	private JLabel usertxt = new JLabel("Adresse e-mail ou mobile");
	private JTextField mp = new JTextField();
	private JLabel mptxt = new JLabel("Mot de passe");
	private JButton connect = new JButton ("Se connecter");
	private Font font = new Font("Arial",Font.BOLD,50);
	private Font font2 = new Font("Arial",Font.BOLD,20);
	
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
		setLayout(new GridLayout(0,1));
		usertxt.setFont(font2);
		usertxt.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		mptxt.setFont(font2);
		mptxt.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		user.addActionListener(new EcouteurUser());
		add(f);
		
		add(usertxt);
		add(user);
		
		add(mptxt);
		add(mp);
		add(Box.createRigidArea(new Dimension (0,41)));
		add(connect);
		
	}
}
	class EcouteurUser implements ActionListener{
	
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			
		}
	
	}

