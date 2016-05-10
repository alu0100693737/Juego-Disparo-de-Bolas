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
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class pnlScore extends JPanel {
	
	private pnlOpciones opciones;
	private jlbEtiqueta score;
	private jbnBotonInfo botonInfo;
	
	public pnlScore() throws IOException {
		setLayout(new GridLayout(3, 1, 5, 5));
		setpnlOpciones(new pnlOpciones());
		add(getpnlOpciones());
		setScore(new jlbEtiqueta("__"));
		setBotonInfo(new jbnBotonInfo());
		add(getScore());
		getBoton().getInfo().addActionListener(new abrirPanelInfo());
		add(getBoton().getInfo());
	}
	
	public jlbEtiqueta getScore() {
		return score;
	}
	
	public void setScore(jlbEtiqueta valor) {
		score = valor;
	}
	
	public jbnBotonInfo getBoton() {
		return botonInfo;
	}
	
	public void setBotonInfo(jbnBotonInfo valor) {
		botonInfo = valor;
	}
	
	public pnlOpciones getpnlOpciones() {
		return opciones;
	}
	
	public void setpnlOpciones(pnlOpciones valor) {
		opciones = valor;
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
