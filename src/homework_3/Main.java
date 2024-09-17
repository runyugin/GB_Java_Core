package homework_3;

import java.util.ArrayList;
import java.util.List;

/***
1.Написать прототип компаратора - метод внутри класса сотрудника, сравнивающий две даты, представленные в виде трёх чисел гггг-мм-дд,
 без использования условного оператора.

2. Опишите класс руководителя, наследник от сотрудника.
 Перенесите статический метод повышения зарплаты в класс руководителя, модифицируйте метод таким образом,
 чтобы он мог поднять заработную плату всем, кроме руководителей. В основной программе создайте руководителя и поместите его в общий массив сотрудников.
 Повысьте зарплату всем сотрудникам и проследите, чтобы зарплата руководителя не повысилась.
***/


public class Main {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        Employee ivan = new Employee("Ivan", "Igorevich","Ovchinnikov", "8(495)000-11-22","developer", 50000, 1985);
        Employee andrey = new Employee("Andrey", "Viktorovich","Bezrukov", "8(495)111-22-33", "fitter", 52000, 1973);
        Employee evgeniy = new Leader("Evgeniy", "Viktorovich", "Delfinov", "8(495)222-33-44", "project manager", 40000, 1963);
        Employee natalia = new Employee("Natalia", "Pavlovna", "Keks", "8(495)333-44-55", "senior developer", 90000, 1990);
        Employee tatiana = new Employee("Tatiana", "Sergeevna", "Krasotkina", "8(495)444-55-66", "accountant", 50000, 1983);

        employees.add(ivan);
        employees.add(andrey);
        employees.add(evgeniy);
        employees.add(natalia);
        employees.add(tatiana);

        for (int i = 0; i < employees.size(); i++) {
            employees.get(i).voidEmployee();
        }

        Employee.addSalary(employees, 5000, 45);


        for (int i = 0; i < employees.size(); i++) {
            employees.get(i).voidEmployee();
        }

        Employee.attSalary(employees);
        Employee.attAge(employees);


    }
}
