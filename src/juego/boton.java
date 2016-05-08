package juego;

/** Ivan Garcia Campos   alu0100693737@ull.edu.es
 * 05/05/16
 * Programacion de aplicaciones interactivas
 * 1.0v
 * Clase Boton para la creacion de boton propio
 */


import java.awt.Color;

import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class boton extends JButton {
	private final static Color COLORBOTON = new Color(255, 255, 88);
	public boton(String text) {
		setText(text);
		setForeground(Color.BLACK);
		setBackground(COLORBOTON);
		Border line = new LineBorder(Color.BLACK);
		Border margin = new EmptyBorder(5, 15, 5, 15);
		Border compound = new CompoundBorder(line, margin);
		setBorder(compound);
	}
}
