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
	private JPanel panelInicial;
	private JPanel panelCarga;
	private JPanel panelGrafo;

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
		
		panelInicial = new JPanel();
		panelCarga = new JPanel();
		panelGrafo = new JPanel();
		
		frame.getContentPane().add(panelInicial);
		frame.getContentPane().add(panelCarga);
		frame.getContentPane().add(panelGrafo);


		
		ventanaInicial = new VentanaInicial(panelInicial);
		
		ventanaDeCarga = new VentanaDeCarga(panelInicial);
		
		ventanaGrafo = new VentanaGrafo(panelInicial);
		
		
		CambiadorDeVentanas cVent = new CambiadorDeVentanas(panelInicial, panelGrafo, panelCarga);
		
		CambiadorDeVentanas.cambiarACarga();
		
	}
	
	public void cambiarFrame(JFrame newFrame) {
		this.frame = newFrame;
		frame.getContentPane().repaint();
	}
	
	
}
