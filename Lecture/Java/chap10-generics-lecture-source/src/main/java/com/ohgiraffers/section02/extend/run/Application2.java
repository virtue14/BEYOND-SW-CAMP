/* 수업목표: 와일드카드에 대해 이해할 수 있다. */
package com.ohgiraffers.section02.extend.run;

import com.ohgiraffers.section02.extend.vo.*;

public class Application2 {
    public static void main(String[] args) {


        WildCardFarm wildCardFarm = new WildCardFarm();
        wildCardFarm.anyType(new RabbitFarm<Rabbit>(new Rabbit()));
        wildCardFarm.anyType(new RabbitFarm<Bunny>(new Bunny()));
        wildCardFarm.anyType(new RabbitFarm<DrunkenBunny>(new DrunkenBunny()));

//        wildCardFarm.extendsType(new RabbitFarm<Rabbit>());
        wildCardFarm.extendsType(new RabbitFarm<Bunny>(new Bunny()));
//        wildCardFarm.extendsType(new RabbitFarm<DrunkenBunny>());

        wildCardFarm.superType(new RabbitFarm<Rabbit>(new Rabbit()));
        wildCardFarm.superType(new RabbitFarm<Bunny>(new Bunny()));
//        wildCardFarm.superType(new RabbitFarm<DrunkenBunny>());
    }
}