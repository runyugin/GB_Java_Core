package lesson_2;

public class HomeWork {

    public static void main(String[] args) {

        int[] array = {0,1,2,3,4,5,0,0,8,9};


        //Написать метод, возвращающий количество чётных элементов массива. countEvens([2, 1, 2, 3, 4]) → 3 countEvens([2, 2, 0]) → 3 countEvens([1, 3, 5]) → 0

        System.out.println(evenNumbers(array));

        //Написать функцию, возвращающую разницу между самым большим и самым ма- леньким элементами переданного не пустого массива.

        System.out.println(difference(array));

        //Написать функцию, возвращающую истину, если в переданном массиве есть два соседних элемента, с нулевым значением.

        System.out.println(arrayNull(array));

    }

    private static boolean arrayNull(int[] array) {

        if (array == null || array.length == 0) {return false;}

        int cash = array[0];
        for (int i = 1; i < array.length; i++) {
            if (cash == 0 && array[i] == 0) {
                return true;
            } else {
                cash = array[i];
            }
        }
        return false;
    }

    private static int difference(int[] array) {

        if (array == null || array.length == 0) {return 0;}

        int max = array[0];
        int min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {max = array[i];}
            if (array[i] < min) {min = array[i];}
        }
        return max - min;
    }

    private static int evenNumbers(int[] array) {

        if (array == null || array.length == 0) {return 0;}

        int result = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {result+=1;}
        }


        return result;
    }

}
