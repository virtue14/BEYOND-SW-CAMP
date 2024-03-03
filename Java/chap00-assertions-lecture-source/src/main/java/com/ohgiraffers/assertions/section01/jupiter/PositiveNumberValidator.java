package com.ohgiraffers.assertions.section01.jupiter;

public class PositiveNumberValidator {
    void checkDividableNumber(int firstNum, int secondNum) throws IllegalArgumentException  {
        if (secondNum == 0) {
            throw new IllegalArgumentException ("0으로 나눌 수 없습니다.");
        }
    }

}
