/* 수업목표: 여러가지 값의 형태를 출력할 수 있다. */
/* 설명:
    상수는 변하지 않는 변수를 의미하며(메모리 위치) 메모리 값을 변경할 수 없다.
    리터럴은 변수의 값이 변하지 않는 데이터(메모리 위치안의 값)를 의미한다.
*/
package com.ohgiraffers.section01.literal;

public class Application1 {
    public static void main(String[] args) {

        // 한 줄 주석
        /* 범위 주석 */
        /*
            여러줄
            주석
            가능
        */

        /* 목차 1. 숫자 형태의 값 */
        /* 목차 1-1. 정수 형태의 값 출력 */

        System.out.println(123);
        /* 목차 1-2. 실수 형태의 값 출력 */
        System.out.println(1.234);

        /* 목차 2. 문자 형태의 값 출력 */
        System.out.println('a');                    // 설명: 문자는 single quatation(')을 적용한다.
        System.out.println('1');                    // 설명: 숫자도 single quatation(')을 적용하면 문자다.
//        System.out.println('ab');                 // 설명: 컴파일 에러(문법 오류)
        System.out.println('\u0000');               // 설명: 문자는 아무것도 안 넣으면 에러가 발생하지만 아무것도 안 넣고 싶으면 \u0000

        /* 목차 3. 문자열 형태의 값 출력 */
        System.out.println("안녕하세요!");           // 설명: 문자열은 double quatation(")을 적용한다.
        System.out.println("a");
        System.out.println("");

        /* 목차 4. 논리 형태의 값 출력 */
        System.out.println(true);
        System.out.println("true");                 // 설명: double quatation(")이 붙으면 문자열이 된다.
        System.out.println(false);                  // 설명: true 또는 false 두 값만 놀리 값이다.
    }
}
