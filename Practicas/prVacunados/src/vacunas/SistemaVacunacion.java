package vacunas;
import java.util.Arrays;

public class SistemaVacunacion {
	private Persona[] personas;
	private int numPersonas;
	private static int vacunas;
	private static final int CAP_INICIAL=5;
	
	public SistemaVacunacion() {
		personas= new Persona[CAP_INICIAL];
		numPersonas=0;
		vacunas=0;
	}
	
	private int buscarPersona(String n, int e) {
		boolean encontrado=false;
		int i=0;
		while(!encontrado && i<numPersonas) {
			if(n.equalsIgnoreCase(this.personas[i].getNombre()) && e==personas[i].getEdad()) {
				encontrado=true;
			}
			++i;
		}
		return i<numPersonas ? i-1 : -1;
	}
	
	protected void anyadirPersona(Persona p) {
		int n=buscarPersona(p.getNombre(), p.getEdad());
		if(n==-1) {
			if(numPersonas==personas.length) {
				personas= Arrays.copyOf(personas, 2*numPersonas);
			}
			personas[numPersonas]=p;
			++numPersonas;
		}
	}
	
	public void addPersona(String n, int e) {
		anyadirPersona(new Persona(n,e));
	}
	
	public void comprarVacunas(int n) {
		if(n>0)
			vacunas+=n;
	}
	
	public void vacunar (int edadMinima, int edadMaxima) {
		int i=0;
		while (i<numPersonas && vacunas>0) {
			if(personas[i].getEdad()<=edadMaxima && personas[i].getEdad()>=edadMinima) {
				personas[i].vacunar();
				--vacunas;
			}
			++i;
		}
	}
	
	@Override
	public String toString() {
		return "Vacunas: " + vacunas + Arrays.toString(personas);
	}
	
	
	
	
}
