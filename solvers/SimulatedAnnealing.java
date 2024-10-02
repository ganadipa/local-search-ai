package solvers;

import heuristics.IHeuristic;
import problems.IProblem;

public class SimulatedAnnealing<T extends IProblem> implements ISolver<T> {
    private IHeuristic<T> heuristic;
    private final double T_INITIAL = 1e8;
    private final double T_FINAL = 0.1;
    private final double COOLING_RATE = 0.99;



    public SimulatedAnnealing(IHeuristic<T> heuristic) {
        this.heuristic = heuristic;
    }

    public T getFinalState(T problem) {

        T currentProblem = (T) problem.clone();
        double score = heuristic.evaluate(currentProblem);

        double T = T_INITIAL;
        int count = 0;
        while (T > T_FINAL) {
            count++;
            // Generate random successor
            T randomSuccessor = (T) currentProblem.generateRandomNeighbour();

            // Evaluate the random successor
            double randomSuccessorScore = heuristic.evaluate(randomSuccessor);

            // If the random successor is better than the current cube, move to the random successor
            if (randomSuccessorScore > score) {
                currentProblem = randomSuccessor;
                score = randomSuccessorScore;
            } else {

                // If the random successor is worse than the current cube, move to the random successor with a probability
                double delta = randomSuccessorScore - score;
                double probability = Math.exp(delta / T);

                // If due to the probability, the random successor is chosen, move to the random successor
                if (Math.random() < probability) {
                    currentProblem = randomSuccessor;
                    score = randomSuccessorScore;
                }
            }

            T *= COOLING_RATE;
            System.out.println("Iteration " + count + ": " + score);
        }





        return currentProblem;
    }
}
