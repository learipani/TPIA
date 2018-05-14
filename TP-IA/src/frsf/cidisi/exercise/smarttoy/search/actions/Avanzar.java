package frsf.cidisi.exercise.smarttoy.search.actions;

import java.util.ArrayList;
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
				/*Si la puerta que tiene delante lo lleva a una habitacion que lo lleva a destino y ademas
				 * no ha visitado esa habitación, entonces, va*/
				if(ExisteCamino(habitacionDelante.getFirst().getIdHabitacion()-1, agState.getNumeroHabitacionSmartPhone()-1, cantidadHabitaciones, matrizAdyacencia) 
						&& !HabitacionVisitada(habitacionDelante.getFirst(), agState.getHabitacionesVisitadas())){
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
				/*Si la puerta que tiene delante lo lleva a una habitacion que lo lleva a destino y ademas
				 * no ha visitado esa habitación, entonces, va*/
				if(ExisteCamino(habitacionDelante.getFirst().getIdHabitacion()-1, agState.getNumeroHabitacionSmartPhone()-1, cantidadHabitaciones, matrizAdyacencia) 
						&& !HabitacionVisitada(habitacionDelante.getFirst(), agState.getHabitacionesVisitadas())){
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
		}
		GirarDerecha.cantidadGirosReales = 0;
		GirarIzquierda.cantidadGirosReales = 0;
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
	
	private Boolean ExisteCamino(int s, int d, int cantidadHabitaciones, LinkedList<Integer> adj[])
	{
		//Guarda los nodos ya visitados
		boolean visited[] = new boolean[cantidadHabitaciones];

		// Create a queue for BFS
		LinkedList<Integer> queue = new LinkedList<Integer>();

		//Marca que el nodo actual fue visitado
		visited[s]=true;
		queue.add(s);

		// i son los vertices adyacentes al vertice actual
		Iterator<Integer> i;
		while (queue.size()!=0)
		{
			// Dequeue a vertex from queue and print it
			s = queue.poll();

			int n;
			i = adj[s].listIterator();

			// Get all adjacent vertices of the dequeued vertex s
			// If a adjacent has not been visited, then mark it
			// visited and enqueue it
			while (i.hasNext())
			{
				n = i.next();

				// If this adjacent node is the destination node,
				// then return true
				if (n==d)
					return true;

				// Else, continue to do BFS
				if (!visited[n])
				{
					visited[n] = true;
					queue.add(n);
				}
			}
		}
		// If BFS is complete without visited d
		return false;
	}

	private boolean HabitacionVisitada(Habitacion hab, List<Habitacion> list) {
		for (Habitacion habitacionVisitada : list) {
			if (habitacionVisitada.getIdHabitacion() == hab.getIdHabitacion()) {
				return true;
			}
		}
		return false;
	}
	
	//Este mtodo hace una lista de int de las habitaciones por las que tiene que ir el agente
	private List<Integer> CalcularCamino(Habitacion habitacionActual, int idHabitacionDestino, List<Habitacion> plano) {
		
		int cantidadHabitaciones = 15; //Esto se debe modificar si se agregan mas habitaciones
		List<Integer> habitacionesRecorrer = new ArrayList<Integer>(); //Esto es lo que se retorna
		LinkedList<Integer> matrizAdyacencia[] = new LinkedList[15];
		for (int i=0; i<cantidadHabitaciones; ++i)
			matrizAdyacencia[i] = new LinkedList();

		for (Habitacion itemHabitacion : plano) {
			for (Pair<Integer, List<Puerta>> itemHabContigua : itemHabitacion
					.getHabitacionesContiguas()) {
				matrizAdyacencia[itemHabitacion.getIdHabitacion()].add(itemHabContigua.getFirst());
			}
		}
		Habitacion incr = habitacionActual;
		while(incr.getIdHabitacion() != idHabitacionDestino){
			for (Pair<Integer, List<Puerta>> itemHabContigua : incr.getHabitacionesContiguas()) {
				if(ExisteCamino(incr.getIdHabitacion(), idHabitacionDestino, 15, matrizAdyacencia)){
					habitacionesRecorrer.add(itemHabContigua.getFirst());
					incr = plano.get(itemHabContigua.getFirst()-1);
				}
			}
		}
		return habitacionesRecorrer;
	}
}