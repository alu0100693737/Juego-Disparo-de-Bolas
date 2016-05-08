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
	private final static int PRECISION_PINTAR = 1; // se pinta en cada pixel
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
					if(prueba < 50) {
						System.out.println("Dentro del timer");
						prueba++;
						System.out.println("Buda" + juego.getPosicionXBola() + " " + juego.getPosicionYBola());
						juego.setPosicionXBola(juego.getPosicionXBola() - 10);
						juego.setPosicionYBola(juego.getPosicionYBola() + 10);
						System.out.println("Ivan" + juego.getPosicionXBola() + " " + juego.getPosicionYBola());

						juego.repaint();
					} else {
						juego.getTempo().stop();
					}
				}
			}
}
