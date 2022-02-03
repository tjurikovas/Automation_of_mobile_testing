package com.geekbrains.lesson_4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalculationHw4 {

    Logger logger = LoggerFactory.getLogger("TestCalculationHw4.class");

    @ParameterizedTest
    @DisplayName("Проверка вычисления площади треугольника методом calculationAreaTriangle")
    @CsvSource({"7, 7, 7, 10.5", "2, 4, 3, 4.5", "5, 5, 5, 7.5", "3, 3, 2, 4"})
    void givenCalculation(Integer a, Integer b, Integer c, Float P) throws NullSideTriangleException, ExceptionDegenerateTriangle {
        assertEquals(P, СalculationHw4.calculationAreaTriangle(a, b, c));
        logger.info("log data");
        logger.trace("trace log data");
        logger.error("err log data");
    }

    @ParameterizedTest
    @DisplayName("Проверка метода calculationAreaTriangle на выкидывание NullSileTriangle")
    @CsvSource({"0, 0, 0, 4", "1, 0, 4, 10", "2, 4, 0, 7"})
    void givenExceptionCalculation(Integer a, Integer b, Integer c, Float P) throws NullSideTriangleException {
        Assertions.assertThrows(NullSideTriangleException.class, () -> СalculationHw4.calculationAreaTriangle(a, b, c));
    }

    @ParameterizedTest
    @DisplayName("Проверка метода calculationAreaTriangle на выкидывание ExceptionDegenerateTriangle")
    @CsvSource({"1, 1, 3, 2.5", "2, 8, 5, 7.5", "11, 1, 5, 8.5"})
    void givenExceptionCalculationDegenerate(Integer a, Integer b, Integer c, Float P) throws ExceptionDegenerateTriangle {
        Assertions.assertThrows(ExceptionDegenerateTriangle.class, () -> СalculationHw4.calculationAreaTriangle(a, b, c));
    }
}
