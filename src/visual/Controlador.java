package visual;
import java.util.ArrayList;
import java.util.Set;

import logica.Clasificador;
import logica.Persona;
public class Controlador {
	
	Clasificador clasificador;
	
	public Controlador () {
		 clasificador = new Clasificador();
	}
	
	
     public void agregarPersona (String nombre, int musica, int deporte,int espectaculo, int ciencia, int arte) {
		clasificador.cargarPersona(nombre, musica, deporte, espectaculo, ciencia, arte);
	}
     
     public void obtenerGrupos(int cantGrupos) {
    	 ArrayList<Set<Persona>> grupos = clasificador.agruparPersonas();
    	 Set <Persona>   grupo1 = grupos.get(0);
 		 Set <Persona>   grupo2 = grupos.get(1);
     }

     
	//Deberiamos hacer que cuando se aprete el boto de cargar DATOS en la parte visual, el controlador debe leer los datos de las 
	//personas y seterlos a sus variables de instancia que corresponden a cada caracateristica de la persona, y los  carga al grafo. 
}
