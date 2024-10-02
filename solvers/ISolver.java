package solvers;

import problems.IProblem;


public interface ISolver<T extends IProblem> {
    public T getFinalState(T problem);
}
