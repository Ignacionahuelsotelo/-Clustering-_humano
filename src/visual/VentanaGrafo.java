package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.CambiadorDeVentanas;

public class VentanaGrafo extends ModeloVentana{

	private PanelGrafo panelGrafo;
	private CambiadorDeVentanas cVent;


	/**
	 * Create the frame.
	 */
	public VentanaGrafo(PanelGrafo p, CambiadorDeVentanas cVent) {
		this.panelGrafo=p;
		this.cVent=cVent;
		initialize();
	}

	
	public void initialize() {		
		panelGrafo.setBounds(0, 0, 1285, 750);
		panelGrafo.setBorder(null);
		panelGrafo.setLayout(null);
		
		
		Font fuente = new Font("Showcard Gothic", java.awt.Font.PLAIN, 38); // para cambiar el tama�o de la letra es mejor hacerlo en la fuente !!
		createJLabel(panelGrafo, "Hola", Color.RED, fuente, 95, 81, 89, 27);
		
		panelGrafo.setVisible(false);
		 
	}
//	
//	
//	@Override
//	public void paint(Graphics g) {
//		super.paint(g);
//	    Grafico.agregarCirculo(150, 50, g);
//		
//	    
//        Grafico.agregarLinea(10, 10, 200, 300, g);
//     
//	}
	
//	protected void makeFrameFullSize(JFrame aFrame) {
//	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//	    aFrame.setSize(screenSize.width, screenSize.height);
//	}
	

}
