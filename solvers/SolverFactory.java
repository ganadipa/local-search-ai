package solvers;



import heuristics.IHeuristic;
import problems.IProblem;

public class SolverFactory {
    static public enum SolverType {
        STEEPEST_ASCENT_HILL_CLIMBING,
        SIDEWAYS_MOVE_HILL_CLIMBING,
    }


    public static <T extends IProblem> ISolver createSolver(SolverType algorithm, T problem, IHeuristic<T> heuristic) {
        switch (algorithm) {
            case STEEPEST_ASCENT_HILL_CLIMBING:
                return new SteepestAscentHillClimbing<>(problem, heuristic);
            case SIDEWAYS_MOVE_HILL_CLIMBING:
                return new SidewaysMoveHillClimbing<>(problem, heuristic);
            default:
                throw new IllegalArgumentException("Unknown solver type: " + algorithm);
        }
    }
}
