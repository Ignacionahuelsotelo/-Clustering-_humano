package visual;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import controlador.CambiadorDeVentanas;
import controlador.Controlador;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;

public class Main {

	private JFrame frame;
	private VentanaInicial ventanaInicial;
	private VentanaGrafo ventanaGrafo;
	private VentanaDeCarga ventanaDeCarga;
	private JPanel panelInicial;
	private JPanel panelCarga;
	private PanelGrafo panelGrafo;
	private JPanel panelEstadisticas;
	private Estadisticas ventanaEstadisticas;

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

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setTitle("Clustering");

		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

		frame.setVisible(true);

		panelInicial = new JPanel();
		
		panelCarga = new JPanel();
		
		panelGrafo = new PanelGrafo();
		
		panelEstadisticas = new JPanel();
		
		
		frame.getContentPane().add(panelInicial);
		frame.getContentPane().add(panelGrafo);
		frame.getContentPane().add(panelCarga);
		frame.getContentPane().add(panelEstadisticas);

		CambiadorDeVentanas cVent = new CambiadorDeVentanas(this);

		ventanaInicial = new VentanaInicial(panelInicial, cVent);

		ventanaDeCarga = new VentanaDeCarga(panelCarga, cVent);

		ventanaGrafo = new VentanaGrafo(panelGrafo, cVent);
		
		ventanaEstadisticas = new Estadisticas(panelEstadisticas, cVent); 

		cVent.cambiarAInicial();

		Controlador.cargarBase();
	}

	public void ocultarPaneles() {
		panelInicial.setVisible(false);
		panelInicial.setEnabled(false);
		panelCarga.setVisible(false);
		panelCarga.setEnabled(false);
		panelGrafo.setVisible(false);
		panelGrafo.setEnabled(false);
		panelEstadisticas.setVisible(false);
		panelEstadisticas.setEnabled(false);
	}

	public void cambiarAInicial() {
		ocultarPaneles();
		panelInicial.setEnabled(true);
		panelInicial.setVisible(true);

		Controlador.agregarLista(ventanaInicial.getPanelPersonas());

	}

	public void cambiarACarga() {
		ocultarPaneles();
		panelCarga.setEnabled(true);
		panelCarga.setVisible(true);
	}

	public void cambiarAGrafo() {
		ocultarPaneles();
		panelGrafo.setEnabled(true);
		panelGrafo.setVisible(true);
	}

	public void cambiarAEstadisticas() {
		ocultarPaneles();
		
		panelEstadisticas.setEnabled(true);
		panelEstadisticas.setVisible(true);
		ventanaEstadisticas.mostrarEstadisticasGrupo1();
	}

	public PanelGrafo getPanelGrafo() {
		return panelGrafo;
	}
		
	

}
