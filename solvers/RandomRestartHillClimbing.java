package solvers;


import heuristics.IHeuristic;
import problems.IProblem;
import solvers.SolverFactory.SolverType;
public class RandomRestartHillClimbing<T extends IProblem> implements ISolver<T> {
    private IHeuristic<T> heuristic;

    public RandomRestartHillClimbing(IHeuristic<T> heuristic) {
        this.heuristic = heuristic;
    }

    public T getFinalState(T problem) {
        
        T best = (T) problem.clone();
        T current = (T) problem.clone();
        double score = heuristic.evaluate(current);

        ISolver<T> solver= SolverFactory.createSolver(SolverFactory.SolverType.SIDEWAYS_MOVE_HILL_CLIMBING, heuristic);

        int count = 0;

        do {
            count++;

            T localMaxima = solver.getFinalState(current);
            double newScore = heuristic.evaluate(localMaxima);

            if (newScore > score) {
                best = localMaxima;
                score = newScore;
            }

            System.out.println("Iteration " + count + ": " + score);

            current.randomize();
            
        } while (score != 0);

        return best;
    }
}

