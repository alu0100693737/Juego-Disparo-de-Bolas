package juego;

import java.awt.Point;
import java.util.ArrayList;

public class rectaEntreDosPuntos {
	
	private Point punto1;
	private Point punto2;
	private ecuacionRecta ecuacion;
	private ArrayList<Point> puntos;
	
	public rectaEntreDosPuntos(Point p1, Point p2) {
		ecuacion = new ecuacionRecta(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		setPunto1(p1);
		setPunto2(p2);
		puntos = new ArrayList<Point>();
	}
	
	public Point getPunto1() {
		return punto1;
	}
	
	public void setPunto1(Point valor) {
		punto1 = valor;
	}
	
	public Point getPunto2() {
		return punto2;
	}
	
	public void setPunto2(Point valor) {
		punto2 = valor;
	}
	
	public ecuacionRecta getEcuacion() {
		return ecuacion;
	}
}
