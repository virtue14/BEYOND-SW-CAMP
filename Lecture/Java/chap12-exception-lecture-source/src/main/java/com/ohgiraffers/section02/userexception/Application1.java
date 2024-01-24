/* 수업목표: 사용자 정의의 예외클래스 정의 후 발생한 사용자 정의의 예외를 처리할 수 있다. */
package com.ohgiraffers.section02.userexception;


import com.ohgiraffers.section02.userexception.exception.MoneyNegativeException;
import com.ohgiraffers.section02.userexception.exception.NotEnoughMoneyException;
import com.ohgiraffers.section02.userexception.exception.PriceNegativeException;

public class Application1 {
    public static void main(String[] args) {
        ExceptionTest et = new ExceptionTest();

        try {
//            et.checkEnoughMoney(-30000, 50000);
            et.checkEnoughMoney(30000, -50000);
//            et.checkEnoughMoney(50000, 30000);
//        } catch (PriceNegativeException e) {
//            System.out.println(e.getMessage());
//        } catch (NotEnoughMoneyException e) {
//            System.out.println(e.getMessage());
//        } catch (MoneyNegativeException e) {
//            System.out.println(e.getMessage());
        } catch (Exception e) { // 다형성을 활용한 catch 처리 방식
            System.out.println("예외 메시지: " + e.getMessage());
        }
    }
}
