package vacunas;

public class Persona {
	private String nombre;
	private int edad;
	private boolean inmunizado;
	
	public Persona (String nombre, int edad) {
		this.nombre=nombre;
		if(edad<0)
			throw new RuntimeException("La edad no puede ser negativa");
		else
			this.edad=edad;
		this.inmunizado=false;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public boolean inmunizado () {
		return inmunizado;
	}
	
	public void vacunar() {
		inmunizado=true;
	}
	
	@Override
	public String toString() {
		String v;
		if(inmunizado)
			v="INMUNIZADO";
		else
			v="NO INMUNIZADO";
			
		return "(" + nombre + ", " + edad + ", " + v + ")";
	}
}
