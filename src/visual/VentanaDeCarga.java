package visual;

import java.awt.Dimension;
import java.awt.EventQueue;
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

public class VentanaDeCarga {

	private JPanel panelCarga;
	private CambiadorDeVentanas cVent;


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
		
		
		//Crea los JLABEL
		crearJLabel(panelCarga, "CARGAR DATOS", 391, 11 );
		crearJLabel(panelCarga, "NOMBRE :", 28, 147);
		crearJLabel(panelCarga, "ARTE", 28, 198 );
		crearJLabel(panelCarga, "MUSICA", 28, 269 );
		crearJLabel(panelCarga, "DEPORTE", 28, 343 );
		crearJLabel(panelCarga, "ESPECT�CULO", 28, 435 );
		crearJLabel(panelCarga, "CIENCIA",28, 542 );
	
		
		//Crea los comboBox
		crearComboBox(panelCarga,230, 208);
		crearComboBox(panelCarga,230, 289);
		crearComboBox(panelCarga,230, 353);
		crearComboBox(panelCarga,230, 445);
		crearComboBox(panelCarga,230, 552);
		
		
//		//Para obtener la opci�n seleccionada
//		int indice = comboBox.getSelectedIndex();
//		System.out.println("El indice seleccionado es" + indice);
		
		
		//Crea los botones
		
		crearBotones(panelCarga, "Elegir foto" , 755, 182);
		crearBotones(panelCarga, "GUARDAR" , 564, 617);
		JButton volver = crearBotones(panelCarga, "Volver al menu principal" , 720, 617);
		
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cVent.cambiarAInicial();
			}
		});
	
		panelCarga.setVisible(false);
	}

	private JButton crearBotones(JPanel panelCarga, String texto, int x, int y) {
		JButton btnNewButton = new JButton(texto);
		btnNewButton.setBounds(x, y, 89, 23);
		panelCarga.add(btnNewButton);
		return btnNewButton;
	}

	private void crearJLabel(JPanel panelCarga, String texto, int x , int y) {
		JLabel lblNewLabel_2 = new JLabel(texto);
		lblNewLabel_2.setBounds(x,y ,126, 40);
		panelCarga.add(lblNewLabel_2);
	}

	private void crearComboBox(JPanel panelCarga, int x, int y) {
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(x,y, 114, 20);
		comboBox.setModel(new DefaultComboBoxModel (new String [] { "Seleccione indice" , "1", "2", "3", "4", "5"}));
		panelCarga.add(comboBox);
	}
	
	protected void makeFrameFullSize(JFrame aFrame) {
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    aFrame.setSize(screenSize.width, screenSize.height);
	}
	
}
