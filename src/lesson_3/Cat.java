package lesson_3;

public class Cat extends Animals{

    private String name;
    private int age;
    private static int id = 0;
    private int cat_id;
    private int jamp=150;
    private int run=2000;
    private int swim=15;

    public Cat(String name, int age) {
        id += 1;
        this.cat_id = id;
        this.name = name;
        this.age = age;
        this.max_jamp = maxRandom(jamp);
        this.max_run =  maxRandom(run);
        this.max_swim =  maxRandom(swim);
    }


    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + cat_id +
                ", max_jamp=" + max_jamp +
                ", max_run=" + max_run +
                ", max_swim=" + max_swim +
                '}';
    }

    @Override
    boolean jamp(int lenght) {
        if (lenght < max_jamp) {return true;}
        return false;
    }

    @Override
    boolean run(int lenght) {
        if (lenght < max_jamp) {return true;}
        return false;
    }

    @Override
    boolean swim(int lenght) {
        System.out.println("Don't swim!");
        return false;
    }
}
