package frsf.cidisi.exercise.smarttoy.search;

import domain.Habitacion;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;
import frsf.cidisi.faia.state.datastructure.Pair;

public class AgentSmartToyPerception extends Perception {

	//TODO: Setup Statics
    public static Object UNKNOWN_PERCEPTION = null;   
	
	
	//TODO: Setup Sensors
	private Habitacion smartphone;	//Envía la habitacíon en la cual se encuentra el agente
	/*Los sensores devuelven letras dependiendo lo que tengan en frente
	 * pu = puerta
	 * pa = pared
	 * ta = terreno adverso
	 * ob = obstaculo
	 * */
	private Object sensorfrontal;
	private Object sensorlateralizquierdo;
	private Object sensorlateralderecho;
	private Object sensortrasero;

    public  AgentSmartToyPerception() {
    	sensorfrontal = UNKNOWN_PERCEPTION;
    	sensorlateralizquierdo = UNKNOWN_PERCEPTION;
    	sensorlateralderecho = UNKNOWN_PERCEPTION;
    	sensortrasero = UNKNOWN_PERCEPTION;
    }

    public AgentSmartToyPerception(Agent agent, Environment environment) {
        super(agent, environment);
    }

    /**
     * This method is used to setup the perception.
     */
    @Override
    public void initPerception(Agent agentIn, Environment environmentIn) {
    	
    	//TODO: Complete Method
        
        //AgentSmartToy agent = (AgentSmartToy) agentIn;
        //EnvironmentSmartToy environment = (EnvironmentSmartToy) environmentIn;
        //EnvironmentSmartToyState environmentState =
        //        environment.getEnvironmentState();

    }
    
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();

        //TODO: Complete Method

        return str.toString();
    }

    // The following methods are agent-specific:
	public Habitacion getSmartphone() {
		return smartphone;
	}

	public void setSmartphone(Habitacion smartphone) {
		this.smartphone = smartphone;
	}

	public Object getSensorfrontal() {
		return sensorfrontal;
	}

	public void setSensorfrontal(Object sensorfrontal) {
		this.sensorfrontal = sensorfrontal;
	}

	public Object getSensorlateralizquierdo() {
		return sensorlateralizquierdo;
	}

	public void setSensorlateralizquierdo(Object sensorlateralizquierdo) {
		this.sensorlateralizquierdo = sensorlateralizquierdo;
	}

	public Object getSensorlateralderecho() {
		return sensorlateralderecho;
	}

	public void setSensorlateralderecho(Object sensorlateralderecho) {
		this.sensorlateralderecho = sensorlateralderecho;
	}

	public Object getSensortrasero() {
		return sensortrasero;
	}

	public void setSensortrasero(Object sensortrasero) {
		this.sensortrasero = sensortrasero;
	}

}
