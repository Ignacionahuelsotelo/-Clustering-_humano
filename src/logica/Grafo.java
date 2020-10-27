package logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Grafo {
	    // Representamos el grafo por su matriz de adyacencia
	    private ArrayList<HashSet<Persona> > vecinos;
	    private ArrayList<Persona> vertices;

	    // La cantidad de vertices esta predeterminada desde el constructor
	    public Grafo(int a)
	    {
	    	vecinos = new ArrayList<HashSet<Persona> >();
	    	for(int i=0; i<a; ++i) //agrega hashSet vacios con la cantidad de vertices
	    	      vecinos.add(new HashSet<Persona>());
	    	vertices= new ArrayList<Persona>();
	    }
	        
	   
		// Getters y setters de aristas 
	    public void agregarArista(int i1, int i2 ) {
	    	
	    	verificarVertice(i1);
			verificarVertice(i2);
			verificarDistintos(i1,i2);
			
			vecinos.get(i1).add(vertices.get(i2));
			vecinos.get(i2).add(vertices.get(i1));
		}
	    
	    public void agregarVertice(Persona persona) {
			vertices.add(persona);
			vecinos.add(new HashSet<Persona>());
			
		}

		public void eliminarArista(int i1, int i2) {
			verificarVertice(i1);
			verificarVertice(i2);
			verificarDistintos(i1,i2);
			vecinos.get(i1).remove(vertices.get(i2));
			vecinos.get(i2).remove(vertices.get(i1));
		}
	    	
		public boolean existeArista(int i,int j) {
			verificarVertice(i);
			verificarVertice(j);
			verificarDistintos(i,j);
			return vecinos.get(i).contains(vertices.get(j));
		}

		public Set<Persona> vecinos(int i){
			verificarVertice(i);
			return vecinos.get(i);
		}
	    
		public ArrayList<Persona> vertices(){
			return vertices;
		}
	
		public int tamanio() {
			return vertices.size();
		}
		
		
		private void verificarDistintos(int i, int j) {
			if(i==j)
				throw new IllegalArgumentException("No se permiten loops: (" +"i="+i +", j="+j);
		}

		private void verificarVertice(int i) {
			if (i < 0)
				throw new IllegalArgumentException("El vertice no puede ser negativo: " + i);
			if (i >= this.tamanio())
				throw new IllegalArgumentException("El vertice no existe: " + i);
		}
		
		public int obtenerIndice(Persona p) {
			return vertices.indexOf(p);
		}
		
		public int getPeso(int i, int j) {
			verificarVertice(i);
			verificarVertice(j);
			verificarDistintos(i,j);
			return vertices.get(i).indiceDeSimilaridad(vertices.get(j));
		}
		
		public void completarGrafo() {
			for(int i=0;i<tamanio()-1;i++) {
	    		for(int j=i+1;j<tamanio();j++) {
	    			this.agregarArista(i, j);
	    	}
		
		}
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



