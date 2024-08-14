package prConcesionario;

public class Coche {
	private String modelo;
	private int ref;
	private double precioBase;
	private static double precioMat=100;
	private static double porcIVA=10;
	private static int nref=0;
	
	public Coche (String m, double p) {
		if (m=="")
			throw new RuntimeException ("Debe especificar el modelo");
		else
			modelo=m;
		if(p<0)
			throw new RuntimeException ("El precio no puede ser negativo");
		else
			precioBase=p;
		
		ref = nref+1;
		++nref;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public int getRef() {
		return ref;
	}
	
	public double getPrecioBase() {
		return precioBase;
	}
	
	public void setPrecioBase(double p) {
		if(p<0)
			throw new RuntimeException ("El precio no puede ser negativo");
		else
			precioBase=p;
	}
	
	public static double getGastosMatriculacion() {
		return precioMat;
	}
	
	public static double getIVA() {
		return porcIVA;
	}
	
	public static void setIVA(double d) {
		porcIVA=d;
	}
	
	public double calcPrecioFinal() {
		return (precioBase + precioMat)*((100+porcIVA)/100);
	}
	
	@Override
	public String toString() {
		return "(" + ref + "," + modelo + "," + calcPrecioFinal();
	}
}
