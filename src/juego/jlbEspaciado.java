package juego;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;

public final class jlbEspaciado extends JLabel {
	public jlbEspaciado(int x, int y) {
		setPreferredSize(new Dimension(x, y));
	}
}

