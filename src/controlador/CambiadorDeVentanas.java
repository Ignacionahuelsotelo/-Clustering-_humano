package controlador;

import javax.swing.JFrame;

import visual.Main;
import visual.VentanaInicial;
import visual.VentanaDeCarga;
import visual.VentanaGrafo;

public class CambiadorDeVentanas {
	
	private static Main main;
	private static VentanaInicial vInicial;
	private static VentanaGrafo vGrafo;
	private static VentanaDeCarga vCarga;
	
	public CambiadorDeVentanas(Main m,VentanaInicial vI, VentanaGrafo vG, VentanaDeCarga vC) {
		main = m;
		vInicial = vI;
		vGrafo = vG;
		vCarga = vC;
	}
	
	public static void  cambiarAVentanaInicial() {
		main.cambiarFrame(vInicial.getFrame());
	}
	
	public static void  cambiarAVentanaDeCarga() {
		System.out.println("Cambioa ventana de carga");
		System.out.println("Titulo inicial: "+ main.getFrame().getTitle());
		System.out.println("Titulo a usar: "+ vCarga.getFrame().getTitle());
		main.cambiarFrame(vCarga.getFrame());
		System.out.println("Titulo inicial: "+ main.getFrame().getTitle());
	}
	
	public static void  cambiarAVentanaGrafo() {
		System.out.println("Cambio ventana de grafo");
		main.cambiarFrame(vGrafo.getFrame());
	}
}
