import heuristics.BaseHeuristic;
import heuristics.IHeuristic;
import problems.MagicCube;
import shapes.Cube;

public class Debug {
    public static void main(String[] args) {
        Integer size = 5;
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

        System.out.println(std.evaluate(magicCube));


    }
}
