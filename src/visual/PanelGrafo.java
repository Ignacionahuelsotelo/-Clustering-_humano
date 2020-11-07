package visual;

import java.awt.Graphics;

import javax.swing.JPanel;

import controlador.Controlador;
import logica.Punto;

public class PanelGrafo extends JPanel {

//	private static final long serialVersionUID = 1L;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Controlador.graficarGrupos(g);
		
		System.out.println("Se coorre paint");
		// this.setBackground(Color.ORANGE);
	}
	
	
	
}
