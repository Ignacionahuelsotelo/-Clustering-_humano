package visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controlador.CambiadorDeVentanas;

public class VentanaGrafo extends ModeloVentana {

	private PanelGrafo panelGrafo;
	private CambiadorDeVentanas cVent;

	/**
	 * Create the frame.
	 */
	public VentanaGrafo(PanelGrafo p, CambiadorDeVentanas cVent) {
		this.panelGrafo = p;
		this.cVent = cVent;
		initialize();
	}

	public void initialize() {
		panelGrafo.setBounds(0, 0, 1400, 750);
		panelGrafo.setBorder(null);
		panelGrafo.setLayout(null);
		panelGrafo.setBackground(new java.awt.Color(250, 250, 210));

		Font fuente = fuenteGothic(38); // para cambiar el tamanioo de la letra es
										// mejor hacerlo en la fuente !!
		
		
		createJLabel(panelGrafo, "Grupos Formados : ", getColor(105, 105, 105), fuente, 454, 30, 401, 94);

		panelGrafo.setVisible(false);

		
		JButton volverAlInicio = createButton(panelGrafo, "Volver", 100, 600, 138,
				67);
		volverAlInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cVent.cambiarAInicial();

			}
		});
		
		JButton estadisticas = createButton(panelGrafo, "Ver estadisticas", 700, 600, 150,
				67);
		estadisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cVent.cambiarAEstadisticas();

			}
		});
	}

}
