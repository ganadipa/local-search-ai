package heuristics;

import java.util.List;

import problems.MagicCube;
import shapes.Cube;

public class NotEqualHeuristic implements IHeuristic<MagicCube> {
    public double evaluate(MagicCube cube) {

        Cube c = cube.cube;
        List<Integer> sums = cube.getEssentialValues();


        Integer NCubed = c.getLength() * c.getLength() * c.getLength();
        Integer sumOneToNCubed = NCubed * (NCubed + 1) / 2;
        Integer magicNumber = sumOneToNCubed / (c.getLength() * c.getLength());

        // return how many in the sums that are not equal to the magic number
        int count = 0;
        for (Integer sum : sums) {
            if (sum != magicNumber) {
                count++;
            }
        }

        return -count;
    }
}


