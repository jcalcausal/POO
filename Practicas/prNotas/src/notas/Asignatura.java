package notas;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Locale;

public class Asignatura {
	private String nombre;
	private ArrayList <Alumno> alumnos;
	private ArrayList <String> errores;
	
	public Asignatura (String nombre, String [] datos) {
		this.nombre=nombre;
		procesarDatos(datos);
	}
	
	private void procesarDatos(String [] datos) {
		alumnos = new ArrayList<>();
		errores = new ArrayList<>();
		for(String al : datos) { 
			try(Scanner sc = new Scanner(al)) {
				sc.useDelimiter("\\s*[;]\\s*");
				String dni = sc.next();
				String nom = sc.next();
				sc.useLocale(Locale.ENGLISH);
				double cal = sc.nextDouble();
				alumnos.add(new Alumno(dni, nom, cal));
			} catch (InputMismatchException imee) { // Se produce un error de formato: se esperaba un double
				errores.add("ERROR. Calificacion no numerica: " + al);
			} catch (NoSuchElementException nseee) { // Se produce un error de formato: se intenta leer un dato que no existe
				errores.add("ERROR. Faltan datos: " + al);
			} catch (AlumnoException ae) { // Se producirá en caso de que la calificación fuese negativa
				errores.add("ERROR. Calificacion negativa: " + al);
			}
		}
	}
	
	public double getCalificacion(Alumno al) throws AlumnoException {
		int res = alumnos.indexOf(al);
		if (res == -1) // Si no se encuentra el alumno, se lanza una excepción con mensaje.
			throw new AlumnoException ("El alumno " + al + " no se encuentra");
		return alumnos.get(res).getCalificacion() ;
	}
}
