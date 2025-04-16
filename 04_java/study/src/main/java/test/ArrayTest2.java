package main.java.test;

public class ArrayTest2 {
    public static void main(String[] args) {
        //1. 값을 알고 있는 경우
        int[][] ages = {
                {1,2},
                {3,4,5},
                {6,7,8,9}
        };
        System.out.println(ages.length); //행, 3
        System.out.println(ages[0].length); //열, 2
        System.out.println(ages[0][0]); //[행] [열]

        //2. 값을 모르고 있는 경우
        int[][] seats2 = new int[3][3]; // 3x3
        int[][] seats3 = new int[3][]; // 3x3
        seats3[0] = new int[] {1,2,3};
        seats3[1] = new int[] {1,2,3,4};
        seats3[2] = new int[] {1,2,3,4,5};
        System.out.println(seats3[2][0]); //1


    }
}
