package frsf.cidisi.exercise.pacman.search;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

/**
 * Represent the internal state of the Agent.
 */
public class PacmanAgentState extends SearchBasedAgentState {
	
	//TODO: Setup Variables
    private int[][] world;
    private int[] position;
    private int[] initialPosition;
    private int energy;
    private int visitedCells;
	

    public PacmanAgentState() {
    
    	//TODO: Complete Method
    	/*
			// world = initData0;
			// position = initData1;
			// initialPosition = initData2;
			// energy = initData3;
			// visitedCells = initData4;
        */
        this.initState();
    }

    /**
     * This method clones the state of the agent. It's used in the search
     * process, when creating the search tree.
     */
    @Override
    public SearchBasedAgentState clone() {
        
		//TODO: Complete Method
		
        return null;
    }

    /**
     * This method is used to update the Agent State when a Perception is
     * received by the Simulator.
     */
    @Override
    public void updateState(Perception p) {
        
        //TODO: Complete Method
    }

    /**
     * This method is optional, and sets the initial state of the agent.
     */
    @Override
    public void initState() {
        
	//TODO: Complete Method

    }

    /**
     * This method returns the String representation of the agent state.
     */
    @Override
    public String toString() {
        String str = "";

        //TODO: Complete Method

        return str;
    }

    /**
     * This method is used in the search process to verify if the node already
     * exists in the actual search.
     */
    @Override
    public boolean equals(Object obj) {
       
       //TODO: Complete Method
        
        return true;
    }

    //TODO: Complete this section with agent-specific methods
    // The following methods are agent-specific:
   	
     public int[][] getworld(){
        return world;
     }
     public void setworld(int[][] arg){
        world = arg;
     }
     public int[] getposition(){
        return position;
     }
     public void setposition(int[] arg){
        position = arg;
     }
     public int[] getinitialPosition(){
        return initialPosition;
     }
     public void setinitialPosition(int[] arg){
        initialPosition = arg;
     }
     public int getenergy(){
        return energy;
     }
     public void setenergy(int arg){
        energy = arg;
     }
     public int getvisitedCells(){
        return visitedCells;
     }
     public void setvisitedCells(int arg){
        visitedCells = arg;
     }
	
}

