package frsf.cidisi.exercise.smarttoy.search;

import pantalla.Ventana;
import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class AgentSmartToyMain {

    public static void main(String[] args) throws PrologConnectorException {
        AgentSmartToy agent = new AgentSmartToy();

        EnvironmentSmartToy environment = new EnvironmentSmartToy();

        SearchBasedAgentSimulator simulator =
                new SearchBasedAgentSimulator(environment, agent);
        
        new Ventana(environment).setVisible(true);
        simulator.start();
    }

}
