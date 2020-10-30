package visual;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class VentanaDeCarga {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDeCarga window = new VentanaDeCarga();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaDeCarga() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		makeFrameFullSize (frame);
		
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setLayout(null);
		
		JPanel panelCarga = new JPanel();
		panelCarga.setBounds(0, 0, 1285, 750);
		panelCarga.setBorder(null);
		panelCarga.setLayout(null);
		
		frame.getContentPane().add(panelCarga);
		
		JLabel lblNewLabel = new JLabel("CARGAR DATOS");
		lblNewLabel.setBounds(391, 11, 395, 77);
		panelCarga.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NOMBRE :");
		lblNewLabel_1.setBounds(28, 147, 162, 40);
		panelCarga.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("ARTE:");
		lblNewLabel_1_1.setBounds(28, 198, 162, 40);
		panelCarga.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("MUSICA:");
		lblNewLabel_1_2.setBounds(28, 269, 162, 40);
		panelCarga.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("DEPORTE :");
		lblNewLabel_1_3.setBounds(28, 343, 162, 40);
		panelCarga.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("ESPECTACULO:");
		lblNewLabel_1_4.setBounds(28, 435, 162, 40);
		panelCarga.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("CIENCIA :");
		lblNewLabel_1_5.setBounds(28, 542, 162, 40);
		panelCarga.add(lblNewLabel_1_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(308, 208, 28, 20);
		panelCarga.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(308, 289, 28, 20);
		panelCarga.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(308, 353, 28, 20);
		panelCarga.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(308, 445, 28, 20);
		panelCarga.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(308, 552, 28, 20);
		panelCarga.add(comboBox_4);
		
		JLabel lblNewLabel_2 = new JLabel("CARGAR FOTO :");
		lblNewLabel_2.setBounds(515, 173, 126, 40);
		panelCarga.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Elegi foto");
		btnNewButton.setBounds(755, 182, 89, 23);
		panelCarga.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("GUARDAR ");
		btnNewButton_1.setBounds(564, 617, 89, 23);
		panelCarga.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Volver al menu principal");
		btnNewButton_1_1.setBounds(720, 617, 145, 23);
		panelCarga.add(btnNewButton_1_1);
		
		
	}
	
	protected void makeFrameFullSize(JFrame aFrame) {
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    aFrame.setSize(screenSize.width, screenSize.height);
	}
}
