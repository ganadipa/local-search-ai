package heuristics;

import java.util.List;

import problems.MagicCube;

public class StandardDeviationHeuristic implements IHeuristic<MagicCube> {
    public double evaluate(MagicCube cube) {
        List<Integer> sums = cube.getEssentialValues();

        // Calculate the mean
        double mean = 0;
        for (int sum : sums) {
            mean += sum;
        }

        mean /= sums.size();

        // Calculate the standard deviation
        double standardDeviation = 0;
        for (int sum : sums) {
            standardDeviation += Math.pow(sum - mean, 2);
        }

        standardDeviation = Math.sqrt(standardDeviation / sums.size());

        return -standardDeviation;
    }
}
