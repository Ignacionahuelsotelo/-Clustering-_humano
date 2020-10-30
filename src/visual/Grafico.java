package visual;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Grafico extends JPanel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paint(Graphics g){
		g.setColor(Color.BLUE);
		//x,y,tamaño alto y ancho
        g.fillOval(150, 50, 40, 40);  
        g.setColor(Color.RED);
        g.drawLine(10, 10, 200, 300);            
    
    }

    public void agregarGrafico (JFrame frame) {
    	frame.getContentPane().add(new Grafico());
	      frame.setSize(300, 300);
	      frame.setVisible(true);
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.setResizable(false);     
    }
//    public static void main(String[] args){
//        JFrame frame= new JFrame("Ejemplo de Líneas");    
//        frame.getContentPane().add(new Grafico());
//        frame.setSize(300, 300);
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setResizable(false);        
//    }
}
	

