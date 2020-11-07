package visual;

import java.awt.Graphics;

import javax.swing.JPanel;

import controlador.Controlador;

public class PanelGrafo extends JPanel {


	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Controlador.graficarGrupos(g);
		

	}
	
	
	
}
