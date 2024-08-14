package dados;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class Dado {
	private static Random aleat= new Random();
	private int cara;
	
	public Dado() {
		agita();
	}
	
	public void agita() {
		cara= aleat.nextInt(6)+1;
	}
	
}
