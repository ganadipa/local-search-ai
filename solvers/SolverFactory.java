package solvers;

import heuristics.IHeuristic;
import shapes.Cube;

public class SolverFactory {
    public static ISolver createSolver(String algorithm, Cube cube, IHeuristic heuristic) {
        if (algorithm.equals("hill-climbing")) {
            return new HillClimbingSolver(cube, heuristic);
        } else if (algorithm.equals("simulated-annealing")) {
            return new SimulatedAnnealingSolver(cube, heuristic);
        } else {
            return null;
        }
    }
}
