package solvers;


import heuristics.IHeuristic;
import problems.IProblem;
public class StochasticHillClimbing<T extends IProblem> implements ISolver<T> {
    private IHeuristic<T> heuristic;
    private final int N_MAX = 1000;

    public StochasticHillClimbing(IHeuristic<T> heuristic) {
        this.heuristic = heuristic;
    }

    public T getFinalState(T problem) {
        
        T currentProblem = (T) problem.clone();
        double score = heuristic.evaluate(currentProblem);

        int randomMoves = 0;
        while (randomMoves < N_MAX) {
            // Generate random successor
            T randomSuccessor = (T) currentProblem.generateRandomNeighbour();

            // Evaluate the random successor
            double randomSuccessorScore = heuristic.evaluate(randomSuccessor);

            // If the random successor is better than the current cube, move to the random successor
            if (randomSuccessorScore > score) {
                currentProblem = randomSuccessor;
                score = randomSuccessorScore;
            }
        }

        // Print the result
        return currentProblem;
    }
}

