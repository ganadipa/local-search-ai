package heuristics;

import java.util.ArrayList;
import java.util.List;

import problems.MagicCube;
import shapes.Cube;

public class BaseHeuristic implements IHeuristic<MagicCube> {
    public double evaluate(MagicCube cube) {
        Cube c = cube.cube;

        List<Integer> sums = new ArrayList<>();

        // Add all sums that is perpendicular to the xy-plane
        for (int x = 0; x < c.getLength(); x++) {
            for (int y = 0; y < c.getLength(); y++) {
                int current = 0;

                for (int z = 0; z < c.getLength(); z++) {
                    current += c.get(x, y, z);
                }

                sums.add(current);
            }
        }

        // Add all sums that is perpendicular to the xz-plane
        for (int x = 0; x < c.getLength(); x++) {
            for (int z = 0; z < c.getLength(); z++) {
                int current = 0;

                for (int y = 0; y < c.getLength(); y++) {
                    current += c.get(x, y, z);
                }

                sums.add(current);
            }
        }

        // Add all sums that is perpendicular to the yz-plane
        for (int y = 0; y < c.getLength(); y++) {
            for (int z = 0; z < c.getLength(); z++) {
                int current = 0;

                for (int x = 0; x < c.getLength(); x++) {
                    current += c.get(x, y, z);
                }

                sums.add(current);
            }
        }

        // Add the space diagonal

        // Diagonal from (0, 0, 0) to (n-1, n-1, n-1)
        int current = 0;
        for (int i = 0; i < c.getLength(); i++) {
            current += c.get(i, i, i);
        }
        sums.add(current);

        // Diagonal from (0, 0, n-1) to (n-1, n-1, 0)
        current = 0;
        for (int i = 0; i < c.getLength(); i++) {
            current += c.get(i, i, c.getLength() - i - 1);
        }

        // Diagonal from (0, n-1, 0) to (n-1, 0, n-1)
        current = 0;
        for (int i = 0; i < c.getLength(); i++) {
            current += c.get(i, c.getLength() - i - 1, i);
        }
        sums.add(current);

        // Diagonal from (n-1, 0, 0) to (0, n-1, n-1)
        current = 0;
        for (int i = 0; i < c.getLength(); i++) {
            current += c.get(c.getLength() - i - 1, i, i);
        }
        sums.add(current);



        // Add the plane diagonals

        // in the xy-plane
        for (int z = 0; z < c.getLength(); z++) {
            current = 0;
            for (int i = 0; i < c.getLength(); i++) {
                current += c.get(i, i, z);
            }
            sums.add(current);

            current = 0;
            for (int i = 0; i < c.getLength(); i++) {
                current += c.get(i, c.getLength() - i - 1, z);
            }
            sums.add(current);
        }

        // in the xz-plane
        for (int y = 0; y < c.getLength(); y++) {
            current = 0;
            for (int i = 0; i < c.getLength(); i++) {
                current += c.get(i, y, i);
            }
            sums.add(current);

            current = 0;
            for (int i = 0; i < c.getLength(); i++) {
                current += c.get(i, y, c.getLength() - i - 1);
            }
            sums.add(current);
        }

        // in the yz-plane
        for (int x = 0; x < c.getLength(); x++) {
            current = 0;
            for (int i = 0; i < c.getLength(); i++) {
                current += c.get(x, i, i);
            }
            sums.add(current);

            current = 0;
            for (int i = 0; i < c.getLength(); i++) {
                current += c.get(x, i, c.getLength() - i - 1);
            }
            sums.add(current);
        }

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

