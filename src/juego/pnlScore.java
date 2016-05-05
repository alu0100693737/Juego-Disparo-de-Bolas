/** Ivan Garcia Campos   alu0100693737@ull.edu.es
 * 11/05/16
 * Programacion de aplicaciones interactivas
 * 1.0v
 * Clase para puntuacion y nivel del juego
 */

package juego;

import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JPanel;

public class pnlScore extends JPanel {
	private jlbEtiqueta score;
	private jbnBotonInfo boton;
	
	public pnlScore() throws IOException {
		setLayout(new GridLayout(3, 1, 5, 5));
		add(new jlbEspaciado(150, 150));
		setScore(new jlbEtiqueta("__"));
		setBoton(new jbnBotonInfo());
		add(getScore());
		add(getBoton().getInfo());
	}
	
	public jlbEtiqueta getScore() {
		return score;
	}
	
	public void setScore(jlbEtiqueta valor) {
		score = valor;
	}
	
	public jbnBotonInfo getBoton() {
		return boton;
	}
	
	public void setBoton(jbnBotonInfo valor) {
		boton = valor;
	}
}
