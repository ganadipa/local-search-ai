package heuristics;

import problems.MagicCube;
import java.util.*;

public class DifferenceMagicNumber implements IHeuristic<MagicCube> {
    public double evaluate(MagicCube cube) {
        List<Integer> sums = cube.getEssentialValues();

        Integer cumulativeDiff = 0;
        for (Integer sum : sums) {
            cumulativeDiff += Math.abs(sum - cube.magicNumber);
        }

        return -cumulativeDiff;
    }
}



