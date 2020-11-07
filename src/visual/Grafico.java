package visual;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logica.Punto;

public class Grafico {
	/**
	 * 
	 */

	public static void agregarCirculo(int x1, int y1, Graphics g) {
		g.setColor(Color.BLUE);
		g.fillOval(x1, y1, 40, 40);

	}

	public static void agregarLinea(int x1, int y1, int x2, int y2, Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine(x1, y1, x2, y2);

	}

	public static void unirNodos(int x1, int x2, int y1, int y2, Graphics g) {
		agregarCirculo(x1, y1, g);
		agregarCirculo(x2, y2, g);
		agregarLinea(x1, x2, y1, y2, g);

	}
	
	public static JLabel graficarImagen(String url, Punto p, PanelGrafo panel, Graphics g) {
		JLabel pan = new JLabel();
		pan.setBounds(p.getX(), p.getY(), 40, 40);
		//panel.add(pan);
		

		Image img = new ImageIcon(url).getImage();
		img=img.getScaledInstance(40, 40, Image.SCALE_DEFAULT);
		ImageIcon icon = new ImageIcon(
				img.getScaledInstance(40, 40, Image.SCALE_DEFAULT));

		
		pan.setIcon(icon);
		
		return pan;
	}
}