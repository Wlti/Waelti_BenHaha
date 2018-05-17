import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.management.loading.PrivateClassLoader;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalculatriceJPanel extends JPanel{
	
	private JButton plus = new JButton("+");
	private JButton moins = new JButton("-");
	private JButton fois = new JButton("x");
	private JButton divise = new JButton("/");
	private JButton egal = new JButton("=");
	private JButton reset = new JButton("C");
	private JButton plusMoins = new JButton("+/-");
	private JButton pourcent = new JButton("%");
	private JButton zero = new JButton("0");
	private JButton point = new JButton(".");
	private JButton un = new JButton("1");
	private JButton deux = new JButton("2");
	private JButton trois = new JButton("3");
	private JButton quatre = new JButton("4");
	private JButton cinq = new JButton("5");
	private JButton six = new JButton("6");
	private JButton sept = new JButton("7");
	private JButton huit = new JButton("8");
	private JButton neuf = new JButton("9");
	private JButton resultat = new JButton ("0");

	private double total=0;
	
	private Font font = new Font("Arial",Font.BOLD,60);
	private Font fontc = new Font("Arial",Font.BOLD,30);
	
	private JPanel calculatrice = new JPanel ();
	private JPanel centreJPanel = new JPanel ();
	
	
	
	//Constructeur
	public CalculatriceJPanel() {
	
	//Ecran
	setLayout(new BorderLayout());
	setBackground(Color.black);
	
	//En haut
	resultat.setEnabled(false);
	resultat.setPreferredSize(new Dimension(400,200));
	resultat.setBackground(Color.black);
	resultat.setFont(font);
	resultat.setAlignmentX(RIGHT_ALIGNMENT);
	add(resultat,BorderLayout.NORTH);
	
	//A droite sur la calculatrice
	calculatrice.setLayout(new GridLayout(5,0));
	divise.setBackground(Color.orange);
	fois.setBackground(Color.orange);
	moins.setBackground(Color.orange);
	plus.setBackground(Color.orange);
	egal.setBackground(Color.orange);
	add(calculatrice,BorderLayout.EAST);
	calculatrice.add(divise);
	calculatrice.add(fois);
	calculatrice.add(moins);
	calculatrice.add(plus);
	calculatrice.add(egal);
	
	//Font
	divise.setFont(fontc);
	fois.setFont(fontc);
	moins.setFont(fontc);
	plus.setFont(fontc);
	egal.setFont(fontc);
	reset.setFont(fontc);
	plusMoins.setFont(fontc);
	pourcent.setFont(fontc);
	sept.setFont(fontc);
	huit.setFont(fontc);
	neuf.setFont(fontc);
	six.setFont(fontc);
	cinq.setFont(fontc);
	quatre.setFont(fontc);
	trois.setFont(fontc);
	deux.setFont(fontc);
	un.setFont(fontc);
	zero.setFont(fontc);
	point.setFont(fontc);
	
	
	//Au centre de la calculatrice 
	add(centreJPanel,BorderLayout.CENTER);
	centreJPanel.setLayout(new GridLayout(5,3));
	centreJPanel.add(reset);
	reset.setBackground(Color.lightGray);
	centreJPanel.add(plusMoins);
	plusMoins.setBackground(Color.lightGray);
	centreJPanel.add(pourcent);
	pourcent.setBackground(Color.lightGray);
	centreJPanel.add(sept);
	centreJPanel.add(huit);	
	centreJPanel.add(neuf);
	centreJPanel.add(quatre);
	centreJPanel.add(cinq);
	centreJPanel.add(six);
	centreJPanel.add(un);
	centreJPanel.add(deux);
	centreJPanel.add(trois);
	centreJPanel.add(zero);
	centreJPanel.add(point);
	
	
	}
	
	
	}
