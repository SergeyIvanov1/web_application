package com.ivanov_sergey.game.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathTest {

    private Math math;

    @BeforeEach
    void setup(){
        math = new Math();
    }

    @Test
    void sumPositive_ShouldThrowException_WhenAIsLessZero() {
        assertThrows(RuntimeException.class, () -> math.sumPositive(-1,12));
    }

    @Test
    void sumPositive_Successful_WhenDataIsCorrect() {
        int expected = 10;
        int actual = math.sumPositive(4, 6);
        assertEquals(expected, actual);
    }
}