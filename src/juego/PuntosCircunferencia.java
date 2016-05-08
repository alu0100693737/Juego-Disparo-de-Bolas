package juego;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JFrame;

public class PuntosCircunferencia {
	private ArrayList<Point> puntos;
	private int radio;
	
	public PuntosCircunferencia(int rad) {
		radio = rad;
		puntos = new ArrayList<Point>();
		calcularPuntos();
	}
	
	/*@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		for (int i = 0; i < puntos.size(); i++) {
			g.fillOval((int)puntos.get(i).getX() + getWidth()/2, (int)puntos.get(i).getY() + getHeight() / 2, 1, 1);
		}
	}*/
	
	public void calcularPuntos() {
		for(int i = 0; i <= 360; i++) {
			//if (getRadioCircunferencia() * Math.sin(i) <= 0)
				getPuntosCircunferencia().add(new Point((int)(getRadioCircunferencia() * Math.cos(i)), (int)(getRadioCircunferencia() * Math.sin(i))));
		}
	}
	
	public ArrayList<Point> getPuntosCircunferencia() {
		return puntos;
	}
	
	public int getRadioCircunferencia() {
		return radio;
	}
	
	public void mostrarPuntos() {
		for (int i = 0; i < getPuntosCircunferencia().size(); i++) {
			System.out.println(getPuntosCircunferencia().get(i));
		}
	}
}
