package heuristics;

import problems.MagicCube;

import utilities.Functions;

public class NotEqualAndStdHeuristic implements IHeuristic<MagicCube> {
    public double evaluate(MagicCube cube) {
        IHeuristic<MagicCube> notEqualHeuristic = new NotEqualHeuristic();
        IHeuristic<MagicCube> stdHeuristic = new StandardDeviationHeuristic();

        return notEqualHeuristic.evaluate(cube) + Functions.sigmoid(stdHeuristic.evaluate(cube));
    }
}



