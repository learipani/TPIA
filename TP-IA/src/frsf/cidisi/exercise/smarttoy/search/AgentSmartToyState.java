package frsf.cidisi.exercise.smarttoy.search;

import java.util.ArrayList;
import java.util.List;

import domain.Habitacion;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.datastructure.Pair;

/**
 * Represent the internal state of the Agent.
 */
public class AgentSmartToyState extends SearchBasedAgentState {
	
    private Pair<Habitacion, int[]> ubicacionAgente;
    private Pair<Habitacion, int[]> ubicacionInicial;
    private List<Habitacion> plano;
	private boolean[] orientacion = new boolean[4];

	public AgentSmartToyState(
			Pair<Habitacion, int[]> ubicacionAgente,
			Pair<Habitacion, int[]> ubicacionInicial, 
			List<Habitacion> plano,
			boolean[] orientacion) {
		super();
		this.ubicacionAgente = ubicacionAgente;
		this.ubicacionInicial = ubicacionInicial;
		this.plano = plano;
		this.orientacion = orientacion;
	}
	
    public AgentSmartToyState() {
		// TODO Auto-generated constructor stub
	}

	/**
     * This method clones the state of the agent. It's used in the search
     * process, when creating the search tree.
     */
    @Override
    public SearchBasedAgentState clone() {
        
		//TODO: Complete Method
    	AgentSmartToyState newAgentSmartToyState = new AgentSmartToyState();
    	
    	//Los atributos de tipo primitvos se pasan por copia(no hay)
    	
    	//No se si hay que clonar cada arreglo del par por separado
    	newAgentSmartToyState.setOrientacion(this.getOrientacion().clone());
    	
    	Pair<Habitacion, int[]> newUbicacionAgente = new Pair<Habitacion, int[]>(null, null);
    	newUbicacionAgente.setFirst(this.getUbicacionAgente().getFirst().clone());
    	newUbicacionAgente.setSecond(this.getUbicacionAgente().getSecond().clone());
    	newAgentSmartToyState.setUbicacionAgente(newUbicacionAgente);
    	
    	Pair<Habitacion, int[]> newUbicacionInicial = new Pair<Habitacion, int[]>(null, null);
    	newUbicacionInicial.setFirst(this.getUbicacionInicial().getFirst().clone());
    	newUbicacionInicial.setSecond(this.getUbicacionInicial().getSecond().clone());
    	newAgentSmartToyState.setUbicacionInicial(newUbicacionInicial);
    	
    	//Los atributos que son objetos (los arrays también son de tipo objeto) se pasan por
    	//referencia; luego, es necesario clonarlos
    	List<Habitacion> newPlano = new ArrayList<Habitacion>();
    	for(Habitacion h : this.getPlano())
    		newPlano.add(h.clone());
    	newAgentSmartToyState.setPlano(newPlano);
    	
        return newAgentSmartToyState;
    }

    /**
     * This method is used to update the Agent State when a Perception is
     * received by the Simulator.
     */
    @Override
    public void updateState(Perception p) {
        
        //TODO: Complete Method
    }

    /**
     * This method is optional, and sets the initial state of the agent.
     */
    @Override
    public void initState() {
        
	//TODO: Complete Method

    }

    /**
     * This method returns the String representation of the agent state.
     */
    @Override
    public String toString() {
        String str = "";

        //TODO: Complete Method

        return str;
    }

    /**
     * This method is used in the search process to verify if the node already
     * exists in the actual search.
     */
    @Override
    public boolean equals(Object obj) {
       
       //TODO: Complete Method
    	//Dos estados son iguales si se encuentran en la misma habitacion, y en la misma posicion
    	//se puede contemplar si la lista de habitaciones visitadas es la misma,
    	//pero en este momento no hay un metodo que diga las habitaciones visitadas    	

    	AgentSmartToyState estadoComparado = (AgentSmartToyState)obj;
    	
    	Habitacion habitacionActual= estadoComparado.getUbicacionAgente().getFirst();//obtiene la habitacion actual
    	int[] posicionActual = estadoComparado.getUbicacionAgente().getSecond();//obtiene la posicion en la habitacion actual
    	
    	boolean mismaHabitacionActual = false;
    	boolean mismaPosicion = false;
    	
        //compara habitacion actual
    	if(habitacionActual.getIdHabitacion()==(this.getUbicacionAgente().getFirst().getIdHabitacion())){
    		mismaHabitacionActual = true;
    	};
    	//compara posicion actual
    	if(posicionActual.equals(this.getUbicacionAgente().getSecond())){
    		mismaPosicion=true;
    	}
   
        return (mismaHabitacionActual && mismaPosicion);
    }

	public Pair<Habitacion, int[]> getUbicacionAgente() {
		return ubicacionAgente;
	}

	public void setUbicacionAgente(Pair<Habitacion, int[]> ubicacionAgente) {
		this.ubicacionAgente = ubicacionAgente;
	}

	public Pair<Habitacion, int[]> getUbicacionInicial() {
		return ubicacionInicial;
	}

	public void setUbicacionInicial(Pair<Habitacion, int[]> ubicacionInicial) {
		this.ubicacionInicial = ubicacionInicial;
	}

	public List<Habitacion> getPlano() {
		return plano;
	}

	public void setPlano(List<Habitacion> plano) {
		this.plano = plano;
	}

	public boolean[] getOrientacion() {
		return orientacion;
	}

	public void setOrientacion(boolean[] orientacion) {
		this.orientacion = orientacion;
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
	
	
}

