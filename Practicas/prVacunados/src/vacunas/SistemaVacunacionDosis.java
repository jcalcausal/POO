package vacunas;

public class SistemaVacunacionDosis extends SistemaVacunacion {
	private int dosisVacunas;
	
	public SistemaVacunacionDosis(int dosisVacunas) {
		super();
		if(dosisVacunas<=0)
			throw new RuntimeException("La cantidad de dosis no puede ser negativa ni nula");
		else
			this.dosisVacunas=dosisVacunas;
	}
	
	@Override
	public void addPersona(String n, int e) {
		super.anyadirPersona(new PersonaDosis(n,e,dosisVacunas));
	}
}
