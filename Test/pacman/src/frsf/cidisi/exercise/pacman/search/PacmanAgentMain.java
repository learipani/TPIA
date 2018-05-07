package frsf.cidisi.exercise.pacman.search;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class PacmanAgentMain {

    public static void main(String[] args) throws PrologConnectorException {
        PacmanAgent agent = new PacmanAgent();

        PacmanEnvironment environment = new PacmanEnvironment();

        SearchBasedAgentSimulator simulator =
                new SearchBasedAgentSimulator(environment, agent);
        
        simulator.start();
    }

}
