

package frsf.cidisi.exercise.smarttoy.search;

import domain.Habitacion;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class GoalSmartToy extends GoalTest {

    @Override
    public boolean isGoalState (AgentState agentState) {
    	
    	 AgentSmartToyState estadoAgente = (AgentSmartToyState) agentState;
    	 //int habitacionAgente= estadoAgente.getUbicacionAgente().getFirst().getIdHabitacion();
    	 //int habitacionSmartphone = estadoAgente.getUbicacionInicial().getFirst().getIdHabitacion();
    	 //int ubicacionAgente[] = estadoAgente.getUbicacionAgente().getSecond();
    	 //int ubicacionSmartphone[] = estadoAgente.getUbicacionInicial().getSecond(); 
    
    	 int xAgent = estadoAgente.getUbicacionAgente().getSecond()[0];
    	 int yAgent = estadoAgente.getUbicacionAgente().getSecond()[1];
    	 String[][] plano = estadoAgente.getUbicacionAgente().getFirst().getPlanoHabitacion();
    	if(plano[xAgent+1][yAgent]  == "go" ||
    			plano[xAgent-1][yAgent]  == "go" ||
    			plano[xAgent][yAgent+1]  == "go" ||
    			plano[xAgent][yAgent-1]  == "go" ||
    			plano[xAgent+1][yAgent+1]  == "go" ||
    			plano[xAgent+1][yAgent-1]  == "go" ||
    			plano[xAgent-1][yAgent-1]  == "go" ||
    			plano[xAgent-1][yAgent+1]  == "go"){
    		return true;
    	}
    	else{
    		return false;
    	}
	}
}