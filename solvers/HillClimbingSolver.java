package solvers;

import heuristics.IHeuristic;
import shapes.Cube;

public class HillClimbingSolver implements ISolver {
    private Cube cube;
    private IHeuristic heuristic;

    public HillClimbingSolver(Cube cube, IHeuristic heuristic) {
        this.cube = cube;
        this.heuristic = heuristic;
    }

    public void solve() {
        // Implement the Hill Climbing algorithm here
    }
}
