package frsf.cidisi.exercise.smarttoy.search.actions;

import java.util.HashMap;
import java.util.List;

import frsf.cidisi.exercise.smarttoy.search.*;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class GirarIzquierda extends SearchAction {
	
	public static int cantidadGiros=0;
	public static int cantidadGirosReales=0;
	
    /**
     * This method updates a tree node state when the search process is running.
     * It does not updates the real world state.
     */
    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        
    	AgentSmartToyState agState = (AgentSmartToyState) s;
		int fila = agState.getUbicacionAgente().getSecond()[0];
		int columna = agState.getUbicacionAgente().getSecond()[1];
		boolean flag=false;

		//if (EstadoNoProbado(fila, columna, agState.getCharOrientacion(),agState.getEstadosProbados())) {
			boolean[] agentOrientation = agState.getOrientacion();
			// [norte oeste sur este] = [arriba izq abajo der]

			switch (agState.getCharOrientacion()) {
			case 'N':
				agentOrientation[0] = false;
				agentOrientation[3] = true;
				String ep = Integer.toString(fila)+Integer.toString(columna)+"O";
				if(!agState.getEstadosProbados().contains(ep)){
					flag=true;
					agState.setEstadosProbados(ep);
				}
				break;
			case 'O':
				agentOrientation[0] = true;
				agentOrientation[1] = true;
				String ep1 = Integer.toString(fila)+Integer.toString(columna)+"S";
				if(!agState.getEstadosProbados().contains(ep1)){
					flag=true;
					agState.setEstadosProbados(ep1);
				}
				break;
			case 'S':
				agentOrientation[2] = false;
				agentOrientation[1] = true;
				String ep2 = Integer.toString(fila)+Integer.toString(columna)+"E";
				if(!agState.getEstadosProbados().contains(ep2)){
					flag=true;
					agState.setEstadosProbados(ep2);
				}
				break;
			case 'E':
				agentOrientation[3] = false;
				agentOrientation[2] = true;
				String ep3 = Integer.toString(fila)+Integer.toString(columna)+"N";
				if(!agState.getEstadosProbados().contains(ep3)){
					flag=true;
					agState.setEstadosProbados(ep3);
				}
				break;
			}
			if (flag){
				cantidadGiros++;
				agState.setOrientacion(agentOrientation);
				return agState;
			}
		//}
		return null;
    	
    	/*AgentSmartToyState agState = (AgentSmartToyState) s;
		int fila = agState.getUbicacionAgente().getSecond()[0];
		int columna = agState.getUbicacionAgente().getSecond()[1];
        
    	//if(EstadoNoProbado(fila, columna, agState.getCharOrientacion(), agState.getEstadosProbados())){
    		boolean[] agentOrientation = agState.getOrientacion();
	        //[norte oeste sur este]   = [arriba izq abajo der]
	        if (agentOrientation[0]==true){//arriba
	        	agentOrientation[0]=false;
	        	agentOrientation[1]=true;
	        	agState.getEstadosProbados().add(Integer.toString(fila)+Integer.toString(columna)+"O");
	        }
	        else if (agentOrientation[1]==true){//izq
	        	agentOrientation[1]=false;
	        	agentOrientation[2]=true;
	        	agState.getEstadosProbados().add(Integer.toString(fila)+Integer.toString(columna)+"S");
	        }
	        else if (agentOrientation[2]==true){//abajo
	        	agentOrientation[2]=false;
	        	agentOrientation[3]=true;
	        	agState.getEstadosProbados().add(Integer.toString(fila)+Integer.toString(columna)+"E");
	        }
	        else if (agentOrientation[3]==true){//der
	        	agentOrientation[3]=false;
	        	agentOrientation[0]=true;
	        	agState.getEstadosProbados().add(Integer.toString(fila)+Integer.toString(columna)+"N");
	        }
	        cantidadGiros++;    
	        agState.setOrientacion(agentOrientation);
	        return agState;
    	//}
    	return null;*/
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
		boolean flag=false;

		boolean[] agentOrientation = agState.getOrientacion();
		// [norte oeste sur este] = [arriba izq abajo der]
		switch (agState.getCharOrientacion()) {
		case 'N':
			agentOrientation[0] = false;
			agentOrientation[3] = true;
			String ep = Integer.toString(fila)+Integer.toString(columna)+"O";
			if(!agState.getEstadosProbados().contains(ep)){
				flag=true;
				agState.setEstadosProbados(ep);
			}
			break;
		case 'O':
			agentOrientation[0] = true;
			agentOrientation[1] = true;
			String ep1 = Integer.toString(fila)+Integer.toString(columna)+"S";
			if(!agState.getEstadosProbados().contains(ep1)){
				flag=true;
				agState.setEstadosProbados(ep1);
			}
			break;
		case 'S':
			agentOrientation[2] = false;
			agentOrientation[1] = true;
			String ep2 = Integer.toString(fila)+Integer.toString(columna)+"E";
			if(!agState.getEstadosProbados().contains(ep2)){
				flag=true;
				agState.setEstadosProbados(ep2);
			}
			break;
		case 'E':
			agentOrientation[3] = false;
			agentOrientation[2] = true;
			String ep3 = Integer.toString(fila)+Integer.toString(columna)+"N";
			if(!agState.getEstadosProbados().contains(ep3)){
				flag=true;
				agState.setEstadosProbados(ep3);
			}
			break;
		}
		if (flag){
			cantidadGiros++;
			agState.setOrientacion(agentOrientation);
			environmentState.setOrientacionAgente(agentOrientation);
		}
		return environmentState;
    	
    	/*EnvironmentSmartToyState environmentState = (EnvironmentSmartToyState) est;
        AgentSmartToyState agState = ((AgentSmartToyState) ast);
		int fila = agState.getUbicacionAgente().getSecond()[0];
		int columna = agState.getUbicacionAgente().getSecond()[1];
        
        if(EstadoNoProbado(fila, columna, agState.getCharOrientacion(), agState.getEstadosProbados())){
	        boolean[] agentOrientation = agState.getOrientacion();
	        //[norte oeste sur este]   = [arriba izq abajo der]
	        if (agentOrientation[0]==true){//arriba
	        	agentOrientation[0]=false;
	        	agentOrientation[1]=true;
	        	agState.getEstadosProbados().add(Integer.toString(fila)+Integer.toString(columna)+"O");
	        }
	        else if (agentOrientation[1]==true){//izq
	        	agentOrientation[1]=false;
	        	agentOrientation[2]=true;
	        	agState.getEstadosProbados().add(Integer.toString(fila)+Integer.toString(columna)+"S");
	        }
	        else if (agentOrientation[2]==true){//abajo
	        	agentOrientation[2]=false;
	        	agentOrientation[3]=true;
	        	agState.getEstadosProbados().add(Integer.toString(fila)+Integer.toString(columna)+"E");
	        }
	        else if (agentOrientation[3]==true){//der
	        	agentOrientation[3]=false;
	        	agentOrientation[0]=true;
	        	agState.getEstadosProbados().add(Integer.toString(fila)+Integer.toString(columna)+"N");
	        }
	        cantidadGirosReales++;    
	        agState.setOrientacion(agentOrientation);
	        environmentState.setOrientacionAgente(agentOrientation);
        }
        return environmentState; */
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
        return "GirarIzquierda";
    }
    
    private boolean EstadoNoProbado(int fila, int columna, char orientacion,List<String> estadosProbados) {
		String ep = Integer.toString(fila)+Integer.toString(columna)+orientacion;
		if(estadosProbados.contains(ep)){
			return false;
		}
		return true;
	}
    
    /*private boolean EstadoNoProbado(int fila, int columna, char orientacion, HashMap<char[], Integer> hashMap) {
		
		Integer value = hashMap.get(new char[]{(char) fila, (char) columna, orientacion});
		if(value == null){
			return true;
		}
		return false;
	}*/
}