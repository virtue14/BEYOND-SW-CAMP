package com.ohgiraffers.section01.aop;

import lombok.*;
import org.springframework.context.annotation.Scope;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MemberDTO {
    private Long id;
    private String name;
}
