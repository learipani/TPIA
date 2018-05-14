package frsf.cidisi.exercise.smarttoy.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import auxiliar.CreacionHabitaciones;

import domain.Habitacion;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.datastructure.Pair;

/**
 * Represent the internal state of the Agent.
 */
public class AgentSmartToyState extends SearchBasedAgentState {
	
    private Pair<Habitacion, int[]> ubicacionAgente;
    int numeroHabitacionSmartPhone;
    private List<Habitacion> habitacionesVisitadas;
	private List<String> estadosProbados;
	private List<Habitacion> plano;
	private boolean[] orientacion;

	
	
    public AgentSmartToyState() {
    	ubicacionAgente = new Pair<Habitacion, int[]>(new Habitacion(),  new int[2]);
    	habitacionesVisitadas = new ArrayList<Habitacion>();
    	estadosProbados = new ArrayList<String>();
        plano = new ArrayList<Habitacion>();
    	orientacion = new boolean[4];
    	
    	this.initState();
	}



	/**
     * This method clones the state of the agent. It's used in the search
     * process, when creating the search tree.
     */
    @Override
    public SearchBasedAgentState clone() {
        
    	AgentSmartToyState newAgentSmartToyState = new AgentSmartToyState();
    	
    	//Los atributos de tipo primitvos se pasan por copia(no hay)
    	newAgentSmartToyState.setNumeroHabitacionSmartPhone(this.getNumeroHabitacionSmartPhone());
    	
    	//No se si hay que clonar cada arreglo del par por separado
    	newAgentSmartToyState.setOrientacion(this.getOrientacion().clone());
    	
    	Pair<Habitacion, int[]> newUbicacionAgente = new Pair<Habitacion, int[]>(null, null);
    	newUbicacionAgente.setFirst(this.getUbicacionAgente().getFirst().clone());
    	newUbicacionAgente.setSecond(this.getUbicacionAgente().getSecond().clone());
    	newAgentSmartToyState.setUbicacionAgente(newUbicacionAgente);
    	
    	//Pair<Habitacion, int[]> newUbicacionInicial = new Pair<Habitacion, int[]>(null, null);
    	
    	//Los atributos que son objetos (los arrays tambi�n son de tipo objeto) se pasan por
    	//referencia; luego, es necesario clonarlos
    	List<Habitacion> newPlano = new ArrayList<Habitacion>();
    	for(Habitacion h : this.getPlano())
    		newPlano.add(h.clone());
    	newAgentSmartToyState.setPlano(newPlano);
    	
    	List<Habitacion> newHabitacionesVisitadas = new ArrayList<Habitacion>();
    	for(Habitacion h : this.getHabitacionesVisitadas())
    		newHabitacionesVisitadas.add(h.clone());
    	newAgentSmartToyState.setHabitacionesVisitadas(newHabitacionesVisitadas);
    	
    	for(String s : this.getEstadosProbados())
    		newAgentSmartToyState.setEstadosProbados(s);
    	
        return newAgentSmartToyState;
    }

