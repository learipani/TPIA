package frsf.cidisi.exercise.smarttoy.search;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class GoalSmartToy extends GoalTest {

	@Override
	public boolean isGoalState(AgentState agentState) {

		AgentSmartToyState estadoAgente = (AgentSmartToyState) agentState;
		
		int xAgent = estadoAgente.getUbicacionAgente().getSecond()[0];
		int yAgent = estadoAgente.getUbicacionAgente().getSecond()[1];
		String[][] plano = estadoAgente.getUbicacionAgente().getFirst().getPlanoHabitacion();
		
		if ((plano[xAgent + 1][yAgent] == "go"
				|| plano[xAgent - 1][yAgent] == "go"
				|| plano[xAgent][yAgent + 1] == "go" || plano[xAgent][yAgent - 1] == "go"
				|| plano[xAgent][yAgent] == "go"
				|| estadoAgente.getCeldasVisitadas()>= 6)
				&& estadoAgente.getUbicacionAgente().getFirst().getIdHabitacion() == estadoAgente.getNumeroHabitacionSmartPhone()) {
			return true;
		} else {
			return false;
		}
	}
}