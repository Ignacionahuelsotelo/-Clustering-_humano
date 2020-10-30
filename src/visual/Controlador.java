package visual;
import logica.Clasificador;
public class Controlador {
	
	Clasificador clasificador;
	
	public Controlador () {
		 clasificador = new Clasificador();
	}
	
	
	public void getGrafos () {
		
		clasificador.cargarPersona(nombre, musica, deporte, espectaculo, ciencia, arte);
		grupo1 = clasificador.agruparPersonas().get(0);
		grupo2 = clasificador.agruparPersonas().get(1);
	}
	
	//Deberiamos hacer que cuando se aprete el boto de cargar DATOS en la parte visual, el controlador debe leer los datos de las 
	//personas y seterlos a sus variables de instancia que corresponden a cada caracateristica de la persona, y los  carga al grafo. 
}
