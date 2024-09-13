package lesson_2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(sifr("Привет",1));  //рсйгёу
        System.out.println(Arrays.toString(mass(new int[]{1, 2, 3, 4, 5},1)));  //5,1,2,3,4
        System.out.println(Arrays.toString(masszero(new int[]{1, 0, 0, 1, 0})));  //0,1,1,0,1
    }

    private static int[] masszero(int[] ints) {
        byte b = 1;
        int[] arr = new int[ints.length];

        for (int i = 0; i < ints.length; i++) {
            arr[i] = Integer.parseInt(Integer.toBinaryString(b - ints[i]));
        }
        return arr;
    }

    private static int[] mass(int[] num, int n) {
        int[] result = new int[num.length];

        for (int i = 0; i < num.length; i++){

                int index = i+n;
                if(index < num.length){
                    result[index] = num[i];
                } else {
                    result[index-num.length] = num[i];
                }

        }

        return result;
    }

    public static String sifr(String text, int b){

        String result = "";
        char[] letters = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};


        for (int i = 0; i < text.length(); i++){

            char ch = Character.toLowerCase(text.charAt(i));

            for (int j = 0; j < letters.length; j++) {
                int index = b+j;
                if(ch == letters[j] && (index) < letters.length){
                    result = result + letters[index];
                    break;
                } else if(ch == letters[j] && ((index) >= letters.length)) {
                    result = result + letters[index-letters.length];
                    break;
                }

            }
        }

        return result;
    }






}
