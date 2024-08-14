package libreria;

import java.util.ArrayList;

public class Libreria {
	
	private ArrayList<Libro> libs;
	
	public Libreria() {
		libs= new ArrayList<Libro>();//Lo inicializa como un array list vacio, los parentesis son
		//una llamada al constructor.
	}
	
	
	private int buscarLibro(String a, String t) {
		int i=0;
		while ((i<libs.size()) && !(libs.get(i).getAutor().equalsIgnoreCase(a) && libs.get(i).getTitulo().equalsIgnoreCase(t))) {
			++i;
		}
		
		return (i< libs.size()) ? i : -1;
		
		/*Es igual que
		if(i==libs.sizlñe())
			return -1; (Esto significa que no lo ha encontrado, lo ha  recorrido entero)
		else
			return i;																																																																																									
		*/
	}
	
	protected void anyadirLibro(Libro libro) {
		int i= buscarLibro(libro.getAutor(), libro.getTitulo());
		if(i<0)
			libs.add(libro);//Lo que hace es añadir el libro en la última posición.
		else
			libs.set(i,libro);//Lo que hace es actualizar una posición concreta del ArrayList.
	}
	
	public void addLibro(String a, String t, double p) {
		anyadirLibro(new Libro(a,t,p));
	}
	
	public double getPrecioFinal(String a, String t) {
		int pos=buscarLibro(a,t);
		if(pos<0)
			throw new RuntimeException("No se ha encontrado un libro con ese autor y titulo");
		else 
			return libs.get(pos).getPrecioFinal();
	}
	
	public void remLibro (String a, String t) {
		if(this.buscarLibro(a,t)<0)
			throw new RuntimeException("No se ha encontrado un libro con ese autor y titulo");
		else
			libs.remove(this.buscarLibro(a,t));
	}
	
	@Override
	public String toString() {
		return libs.toString();//Lo que hace es ir llamando al método toString de cada objeto del ArrayList
	}
	
	
}
