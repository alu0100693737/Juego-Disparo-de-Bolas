package juego;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class pnlOpciones extends JPanel {
	private botonContainer botones;
	
	public pnlOpciones() {
		botones = new botonContainer();
		setLayout(new GridLayout(2, 1 , 5, 5));
		
		for (int i = 0; i < getBotones().getArraybtn().size(); i++) {
			add(getBotones().getArraybtn().get(i));
		}
	}
	
	public botonContainer getBotones() {
		return botones;
	}

}
