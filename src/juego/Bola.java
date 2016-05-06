/** Ivan Garcia Campos   alu0100693737@ull.edu.es
 * 11/05/16
 * Programacion de aplicaciones interactivas
 * 1.0v
 * Clase para la creacion de bolas aleatorias, coord x y, color y radio
 */

package juego;

import java.awt.Color;
import java.util.Random;

public class Bola {
	final static int RADIO_BOLA = 30;
	private Color colorBola;
	private ColoresContainer tiposColores;
	private int coordenadaX;
	private int coordenadaY;
	public Bola(int coordX, int coordY) {
		setTipoColores(new ColoresContainer());
		setCoordX(coordX);
		setCoordY(coordY);
		Random aux = new Random();
		int aux1 = aux.nextInt() % getTipoColores().getArrayColores().size();
		setColorBola(getTipoColores().getArrayColores().get(Math.abs(aux.nextInt() % getTipoColores().getArrayColores().size())));
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
}
