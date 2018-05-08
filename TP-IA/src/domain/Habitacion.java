package domain;


import java.util.ArrayList;
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
	
	
	public Habitacion() {
		// TODO Auto-generated constructor stub
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
	
	//Metodo clone para poder clonar AgentSmartToyState (no estoy seguro si hay que clonar todo por separado)
	
	public Habitacion clone(){
		Habitacion newHabitacion = new Habitacion();
		
		newHabitacion.setIdHabitacion(this.getIdHabitacion());
		
		List<Pair<Habitacion, Puerta>> newHabitacionesContiguas = new ArrayList<Pair<Habitacion, Puerta>>();
		for(Pair<Habitacion, Puerta> p : this.getHabitacionesContiguas()){
			Pair<Habitacion, Puerta> habitacionContigua = new Pair<Habitacion, Puerta>(null, null); 
			habitacionContigua.setFirst(p.getFirst().clone());
			habitacionContigua.setSecond(p.getSecond().clone());
			newHabitacionesContiguas.add(habitacionContigua);
		}
		newHabitacion.setHabitacionesContiguas(newHabitacionesContiguas);
		
		newHabitacion.setTamano(this.getTamano().clone());
		
		List<Objeto> newObjetos = new ArrayList<Objeto>();
		for(Objeto objeto : this.getObjetos()){
			newObjetos.add(objeto.clone());
		}
		newHabitacion.setObjetos(newObjetos);
		
		return newHabitacion;
	}
	
}
