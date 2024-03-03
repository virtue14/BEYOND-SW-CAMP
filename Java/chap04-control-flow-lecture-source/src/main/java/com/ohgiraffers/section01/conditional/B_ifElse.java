/* 수업목표: if-else문 단독 사용에 흐름을 이해하고 적용할 수 있고, 중첩된 if-else문의 흐름을 이해하고 적용할 수 있다. */
package com.ohgiraffers.section01.conditional;

import java.util.Scanner;

public class B_ifElse {
    public void testSimpleIfElseStatement() {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 하나 입력하세요:");
        int input = sc.nextInt();

//        만약에(홀수라면) {
//            "입력하신 정수는 홀수입니다." 출력
//        } 그 밖에 {
//            "입력하신 정수는 짝수입니다." 출력
//        }

        if ((input % 2) != 0) {
            System.out.println("입력하신 정수는 홀수 입니다.");
        } else {
            System.out.println("입력하신 정수는 짝수 입니다.");
        }

    }

    public void NestedIfElseStatement() {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 하나를 입력하세요:");
        int input = sc.nextInt();
        /* 설명: 정수를 하나 입력받아 양수와 음수를 구분하고 양수일 때만 짝수인지 아닌지 판별한다.(각 상태 모두 출력) */
        if (input > 0) {    // 양수일 때
            System.out.println("양수 입니다.");
            if (input % 2 == 0) {   // 양수이면서 짝수일 떄
                System.out.println("양수 이면서 짝수입니다.");
            } else {        // 양수이면서 홀수일 때
                System.out.println("양수 이면서 홀수입니다.");
            }
        } else {        // 0 또는 음수
            System.out.println("0 또는 음수입니다.");
        }

    }
}
