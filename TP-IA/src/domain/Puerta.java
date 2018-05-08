package domain;

public class Puerta {

	private int numeroPuerta;
	private int[] posicionIngreso = new int[2]; 
	private int[] posicionEngreso = new int[2];
	
	public Puerta(int numeroPuerta, int[] posicionIngreso, int[] posicionEngreso) {
		super();
		this.numeroPuerta = numeroPuerta;
		this.posicionIngreso = posicionIngreso;
		this.posicionEngreso = posicionEngreso;
	}

	public Puerta() {
		// TODO Auto-generated constructor stub
	}

	public int getNumeroPuerta() {
		return numeroPuerta;
	}

	public void setNumeroPuerta(int numeroPuerta) {
		this.numeroPuerta = numeroPuerta;
	}

	public int[] getPosicionIngreso() {
		return posicionIngreso;
	}

	public void setPosicionIngreso(int[] posicionIngreso) {
		this.posicionIngreso = posicionIngreso;
	}

	public int[] getPosicionEngreso() {
		return posicionEngreso;
	}

	public void setPosicionEngreso(int[] posicionEngreso) {
		this.posicionEngreso = posicionEngreso;
	}
	
	// metodo clone 
	
	public Puerta clone(){
		Puerta newPuerta = new Puerta();
		
		newPuerta.setNumeroPuerta(this.getNumeroPuerta());
		newPuerta.setPosicionIngreso(this.getPosicionIngreso().clone());
		newPuerta.setPosicionEngreso(this.getPosicionEngreso().clone());
		
		return newPuerta;
	}
}
