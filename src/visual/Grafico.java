package visual;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

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
	
	public static void graficarImagen(String url, Punto p, Graphics g) {
		BufferedImage img;
        try {
                img = ImageIO.read(new File(url));
                g.drawImage(img, p.getX(), p.getY(), 40, 40, null);
        } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
	}
}