package logica;

public class Persona {
	private String nombre;
	private int musica; 
	private int deporte;
	private int espectaculo;
	private int ciencia;
	private int arte;
	
	
	public Persona (String nombre, int musica, int deporte, int espectaculo, int ciencia, int arte ) {
		
		nombreValido(nombre);
		interesValido(musica, "musica");
		interesValido(deporte, "deporte");
		interesValido(espectaculo, "espectaculo");
		interesValido(ciencia, "ciencia");
		interesValido(arte, "arte");
		
		this.nombre = nombre;
		this.musica = musica;
		this.deporte = deporte;
		this.espectaculo = espectaculo;
		this.ciencia = ciencia;
		this.arte = arte;
	}
	
	public void nombreValido (String nombre) {
		if (nombre == "") {
			throw new IllegalArgumentException("El nombre no puede ser vacío");
		}
		if (nombre.length() <= 3) {
			throw new IllegalArgumentException("El nombre debe ser mayor igual a 3 caracteres");
			
		}
	}

	public void interesValido(int interes, String propiedad) {
		if(interes<0)
			throw new IllegalArgumentException("El valor de "+ propiedad+ " es negativo");
		if(interes>5)
			throw new IllegalArgumentException("El valor de "+ propiedad+ " es mayor a 5");
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getMusica() {
		return musica;
	}

	

	public int getDeporte() {
		return deporte;
	}

	
	public int getEspectaculo() {
		return espectaculo;
	}

	
	public int getCiencia() {
		return ciencia;
	}

	
	public int getArte() {
		return arte;
	}

	
	
	public int indiceDeSimilaridad (Persona otro) {
		int indiceMusica = Math.abs(musica - otro.getMusica());
		int indiceArte = Math.abs(arte - otro.getArte());
		int indiceCiencia = Math.abs(ciencia - otro.getCiencia());
		int indiceEspectaculo = Math.abs(espectaculo - otro.getEspectaculo());
		int indiceDeporte = Math.abs(deporte - otro.getDeporte());
		
		return indiceMusica + indiceArte + indiceCiencia + indiceEspectaculo + indiceDeporte;
		
	}

}
