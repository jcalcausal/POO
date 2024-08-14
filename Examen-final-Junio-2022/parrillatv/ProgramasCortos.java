package parrillatv;

import java.util.*;
import java.util.Collection;
import java.util.SortedSet;

public class ProgramasCortos implements Sugerencias{
	private int durMaxima;
	
	public ProgramasCortos(int n) {
		durMaxima=n;
	}
	
	public SortedSet<ProgramaTV> sugerencias (Collection<ProgramaTV> progs){
		SortedSet<ProgramaTV> res;
		Comparator<ProgramaTV> op= new OrdenAlternativo();
		for(ProgramaTV t: progs) {
			if(t.getDuracion()<durMaxima) {
				res.add(t);
			}
		}
	}

}
