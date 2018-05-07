package frsf.cidisi.exercise.pacman.search;

import frsf.cidisi.exercise.pacman.search.actions.Eat;
import frsf.cidisi.exercise.pacman.search.actions.Fight;
import frsf.cidisi.exercise.pacman.search.actions.GoLeft;
import frsf.cidisi.exercise.pacman.search.actions.GoUp;
import frsf.cidisi.exercise.pacman.search.actions.GoRight;
import frsf.cidisi.exercise.pacman.search.actions.GoDown;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.solver.search.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Vector;

public class PacmanAgent extends SearchBasedAgent {

    public PacmanAgent() {

        // The Agent Goal
        PacmanGoal agGoal = new PacmanGoal();

        // The Agent State
        PacmanAgentState agState = new PacmanAgentState();
        this.setAgentState(agState);

        // Create the operators
        Vector<SearchAction> operators = new Vector<SearchAction>();
        operators.addElement(new Eat());	
        operators.addElement(new Fight());	
        operators.addElement(new GoLeft());	
        operators.addElement(new GoUp());	
        operators.addElement(new GoRight());	
        operators.addElement(new GoDown());	

        // Create the Problem which the agent will resolve
        Problem problem = new Problem(agGoal, agState, operators);
        this.setProblem(problem);
    }

    /**
     * This method is executed by the simulator to ask the agent for an action.
     */
    @Override
    public Action selectAction() {

        // Create the search strategy
        DepthFirstSearch strategy = new DepthFirstSearch();          

        // Create a Search object with the strategy
        Search searchSolver = new Search(strategy);

        /* Generate an XML file with the search tree. It can also be generated
         * in other formats like PDF with PDF_TREE */
        searchSolver.setVisibleTree(Search.GRAPHVIZ_TREE);

        // Set the Search searchSolver.
        this.setSolver(searchSolver);

        // Ask the solver for the best action
        Action selectedAction = null;
        try {
            selectedAction =
                    this.getSolver().solve(new Object[]{this.getProblem()});
        } catch (Exception ex) {
            Logger.getLogger(PacmanAgent.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Return the selected action
        return selectedAction;

    }

    /**
     * This method is executed by the simulator to give the agent a perception.
     * Then it updates its state.
     * @param p
     */
    @Override
    public void see(Perception p) {
        this.getAgentState().updateState(p);
    }
}
