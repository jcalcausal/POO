package libreria;

public class Libro {
	private static double porcIVA=10;
	private String autor;
	private String titulo;
	private double precioBase;
	
	public Libro (String autor, String titulo, double precioBase) {
		this.autor=autor;
		this.titulo=titulo;
		this.precioBase=precioBase;
	}
	
	public String getAutor () {
		return autor;
	}
	
	public String getTitulo () {
		return titulo;
	}
	
	public double getPrecioBase () {
		return precioBase;
	}
	
	protected double getBaseImponible() {
		return precioBase;
	}
	
	public double getPrecioFinal() {
		return getBaseImponible() + getBaseImponible()*getIVA()/100;
	}
	
	@Override
	public String toString() {
		return "("+getAutor()+","+getTitulo()+";"+getPrecioBase()+";"+getIVA()+"%"+";"+getPrecioFinal()+")";
	}
	
	public static double getIVA() {
		return porcIVA;
	}
	
	public static void setIVA(double nuevoIVA) {
		porcIVA=nuevoIVA;
	}
	
}
