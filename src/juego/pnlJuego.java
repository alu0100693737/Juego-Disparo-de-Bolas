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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

public class pnlJuego extends JPanel implements MouseListener, MouseMotionListener {
	public final static int ESPACIO_SUELO_PANEL = 30; // Distancia de pixeles entre la linea del suelo y el borde del panel
	private final static Color COLOR_FONDO = new Color(141, 206, 255);
	private ColoresContainer colores;
	private Bola bolaJugador;
	private int puntoXFlecha;
	private int puntoYFlecha;
	private ArrayList<Bola> bolasJuego; 
	
	//movimiento de la bola
	private rectaEntreDosPuntos rectaPuntos; 
	private static int posicionXBola;
	private static int posicionYBola;
	private static Timer tempo;
	private boolean lanzado;
	
	public pnlJuego() {
		setPreferredSize(new Dimension(400, 600));
		System.out.println("HOLA");
		System.out.println(getSize().getWidth() + " " + getSize().getHeight());
		setBackground(COLOR_FONDO);
		setColores(new ColoresContainer());
		tempo = new Timer(500, new jfrAplicacion.timerHandler());
		setBolaJugador(new Bola(getWidth() / 2, getHeight() - ESPACIO_SUELO_PANEL));
		setPuntoXFlecha(getWidth() / 2);
		setPuntoXFlecha(getHeight());
		
		System.out.println("Creando");
		System.out.println(getPosicionXBola() + " " + getPosicionYBola());

		setLanzado(false);
		addMouseMotionListener(this);
		addMouseListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		
		// se Pinta el suelo
		g2.setStroke(new BasicStroke(3));
		g2.draw(new Line2D.Float(0, getHeight() - ESPACIO_SUELO_PANEL, getWidth(), getHeight() - ESPACIO_SUELO_PANEL));
		
		g2.setColor(getBolaJugador().getColorBola());
		// se Pinta la bola
		if(!lanzado) {
			g2.fillOval(getWidth()/2 - getBolaJugador().RADIO_BOLA / 2 , getHeight() - 2 * ESPACIO_SUELO_PANEL, getBolaJugador().RADIO_BOLA, getBolaJugador().RADIO_BOLA);
		} else {
			g2.fillOval(getWidth()/2 + getPosicionXBola() - getBolaJugador().RADIO_BOLA / 2, getHeight() - 2 *  ESPACIO_SUELO_PANEL + getPosicionYBola() - getBolaJugador().RADIO_BOLA / 2, getBolaJugador().RADIO_BOLA, getBolaJugador().RADIO_BOLA);			//}
		}
		// se Pinta la flecha
		Point sw = new Point(getWidth()/2, getHeight() - ESPACIO_SUELO_PANEL);
		Point ne = new Point(getPuntoXFlecha(), getPuntoYFlecha());
		g2.draw(new Line2D.Double(sw, ne));
		
		// se Pinta la direccion de la flecha
		if(ne.x > getWidth() / 2) {
			g2.drawLine(ne.x, ne.y, ne.x - ne.x / 10 , ne.y + ne.y / 5);//drawArrowHead(g2, sw, ne, Color.red);
		} else {
			g2.drawLine(ne.x, ne.y, ne.x + ne.x / 10 , ne.y + ne.y /5);
		}
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
	
	public boolean getLanzado() {
		return lanzado;
	}
	
	public void setLanzado(boolean valor) {
		lanzado = valor;
	}
	
	public rectaEntreDosPuntos getRectaEntrePuntos() {
		return rectaPuntos;
	}
	
	public void setRectaEntrePuntos(Point p1, Point p2) {
		rectaPuntos = new rectaEntreDosPuntos(p1, p2);
	}
	
	public int getPosicionXBola() {
		return posicionXBola;
	}

	public void setPosicionXBola(int valor) {
		posicionXBola = valor;
	}
	
	public int getPosicionYBola() {
		return posicionYBola;
	}

	public void setPosicionYBola(int valor) {
		posicionYBola = valor;
	}
	
	public static Timer getTempo() {
		return tempo;
	}
	
	 public void mouseMoved(MouseEvent e) {
		 setPuntoXFlecha(e.getX()); 
		 setPuntoYFlecha(e.getY());
		 repaint();
  }

  public void mouseDragged(MouseEvent e) {
  	System.out.println("Dragged");
  }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println(getWidth()/ 2 + " ");
		System.out.println(getHeight() - ESPACIO_SUELO_PANEL);
		System.out.println("Evento:" + e.getX() + " " + e.getY());
		setRectaEntrePuntos(new Point(getWidth() / 2, getHeight() - ESPACIO_SUELO_PANEL), new Point(e.getX(), e.getY()));
		setLanzado(true);
		if (getTempo().isRunning()) {
			getTempo().stop();
		}
		else {
			getTempo().start();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
