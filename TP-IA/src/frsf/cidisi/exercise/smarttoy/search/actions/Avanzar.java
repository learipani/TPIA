package frsf.cidisi.exercise.smarttoy.search.actions;

import java.util.LinkedList;
import java.util.List;

//import Dominio.Orientacion;

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
	public static int casilla;
	private char agentOrientation;
	/**
	 * This method updates a tree node state when the search process is running.
	 * It does not updates the real world state.
	 */
	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		AgentSmartToyState agState = (AgentSmartToyState) s;

		this.agentOrientation = agState.getCharOrientacion();
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
		switch (this.agentOrientation) {
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
		if ((planoHabitacionAgente[fila][columna].equals(AgentSmartToyPerception.EMPTY_PERCEPTION)
				|| planoHabitacionAgente[fila][columna].equals(AgentSmartToyPerception.PISO_ARENA)
				|| planoHabitacionAgente[fila][columna].equals(AgentSmartToyPerception.PISO_BASURA)
				|| planoHabitacionAgente[fila][columna].equals(AgentSmartToyPerception.PISO_MOJADO)
				|| planoHabitacionAgente[fila][columna].equals(AgentSmartToyPerception.PISO_ALFOMBRA)
				|| planoHabitacionAgente[fila][columna].equals(AgentSmartToyPerception.ESCALERA))
				&& EstadoNoProbado(fila, columna, agState.getCharOrientacion(), agState.getEstadosProbados())) {
			agState.getUbicacionAgente().setSecond(new int[] { fila, columna });
			agState.getEstadosProbados().add(Integer.toString(fila)+Integer.toString(columna)+agState.getCharOrientacion());
			casilla = obtenerReferenciaDeTerreno(planoHabitacionAgente[fila][columna]); 
			agState.setTiempo(agState.getTiempo() + this.getCost());
			agState.setCeldasVisitadas(agState.getCeldasVisitadas()+1);
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

		this.agentOrientation = agState.getCharOrientacion();
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

		if ((planoHabitacionAgente[fila][columna].equals(AgentSmartToyPerception.EMPTY_PERCEPTION)
				|| planoHabitacionAgente[fila][columna].equals(AgentSmartToyPerception.PISO_ARENA)
				|| planoHabitacionAgente[fila][columna].equals(AgentSmartToyPerception.PISO_BASURA)
				|| planoHabitacionAgente[fila][columna].equals(AgentSmartToyPerception.PISO_MOJADO)
				|| planoHabitacionAgente[fila][columna].equals(AgentSmartToyPerception.PISO_ALFOMBRA)
				|| planoHabitacionAgente[fila][columna].equals(AgentSmartToyPerception.ESCALERA))
				&& EstadoNoProbado(fila, columna, agState.getCharOrientacion(), agState.getEstadosProbados())) {
			agState.getUbicacionAgente().setSecond(new int[] { fila, columna });
			agState.getEstadosProbados().add(Integer.toString(fila)+Integer.toString(columna)+agState.getCharOrientacion());
			environmentState.getUbicacionAgente().setSecond(new int[] { fila, columna });
			environmentState.celdasVisitadas = environmentState.celdasVisitadas + 1;
			casilla = obtenerReferenciaDeTerreno(planoHabitacionAgente[fila][columna]);
			agState.setTiempo(agState.getTiempo() + this.getCost());
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
		// 1: PISO_ARENA
		// 1: PISO_BASURA
		// 1: PISO_ALFOMBRA 
		// 2: PISO_MOJADO
		// 3: ESCALERA
		// DEFAULT: PISO NORMAL (CELDA VACIA)
		switch(casilla){
		case 1:
			return 2.0;
		case 2:
			return 0.5;
		case 3: // Las dos escaleras de la casa van de norte a sur en subida y sur a norte en bajada.
			if(this.agentOrientation == 'N'){
				// escalera subida
				return 2.0;
			} else {
				if(this.agentOrientation == 'S'){
					//escalera bajada
					return 0.5;
				}
				else return 1.0; //si se mueve en la escalera sin subir ni bajar
			}
		}
		return 1.0; // piso normal
	}
	
	private int obtenerReferenciaDeTerreno(String s){
		if(s == AgentSmartToyPerception.PISO_MOJADO){
			return 2;
		}
		else {
			if(s == AgentSmartToyPerception.PISO_BASURA || s == AgentSmartToyPerception.PISO_ARENA
					|| s == AgentSmartToyPerception.PISO_ALFOMBRA){
				return 1;
			}
			else{
				if(s == AgentSmartToyPerception.ESCALERA){
					return 3;
				}
			}
		}
		// piso normal
		return 0;
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