/** Ivan Garcia Campos   alu0100693737@ull.edu.es
 * 11/05/16
 * Programacion de aplicaciones interactivas
 * 1.0v
 * Clase para contener los colores rojo, amarilo, azul y verde
 */
package juego;

import java.awt.Point;

// Clase para el calculo de la recta que resulta de la direccion de la bola
// Incluye representacion de la perpendicular
// la representacion de ecuaciones de la forma ax + by + c = 0;
public class ecuacionRecta {
	private double valorX;
	private double valorY;
	private double constante;
	private double pendiente;

	// Puntos necesarios para calcular la perpendicular
	private double x1;
	private double y1;

	public ecuacionRecta(double a1, double a2, double b1, double b2) {
		pendiente = (b2 - a2) / (b1 -a1);
		valorX = - pendiente;
		valorY = 1 ;
		constante = -a2 - (getPendiente() * (-a1));
		mostrarEcuacion();
		x1 = a1;
		y1 = a2;
	}

	public double calcularX(int y) {
		return ((-getValorY() * y) - getConstante()) / getValorX();
	}

	public double calcularY(int x) {
		return ((-getValorX() * x) - getConstante()) / getValorY();
	}

	public void mostrarEcuacion() {		
		System.out.println("Pendiente " + getPendiente());
		System.out.println("La ecuacion es : " + getValorX() + "x + " + getValorY() + "y + " +  getConstante());

	}

	public void cambiarAPerpendicular(double x1, double y1) {
		pendiente = -1/pendiente;
		valorX = - pendiente;
		valorY = 1 ;
		constante = -y1 - (getPendiente() * (-x1));
		mostrarEcuacion();
	}

	public double getValorX() {
		return valorX;
	}

	public double getValorY() {
		return valorY;
	}

	public double getConstante() {
		return constante;
	}

	public double getPendiente() {
		return pendiente;
	}	

	public double getX1() {
		return x1;
	}

	public double getY1() {
		return y1;
	}
}
