package jarras;

public class Mesa {
	private Jarra jarra1;
	private Jarra jarra2;

	public Mesa (Jarra jarra1, Jarra jarra2) {
		if(jarra1==jarra2) {
			throw new RuntimeException("Las dos jarras no pueden ser la misma");
		}
		this.jarra1=jarra1;
		this.jarra2=jarra2;
	}
	
	public Mesa(int capacidad1, int capacidad2) {
		jarra1 = new Jarra(capacidad1);
		jarra2 = new Jarra(capacidad2);
	}
	
	public int capacidad (int njarra) {
		if(njarra==1) {
			return jarra1.capacidad();
		}
		else if(njarra==2) {
			return jarra2.capacidad();
		}
		else
			throw new RuntimeException("Solo hay dos jarras");
	}
	
	public int contenido (int njarra) {
		if(njarra==1) {
			return jarra1.contenido();
		}
		else if(njarra==2) {
			return jarra2.contenido();
		}
		else
			throw new RuntimeException("Solo hay dos jarras");
	}
	
	public void llena(int njarra) {
		if(njarra==1) {
			jarra1.llena();
		}
		else if(njarra==2) {
			jarra2.llena();
		}
		else
			throw new RuntimeException("Solo hay dos jarras");
	}
	
	public void vacia(int njarra) {
		if(njarra==1) {
			jarra1.vacia();
		}
		else if(njarra==2) {
			jarra2.vacia();
		}
		else
			throw new RuntimeException("Solo hay dos jarras");
	}
	
	public void llenaDesde(int njarra) {
		if(njarra==1) {
			jarra2.llenaDesde(jarra1);
		}
		else if(njarra==2) {
			jarra1.llenaDesde(jarra2);
		}
		else
			throw new RuntimeException("Solo hay dos jarras");
	}
	
	@Override
	public String toString() {
		return "M("+jarra1.toString()+","+jarra2.toString()+")";
	}
}
