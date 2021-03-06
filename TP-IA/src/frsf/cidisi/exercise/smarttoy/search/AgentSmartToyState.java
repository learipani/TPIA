package frsf.cidisi.exercise.smarttoy.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import auxiliar.CreacionHabitaciones;

import domain.Habitacion;
import domain.Puerta;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.datastructure.Pair;

/**
 * Represent the internal state of the Agent.
 */

public class AgentSmartToyState extends SearchBasedAgentState {
	//Variables global
	//Variables privadas
    private Pair<Habitacion, int[]> ubicacionAgente;
    int numeroHabitacionSmartPhone;
    private List<Integer> habitacionesVisitadas;
	private List<String> estadosProbados;
	private List<Habitacion> plano;
	private boolean[] orientacion;
	private double tiempo;
	private int celdasVisitadas ;
	private int[] ubicacionObjetivoParaHeuristica ; 


	public AgentSmartToyState() {
    	ubicacionAgente = new Pair<Habitacion, int[]>(new Habitacion(),  new int[2]);
    	habitacionesVisitadas = new ArrayList<Integer>();
    	estadosProbados = new ArrayList<String>();
        plano = new ArrayList<Habitacion>();
    	orientacion = new boolean[4];
    	celdasVisitadas=0;
    	tiempo = 0.0;
    	
    	this.initState();
	}

