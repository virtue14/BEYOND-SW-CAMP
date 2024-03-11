package com.ohgiraffers.section01.common;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BookDTO {
    private int sequence;
    private int isbn;
    private String title;
    private String author;
    private String publisher;
    private Date createdDate;
}
