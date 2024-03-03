package com.ohgiraffers.section02.looping;

import java.util.Scanner;

public class D_doWhile {
    public void testSimpleDoWhileStatement() {

        /* 수업목표: do-While문 단독 사용에 흐름을 이해하고 적용할 수 있다. */
        do {
            System.out.println("실행될까?");
        } while (false);
        System.out.println("반복 종료 이후");
    }

    public void testDoWhileExample() {
        /* 수업목표: do-While문의 흐름을 이해하고 적용할 수 있다. */
        Scanner sc = new Scanner(System.in);
        String str = "";

        do {
            if (!str.equals("finish") && !str.equals("")) {
                System.out.println("error");
            }
            System.out.print("finish를 입력하시오: ");
            str = sc.nextLine();
            System.out.println(str + "를 입력하셨습니다.");
        } while (!str.equals("finish"));        // equals메소드는 String 비교에 사용되며 '=='과 같은 의미이다.
            System.out.println("감사합니다.");  // str 문자열의 값이 finish와 일치하면 false가 되도록 작성
    }
}
