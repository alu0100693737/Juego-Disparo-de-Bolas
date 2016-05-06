/** Ivan Garcia Campos   alu0100693737@ull.edu.es
 * 11/05/16
 * Programacion de aplicaciones interactivas
 * 1.0v
 * Clase panel del juego
 */
package juego;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import javax.swing.JPanel;

public class pnlJuego extends JPanel {
	
	private final static int ESPACIO_SUELO_PANEL = 30; // Distancia de pixeles entre la linea del suelo y el borde del panel
	private final static Color COLOR_FONDO = new Color(141, 206, 255);
	private ColoresContainer colores;
	private Bola bolaJugador;
	private ArrayList<Bola> bolasJuego; 
	public int posicionSueloHeight; 
	
	public pnlJuego() {
		setPreferredSize(new Dimension(400, 600));
		setBackground(COLOR_FONDO);
		setColores(new ColoresContainer());
		setBolaJugador(new Bola(getWidth() / 2, getHeight() - ESPACIO_SUELO_PANEL));
		
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawLine(0, getHeight() - ESPACIO_SUELO_PANEL, getWidth(), getHeight() - ESPACIO_SUELO_PANEL);
		g2.setStroke(new BasicStroke(5));
		g2.draw(new Line2D.Float(0, getHeight() - ESPACIO_SUELO_PANEL, getWidth(), getHeight() - ESPACIO_SUELO_PANEL));
		g2.setColor(getBolaJugador().getColorBola());
		g2.fillOval(getWidth()/2, getHeight() - 2 * ESPACIO_SUELO_PANEL, getBolaJugador().RADIO_BOLA, getBolaJugador().RADIO_BOLA);
		
	}
	
	public Bola getBolaJugador() {
		return bolaJugador;
	}
	
	public void setBolaJugador(Bola nueva) {
		bolaJugador = nueva;
	}
	public ColoresContainer getColores() {
		return colores;
	}
	
	public void setColores(ColoresContainer valor) {
		colores = valor;
	}
}
