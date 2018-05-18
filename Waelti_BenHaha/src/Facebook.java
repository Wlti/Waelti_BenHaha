import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Facebook extends JPanel{

	private JLabel f = new JLabel (new ImageIcon("images/facebookimage.png"));
	
	public Facebook (){
		setBackground(Color.black);
		
		add(f);
	}
	
}
