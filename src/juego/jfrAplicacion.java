/** Ivan Garcia Campos   alu0100693737@ull.edu.es
 * 11/05/16
 * Programacion de aplicaciones interactivas
 * 1.0v
 * Clase ventana aplicacion juego disparo bolas
 */
package juego;
import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.GenericArrayType;

import javax.swing.JFrame;

import org.omg.PortableServer.ServantRetentionPolicyOperations;

public class jfrAplicacion extends JFrame {
	private static int prueba;	
	private final static int PRECISION_PINTAR = 1; // se pinta en cada pixel
	private static pnlJuego juego;
	public static pnlScore score;

	public jfrAplicacion() throws IOException {
		prueba = 0;
		setLayout(new BorderLayout());
		juego = new pnlJuego();
		score = new pnlScore();

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
				if(getJuego().getPosicionYBola() - getJuego().getBolaJugador().RADIO_BOLA > 0) {
					if(getJuego().getPosicionXBola() > getJuego().getBolaJugador().RADIO_BOLA/2) {
						getJuego().setPosicionYBola(getJuego().getPosicionYBola() - PRECISION_PINTAR);
						getJuego().setPosicionXBola(getJuego().getRectaEntrePuntos().calcularPunto(getJuego().getPosicionYBola()));
					}else {
						System.out.println("Choca con con el lado izquierdo");
						//cambiamos la direccion
						getJuego().getTempo().stop();
						getJuego().setLanzado(false);
					}
				} else {
					System.out.println("Choca con el techo");
					getJuego().getTempo().stop();
					getJuego().setLanzado(false);
				}
			} else if(getJuego().getRectaEntrePuntos().getPunto2().getX() > (getJuego().getWidth()/2  - getJuego().getBolaJugador().RADIO_BOLA / 2)) {
				if(getJuego().getPosicionYBola() - getJuego().getBolaJugador().RADIO_BOLA > 0) {
					if(getJuego().getPosicionXBola() < getJuego().getWidth() - getJuego().getBolaJugador().RADIO_BOLA / 2) {
						getJuego().setPosicionYBola(getJuego().getPosicionYBola() - PRECISION_PINTAR);
						getJuego().setPosicionXBola(getJuego().getRectaEntrePuntos().calcularPunto(getJuego().getPosicionYBola()));
					} else {
						System.out.println("Chocando derecha");
						getJuego().getTempo().stop();
						/*setPosicionYBola(getHeight() - ESPACIO_SUELO_PANEL);
						setPosicionXBola(getWidth() / 2);
						setLanzado(true);
						setRectaEntrePuntos(new Point(getWidth() / 2, getHeight() - ESPACIO_SUELO_PANEL), new Point(e.getX(), e.getY()));
						getTempo().start();*/
						
						getJuego().setLanzado(false);
					}
				} else {
					System.out.println("Chocando techo");
					getJuego().getTempo().stop();
					getJuego().setLanzado(false);
				}
			} else {
				System.out.println("Perpendicular");
			}
			getJuego().repaint();
		}
	}
}
