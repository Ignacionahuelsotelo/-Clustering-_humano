package visual;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controlador.CambiadorDeVentanas;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class VentanaDeCarga extends ModeloVentana {

	private JPanel panelCarga;
	private CambiadorDeVentanas cVent;
	private javax.swing.JTextField textNombre;


	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VentanaDeCarga window = new VentanaDeCarga();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public VentanaDeCarga(JPanel p,CambiadorDeVentanas cVent) {
		this.panelCarga=p;
		this.cVent=cVent;
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		panelCarga.setBounds(0, 0, 1285, 750);
		panelCarga.setBorder(null);
		panelCarga.setLayout(null);
		panelCarga.setBackground(new java.awt.Color(250,250,210));
		
		
		//Crea los JLABEL
		createJLabel(panelCarga, "DATOS E INTERESES" , new java.awt.Color(105, 105, 105) ,new Font("Showcard Gothic", java.awt.Font.PLAIN, 28),391, 11, 300,126 );
		
		createJLabel(panelCarga, "NOMBRE: " , new java.awt.Color(105, 105, 105) ,new Font("Sitka Banner", java.awt.Font.PLAIN, 16), 28, 147, 300,126 );
		textNombre = createTextField(panelCarga,new Color(240, 230, 140), 230, 198, 114, 20);  
		
		createJLabel(panelCarga, "ARTE:" , new java.awt.Color(105, 105, 105) ,new Font("Sitka Banner", java.awt.Font.PLAIN, 16), 28, 198, 300,126 );
		createJLabel(panelCarga, "MUSICA:" , new java.awt.Color(105, 105, 105) ,new Font("Sitka Banner", java.awt.Font.PLAIN, 16),  28, 249, 300,126 );
		createJLabel(panelCarga, "DEPORTE:" , new java.awt.Color(105, 105, 105) ,new Font("Sitka Banner", java.awt.Font.PLAIN, 16),  28, 300, 300,126 );
		createJLabel(panelCarga, "ESPECTACULO:" , new java.awt.Color(105, 105, 105) ,new Font("Sitka Banner", java.awt.Font.PLAIN, 16),  28, 351, 300,126 );
		createJLabel(panelCarga, "CIENCIA:" , new java.awt.Color(105, 105, 105) ,new Font("Sitka Banner", java.awt.Font.PLAIN, 16),  28, 402, 300,126 );
		
		
		//Crea los comboBox
		crearComboBox(panelCarga,230, 249);
		crearComboBox(panelCarga,230, 299);
		crearComboBox(panelCarga,230, 349);
		crearComboBox(panelCarga,230, 399);
		crearComboBox(panelCarga,230, 449);
		
//		//Para obtener la opcion seleccionada
//		int indice = comboBox.getSelectedIndex();
//		System.out.println("El indice seleccionado es" + indice);
		
		
		//Crea los botones
		Color foreGround = new java.awt.Color(51,51,51);
		Font buttonFont = new Font("Sitka Banner", java.awt.Font.PLAIN, 15);
		Color background = new Color(240, 230, 140);
		createButton(panelCarga, "Elegir foto", foreGround, buttonFont,background, 755, 182,189, 40);
		JButton volver = createButton(panelCarga, "Volver al menu principal", foreGround, buttonFont,background, 720, 617,189, 40);
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cVent.cambiarAInicial();
			}
		});
	
		panelCarga.setVisible(false);
	}
	
	protected void makeFrameFullSize(JFrame aFrame) {
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    aFrame.setSize(screenSize.width, screenSize.height);
	}
	
}
