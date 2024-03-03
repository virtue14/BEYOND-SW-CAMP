/* 수업목표: Object 클래스의 equals() 메소드 오버라이딩 목적을 이해하고 활용할 수 있다. */
package com.ohgiraffers.section01.object.run;

import com.ohgiraffers.section01.object.dto.BookDTO;

public class Application2 {
    public static void main(String[] args) {
        BookDTO book1 = new BookDTO(1, "홍길동전", "허균", 500000);
        BookDTO book2 = new BookDTO(1, "홍길동전", "허균", 500000);
        BookDTO book3 = new BookDTO(1, "홍길동전", "허균", 300000);

        System.out.println("두 인스턴스를 == 연산자로 비교: " + (book1 == book2));
        System.out.println("두 인스턴스를 equals() 메소드로 비교: " + book1.equals(book2));
        System.out.println("두 인스턴스를 equals() 메소드로 비교: " + book1.equals(book3));


    }
}
