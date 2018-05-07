package frsf.cidisi.exercise.smarttoy.search;

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
	
    /**
     * This method clones the state of the agent. It's used in the search
     * process, when creating the search tree.
     */
    @Override
    public SearchBasedAgentState clone() {
        
		//TODO: Complete Method
		
        return null;
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
        
        return true;
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

	
}

