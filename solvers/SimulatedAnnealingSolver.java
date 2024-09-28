package solvers;

import heuristics.IHeuristic;
import shapes.Cube;

public class SimulatedAnnealingSolver implements ISolver {
    private Cube cube;
    private IHeuristic heuristic;

    public SimulatedAnnealingSolver(Cube cube, IHeuristic heuristic) {
        this.cube = cube;
        this.heuristic = heuristic;
    }

    public void solve() {
        // Implement the Simulated Annealing algorithm here
    }
}
