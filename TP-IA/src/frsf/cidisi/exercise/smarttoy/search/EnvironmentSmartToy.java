package frsf.cidisi.exercise.smarttoy.search;

import domain.Habitacion;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.environment.Environment;
import frsf.cidisi.faia.state.datastructure.Pair;

public class EnvironmentSmartToy extends Environment {

	public EnvironmentSmartToy() {
		// Create the environment state
		this.environmentState = new EnvironmentSmartToyState();
	}

	public EnvironmentSmartToyState getEnvironmentState() {
		return (EnvironmentSmartToyState) super.getEnvironmentState();
	}

	/**
	 * This method is called by the simulator. Given the Agent, it creates a new
	 * perception reading, for example, the agent position.
	 * 
	 * @param agent
	 * @return A perception that will be given to the agent by the simulator.
	 */
	@Override
	public AgentSmartToyPerception getPercept() {
		// Create a new perception to return
		AgentSmartToyPerception perception = new AgentSmartToyPerception();

		// Obtiene el estado del ambiente y lo guarda en una variable
		EnvironmentSmartToyState environmentState = this.getEnvironmentState();

		// Las siguientes dos variables son creadas para facilitar la lectura
		// del código
		Pair<Habitacion, int[]> ubicacionAgente = environmentState
				.getUbicacionAgente();
		String[][] planoHabitacionDeAgente = environmentState
				.getHabitacionDePlano(
						ubicacionAgente.getFirst().getIdHabitacion())
				.getPlanoHabitacion();

		
		// Dependiendo la orientación, setea de distintas formas las 4 percepciones cardinales
		switch (environmentState.getCharOrientacionAgente()) {
		case 'N':
			perception.setSensorfrontal(planoHabitacionDeAgente[ubicacionAgente
					.getSecond()[0] - 1][ubicacionAgente.getSecond()[1]]);
			perception
					.setSensorlateralizquierdo(planoHabitacionDeAgente[ubicacionAgente
							.getSecond()[0]][ubicacionAgente.getSecond()[1] - 1]);
			perception
					.setSensorlateralderecho(planoHabitacionDeAgente[ubicacionAgente
							.getSecond()[0]][ubicacionAgente.getSecond()[1] + 1]);
			perception.setSensortrasero(planoHabitacionDeAgente[ubicacionAgente
					.getSecond()[0] + 1][ubicacionAgente.getSecond()[1]]);
			break;
		case 'O':
			perception.setSensorfrontal(planoHabitacionDeAgente[ubicacionAgente
					.getSecond()[0]][ubicacionAgente.getSecond()[1] - 1]);
			perception
					.setSensorlateralizquierdo(planoHabitacionDeAgente[ubicacionAgente
							.getSecond()[0] + 1][ubicacionAgente.getSecond()[1]]);
			perception
					.setSensorlateralderecho(planoHabitacionDeAgente[ubicacionAgente
							.getSecond()[0] - 1][ubicacionAgente.getSecond()[1]]);
			perception.setSensortrasero(planoHabitacionDeAgente[ubicacionAgente
					.getSecond()[0]][ubicacionAgente.getSecond()[1] + 1]);
			break;
		case 'S':
			perception.setSensorfrontal(planoHabitacionDeAgente[ubicacionAgente
					.getSecond()[0] + 1][ubicacionAgente.getSecond()[1]]);
			perception
					.setSensorlateralizquierdo(planoHabitacionDeAgente[ubicacionAgente
							.getSecond()[0]][ubicacionAgente.getSecond()[1] + 1]);
			perception
					.setSensorlateralderecho(planoHabitacionDeAgente[ubicacionAgente
							.getSecond()[0]][ubicacionAgente.getSecond()[1] - 1]);
			perception.setSensortrasero(planoHabitacionDeAgente[ubicacionAgente
					.getSecond()[0] - 1][ubicacionAgente.getSecond()[1]]);
			break;
		case 'E':
			perception.setSensorfrontal(planoHabitacionDeAgente[ubicacionAgente
					.getSecond()[0]][ubicacionAgente.getSecond()[1] + 1]);
			perception
					.setSensorlateralizquierdo(planoHabitacionDeAgente[ubicacionAgente
							.getSecond()[0] - 1][ubicacionAgente.getSecond()[1]]);
			perception
					.setSensorlateralderecho(planoHabitacionDeAgente[ubicacionAgente
							.getSecond()[0] + 1][ubicacionAgente.getSecond()[1]]);
			perception.setSensortrasero(planoHabitacionDeAgente[ubicacionAgente
					.getSecond()[0]][ubicacionAgente.getSecond()[1] - 1]);
			break;
		}
		
		//Setea la posición del llamado
		perception.setSmartphone(environmentState.getUbicacionSmartPhone().getFirst());

		// Return the perception
		return perception;
	}

	public String toString() {
		return environmentState.toString();
	}

	public boolean agentFailed(Action actionReturned) {

		EnvironmentSmartToyState envState = this.getEnvironmentState();
		if (envState.celdasVisitadas > 210) {
			return true;
		}

		return false;
	}
}
