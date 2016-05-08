/** Ivan Garcia Campos   alu0100693737@ull.edu.es
 * 11/05/16
 * Programacion de aplicaciones interactivas
 * 1.0v
 * Panel informacion, muestra datos del desarrollador
 */

package juego;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class jfrInfo extends JFrame {
	
	private final static Color COLOR_FONDO = new Color(141, 206, 255);
	
	private final static jlbEtiqueta NOMBRE = new jlbEtiqueta("Nombre:");
	private final static jlbEtiqueta EMAIL = new jlbEtiqueta("Email:");
	private final static jlbEtiqueta ASIGNATURA = new jlbEtiqueta("Asignatura:");
	
	private final static jlbEtiqueta VALOR_NOMBRE = new jlbEtiqueta("Ivan Garcia Campos");
	private final static jlbEtiqueta VALOR_EMAIL = new jlbEtiqueta("alu0100693737@ull.edu.es");
	private final static jlbEtiqueta VALOR_ASIGNATURA = new jlbEtiqueta("Programacion de aplicaciones interactivas");
	
	private JPanel entradas;
	private JPanel datos;
	
	public jfrInfo() {
		setLayout(new BorderLayout(5, 5));
		setBackground(COLOR_FONDO);
		setEntradas(new JPanel());
		getEntradas().setLayout(new GridLayout(3, 1, 5, 5));
		getEntradas().add(NOMBRE);
		getEntradas().add(EMAIL);
		getEntradas().add(ASIGNATURA);
		
		setDatos(new JPanel());
		getDatos().setLayout(new GridLayout(3, 1, 5, 5));
		getDatos().add(VALOR_NOMBRE);
		getDatos().add(VALOR_EMAIL);
		getDatos().add(VALOR_ASIGNATURA);
		
		add(getEntradas(), BorderLayout.WEST);
		add(getDatos(), BorderLayout.CENTER);
	}
	
	JPanel getEntradas() {
		return entradas;
	}
	
	void setEntradas(JPanel nuevo) {
		entradas = nuevo;
	}
	
	JPanel getDatos() {
		return datos;
	}
	
	void setDatos(JPanel nuevo) {
		datos = nuevo;
	}
}
