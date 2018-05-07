package frsf.cidisi.exercise.smarttoy.search;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class AgentSmartToyPerception extends Perception {

	//TODO: Setup Statics
    //public static int UNKNOWN_PERCEPTION = -1;   
	
	
	//TODO: Setup Sensors
//	private Other smartphone;
//	private Other sensorfrontal;
	private int sensorlateralizquierdo;
	private int sensorlateralderecho;
	private int sensortrasero;
	
 

    public  AgentSmartToyPerception() {
    	//TODO: Complete Method
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
    //TODO: Complete this section with the agent-specific methods
	
//     public Other getsmartphone(){
//        return smartphone;
//     }
//     public void setsmartphone(Other arg){
//        this.smartphone = arg;
//     }
//     public Other getsensorfrontal(){
//        return sensorfrontal;
//     }
//     public void setsensorfrontal(Other arg){
//        this.sensorfrontal = arg;
//     }
     public int getsensorlateralizquierdo(){
        return sensorlateralizquierdo;
     }
     public void setsensorlateralizquierdo(int arg){
        this.sensorlateralizquierdo = arg;
     }
     public int getsensorlateralderecho(){
        return sensorlateralderecho;
     }
     public void setsensorlateralderecho(int arg){
        this.sensorlateralderecho = arg;
     }
     public int getsensortrasero(){
        return sensortrasero;
     }
     public void setsensortrasero(int arg){
        this.sensortrasero = arg;
     }
	
   
}
