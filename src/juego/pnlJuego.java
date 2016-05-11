/** Ivan Garcia Campos   alu0100693737@ull.edu.es
 * 11/05/16
 * Programacion de aplicaciones interactivas
 * 1.0v
 * Clase panel del juego
 */
package juego;

import java.applet.AudioClip;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
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
	private final static int NUM_PUNTOS = 10;

	//movimiento de la bola
	private rectaEntreDosPuntos rectaPuntos;  // direccion bola
	private static Timer tempo;	//tiempo para ejecutar evento timehandler
	private boolean lanzado;	//utilizado en paint
	private boolean noPintar; //en el caso de tercera bola, no pintar la ultima
	private AudioClip sonido;

	public pnlJuego(AudioClip audio) {
		sonido = audio;
		setPreferredSize(new Dimension(400, 600));
		setBackground(COLOR_FONDO);
		setColores(new ColoresContainer());
		tempo = new Timer(2, new jfrAplicacion.timerHandler());
		setBolaJugador(new Bola(getWidth() / 2, getHeight() - ESPACIO_SUELO_PANEL - getBolaJugador().RADIO_BOLA/2));
		setPuntoXFlecha(getWidth() / 2);
		setPuntoXFlecha(getHeight());
		setBolasJuego(new ArrayList<Bola>());
		setLanzado(false);
		setNoPintar(false);
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
		if(!getLanzado()) {
			Ellipse2D.Double hole = new Ellipse2D.Double(getWidth()/2 - getBolaJugador().RADIO_BOLA/2 , getHeight() - ESPACIO_SUELO_PANEL - getBolaJugador().RADIO_BOLA/2 - getBolaJugador().RADIO_BOLA , getBolaJugador().RADIO_BOLA, getBolaJugador().RADIO_BOLA);
			g2.fill(hole);
		} else {
			Ellipse2D.Double hole = new Ellipse2D.Double(getBolaJugador().getCoordX() - getBolaJugador().RADIO_BOLA / 2, getBolaJugador().getCoordY() - getBolaJugador().RADIO_BOLA, getBolaJugador().RADIO_BOLA, getBolaJugador().RADIO_BOLA);
			g2.fill(hole);
		}

		// se Pinta la flecha
		Point inicio = new Point(getWidth()/2, getHeight() - ESPACIO_SUELO_PANEL - getBolaJugador().RADIO_BOLA);
		Point direccion = new Point(getPuntoXFlecha(), getPuntoYFlecha());
		g2.draw(new Line2D.Double(inicio, direccion));

		// se Pinta la direccion de la flecha. MEJORAR
		if(direccion.x > getWidth() / 2) {
			g2.drawLine(direccion.x, direccion.y, (int)(direccion.x - (20* Math.cos(270))) , (int)(direccion.y - (20 * Math.sin(0))));//drawArrowHead(g2, sw, ne, Color.red);
			g2.drawLine(direccion.x, direccion.y, (int)(direccion.x + (20* Math.cos(90))) , (int)(direccion.y + (20 * Math.sin(90))));//drawArrowHead(g2, sw, ne, Color.red);
		} else {
			g2.drawLine(direccion.x, direccion.y, (int)(direccion.x - (20* Math.cos(180))) , (int)(direccion.y - (20 * Math.sin(180))));//drawArrowHead(g2, sw, ne, Color.red);
			g2.drawLine(direccion.x, direccion.y, (int)(direccion.x + (20* Math.cos(0))) , (int)(direccion.y + (20 * Math.sin(0))));//drawArrowHead(g2, sw, ne, Color.red);
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

	public AudioClip getSonido() {
		return sonido;
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

	public boolean getNoPintar() {
		return noPintar;
	}

	public void setNoPintar(boolean valor) {
		noPintar = valor;
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

			setLanzado(true);
			getBolaJugador().setCoordY(getHeight() - ESPACIO_SUELO_PANEL - getBolaJugador().RADIO_BOLA/2 );
			getBolaJugador().setCoordX(getWidth() / 2);
			setRectaEntrePuntos(new Point(getWidth() / 2, getHeight() - ESPACIO_SUELO_PANEL - getBolaJugador().RADIO_BOLA/2), new Point(e.getX(), e.getY()));
			getTempo().start();

		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	public boolean compararCercanias() throws InterruptedException {
		//se compara con todas las bolas
		for (int i = 0; i < getBolasJuego().size(); i++) {

			for (int j = 0; j < NUM_PUNTOS; j++) {
				if(getBolasJuego().get(i).getDibujoBola().intersects(getBolaJugador().calcularAreaBola1().get(j).getX(), (int)(getBolaJugador().calcularAreaBola1().get(j).getY()), 1, 1)) {
					if(getBolasJuego().get(i).getColorBola() == getBolaJugador().getColorBola()) {
						if((getBolasJuego().get(i).getBolasCercanas().size() < 1)){
							getBolasJuego().get(i).getBolasCercanas().add(new Point(getBolaJugador().getCoordX(), getBolaJugador().getCoordY()));
							getBolaJugador().getBolasCercanas().add(new Point(getBolasJuego().get(i).getCoordX(), getBolasJuego().get(i).getCoordY()));
							return true;
						} else {
							for (int k = 0; k < 1; k++) {
								for (int j2 = 0; j2 < getBolasJuego().size(); j2++) {
									if((getBolasJuego().get(j2).getCoordX() == getBolasJuego().get(i).getBolasCercanas().get(k).getX()) && (getBolasJuego().get(j2).getCoordY() == getBolasJuego().get(i).getBolasCercanas().get(k).getY())) {
										getBolasJuego().remove(j2);
										getSonido().loop();
										Thread.sleep(600);
										getSonido().stop();
										break;
									}
								}
								getBolasJuego().remove(i - 1);
								setNoPintar(true);
								return true;
							}
						}
					} // color
					return true;
				}//interseccion
			}
		}
		return false;
	}
}

