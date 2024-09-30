package lesson_4;

/**

 1. Напишите два наследника класса Exception: ошибка преобразования строки и
 ошибка преобразования столбца
 2. Разработайте исключения-наследники так, чтобы они информировали
 пользователя в формате ожидание/реальность
 3. Для проверки напишите программу, преобразующую квадратный массив целых
 чисел 5х5 в сумму чисел в этом массиве, при этом, программа должна выбросить
 исключение, если строк или столбцов в исходном массиве окажется не 5.

 **/

import java.util.Arrays;

public class Task_3 {

    public static void main(String[] args) {

        int[][] arr_1 = addArray(5,6);
        int[][] arr_2 = addArray(5,5);
        int[][] arr_3 = addArray(7,5);


        try {
            sumArray(arr_1);
            System.out.println("Все Верно!!!");
        } catch (ExceptionColumn e) {
            System.out.println("Колонок в массиве: \n" + Arrays.deepToString(arr_1).replace("], ", "]\n")  + "\nне 5");
        } catch (ExceptionLine e) {
            System.out.println("Строк в массиве: \n" + Arrays.deepToString(arr_1).replace("], ", "]\n")  + "\nне 5");
        } finally {
            System.out.println("Cтрок или столбцов в исходном массиве должно быть по 5");
        }


        System.out.println("_________________________");

        try {
            sumArray(arr_2);
            System.out.println("Все Верно!!!");
        } catch (ExceptionColumn e) {
            System.out.println("Колонок в массиве: \n" + Arrays.deepToString(arr_2).replace("], ", "]\n")  + "\nне 5");
        } catch (ExceptionLine e) {
            System.out.println("Строк в массиве: \n" + Arrays.deepToString(arr_2).replace("], ", "]\n")  + "\nне 5");
        } finally {
            System.out.println("Cтрок или столбцов в исходном массиве должно быть по 5");
        }

        System.out.println("_________________________");


        try {
            sumArray(arr_3);
            System.out.println("Все Верно!!!");
        } catch (ExceptionColumn e) {
            System.out.println("Колонок в массиве: \n" + Arrays.deepToString(arr_3).replace("], ", "]\n")  + "\nне 5");
        } catch (ExceptionLine e) {
            System.out.println("Строк в массиве: \n" + Arrays.deepToString(arr_3).replace("], ", "]\n")  + "\nне 5");
        } finally {
            System.out.println("Cтрок или столбцов в исходном массиве должно быть по 5");
        }

    }

    public static int[][] addArray(int column, int line) {
        int[][] array = new int[column][line];

        for (int i = 0; i < column; i++) {
            for (int j = 0; j < line; j++) {
                array[i][j] = (int) (Math.random() * column);
            }
        }
        return array;
    }

    public static int sumArray(int[][] arr) throws ExceptionLine, ExceptionColumn {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr.length != 5) {
                    throw new ExceptionColumn("Колонок должно быть 5");
                }
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i].length != 5) {
                    throw new ExceptionLine("Строк должно быть 5");
                }
                sum +=arr[i][j];
            }
        }
        return sum;
    }

    public static class ExceptionLine extends Exception{

        public ExceptionLine(String message) {
            super(message);
        }

    }


    public static class ExceptionColumn extends Exception{

        public ExceptionColumn(String message) {
            super(message);
        }

    }



}
