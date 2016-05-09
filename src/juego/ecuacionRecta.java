package juego;

import java.awt.Point;

//Clase para la representacion de ecuaciones de la forma ax + by + c = 0;
public class ecuacionRecta {
	private double valorX;
	private double valorY;
	private double constante;
	
	public ecuacionRecta(double a1, double a2, double b1, double b2) {
		System.out.println("Punto1 " + a1 + ", " + a2  + " " + b1 + ", " + b2);
		//ecuacion de la forma 
		// x - x1   y - y1
		// ------ = ------
		// x2-x1    y2 - y1
		
		valorX = (b2 - a2) / (b1 - a1);
		valorY = -(b1 - a1);
		constante = (-a1 * (b2 - a2)) + (a2 * (b1 - a1));
		System.out.println("La ecuacion es : " + valorX + "x + " + valorY + "y + " +  constante);
	}
}
