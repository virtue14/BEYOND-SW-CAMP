/* 수업목표: finally를 활용한 try-catch문 이해하고 활용하기 */
package com.ohgiraffers.section02.userexception;

public class Application2 {
    public static void main(String[] args) {
        ExceptionTest et = new ExceptionTest();

        try {
//            et.checkEnoughMoney(200000, 500000);
            et.checkEnoughMoney(-200000, 500000);
        } catch (Exception e) {
            System.out.println("충분한 돈을 지녔는지 유효성 체크 결과 문제: " + e.getMessage());
        } finally {
            /* 설명: try구문에서 예외가 발생하지 않든 반드시 실행해야 할 부분이 있다면 작성하는 부분 */
            System.out.println("finally 블럭의 내용이 동작함");
        }
        System.out.println("프로그램을 종료합니다");
    }
}
