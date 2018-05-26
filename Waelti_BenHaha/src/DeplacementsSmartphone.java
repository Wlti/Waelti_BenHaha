import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;


public class DeplacementsSmartphone extends MouseAdapter implements MouseMotionListener {
	
	private Smartphone samsung;	
	private Point clicOrigine;	
	private int differenceLargeur;
	private int differenceHauteur;
	
	public DeplacementsSmartphone (Smartphone samsung){
	this.samsung = samsung;	
	}

	//Quand tu cliques la première fois, mémorise l'endroit
		public void mousePressed(MouseEvent e) {
			clicOrigine = e.getPoint();
		}
	
	//Fait la différence du point de départ jusqu'où je le déplace
	public void mouseDragged(MouseEvent e) {
		this.differenceLargeur = e.getX()-clicOrigine.x;
		this.differenceHauteur = e.getY()-clicOrigine.y;
		samsung.setLocation(samsung.getLocation().x+differenceLargeur, samsung.getLocation().y+differenceHauteur);
	}

	public int getDifferenceLargeur() {
		return differenceLargeur;
	}

	public void setDifferenceLargeur(int differenceLargeur) {
		this.differenceLargeur = differenceLargeur;
	}

	public int getDifferenceHauteur() {
		return differenceHauteur;
	}

	public void setDifferenceHauteur(int differenceHauteur) {
		this.differenceHauteur = differenceHauteur;
	}
	
	
}

	