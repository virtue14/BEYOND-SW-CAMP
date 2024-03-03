/* 수업목표: Enum의 문법에 대해 이해하고 활용할 수 있다.(클래스적인 면모) */
/* 필기
    enum 타입의 필드를 최소 사용 시에만 열거 타입의 인스턴스를 최초 하나만 생성하고 이후에는 생성자를 호출하지 않는다.
    또한, enum 타입은 set으로 바꿔 반복시키며 필드들을 한번에 확인하고 활용할 수도 있다.
*/
package com.ohgiraffers.section03.grammer;

import java.util.EnumSet;
import java.util.Iterator;

public class Application {
    public static void main(String[] args) {
        UserRole1 admin = UserRole1.ADMIN;
        System.out.println(admin.toString());
        System.out.println(admin.getNameToLowerCase());

        UserRole2 consumer = UserRole2.CONSUMERT;
        System.out.println(consumer.ordinal() + ", " + consumer.name() + ", " +consumer.getDescription());

        System.out.println("=============== Set으로 바꿔 반복자를 활용해 보자. ===============");
        EnumSet<UserRole2> roles = EnumSet.allOf(UserRole2.class);
        Iterator<UserRole2> iter = roles.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next().name());
        }

    }
}
