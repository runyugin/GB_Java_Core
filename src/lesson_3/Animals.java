package lesson_3;

public abstract class Animals {

    protected String name;
    protected int age;
    protected int max_jamp;
    protected int max_run;
    protected int max_swim;
    private int proc = 25;

    abstract boolean jamp(int lenght);
    abstract boolean run(int lenght);
    abstract boolean swim(int lenght);



    private int max(int move) {
        return move+(proc*move/100);
    }

    private int min(int move) {
        return move-(proc*move/100);
    }


    protected int maxRandom(int move) {
        return (int) ((Math.random() * ((max(move) - min(move)) + 1)) + min(move));
    }


}
