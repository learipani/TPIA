package frsf.cidisi.exercise.smarttoy.search;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class EnvironmentSmartToy extends Environment {

    public EnvironmentSmartToy() {
        // Create the environment state
        this.environmentState = new EnvironmentSmartToyState();
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

        // TODO: Complete Method        

        return false;
    }

	//TODO: Complete this section with agent-specific methods
    // The following methods are agent-specific:
    
    
}
