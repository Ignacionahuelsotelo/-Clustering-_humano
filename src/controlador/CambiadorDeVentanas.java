package controlador;

import javax.swing.JFrame;
import javax.swing.JPanel;

import visual.Main;
import visual.PanelGrafo;

public class CambiadorDeVentanas {
	
	private static Main m;
	
	public CambiadorDeVentanas(Main m) {
	
		CambiadorDeVentanas.m = m;
	}
	
	
	
	public  void cambiarAInicial() {
		m.cambiarAInicial();
	}
	
	public  void cambiarACarga() {
		m.cambiarACarga();
	}
	
	public  void cambiarAGrafo() {
		m.cambiarAGrafo();
	}



	public void cambiarAEstadisticas() {
		m.cambiarAEstadisticas();
		
	}
	
	public static PanelGrafo getPanelGrafo() {
		return m.getPanelGrafo();
	}
}
