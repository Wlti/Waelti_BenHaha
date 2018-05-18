import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.omg.CORBA.PRIVATE_MEMBER;

// source : https://openclassrooms.com/courses/apprenez-a-programmer-en-java/tp-une-calculatrice

public class CalculatriceJPanel extends JPanel {
  String[] tab_string = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".", "=", "C", "+", "-", "*", "/"};
  JButton[] tab_button = new JButton[tab_string.length];
  private JLabel ecran = new JLabel();
  private double resultat;
  private boolean clicOperateur = false, update = false;
  private String operateur = "";
  private Font police = new Font("Arial", Font.BOLD, 60);
  private Font policeClavier = new Font("Arial", Font.BOLD, 20);
  
  public CalculatriceJPanel(){
	  setLayout(new BorderLayout());
	  initComposant();
  }
      
  private void initComposant(){
	 //Ecran
    ecran = new JLabel("0");
    ecran.setForeground(Color.white);
    ecran.setFont(police);
    JPanel panEcran = new JPanel();
    panEcran.add(ecran);
    panEcran.setLayout(new FlowLayout());
    panEcran.setBackground(Color.black);
    add(panEcran,BorderLayout.NORTH);
    
    
    //Opérateurs
    JPanel operateur = new JPanel(); 
    operateur.setPreferredSize(new Dimension (110,200));
    operateur.setLayout(new GridLayout(5,0));
    add(operateur,BorderLayout.EAST);
    
    //Chiffres
    JPanel chiffre = new JPanel();
    chiffre.setLayout(new GridLayout(4,4));
    add(chiffre,BorderLayout.CENTER);
    
    
    //On parcourt le tableau initialisé afin de créer nos boutons
    for(int i = 0; i < tab_string.length; i++){
      tab_button[i] = new JButton(tab_string[i]);
      switch(i){
        case 11 :
          tab_button[i].addActionListener(new EgalListener());
          chiffre.add(tab_button[i]);
          tab_button[i].setFont(policeClavier);
          break;
        case 12 :
          tab_button[i].setForeground(Color.red);
          tab_button[i].addActionListener(new ResetListener());
          operateur.add(tab_button[i]);
          tab_button[i].setBackground(Color.orange);
          tab_button[i].setFont(policeClavier);
          break;
        case 13 :
          tab_button[i].addActionListener(new PlusListener());
          operateur.add(tab_button[i]);
          tab_button[i].setBackground(Color.orange);
          tab_button[i].setFont(policeClavier);
          break;
        case 14 :
          tab_button[i].addActionListener(new MoinsListener());
          operateur.add(tab_button[i]);
          tab_button[i].setBackground(Color.orange);
          tab_button[i].setFont(policeClavier);
          break;	
        case 15 :	
          tab_button[i].addActionListener(new MultiListener());
          operateur.add(tab_button[i]);
          tab_button[i].setBackground(Color.orange);
          tab_button[i].setFont(policeClavier);
          break;
        case 16 :
          tab_button[i].addActionListener(new DivListener());
          operateur.add(tab_button[i]);
          tab_button[i].setBackground(Color.orange);
          tab_button[i].setFont(policeClavier);
          break;
        default :
          //Par défaut, ce sont les premiers éléments du tableau donc des chiffres, on affecte alors le bon listener
          chiffre.add(tab_button[i]);
          tab_button[i].addActionListener(new ChiffreListener());
          tab_button[i].setFont(policeClavier);
          break;
      }
    }
    
   
  }

  //Méthode permettant d'effectuer un calcul selon l'opérateur sélectionné
  private void calcul(){
    if(operateur.equals("+")){
    	resultat = resultat + 
            Double.valueOf(ecran.getText()).doubleValue();
      ecran.setText(String.valueOf(resultat));
    }
    if(operateur.equals("-")){
    	resultat = resultat - 
            Double.valueOf(ecran.getText()).doubleValue();
      ecran.setText(String.valueOf(resultat));
    }          
    if(operateur.equals("*")){
    	resultat = resultat * 
            Double.valueOf(ecran.getText()).doubleValue();
      ecran.setText(String.valueOf(resultat));
    }     
    if(operateur.equals("/")){
      try{
    	  resultat = resultat / 
              Double.valueOf(ecran.getText()).doubleValue();
        ecran.setText(String.valueOf(resultat));
      } catch(ArithmeticException e) {
        ecran.setText("0");
      }
    }
  }

  //Listener utilisé pour les chiffres
  //Permet de stocker les chiffres et de les afficher
  class ChiffreListener implements ActionListener {
    public void actionPerformed(ActionEvent e){
      //On affiche le chiffre additionnel dans le label
      String str = ((JButton)e.getSource()).getText();
      if(update){
        update = false;
      }
      else{
        if(!ecran.getText().equals("0"))
          str = ecran.getText() + str;
      }
      ecran.setText(str);
    }
  }

  //Listener affecté au bouton =
  class EgalListener implements ActionListener {
    public void actionPerformed(ActionEvent arg0){
      calcul();
      update = true;
      clicOperateur = false;
    }
  }

  //Listener affecté au bouton +
  class PlusListener implements ActionListener {
    public void actionPerformed(ActionEvent arg0){
      if(clicOperateur){
        calcul();
        ecran.setText(String.valueOf(resultat));
      }
      else{
    	  resultat = Double.valueOf(ecran.getText()).doubleValue();
        clicOperateur = true;
      }
      operateur = "+";
      update = true;
    }
  }

  //Listener affecté au bouton -
  class MoinsListener implements ActionListener {
    public void actionPerformed(ActionEvent arg0){
      if(clicOperateur){
        calcul();
        ecran.setText(String.valueOf(resultat));
      }
      else{
    	  resultat = Double.valueOf(ecran.getText()).doubleValue();
        clicOperateur = true;
      }
      operateur = "-";
      update = true;
    }
  }

  //Listener affecté au bouton *
  class MultiListener implements ActionListener {
    public void actionPerformed(ActionEvent arg0){
      if(clicOperateur){
        calcul();
        ecran.setText(String.valueOf(resultat));
      }
      else{
    	  resultat = Double.valueOf(ecran.getText()).doubleValue();
        clicOperateur = true;
      }
      operateur = "*";
      update = true;
    }
  }

  //Listener affecté au bouton /
  class DivListener implements ActionListener {
    public void actionPerformed(ActionEvent arg0){
      if(clicOperateur){
        calcul();
        ecran.setText(String.valueOf(resultat));
      }
      else{
    	  resultat = Double.valueOf(ecran.getText()).doubleValue();
        clicOperateur = true;
      }
      operateur = "/";
      update = true;
    }
  }

  //Listener affecté au bouton de remise à zéro
  class ResetListener implements ActionListener {
    public void actionPerformed(ActionEvent arg0){
      clicOperateur = false;
      update = true;
      resultat = 0;
      operateur = "";
      ecran.setText("0");
    }
  }      
}