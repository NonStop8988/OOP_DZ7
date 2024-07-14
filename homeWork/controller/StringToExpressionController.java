package controller;

import model.ComplexNum;
import service.StringToExpressionService;

public class StringToExpressionController {
    private final StringToExpressionService stringToExpressionService;

    public StringToExpressionController(StringToExpressionService stringToExpressionService) {
        this.stringToExpressionService = stringToExpressionService;
    }

    public void stringToExpression(String mess) {
        try {
            stringToExpressionService.stringToExpression(mess);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ComplexNum getN1() {
        return stringToExpressionService.getN1();
    }

    public ComplexNum getN2() {
        return stringToExpressionService.getN2();
    }

    public String getAction() {
        return stringToExpressionService.getAction();
    }
}
