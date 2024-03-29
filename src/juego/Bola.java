/** Ivan Garcia Campos   alu0100693737@ull.edu.es
 * 11/05/16
 * Programacion de aplicaciones interactivas
 * 1.0v
 * Clase para la creacion de bolas aleatorias, coord x y, color y radio
 */

package juego;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
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
	private Ellipse2D.Double dibujoBola; 			// Bola a dibujar
	private final int PRECISION = 36; 				// precision calculo de puntos circunferenca
	// bolas cercanas con el mismo color
	private ArrayList<Point> bolasCercanas;

	public Bola(int coordX, int coordY) {
		setTipoColores(new ColoresContainer());
		setCoordX(coordX);
		setCoordY(coordY);
		Random aux = new Random();
		int aux1 = aux.nextInt() % getTipoColores().getArrayColores().size();
		setColorBola(getTipoColores().getArrayColores().get(Math.abs(aux.nextInt() % getTipoColores().getArrayColores().size())));
		setPuntosCircunferencia(new ArrayList<Point>());
		dibujoBola = new Ellipse2D.Double();
		bolasCercanas = new ArrayList<Point>();
	}
	
	public Bola(int coordX, int coordY, int color) {
		setTipoColores(new ColoresContainer());
		setCoordX(coordX);
		setCoordY(coordY);
		setColorBola(getTipoColores().getArrayColores().get(color));
		setPuntosCircunferencia(new ArrayList<Point>());
		dibujoBola = new Ellipse2D.Double();
		bolasCercanas = new ArrayList<Point>();
		
	}

	public void calcularAreaBola() {
		for (int i = 0; i < ANGULOS; i += PRECISION) {
			getPuntosCircunferencia().add(new Point((int)(RADIO_BOLA / 2 * Math.cos(Math.toDegrees(i)) + getCoordX()), (int)(RADIO_BOLA / 2 * Math.sin(Math.toDegrees(i)) + getCoordY() - RADIO_BOLA/2)));
		}
	}
	public ArrayList<Point> calcularAreaBola1() {
		ArrayList<Point> puntos = new ArrayList<Point>();
		for (int i = 0; i < ANGULOS; i += PRECISION) {
			puntos.add(new Point((int)(RADIO_BOLA / 2 * Math.cos(Math.toDegrees(i)) + getCoordX()), (int)(RADIO_BOLA / 2 * Math.sin(Math.toDegrees(i)) + getCoordY() - RADIO_BOLA/2)));
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

	public Ellipse2D.Double getDibujoBola() {
		return dibujoBola;
	}

	public void setDibujoBola(Ellipse2D.Double valor) {
		dibujoBola = valor;
	}

	public ArrayList<Point> getBolasCercanas() {
		return bolasCercanas;
	}

	public void setBolasCercanas(ArrayList<Point> valor) {
		bolasCercanas = valor;
	}
}
