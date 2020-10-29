package visual;

import java.awt.EventQueue;
import java.awt.Font;
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

public class VentanaInicial extends ModeloVentana  {

	private JFrame frame;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public VentanaInicial() {
	
		//this.frame=frame;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame= new JFrame();
		makeFrameFullSize(frame);
		//frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JPanel panelTitulo = new JPanel();
//		FlowLayout flowLayout = (FlowLayout) panelTitulo.getLayout();
//		flowLayout.setAlignment(FlowLayout.CENTER);
		panelTitulo.setBounds(10, 500, 100, 100);
		frame.getContentPane().add(panelTitulo);

	
		
		Font fuenteTitulo = new Font("Showcard Gothic", java.awt.Font.PLAIN, 38);
		
		createJLabel(panelTitulo, "Clustering Humano", Color.BLACK, fuenteTitulo, 73, 140, 290, 50);
		frame.getContentPane().add(panelTitulo, BorderLayout.NORTH);
		
		JPanel panelSur = new JPanel();
		frame.getContentPane().add(panelSur, BorderLayout.SOUTH);

		 
		Color foreGround = new Color(255, 99, 71);
		Font buttonFont = new Font("Showcard Gothic", java.awt.Font.PLAIN, 16);
		Color background = new Color(240, 230, 140);
		createButton(panelSur, "Cargar", foreGround, buttonFont, background,158, 500,
				500, 48);
	
		frame.setVisible(true);
		
		
	}
	
	protected void makeFrameFullSize(JFrame aFrame) {
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    aFrame.setSize(screenSize.width, screenSize.height);
	}
	
	
	
}
