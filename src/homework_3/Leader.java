package homework_3;

import java.util.List;

public class Leader extends Employee {

    public Leader(String name, String midName, String surName, String phone, String position, int salary, int birth) {
        super(name, midName, surName, phone, position, salary, birth);
        }

        public static void increaser(List<Employee> employeeLis, int age, int increment) {
            for (Employee employeeLi : employeeLis) {
                if (employeeLi.getAge() > age) {
                    if (!(employeeLi instanceof Leader))
                        employeeLi.setSalary(employeeLi.getSalary() + increment);
                    ;
                }
            }
        }
}