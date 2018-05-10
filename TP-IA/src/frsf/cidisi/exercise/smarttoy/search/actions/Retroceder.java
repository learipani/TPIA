package frsf.cidisi.exercise.smarttoy.search.actions;

import domain.Habitacion;
import frsf.cidisi.exercise.smarttoy.search.*;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import frsf.cidisi.faia.state.datastructure.Pair;

public class Retroceder extends SearchAction {

    /**
     * This method updates a tree node state when the search process is running.
     * It does not updates the real world state.
     */
    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        AgentSmartToyState agState = (AgentSmartToyState) s;
        
        // TODO: Use this conditions
        // PreConditions: null
        // PostConditions: null
        
        return null;
    }

    /**
     * This method updates the agent state and the real world state.
     */
    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        EnvironmentSmartToyState environmentState = (EnvironmentSmartToyState) est;
        AgentSmartToyState agState = ((AgentSmartToyState) ast);

        boolean[] agentOrientation = agState.getOrientacion();
        int fila = environmentState.getUbicacionAgente().getSecond()[0];
        int columna = environmentState.getUbicacionAgente().getSecond()[1];

        int newFila = fila, newCol = columna;

    //[norte oeste sur este]   = [arriba izq abajo der]
        if (agentOrientation[0]==true)//arriba
            newFila = fila + 1;
        else if (agentOrientation[1]==true)//izq
            newCol = columna + 1;
        else if (agentOrientation[2]==true)//abajo
            newFila = fila - 1;
        else if (agentOrientation[3]==true)//der
            newCol = columna - 1;
        
        Habitacion h = environmentState.getUbicacionAgente().getFirst();
        int[] newPos = {newFila, newCol};
        Pair<Habitacion, int[]> ubicacionNueva = new Pair(h,newPos);

        environmentState.setUbicacionAgente(ubicacionNueva);

        return environmentState;
       /* // TODO: Use this conditions
        // PreConditions: null
        // PostConditions: null
        
        if (true) {
            // Update the real world
            
            // Update the agent state
            
            return environmentState;
        }

        return null;*/
    }

    /**
     * This method returns the action cost.
     */
    @Override
    public Double getCost() {
        return new Double(0);
    }

    /**
     * This method is not important for a search based agent, but is essensial
     * when creating a calculus based one.
     */
    @Override
    public String toString() {
        return "Retroceder";
    }
}