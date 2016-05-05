/** Ivan Garcia Campos   alu0100693737@ull.edu.es
 * 11/05/16
 * Programacion de aplicaciones interactivas
 * 1.0v
 * Clase Etiqueta utilizada en pnlScore
 */
package juego;
import java.awt.Color;
import javax.swing.JLabel;

public class jlbEtiqueta extends JLabel {
	private final static Color COLORBOTON = new Color(255, 255, 88);
	public jlbEtiqueta(String text) {
		setText(text);
		setAlignmentX(CENTER);
		setForeground(Color.BLACK);
		setBackground(COLORBOTON);
	}
}
