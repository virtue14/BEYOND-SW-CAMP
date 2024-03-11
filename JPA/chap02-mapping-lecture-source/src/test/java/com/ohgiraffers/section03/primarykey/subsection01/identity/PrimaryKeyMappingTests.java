package com.ohgiraffers.section03.primarykey.subsection01.identity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.util.List;

public class PrimaryKeyMappingTests {
    private static EntityManagerFactory entityManagerFactory;

    private EntityManager entityManager;

    @BeforeAll
    public static void initFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach
    public void initManager() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterAll
    public static void closeFactory() {
        entityManagerFactory.close();
    }
    @AfterEach
    public void closeManager() {
        entityManager.close();
    }

    /* 설명
        strategy: 자동 생성 전략을 지정
          - GenerationType.IDENTITY: 기본 키 생성을 데이터베이스에 위임(Mysql 또는 MariaDB의 auto_increment)
          - GenerationType.SEQUENCE: 데이터베이스 시퀀스 객체 사용(ORACLE의 SEQUENCE)
          - GenerationType.TABLE: 키 생성 테이블 사용
          - GenerationType.AUTO: 자동선택(Mysql의 IDENTITY 또는 ORACLE이면 SEQUENCE)
    */

    @Test
    public void 식별자_매핑_테스트() {
        Member member1 = new Member();
//        member1.setMemberNo(1);
        member1.setMemberId("user01");
        member1.setMemberPwd("pass01");
        member1.setNickname("홍길동");
        member1.setPhone("010-1234-5678");
        member1.setEmail("hong@gmail.com");
        member1.setAddress("서울시 서초구");
        member1.setEnrollDate(new java.util.Date());
        member1.setMemberRole("ROLE_MEMBER");
        member1.setStatus("Y");

        Member member2 = new Member();
//        member2.setMemberNo(1);
        member2.setMemberId("user02");
        member2.setMemberPwd("pass02");
        member2.setNickname("유관순");
        member2.setPhone("010-5678-1234");
        member2.setEmail("you@gmail.com");
        member2.setAddress("서울시 마포구");
        member2.setEnrollDate(new java.util.Date());
        member2.setMemberRole("ROLE_MEMBER");
        member2.setStatus("Y");

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(member1);
        entityManager.persist(member2);
        entityTransaction.commit();

//        Member selectedMember = entityManager.find(Member.class, 1);
//        System.out.println("selectedMember = " + selectedMember);

        String jpql = "SELECT A.memberNo FROM member_section03_subsection01 A";
        List<Integer> memberNoList = entityManager.createQuery(jpql, Integer.class).getResultList();

        memberNoList.forEach(System.out::println);
    }
}
