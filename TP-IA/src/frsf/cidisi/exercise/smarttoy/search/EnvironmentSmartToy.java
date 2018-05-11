package frsf.cidisi.exercise.smarttoy.search;

import java.util.ArrayList;
import java.util.List;

import domain.Habitacion;
import domain.Objeto;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;
import frsf.cidisi.faia.state.datastructure.Pair;

public class EnvironmentSmartToy extends Environment {

    public EnvironmentSmartToy() {
        // Create the environment state
        this.environmentState = new EnvironmentSmartToyState(new ArrayList<Habitacion>(), new Pair<Habitacion, int[]>(null,  new int[] {0,0}), new Pair<Habitacion, int[]>(null, new int[] {0,0}));
    }

    public EnvironmentSmartToyState getEnvironmentState() {
        return (EnvironmentSmartToyState) super.getEnvironmentState();
    }

    /**
     * This method is called by the simulator. Given the Agent, it creates
     * a new perception reading, for example, the agent position.
     * @param agent
     * @return A perception that will be given to the agent by the simulator.
     */
    @Override
    public  AgentSmartToyPerception getPercept() {
        // Create a new perception to return
         AgentSmartToyPerception perception = new AgentSmartToyPerception();
		
		//TODO : Set the perceptions sensors
        
        // Return the perception
        return perception;
    }

    
    public String toString() {
        return environmentState.toString();
    }

    
    public boolean agentFailed(Action actionReturned) {

        EnvironmentSmartToyState envState =
                this.getEnvironmentState();
        if(envState.celdasVisitadas>2000){
        	return true;
        }

        // TODO: Complete Method        

        return false;
    }

	//TODO: Complete this section with agent-specific methods
    // The following methods are agent-specific:
    
    
}
