package libreria;
import java.util.Arrays;

public class OfertaAutor implements OfertaFlex{
	private double porcDescuento;
	private String[] autoresOferta; 
	
	public OfertaAutor(double porcDescuento, String[] autoresOferta) {
		this.porcDescuento = porcDescuento;
		this.autoresOferta = autoresOferta;
	}
	
	
	@Override
	public double getDescuento (Libro libro) {
		if(!estaDentro(libro.getAutor()))	
			return 0;
		else 
			return porcDescuento;
	}	
	
	private boolean estaDentro (String autor) {
		for(String s: autoresOferta) {
			if(autor.compareToIgnoreCase(s)==0) 
				return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return porcDescuento + "%" + Arrays.toString(autoresOferta);
	}
	
}
