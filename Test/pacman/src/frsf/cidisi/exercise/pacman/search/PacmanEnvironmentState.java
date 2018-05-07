package frsf.cidisi.exercise.pacman.search;

import frsf.cidisi.faia.state.EnvironmentState;

/**
 * This class represents the real world state.
 */
public class PacmanEnvironmentState extends EnvironmentState {
	
	//TODO: Setup Variables
    private int[][] world;
    private int[] agentPosition;
    private int agentEnergy;
	
    public PacmanEnvironmentState() {
        
        //TODO: Complete Method
    	/*
			// world = initData0;
			// agentPosition = initData1;
			// agentEnergy = initData2;
        */
        this.initState();
    }

    /**
     * This method is used to setup the initial real world.
     */
    @Override
    public void initState() {

        //TODO: Complete Method
    }

    /**
     * String representation of the real world state.
     */
    @Override
    public String toString() {
        String str = "";

        //TODO: Complete Method

        return str;
    }

	//TODO: Complete this section with agent-specific methods
    // The following methods are agent-specific:
	
     public int[][] getworld(){
        return world;
     }
     public void setworld(int[][] arg){
        world = arg;
     }
     public int[] getagentPosition(){
        return agentPosition;
     }
     public void setagentPosition(int[] arg){
        agentPosition = arg;
     }
     public int getagentEnergy(){
        return agentEnergy;
     }
     public void setagentEnergy(int arg){
        agentEnergy = arg;
     }
	

}

