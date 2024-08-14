package libreria;

public class LibreriaOfertaFlex 
	extends Libreria{
	
	OfertaFlex oferta;

	public LibreriaOfertaFlex(OfertaFlex of){
		oferta=of;
	}
	
	public void setOferta(OfertaFlex oferta) {
		this.oferta=oferta;
	}
	
	public OfertaFlex getOferta() {
		return oferta;
	}
	
	@Override
	public void addLibro (String a, String t, double p) {
		Libro libro=new Libro(a,t,p);
		double desc= oferta.getDescuento(libro);
		if(desc!=0)
			anyadirLibro(new LibroOferta(a,t,p,desc));
		else
			anyadirLibro(libro);
	}
	
	@Override
	public String toString() {
		return oferta.toString()+ "/n" + super.toString();
	}
}
