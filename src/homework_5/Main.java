package homework_5;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 1. Написать функцию, создающую резервную копию всех файлов в директории(без поддиректорий) во вновь созданную папку ./backup

 2. Предположить, что числа в исходном массиве из 9 элементов имеют диапазон [0,
 3], и представляют собой, например, состояния ячеек поля для игры в крестики-
 нолики, где 0 – это пустое поле, 1 – это поле с крестиком, 2 – это поле с ноликом, 3
 – резервное значение. Такое предположение позволит хранить в одном числе типа
 int всё поле 3х3. Записать в файл 9 значений так, чтобы они заняли три байта

*/

 public class Main {

    public static void main(String[] args) {

        backup("./src/homework_5");

        try {
            data(new int[]{0,1,2,3,0,1,2,3,0});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static void backup(String path) {

        Path outpath = Paths.get(path);

        try {
            Path creatDirectory = Files.createDirectory(Paths.get(path + "/backup"));
        } catch (IOException e) {
        }

        try (DirectoryStream<Path> files = Files.newDirectoryStream(outpath)) {
            for (Path p : files) {
                if (Files.isRegularFile(p)) {
                    Files.copy(p, Path.of(path + "/backup/" + p.getFileName()));
                }
            }
        } catch (IOException e) {
        }
    }




    private static void data(int[] ints) throws IOException {

        FileOutputStream fos = new FileOutputStream("save1.out");
        for (int b = 0; b < 3; b++) { // write to 3 bytes
            byte wr = 0;
            for (int v = 0; v < 3; v++) { // write by 3 values in each
                wr += (byte) (ints[3 * b + v] << (v * 2));
            }
            fos.write(wr);
        }
        fos.flush();
        fos.close();

    }




}
