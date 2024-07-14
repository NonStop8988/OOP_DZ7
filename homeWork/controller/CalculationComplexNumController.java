package controller;

import model.ComplexNum;
import service.CalculationComplexNumService;

public class CalculationComplexNumController {
    private final CalculationComplexNumService calculationComplexNumService;

    public CalculationComplexNumController(CalculationComplexNumService calculationComplexNumService) {
        this.calculationComplexNumService = calculationComplexNumService;
    }

    public ComplexNum sumComplexNum(ComplexNum n1, ComplexNum n2) {
        return calculationComplexNumService.sumComplexNum(n1, n2);
    }

    public ComplexNum multiplyComplexNum(ComplexNum n1, ComplexNum n2) {
        return calculationComplexNumService.multiplyComplexNum(n1, n2);
    }

    public ComplexNum divideComplexNum(ComplexNum n1, ComplexNum n2) {
        return calculationComplexNumService.divideComplexNum(n1, n2);
    }
}
