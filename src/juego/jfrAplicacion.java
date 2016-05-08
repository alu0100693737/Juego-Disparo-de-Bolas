/** Ivan Garcia Campos   alu0100693737@ull.edu.es
 * 11/05/16
 * Programacion de aplicaciones interactivas
 * 1.0v
 * Clase ventana aplicacion juego disparo bolas
 */
package juego;
import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;

public class jfrAplicacion extends JFrame {
	
	private final static int PRECISION_PINTAR = 1; // se pinta en cada pixel
	private pnlJuego juego;
	public pnlScore score;

	public jfrAplicacion() throws IOException {
		setLayout(new BorderLayout());
		juego = new pnlJuego();
		score = new pnlScore();
		
		add(juego, BorderLayout.CENTER);
		add(score, BorderLayout.EAST);
	}
}
