package com.ohgiraffers.section01.array;

public class TestClap {
    public static void main(String[] args) {

        extracted();

        extracted2();
    }

    private static void extracted() {
        int[] arr = new int[3];
        for (int i = 0; i < 10; i++) {
            arr[0] = i;
            for (int j = 0; j < 10; j++) {
                arr[1] = j;
                for (int k = 0; k < 10; k++) {

                    arr[2] = k;

                    boolean flag = false;
                    if(arr[0] != 0 && arr[0] % 3 == 0) {
                        System.out.print("짝");
                        flag = true;
                    }
                    if(arr[1] != 0 && arr[1] % 3 == 0) {
                        System.out.print("짝");
                        flag = true;
                    }
                    if(arr[2] != 0 && arr[2] % 3 == 0) {
                        System.out.print("짝");
                        flag = true;
                    }
                    if(!flag) {
                        System.out.print("" + arr[0] + arr[1] + arr[2]);
                    } else {
                        System.out.print("(" + arr[0] + arr[1] + arr[2] + ")");
                    }
                    System.out.println();
                }
            }
        }
    }


    private static void extracted2() {
        for (int i = 0; i < 1000; i++) {

            int change = i;

            int first = -1;
            int second = -1;
            int third = -1;

            if (i / 100 != 0) {
                first = i / 100 % 3;
                if (first == 0) System.out.print("짝");
            }

            change = i - i / 100 * 100;             // 10의 자릿수까지 남김

            if(change / 10 != 0) {
                second = change / 10 % 3;
                if(second == 0) System.out.print("짝");
            }

            change = change - change / 10 * 10;     // 1의 자릿수까지 남김

            if(change != 0) {
                third = change % 3;
                if(third == 0) System.out.print("짝");
            }

            if(first != 0 && second != 0 && third != 0) {
                System.out.println(i);
            } else {
                System.out.println("(" + i + ")");
            }
        }
    }
}