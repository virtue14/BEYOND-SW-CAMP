package com.ohgiraffers.section02.encapsulation.problem1;

public class Monster {
    String name;
    int hp;



    public void setHp(int hp) {
        if (hp > 0) {
        this.hp = hp;       // 설명: this는 메소드 호출 당시의 Monster 객체를 뜻하고 this.hp는 해당 객체의 hp공간을 뜻한다.
        } else if (hp >= 0) {
            this.hp = 0;
        }
    System.out.println("Die💀");
    }

    public void setInfo1(String 프랑켄슈타인) {
    }
}
