package solvers;


import heuristics.IHeuristic;
import problems.IProblem;
public class SidewaysMoveHillClimbing<T extends IProblem> implements ISolver<T> {
    private IHeuristic<T> heuristic;
    private final int MAX_SIDEWAYS_MOVES = 100;

    public SidewaysMoveHillClimbing(IHeuristic<T> heuristic) {
        this.heuristic = heuristic;
    }

    public T getFinalState(T problem) {
        
        T currentProblem = (T) problem.clone();
        double score = heuristic.evaluate(currentProblem);

        int sidewaysMoves = 0;
        while (sidewaysMoves < MAX_SIDEWAYS_MOVES) {
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
            if (bestScore >= score) {
                currentProblem = bestNeighbor;
                score = bestScore;

                // If the best neighbor is the same as the current cube, increment the sideways moves counter
                if (bestScore == score) {
                    sidewaysMoves++;
                } else {
                    sidewaysMoves = 0;
                }
            } else {
                break;
            }
        }

        // Print the result
        return currentProblem;
    }
}

