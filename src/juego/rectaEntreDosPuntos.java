package juego;

import java.awt.Point;
import java.util.ArrayList;

public class rectaEntreDosPuntos {
	
	private Point punto1;
	private Point punto2;
	private ArrayList<Point> puntos;
	
	public rectaEntreDosPuntos(Point p1, Point p2) {
		setPunto1(p1);
		setPunto2(p2);
		puntos = new ArrayList<Point>();
	}

	// Ecuacion para el calculo de la recta que pasa por 
	// los puntos p1 y p2 dado y
	public int calcularPunto(int y) {

		int aux = (int)((y - getPunto1().getY()) * (getPunto2().getX() - getPunto1().getX()) / (getPunto2().getY() - getPunto1().getY()));
		System.out.println(aux + getPunto1().getX() + " X " + y + " Y");
		return (int)(aux + getPunto1().getX());
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
}
