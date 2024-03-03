/* 수업목표: 강제 형변환 규칙에 대해 이해할 수 있다. */
/* 필기
    - 강제형변환: 바꾸려는 자료형으로 캐스트 연산자(자료형)를 이용하여 형변환한다.
    - 데이터 손실을 감수하고 다운캐스팅 시에는 주의해야한다.
 */
package com.ohgiraffers.section05.typecasting;

public class Application2 {
    public static void main(String[] args) {

        long lnum = 80000000000L;
        int inum = (int) lnum;
        System.out.println("inum = " + inum);

        /* 설명: 실수 변수에서 정수로 다운캐스팅 시에는 소수점 이하가 제거(버림)된다. */
        float avg = 31.235f;
        int floornum = (int) avg;
        System.out.println("floornum = " + floornum);
    }
}
