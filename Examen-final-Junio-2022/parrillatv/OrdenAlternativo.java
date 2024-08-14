package parrillatv;
import java.util.*;

public class OrdenAlternativo implements Comparator<ProgramaTV>{
	public int compare(ProgramaTV p1, ProgramaTV p2) {
		int res=p1.getNombre().compareToIgnoreCase(p2.getNombre());
		if(res==0)
			res=Integer.compare(p1.getDuracion(), p1.getDuracion());
		else if(res==0)
			res=p1.getHoraInicio().compareTo(p2.getHoraInicio());
		return res;
	}
	
}
