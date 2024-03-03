/* 수업목표: 정수 열거 패턴과 이의 단점을 이해할 수 있다.(열거형(enum) 아닐 때) */
package com.ohgiraffers.secrtion01.intenum;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        int subject1 = Subjects.JAVA;
        int subject2 = Subjects.HTML;

        /* 설명 1. 둘 다 상수이자 숫자일 뿐인데 같은 숫자일 경우 구분할 수 없다. */
        if (subject1 == subject2) {
            System.out.println("두 과목은 같은 과목이다.");
        }

        /* 설명 2. 이름 충돌 방지를 위해서는 접두어를 써서 구분해야만 한다.(이름과 번호가 같을 때)*/
        /* 설명 3. 변수명에 쓰인 이름/문자열을 출력하기 어렵다.(feat.switch) */
        Scanner sc = new Scanner(System.in);
        System.out.print("과목번호를 눌러주세요(0~2): ");
        int fieldNo = sc.nextInt();
        String subName = "";
        switch (fieldNo) {
            case Subjects.JAVA : subName = "JAVA"; break;
            case Subjects.MARIADB : subName = "MARAIDB"; break;
            case Subjects.JDBC : subName = "JDBC"; break;
        }
        System.out.println("선택한 과목명은: " + subName + "입니다.");

        /* 설명 4. 같은 클래스에 속한 상수들을 순회(반복자/반복문 사용)할 수 없다.(전체 필드의 개수도 알 수 없음) */
        /* 설명 5. 타입 안전성을 보장할 수 없다.(Subject.JAVA라는 것과 단순 정수값이 구분이 안되기 때문) */
        printSubject(Subjects.JAVA);
        printSubject(0);            // 대충 아무 int값이나 전달해도 해당 메소드는 문제 없이 돌아갈 수 있다.

    }

    private static void printSubject(int java) {
    }
}
