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
	public static String META_PERCEPTION = "go";
	public static String PISO_ARENA = "PA";
	public static String PISO_BASURA = "PB";
	public static String PISO_ALFOMBRA = "AL";
	public static String PISO_MOJADO = "PM";
	public static String ESCALERA = "ES";

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

		// Dependiendo la orientación, hace distintas cosas
		switch (((AgentSmartToyState) agent.getAgentState())
				.getCharOrientacion()) {
		case 'N':
			this.sensorfrontal = planoHabitacionDeAgente[ubicacionAgente.getSecond()[0] - 1][ubicacionAgente
					.getSecond()[1]];
			this.sensorlateralizquierdo = planoHabitacionDeAgente[ubicacionAgente
					.getSecond()[0]][ubicacionAgente.getSecond()[1] - 1];
			this.sensorlateralderecho = planoHabitacionDeAgente[ubicacionAgente
					.getSecond()[0]][ubicacionAgente.getSecond()[1] + 1];
			this.sensortrasero = planoHabitacionDeAgente[ubicacionAgente.getSecond()[0] + 1][ubicacionAgente
					.getSecond()[1]];
			break;
		case 'O':
			this.sensorfrontal = planoHabitacionDeAgente[ubicacionAgente.getSecond()[0]][ubicacionAgente
					.getSecond()[1] - 1];
			this.sensorlateralizquierdo = planoHabitacionDeAgente[ubicacionAgente
					.getSecond()[0] + 1][ubicacionAgente.getSecond()[1]];
			this.sensorlateralderecho = planoHabitacionDeAgente[ubicacionAgente
					.getSecond()[0] - 1][ubicacionAgente.getSecond()[1]];
			this.sensortrasero = planoHabitacionDeAgente[ubicacionAgente.getSecond()[0]][ubicacionAgente
					.getSecond()[1] + 1];
			break;
		case 'S':
			this.sensorfrontal = planoHabitacionDeAgente[ubicacionAgente.getSecond()[0] + 1][ubicacionAgente
					.getSecond()[1]];
			this.sensorlateralizquierdo = planoHabitacionDeAgente[ubicacionAgente
					.getSecond()[0]][ubicacionAgente.getSecond()[1] + 1];
			this.sensorlateralderecho = planoHabitacionDeAgente[ubicacionAgente
					.getSecond()[0]][ubicacionAgente.getSecond()[1] - 1];
			this.sensortrasero = planoHabitacionDeAgente[ubicacionAgente.getSecond()[0] - 1][ubicacionAgente
					.getSecond()[1]];
			break;
		case 'E':
			this.sensorfrontal = planoHabitacionDeAgente[ubicacionAgente.getSecond()[0]][ubicacionAgente
					.getSecond()[1] + 1];
			this.sensorlateralizquierdo = planoHabitacionDeAgente[ubicacionAgente
					.getSecond()[0] - 1][ubicacionAgente.getSecond()[1]];
			this.sensorlateralderecho = planoHabitacionDeAgente[ubicacionAgente
					.getSecond()[0]][ubicacionAgente.getSecond()[1] + 1];
			this.sensortrasero = planoHabitacionDeAgente[ubicacionAgente.getSecond()[0]][ubicacionAgente
					.getSecond()[1] - 1];
			break;
		}
		this.smartphone = environmentState.getUbicacionSmartPhone().getFirst();
	}

	@Override
	public String toString() {
		String str = new String();
		
		str += "\nAl frente: " + sensorfrontal;
		str += "\nDetrás: " + sensortrasero;
		str += "\nIzquierda: " + sensorlateralizquierdo;
		str += "\nDerecha: " + sensorlateralderecho;
		str += "\nEl SmartPhone se encuentra en la habitación: "
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
