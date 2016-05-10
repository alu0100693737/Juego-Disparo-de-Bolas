package juego;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;


public class PrincipalApplet {
	public static void main(String[] args) throws IOException {
		// Create a frame
		JFrame frame = new JFrame("Juego Disparo Bolas");
		frame.setTitle("Juego Disparo Bolas");
		frame.pack();
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(600, 450));
		
		jfrAplicacion applet = new jfrAplicacion();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Add the applet instance to the frame
		frame.add(applet, BorderLayout.CENTER);
		
		frame.setVisible(true);
	}
}
