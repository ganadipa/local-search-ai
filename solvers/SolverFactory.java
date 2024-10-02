package solvers;



import heuristics.IHeuristic;
import problems.IProblem;

public class SolverFactory {
    static public enum SolverType {
        STEEPEST_ASCENT_HILL_CLIMBING,
        SIDEWAYS_MOVE_HILL_CLIMBING,
        RANDOM_RESTART_HILL_CLIMBING,
        STOCHASTIC_HILL_CLIMBING,
        SIMULATED_ANNEALING
    }


    public static <T extends IProblem> ISolver<T> createSolver(SolverType algorithm, IHeuristic<T> heuristic) {
        switch (algorithm) {
            case STEEPEST_ASCENT_HILL_CLIMBING:
                return new SteepestAscentHillClimbing<>(heuristic);
            case SIDEWAYS_MOVE_HILL_CLIMBING:
                return new SidewaysMoveHillClimbing<>(heuristic);
            case RANDOM_RESTART_HILL_CLIMBING:
                return new RandomRestartHillClimbing<>(heuristic);
            case STOCHASTIC_HILL_CLIMBING:
                return new StochasticHillClimbing<>(heuristic);
            case SIMULATED_ANNEALING:
                return new SimulatedAnnealing<>(heuristic);
            default:
                throw new IllegalArgumentException("Unknown solver type: " + algorithm);
        }
    }
}
