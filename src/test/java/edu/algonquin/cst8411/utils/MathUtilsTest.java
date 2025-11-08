/*
CST8411 – Information Systems Development and Deployment
Assignment 1: Library Packaging & Publication (GitHub Packages)
File: MathUtilsTest.java
Student ID: 041142952
Name: Rachid Hankir
Instructor: Ziad Ewais
Repository: https://github.com/Hank0007AC/cst8411-assigment1-utils
Package: edu.algonquin.cst8411:cst8411-assigment1-utils:1.0.0
Date: 2025-11-07
*/
package edu.algonquin.cst8411.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    @Test
    void mod_handlesPositive() {
        assertEquals(2, MathUtils.mod(5, 3));
    }

    @Test
    void mod_handlesNegativeDividend() {
        assertEquals(1, MathUtils.mod(-5, 3));
    }

    @Test
    void mod_throwsOnZeroDivisor() {
        assertThrows(IllegalArgumentException.class, () -> MathUtils.mod(5, 0));
    }

    @Test
    void pow_basicPositive() {
        assertEquals(8.0, MathUtils.pow(2.0, 3), 1e-12);
    }

    @Test
    void pow_zeroExponent() {
        assertEquals(1.0, MathUtils.pow(123.0, 0), 1e-12);
    }

    @Test
    void pow_negativeExponent() {
        assertEquals(0.25, MathUtils.pow(2.0, -2), 1e-12);
    }

    @Test
    void sqrt_basic() {
        assertEquals(10.0, MathUtils.sqrt(100.0), 1e-9);
    }

    @Test
    void sqrt_throwsOnNegative() {
        assertThrows(IllegalArgumentException.class, () -> MathUtils.sqrt(-1.0));
    }

    @Test
    void percent_basic() {
        assertEquals(25.0, MathUtils.percent(1, 4), 1e-12);
    }

    @Test
    void percent_throwsOnZeroWhole() {
        assertThrows(IllegalArgumentException.class, () -> MathUtils.percent(1, 0));
    }
}
