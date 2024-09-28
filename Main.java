import heuristics.IHeuristic;
import heuristics.StandardDeviationHeuristic;
import shapes.Cube;
import solvers.ISolver;
import solvers.SolverFactory;

public class Main {
    public static void main(String[] args) {
        Cube cube = new Cube(5);

        IHeuristic std = new StandardDeviationHeuristic();

        ISolver solver = SolverFactory.createSolver("hill-climbing", cube, std);
        solver.solve();
    }
}