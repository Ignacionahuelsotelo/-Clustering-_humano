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
   
     public static void cargarDatosEnClasificador(String nombreDelArchivo) {
     	PersonasJSON personas = PersonasJSON.leerJSON(nombreDelArchivo);
     	ArrayList<Persona> paraCargar = personas.getPersonas();
     	for(Persona p : paraCargar) {
     		clasificador.agregarPersonas(p);
     	}
     } 
     
    public static void cargarBase() {
    	cargarDatosEnClasificador("PersonasPretty.JSON");
    }
    
    public static void cargarActual() {
    	cargarDatosEnClasificador("usuarios.JSON");
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
    	 ArrayList<String>  personasCargadas = PersonasJSON.leerJSON("usuarios.JSON").getPersonasString();
    	 ArrayList<String>  personas = PersonasJSON.leerJSON("PersonasPretty.JSON").getPersonasString();
    	 for(String p : personasCargadas) {
    		 personas.add(p);
    	 }

    	return personas;
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
