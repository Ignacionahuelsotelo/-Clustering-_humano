package logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Grafo {
	    // Representamos el grafo por su matriz de adyacencia
	    private ArrayList<HashSet<Persona> > vecinos;
	    private Set<Persona> vertices;

	    // La cantidad de vertices esta predeterminada desde el constructor
	    public Grafo(int vertices)
	    {
	    	vecinos = new ArrayList<HashSet<Persona> >();
	    	for(int i=0; i<vertices; ++i) //agrega hashSet vacios con la cantidad de vertices
	    	vecinos.add(new HashSet<Persona>());
	    }
	        
	   
		// Getters y setters de aristas 
	    public void agregarArista(Persona persona1,  Persona persona2, int i1, int i2 ) {
			vecinos.get(i1).add(persona2);
			vecinos.get(i2).add(persona1);
		}
	    
	    public void agregarVertice(Persona persona) {
			vertices.add(persona);
		}

		public void eliminarArista(Persona persona1,  Persona persona2, int i1, int i2) {
			vecinos.get(i1).remove(persona2);
			vecinos.get(i2).remove(persona1);
		}
	    	
		public boolean existeArista(Persona persona, int i) {
			return vecinos.get(i).contains(persona);
		}

		public Set<Persona> vecinos(int i){
			return vecinos.get(i);
		}
	    
		public Set<Persona> vertices(){
			return vertices;
		}
	

//	    // Agregado de aristas
//	    public void agregarArista(int i, int j, int peso)
//	    {
//	        verificarVertice(i);
//	        verificarVertice(j);
//	        verificarDistintos(i, j);
//
//	        A[i][j] = peso;
//	        A[j][i] = peso;
//	    }
//
//	    // Eliminacion de aristas
//	    public void eliminarArista(int i, int j)
//	    {
//	        verificarVertice(i);
//	        verificarVertice(j);
//	        verificarDistintos(i, j);
//
//	        A[i][j] = 0;
//	        A[j][i] = 0;
//	    }
//	// Informa si existe la arista especificada
//	    public boolean existeArista(int i, int j)
//	    {
//	        verificarVertice(i);
//	        verificarVertice(j);
//	        verificarDistintos(i, j);
//	        if (A[i][j] != 0) {
//	        	return true;
//	        }
//	        return false;
//	    }
//
//	    // Cantidad de vertices
//	    public int tamano()
//	    {
//	        return A.length;
//	    }
//
//	    
//
//	    // Verifica que sea un vertice valido
//	    private void verificarVertice(int i)
//	    {
//	        if( i < 0 )
//	            throw new IllegalArgumentException("El vertice no puede ser negativo: " + i);
//
//	        if( i >= A.length )
//	            throw new IllegalArgumentException("Los vertices deben estar entre 0 y |V|-1: " + i);
//	    }
//
//	    // Verifica que i y j sean distintos
//	    private void verificarDistintos(int i, int j)
//	    {
//	        if( i == j )
//	            throw new IllegalArgumentException("No se permiten loops: (" + i + ", " + j + ")");
//	    }
	}



