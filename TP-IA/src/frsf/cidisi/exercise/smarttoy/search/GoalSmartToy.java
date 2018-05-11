

package frsf.cidisi.exercise.smarttoy.search;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class GoalSmartToy extends GoalTest {

    @Override
    public boolean isGoalState (AgentState agentState) {
    	
    	 AgentSmartToyState estadoAgente = (AgentSmartToyState) agentState;
    	 int habitacionAgente= estadoAgente.getUbicacionAgente().getFirst().getIdHabitacion();
    	 int habitacionSmartphone = estadoAgente.getUbicacionInicial().getFirst().getIdHabitacion();
    	 int ubicacionAgente[] = estadoAgente.getUbicacionAgente().getSecond();
    	 int ubicacionSmartphone[] = estadoAgente.getUbicacionInicial().getSecond(); 
    
    	if(habitacionAgente == habitacionSmartphone & //habitacion smartphone misma que smartoy
    			ubicacionAgente[0]==ubicacionSmartphone[0] & //ubicacion en la pieza es la misma
    			ubicacionAgente[1]==ubicacionSmartphone[1]){
    		return true;
    	}
    	else{
    		return false;
    	}
	}
}