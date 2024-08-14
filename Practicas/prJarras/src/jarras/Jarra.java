package jarras;

public class Jarra {
	private final int capacidad;
	private int contenido;
	
	public Jarra(int capacidad) {
		if( capacidad<=0 ) {
			throw new RuntimeException("La capacidad no puede ser negativa");
		}
		
		this.capacidad=capacidad;
		this.contenido=0;
	}
	
	public int capacidad () {
		return capacidad;
	}
	
	public int contenido () {
		return contenido;
	}
	
	@Override //Quiere decir que est� redefiniendo un m�todo.
	public String toString() {
		return "J(" + capacidad + "," + contenido + ")";
	}
	
	public void llena() {
		contenido=capacidad;
	}
	
	public void vacia() {
		contenido=0;
	}
	
	public void llenaDesde(Jarra j) {//Con this. nos referimos a la jarra que estamos llenando
		if(this==j) {
			throw new RuntimeException("No se puede llenar una jarra desde s� misma");
		}
		int trasvase=Math.min(this.capacidad-this.contenido, j.contenido);//El m�nimo entre lo que cabe y lo que hay
		this.contenido+=trasvase;
		j.contenido-=trasvase;//Lo que a�adimos en una lo quitamos de la otra.
	}

}
