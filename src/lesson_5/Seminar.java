package lesson_5;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 Задача: Создать массив из 9 цифр и записать его в файл, используя поток
 вывода.


 */

public class Seminar {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        writeToFile(arr);

        System.out.println("_________________________");

        readFile("example.txt");


    }

    private static void writeToFile(int[] arr) {


        try (FileWriter fileWriter = new FileWriter("example.txt", false)) {
            for (int elem : arr) { // Перебираем элементы массива
                fileWriter.append(String.valueOf(elem)) // Записываем элементы в файл, приводим целые числа к строковому формату
                        .append("0"); // Добавляем пробелы между элементами
                fileWriter.flush(); // Очищаем буфер потока
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void readFile(String path) {

        List<Character> lines = new ArrayList<>();
        try (FileReader fileReader = new FileReader(path)) {
            while (fileReader.ready()) //пока есть непрочитанные байты в потоке ввода
            {
                int data = fileReader.read(); //читаем один символ (char будет расширен до int)
                if ((char)data == '0') {continue;}
                lines.add((char)data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Arrays.toString(lines.toArray()));

    }



}
