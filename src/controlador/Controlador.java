package controlador;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

import logica.Clasificador;
import logica.Grafo;
import logica.Persona;
import visual.Grafico;
import datos.GestorJSON;
import datos.PersonasJSON;

public class Controlador {
	
	static Clasificador clasificador = new Clasificador() ;
	
//	public Controlador () {
//		 clasificador = new Clasificador();
//	}
	
	
     public static void agregarPersona (String nombre, int musica, int deporte,int espectaculo, int ciencia, int arte) {
		clasificador.cargarPersona(nombre, musica, deporte, espectaculo, ciencia, arte);
		GestorJSON.agregarPersonas(new Persona(nombre, musica, deporte, espectaculo, ciencia, arte));
		
	}
     
     public static void guardarPersona () {
    	 GestorJSON.guardarPersonas();
     }
     
     public static void obtenerGrupos() {
    	 ArrayList<Set<Persona>> grupos = clasificador.agruparPersonas();
    	 Set <Persona>   grupo1 = grupos.get(0);
 		 Set <Persona>   grupo2 = grupos.get(1);
     }
     
     public static void graficarGrupos  (Graphics g) {
    	 Grafo nuevo = clasificador.dividirGrafo();
    	 Random r1 = new Random(100);
    	 Random r2 = new Random(100);
    	 
    	 for (int i = 0 ; i < nuevo.tamanio();i++) {
    		 Grafico.agregarCirculo(r1.nextInt(), r2.nextInt(), g);
    	 }
     }
     
     public static ArrayList<String> getDatosPersonas (){
    	PersonasJSON personas = PersonasJSON.leerJSON("usuarios.JSON");
    	return personas.getPersonasString();
     }
     
 	public static DefaultListModel<String> recorrerDatosPersonas (ArrayList<String> datos) {
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for (int i = 0 ; i < datos.size(); i++) {
			listModel.addElement(datos.get(i));
		}
		return listModel;
		
	}
	
	public static JList crearLista () {
		Font fuenteLista = new Font("Showcard Gothic", java.awt.Font.PLAIN, 20);
		JList list = new JList<>(recorrerDatosPersonas(getDatosPersonas()));
		list.setBounds(0, 0, 328, 521);
		
		list.setFont(fuenteLista);
		
		return list;
	}
	
	public static void agregarLista (JPanel panel) {
		JList list = crearLista();
		panel.removeAll();
		panel.add(list);
		
		
	}
     
	//Deberiamos hacer que cuando se aprete el boto de cargar DATOS en la parte visual, el controlador debe leer los datos de las 
	//personas y seterlos a sus variables de instancia que corresponden a cada caracateristica de la persona, y los  carga al grafo. 
}
