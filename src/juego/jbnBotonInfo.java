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
	
	public jbnBotonInfo() throws IOException {
		BufferedImage myPicture = ImageIO.read(new File("info.png"));
		setInfo(new JButton(new ImageIcon(myPicture)));
		getInfo().setBackground(Color.WHITE);
		getInfo().setBorder(null);
	}
	
	public JButton getInfo() {
		return info;
	}
	
	public void setInfo(JButton valor) {
		info = valor;
	}
}
