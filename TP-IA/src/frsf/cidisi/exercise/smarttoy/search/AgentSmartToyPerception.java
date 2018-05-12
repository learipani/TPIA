package frsf.cidisi.exercise.smarttoy.search;

import domain.Habitacion;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;
import frsf.cidisi.faia.state.datastructure.Pair;

public class AgentSmartToyPerception extends Perception {

	// TODO: Setup Statics
	public static String UNKNOWN_PERCEPTION = "uk";
	public static String EMPTY_PERCEPTION = "##";
	public static String PUERTA_PERCEPTION = "pu";
	public static String OBSTACULO_PERCEPTION = "ob";
	public static String TERRENO_PERCEPTION = "ta";
	public static String META_PERCEPTION = "go";

	// TODO: Setup Sensors
	// Envía la habitacíon en la cual se encuentra el agente
	/*
	 * Los sensores devuelven letras dependiendo lo que tengan en frente pu =
	 * puerta pa = pared ta = terreno adverso ob = obstaculo
	 */
	private String sensorfrontal;
	private String sensorlateralizquierdo;
	private String sensorlateralderecho;
	private String sensortrasero;
	private Habitacion smartphone;

	public AgentSmartToyPerception() {
	}

	public AgentSmartToyPerception(Agent agent, Environment environment) {
		super(agent, environment);
	}

	@Override
	public void initPerception(Agent agentIn, Environment environmentIn) {
		// Le pasa el Agente y el Ambiente
		AgentSmartToy agent = (AgentSmartToy) agentIn;
		EnvironmentSmartToy environment = (EnvironmentSmartToy) environmentIn;
		// Obtiene el estado del ambiente y lo guarda en una variable
		EnvironmentSmartToyState environmentState = environment
				.getEnvironmentState();

		// Las siguientes dos variables son creadas para facilitar la lectura
		// del código
		Pair<Habitacion, int[]> ubicacionAgente = environmentState
				.getUbicacionAgente();
		String[][] planoHabitacionDeAgente = environmentState
				.getHabitacionDePlano(
						ubicacionAgente.getFirst().getIdHabitacion())
				.getPlanoHabitacion();
		// Pair<Habitacion, int[]> ubicacionSmartPhone =
		// environmentState.getUbicacionSmartPhone();
		// Pair<Habitacion, int[]> ubicacionInicial;
		// List<Habitacion> plano = environmentState.getPlano();

		// Dependiendo la orientación, hace distintas cosas
		switch (((AgentSmartToyState) agent.getAgentState())
				.getCharOrientacion()) {
		case 'N':
			sensorfrontal = planoHabitacionDeAgente[ubicacionAgente.getSecond()[0] - 1][ubicacionAgente
					.getSecond()[1]];
			sensorlateralizquierdo = planoHabitacionDeAgente[ubicacionAgente
					.getSecond()[0]][ubicacionAgente.getSecond()[1] - 1];
			sensorlateralderecho = planoHabitacionDeAgente[ubicacionAgente
					.getSecond()[0] + 1][ubicacionAgente.getSecond()[1]];
			sensortrasero = planoHabitacionDeAgente[ubicacionAgente.getSecond()[0]][ubicacionAgente
					.getSecond()[1] + 1];
			break;
		case 'O':
			sensorfrontal = planoHabitacionDeAgente[ubicacionAgente.getSecond()[0]][ubicacionAgente
					.getSecond()[1] - 1];
			sensorlateralizquierdo = planoHabitacionDeAgente[ubicacionAgente
					.getSecond()[0]][ubicacionAgente.getSecond()[1] + 1];
			sensorlateralderecho = planoHabitacionDeAgente[ubicacionAgente
					.getSecond()[0] - 1][ubicacionAgente.getSecond()[1]];
			sensortrasero = planoHabitacionDeAgente[ubicacionAgente.getSecond()[0] + 1][ubicacionAgente
					.getSecond()[1]];
			break;
		case 'S':
			sensorfrontal = planoHabitacionDeAgente[ubicacionAgente.getSecond()[0]][ubicacionAgente
					.getSecond()[1] + 1];
			sensorlateralizquierdo = planoHabitacionDeAgente[ubicacionAgente
					.getSecond()[0] + 1][ubicacionAgente.getSecond()[1]];
			sensorlateralderecho = planoHabitacionDeAgente[ubicacionAgente
					.getSecond()[0]][ubicacionAgente.getSecond()[1] - 1];
			sensortrasero = planoHabitacionDeAgente[ubicacionAgente.getSecond()[0] - 1][ubicacionAgente
					.getSecond()[1]];
			break;
		case 'E':
			sensorfrontal = planoHabitacionDeAgente[ubicacionAgente.getSecond()[0] + 1][ubicacionAgente
					.getSecond()[1]];
			sensorlateralizquierdo = planoHabitacionDeAgente[ubicacionAgente
					.getSecond()[0] - 1][ubicacionAgente.getSecond()[1]];
			sensorlateralderecho = planoHabitacionDeAgente[ubicacionAgente
					.getSecond()[0]][ubicacionAgente.getSecond()[1] + 1];
			sensortrasero = planoHabitacionDeAgente[ubicacionAgente.getSecond()[0]][ubicacionAgente
					.getSecond()[1] - 1];
			break;
		}
		smartphone = environmentState.getUbicacionSmartPhone().getFirst();
	}

	@Override
	public String toString() {
		String str = new String();

		str += "El SmartToy percibe: ";
		str += "\nAl frente: " + sensorfrontal;
		str += "\nDetrás: " + sensortrasero;
		str += "\nIzquierda: " + sensorlateralizquierdo;
		str += "\nDerecha: " + sensorlateralderecho;
		str += "\n\nEl SmartPhone se encuentra en la habitación: "
				+ smartphone.getIdHabitacion();

		return str.toString();
	}

	// The following methods are agent-specific:
	public Habitacion getSmartphone() {
		return smartphone;
	}

	public void setSmartphone(Habitacion smartphone) {
		this.smartphone = smartphone;
	}

	public String getSensorfrontal() {
		return sensorfrontal;
	}

	public void setSensorfrontal(String sensorfrontal) {
		this.sensorfrontal = sensorfrontal;
	}

	public String getSensorlateralizquierdo() {
		return sensorlateralizquierdo;
	}

	public void setSensorlateralizquierdo(String sensorlateralizquierdo) {
		this.sensorlateralizquierdo = sensorlateralizquierdo;
	}

	public String getSensorlateralderecho() {
		return sensorlateralderecho;
	}

	public void setSensorlateralderecho(String sensorlateralderecho) {
		this.sensorlateralderecho = sensorlateralderecho;
	}

	public String getSensortrasero() {
		return sensortrasero;
	}

	public void setSensortrasero(String sensortrasero) {
		this.sensortrasero = sensortrasero;
	}

}
