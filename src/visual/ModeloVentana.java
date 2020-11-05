package visual;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;



public class ModeloVentana{
	
	protected JLabel createJLabel(JPanel panel, String texto, Color color, Font fuente, int posX, int posY, int ancho,
			int alto) {
		JLabel titulo = new JLabel(texto);
		titulo.setForeground(color);
		titulo.setFont(fuente);
		titulo.setBounds(posX, posY, ancho, alto);
		panel.add(titulo);
		return titulo;
	}

	protected void alignJLabel(JLabel label) {
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		label.setHorizontalAlignment(SwingConstants.CENTER);
	}

	protected JTextField createTextField(JPanel panel, Color color, int posX, int posY, int ancho, int alto) {
		JTextField textJugador = new JTextField();
		textJugador.setBackground(color);
		textJugador.setBounds(posX, posY, ancho, alto);
		panel.add(textJugador);
		return textJugador;
	}

	protected JButton createButton(JPanel panel, String text, Color foreGround, Font font, Color background, int posX,
			int posY, int ancho, int alto) {
		JButton boton = new JButton(text);
		if (foreGround != null)
			boton.setForeground(foreGround);
		if (font != null)
			boton.setFont(font);
		if (background != null)
			boton.setBackground(background);
		boton.setBounds(posX, posY, ancho, alto);
		panel.add(boton);
		return boton;
	}
	
	protected void makeFrameFullSize(JFrame aFrame) {
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    aFrame.setSize(screenSize.width, screenSize.height);
	}
	
	protected JComboBox crearComboBox(JPanel panelCarga, int x, int y) {
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(x,y, 140, 20);
		comboBox.setModel(new DefaultComboBoxModel (new String [] { "Seleccione interes" , "1", "2", "3", "4", "5"}));
		panelCarga.add(comboBox);
		return comboBox;
		
	}
	
//	public JLabel crearBotonImagen(JPanel panel ,Juego juego,int posBX, int posBY, int anchoB, int altoB, int posIX, int posIY, int anchoI, int altoI) {
//		JLabel foto = new JLabel("");
//		foto.setBounds(posIX, posIY, anchoI, altoI);
//		foto.setBorder(new LineBorder(new Color(240, 230, 140), 2));
//		panel.add(foto);
//		JButton boton = createButton(panel, "Elegir foto", null, null, null, posBX, posBY, anchoB, altoB);
//		
//		boton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				JFileChooser fc = new JFileChooser();
//				fc.setDialogTitle("Buscar foto");
//
//				if (fc.showOpenDialog(panel) == JFileChooser.APPROVE_OPTION) {
//
//					Image img = new ImageIcon(fc.getSelectedFile().toString()).getImage();
//					ImageIcon icon = new ImageIcon(img.getScaledInstance(78, 124, Image.SCALE_SMOOTH));
//					juego.setImagenJugador(icon);
//					foto.setIcon(icon);
//
//				}
//			}
//		});
//		return foto;
//		
//	}
}
