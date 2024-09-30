package lesson_4;

/**
 *
 * Задача: Проверка логина и пароля
 * 1. Создать статический метод который принимает на вход три
 * параметра: login, password и confirmPassword.
 * 2. Длина login должна быть меньше 20 символов. Если login не
 * соответствует этим требованиям, необходимо выбросить
 * WrongLoginException.
 * 3. Длина password должна быть меньше 20 символов. Также password
 * и confirmPassword должны быть равны. Если password не
 * соответствует этим требованиям, необходимо выбросить
 * WrongPasswordException.
 * 4. WrongPasswordException и WrongLoginException - пользовательские
 * классы исключения с двумя конструкторами – один по умолчанию,
 * второй принимает сообщение исключения и передает его в
 * конструктор класса Exception.
 * 5. В основном классе программы необходимо по-разному обработать
 * исключения.
 * 6. Метод возвращает true, если значения верны или false в другом
 * случае.
 *
 * **/

public class ClassRoom {

public static void main(String[] args){

    System.out.println(loginAndPass("ivan", "123456789012345678901", "123456789012345678901"));

    System.out.println(loginAndPass("dmitriy", "12345", "1234"));

    System.out.println(loginAndPass("evgenii", "1234", "1234"));

    System.out.println(loginAndPass("konstantinoipolipolusapaypes", "sss", "sss"));
}

    public static boolean loginAndPass(String login, String password, String confirmPassword) {

        if(login.length()>20){
            try {
                throw new WrongLoginException("Long login");
            } catch (WrongLoginException e) {
                return false;
            }
        } else if(password.length()<20 || !confirmPassword.equals(password)){
            try {
                throw new WrongPasswordException("Password error");
            } catch (WrongPasswordException e) {
                return false;
            }
        }

        return true;
    }


}
