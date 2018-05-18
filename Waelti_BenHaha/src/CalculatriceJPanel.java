import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

// source : https://openclassrooms.com/courses/apprenez-a-programmer-en-java/tp-une-calculatrice

public class CalculatriceJPanel extends JPanel {
  String[] tab_string = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".", "=", "C", "+", "-", "*", "/"};
  JButton[] tab_button = new JButton[tab_string.length];
  private JLabel ecran = new JLabel();
  private double resultat;
  private boolean clicOperateur = false, update = false;
  private String operateur = "";
  
  public CalculatriceJPanel(){
  
	  initComposant();
  }
      
  private void initComposant(){
	 //Ecran
    Font police = new Font("Arial", Font.BOLD, 60);
    ecran = new JLabel("0");
    ecran.setForeground(Color.white);
    ecran.setFont(police);
    ecran.setPreferredSize(new Dimension(220, 20));
    JPanel panEcran = new JPanel();
    panEcran.add(ecran,BorderLayout.NORTH);
    panEcran.setBackground(Color.black);
    
    //Opérateurs
    JPanel operateur = new JPanel();  
    add(operateur,BorderLayout.EAST);
    //Chiffres
    JPanel chiffre = new JPanel();

    add(operateur,BorderLayout.CENTER);
    //On parcourt le tableau initialisé afin de créer nos boutons
    for(int i = 0; i < tab_string.length; i++){
      tab_button[i] = new JButton(tab_string[i]);
      switch(i){
        case 11 :
          tab_button[i].addActionListener(new EgalListener());
          chiffre.add(tab_button[i]);
          break;
        case 12 :
          tab_button[i].setForeground(Color.red);
          tab_button[i].addActionListener(new ResetListener());
          operateur.add(tab_button[i]);
          break;
        case 13 :
          tab_button[i].addActionListener(new PlusListener());
          operateur.add(tab_button[i]);
          break;
        case 14 :
          tab_button[i].addActionListener(new MoinsListener());
          operateur.add(tab_button[i]);
          break;	
        case 15 :	
          tab_button[i].addActionListener(new MultiListener());
          operateur.add(tab_button[i]);
          break;
        case 16 :
          tab_button[i].addActionListener(new DivListener());
          operateur.add(tab_button[i]);
          break;
        default :
          //Par défaut, ce sont les premiers éléments du tableau donc des chiffres, on affecte alors le bon listener
          chiffre.add(tab_button[i]);
          tab_button[i].addActionListener(new ChiffreListener());
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
      ecran.setText("");
    }
  }      
}