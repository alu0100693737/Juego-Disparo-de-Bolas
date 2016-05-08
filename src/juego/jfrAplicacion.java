/** Ivan Garcia Campos   alu0100693737@ull.edu.es
 * 11/05/16
 * Programacion de aplicaciones interactivas
 * 1.0v
 * Clase ventana aplicacion juego disparo bolas
 */
package juego;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.GenericArrayType;

import javax.swing.JFrame;

public class jfrAplicacion extends JFrame {
	private static int prueba;	
	private final static int PRECISION_PINTAR = 2; // se pinta en cada pixel
	private static pnlJuego juego;
	public static pnlScore score;

	public jfrAplicacion() throws IOException {
		prueba = 0;
		setLayout(new BorderLayout());
		juego = new pnlJuego();
		score = new pnlScore();

		add(juego, BorderLayout.CENTER);
		add(score, BorderLayout.EAST);
	}
	public static class timerHandler implements ActionListener {
		//pinta elemento a elemento del camino
		@Override
		public void actionPerformed(ActionEvent e) {
			//calcula uno por uno
			if(prueba < 1000) {

				prueba++;
				if(juego.getRectaEntrePuntos().getPunto2().getX() < (juego.getWidth()/2  - juego.getBolaJugador().RADIO_BOLA / 2)) {
					juego.setPosicionXBola(juego.getPosicionXBola() - PRECISION_PINTAR);
					juego.setPosicionYBola(juego.getHeight() - juego.getRectaEntrePuntos().calcularPunto(juego.getWidth()/ 2 - juego.getPosicionXBola()));
				} else if(juego.getRectaEntrePuntos().getPunto2().getX() > (juego.getWidth()/2  - juego.getBolaJugador().RADIO_BOLA / 2)) {
					System.out.println("NOO");
					System.out.println(juego.getRectaEntrePuntos().getPunto2().getX() +  " X ");
					
					juego.setPosicionXBola(juego.getPosicionXBola() + PRECISION_PINTAR);
					juego.setPosicionYBola(juego.getHeight() - juego.getRectaEntrePuntos().calcularPunto(juego.getWidth()/ 2 - juego.getPosicionXBola()));
				} else {
					
				}
				juego.repaint();
			} else {
				juego.getTempo().stop();
			}
		}
	}
}
