package frsf.cidisi.exercise.smarttoy.search.actions;

import frsf.cidisi.exercise.smarttoy.search.*;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class GirarIzquierda extends SearchAction {
	
	/**
     * This method updates a tree node state when the search process is running.
     * It does not updates the real world state.
     */
    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        
    	AgentSmartToyState agState = (AgentSmartToyState) s;
		int fila = agState.getUbicacionAgente().getSecond()[0];
		int columna = agState.getUbicacionAgente().getSecond()[1];
		boolean flag=false;

		boolean[] agentOrientation = agState.getOrientacion();
		// [norte oeste sur este] = [arriba izq abajo der]
		switch (agState.getCharOrientacion()) {
		case 'N':
			agentOrientation[0] = false;
			agentOrientation[1] = true;
			String ep = Integer.toString(fila)+Integer.toString(columna)+"O";
			if(!agState.getEstadosProbados().contains(ep)){
				flag=true;
				agState.getEstadosProbados().add(ep);
				agState.setTiempo(agState.getTiempo() + this.getCost());
			}
			break;
		case 'O':
			agentOrientation[1] = false;
			agentOrientation[2] = true;
			String ep1 = Integer.toString(fila)+Integer.toString(columna)+"S";
			if(!agState.getEstadosProbados().contains(ep1)){
				flag=true;
				agState.getEstadosProbados().add(ep1);
				agState.setTiempo(agState.getTiempo() + this.getCost());
			}
			break;
		case 'S':
			agentOrientation[2] = false;
			agentOrientation[3] = true;
			String ep2 = Integer.toString(fila)+Integer.toString(columna)+"E";
			if(!agState.getEstadosProbados().contains(ep2)){
				flag=true;
				agState.getEstadosProbados().add(ep2);
				agState.setTiempo(agState.getTiempo() + this.getCost());
			}
			break;
		case 'E':
			agentOrientation[3] = false;
			agentOrientation[0] = true;
			String ep3 = Integer.toString(fila)+Integer.toString(columna)+"N";
			if(!agState.getEstadosProbados().contains(ep3)){
				flag=true;
				agState.getEstadosProbados().add(ep3);
				agState.setTiempo(agState.getTiempo() + this.getCost());
			}
			break;
		}
		if (flag){
			agState.setOrientacion(agentOrientation);
			return agState;
		}
		return null;
    }

    /**
     * This method updates the agent state and the real world state.
     */
    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        
    	EnvironmentSmartToyState environmentState = (EnvironmentSmartToyState) est;
        AgentSmartToyState agState = ((AgentSmartToyState) ast);
    	int fila = agState.getUbicacionAgente().getSecond()[0];
		int columna = agState.getUbicacionAgente().getSecond()[1];
		boolean flag=false;

		boolean[] agentOrientation = agState.getOrientacion();
		// [norte oeste sur este] = [arriba izq abajo der]
		switch (agState.getCharOrientacion()) {
		case 'N':
			agentOrientation[0] = false;
			agentOrientation[1] = true;
			String ep = Integer.toString(fila)+Integer.toString(columna)+"O";
			if(!agState.getEstadosProbados().contains(ep)){
				flag=true;
				agState.getEstadosProbados().add(ep);
				agState.setTiempo(agState.getTiempo() + this.getCost());
			}
			break;
		case 'O':
			agentOrientation[1] = false;
			agentOrientation[2] = true;
			String ep1 = Integer.toString(fila)+Integer.toString(columna)+"S";
			if(!agState.getEstadosProbados().contains(ep1)){
				flag=true;
				agState.getEstadosProbados().add(ep1);
				agState.setTiempo(agState.getTiempo() + this.getCost());
			}
			break;
		case 'S':
			agentOrientation[2] = false;
			agentOrientation[3] = true;
			String ep2 = Integer.toString(fila)+Integer.toString(columna)+"E";
			if(!agState.getEstadosProbados().contains(ep2)){
				flag=true;
				agState.getEstadosProbados().add(ep2);
				agState.setTiempo(agState.getTiempo() + this.getCost());
			}
			break;
		case 'E':
			agentOrientation[3] = false;
			agentOrientation[0] = true;
			String ep3 = Integer.toString(fila)+Integer.toString(columna)+"N";
			if(!agState.getEstadosProbados().contains(ep3)){
				flag=true;
				agState.getEstadosProbados().add(ep3);
				agState.setTiempo(agState.getTiempo() + this.getCost());
			}
			break;
		}
		if (flag){
			agState.setOrientacion(agentOrientation);
			environmentState.setOrientacionAgente(agentOrientation);
		}
		return environmentState;
    }

    /**
     * This method returns the action cost.
     */
    @Override
    public Double getCost() {
        return 0.5;
    }

    /**
     * This method is not important for a search based agent, but is essensial
     * when creating a calculus based one.
     */
    @Override
    public String toString() {
        return "GirarIzquierda";
    }
}