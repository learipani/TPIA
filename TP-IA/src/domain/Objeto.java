package domain;

import java.util.ArrayList;
import java.util.List;

import frsf.cidisi.faia.state.datastructure.Pair;

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
	
	// metodo clone (hacerlo)
	
	public Objeto clone(){
		Objeto newObjeto = new Objeto();
		
		return newObjeto;
	}
}