	/**
     * This method clones the state of the agent. It's used in the search
     * process, when creating the search tree.
     */
    @Override
    public SearchBasedAgentState clone() {
        
    	AgentSmartToyState newAgentSmartToyState = new AgentSmartToyState();
    	
    	newAgentSmartToyState.setNumeroHabitacionSmartPhone(this.getNumeroHabitacionSmartPhone());
    	newAgentSmartToyState.setTiempo(this.getTiempo());
    	newAgentSmartToyState.setCeldasVisitadas(this.getCeldasVisitadas());
    	
    	int[] newUbicacionObjetivoParaHeuristica = new int[2];
    	newUbicacionObjetivoParaHeuristica[0] = this.getUbicacionObjetivoParaHeuristica()[0];
    	newUbicacionObjetivoParaHeuristica[1] = this.getUbicacionObjetivoParaHeuristica()[1];
    	newAgentSmartToyState.setUbicacionObjetivoParaHeuristica(newUbicacionObjetivoParaHeuristica);
    	
    	newAgentSmartToyState.setOrientacion(this.getOrientacion().clone());
    	
    	Pair<Habitacion, int[]> newUbicacionAgente = new Pair<Habitacion, int[]>(null, null);
    	Habitacion newHabitacion = this.getUbicacionAgente().getFirst().clone();
    	int[] newUbicacionEnHab = new int[2];
    	newUbicacionEnHab[0]=this.getUbicacionAgente().getSecond()[0];
    	newUbicacionEnHab[1]=this.getUbicacionAgente().getSecond()[1];
    	newUbicacionAgente.setFirst(newHabitacion);
    	newUbicacionAgente.setSecond(newUbicacionEnHab);
    	newAgentSmartToyState.setUbicacionAgente(newUbicacionAgente);
    	
    	//Los atributos que son objetos (los arrays tambi�n son de tipo objeto) se pasan por
    	//referencia; luego, es necesario clonarlos
    	List<Habitacion> newPlano = new ArrayList<Habitacion>();
    	for(Habitacion h : this.getPlano())
    		newPlano.add(h.clone());
    	newAgentSmartToyState.setPlano(newPlano);
    	
    	List<Integer> newHabitacionesVisitadas = new ArrayList<Integer>();
    	for(Integer h : this.getHabitacionesVisitadas())
    		newHabitacionesVisitadas.add(h);
    	newAgentSmartToyState.setHabitacionesVisitadas(newHabitacionesVisitadas);
    	
    	List<String> newEstadosProbados = new ArrayList<String>();
    	for(String s : this.getEstadosProbados())
    		newEstadosProbados.add(s);
    	newAgentSmartToyState.setEstadosProbados(newEstadosProbados);
    	
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
			for(Habitacion h : plano){
				if(h.getIdHabitacion()==habitacionAgente.getIdHabitacion()){
					h.getPlanoHabitacion()[celdaArriba[0]][celdaArriba[1]] = agentSmartToyPerception.getSensorfrontal();
					h.getPlanoHabitacion()[celdaAbajo[0]][celdaAbajo[1]] = agentSmartToyPerception.getSensortrasero();
					h.getPlanoHabitacion()[celdaIzquierda[0]][celdaIzquierda[1]] = agentSmartToyPerception.getSensorlateralizquierdo();
					h.getPlanoHabitacion()[celdaDerecha[0]][celdaDerecha[1]] = agentSmartToyPerception.getSensorlateralderecho();
				}
			}
			break;
		case 'O':
			for(Habitacion h : plano){
				if(h.getIdHabitacion()==habitacionAgente.getIdHabitacion()){
					h.getPlanoHabitacion()[celdaIzquierda[0]][celdaIzquierda[1]] = agentSmartToyPerception.getSensorfrontal();
					h.getPlanoHabitacion()[celdaDerecha[0]][celdaDerecha[1]] = agentSmartToyPerception.getSensortrasero();
					h.getPlanoHabitacion()[celdaAbajo[0]][celdaAbajo[1]] = agentSmartToyPerception.getSensorlateralizquierdo();
					h.getPlanoHabitacion()[celdaArriba[0]][celdaArriba[1]] = agentSmartToyPerception.getSensorlateralderecho();
				}
			}
			break;
		case 'S':
			for(Habitacion h : plano){
				if(h.getIdHabitacion()==habitacionAgente.getIdHabitacion()){
					h.getPlanoHabitacion()[celdaAbajo[0]][celdaAbajo[1]] = agentSmartToyPerception.getSensorfrontal();
					h.getPlanoHabitacion()[celdaArriba[0]][celdaArriba[1]] = agentSmartToyPerception.getSensortrasero();
					h.getPlanoHabitacion()[celdaDerecha[0]][celdaDerecha[1]] = agentSmartToyPerception.getSensorlateralizquierdo();
					h.getPlanoHabitacion()[celdaIzquierda[0]][celdaIzquierda[1]] = agentSmartToyPerception.getSensorlateralderecho();
				}
			}
			break;
		case 'E':
			for(Habitacion h : plano){
				if(h.getIdHabitacion()==habitacionAgente.getIdHabitacion()){
					h.getPlanoHabitacion()[celdaDerecha[0]][celdaDerecha[1]] = agentSmartToyPerception.getSensorfrontal();
					h.getPlanoHabitacion()[celdaIzquierda[0]][celdaIzquierda[1]] = agentSmartToyPerception.getSensortrasero();
					h.getPlanoHabitacion()[celdaArriba[0]][celdaArriba[1]] = agentSmartToyPerception.getSensorlateralizquierdo();
					h.getPlanoHabitacion()[celdaAbajo[0]][celdaAbajo[1]] = agentSmartToyPerception.getSensorlateralderecho();
				}
			}
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
    	this.ubicacionAgente.setFirst(this.getPlano().get(8)); //Habitacion .get(HABITACION)
    	this.ubicacionAgente.setSecond(new int[]{45,5}); //Posicion dentro de la habitaci�n {FILA, COLUMNA})
    	setAgentStringInPlano();
    	
    	//Agrega la habitacion actual a las habitaciones visitadas
    	habitacionesVisitadas.add(ubicacionAgente.getFirst().getIdHabitacion());
    	
    	//Setea la orientaci�n inicial del agente
    	orientacion[0] = false;
    	orientacion[1] = false;
    	orientacion[2] = false;
    	orientacion[3] = true;
    	
    	//Agrega el estadoProbado actual
    	estadosProbados.add(Integer.toString(this.ubicacionAgente.getSecond()[0])+Integer.toString(this.ubicacionAgente.getSecond()[1])+this.getCharOrientacion());
    	
    	//setea posicion para calcular heuristica
    	this.setUbicacionObjetivoParaHeuristica(this.getUbicacionAgente().getFirst().getUbicacionCentralGlobal());
    	
    	//Setea el n�mero de habitacion donde est� el smartphone
    	this.numeroHabitacionSmartPhone = 5;

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
        str += "\nCosto: "+ getTiempo();
        
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
       
    	//Dos estados son iguales si se encuentran en la misma habitacion, y en la misma posicion y con la misma orientacion

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

	public List<Integer> getHabitacionesVisitadas() {
		return habitacionesVisitadas;
	}

	public void setHabitacionesVisitadas(List<Integer> habitacionesVisitadas) {
		this.habitacionesVisitadas = habitacionesVisitadas;
	}
	
	public void addHabitacionesVisitadas(Integer habitacionVisitada) {
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
	public void setEstadosProbados(List<String> estadosProbados) {
		this.estadosProbados = estadosProbados;
	}
	
	public double getTiempo() {
			return tiempo;
	}

	public void setTiempo(double tiempo) {
			this.tiempo = tiempo;
	}
	
	public int getCeldasVisitadas() {
		return celdasVisitadas;
	}

	public void setCeldasVisitadas(int celdasVisitadas) {
		this.celdasVisitadas = celdasVisitadas;
	}
	
	public int[] getUbicacionObjetivoParaHeuristica() {
		return ubicacionObjetivoParaHeuristica;
	}

	public void setUbicacionObjetivoParaHeuristica(
			int[] ubicacionObjetivoParaHeuristica) {
		this.ubicacionObjetivoParaHeuristica = ubicacionObjetivoParaHeuristica;
	}
	
}

