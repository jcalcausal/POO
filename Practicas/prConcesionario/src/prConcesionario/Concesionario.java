package prConcesionario;

public class Concesionario {
	private Coche[] concesionario;
	private int CONST_TAM=10;
	
	public Concesionario() {
		concesionario= new Coche[CONST_TAM];
	}
	
	public Concesionario (int n) {
		if(n>0)
			concesionario= new Coche[n];
			ne=0;
		else
			throw new RuntimeException("La capacidad no puede ser negativo");
	}
	
	private int buscarCoche(Coche c) {
		boolean encontrado=false;
		int i=0;
		while(i<concesionario.length && !encontrado) {
			if(c.getModelo().equalsIgnoreCase(concesionario[i].getModelo())) {
				encontrado=true;
			}
			++i;
		}
		return encontrado? i-1 : -1;
	}
	
	public void anyadirCoche(Coche c) {
		int p=buscarCoche(c);
		if(p<0)
			concesionario[p]=c;
		else if(p<concesionario.length)
			concesionario[concesionario.length]=c;
		else {
			
		}

	}
}
