/** Ivan Garcia Campos   alu0100693737@ull.edu.es
 * 11/05/16
 * Programacion de aplicaciones interactivas
 * 1.0v
 * Panel informacion, muestra datos del desarrollador
 */

package juego;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class pnlInfo extends JPanel {
	
	private final static JLabel NOMBRE = new JLabel("Nombre:");
	private final static JLabel EMAIL = new JLabel("Email:");
	private final static JLabel ASIGNATURA = new JLabel("Asignatura:");
	
	private final static JLabel VALOR_NOMBRE = new JLabel("Ivan Garcia Campos");
	private final static JLabel VALOR_EMAIL = new JLabel("alu0100693737@ull.edu.es");
	private final static JLabel VALOR_ASIGNATURA = new JLabel("Programacion de aplicaciones interactivas");
	
	public pnlInfo() {
		setLayout(new GridLayout(3, 2, 5, 5));
		add(NOMBRE); add(VALOR_NOMBRE);
		add(EMAIL); add(VALOR_EMAIL);
		add(ASIGNATURA); add(VALOR_ASIGNATURA);
	}
}
