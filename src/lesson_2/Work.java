package lesson_2;

import java.util.Arrays;

public class Work {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        readArr(arr(9));
        System.out.println();
        readArr(arrAdd(array, 5));
        System.out.println();
        readArr(arrAdd(array, 5,8));

    }

    private static int[] arrAdd(int[] array, int i) {
        int[] result = new int[array.length + 1];
        System.arraycopy(array, 0, result, 0, array.length);
        result[array.length] = i;

        return result;

    }
    private static int[] arrAdd(int[] array, int i, int pos) {
        int[] result = new int[array.length + 1];
        System.arraycopy(array, 0, result, 0, array.length);

        for (int j = pos; j < result.length; j++) {
            if(j == pos){
                result[j] = i;
            } else {
                result[j] = array[j - 1];
            }
        }


        return result;

    }


    private static int[][] arr(int leght) {
        int[][] arr = new int[leght][leght];
        for(int j=0;j<leght;j++) {
            arr[j][j] = 1;
            arr[j][leght-1-j] = 1;
        }
        return arr;
    }

    private static void readArr(int [][] arr) {

        for(int j=0;j<arr.length;j++) {
            for(int k=0;k<arr.length;k++) {
                System.out.print(arr[j][k] +", ");
            }
            System.out.println();
        }

    }

    private static void readArr(int [] arr) {
            for(int k=0;k<arr.length;k++) {
                System.out.print(arr[k] +", ");
        }
        System.out.println();

    }



}
