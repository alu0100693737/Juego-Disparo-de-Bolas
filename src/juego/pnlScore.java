/** Ivan Garcia Campos   alu0100693737@ull.edu.es
 * 11/05/16
 * Programacion de aplicaciones interactivas
 * 1.0v
 * Clase para puntuacion y nivel del juego
 */

package juego;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import javax.swing.JPanel;

public class pnlScore extends JPanel {
	private jlbEtiquetaScore score;
	private jbnBotonInfo botonInfo;
	private jlbEspaciado espacio;

	public pnlScore(URL url) throws IOException {
		setLayout(new GridLayout(3, 1, 0, 0));
		setEspacio(new jlbEspaciado(60, 80));
		setBackground(Color.BLACK);
		add(getEspacio());
		setScore(new jlbEtiquetaScore("__"));
		setBotonInfo(new jbnBotonInfo(url));
		add(getScore());
		getBoton().getInfo().addActionListener(new abrirPanelInfo());
		add(getBoton().getInfo());
	}

	public jlbEtiquetaScore getScore() {
		return score;
	}

	public void setScore(jlbEtiquetaScore valor) {
		score = valor;
	}

	public jbnBotonInfo getBoton() {
		return botonInfo;
	}

	public void setBotonInfo(jbnBotonInfo valor) {
		botonInfo = valor;
	}

	public jlbEspaciado getEspacio() {
		return espacio;
	}

	public void setEspacio(jlbEspaciado valor) {
		espacio = valor;
	}

	public static class abrirPanelInfo implements ActionListener {
		//crea un color aleatorio
		public void actionPerformed(ActionEvent arg0) {	
			jfrInfo info = new jfrInfo();
			info.setTitle("Juego Disparo Bolas");
			info.pack();
			info.setResizable(false);
			info.setLocationRelativeTo(null); // Center the frame
			info.setVisible(true);
		}	
	}
}
