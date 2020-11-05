package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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
		panelGrafo.setBounds(0, 0, 1400, 750);
		panelGrafo.setBorder(null);
		panelGrafo.setLayout(null);
		panelGrafo.setBackground(new java.awt.Color(250,250,210));
		
		
		Font fuente = new Font("Showcard Gothic", java.awt.Font.PLAIN, 38); // para cambiar el tama�o de la letra es mejor hacerlo en la fuente !!
		createJLabel(panelGrafo, "Grupos Formados : ", new java.awt.Color(105, 105, 105), fuente, 454,30,401,94);
		
		
		panelGrafo.setVisible(false);
		
		Color foreGround = new java.awt.Color(51,51,51);
		Font buttonFont = new Font("Sitka Banner", java.awt.Font.PLAIN, 15);
		Color background = new Color(240, 230, 140);
		JButton volverAlInicio = createButton(panelGrafo, "Volver", foreGround, buttonFont,background, 600, 600, 138, 67);
		volverAlInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cVent.cambiarAInicial();
				
			}
		}); 
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
