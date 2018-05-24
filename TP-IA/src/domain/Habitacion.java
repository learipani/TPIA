package domain;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import frsf.cidisi.exercise.smarttoy.search.AgentSmartToyPerception;
import frsf.cidisi.faia.state.datastructure.Pair;

public class Habitacion {

	/*Manejo de listas en Java:
	 * http://panamahitek.com/el-uso-de-listas-en-java/
	 * */
	
	private int idHabitacion;
	private String[][] planoHabitacion; 
	private List<Pair<Integer, List<Puerta>>> habitacionesContiguas;
	private List<Objeto> objetos;
	private int[] ubicacionCentralGlobal;
	private int[] ubicacionCentralLocal;

	public Habitacion(int idHabitacion, String[][] planoHabitacion,
			List<Pair<Integer, List<Puerta>>> habitacionesContiguas,
			List<Objeto> objetos) {
		super();
		this.idHabitacion = idHabitacion;
		this.planoHabitacion = planoHabitacion;
		this.habitacionesContiguas = habitacionesContiguas;
		this.objetos = objetos;
	}
	
	public Habitacion() {
	}

	public int getIdHabitacion() {
		return idHabitacion;
	}

	public void setIdHabitacion(int idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	public List<Pair<Integer, List<Puerta>>> getHabitacionesContiguas() {
		return habitacionesContiguas;
	}

	public void setHabitacionesContiguas(
			List<Pair<Integer, List<Puerta>>> habitacionesContiguas) {
		this.habitacionesContiguas = habitacionesContiguas;
	}
	
	public void addHabitacionContigua(Pair<Integer, List<Puerta>> habitacionContigua) {
		this.habitacionesContiguas.add(habitacionContigua);
	}

	

	public List<Objeto> getObjetos() {
		return objetos;
	}

	public void setObjetos(List<Objeto> objetos) {
		this.objetos = objetos;
	}
	
	public void addObjeto(Objeto objeto) {
		this.objetos.add(objeto);
	}
	
	public String[][] getPlanoHabitacion() {
		return planoHabitacion;
	}
	
	public void setPlanoHabitacion(String[][] planoHabitacion) {
		this.planoHabitacion = planoHabitacion;
	}
	
	public void addPlanoHabitacion(String ob, int fila, int columna) {
		this.planoHabitacion[fila][columna] = ob;
	}
	
	public void removePlanoHabitacion(int fila, int columna) {
		this.planoHabitacion[fila][columna] = null;
	}
	
	public int[] getUbicacionCentralGlobal() {
		return ubicacionCentralGlobal;
	}

	public void setUbicacionCentralGlobal(int[] ubicacionCentralGlobal) {
		this.ubicacionCentralGlobal = ubicacionCentralGlobal;
	}
	
	public int[] getUbicacionCentralLocal() {
		return ubicacionCentralLocal;
	}

	public void setUbicacionCentralLocal(int[] ubicacionCentralLocal) {
		this.ubicacionCentralLocal = ubicacionCentralLocal;
	}
	
	//Metodo clone para poder clonar AgentSmartToyState
	public Habitacion clone(){
		Habitacion newHabitacion = new Habitacion();
		
		//clonacion id
		newHabitacion.setIdHabitacion(this.getIdHabitacion());
		
		//ubicacion Central global Para Heuristica
		int[] newUbicacionCentralGlobal = new int[2];
		newUbicacionCentralGlobal[0]=this.getUbicacionCentralGlobal()[0];
		newUbicacionCentralGlobal[1]=this.getUbicacionCentralGlobal()[1];
		newHabitacion.setUbicacionCentralGlobal(newUbicacionCentralGlobal);
		
		//ubicacion Central local Para Heuristica
		int[] newUbicacionCentralLocal = new int[2];
		newUbicacionCentralLocal[0]=this.getUbicacionCentralLocal()[0];
		newUbicacionCentralLocal[1]=this.getUbicacionCentralLocal()[1];
		newHabitacion.setUbicacionCentralLocal(newUbicacionCentralLocal);
		
		//clonacion habitacionescontiguas
		List<Pair<Integer, List<Puerta>>> newHabitacionesContiguas = new ArrayList<Pair<Integer, List<Puerta>>>();
		for(Pair<Integer, List<Puerta>> p : this.getHabitacionesContiguas()){
			Pair<Integer, List<Puerta>> habitacionContigua = new Pair<Integer, List<Puerta>>(null, null); 
			habitacionContigua.setFirst(p.getFirst());
			List<Puerta> newListaPuertas = new ArrayList<Puerta>();
			for(Puerta i : p.getSecond()){
				newListaPuertas.add(i.clone()); 
			}
			habitacionContigua.setSecond(newListaPuertas);
			newHabitacionesContiguas.add(habitacionContigua);
		}
		newHabitacion.setHabitacionesContiguas(newHabitacionesContiguas);
		
		//clonacion matriz
		int fila = this.planoHabitacion.length;
		int col = this.planoHabitacion[0].length;
		String[][] newPlanoHabitacion = new String[fila][col];
		//La linea de abajo reemplazaria el for si es que funciona bien el clone() para matrices
		//newPlanoHabitacion = this.planoHabitacion.clone();
		for(int i=0;i<fila;i++){
			for(int j=0;j<col;j++){
				newPlanoHabitacion[i][j]= this.planoHabitacion[i][j]; 
			}
		}
		newHabitacion.setPlanoHabitacion(newPlanoHabitacion);
		
		//clonacion lista objetos
		List<Objeto> newObjetos = new ArrayList<Objeto>();
		for(Objeto objeto : this.getObjetos()){
			newObjetos.add(objeto.clone());
		}
		newHabitacion.setObjetos(newObjetos);
		
		return newHabitacion;
	}
	
	public void ActualizarPlanoHabitacion(int[] tamano){

		int x;
		int y;
		//Antes que nada, lleno todas las celdas con nada
		for (int row = 0; row < tamano[0]; row++) {
            for (int col = 0; col < tamano[1]; col++) {
            	planoHabitacion[row][col] = AgentSmartToyPerception.EMPTY_PERCEPTION;
            }
        }
		
		//Itero todas las puertas y las pongo en el plano
		for (Iterator<Pair<Integer, List<Puerta>>> i = habitacionesContiguas.iterator(); i.hasNext();) {
			Pair<Integer, List<Puerta>> item = i.next();
			
			for (Iterator<Puerta> j = item.getSecond().iterator(); j.hasNext();) {
				Puerta itemPuerta = j.next();
				x = itemPuerta.getPosicionIngreso()[0];
				y = itemPuerta.getPosicionIngreso()[1];
				planoHabitacion[x][y] = AgentSmartToyPerception.PUERTA_PERCEPTION;

			}
		}
		//Itero todos los objetos y los pongo en el plano
		for (Iterator<Objeto> it = objetos.iterator(); it.hasNext();) {
			Objeto item = it.next();
			String claseObjeto;
			//Segun el tipo de objeto se carga el string correspondiente
			switch(item.getTipoObjeto()){
			case 1:
				claseObjeto = AgentSmartToyPerception.OBSTACULO_PERCEPTION;
				break;
			case 2:
				claseObjeto = AgentSmartToyPerception.PISO_ARENA;
				break;
			case 3:
				claseObjeto = AgentSmartToyPerception.PISO_BASURA;
				break;
			case 4:
				claseObjeto = AgentSmartToyPerception.PISO_ALFOMBRA;
				break;
			case 5:
				claseObjeto = AgentSmartToyPerception.PISO_MOJADO;
				break;
			case 6:
				claseObjeto = AgentSmartToyPerception.ESCALERA;
				break;
			case 7:
				claseObjeto = AgentSmartToyPerception.PARED;
				break;
			default: 
				claseObjeto = AgentSmartToyPerception.UNKNOWN_PERCEPTION;
				break;
			}
			//Recorro el objeto y voy actualizando el plano
			for (int i = 0; i < item.getTamano()[0]; i++) {
				for (int j = 0; j < item.getTamano()[1]; j++) {
					x = item.getUbicacionEnHabitacion()[0] + i;
					y = item.getUbicacionEnHabitacion()[1] + j;
					planoHabitacion[x][y] = claseObjeto;
				}
			}
		}
	}
	
}
