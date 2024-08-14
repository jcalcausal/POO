import jarras.Mesa;

public class EjemploUsoMesa1 {

	public static void main(String[] args) {
		Mesa m1= new Mesa(7,5);
		m1.llena(2);
		System.out.println(m1);
		m1.llenaDesde(2);
		System.out.println(m1);
		m1.llena(2);
		System.out.println(m1);
		m1.llenaDesde(2);
		System.out.println(m1);
		m1.vacia(1);
		System.out.println(m1);
		m1.llenaDesde(2);
		System.out.println(m1);
		m1.llena(2);
		System.out.println(m1);
		m1.llenaDesde(2);
		System.out.println(m1);
	}

}
