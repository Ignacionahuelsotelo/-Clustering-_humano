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
		frame.getContentPane().add(panelGrafo);	
		frame.getContentPane().add(panelCarga);
		
		CambiadorDeVentanas cVent = new CambiadorDeVentanas(this);
		
		
		ventanaInicial = new VentanaInicial(panelInicial,cVent);
		
		ventanaDeCarga = new VentanaDeCarga(panelCarga,cVent);
		
		ventanaGrafo = new VentanaGrafo(panelGrafo,cVent);

		
		
		cVent.cambiarAInicial();


	}
	
	public void cambiarFrame(JFrame newFrame) {
		this.frame = newFrame;
		frame.getContentPane().repaint();
	}
	
	
	public  void ocultarPaneles() {
		panelInicial.setVisible(false);
		panelCarga.setVisible(false);
		panelGrafo.setVisible(false);
	}
	
	
	public  void cambiarAInicial() {
		ocultarPaneles();
		panelInicial.setVisible(true);
	}
	
	public  void cambiarACarga() {
		ocultarPaneles();
		panelCarga.setVisible(true);
	}
	
	public  void cambiarAGrafo() {
		ocultarPaneles();
		panelGrafo.setVisible(true);
	}
	
}
