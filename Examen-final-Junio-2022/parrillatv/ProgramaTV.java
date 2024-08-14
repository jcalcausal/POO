package parrillatv;

public class ProgramaTV implements Comparable<ProgramaTV>{
	private String nombre;
	private Hora horaInicio;
	private int duracion;
	
	public ProgramaTV(String nombre, Hora horaInicio, int duracion) {
		if(duracion<0)
			throw new ProgramacionTVException("La duracion no puede seer negativa");
		this.nombre=nombre;
		this.horaInicio=horaInicio;
		this.duracion=duracion;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public Hora getHoraInicio() {
		return horaInicio;
	}
	
	public int getDuracion() {
		return duracion;
	}
	
	public Hora getHoraFin() {
		int h= horaInicio.getHora();
		int m= horaInicio.getMinuto();
		Hora HoraFin= new Hora(h,m);
		HoraFin.incrementar(duracion);
		return HoraFin;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ProgramaTV) {
			ProgramaTV p= (ProgramaTV) obj;
			return this.nombre.equalsIgnoreCase(p.getNombre()) && this.horaInicio.equals(p.getHoraInicio()) && this.duracion==p.getDuracion();
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.nombre.toUpperCase().hashCode() + horaInicio.hashCode() + duracion;
	}
	
	@Override
	public int compareTo (ProgramaTV p) {
		int res= this.horaInicio.compareTo(p.getHoraInicio());
		if(res==0)
			res= Integer.compare(duracion, p.getDuracion());
		else if(res==0)
			res=nombre.compareToIgnoreCase(p.getNombre());
		return res;
	}
	
	@Override
	public String toString() {
		return nombre.toUpperCase()+"["+horaInicio.getHora()+":"+horaInicio.getMinuto()+"]-"+duracion;
	}
}
