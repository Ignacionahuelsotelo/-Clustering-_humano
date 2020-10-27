package logica;

import java.util.ArrayList;

public class AGM {
	
    int[][] pesos;
    Grafo g;
    
    public AGM(Grafo grafo) {
    	int n =grafo.tamanio();
    	g = grafo;
    	pesos = new int[n][n];
    	for(int i=0;i<n-1;i++) {
    		for(int j=i+1;j<n;j++) {
    			if(g.existeArista(i, j))
    				pesos[i][j]= g.getPeso(i, j);
    			else
    				pesos[i][j]=-1;
    		}
    	}
    }
    
    
    public int[] obtenerAristaMinima() {
    	int[] indicesMinimos = new int[2];
    	int minimo = 800000000;
    	for(int i=0;i<g.tamanio()-1;i++) {
    		for(int j=i+1;j<g.tamanio();j++) {
    			if(pesos[i][j]<minimo && pesos[i][j]>=0) {
    				minimo=pesos[i][j];
    				indicesMinimos[0] = i;
    				indicesMinimos[1] = j;
    			}
    		}
    	}
    	
    	pesos[indicesMinimos[0]][ indicesMinimos[1]]=-1;
    	
    	return indicesMinimos;
    }
    
    public Grafo generadoMin(){
    	int cantAristas=0;
    	int n= g.tamanio();
    	Grafo min =  new Grafo(n);
    	for(Persona p : g.vertices()) {
    		min.agregarVertice(p);
    	}
    	int i=0;
    	int j=0;
    	int[] indicesMinimos = new int[2];
    	while(cantAristas<n-1) {
    		indicesMinimos = obtenerAristaMinima();
    		i=indicesMinimos[0];
    		j=indicesMinimos[1];
			System.out.println("Los Indices son: "+indicesMinimos[0]+" "+ indicesMinimos[1 ]);

    		if(!BFS.alcanzables(min, min.vertices().get(i)).contains(min.vertices().get(j))) {
    			min.agregarArista(i, j);
    			cantAristas++;
    		}
    	}    	
    	return min;
    }
	
}
