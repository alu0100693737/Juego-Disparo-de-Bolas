/** Ivan Garcia Campos   alu0100693737@ull.edu.es
 * 11/05/16
 * Programacion de aplicaciones interactivas
 * 1.0v
 * Clase Etiqueta utilizada en pnlScore
 */
package juego;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class jlbEtiqueta extends JLabel {
	private final static Color COLORBOTON = new Color(194, 235, 253);
	public jlbEtiqueta(String text) {
		setText(text);
		setOpaque(true);
		setBackground(COLORBOTON);
		setForeground(Color.BLACK);
		Border line = new LineBorder(Color.BLACK);
		Border margin = new EmptyBorder(5, 15, 5, 15);
		Border compound = new CompoundBorder(line, margin);
		setBorder(compound);
		setFont(new Font("Comic Sans MS", Font.BOLD, 16));
	}
}
