package lesson_4;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Задание: Класс «Эмуляция интернет-магазина».
 * 1. Написать классы покупатель (ФИО, возраст, телефон), товар (название, цена) и
 * заказ (объект покупатель, объект товар, целочисленное количество).
 * 2. Создать массив покупателей (инициализировать 2 элемента), массив товаров
 * (инициализировать 5 элементов) и массив заказов (пустой на 5 элементов).
 * 3. Создать статический метод «совершить покупку» со строковыми параметрами,
 * соответствующими полям объекта заказа. Метод должен вернуть объект заказа.
 * 4. Если в метод передан несуществующий покупатель – метод должен выбросить
 * исключение CustomerException, если передан несуществующий товар, метод
 * должен выбросить исключение ProductException, если было передано отри-
 * цательное или слишком больше значение количества (например, 100), метод
 * должен выбросить исключение AmountException.
 * 5. Вызвать метод совершения покупки несколько раз таким образом, чтобы запол-
 * нить массив покупок возвращаемыми значениями. Обработать исключения сле-
 * дующим образом (в заданном порядке):
 * – если был передан неверный товар – вывести в консоль сообщение об ошиб-
 * ке, не совершать данную покупку;
 * – если было передано неверное количество – купить товар в количестве 1;
 * – если был передан неверный пользователь – завершить работу приложения
 * с исключением.
 * 6. Вывести в консоль итоговое количество совершённых покупок после выполне-
 * ния основного кода приложения
 *
 *
 * 1. В класс покупателя добавить перечисление с гендерами, добавить в сотрудника свойство «пол»
 * со значением созданного перечисления. Добавить геттеры, сеттеры.
 *
 * 2. Добавить в основную программу перечисление с праздниками (нет праздника, Новый Год, 8 марта, 23 февраля),
 * написать метод, принимающий массив сотрудников, поздравляющий всех сотрудников с Новым Годом,
 * женщин с 8 марта, а мужчин с 23 февраля, если сегодня соответствующий день.
 */

public class HomeWork {
    private static class Customer {
        String name;
        int age;
        String phone;
        Sex sex;

        public Customer(String name, int age, String phone, Sex sex) {
            this.name = name;
            this.age = age;
            this.phone = phone;
            this.sex = sex;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public Sex getSex() {
            return sex;
        }

        public void setSex(Sex sex) {
            this.sex = sex;
        }

        @Override
        public String toString() {
            return "Customer{name='" + name + '\'' +
                    ", age=" + age + ", phone='" + phone + "'}";
        }

    }

    private enum Sex {
        MALE, FEMALE;
    }

    private enum Holiday {
        MART8("8 марта"),
        FEBRUARY23("23 февраль"),
        HAPPYNEWYAR("Новый год"),
        NO("Нет праздника");

        private String name;

        Holiday(String name) {
            this.name = name;
        }
    }



    public static void congratulate(Customer[] people){

        Date date = new Date(105, 1, 23);

        for (Customer c : people) {

            if(date.getMonth()==2 && date.getDate()==8 && c.getSex()==Sex.FEMALE){
                System.out.println("Поздравляем " + c.getName() + " c " + Holiday.MART8.name);
            } else if (date.getMonth()==1 && date.getDate()==23 && c.getSex()==Sex.MALE){
                System.out.println("Поздравляем " + c.getName() + " c " + Holiday.FEBRUARY23.name);
            }  else if (date.getMonth()==0 && date.getDate()==1){
                System.out.println("Поздравляем " + c.getName() + " c " + Holiday.HAPPYNEWYAR.name);
            } else {
                System.out.println(Holiday.NO.name);
            }


        }
    }






    private static class Item {
        String name;
        int cost;

        public Item(String name, int cost) {
            this.name = name;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Item{name='" + name + "', cost=" + cost + "}";
        }
    }

    private static class Order {
        Customer customer;
        Item item;
        int amount;

        public Order(Customer customer, Item item, int amount) {
            this.customer = customer;
            this.item = item;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "Order{customer=" + customer +
                    ", item=" + item + ", amount=" + amount + "}";
        }
    }

    public static class CustomerException extends RuntimeException {
        public CustomerException(String message) {
            super(message);
        }
    }

    public static class ProductException extends RuntimeException {
        public ProductException(String message) {
            super(message);
        }
    }

    public static class AmountException extends RuntimeException {
        public AmountException(String message) {
            super(message);
        }
    }

    private final static Customer[] people = {
            new Customer("Ivan", 20, "+1-222-333-44-55", Sex.MALE),
            new Customer("Petr", 30, "+2-333-444-55-66", Sex.MALE),
    };
    private final static Item[] items = {
            new Item("Ball", 100),
            new Item("Sandwich", 1000),
            new Item("Table", 10000),
            new Item("Car", 100000),
            new Item("Rocket", 10000000)
    };
    private static Order[] orders = new Order[5];

    private static boolean isInArray(Object[] arr, Object o) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i].equals(o)) return true;
        return false;
    }

    public static Order buy(Customer who, Item what, int howMuch) {
        if (!isInArray(people, who))
            throw new CustomerException("Unknown customer: " + who);
        if (!isInArray(items, what))
            throw new ProductException("Unknown item: " + what);
        if (howMuch < 0 || howMuch > 100)
            throw new AmountException("Incorrect amount: " + howMuch);
        return new Order(who, what, howMuch);

    }

    public static void main(String[] args) {

        congratulate(people);

        Object[][] info = {
                {people[0], items[0], 1}, //good
                {people[1], items[1], -1}, //bad amount -1
                {people[0], items[2], 150}, //bad amount >100
                {people[1], new Item("Flower", 10), 1}, //no item
                {new Customer("Fedor", 40, "+3-444-555-66-77", Sex.MALE), items[3], 1}, //no customer
        };
        int capacity = 0;
        int i = 0;
        while (capacity != orders.length - 1 || i != info.length) {
            try {
                orders[capacity] = buy((Customer) info[i][0], (Item) info[i][1], (int) info[i][2]);
                capacity++;
            } catch (ProductException e) {
                e.printStackTrace();
            } catch (AmountException e) {
                orders[capacity++] = buy((Customer) info[i][0], (Item) info[i][1], 1);
            } catch (CustomerException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("Orders made: " + capacity);
            }
            ++i;
        }
    }


}