    /**
     * This method is used to update the Agent State when a Perception is
     * received by the Simulator.
     */
    @Override
    public void updateState(Perception p) {

    	AgentSmartToyPerception agentSmartToyPerception = (AgentSmartToyPerception) p;

        Habitacion habitacionAgente = this.getUbicacionAgente().getFirst();
    	int filaEnHabitacion = this.getUbicacionAgente().getSecond()[0];
        int colEnHabitacion = this.getUbicacionAgente().getSecond()[1];
        
        //Estos vectores son relativos a la matriz, no a la orientacion del agente
        int[] celdaArriba = new int[]{filaEnHabitacion-1, colEnHabitacion};
        int[] celdaAbajo = new int[]{filaEnHabitacion+1, colEnHabitacion};
        int[] celdaIzquierda = new int[]{filaEnHabitacion, colEnHabitacion-1};
        int[] celdaDerecha = new int[]{filaEnHabitacion, colEnHabitacion+1};
        
        switch (this.getCharOrientacion()) {
		case 'N':
			habitacionAgente.getPlanoHabitacion()[celdaArriba[0]][celdaArriba[1]] = agentSmartToyPerception.getSensorfrontal();
			habitacionAgente.getPlanoHabitacion()[celdaAbajo[0]][celdaAbajo[1]] = agentSmartToyPerception.getSensortrasero();
			habitacionAgente.getPlanoHabitacion()[celdaIzquierda[0]][celdaIzquierda[1]] = agentSmartToyPerception.getSensorlateralizquierdo();
			habitacionAgente.getPlanoHabitacion()[celdaDerecha[0]][celdaDerecha[1]] = agentSmartToyPerception.getSensorlateralderecho();
			break;
		case 'O':
			habitacionAgente.getPlanoHabitacion()[celdaIzquierda[0]][celdaIzquierda[1]] = agentSmartToyPerception.getSensorfrontal();
			habitacionAgente.getPlanoHabitacion()[celdaDerecha[0]][celdaDerecha[1]] = agentSmartToyPerception.getSensortrasero();
			habitacionAgente.getPlanoHabitacion()[celdaAbajo[0]][celdaAbajo[1]] = agentSmartToyPerception.getSensorlateralizquierdo();
			habitacionAgente.getPlanoHabitacion()[celdaArriba[0]][celdaArriba[1]] = agentSmartToyPerception.getSensorlateralderecho();
			break;
		case 'S':
			habitacionAgente.getPlanoHabitacion()[celdaAbajo[0]][celdaAbajo[1]] = agentSmartToyPerception.getSensorfrontal();
			habitacionAgente.getPlanoHabitacion()[celdaArriba[0]][celdaArriba[1]] = agentSmartToyPerception.getSensortrasero();
			habitacionAgente.getPlanoHabitacion()[celdaDerecha[0]][celdaDerecha[1]] = agentSmartToyPerception.getSensorlateralizquierdo();
			habitacionAgente.getPlanoHabitacion()[celdaIzquierda[0]][celdaIzquierda[1]] = agentSmartToyPerception.getSensorlateralderecho();
			break;
		case 'E':
			habitacionAgente.getPlanoHabitacion()[celdaDerecha[0]][celdaDerecha[1]] = agentSmartToyPerception.getSensorfrontal();
			habitacionAgente.getPlanoHabitacion()[celdaIzquierda[0]][celdaIzquierda[1]] = agentSmartToyPerception.getSensortrasero();
			habitacionAgente.getPlanoHabitacion()[celdaArriba[0]][celdaArriba[1]] = agentSmartToyPerception.getSensorlateralizquierdo();
			habitacionAgente.getPlanoHabitacion()[celdaAbajo[0]][celdaAbajo[1]] = agentSmartToyPerception.getSensorlateralderecho();
			break;
		}
        this.numeroHabitacionSmartPhone = agentSmartToyPerception.getSmartphone().getIdHabitacion();
    }

    /**
     * This method is optional, and sets the initial state of the agent.
     */
    @Override
    public void initState() {
        
    	//Add de habitaciones al plano
    	this.plano.add(CreacionHabitaciones.createHabitacion1());
    	this.plano.add(CreacionHabitaciones.createHabitacion2());
    	this.plano.add(CreacionHabitaciones.createHabitacion3());
    	this.plano.add(CreacionHabitaciones.createHabitacion4());
    	this.plano.add(CreacionHabitaciones.createHabitacion5());
    	this.plano.add(CreacionHabitaciones.createHabitacion6());
    	this.plano.add(CreacionHabitaciones.createHabitacion7());
    	this.plano.add(CreacionHabitaciones.createHabitacion8());
    	this.plano.add(CreacionHabitaciones.createHabitacion9());
    	this.plano.add(CreacionHabitaciones.createHabitacion10());
    	this.plano.add(CreacionHabitaciones.createHabitacion11());
    	this.plano.add(CreacionHabitaciones.createHabitacion12());
    	this.plano.add(CreacionHabitaciones.createHabitacion13());
    	this.plano.add(CreacionHabitaciones.createHabitacion14());
    	this.plano.add(CreacionHabitaciones.createHabitacion15());
    	
    	//Setea la posicion inicial del agente
    	this.ubicacionAgente.setFirst(this.getPlano().get(0)); //Habitacion .get(HABITACION)
    	this.ubicacionAgente.setSecond(new int[]{1,1}); //Posicion dentro de la habitaci�n {FILA, COLUMNA})
    	setAgentStringInPlano();
    	
    	//Agrega la habitacion actual a las habitaciones visitadas
    	habitacionesVisitadas.add(ubicacionAgente.getFirst());
    	
    	//Setea la orientaci�n inicial del agente
    	orientacion[0] = true;
    	orientacion[1] = false;
    	orientacion[2] = false;
    	orientacion[3] = false;
    	
    	//Agrega el estadoProbado actual
    	//estadosProbados.put(new char[]{(char) this.ubicacionAgente.getSecond()[0],(char) this.ubicacionAgente.getSecond()[1], this.getCharOrientacion()}, 1);
    	estadosProbados.add(Integer.toString(this.ubicacionAgente.getSecond()[0])+Integer.toString(this.ubicacionAgente.getSecond()[1])+this.getCharOrientacion());
    	
    	//Setea el n�mero de habitacion donde est� el smartphone
    	this.numeroHabitacionSmartPhone = 1;
    	plano.get(1).getPlanoHabitacion()[1][4] = AgentSmartToyPerception.META_PERCEPTION;

    }

