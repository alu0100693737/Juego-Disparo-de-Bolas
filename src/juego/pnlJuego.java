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
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
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
	private static Timer tempo;
	private boolean lanzado;

	public pnlJuego() {
		setPreferredSize(new Dimension(400, 600));
		setBackground(COLOR_FONDO);
		setColores(new ColoresContainer());
		tempo = new Timer(2, new jfrAplicacion.timerHandler());
		setBolaJugador(new Bola(getWidth() / 2, getHeight() - ESPACIO_SUELO_PANEL - getBolaJugador().RADIO_BOLA/2));
		setPuntoXFlecha(getWidth() / 2);
		setPuntoXFlecha(getHeight());
		setBolasJuego(new ArrayList<Bola>());
		//crearBolas(20); //se Crean 20 Bolas en posiciones correctas
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
		g2.draw(new Line2D.Float(0, getHeight() - ESPACIO_SUELO_PANEL - getBolaJugador().RADIO_BOLA/2, getWidth(), getHeight() - ESPACIO_SUELO_PANEL - getBolaJugador().RADIO_BOLA/2));
		g2.setStroke(new BasicStroke(3));
		g2.draw(new Line2D.Float(getWidth() - 3, 0, getWidth() - 3, getHeight() - ESPACIO_SUELO_PANEL - getBolaJugador().RADIO_BOLA/2));

		//se pintan las bolas que existen
		for (int i = 0; i < getBolasJuego().size(); i++) {
			g2.setColor(getBolasJuego().get(i).getColorBola());
			g2.fill(getBolasJuego().get(i).getDibujoBola());
		}
		
		g2.setColor(getBolaJugador().getColorBola());
		// se Pinta la bola
	
		if(!lanzado) {
			Ellipse2D.Double hole = new Ellipse2D.Double(getWidth()/2 - getBolaJugador().RADIO_BOLA/2 , getHeight() - ESPACIO_SUELO_PANEL - getBolaJugador().RADIO_BOLA/2 - getBolaJugador().RADIO_BOLA , getBolaJugador().RADIO_BOLA, getBolaJugador().RADIO_BOLA);
			g2.fill(hole);
		} else {
			Ellipse2D.Double hole = new Ellipse2D.Double(getBolaJugador().getCoordX() - getBolaJugador().RADIO_BOLA / 2, getBolaJugador().getCoordY() - getBolaJugador().RADIO_BOLA, getBolaJugador().RADIO_BOLA, getBolaJugador().RADIO_BOLA);
			g2.fill(hole);
		}
		// se Pinta la flecha
		Point sw = new Point(getWidth()/2, getHeight() - ESPACIO_SUELO_PANEL - getBolaJugador().RADIO_BOLA);
		Point ne = new Point(getPuntoXFlecha(), getPuntoYFlecha());
		g2.draw(new Line2D.Double(sw, ne));

		// se Pinta la direccion de la flecha. MEJORAR
		if(ne.x > getWidth() / 2) {
			g2.drawLine(ne.x, ne.y, (int)(ne.x - (20* Math.cos(270))) , (int)(ne.y - (20 * Math.sin(0))));//drawArrowHead(g2, sw, ne, Color.red);
			g2.drawLine(ne.x, ne.y, (int)(ne.x + (20* Math.cos(90))) , (int)(ne.y + (20 * Math.sin(90))));//drawArrowHead(g2, sw, ne, Color.red);
		} else {
			g2.drawLine(ne.x, ne.y, (int)(ne.x - (20* Math.cos(180))) , (int)(ne.y - (20 * Math.sin(180))));//drawArrowHead(g2, sw, ne, Color.red);
			g2.drawLine(ne.x, ne.y, (int)(ne.x + (20* Math.cos(0))) , (int)(ne.y + (20 * Math.sin(0))));//drawArrowHead(g2, sw, ne, Color.red);
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

	public ArrayList<Bola> getBolasJuego() {
		return bolasJuego;
	}

	public void setBolasJuego(ArrayList<Bola> valor) {
		bolasJuego = valor;
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

		if (!getTempo().isRunning()) {
			System.out.println("Altura: " + getHeight());
			setLanzado(true);
			getBolaJugador().setCoordY(getHeight() - ESPACIO_SUELO_PANEL - getBolaJugador().RADIO_BOLA/2 );
			getBolaJugador().setCoordX(getWidth() / 2);
			setRectaEntrePuntos(new Point(getWidth() / 2, getHeight() - ESPACIO_SUELO_PANEL - getBolaJugador().RADIO_BOLA/2), new Point(e.getX(), e.getY()));
			System.out.println("Pendiente " + getRectaEntrePuntos().getEcuacion().getPendiente());
			getTempo().start();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	public boolean compararCercanias() {
		Graphics g = getGraphics();
		g.setColor(Color.BLACK);

		for (int i = 0; i < getBolasJuego().size(); i++) {
			for (int j = 0; j < 10; j++) {
				if(getBolasJuego().get(i).getDibujoBola().intersects(getBolaJugador().calcularAreaBola1().get(j).getX(), (int)(getBolaJugador().calcularAreaBola1().get(j).getY()), 1, 1)) {

					System.out.println("caso 1");
					return true;
				}/* else if (getBolasJuego().get(i).getDibujoBola().contains(getPosicionXBola() - getBolaJugador().RADIO_BOLA, getPosicionYBola())) {
					System.out.println("caso 2");
					return true;
				} else if (getBolasJuego().get(i).getDibujoBola().contains(getPosicionXBola() + getBolaJugador().RADIO_BOLA, getPosicionYBola())) {
					System.out.println("caso 3");
					return true;
				} */else { }
					//g.fillOval((int)getBolasJuego().get(i).getPuntosCircunferencia().get(j).getX(), 
					//		(int)getBolasJuego().get(i).getPuntosCircunferencia().get(j).getY(), 5, 5);
					//paint(g);
				//	return true;
				//}
			//g.drawRect((int)(getBolaJugador().getPuntosCircunferencia().get(j).getX()), (int)(getBolaJugador().getPuntosCircunferencia().get(j).getY()), (int)(getBolaJugador().getPuntosCircunferencia().get(j).getX()), (int)(getBolaJugador().getPuntosCircunferencia().get(j).getY()));
		}
			

			/*//Graphics g = getGraphics();
			g.setColor(Color.BLACK);
			for (int j = 0; j < 360; j++) {
				g.drawRect((int)getBolaJugador().calcularAreaBola1().get(j).getX(), (int)(getBolaJugador().calcularAreaBola1().get(j).getY()), 10, 10);
				g.fillOval((int)getBolasJuego().get(i).getPuntosCircunferencia().get(j).getX(), 
						(int)getBolasJuego().get(i).getPuntosCircunferencia().get(j).getY(), 5, 5);
				g.fillOval((int)(getBolaJugador().calcularAreaBola1().get(j).getX()), (int)(getBolaJugador().calcularAreaBola1().get(j).getY()), 10, 10);
			}
			*/

		
		}
		return false;
	}
}

