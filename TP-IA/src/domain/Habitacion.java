package domain;


import java.util.ArrayList;
import java.util.Iterator;
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
	private String[][] planoHabitacion; 
	private List<Pair<Integer, List<Puerta>>> habitacionesContiguas;
	private List<Objeto> objetos;

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
		// TODO Auto-generated constructor stub
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
	
	//Metodo clone para poder clonar AgentSmartToyState (no estoy seguro si hay que clonar todo por separado)
	
	public Habitacion clone(){
		Habitacion newHabitacion = new Habitacion();
		
		newHabitacion.setIdHabitacion(this.getIdHabitacion());
		
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
		
		newHabitacion.setTamano(this.getTamano().clone());
		
		List<Objeto> newObjetos = new ArrayList<Objeto>();
		for(Objeto objeto : this.getObjetos()){
			newObjetos.add(objeto.clone());
		}
		newHabitacion.setObjetos(newObjetos);
		
		return newHabitacion;
	}
	
	public void ActualizarPlanoHabitacion(){
		/*private List<Pair<Integer, List<Puerta>>> habitacionesContiguas;
		private List<Objeto> objetos;*/
		//Itero todas las puertas y las pongo en el plano
		for (Iterator<Pair<Integer, List<Puerta>>> i = habitacionesContiguas.iterator(); i.hasNext();) {
			Pair<Integer, List<Puerta>> item = i.next();
			Puerta puertaAux = (Puerta)item.getSecond();
			planoHabitacion[puertaAux.getPosicionIngreso()[0]][puertaAux.getPosicionIngreso()[1]] = "pu"; 
		}
		//Itero todos los objetos y los pongo en el plano
		for (Iterator<Objeto> it = objetos.iterator(); it.hasNext();) {
			Objeto item = it.next();
			String claseObjeto;
			//Me fijo que tipo de objeto es el que tengo y lo guardo en una variable
			if(item.getClass().getName() == "Obstaculo"){
				claseObjeto = "ob";
			}
			else{
				if(item.getClass().getName() == "TerrenoAdverso"){
					claseObjeto = "ta";
				}
				else{
					claseObjeto = "uk";
				}
			}
			//Recorro el objeto y voy actualizando el plano
			for (int i = 0; i < item.getTamano()[0]; i++) {
				for (int j = 0; j < item.getTamano()[1]; j++) {
					planoHabitacion[i][j] = claseObjeto;
				}
			}
		}
	}
	
}
