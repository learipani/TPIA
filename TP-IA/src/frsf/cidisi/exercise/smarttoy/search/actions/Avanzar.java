package frsf.cidisi.exercise.smarttoy.search.actions;

import java.util.List;

import domain.Habitacion;
import domain.Puerta;
import frsf.cidisi.exercise.smarttoy.search.*;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.*;
import frsf.cidisi.faia.state.datastructure.Pair;

public class Avanzar extends SearchAction {

	/**
	 * This method updates a tree node state when the search process is running.
	 * It does not updates the real world state.
	 */
	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		AgentSmartToyState agState = (AgentSmartToyState) s;

		int addFilaosicionEgreso = 0;
		int addColumnaposicionEgreso = 0;
		char agentOrientation = agState.getCharOrientacion();
		int fila = agState.getUbicacionAgente().getSecond()[0];
		int columna = agState.getUbicacionAgente().getSecond()[1];
		Pair<Habitacion, int[]> ubicacionAgente = agState.getUbicacionAgente();
		String[][] planoHabitacionAgente = agState.getUbicacionAgente()
				.getFirst().getPlanoHabitacion();

		// [norte oeste sur este] = [arriba izq abajo der]
		switch (agentOrientation) {
		case 'N':
			fila -= 1;
			addFilaosicionEgreso = 1;
			break;
		case 'O':
			columna -= 1;
			addColumnaposicionEgreso = -1;
			break;
		case 'S':
			fila += 1;
			addFilaosicionEgreso = -1;
			break;
		case 'E':
			columna += 1;
			addColumnaposicionEgreso = 1;
			break;
		}

		// Si la celda de en frente, avanza
		if (planoHabitacionAgente[fila][columna]
				.equals(AgentSmartToyPerception.EMPTY_PERCEPTION)) {
			agState.getUbicacionAgente().setSecond(new int[] { fila, columna });
			GirarDerecha.cantidadGiros = 0;
			GirarIzquierda.cantidadGiros = 0;
			return agState;
		} else {
			// Si tiene una puerta, va a la otra habitación
			if (planoHabitacionAgente[fila][columna]
					.equals(AgentSmartToyPerception.PUERTA_PERCEPTION)) {
				// Acá obtiene una par de la puerta que tiene adelante y la
				// habitacion al cual lleva al agente.
				Pair<Habitacion, Puerta> habitacionDelante = ObtenerHabitacion(
						fila, columna, ubicacionAgente.getFirst(), agState
								.getPlano());
				// Acá setea los nuevos valores
				agState.getUbicacionAgente().setFirst(
						habitacionDelante.getFirst());

				agState.getUbicacionAgente().setSecond(
						new int[] {
								// Aca suma la variable aux para que el Agente
								// no quede en un borde
								habitacionDelante.getSecond()
										.getPosicionEngreso()[0]
										+ addFilaosicionEgreso,
								habitacionDelante.getSecond()
										.getPosicionEngreso()[1]
										+ addColumnaposicionEgreso });
				GirarDerecha.cantidadGiros = 0;
				GirarIzquierda.cantidadGiros = 0;
				return agState;
			}
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

		int addFilaosicionEgreso = 0;
		int addColumnaposicionEgreso = 0;
		char agentOrientation = agState.getCharOrientacion();
		int fila = agState.getUbicacionAgente().getSecond()[0];
		int columna = agState.getUbicacionAgente().getSecond()[1];
		Pair<Habitacion, int[]> ubicacionAgente = agState.getUbicacionAgente();
		String[][] planoHabitacionAgente = agState.getUbicacionAgente()
				.getFirst().getPlanoHabitacion();

		switch (agentOrientation) {
		case 'N':
			fila -= 1;
			addFilaosicionEgreso = 1;
			break;
		case 'O':
			columna -= 1;
			addColumnaposicionEgreso = -1;
			break;
		case 'S':
			fila += 1;
			addFilaosicionEgreso = -1;
			break;
		case 'E':
			columna += 1;
			addColumnaposicionEgreso = 1;
			break;
		}

		if (planoHabitacionAgente[fila][columna]
				.equals(AgentSmartToyPerception.EMPTY_PERCEPTION)) {
			agState.getUbicacionAgente().setSecond(new int[] { fila, columna });
			environmentState.getUbicacionAgente().setSecond(new int[] { fila, columna });
		} else {
			// Si tiene una puerta, va a la otra habitación
			if (planoHabitacionAgente[fila][columna]
					.equals(AgentSmartToyPerception.PUERTA_PERCEPTION)) {
				// Acá obtiene una par de la puerta que tiene adelante y la
				// habitacion al cual lleva al agente.
				Pair<Habitacion, Puerta> habitacionDelante = ObtenerHabitacion(
						fila, columna, ubicacionAgente.getFirst(), agState
								.getPlano());
				// Acá setea los nuevos valores
				agState.getUbicacionAgente().setFirst(
						habitacionDelante.getFirst());
				environmentState.getUbicacionAgente().setFirst(habitacionDelante.getFirst());

				int[] nuevaPosicionEnHab = new int[] {
						// Aca suma la variable aux para que el Agente
						// no quede en un borde
						habitacionDelante.getSecond()
								.getPosicionEngreso()[0]
								+ addFilaosicionEgreso,
						habitacionDelante.getSecond()
								.getPosicionEngreso()[1]
								+ addColumnaposicionEgreso };
				agState.getUbicacionAgente().setSecond(nuevaPosicionEnHab);
				environmentState.getUbicacionAgente().setSecond(nuevaPosicionEnHab);
			}
		}
		GirarDerecha.cantidadGirosReales = 0;
		GirarIzquierda.cantidadGirosReales = 0;
		environmentState.celdasVisitadas = environmentState.celdasVisitadas + 1;

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
		return "Avanzar";
	}

	private Pair<Habitacion, Puerta> ObtenerHabitacion(int fila, int columna,
			Habitacion hab, List<Habitacion> listHab) {
		Pair<Habitacion, Puerta> habPuert = new Pair<Habitacion, Puerta>(
				new Habitacion(), new Puerta());
		int idHab = 0;
		for (Pair<Integer, List<Puerta>> itemHabitacionContigua : hab
				.getHabitacionesContiguas()) {
			for (Puerta itemPuertaDeHC : itemHabitacionContigua.getSecond()) {
				if (itemPuertaDeHC.getPosicionIngreso()[0] == fila
						&& itemPuertaDeHC.getPosicionIngreso()[1] == columna) {
					habPuert.setSecond(itemPuertaDeHC);
					idHab = itemHabitacionContigua.getFirst();
					break;
				}
			}
		}
		for (Habitacion itemHabitacion : listHab) {
			if (itemHabitacion.getIdHabitacion() == idHab) {
				habPuert.setFirst(itemHabitacion);
				return habPuert;
			}
		}
		return null;
	}

}