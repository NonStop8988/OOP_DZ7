package service;

import model.ComplexNum;

public class StringToExpressionService {
    private final ComplexNumService complexNumService;
    private ComplexNum n1;
    private ComplexNum n2;
    private String action;

    public StringToExpressionService(ComplexNumService complexNumService) {
        this.complexNumService = complexNumService;
    }

    public void stringToExpression(String mess) throws Exception {
        String[] arr = mess.replace("(", "").replace("i)", "").split(" ");
        if (arr.length != 3) {
            throw new Exception("Ошибка ввода");
        }
        String[] n1Arr = arr[0].split(",");
        this.action = arr[1];
        String[] n2Arr = arr[2].split(",");
        if (!isNumber(n1Arr[0]) || !isNumber(n1Arr[1]) || !isNumber(n2Arr[0]) || !isNumber(n2Arr[1])) {
            throw new Exception("Ошибка ввода");
        }
        this.n1 = new ComplexNum(Double.parseDouble(n1Arr[0]), Double.parseDouble(n1Arr[1]));
        this.n2 = new ComplexNum(Double.parseDouble(n2Arr[0]), Double.parseDouble(n2Arr[1]));
    }

    private boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ComplexNum getN1() {
        return n1;
    }

    public ComplexNum getN2() {
        return n2;
    }

    public String getAction() {
        return action;
    }
}
