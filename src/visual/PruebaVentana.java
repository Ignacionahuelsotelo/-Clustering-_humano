package visual;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Rectangle;

public class PruebaVentana {

	private JFrame frame;
	private JPanel cosa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PruebaVentana window = new PruebaVentana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PruebaVentana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		makeFrameFullSize (frame);
		
		cosa = new JPanel();
		Font fuente = new Font("Showcard Gothic", java.awt.Font.PLAIN, 38);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		createJLabel(cosa, "Hola mundo", Color.BLUE, fuente, 95, 81, 89, 27);

		frame.getContentPane().add(cosa);
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		 
		frame.setVisible(true);
	}
	
	private void makeFrameFullSize(JFrame aFrame) {
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    aFrame.setSize(screenSize.width, screenSize.height);
	}
	
	public JLabel createJLabel(JPanel panel, String texto, Color color, Font fuente, int posX, int posY, int ancho,
			int alto) {
		cosa.setLayout(null);
		JLabel titulo = new JLabel(texto);
		titulo.setForeground(color);
		titulo.setFont(fuente);
		titulo.setBounds(327, 188, 244, 48);
		panel.add(titulo);
		return titulo;
	}
}
