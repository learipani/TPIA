package domain;

import java.util.List;
import frsf.cidisi.faia.state.datastructure.Pair;

public class Habitacion {

	/*Aca preguntar para que son los DataStructure 
	 * del paquete datastructure del proyecto faia y si tenemos
	 * que usar esos o podemos usar la libreria util.List
	 * */

	/*Manejo de listas en Java:
	 * http://panamahitek.com/el-uso-de-listas-en-java/
	 * */
	
	private int idHabitacion;
	private List<Pair<Habitacion, Puerta>> habitacionesContiguas;
	private int[] tamano;
	private List<Objeto> objetos;
	
	protected Habitacion(int idHabitacion,
			List<Pair<Habitacion, Puerta>> habitacionesContiguas, int[] tamano,
			List<Objeto> objetos) {
		super();
		this.idHabitacion = idHabitacion;
		this.habitacionesContiguas = habitacionesContiguas;
		this.tamano = tamano;
		this.objetos = objetos;
	}
	
	public int getIdHabitacion() {
		return idHabitacion;
	}

	public void setIdHabitacion(int idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	public List<Pair<Habitacion, Puerta>> getHabitacionesContiguas() {
		return habitacionesContiguas;
	}

	public void setHabitacionesContiguas(
			List<Pair<Habitacion, Puerta>> habitacionesContiguas) {
		this.habitacionesContiguas = habitacionesContiguas;
	}

	public int[] getTamano() {
		return tamano;
	}

	public void setTamano(int[] tamano) {
		this.tamano = tamano;
	}

	public List<Objeto> getObjetos() {
		return objetos;
	}

	public void setObjetos(List<Objeto> objetos) {
		this.objetos = objetos;
	}
	
}
