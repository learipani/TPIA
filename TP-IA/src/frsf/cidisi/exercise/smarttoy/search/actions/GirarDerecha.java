package frsf.cidisi.exercise.smarttoy.search.actions;

import java.util.HashMap;

import frsf.cidisi.exercise.smarttoy.search.*;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class GirarDerecha extends SearchAction {

	public static int cantidadGiros = 0;
	public static int cantidadGirosReales = 0;

	/**
	 * This method updates a tree node state when the search process is running.
	 * It does not updates the real world state.
	 */
	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {

		AgentSmartToyState agState = (AgentSmartToyState) s;
		String[][] planoHabitacionAgente = agState.getUbicacionAgente()
				.getFirst().getPlanoHabitacion();
		int fila = agState.getUbicacionAgente().getSecond()[0];
		int columna = agState.getUbicacionAgente().getSecond()[1];

		if (EstadoNoProbado(fila, columna, agState.getCharOrientacion(),
				agState.getEstadosProbados())) {
			boolean[] agentOrientation = agState.getOrientacion();
			// [norte oeste sur este] = [arriba izq abajo der]

			switch (agState.getCharOrientacion()) {
			case 'N':
				agentOrientation[0] = false;
				agentOrientation[3] = true;
				agState.getEstadosProbados().put(
						new char[] { (char) fila, (char) columna, 'E' }, 1);

				break;
			case 'O':
				agentOrientation[0] = true;
				agentOrientation[1] = true;
				agState.getEstadosProbados().put(
						new char[] { (char) fila, (char) columna, 'N' }, 1);
				break;
			case 'S':
				agentOrientation[2] = false;
				agentOrientation[1] = true;
				agState.getEstadosProbados().put(
						new char[] { (char) fila, (char) columna, 'O' }, 1);
				break;
			case 'E':
				agentOrientation[3] = false;
				agentOrientation[2] = true;
				agState.getEstadosProbados().put(
						new char[] { (char) fila, (char) columna, 'S' }, 1);
				break;
			}
			cantidadGiros++;
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

		if (EstadoNoProbado(fila, columna, agState.getCharOrientacion(),
				agState.getEstadosProbados())) {
			boolean[] agentOrientation = agState.getOrientacion();
			// [norte oeste sur este] = [arriba izq abajo der]
			if (agentOrientation[0] == true) {// arriba
				agentOrientation[0] = false;
				agentOrientation[3] = true;
				agState.getEstadosProbados().put(
						new char[] { (char) fila, (char) columna, 'E' }, 1);
			} else if (agentOrientation[1] == true) {// izq
				agentOrientation[1] = false;
				agentOrientation[0] = true;
				agState.getEstadosProbados().put(
						new char[] { (char) fila, (char) columna, 'N' }, 1);
			} else if (agentOrientation[2] == true) {// abajo
				agentOrientation[2] = false;
				agentOrientation[1] = true;
				agState.getEstadosProbados().put(
						new char[] { (char) fila, (char) columna, 'O' }, 1);
			} else if (agentOrientation[3] == true) {// der
				agentOrientation[3] = false;
				agentOrientation[2] = true;
				agState.getEstadosProbados().put(
						new char[] { (char) fila, (char) columna, 'S' }, 1);
			}
			cantidadGirosReales++;
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
		return new Double(0);
	}

	/**
	 * This method is not important for a search based agent, but is essensial
	 * when creating a calculus based one.
	 */
	@Override
	public String toString() {
		return "GirarDerecha";
	}

	private boolean EstadoNoProbado(int fila, int columna, char orientacion,
			HashMap<char[], Integer> hashMap) {

		Integer value = hashMap.get(new char[] { (char) fila, (char) columna,
				orientacion });
		if (value == null) {
			return true;
		}
		return false;
	}
}