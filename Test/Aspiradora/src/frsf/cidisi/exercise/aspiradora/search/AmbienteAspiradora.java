package frsf.cidisi.exercise.aspiradora.search;

import domain.Habitacion;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.environment.Environment;

public class AmbienteAspiradora extends Environment {

    public AmbienteAspiradora() {
        // Create the environment state
        this.environmentState = new EstadoAmbiente();
    }

    public EstadoAmbiente getEnvironmentState() {
        return (EstadoAmbiente) super.getEnvironmentState();
    }

    /**
     * This method is called by the simulator. Given the Agent, it creates
     * a new perception reading, for example, the agent position.
     * @param agent
     * @return A perception that will be given to the agent by the simulator.
     */
    @Override
    public  AspiradoraPerception getPercept() {
        
    	//Creamos la percepci�n que el agente obtendr�a, a partir del estado actual del ambiente
        AspiradoraPerception perception = new AspiradoraPerception();
		
        //Pimero chequeamos que la habitaci�n en la que est� el agente est� sucia
        Habitacion h = this.getEnvironmentState().getposicionAspiradora();
        boolean estaSucia = false;
        for(Habitacion hab : this.getEnvironmentState().gethabitacionesSucias())
        	if(hab.getNombre().equals(h.getNombre()))
        		estaSucia = true;
        
        //Si lo est�, el valor de la percepci�n ser� 1; en caso contrario ser� 0
        if(estaSucia)
        	perception.setsuciedad(1);
        else
        	perception.setsuciedad(0);
        
        // Return the perception
        return perception;
    }

    
    public String toString() {
        return environmentState.toString();
    }

    //Este m�todo indica bajo qu� condici�n se considera que el agente ha fallado
    public boolean agentFailed(Action actionReturned) {
    	boolean failed = false;

    	//Notar que en este punto tenemos 3 posibilidades inmediatas:
    	//1 - Agregar al estado del ambiente el atributo que nos indica falla (energ�a)
    	//2 - Agregar un operador que se denomine "apagar" (que vendr� en "actionReturned")
    	//3 - Modificar GoalBasedAgentSimulator para que pase el AgentState en lugar de Action

        return failed;
    }

}
