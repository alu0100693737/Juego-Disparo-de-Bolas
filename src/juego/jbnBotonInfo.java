package juego;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public final class jbnBotonInfo {
	private JButton info;
	private final static Color COLOR_FONDO = new Color(141, 206, 255);
	public jbnBotonInfo() throws IOException {
		BufferedImage myPicture = ImageIO.read(new File("info.png"));
		setInfo(new JButton(new ImageIcon(myPicture)));
		getInfo().setBorder(null);
		getInfo().setBackground(COLOR_FONDO);
	}
	
	public JButton getInfo() {
		return info;
	}
	
	public void setInfo(JButton valor) {
		info = valor;
	}
}
