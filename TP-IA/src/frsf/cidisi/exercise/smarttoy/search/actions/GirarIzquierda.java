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
        boolean[] agentOrientation = agState.getOrientacion();
        
        //[norte oeste sur este]   = [arriba izq abajo der]
        if (agentOrientation[0]==true){//arriba
        	agentOrientation[0]=false;
        	agentOrientation[1]=true;
        }
        else if (agentOrientation[1]==true){//izq
        	agentOrientation[1]=false;
        	agentOrientation[2]=true;
        }
        else if (agentOrientation[2]==true){//abajo
        	agentOrientation[2]=false;
        	agentOrientation[3]=true;
        }
        else if (agentOrientation[3]==true){//der
        	agentOrientation[3]=false;
        	agentOrientation[0]=true;
        }
            
        agState.setOrientacion(agentOrientation);

        return agState;
        // TODO: Use this conditions
        // PreConditions: null
        // PostConditions: null
        
        //return null;
    }

    /**
     * This method updates the agent state and the real world state.
     */
    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        
    	EnvironmentSmartToyState environmentState = (EnvironmentSmartToyState) est;
        AgentSmartToyState agState = ((AgentSmartToyState) ast);
        boolean[] agentOrientation = agState.getOrientacion();
        
        //[norte oeste sur este]   = [arriba izq abajo der]
            if (agentOrientation[0]==true){//arriba
            	agentOrientation[0]=false;
            	agentOrientation[1]=true;
            }
            else if (agentOrientation[1]==true){//izq
            	agentOrientation[1]=false;
            	agentOrientation[2]=true;
            }
            else if (agentOrientation[2]==true){//abajo
            	agentOrientation[2]=false;
            	agentOrientation[3]=true;
            }
            else if (agentOrientation[3]==true){//der
            	agentOrientation[3]=false;
            	agentOrientation[0]=true;
            }
                
            agState.setOrientacion(agentOrientation);
            environmentState.setOrientacionAgente(agentOrientation);

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
        return "GirarIzquierda";
    }
}