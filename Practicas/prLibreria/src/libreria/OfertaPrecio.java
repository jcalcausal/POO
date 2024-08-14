package libreria;

public class OfertaPrecio implements OfertaFlex{
	private double porcDescuento;
	private double umbralPrecio;
	
	public OfertaPrecio(double porcDescuento, double umbralPrecio) {
		this.porcDescuento=porcDescuento;
		this.umbralPrecio=umbralPrecio;
	}
	
	@Override
	public double getDescuento(Libro libro) {
		return libro.getPrecioBase()<this.umbralPrecio ? 0 : this.porcDescuento;
	}
	
	@Override
	public String toString() {
		return porcDescuento + "%" + "(" +  umbralPrecio +")";
	}
}
