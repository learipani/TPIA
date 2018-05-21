package frsf.cidisi.exercise.smarttoy.search.actions;

import java.util.ArrayList;
import java.util.HashMap;
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

public class Avanzar extends SearchAction {

	static Contenedor contenedor;
	static int cantidadHabitaciones = 15;
	/**
	 * This method updates a tree node state when the search process is running.
	 * It does not updates the real world state.
	 */
	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		AgentSmartToyState agState = (AgentSmartToyState) s;

		char agentOrientation = agState.getCharOrientacion();
		int fila = agState.getUbicacionAgente().getSecond()[0];
		int columna = agState.getUbicacionAgente().getSecond()[1];
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
		
		// [norte oeste sur este] = [arriba izq abajo der]
		switch (agentOrientation) {
		case 'N':
			fila -= 1;
			break;
		case 'O':
			columna -= 1;
			break;
		case 'S':
			fila += 1;
			break;
		case 'E':
			columna += 1;
			break;
		}
		
		// Si la celda de en frente esta vacia, avanza
		if (planoHabitacionAgente[fila][columna].equals(AgentSmartToyPerception.EMPTY_PERCEPTION)
				&& EstadoNoProbado(fila, columna, agState.getCharOrientacion(), agState.getEstadosProbados())) {
			agState.getUbicacionAgente().setSecond(new int[] { fila, columna });
			agState.getEstadosProbados().add(Integer.toString(fila)+Integer.toString(columna)+agState.getCharOrientacion());
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

		char agentOrientation = agState.getCharOrientacion();
		int fila = agState.getUbicacionAgente().getSecond()[0];
		int columna = agState.getUbicacionAgente().getSecond()[1];
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
			break;
		case 'O':
			columna -= 1;
			break;
		case 'S':
			fila += 1;
			break;
		case 'E':
			columna += 1;
			break;
		}

		if (planoHabitacionAgente[fila][columna].equals(AgentSmartToyPerception.EMPTY_PERCEPTION)
				&& EstadoNoProbado(fila, columna, agState.getCharOrientacion(), agState.getEstadosProbados())) {
			agState.getUbicacionAgente().setSecond(new int[] { fila, columna });
			agState.getEstadosProbados().add(Integer.toString(fila)+Integer.toString(columna)+agState.getCharOrientacion());
			environmentState.getUbicacionAgente().setSecond(new int[] { fila, columna });
			environmentState.celdasVisitadas = environmentState.celdasVisitadas + 1;
		}

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
		return "Avanzar";
	}

	private boolean EstadoNoProbado(int fila, int columna, char orientacion,List<String> estadosProbados) {
		String ep = Integer.toString(fila)+Integer.toString(columna)+orientacion;
		if(estadosProbados.contains(ep)){
			return false;
		}
		return true;
	}
}