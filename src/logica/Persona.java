package logica;

public class Persona {
	private int musica; 
	private int deporte;
	private int espectaculo;
	private int ciencia;
	private int arte;
	
	public Persona (int musica, int deporte, int espectaculo, int ciencia, int arte ) {
		this.musica = musica;
		this.deporte = deporte;
		this.espectaculo = espectaculo;
		this.ciencia = ciencia;
		this.arte = arte;
	}

	public int getMusica() {
		return musica;
	}

	public void setMusica(int musica) {
		this.musica = musica;
	}

	public int getDeporte() {
		return deporte;
	}

	public void setDeporte(int deporte) {
		this.deporte = deporte;
	}

	public int getEspectaculo() {
		return espectaculo;
	}

	public void setEspectaculo(int espectaculo) {
		this.espectaculo = espectaculo;
	}

	public int getCiencia() {
		return ciencia;
	}

	public void setCiencia(int ciencia) {
		this.ciencia = ciencia;
	}

	public int getArte() {
		return arte;
	}

	public void setArte(int arte) {
		this.arte = arte;
	}
	
	public int indiceDeSimilaridad (Persona otro) {
		int indiceMusica = Math.abs(this.musica - otro.getMusica());
		int indiceArte = Math.abs(this.arte - otro.getArte());
		int indiceCiencia = Math.abs(this.ciencia - otro.getCiencia());
		int indiceEspectaculo = Math.abs(this.espectaculo - otro.getEspectaculo());
		int indiceDeporte = Math.abs(this.deporte - otro.getDeporte());
		
		return indiceMusica + indiceArte + indiceCiencia + indiceEspectaculo + indiceDeporte;
		
	}

}
