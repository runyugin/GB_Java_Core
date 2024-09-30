package lesson_4;

public class WrongLoginException extends RuntimeException{

    public WrongLoginException() {
    }

    public WrongLoginException(String message) {
        super(message);
        System.out.println(message);
    }
}
