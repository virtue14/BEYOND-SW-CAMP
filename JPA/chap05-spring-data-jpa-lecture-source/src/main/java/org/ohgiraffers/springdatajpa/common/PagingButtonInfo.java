package org.ohgiraffers.springdatajpa.common;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class PagingButtonInfo {
    private int currentPage;

    private int startPage;

    private int endPage;
}
