package org.verigo.solver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("quadraticEquationSolver")
public class QuadraticEquationSolver implements EquationSolver {
    private double a;
    private double b;
    private double c;

    private double D;

    @Override
    public void setCoefficients(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double[] solve() {
        D = b * b - 4 * a * c;
        if (D > 0) {
            double x1, x2;
            x1 = (-b - Math.sqrt(D)) / (2 * a);
            x2 = (-b + Math.sqrt(D)) / (2 * a);
            return new double[] {x1, x2};
        }
        else if (D == 0) {
            double x;
            x = -b / (2 * a);
            return new double[] {x};
        }
        return new double[] {};
    }
}
