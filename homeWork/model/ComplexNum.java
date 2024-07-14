package model;

public class ComplexNum {
    private final double real;
    private final double imaginary;

    public ComplexNum(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    @Override
    public String toString() {
        return String.format("( %s, %si )", real, imaginary);
    }
}
