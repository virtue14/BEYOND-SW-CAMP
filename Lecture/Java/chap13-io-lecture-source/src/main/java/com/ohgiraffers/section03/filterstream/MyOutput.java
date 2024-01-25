package com.ohgiraffers.section03.filterstream;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/* 설명: 객체 출력을 기존 파일 내용에 이어쓰기 하고 싶은데 헤더가 추가되는 것 때문에 헤더가 안 생기는 ObjectOutputStream 만들어보기 */
public class MyOutput extends ObjectOutputStream {

    public MyOutput(OutputStream out) throws IOException {
        super(out);
    }
    @Override
    protected void writeStreamHeader() throws IOException {

    }

}
