package visual;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelGrafo extends JPanel {

//	private static final long serialVersionUID = 1L;

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		// x,y,tama�o alto y ancho
		g.fillOval(150, 50, 40, 40);
		g.setColor(Color.RED);
		g.drawLine(10, 10, 200, 300);

		this.setBackground(Color.ORANGE);
	}
}
