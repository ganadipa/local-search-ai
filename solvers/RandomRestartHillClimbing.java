package solvers;


import heuristics.IHeuristic;
import problems.IProblem;
public class RandomRestartHillClimbing<T extends IProblem> implements ISolver<T> {
    private IHeuristic<T> heuristic;

    public RandomRestartHillClimbing(IHeuristic<T> heuristic) {
        this.heuristic = heuristic;
    }

    public T getFinalState(T problem) {
        
        T best = (T) problem.clone();
        T current = (T) problem.clone();
        double score = heuristic.evaluate(current);

        ISolver<T> solver= new SteepestAscentHillClimbing<>(heuristic);

        int iter = 0;
        do {
            // Find the local maxima
            T localMaxima = solver.getFinalState(current);
            double newScore = heuristic.evaluate(localMaxima);

            if (newScore > score) {
                best = localMaxima;
                score = newScore;
            }

            // Randomize the current cube
            current.randomize();

            iter++;
            System.out.println("Iteration " + iter + ": " + score);
            
        } while (score != 0);

        return best;
    }
}

