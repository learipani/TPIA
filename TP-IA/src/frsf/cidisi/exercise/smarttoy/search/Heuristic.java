package frsf.cidisi.exercise.smarttoy.search;

import frsf.cidisi.faia.solver.search.IEstimatedCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

/**
 * This class allows to define a function to be used by any
 * informed search strategy, like A Star or Greedy.
 */
public class Heuristic implements IEstimatedCostFunction {

    /**
     * It returns the estimated cost to reach the goal from a NTree node.
     */
    @Override
    public double getEstimatedCost(NTree node) {
        
    	AgentSmartToyState agState = (AgentSmartToyState) node.getAgentState();
		int[] ubicacionActual = new int[2];
		int[] ubicacionObjetivo = new int[2];
		double distancia, cuadrado1, cuadrado2;
        
		if(agState.getUbicacionAgente().getFirst().getIdHabitacion()==agState.getNumeroHabitacionSmartPhone()){
			ubicacionObjetivo = agState.getUbicacionAgente().getFirst().getUbicacionCentralParaHeuristica();
			ubicacionActual = agState.getUbicacionAgente().getSecond();
        	cuadrado1 = Math.pow(ubicacionObjetivo[0]-ubicacionActual[0], 2);
        	cuadrado2 = Math.pow(ubicacionObjetivo[1]-ubicacionActual[1], 2);
        	distancia = Math.sqrt(cuadrado1+cuadrado2);
        }
        else{
        	ubicacionObjetivo = agState.getUbicacionObjetivoParaHeuristica();
        	ubicacionActual = agState.getUbicacionAgente().getFirst().getUbicacionCentralParaHeuristica();
        	cuadrado1 = Math.pow(ubicacionObjetivo[0]-ubicacionActual[0], 2);
        	cuadrado2 = Math.pow(ubicacionObjetivo[1]-ubicacionActual[1], 2);
        	distancia = Math.sqrt(cuadrado1+cuadrado2);
        }
        
        return distancia;
    }
}
