package problems;

import java.util.ArrayList;
import java.util.List;

import shapes.Cube;
import utilities.Pair;
import utilities.Triplet;

public class MagicCube implements IProblem {

    public Cube cube;
    public Integer magicNumber;

    public MagicCube(Cube cube) {
        this.cube = cube;

        Integer size = cube.getLength();
        Integer NCubed = size * size * size;
        magicNumber = (NCubed * (NCubed + 1) / 2)/(size * size);
    }
    

    public MagicCube clone() {
        return new MagicCube(cube.clone());
    }

    public List<MagicCube> getNeighbours() {
        int size = cube.getLength();

        // Memory for all the neighbors
        List<MagicCube> neighbors = new ArrayList<>();


        // Memory for all the candidate moves
        List<Pair<Triplet<Integer, Integer, Integer>, Triplet<Integer, Integer, Integer>>> moves = new ArrayList<>();

        // Generate all the candidate moves
        for (int x1 = 0; x1 < size; x1++) {
            for (int y1 = 0; y1 < size; y1++) {
                for (int z1 = 0; z1 < size; z1++) {
                    for (int x2 = 0; x2 < size; x2++) {
                        for (int y2 = 0; y2 < size; y2++) {
                            for (int z2 = 0; z2 < size; z2++) {
                                if (x1 == x2 && y1 == y2 && z1 == z2) {
                                    continue;
                                }
                                moves.add(new Pair<>(new Triplet<>(x1, y1, z1), new Triplet<>(x2, y2, z2)));
                            }
                        }
                    }
                }
            }
        }

        // Generate all the neighbors
        for (Pair<Triplet<Integer, Integer, Integer>, Triplet<Integer, Integer, Integer>> move : moves) {
            MagicCube neighbor = this.clone();
            Triplet<Integer, Integer, Integer> from = move.first;
            Triplet<Integer, Integer, Integer> to = move.second;


            // Swap the values
            int temp = neighbor.cube.get(from.first, from.second, from.third);
            neighbor.cube.set(from.first, from.second, from.third, neighbor.cube.get(to.first, to.second, to.third));
            neighbor.cube.set(to.first, to.second, to.third, temp);

            neighbors.add(neighbor);
        }

        return neighbors;
    }

    public List<Integer> getEssentialValues() {
        Cube c = cube;

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
        sums.add(current);

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
        }

        // in the xz-plane
        for (int y = 0; y < c.getLength(); y++) {
            current = 0;
            for (int i = 0; i < c.getLength(); i++) {
                current += c.get(i, y, i);
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
        }

        return sums;
    }

    public void randomize() {
        cube.randomize();
    }

    public MagicCube generateRandomNeighbour() {

        // Clone the current cube
        MagicCube neighbour = this.clone();

        // Generate random triplet
        Triplet<Integer, Integer, Integer> from = new Triplet<>(0, 0, 0);
        Triplet<Integer, Integer, Integer> to = new Triplet<>(0, 0, 0);

        while (from.equals(to)) {
            from = new Triplet<>((int) (Math.random() * cube.getLength()), (int) (Math.random() * cube.getLength()), (int) (Math.random() * cube.getLength()));
            to = new Triplet<>((int) (Math.random() * cube.getLength()), (int) (Math.random() * cube.getLength()), (int) (Math.random() * cube.getLength()));
        }

        // Swap the values
        int temp = neighbour.cube.get(from.first, from.second, from.third);
        neighbour.cube.set(from.first, from.second, from.third, neighbour.cube.get(to.first, to.second, to.third));
        neighbour.cube.set(to.first, to.second, to.third, temp);

        return neighbour;
    }
    
}
