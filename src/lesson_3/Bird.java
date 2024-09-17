package lesson_3;

import java.util.Random;

public class Bird extends Animals{

    private static int id = 0;
    private int bird_id;
    private int jamp=5;
    private int run=20;
    private int swim=15;

    public Bird(String name, int age) {
        id += 1;
        this.bird_id = id;
        super.name = name;
        super.age = age;
        super.max_jamp = maxRandom(jamp);
        super.max_run =  maxRandom(run);
        super.max_swim =  maxRandom(swim);
    }


    @Override
    public String toString() {
        return "Bird{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + bird_id +
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
        if (lenght < max_run) {return true;}
        return false;
    }

    @Override
    boolean swim(int lenght) {
        if (lenght < max_swim) {return true;}
        return false;
    }
}
