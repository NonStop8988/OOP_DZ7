package view;

import controller.CalculationComplexNumController;
import controller.StringToExpressionController;
import model.ComplexNum;
import service.*;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class CalculationView {

    private final StringToExpressionController stringToExpressionController;
    private final CalculationComplexNumController calculationComplexNumController;
    private final Logger logger;

    public CalculationView() throws IOException {
        this.logger = Logger.getLogger(CalculationView.class.getName());
        FileHandler fh = new FileHandler("log.txt", true);
        logger.addHandler(fh);
        logger.setUseParentHandlers(false);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        // Dependency injection
        ComplexNumService complexNumService = new ComplexNumService();
        CalculationComplexNumService calculationComplexNumService = new CalculationComplexNumService();
        this.stringToExpressionController = new StringToExpressionController(new StringToExpressionService(complexNumService));
        this.calculationComplexNumController = new CalculationComplexNumController(calculationComplexNumService);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первую часть первого комплексного числа (действительная часть):");
        double real1 = scanner.nextDouble();
        System.out.println("Введите вторую часть первого комплексного числа (мнимая часть):");
        double imaginary1 = scanner.nextDouble();

        System.out.println("Введите первую часть второго комплексного числа (действительная часть):");
        double real2 = scanner.nextDouble();
        System.out.println("Введите вторую часть второго комплексного числа (мнимая часть):");
        double imaginary2 = scanner.nextDouble();

        ComplexNum n1 = new ComplexNum(real1, imaginary1);
        ComplexNum n2 = new ComplexNum(real2, imaginary2);

        System.out.println("Введите действие (+, *, /):");
        String action = scanner.next();

        logger.info("Получение выражения от пользователя");
        switch (action) {
            case "+" -> System.out.println(sumComplexNum(n1, n2));
            case "*" -> System.out.println(multiplyComplexNum(n1, n2));
            case "/" -> System.out.println(divideComplexNum(n1, n2));
            default -> System.out.println("Операция не поддерживается");
        }
    }

    private ComplexNum sumComplexNum(ComplexNum num1, ComplexNum num2) {
        logger.info("Суммирование чисел: " + num1 + " и " + num2);
        return calculationComplexNumController.sumComplexNum(num1, num2);
    }

    private ComplexNum multiplyComplexNum(ComplexNum num1, ComplexNum num2) {
        logger.info("Умножение чисел: " + num1 + " и " + num2);
        return calculationComplexNumController.multiplyComplexNum(num1, num2);
    }

    private ComplexNum divideComplexNum(ComplexNum num1, ComplexNum num2) {
        logger.info("Деление чисел: " + num1 + " и " + num2);
        return calculationComplexNumController.divideComplexNum(num1, num2);
    }
}
