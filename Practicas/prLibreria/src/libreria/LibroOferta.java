package libreria;

public class LibroOferta extends Libro{
	private double porcDescuento;
	
	public LibroOferta(String autor, String titulo, double precioBase, double porcentajeDescuento) {
		super(autor, titulo, precioBase);//Invoca el constructor de la clase libro. Esto tiene que ir en la primera línea;
		this.porcDescuento=porcentajeDescuento;
	}
	
	public double getDescuento() {
		return this.porcDescuento;
	}
	
	@Override
	protected double getBaseImponible() {
		return super.getBaseImponible()*(100-this.getDescuento())/100;
	}
	
	@Override
	public String toString() {
		return "(" + getAutor() + "; " + getTitulo() + "; " + getBaseImponible() + "; " + getIVA() + "; " + getPrecioFinal() +")";
	} 
}
