
import heuristics.NotEqualHeuristic;
import heuristics.StandardDeviationHeuristic;
import heuristics.DifferenceMagicNumber;
import heuristics.IHeuristic;
import heuristics.NotEqualAndStdHeuristic;
import problems.MagicCube;
import shapes.Cube;
import solvers.ISolver;
import solvers.RandomRestartHillClimbing;

public class Main {
    public static void main(String[] args) {
        Integer size = 3;
        Cube cube = new Cube(size);
        
        // assign 1 to n^3 to the cube
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    cube.set(i, j, k, i * size * size + j * size + k + 1);
                }
            }
        }
    

        // create a magic cube
        MagicCube magicCube = new MagicCube(cube);

        // randomize the cube
        magicCube.randomize();

        // find a heuristic
        IHeuristic<MagicCube> heur = new DifferenceMagicNumber();

        // find a solver
        ISolver<MagicCube> solver = new RandomRestartHillClimbing<>(heur);

        // get the final state using this chosen local search
        solver.getFinalState(magicCube);
    }
}