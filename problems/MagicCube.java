package problems;

import java.util.ArrayList;
import java.util.List;

import shapes.Cube;
import utilities.Pair;
import utilities.Triplet;

public class MagicCube implements IProblem {

    public Cube cube;

    public MagicCube(Cube cube) {
        this.cube = cube;
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
    
}
