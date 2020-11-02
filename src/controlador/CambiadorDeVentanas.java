package controlador;

import javax.swing.JFrame;
import javax.swing.JPanel;

import visual.Main;
import visual.VentanaInicial;
import visual.VentanaDeCarga;
import visual.VentanaGrafo;

public class CambiadorDeVentanas {
	
	private static JPanel panelInicial;
	private static JPanel panelCarga;
	private static JPanel panelGrafo;
	
	public CambiadorDeVentanas(JPanel vI, JPanel vG, JPanel vC) {
	
		panelInicial = vI;
		panelGrafo = vG;
		panelCarga = vC;
	}
	
	public static void ocultarPaneles() {
		panelInicial.setVisible(false);
		panelCarga.setVisible(false);
		panelGrafo.setVisible(false);
	}
	
	
	public static void cambiarAInicial() {
		ocultarPaneles();
		panelInicial.setVisible(true);
	}
	
	public static void cambiarACarga() {
		ocultarPaneles();
		panelCarga.setVisible(true);
	}
	
	public static void cambiarAGrafo() {
		ocultarPaneles();
		panelGrafo.setVisible(true);
	}
}
