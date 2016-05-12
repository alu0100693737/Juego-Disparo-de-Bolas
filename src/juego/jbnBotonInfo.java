/** Ivan Garcia Campos   alu0100693737@ull.edu.es
 * 11/05/16
 * Programacion de aplicaciones interactivas
 * 1.0v
 * Clase para el boton informacion datos del desarrollador
 */
package juego;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public final class jbnBotonInfo {
	private JButton info;
	public jbnBotonInfo(URL url) throws IOException {
		setInfo(new JButton(new ImageIcon(url)));
		getInfo().setBorder(null);
		getInfo().setBackground(Color.WHITE);
	}

	public JButton getInfo() {
		return info;
	}

	public void setInfo(JButton valor) {
		info = valor;
	}
}
