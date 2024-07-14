package service;

import model.ComplexNum;

public class CalculationComplexNumService {

    public ComplexNum sumComplexNum(ComplexNum n1, ComplexNum n2) {
        double real = n1.getReal() + n2.getReal();
        double imaginary = n1.getImaginary() + n2.getImaginary();
        return new ComplexNum(real, imaginary);
    }

    public ComplexNum multiplyComplexNum(ComplexNum n1, ComplexNum n2) {
        double real = n1.getReal() * n2.getReal() - n1.getImaginary() * n2.getImaginary();
        double imaginary = n1.getReal() * n2.getImaginary() + n1.getImaginary() * n2.getReal();
        return new ComplexNum(real, imaginary);
    }

    public ComplexNum divideComplexNum(ComplexNum n1, ComplexNum n2) {
        ComplexNum conjugate = new ComplexNum(n2.getReal(), -n2.getImaginary());
        ComplexNum numerator = multiplyComplexNum(n1, conjugate);
        double denominator = n2.getReal() * n2.getReal() + n2.getImaginary() * n2.getImaginary();
        return new ComplexNum(numerator.getReal() / denominator, numerator.getImaginary() / denominator);
    }
}
