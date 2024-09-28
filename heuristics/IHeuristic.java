package heuristics;

import problems.IProblem;

public interface IHeuristic<T extends IProblem> {
    double evaluate(T game);
}
