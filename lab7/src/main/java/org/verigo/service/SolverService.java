package org.verigo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.verigo.solver.EquationSolver;

@Service
public class SolverService {

    @Autowired
    private EquationSolver equationSolver;

    public double[] solveEquation(double a, double b, double c) {
        equationSolver.setCoefficients(a, b, c);
        return equationSolver.solve();
    }
}
