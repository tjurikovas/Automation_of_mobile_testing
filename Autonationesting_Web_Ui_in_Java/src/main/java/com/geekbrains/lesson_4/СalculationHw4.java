package com.geekbrains.lesson_4;

public class СalculationHw4 {


    public static float calculationAreaTriangle(int a, int b, int c) throws NullSideTriangleException, ExceptionDegenerateTriangle {
        if (a < 1 | b < 1 | c < 1) {
            throw new NullSideTriangleException();
        } else if ((a + b) < c | (a + c) < b | (b + c) < a) {
            throw new ExceptionDegenerateTriangle();
        } else {
            float p = (float) (a + b + c) / 2;
            System.out.println("Площадь треугольника = " + p);
            return p;
        }
    }
}
