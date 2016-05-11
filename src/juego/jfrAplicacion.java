/** Ivan Garcia Campos   alu0100693737@ull.edu.es
 * 11/05/16
 * Programacion de aplicaciones interactivas
 * 1.0v
 * Clase ventana aplicacion juego disparo bolas
 */
package juego;
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.io.IOException;
import java.net.URL;

import javax.swing.JApplet;
import javax.swing.JFrame;

public class jfrAplicacion extends JApplet {
	private final static int PRECISION_PINTAR = 1; // se pinta en cada pixel
	private static pnlJuego juego;
	public static pnlScore score;

	public jfrAplicacion() throws IOException {

		URL urlimagen = jfrAplicacion.class.getResource(
				"info.png");
		URL urlForAudio = getClass().getResource("musica.wav");
		System.out.println("¿Audio cargado?" + urlForAudio);
		setLayout(new BorderLayout());
		juego = new pnlJuego(Applet.newAudioClip(urlForAudio));
		score = new pnlScore(urlimagen);

		add(getJuego(), BorderLayout.CENTER);
		add(getScore(), BorderLayout.EAST);
	}

	public static pnlJuego getJuego() {
		return juego;
	}

	public static pnlScore getScore() {
		return score;
	}

	public static class timerHandler implements ActionListener {
		//pinta elemento a elemento del camino
		@Override
		public void actionPerformed(ActionEvent e) {
			//calcula uno por uno
			if(getJuego().getRectaEntrePuntos().getPunto2().getX() <= (getJuego().getWidth()/2  - getJuego().getBolaJugador().RADIO_BOLA / 2)) {
				try {
					if((getJuego().getBolaJugador().getCoordY() - getJuego().getBolaJugador().RADIO_BOLA > 0) && (!getJuego().compararCercanias())) {
						if(getJuego().getBolaJugador().getCoordX() > getJuego().getBolaJugador().RADIO_BOLA/2) {
							getJuego().getBolaJugador().setCoordY(getJuego().getBolaJugador().getCoordY() - PRECISION_PINTAR);
							getJuego().getBolaJugador().setCoordX((int)getJuego().getRectaEntrePuntos().getEcuacion().calcularX(getJuego().getBolaJugador().getCoordY()));
						}else {
							System.out.println("Choca con con el lado izquierdo");
							//cambiamos la direccion
							getJuego().getRectaEntrePuntos().getEcuacion().cambiarAPerpendicular(getJuego().getBolaJugador().getCoordX(), getJuego().getBolaJugador().getCoordY());
							getJuego().getBolaJugador().setCoordX(getJuego().getBolaJugador().getCoordX() + PRECISION_PINTAR);
							getJuego().getBolaJugador().setCoordY((int)getJuego().getRectaEntrePuntos().getEcuacion().calcularY(getJuego().getBolaJugador().getCoordX()));
						}
					} else {
						System.out.println("Choca con el techo");
						getJuego().getBolaJugador().calcularAreaBola();
						if(getJuego().getNoPintar() == false) {
							Ellipse2D.Double aux = new Ellipse2D.Double(getJuego().getBolaJugador().getCoordX() - getJuego().getBolaJugador().RADIO_BOLA / 2, getJuego().getBolaJugador().getCoordY() - getJuego().getBolaJugador().RADIO_BOLA, getJuego().getBolaJugador().RADIO_BOLA, getJuego().getBolaJugador().RADIO_BOLA);
							getJuego().getBolaJugador().setDibujoBola(aux);
							getJuego().getBolasJuego().add(getJuego().getBolaJugador());
						} else {
							getJuego().setNoPintar(false);
						}
						getJuego().getTempo().stop();
						getJuego().setBolaJugador(new Bola(getJuego().getWidth() / 2, getJuego().getHeight() - getJuego().ESPACIO_SUELO_PANEL));
						getJuego().getBolaJugador().setCoordY(getJuego().getHeight() - getJuego().ESPACIO_SUELO_PANEL);
						getJuego().getBolaJugador().setCoordX(getJuego().getWidth() / 2);
						getJuego().setLanzado(false);
					}
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if(getJuego().getRectaEntrePuntos().getPunto2().getX() > (getJuego().getWidth()/2  - getJuego().getBolaJugador().RADIO_BOLA / 2)) {
				try {
					if((getJuego().getBolaJugador().getCoordY() - getJuego().getBolaJugador().RADIO_BOLA > 0) && (!getJuego().compararCercanias())) {
						if(getJuego().getBolaJugador().getCoordX() < getJuego().getWidth() - getJuego().getBolaJugador().RADIO_BOLA / 2) {
							getJuego().getBolaJugador().setCoordY(getJuego().getBolaJugador().getCoordY() - PRECISION_PINTAR);
							getJuego().getBolaJugador().setCoordX((int)getJuego().getRectaEntrePuntos().getEcuacion().calcularX(getJuego().getBolaJugador().getCoordY()));
						} else {
							System.out.println("Chocando derecha");
							getJuego().getRectaEntrePuntos().getEcuacion().cambiarAPerpendicular(getJuego().getBolaJugador().getCoordX(), getJuego().getBolaJugador().getCoordY());
							getJuego().getBolaJugador().setCoordX(getJuego().getBolaJugador().getCoordX() - PRECISION_PINTAR);
							getJuego().getBolaJugador().setCoordY((int)getJuego().getRectaEntrePuntos().getEcuacion().calcularY(getJuego().getBolaJugador().getCoordX()));
						}
					} else {
						System.out.println("Chocando techo");
						getJuego().getBolaJugador().calcularAreaBola();
						if(getJuego().getNoPintar() == false) {
							Ellipse2D.Double aux = new Ellipse2D.Double(getJuego().getBolaJugador().getCoordX() - getJuego().getBolaJugador().RADIO_BOLA / 2, getJuego().getBolaJugador().getCoordY() - getJuego().getBolaJugador().RADIO_BOLA, getJuego().getBolaJugador().RADIO_BOLA, getJuego().getBolaJugador().RADIO_BOLA);
							getJuego().getBolaJugador().setDibujoBola(aux);
							getJuego().getBolasJuego().add(getJuego().getBolaJugador());
						} else {
							getJuego().setNoPintar(false);
						}
						System.out.println("Tamano " + getJuego().getBolasJuego().size());
						getJuego().getTempo().stop();
						getJuego().setBolaJugador(new Bola(getJuego().getWidth() / 2, getJuego().getHeight() - getJuego().ESPACIO_SUELO_PANEL));
						getJuego().getBolaJugador().setCoordY(getJuego().getHeight() - getJuego().ESPACIO_SUELO_PANEL);
						getJuego().getBolaJugador().setCoordX(getJuego().getWidth() / 2);
						getJuego().setLanzado(false);
					}
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {
				System.out.println("Perpendicular");
			}
			getJuego().repaint();
			getScore().getScore().setText((String.valueOf(getJuego().getBolasJuego().size())));
			getScore().updateUI();
			getScore().repaint();
		}
	}
}
