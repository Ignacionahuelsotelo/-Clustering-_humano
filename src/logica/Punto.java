package logica;

public class Punto {
	
	int x;
	int y;
	
	public Punto(int x, int y) {
		
		this.x = x;
		this.y = y;
		
		
	}
	
	public boolean intersecan (Punto p) {
		int numero1 = Math.abs(this.x - p.getX());
		int numero2 = Math.abs(this.y - p.getY());
		
		if (numero1 < 80 && numero2 < 80 ) {
			return true ;
		}
		return false;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
}
