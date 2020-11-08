package visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.CambiadorDeVentanas;
import controlador.Controlador;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class VentanaDeCarga extends ModeloVentana {

	private JPanel panelCarga;
	private CambiadorDeVentanas cVent;
	private javax.swing.JTextField textNombre;
	private ArrayList<JComboBox> combos;
	private static String foto;
	private JLabel fotoLabel;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public VentanaDeCarga(JPanel p, CambiadorDeVentanas cVent) {
		this.panelCarga = p;
		this.cVent = cVent;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		panelCarga.setBounds(0, 0, 1385, 750);
		panelCarga.setBorder(null);
		panelCarga.setLayout(null);
		panelCarga.setBackground(new java.awt.Color(250, 250, 210));

		Color colorLabel = getColor(105, 105, 105);
		Font fuenteLabel = fuenteSitka(16);

		// Crea los JLABEL
		createJLabel(panelCarga, "DATOS E INTERESES", colorLabel, fuenteLabel, 391, 11, 300,
				126);

		createJLabel(panelCarga, "NOMBRE: ", colorLabel, fuenteLabel, 28, 147, 300, 126);
		textNombre = createTextField(panelCarga, new Color(240, 230, 140), 230, 198, 140, 20);

		createJLabel(panelCarga, "ARTE:", colorLabel, fuenteLabel, 28, 198, 300, 126);
		createJLabel(panelCarga, "MUSICA:", colorLabel, fuenteLabel, 28, 249, 300, 126);
		createJLabel(panelCarga, "DEPORTE:", colorLabel, fuenteLabel, 28, 300, 300, 126);
		createJLabel(panelCarga, "ESPECTACULO:", colorLabel, fuenteLabel, 28, 351, 300, 126);
		createJLabel(panelCarga, "CIENCIA:", colorLabel, fuenteLabel, 28, 402, 300, 126);

		combos = crearComboBoxes();

		fotoLabel = crearBotonImagen(panelCarga, 755, 182, 189, 40, 755, 250, 350, 350);

		JButton volver = createButton(panelCarga, "Volver al menu principal", 720, 617, 189, 40);
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cVent.cambiarAInicial();
				borrarComboBox();
				borrarFoto();
				borrarNombres();
			}
		});

		JButton guardar = createButton(panelCarga, "Guardar", 200, 617, 189, 40);
		guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				guardarDatos(combos);
				cVent.cambiarAInicial();
				borrarNombres();
				borrarComboBox();
				borrarFoto();

			}
		});

		panelCarga.setVisible(false);
	}

	public ArrayList<JComboBox> crearComboBoxes() {
		int y = 249;
		ArrayList<JComboBox> combos = new ArrayList<JComboBox>();
		for (int i = 0; i < 5; i++) {
			combos.add(crearComboBox(panelCarga, 230, y));
			y = y + 50;
		}
		return combos;
	}

	public boolean sePuedeAgregar(ArrayList<JComboBox> combos) {
		for (int i = 0; i < 5; i++) {
			if (combos.get(i).getSelectedIndex() < 1) {
				return false;
			}

		}
		return true;
	}

	public void guardarDatos(ArrayList<JComboBox> combos) {
		if (sePuedeAgregar(combos)) {
			Controlador.agregarPersona(textNombre.getText(), combos.get(1).getSelectedIndex(),
					combos.get(2).getSelectedIndex(), combos.get(3).getSelectedIndex(),
					combos.get(4).getSelectedIndex(), combos.get(0).getSelectedIndex(), foto);
			Controlador.guardarPersona();
		}

	}

	public void borrarNombres() {
		textNombre.setText("");

	}

	public void borrarComboBox() {
		for (JComboBox c : combos) {

			c.setSelectedIndex(0);

		}
	}

	public static void setFoto(String nuevaFoto) {
		VentanaDeCarga.foto = nuevaFoto;
	}

	public void borrarFoto() {
		VentanaDeCarga.foto = null;
		fotoLabel.setIcon(null);
	}
}
