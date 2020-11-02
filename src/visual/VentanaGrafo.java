package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.CambiadorDeVentanas;

public class VentanaGrafo extends ModeloVentana {

	private JPanel panelGrafo;
	private CambiadorDeVentanas cVent;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VentanaGrafo frame = new VentanaGrafo();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public VentanaGrafo(JPanel p, CambiadorDeVentanas cVent) {
		this.panelGrafo=p;
		this.cVent=cVent;
		initialize();
	}

	
	public void initialize() {		
		panelGrafo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelGrafo);
		panelGrafo.setLayout(null);
	}
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	    Grafico.agregarCirculo(150, 50, g);
		
	    
        Grafico.agregarLinea(10, 10, 200, 300, g);
     
	}
	
	protected void makeFrameFullSize(JFrame aFrame) {
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    aFrame.setSize(screenSize.width, screenSize.height);
	}
	
	public JFrame getFrame() {
		return this;
	}
}
