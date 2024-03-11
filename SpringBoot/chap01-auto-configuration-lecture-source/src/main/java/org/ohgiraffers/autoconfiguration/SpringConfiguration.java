package org.ohgiraffers.autoconfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SpringConfiguration {
    @Value("${test.value}")
    public String value;

    @Value("${test.age}")
    public String age;

    @Value("${test.array}")
//    public List<String> list;
    public String[] arr;


    @Bean
    public Object propertyReadTest() {

        System.out.println("value = " + value);
        System.out.println("age = " + age);

//        list.forEach(System.out::println);
        Arrays.stream(arr).forEach(System.out::println);

        return new Object();
    }

}