package visual;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.SwingConstants;

import controlador.CambiadorDeVentanas;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class VentanaInicial  {

	
	private JPanel panelInicial;
	private CambiadorDeVentanas cVent;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public VentanaInicial(JPanel p, CambiadorDeVentanas cVent) {
		this.panelInicial=p;
		this.cVent=cVent;
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		panelInicial.setBounds(0, 0, 1285, 750);
		panelInicial.setBorder(null);
		panelInicial.setLayout(null);
		
		Font fuente = new Font("Showcard Gothic", java.awt.Font.PLAIN, 38); // para cambiar el tama�o de la letra es mejor hacerlo en la fuente !!
		createJLabel(panelInicial, "Clustering Humano", Color.RED, fuente, 95, 81, 89, 27);
		 
		

		
		JButton btnNewButton = new JButton("Cargar Datos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cVent.cambiarACarga();
				
			}
		});
		
		
		btnNewButton.setBounds(438, 366, 138, 67);
		panelInicial.add(btnNewButton);
		
		JButton btnClustering = new JButton("MATCH");
		btnClustering.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cVent.cambiarAGrafo();

				//panelInicial.setVisible(false);
			}
		});
		
		btnClustering.setBounds(688, 366, 138, 67);
		panelInicial.add(btnClustering);
		
			JPanel panelPersonasCargadas = new JPanel();
			panelPersonasCargadas.setBounds(43, 148, 328, 521);
			panelInicial.add(panelPersonasCargadas);
			
		
		
	
		
		
	}
	
	protected void makeFrameFullSize(JFrame aFrame) {
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    aFrame.setSize(screenSize.width, screenSize.height);
	}
	
	public JLabel createJLabel(JPanel panel, String texto, Color color, Font fuente, int posX, int posY, int ancho,
			int alto) {
		JLabel titulo = new JLabel(texto);
		titulo.setForeground(color);
		titulo.setFont(fuente);
		titulo.setBounds(454, 30, 401, 94);
		panel.add(titulo);

		return titulo;
	}
	
	public JPanel getPanel() {
		return this.panelInicial;
	}
}
