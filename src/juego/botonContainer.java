package juego;

/** Ivan Garcia Campos   alu0100693737@ull.edu.es
 * 05/05/16
 * Programacion de aplicaciones interactivas
 * 1.0v
 * Clase contenedor de botones
 */

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;


public class botonContainer {
	ArrayList<boton> botones;
	private  static boton lanzar;
	private static boton pausa;
	private static boton borrar;

	public botonContainer() {
		botones = new ArrayList<boton>();
		lanzar = new boton("Lanzar");
		pausa = new boton("Pausa");
		borrar = new boton("Borrar");

		getLanzar().setName("Lanzar");
		getBorrar().setName("Borrar");

		getLanzar().setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		getBorrar().setFont(new Font("Comic Sans MS", Font.BOLD, 18));

		getArraybtn().add(getLanzar());
		getArraybtn().add(getBorrar());
	}

	public boton getLanzar() {
		return lanzar;
	}

	public boton getBorrar() {
		return borrar;
	}

	public ArrayList<boton> getArraybtn() {
		return botones;
	}
}
