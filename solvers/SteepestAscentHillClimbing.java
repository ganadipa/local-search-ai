package solvers;


import heuristics.IHeuristic;
import problems.IProblem;
public class SteepestAscentHillClimbing<T extends IProblem> implements ISolver<T> {
    private IHeuristic<T> heuristic;

    public SteepestAscentHillClimbing(IHeuristic<T> heuristic) {
        this.heuristic = heuristic;
    }

    public T getFinalState(T problem) {
        

        T currentProblem = (T) problem.clone();
        double score = heuristic.evaluate(currentProblem);

        while (true) {
            T bestNeighbor = null;
            double bestScore = Double.NEGATIVE_INFINITY;

            // Find the best neighbor
            for (IProblem neighbor : currentProblem.getNeighbours()) {
                T castedNeighbor = (T) neighbor;
                double neighborScore = heuristic.evaluate(castedNeighbor);
                
                if (neighborScore > bestScore) {
                    bestNeighbor = castedNeighbor;
                    bestScore = neighborScore;
                }
            }

            // If the best neighbor is better than the current cube, move to the best neighbor
            if (bestScore > score) {
                currentProblem = bestNeighbor;
                score = bestScore;
            } else {
                break;
            }
        }

        // Print the result
        return currentProblem;
    }
}

