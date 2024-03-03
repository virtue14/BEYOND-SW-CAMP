/* 수업목표: TreeSet에 대해 이해하고 활용할 수 있다. */
package com.ohgiraffers.section02.set.run;

import java.util.Set;
import java.util.TreeSet;

public class Application3 {
    public static void main(String[] args) {
        Set<String> tSet = new TreeSet<>();

        tSet.add("raman");
        tSet.add("pork");
        tSet.add("kimchi");
        tSet.add("friedEgg");
        tSet.add("soup");
        System.out.println("tSet = " + tSet);

        System.out.println();

        Set<Integer> lotto = new TreeSet<>();
        /* 설명: 1부터 45까지 6자리 중복되지 않는 난수를 발생하여 값 저장 */
        while (lotto.size() < 6) {
            lotto.add((int) (Math.random() * 45) + 1);
        }
        /* 설명: 출력 시에는 오름차순으로 출력 되도록 작성 */
        System.out.println("lotto = " + lotto);

    }
}
