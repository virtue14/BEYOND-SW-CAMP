package com.ohgiraffers.section01.object.dto;

import java.util.Objects;

public class BookDTO {

    private int number;
    private String title;
    private String author;
    private int price;

    public BookDTO(int number, String title, String author, int price) {
        this.number = number;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPrice() {
        return price;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    /* 목차 1. toString() 오버라이딩 */
    @Override
    public String toString() {
        return "BookDTO{" +
                "number=" + number +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

    /* 목차 2. equals() 오버라이딩 */
//    @Override
//    public boolean equals(Object obj) {
//        return this.author.equals(((BookDTO)obj).getAuthor()) && this.price == (((BookDTO) obj).getPrice());
////        return false;
//    }

    /* 설명: 우리가 BookDTO 타입의 객체가 동등하다라는 것에 대한 기준을 정하기 위해 오버라이딩 */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDTO bookDTO = (BookDTO) o;
        return number == bookDTO.number && price == bookDTO.price && Objects.equals(title, bookDTO.title) && Objects.equals(author, bookDTO.author);
    }


}
