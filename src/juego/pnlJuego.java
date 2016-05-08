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
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import javax.swing.JPanel;

public class pnlJuego extends JPanel implements MouseMotionListener {
	
	private final static int ESPACIO_SUELO_PANEL = 30; // Distancia de pixeles entre la linea del suelo y el borde del panel
	private final static Color COLOR_FONDO = new Color(141, 206, 255);
	private ColoresContainer colores;
	private Bola bolaJugador;
	private pnlFlecha flecha;
	
	private int puntoXFlecha;
	private int puntoYFlecha;
	
	private ArrayList<Bola> bolasJuego; 
	public int posicionSueloHeight; 
	
	private double phi;
	private int barb;
	
	public pnlJuego() {
		setPreferredSize(new Dimension(400, 600));
		setBackground(COLOR_FONDO);
		setColores(new ColoresContainer());
		setBolaJugador(new Bola(getWidth() / 2, getHeight() - ESPACIO_SUELO_PANEL));
		flecha = new pnlFlecha();
		setPuntoXFlecha(getWidth() / 2);
		setPuntoXFlecha(getHeight());
		addMouseMotionListener(this);
		add(flecha);
	}
	
	private void drawArrowHead(Graphics2D g2, Point tip, Point tail, Color color) {
		g2.setPaint(color);
		double dy = tip.y - tail.y;
		double dx = tip.x - tail.x;
		double theta = Math.atan2(dy, dx);
		//System.out.println("theta = " + Math.toDegrees(theta));
		double x, y, rho = theta + phi;
		for(int j = 0; j < 2; j++)
		{
			x = tip.x - barb * Math.cos(rho);
			y = tip.y - barb * Math.sin(rho);
			g2.draw(new Line2D.Double(tip.x, tip.y, x, y));
			rho = theta - phi;
		}
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawLine(0, getHeight() - ESPACIO_SUELO_PANEL, getWidth(), getHeight() - ESPACIO_SUELO_PANEL);
		g2.setStroke(new BasicStroke(3));
		g2.draw(new Line2D.Float(0, getHeight() - ESPACIO_SUELO_PANEL, getWidth(), getHeight() - ESPACIO_SUELO_PANEL));
		g2.setColor(getBolaJugador().getColorBola());
	
		g2.fillOval(getWidth()/2 - getBolaJugador().RADIO_BOLA / 2 , getHeight() - 2 * ESPACIO_SUELO_PANEL, getBolaJugador().RADIO_BOLA, getBolaJugador().RADIO_BOLA);
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		Point sw = new Point(getWidth()/2, getHeight() - ESPACIO_SUELO_PANEL);
		Point ne = new Point(getPuntoXFlecha(), getPuntoYFlecha());
		g2.draw(new Line2D.Double(sw, ne));
		//g2.drawLine(ne.x, ne.y, ne.x - 10, ne.y + 15);//drawArrowHead(g2, sw, ne, Color.red);
		//g2.drawLine(ne.x, ne.y, ne.x + 10, ne.y + 15);
		drawArrowHead(g2, ne, sw, Color.blue);
	}
	
	public Bola getBolaJugador() {
		return bolaJugador;
	}
	
	public void setBolaJugador(Bola nueva) {
		bolaJugador = nueva;
	}
	
	public int getPuntoXFlecha() {
		return puntoXFlecha;
	}
	
	public void setPuntoXFlecha(int valor) {
		puntoXFlecha = valor;
	}
	
	public int getPuntoYFlecha() {
		return puntoYFlecha;
	}
	
	public void setPuntoYFlecha(int valor) {
		puntoYFlecha = valor;
	}

	public ColoresContainer getColores() {
		return colores;
	}
	
	public void setColores(ColoresContainer valor) {
		colores = valor;
	}

	 public void mouseMoved(MouseEvent e) {
		 setPuntoXFlecha(e.getX()); 
		 setPuntoYFlecha(e.getY());
		 repaint();
  }

  public void mouseDragged(MouseEvent e) {
  	System.out.println("Dragged");
  }
}
