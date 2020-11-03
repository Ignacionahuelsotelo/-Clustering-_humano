package logica;

public class Persona {
	private String nombre;
	private int musica;
	private int deporte;
	private int espectaculo;
	private int ciencia;
	private int arte;

	public Persona(String nombre, int musica, int deporte, int espectaculo, int ciencia, int arte) {

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

	public void nombreValido(String nombre) {
		if (nombre == "") {
			throw new IllegalArgumentException("El nombre no puede ser vac�o");
		}
		if (nombre.length() < 1) {
			throw new IllegalArgumentException("El nombre debe ser mayor igual a 3 caracteres");

		}
	}

	public void interesValido(int interes, String propiedad) {
		if (interes < 0)
			throw new IllegalArgumentException("El valor de " + propiedad + " es negativo");
		if (interes > 5)
			throw new IllegalArgumentException("El valor de " + propiedad + " es mayor a 5");
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

	public int indiceDeSimilaridad(Persona otro) {
		int indiceMusica = Math.abs(musica - otro.getMusica());
		int indiceArte = Math.abs(arte - otro.getArte());
		int indiceCiencia = Math.abs(ciencia - otro.getCiencia());
		int indiceEspectaculo = Math.abs(espectaculo - otro.getEspectaculo());
		int indiceDeporte = Math.abs(deporte - otro.getDeporte());

		return indiceMusica + indiceArte + indiceCiencia + indiceEspectaculo + indiceDeporte;

	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + arte;
		result = prime * result + ciencia;
		result = prime * result + deporte;
		result = prime * result + espectaculo;
		result = prime * result + musica;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (arte != other.arte)
			return false;
		if (ciencia != other.ciencia)
			return false;
		if (deporte != other.deporte)
			return false;
		if (espectaculo != other.espectaculo)
			return false;
		if (musica != other.musica)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

}
