package parrillatv;

public class ProgramacionTVPublicidad extends ProgramacionTV{
	public ProgramacionTVPublicidad() {
		super();
	}
	
	public void agregar(String cadenaTV, ProgramaTV prog) {
		ProgramaTV publicidad= new ProgramaTV("Publicidad", prog.getHoraFin(), 5);
		super.agregar(cadenaTV, prog);
		super.agregar(cadenaTV, publicidad);
	}
}
