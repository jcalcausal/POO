package canciones;

import java.util.ArrayList;

public class Coleccion {
	private ArrayList<Cancion> canciones;
	
	public Coleccion() {
		canciones= new ArrayList<>();
	}
	public ArrayList<Cancion> getCanciones (){
		return canciones;
	}
	
	protected boolean iguales (ArrayList<String> a, ArrayList<String> b) {
		boolean iguales=true;
		if(a.size()!=b.size())
			iguales= false;
		int i=0;
		while(iguales && i<Math.max(a.size(), b.size())) {
			if(a.get(i)!=b.get(i))
				iguales=false;
		}
		return iguales;
	}
	
	private int buscarCancion(String t, ArrayList<String> inter) {
		for(int i=0; i<canciones.size();++i) {
			if(t.equalsIgnoreCase(canciones.get(i).getTitulo()) && iguales(canciones))
				return i;
		}
		return -1;
	}
}