	/**
     * This method returns the String representation of the agent state.
     */
    @Override
    public String toString() {
        String str = "";
        str += "\nAgente en habitac�n n�mero: " + ubicacionAgente.getFirst().getIdHabitacion();
        str += "\nPosicion: [" + ubicacionAgente.getSecond()[0]+";"+ubicacionAgente.getSecond()[1]+"]";
        str += "\nOrientacion: "+ getCharOrientacion();
        
        String[][] planoAgente =  ubicacionAgente.getFirst().getPlanoHabitacion();
        str = str + "\n\nPlano=\"[ \n";
        for (int fila = 0; fila < planoAgente.length; fila++) {
            str = str + "[ ";
            for (int col = 0; col < planoAgente[fila].length; col++) {
            	if (planoAgente[fila][col] == null ) {
                    str = str + AgentSmartToyPerception.UNKNOWN_PERCEPTION;
                } else {
                    str = str + planoAgente[fila][col] + " ";
                }
            }
            str = str + " ]\n";
        }
        str = str + " ]\"";
    
        return str;
    }


    /**
     * This method is used in the search process to verify if the node already
     * exists in the actual search.
     */
    @Override
    public boolean equals(Object obj) {
       
    	//Dos estados son iguales si se encuentran en la misma habitacion, y en la misma posicion
    	//se puede contemplar si la lista de habitaciones visitadas es la misma,
    	//pero en este momento no hay un metodo que diga las habitaciones visitadas    	

    	AgentSmartToyState estadoComparado = (AgentSmartToyState)obj;
    	
    	Habitacion habitacionActual= estadoComparado.getUbicacionAgente().getFirst();//obtiene la habitacion actual
    	int[] posicionActual = estadoComparado.getUbicacionAgente().getSecond();//obtiene la posicion en la habitacion actual
    	boolean[] orientacionActual = estadoComparado.getOrientacion(); // obtiene la orientacion actual
    	
    	boolean mismaHabitacionActual = false;
    	boolean mismaPosicion = false;
    	boolean mismaOrientacion = false;
    	
        //compara habitacion actual
    	if(habitacionActual.getIdHabitacion() == this.getUbicacionAgente().getFirst().getIdHabitacion()){
    		mismaHabitacionActual = true;
    	};
    	//compara posicion actual
    	if(posicionActual.equals(this.getUbicacionAgente().getSecond())){
    		mismaPosicion=true;
    	}
    	//compara la orientacion actual
    	if(orientacionActual.equals(this.getOrientacion())){
    		mismaOrientacion = true;
    	}
   
        return (mismaHabitacionActual && mismaPosicion && mismaOrientacion);
    }

	public Pair<Habitacion, int[]> getUbicacionAgente() {
		return ubicacionAgente;
	}

	public void setUbicacionAgente(Pair<Habitacion, int[]> ubicacionAgente) {
		this.ubicacionAgente = ubicacionAgente;
	}

	public List<Habitacion> getPlano() {
		return plano;
	}

	public void setPlano(List<Habitacion> plano) {
		this.plano = plano;
	}

	public List<Habitacion> getHabitacionesVisitadas() {
		return habitacionesVisitadas;
	}

	public void setHabitacionesVisitadas(List<Habitacion> habitacionesVisitadas) {
		this.habitacionesVisitadas = habitacionesVisitadas;
	}
	
	public void addHabitacionesVisitadas(Habitacion habitacionVisitada) {
		this.habitacionesVisitadas.add(habitacionVisitada);
	}

	public boolean[] getOrientacion() {
		return orientacion;
	}

	public void setOrientacion(boolean[] orientacion) {
		this.orientacion = orientacion;
	}
	
	public int getNumeroHabitacionSmartPhone() {
		return numeroHabitacionSmartPhone;
	}

	public void setNumeroHabitacionSmartPhone(int numeroHabitacionSmartPhone) {
		this.numeroHabitacionSmartPhone = numeroHabitacionSmartPhone;
	}
	
/*	public HashMap<char[], Integer> getEstadosProbados() {
		return estadosProbados;
	}

	public void setEstadosProbados(HashMap<char[], Integer> estadosProbados) {
		this.estadosProbados = estadosProbados;
	}*/
	
	public char getCharOrientacion() {
		char orientacion;
		if( this.orientacion[0] == true ){
			orientacion = 'N';
	    }
	    else{
	    	if( this.orientacion[1] == true ){
				orientacion = 'O';
		    }
		    else{
		    	if( this.orientacion[2] == true ){
					orientacion = 'S';
			    }
			    else{
			    	orientacion = 'E';
			    }
		    }
	    }
		return orientacion;
	}
	
	public void setAgentStringInPlano(){
		int filaLlamado = ubicacionAgente.getSecond()[0];
		int columnaLlmado = ubicacionAgente.getSecond()[1] ;
		plano.get(ubicacionAgente.getFirst().getIdHabitacion()-1).getPlanoHabitacion()[filaLlamado][columnaLlmado] = "||";
	}
	
	 public List<String> getEstadosProbados() {
			return estadosProbados;
		}



		public void setEstadosProbados(String estadodProbado) {
			this.estadosProbados.add(estadodProbado);
		}
}

