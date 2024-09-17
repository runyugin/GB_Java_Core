package lesson_3;

public class Dog extends Animals{

    private String name;
    private int age;
    private static int id = 0;
    private int dog_id;
    private int jamp=150;
    private int run=2000;
    private int swim=15;

    public Dog(String name, int age) {
        id += 1;
        this.dog_id = id;
        this.name = name;
        this.age = age;
        super.max_jamp = maxRandom(jamp);
        super.max_run =  maxRandom(run);
        super.max_swim =  maxRandom(swim);
    }



    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + dog_id +
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
