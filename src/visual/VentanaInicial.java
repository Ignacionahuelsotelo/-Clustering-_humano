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
import controlador.Controlador;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class VentanaInicial extends ModeloVentana  {

	
	private JPanel panelInicial;
	private CambiadorDeVentanas cVent;
	private JPanel panelPersonasCargadas;

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
		panelInicial.setBackground(new java.awt.Color(250,250,210));
		
		
		
		Font fuente = new Font("Showcard Gothic", java.awt.Font.PLAIN, 38); // para cambiar el tama�o de la letra es mejor hacerlo en la fuente !!
		JLabel titulo = createJLabel(panelInicial, "Clustering Humano", new java.awt.Color(105, 105, 105), fuente, 95, 81, 89, 27);
		titulo.setBounds(454,30,401,94);
		Font fuenteSubTitulo = new Font("Showcard Gothic", java.awt.Font.PLAIN, 25);
		JLabel subTitulo = createJLabel(panelInicial, "Nombres de Usuarios : ",new java.awt.Color(105, 105, 105), fuenteSubTitulo, 43,-140, 328, 521);
		
		Color foreGround = new java.awt.Color(51,51,51);
		Font buttonFont = new Font("Sitka Banner", java.awt.Font.PLAIN, 15);
		Color background = new Color(240, 230, 140);
		JButton btnNewButton = createButton(panelInicial, "Cargar datos", foreGround, buttonFont,background, 438, 366, 138, 67);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cVent.cambiarACarga();
				
			}
		});
		
		JButton btnClustering = createButton(panelInicial, "MATCH", foreGround, buttonFont,background, 688, 366, 138, 67);
		btnClustering.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cVent.cambiarAGrafo();
			}
		});
		
			panelPersonasCargadas = new JPanel();
			panelPersonasCargadas.setBounds(43, 148, 328, 521);
			panelInicial.add(panelPersonasCargadas);
			panelPersonasCargadas.setLayout(null);
			
			
			
			Controlador.agregarLista(panelPersonasCargadas);
		
//			panelPersonasCargadas.add(crearLista());
			
		
//			agregarLista(panelPersonasCargadas);
	
		
		
	}
	
	protected void makeFrameFullSize(JFrame aFrame) {
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    aFrame.setSize(screenSize.width, screenSize.height);
	}
	
	
	public JPanel getPanel() {
		return this.panelInicial;
	}
	
	public JPanel getPanelPersonas () {
		return panelPersonasCargadas;
	}
//	public DefaultListModel<String> recorrerDatosPersonas (ArrayList<String> datos) {
//		DefaultListModel<String> listModel = new DefaultListModel<>();
//		for (int i = 0 ; i < datos.size(); i++) {
//			listModel.addElement(datos.get(i));
//		}
//		return listModel;
//		
//	}
//	
//	public JList crearLista () {
//		Font fuenteLista = new Font("Showcard Gothic", java.awt.Font.PLAIN, 20);
//		JList list = new JList<>(recorrerDatosPersonas(Controlador.getDatosPersonas()));
//		list.setBounds(0, 0, 328, 521);
//		
//		list.setFont(fuenteLista);
//		
//		return list;
//	}
//	
//	public void agregarLista (JPanel panel) {
//		JList list = crearLista();
//		panel.removeAll();
//		panel.add(list);
//		
//		
//	}
}
