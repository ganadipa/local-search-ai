
import heuristics.BaseHeuristic;
import heuristics.IHeuristic;
import problems.MagicCube;
import shapes.Cube;
import solvers.ISolver;
import solvers.SolverFactory;

public class Main {
    public static void main(String[] args) {
        Integer size = 1;
        Cube cube = new Cube(size);
        
        // assign 1 to n^3 to the cube
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    cube.set(i, j, k, i * size * size + j * size + k + 1);
                }
            }
        }
        
        // randomize the cube
        cube.randomize();

        // create a magic cube
        MagicCube magicCube = new MagicCube(cube);

        // find a heuristic
        IHeuristic<MagicCube> std = new BaseHeuristic();

        // find a solver
        ISolver solver = SolverFactory.createSolver(SolverFactory.SolverType.SIDEWAYS_MOVE_HILL_CLIMBING, magicCube, std);

        // solve the cube
        solver.solve();
    }
}