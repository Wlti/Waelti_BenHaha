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

	//Quand tu cliques la première fois, mémorise l'endroit
		public void mousePressed(MouseEvent e) {
			clicOrigine = e.getPoint();
		}
	
	//Fait la différence du point de départ jusqu'où je le déplace
	public void mouseDragged(MouseEvent e) {
		int differenceLargeur = e.getX()-clicOrigine.x;
		int differenceHauteur = e.getY()-clicOrigine.y;
		samsung.setLocation(samsung.getLocation().x+differenceLargeur, samsung.getLocation().y+differenceHauteur);
	}
	
	
}

	