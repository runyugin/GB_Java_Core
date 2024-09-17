package homework_3;

import java.util.List;

public class Employee {

    private static final int CURRENT_YEAR = 2024;
    String name;
    String midName;
    String surName;
    String position;
    String phone;
    int salary;
    int birth;

    int bMonth;
    int bDay;


    public Employee(String name, String midName, String surName,
                    String phone, String position, int salary, int birth) {
        this.name = name;
        this.midName = midName;
        this.surName = surName;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public String getMidName() {
        return midName;
    }

    public String getSurName() {
        return surName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return CURRENT_YEAR - birth;
    }


    public void voidEmployee() {
        System.out.println("Employee{" +
                "name='" + name + '\'' +
                ", midName='" + midName + '\'' +
                ", surName='" + surName + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", birth=" + birth +
                '}');
    }


   public static void addSalary(List<Employee> employees, int addSalary, int age) {
       for (Employee employee : employees) {
           if (employee.getAge() > age) {
               employee.setSalary(employee.getSalary() + addSalary);
           }
       }
   }


    public static void attSalary(List<Employee> employees) {
        float sum = 0.0F;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        System.out.println("Средня зарплата по сотрудникам: " + sum/employees.size());
    }

    public static void attAge(List<Employee> employees) {
        float sum = 0.0F;
        for (Employee employee : employees) {
            sum += employee.getAge();
        }
        System.out.println("Средний вовозраст по сотрудникам: " + sum/employees.size());
    }


    public int compare(int dd, int mm, int yyyy) {
        int empl = bDay + (bMonth << 6) + (birth << 11);
        int income = dd + (mm << 6) + (yyyy << 11);
        return empl - income;
    }

}

