package problems;

import java.util.List;

import utilities.Prototype;

public interface IProblem extends Prototype<IProblem> {
    public IProblem clone();

    public List<? extends IProblem> getNeighbours();    
}
