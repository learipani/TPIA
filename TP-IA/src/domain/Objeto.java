package domain;

public class Objeto {

	protected int idHabitacion;
	protected int[] tamano = new int[2];
	protected int[] ubicacionEnHabitacion = new int[2];
	
	
	
    protected Objeto(int idHabitacion, int[] tamano, int[] ubicacionEnHabitacion) {
		super();
		this.idHabitacion = idHabitacion;
		this.tamano = tamano;
		this.ubicacionEnHabitacion = ubicacionEnHabitacion;
	}
    
	public Objeto() {
		// TODO Auto-generated constructor stub
	}

	public int getIdHabitacion() {
		return idHabitacion;
	}

	public void setIdHabitacion(int idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	public int[] getTamano() {
		return tamano;
	}

	public void setTamano(int[] tamano) {
		this.tamano = tamano;
	}

	public int[] getUbicacionEnHabitacion() {
		return ubicacionEnHabitacion;
	}

	public void setUbicacionEnHabitacion(int[] ubicacionEnHabitacion) {
		this.ubicacionEnHabitacion = ubicacionEnHabitacion;
	}
	
	// metodo clone
	
	public Objeto clone(){
		Objeto newObjeto = new Objeto();
		
		newObjeto.setIdHabitacion(this.getIdHabitacion());
		newObjeto.setTamano(this.getTamano().clone());
		newObjeto.setUbicacionEnHabitacion(this.getUbicacionEnHabitacion().clone());
		
		return newObjeto;
	}
}
