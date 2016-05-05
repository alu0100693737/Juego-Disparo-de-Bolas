package juego;

import java.io.IOException;

/** Ivan Garcia Campos   alu0100693737@ull.edu.es
 * 11/05/16
 * Programacion de aplicaciones interactivas
 * 1.0v
 * Clase para la prueba de la aplicacion
 */
import javax.swing.JFrame;

public class Principal {
	public static void main(String[] args) throws IOException {
		jfrAplicacion prueba = new jfrAplicacion();
		prueba.setTitle("Juego Disparo Bolas");
		prueba.setSize(400, 250);
		prueba.setLocationRelativeTo(null); // Center the frame
		prueba.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		prueba.setVisible(true);
	}
}
