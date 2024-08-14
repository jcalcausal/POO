package notas;

public class Alumno {
	private String nombre;
	private String dni;
	private double nota;
	
	public Alumno(String dni, String nombre, double nota) throws AlumnoException {
		if(nota<0)
			throw new AlumnoException("Calificación negativa");
		this.dni=dni;
		this.nombre=nombre;
		this.nota=nota;
	}
	
	public Alumno(String dni, String nombre) throws AlumnoException{
		this(dni, nombre, 0);
	}
	
	@Override
	public boolean equals (Object obj) {
		if(obj instanceof Alumno) {
			Alumno a= (Alumno) obj;
			if(this.nombre.equals(a.nombre) && this.dni.equalsIgnoreCase(a.dni))
				return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return dni.toUpperCase().hashCode() + nombre.hashCode();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDni() {
		return dni;
	}
	
	public double getCalificacion() {
		return nota;
	}
	
	@Override
	public String toString() {
		return nombre + " " + dni.toUpperCase();
	}
}
