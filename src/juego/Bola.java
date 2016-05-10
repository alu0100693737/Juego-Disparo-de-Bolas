/** Ivan Garcia Campos   alu0100693737@ull.edu.es
 * 11/05/16
 * Programacion de aplicaciones interactivas
 * 1.0v
 * Clase para la creacion de bolas aleatorias, coord x y, color y radio
 */

package juego;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Bola {
	final static int RADIO_BOLA = 30;
	private final static int ANGULOS = 360;
	private Color colorBola;
	private ColoresContainer tiposColores;
	private int coordenadaX;
	private int coordenadaY;
	private ArrayList<Point> puntosCircunfencia;
	
	public Bola(int coordX, int coordY) {
		setTipoColores(new ColoresContainer());
		setCoordX(coordX);
		setCoordY(coordY);
		Random aux = new Random();
		int aux1 = aux.nextInt() % getTipoColores().getArrayColores().size();
		setColorBola(getTipoColores().getArrayColores().get(Math.abs(aux.nextInt() % getTipoColores().getArrayColores().size())));
		setPuntosCircunferencia(new ArrayList<Point>());
	}
	
	public void calcularAreaBola() {
		for (int i = 0; i < ANGULOS; i++) {
			getPuntosCircunferencia().add(new Point((int)(RADIO_BOLA / 2 * Math.cos(Math.toDegrees(i)) + getCoordX() + RADIO_BOLA/2), (int)(RADIO_BOLA / 2 * Math.sin(Math.toDegrees(i)) + getCoordY() + RADIO_BOLA/2)));
		}
	}
	public ArrayList<Point> calcularAreaBola1() {
		ArrayList<Point> puntos = new ArrayList<Point>();
		for (int i = 0; i < ANGULOS; i++) {
			puntos.add(new Point((int)(RADIO_BOLA / 2 * Math.cos(Math.toDegrees(i)) + getCoordX() + RADIO_BOLA/2), (int)(RADIO_BOLA / 2 * Math.sin(Math.toDegrees(i)) + getCoordY() + RADIO_BOLA/2)));
		}
		return puntos;
	}
	
	public Color getColorBola() {
		return colorBola;
	}
	
	public void setColorBola(Color nuevo) {
		colorBola = nuevo;
	}
	
	public int getCoordX() {
		return coordenadaX;
	}
	
	public void setCoordX(int valor) {
		coordenadaX = valor;
	}
	
	public int getCoordY() {
		return coordenadaY;
	}
	
	public void setCoordY(int valor) {
		coordenadaY = valor;
	}
	
	public ColoresContainer getTipoColores() {
		return tiposColores;
	}
	
	public void setTipoColores(ColoresContainer colores) {
		tiposColores = colores;
	}
	
	public ArrayList<Point> getPuntosCircunferencia() {
		return puntosCircunfencia;
	}
	
	public void setPuntosCircunferencia(ArrayList<Point> valor) {
		puntosCircunfencia = valor;
	}
}
