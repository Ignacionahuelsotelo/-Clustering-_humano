package visual;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import controlador.Controlador;

public class PanelGrafo extends JPanel {

//	private static final long serialVersionUID = 1L;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Controlador.graficarGrupos(g);

		this.setBackground(Color.ORANGE);
	}
	
	
	
	
	
}
