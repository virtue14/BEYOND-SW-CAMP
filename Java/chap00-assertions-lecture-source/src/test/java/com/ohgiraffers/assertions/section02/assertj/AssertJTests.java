package com.ohgiraffers.assertions.section02.assertj;
/* 수업목표: test third party lib 중 AssertJ의 사용법에 대해 이해할 수 있다. */

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class AssertJTests {

    @Test
    @DisplayName("문자열 테스트 하기")
    void testStringValidation() {
        String expected = "hello world";

        String actual = new String(expected);

        Assertions.assertThat(actual)
                .isNotEmpty()
                .isNotBlank()
                .contains("hello")
                .doesNotContain("hahaha")
                .startsWith("h")
                .endsWith("d")
                .isEqualTo("hello world");
    }

    @Test
    @DisplayName("숫자 테스트하기")
    void testIntegerValidation() {
        double pi = Math.PI;

        Double actual = Double.valueOf(pi);

        Assertions.assertThat(actual)
                .isPositive()
                .isGreaterThan(3)
                .isLessThan(4)
                .isEqualTo(Math.PI);
    }

    @Test
    @DisplayName("날짜 테스트하기")
    void testLocalDateTimeValidation() {
        String birthday = "2014-09-18T16:42:00.000";

        LocalDateTime theDay = LocalDateTime.parse(birthday);

        Assertions.assertThat(theDay)
                .hasYear(2014)
                .hasMonthValue(9)
                .hasMonth(Month.SEPTEMBER)
                .hasDayOfMonth(18)
                .isBetween(LocalDateTime.parse("2014-01-01T00:00:00.000"), LocalDateTime.parse("2014-12-31T23:59:59.999"))
                .isBefore(LocalDateTime.now());
    }

    @Test
    @DisplayName("예외 테스트하기")
    void testExceptionValidation() {
        Throwable thrown = Assertions.catchThrowable(() -> {
            throw new IllegalArgumentException("잘못된 파라미터를 입력하셨습니다.");
        });

        Assertions.assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("파라미터");
    }

    @Test
    @DisplayName("filtering assertions 테스트하기")
    void testFilteringAssertions() {
        Member member1 = new Member(1, "user01", "홍길동", 20);
        Member member2 = new Member(2, "user02", "유관순", 16);
        Member member3 = new Member(3, "user03", "이순신", 40);
        Member member4 = new Member(4, "user04", "신사임당", 43);
        Member member5 = new Member(5, "user05", "임꺽정", 19);

        List<Member> members = Arrays.asList(member1, member2, member3, member4, member5);

        Assertions.assertThat(members)
                .filteredOn(member -> member.getAge() > 20)
                .containsOnly(member3, member4);
    }

    @Test
    @DisplayName("객체의 프로퍼티 검증 테스트하기")
    void testPropertyValidation() {
        Member member1 = new Member(1, "user01", "홍길동", 20);
        Member member2 = new Member(2, "user02", "유관순", 16);
        Member member3 = new Member(3, "user03", "이순신", 40);
        Member member4 = new Member(4, "user04", "신사임당", 43);
        Member member5 = new Member(5, "user05", "임꺽정", 19);

        List<Member> members = Arrays.asList(member1, member2, member3, member4, member5);

        Assertions.assertThat(members)
                .filteredOn("age", 20)
                .containsOnly(member1);
    }
}

