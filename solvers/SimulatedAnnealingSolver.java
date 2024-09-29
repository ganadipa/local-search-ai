package solvers;

import heuristics.IHeuristic;
import problems.IProblem;
import shapes.Cube;

public class SimulatedAnnealingSolver<T extends IProblem> implements ISolver {
    private Cube cube;
    private IHeuristic<? extends IProblem> heuristic;

    public SimulatedAnnealingSolver(Cube cube, IHeuristic<? extends IProblem> heuristic) {
        this.cube = cube;
        this.heuristic = heuristic;
    }

    public T getFinalState() {
        // Implement the Simulated Annealing algorithm here
        return null;
    }
}
