package lesson_3;


public class Main {
    public static void main(String[] args) {

        Cat cat_1 = new Cat("Barsik", 4);
        Cat cat_2 = new Cat("Mursik", 6);
        Cat cat_3 = new Cat("Rid", 5);

        Dog dog_1 = new Dog("Barbos", 7);
        Dog dog_2 = new Dog("Jeck", 6);
        Dog dog_3 = new Dog("Tusik", 9);

        Bird bird_1 = new Bird("Kesha", 3);
        Bird bird_2 = new Bird("Mosha", 6);
        Bird bird_3 = new Bird("Gosha", 9);

        System.out.println(cat_1);
        System.out.println(cat_2);
        System.out.println(cat_3);
        System.out.println();
        System.out.println(dog_1);
        System.out.println(dog_2);
        System.out.println(dog_3);
        System.out.println();
        System.out.println(bird_1);
        System.out.println(bird_2);
        System.out.println(bird_3);
    }


}
