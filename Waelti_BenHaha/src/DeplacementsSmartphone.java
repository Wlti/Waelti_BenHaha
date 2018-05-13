import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


public class DeplacementsSmartphone extends MouseAdapter implements MouseMotionListener {
	
	private Smartphone samsung;	
	private Point clicOrigine;	
	
	public DeplacementsSmartphone (Smartphone samsung){
	this.samsung = samsung;	
	}

	//Quand tu cliques la premi�re fois, m�morise l'endroit
		public void mousePressed(MouseEvent e) {
			clicOrigine = e.getPoint();
		}
	
	//Fait la diff�rence du point de d�part jusqu'o� je le d�place
	public void mouseDragged(MouseEvent e) {
		int differenceLargeur = e.getX()-clicOrigine.x;
		int differenceHauteur = e.getY()-clicOrigine.y;
		samsung.setLocation(samsung.getLocation().x+differenceLargeur, samsung.getLocation().y+differenceHauteur);
	}
	
	
}

	