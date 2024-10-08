package lesson_5;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

/**
 * 1. Cоздать пару-тройку текстовых файлов. Для упрощения (чтобы не разбираться с
 * кодировками) внутри файлов следует писать текст только латинскими буквами.
 * <p>
 * 2. Написать метод, осуществляющий конкатенацию (объединение) переданных ей в
 * качестве параметров файлов (не важно, в первый допишется второй или во второй
 * первый, или файлы вовсе объединятся в какой-то третий);
 * <p>
 * 3. Написать метод поиска слова внутри файла.
 */


public class Main {

    public static void main(String[] args) {


        List<String> lines = Arrays.asList(
                "The cat wants to play with you",
                "But you don't want to play with it 1");

        Path file = null;

        for (int i = 1; i < 4; i++) {

            String fileName = "test" + i + ".txt";

            try {
                file = Files.createFile(Paths.get(fileName));
                if (Files.exists(file)) {
                    Files.write(file, lines, StandardCharsets.UTF_8);
                }

            } catch (IOException e) {
                System.out.println(fileName + " - Есть такой фаил");
            }

        }

        System.out.println("_________________________________");

        try {
            addFile("test2.1.txt", "test2.2.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        System.out.println("_________________________________");


        try {
            findWord("test2.2.txt", "play");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public static void addFile(String fileName1, String fileName2) throws IOException {

        List<String> lines = Files.readAllLines(
                Paths.get(fileName1), StandardCharsets.UTF_8);

        Path file = Paths.get(fileName2);
        if (Files.exists(file)) {
            Files.write(file, lines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        }

    }


    public static void findWord(String fileName, String word) throws IOException {


        List<String> lines = Files.readAllLines(
                Paths.get(fileName), StandardCharsets.UTF_8);

        int i = 0;
        for (String line : lines) {

            if (line.contains(word)) {
                i++;
            }
        }

        System.out.println(word + " Найден " + i + " раз");

    }


}
