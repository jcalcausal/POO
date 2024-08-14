package canciones;
import java.util.ArrayList;
import java.util.Arrays;

public class Cancion {
	private String titulo;
	private ArrayList<String> interpretes;
	private int duracion;
	private Estilo estilo;
	
	public Cancion(String titulo, ArrayList<String> interpretes, int duracion, Estilo estilo) {
		if(duracion<0)
			throw new RuntimeException("La duracion no puede ser negativa");
		else {
			this.titulo=titulo;
			this.interpretes=interpretes;
			this.duracion=duracion;
			this.estilo=estilo;
		}
	}
	
	public Cancion(String titulo, ArrayList<String> interpretes, int duracion) {
		if(duracion<0)
			throw new RuntimeException("La duracion no puede ser negativa");
		else {
			this.titulo=titulo;
			this.interpretes=interpretes;
			this.duracion=duracion;
			this.estilo=Estilo.valueOf("OTRO");
		}
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public ArrayList<String> getInterpretes(){
		return interpretes;
	}
	
	public int getDuracion() {
		return duracion;
	}
	
	public Estilo getEstilo() {
		return estilo;
	}
	
	@Override
	public String toString() {
		return titulo + "; " + interpretes.toString() + "; " + duracion + estilo;
	}
}
