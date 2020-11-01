package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import controlador.CambiadorDeVentanas;

import javax.swing.JScrollBar;
import javax.swing.JPanel;

public class Main {

	private JFrame frame;
	private VentanaInicial ventanaInicial;
	private VentanaGrafo ventanaGrafo;
	private VentanaDeCarga ventanaDeCarga;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		//frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setTitle("Main");
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	 
		frame.setVisible(true);
		
		
		ventanaInicial = new VentanaInicial();
		
		ventanaDeCarga = new VentanaDeCarga();
		
		
		ventanaGrafo = new VentanaGrafo();
		
		
		CambiadorDeVentanas cVent = new CambiadorDeVentanas(this, ventanaInicial, ventanaGrafo, ventanaDeCarga);
		
		//CambiadorDeVentanas.cambiarAVentanaInicial();
		
		cambiarFrame(ventanaGrafo.getFrame());
		
		
	}
	
	public void cambiarFrame(JFrame newFrame) {
		this.frame = newFrame;
		frame.getContentPane().repaint();
	}
	
	public JFrame getFrame(){
		return frame;
	}
}
