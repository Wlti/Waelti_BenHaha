import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CalculatriceJPanel extends JPanel{
	
	private JButton plus = new JButton("+");
	private JButton moins = new JButton("-");
	private JButton fois = new JButton("x");
	private JButton divise = new JButton("/");
	private JButton egal = new JButton("=");
	private JButton puissance = new JButton("^");
	private JButton un = new JButton("1");
	private JButton deux = new JButton("2");
	private JButton trois = new JButton("3");
	private JButton quatre = new JButton("4");
	private JButton cinq = new JButton("5");
	private JButton six = new JButton("6");
	private JButton sept = new JButton("7");
	private JButton huit = new JButton("8");
	private JButton neuf = new JButton("9");
	
	public CalculatriceJPanel() {
	setLayout(new GridLayout(5,3));
	add(plus);
	add(moins);	
	add(fois);
	add(divise);	
	add(egal);
	add(puissance);	
	add(un);	
	add(deux);	
	add(trois);	
	add(quatre);	
	add(cinq);	
	add(six);	
	add(sept);	
	add(huit);	
	add(neuf);	
	}
	
	@Override
	public void setLayout(LayoutManager mgr) {
		super.setLayout(mgr);
	}
	
	}
