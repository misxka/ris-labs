package org.verigo.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import java.util.Scanner;

import org.verigo.service.SolverService;

@Component
@PropertySource("application.properties")
public class Main
{
    private static final String BASE_PACKAGE = "org.verigo";

    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(BASE_PACKAGE);
        SolverService solverService = context.getBean(SolverService.class);

        System.out.println("Программа решает квадратное уравнение вида:");
        System.out.println("ax^2 + bx + c = 0");

        char action = '1';
        do {
            System.out.println("Введите a, b и c:");
            Scanner scanner = new Scanner(System.in);
            double a = scanner.nextDouble();
            double b = scanner.nextDouble();
            double c = scanner.nextDouble();

            double[] results = solverService.solveEquation(a, b, c);

            if (results.length == 0) {
                System.out.println("Уравнение не имеет действительных корней!");
            } else if (results.length == 1) {
                System.out.println("Уравнение имеет единственный корень: x = " + results[0]);
            } else {
                System.out.println("Корни уравнения: x1 = " + results[0] + ", x2 = " + results[1]);
            }

            System.out.println("Желаете продолжить?");
            System.out.println("0 - Завершить работу");
            System.out.println("Остальные клавиши - продолжить");
            action = scanner.next().charAt(0);
        } while (action != '0');
    }
}
