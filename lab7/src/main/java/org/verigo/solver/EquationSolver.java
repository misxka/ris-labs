package org.verigo.solver;

public interface EquationSolver {
    void setCoefficients(double a, double b, double c);
    double[] solve();
}
