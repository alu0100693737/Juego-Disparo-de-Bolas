package juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class pnlFlecha  extends JLabel {

	double phi;
	int barb;

	public pnlFlecha() {
		phi = Math.toRadians(20);
		barb = 20;
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		int w = getWidth();
		int h = getHeight();
		Point sw = new Point(getWidth(), getHeight()/2);
		Point ne = new Point(w*7/8, h/8);
		g2.draw(new Line2D.Double(sw, ne));
		//drawArrowHead(g2, sw, ne, Color.red);
		
	}

	
}
