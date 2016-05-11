/** Ivan Garcia Campos   alu0100693737@ull.edu.es
 * 11/05/16
 * Programacion de aplicaciones interactivas
 * 1.0v
 * Clase para contener los colores rojo, amarilo, azul y verde
 */
package juego;

import java.awt.Color;
import java.util.ArrayList;

public class ColoresContainer {

	private ArrayList<Color> colores;

	public ColoresContainer() {
		setArrayColores(new ArrayList<Color>());
		getArrayColores().add(Color.RED);
		getArrayColores().add(Color.YELLOW);
		getArrayColores().add(Color.BLUE);
		getArrayColores().add(Color.GREEN);
		System.out.println(getArrayColores().size());
	}

	public ArrayList<Color> getArrayColores() {
		return colores;
	}

	public void setArrayColores(ArrayList<Color> valor) {
		colores = valor;
	}
}
