package parrillatv;
import java.util.SortedSet;
import java.util.Set;
import java.util.Map;
import java.util.List;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Scanner;
import java.nio.file.*;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.io.PrintWriter;

public class ProgramacionTV{
	protected Map<String, SortedSet<ProgramaTV>> cadenas;
	
	public ProgramacionTV() {
		cadenas= new HashMap<>();
	}
	
	public void agregar(String cadenaTV, ProgramaTV prog) {
		SortedSet<ProgramaTV> p= cadenas.get(cadenaTV);
		p.add(prog);
		cadenas.put(cadenaTV, p);
	}
	
	public void leerProgramas(String fichero) throws IOException {
		Path path = Path.of(fichero);
		List<String> lineas = Files.readAllLines(path);
		for(String linea: lineas) {
			try(Scanner sc= new Scanner(linea)){
				sc.useDelimiter("[>@:-]+");
				String nc= sc.next();
				String np= sc.next();
				int hh= sc.nextInt();
				int mm= sc.nextInt();
				int d= sc.nextInt();
				Hora hi= new Hora(hh, mm);
				ProgramaTV p= new ProgramaTV(np,hi,d);
				this.agregar(nc, p);
			}catch (NoSuchElementException nse) {
			}
		}
	}
	
	public void mostrarProgramas(String fichero) throws FileNotFoundException{
		try (PrintWriter pw = new PrintWriter(fichero)) {
			Set<String> keySet= cadenas.keySet();
			for(String s: keySet) {
				pw.println(s+":");
				SortedSet<ProgramaTV> p= cadenas.get(s);
				Iterator<ProgramaTV> iter= p.iterator();
				while(iter.hasNext()) 
					pw.println(iter.next());
			}
		}
	}
	
	public void mostrarProgramas(PrintWriter pw) throws FileNotFoundException{
		Set<String> keySet= cadenas.keySet();
		for(String s: keySet) {
			pw.println(s+":");
			SortedSet<ProgramaTV> p= cadenas.get(s);
			Iterator<ProgramaTV> iter= p.iterator();
			while(iter.hasNext()) 
				pw.println(iter.next());
		}
		pw.close();
	}
	public boolean esConsistente(String cadenaTV) {
		SortedSet<ProgramaTV> p = cadenas.getOrDefault(cadenaTV, null);
		if (p==null)
			throw new ProgramacionTVException("La cadena no aparece");
		boolean consistente=true;
		Iterator<ProgramaTV> iter= p.iterator();
		while(iter.hasNext()) {
			ProgramaTV pr1= iter.next();
			ProgramaTV pr2= iter.next();
			if(pr1.getHoraFin().diferenciaMinutos(pr2.getHoraInicio())<0)
				consistente=false;
		}
		return consistente;
	}
	
	public SortedSet<ProgramaTV> sugerencias(SugerenciasTV seleccion){
		return this.sugerencias(seleccion);
	}

}
