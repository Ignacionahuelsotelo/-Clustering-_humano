package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import controlador.CambiadorDeVentanas;
import controlador.Controlador;

import javax.swing.JScrollBar;
import javax.swing.JPanel;
import java.awt.Color;

public class Main {

	private JFrame frame;
	private VentanaInicial ventanaInicial;
	private VentanaGrafo ventanaGrafo;
	private VentanaDeCarga ventanaDeCarga;
	private JPanel panelInicial;
	private JPanel panelCarga;
	private PanelGrafo panelGrafo;

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
		
		frame.setTitle("Clustering");
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	 
		frame.setVisible(true);
		
		panelInicial = new JPanel();
		panelInicial.setBackground(new Color(250, 250, 210));
		panelCarga = new JPanel();
		panelCarga.setBackground(new Color(51, 51, 51));
		panelGrafo = new PanelGrafo();
		
		frame.getContentPane().add(panelInicial);
		frame.getContentPane().add(panelGrafo);	
		frame.getContentPane().add(panelCarga);
		
		CambiadorDeVentanas cVent = new CambiadorDeVentanas(this);
		
		
		ventanaInicial = new VentanaInicial(panelInicial,cVent);
		
		ventanaDeCarga = new VentanaDeCarga(panelCarga,cVent);
		
		ventanaGrafo = new VentanaGrafo(panelGrafo,cVent);

		
		
		cVent.cambiarAInicial();


	}
	
	
	public  void ocultarPaneles() {
		panelInicial.setVisible(false);
		panelInicial.setEnabled(false);
		panelCarga.setVisible(false);
		panelCarga.setEnabled(false);
		panelGrafo.setVisible(false);
		panelGrafo.setEnabled(false);
	}
	
	
	public  void cambiarAInicial() {
		ocultarPaneles();
		panelInicial.setEnabled(true);
		panelInicial.setVisible(true);
		
		Controlador.agregarLista(ventanaInicial.getPanelPersonas());
		
	}
	
	public  void cambiarACarga() {
		ocultarPaneles();
		panelCarga.setEnabled(true);
		panelCarga.setVisible(true);
	}
	
	public  void cambiarAGrafo() {
		ocultarPaneles();
		panelGrafo.setEnabled(true);
		panelGrafo.setVisible(true);
	}
	
}
