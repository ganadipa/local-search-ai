package solvers;


import heuristics.IHeuristic;
import problems.IProblem;
public class SidewaysMoveHillClimbing<T extends IProblem> implements ISolver {
    private T problem;
    private IHeuristic<T> heuristic;

    public SidewaysMoveHillClimbing(T problem, IHeuristic<T> heuristic) {
        this.problem = problem;
        this.heuristic = heuristic;
    }

    public void solve() {
        

        T currentProblem = (T) this.problem.clone();
        double score = -heuristic.evaluate(currentProblem);

        while (true) {
            T bestNeighbor = null;
            double bestScore = Double.NEGATIVE_INFINITY;

            // Find the best neighbor
            for (IProblem neighbor : currentProblem.getNeighbours()) {
                T castedNeighbor = (T) neighbor;
                double neighborScore = -heuristic.evaluate(castedNeighbor);
                
                if (neighborScore > bestScore) {
                    bestNeighbor = castedNeighbor;
                    bestScore = neighborScore;
                }
            }

            // If the best neighbor is better than the current cube, move to the best neighbor
            if (bestScore >= score) {
                currentProblem = bestNeighbor;
                score = bestScore;
            } else {
                break;
            }
        }

        // Print the result
        System.out.println("Best score: " + score);
    }
}

