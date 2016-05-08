package juego;

import java.awt.Point;

public class rectaEntreDosPuntos {
	
	public Point punto1;
	public Point punto2;
	public rectaEntreDosPuntos(Point p1, Point p2) {
		setPunto1(p1);
		setPunto2(p2);
	}
	
	// Ecuacion para el calculo de la recta que pasa por 
	// los puntos p1 y p2 dado x
	public int calcularPunto(int x) {
		int aux = (int) (((getPunto2().getY() - getPunto1().getY()) / (getPunto2().getX() - getPunto1().getX())) * (x - getPunto1().getX()));
		return (int)(aux + getPunto1().getY());
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
