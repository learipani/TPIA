package frsf.cidisi.exercise.smarttoy.search.actions;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import pantalla.Contenedor;

import domain.Habitacion;
import domain.Puerta;
import frsf.cidisi.exercise.smarttoy.search.*;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.*;
import frsf.cidisi.faia.state.datastructure.Pair;

public class IrHabitacionContigua extends SearchAction {

	static Contenedor contenedor;
	static int cantidadHabitaciones = 15;
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
		
		//
		LinkedList<Integer>[] matrizAdyacencia = new LinkedList[cantidadHabitaciones];
		for (int i=0; i<cantidadHabitaciones; i++)
			matrizAdyacencia[i] = new LinkedList();

		for (Habitacion itemHabitacion : agState.getPlano()) {
			for (Pair<Integer, List<Puerta>> itemHabContigua : itemHabitacion
					.getHabitacionesContiguas()) {
				matrizAdyacencia[itemHabitacion.getIdHabitacion()-1].add(itemHabContigua.getFirst()-1);
			}
		}
		//
		// [norte oeste sur este] = [arriba izq abajo der]
		switch (agentOrientation) {
		case 'N':
			fila -= 1;
			addFilaosicionEgreso = -1;
			break;
		case 'O':
			columna -= 1;
			addColumnaposicionEgreso = -1;
			break;
		case 'S':
			fila += 1;
			addFilaosicionEgreso = 1;
			break;
		case 'E':
			columna += 1;
			addColumnaposicionEgreso = 1;
			break;
		}
		// Si tiene una puerta, va a la otra habitación
		if (planoHabitacionAgente[fila][columna].equals(AgentSmartToyPerception.PUERTA_PERCEPTION)
				&& agState.getNumeroHabitacionSmartPhone()!=agState.getUbicacionAgente().getFirst().getIdHabitacion()) {
			// Acá obtiene un par de la puerta que tiene adelante y la
			// habitacion a la cual lleva al agente.
			Pair<Habitacion, Puerta> habitacionDelante = ObtenerHabitacion(
						fila, columna, ubicacionAgente.getFirst(), agState
								.getPlano());
			if(!agState.getHabitacionesVisitadas().contains(habitacionDelante.getFirst().getIdHabitacion())){
				agState.addHabitacionesVisitadas(ubicacionAgente.getFirst().getIdHabitacion());
				Pair<Habitacion, int[]> nuevaUbicacion = new Pair<Habitacion, int[]>(null, null);
				nuevaUbicacion.setFirst(habitacionDelante.getFirst());
				int[] nuevaPosicionEnHab = new int[] {
					// Aca suma la variable aux para que el Agente
					// no quede en un borde
					habitacionDelante.getSecond().getPosicionEngreso()[0] + addFilaosicionEgreso,
					habitacionDelante.getSecond().getPosicionEngreso()[1] + addColumnaposicionEgreso};
				agState.getEstadosProbados().clear();
				nuevaUbicacion.setSecond(nuevaPosicionEnHab);
				agState.setUbicacionAgente(nuevaUbicacion);
				//ver
				agState.setCeldasVisitadas(agState.getCeldasVisitadas()+1);
				agState.setTiempo(agState.getTiempo() + this.getCost());
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
		
		//
		LinkedList<Integer>[] matrizAdyacencia = new LinkedList[15];
		for (int i=0; i<cantidadHabitaciones; i++)
			matrizAdyacencia[i] = new LinkedList();

		for (Habitacion itemHabitacion : agState.getPlano()) {
			for (Pair<Integer, List<Puerta>> itemHabContigua : itemHabitacion
					.getHabitacionesContiguas()) {
				matrizAdyacencia[itemHabitacion.getIdHabitacion()-1].add(itemHabContigua.getFirst()-1);
			}
		}
		//

		switch (agentOrientation) {
		case 'N':
			fila -= 1;
			addFilaosicionEgreso = -1;
			break;
		case 'O':
			columna -= 1;
			addColumnaposicionEgreso = -1;
			break;
		case 'S':
			fila += 1;
			addFilaosicionEgreso = 1;
			break;
		case 'E':
			columna += 1;
			addColumnaposicionEgreso = 1;
			break;
		}

		if (planoHabitacionAgente[fila][columna].equals(AgentSmartToyPerception.PUERTA_PERCEPTION)
				&& agState.getNumeroHabitacionSmartPhone()!=agState.getUbicacionAgente().getFirst().getIdHabitacion()
				&& EstadoNoProbado(fila, columna, agState.getCharOrientacion(), agState.getEstadosProbados())) {
			// Acá obtiene una par de la puerta que tiene adelante y la
			// habitacion al cual lleva al agente.
			Pair<Habitacion, Puerta> habitacionDelante = ObtenerHabitacion(
					fila, columna, ubicacionAgente.getFirst(), agState
							.getPlano());
			if(!agState.getHabitacionesVisitadas().contains(habitacionDelante.getFirst().getIdHabitacion())){
				agState.addHabitacionesVisitadas(ubicacionAgente.getFirst().getIdHabitacion());
				Pair<Habitacion, int[]> nuevaUbicacion = new Pair<Habitacion, int[]>(null, null);
				nuevaUbicacion.setFirst(habitacionDelante.getFirst());
				int[] nuevaPosicionEnHab = new int[] {
						// Aca suma la variable aux para que el Agente
						// no quede en un borde
						habitacionDelante.getSecond().getPosicionEngreso()[0] + addFilaosicionEgreso,
						habitacionDelante.getSecond().getPosicionEngreso()[1] + addColumnaposicionEgreso};
				agState.getEstadosProbados().clear();
				nuevaUbicacion.setSecond(nuevaPosicionEnHab);
				agState.setUbicacionAgente(nuevaUbicacion);
				environmentState.setUbicacionAgente(nuevaUbicacion);
				//ver
				agState.setTiempo(agState.getTiempo() + this.getCost());
			}
		}
		environmentState.celdasVisitadas = environmentState.celdasVisitadas + 1;

		try {
			Contenedor.mover();
			Thread.sleep(250); //tiempo para que se vea
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		return "Ir habitacion";
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
	
	private boolean EstadoNoProbado(int fila, int columna, char orientacion,List<String> estadosProbados) {
		String ep = Integer.toString(fila)+Integer.toString(columna)+orientacion;
		if(estadosProbados.contains(ep)){
			return false;
		}
		return true;
	}
}