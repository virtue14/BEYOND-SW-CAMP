/* 수업목표: 배열을 사용하는 예시를 통해 카드 게임을 작성해 보자. */
package com.ohgiraffers.section01.array;

import java.util.Random;

public class Application5 {
    public static void main(String[] args) {
        Random random = new Random();
        String[] shape = {"SPADE", "CLOVER", "HEART", "DIAMOND"};
        String[] cardNumbers = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "JACK", "QUEEN", "KING", "ACE"};


        int randomShapeIndex = new Random().nextInt(shape.length);
        int randomcardNumberIndex = new Random().nextInt(cardNumbers.length);
//        System.out.println("당신이 뽑은 카드는 " + shape[0] + cardNumbers[0] + " 카드 입니다.");
        System.out.println("당신이 뽑은 카드는 \"" + shape[randomShapeIndex] + " " + cardNumbers[randomcardNumberIndex] + "\" 카드 입니다.");
    }
}
