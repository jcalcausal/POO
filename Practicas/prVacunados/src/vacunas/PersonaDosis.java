package vacunas;

public class PersonaDosis extends Persona{
	private int dosisNecesarias;
	private int dosisAdministradas;
	
	public PersonaDosis(String nombre, int edad, int dosisNecesarias) {
		super(nombre,edad);
		if(dosisNecesarias<0)
			throw new RuntimeException("El numero de dosis no puede ser negativo");
		this.dosisNecesarias=dosisNecesarias;
		this.dosisAdministradas=0;
	}
	
	@Override
	public void vacunar() {
		if(dosisAdministradas<dosisNecesarias)
			++dosisAdministradas;
		if(dosisAdministradas==dosisNecesarias)
			super.vacunar();
	}
}
