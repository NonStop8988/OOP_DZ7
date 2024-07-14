package service;

import model.ComplexNum;

public class ComplexNumService {

    public ComplexNum createComplexNum(double real, double imaginary) {
        return new ComplexNum(real, imaginary);
    }

    public ComplexNum conjugate(ComplexNum n) {
        return new ComplexNum(n.getReal(), -n.getImaginary());
    }
}
