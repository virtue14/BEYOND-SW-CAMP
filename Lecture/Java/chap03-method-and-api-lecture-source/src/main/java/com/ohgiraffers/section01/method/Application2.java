/* 수업목표: 메소드의 호출 흐름에 대해 이해할 수 있다.(main method에서 한번에 여러 메소드 호출해 보기) */
/* 필기
    - static이 붙어 있지 않은 메소드는 <{클래스명} {변수명} = new {클래스명)();>을 활용해 메소드를 호출해야 한다.(접근 연산자(.)도 활용)
*/
package com.ohgiraffers.section01.method;
public class Application2 {
    public static void main(String[] args) {
        System.out.println("main() 호출됨...");
        Application2 app2 = new Application2();
        app2.methodA();
        app2.methodB();
        app2.methodC();
        System.out.println("main() 종료됨...");
    }

    public void methodA() {
        System.out.println("methodA() 호출됨...");
        System.out.println("methodA() 종료됨...");
    }

    public void methodB() {
        System.out.println("methodB() 호출됨...");
        System.out.println("methodB() 종료됨...");
    }
    public void methodC() {
        System.out.println("methodC() 호출됨...");
        System.out.println("methodC() 종료됨...");
    }
}
