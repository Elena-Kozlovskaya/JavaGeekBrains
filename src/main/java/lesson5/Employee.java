package lesson5;

public class Employee {
   protected String fullName;
   protected String position;
   protected String email;
   protected String phone;
   protected int salary;
   protected int age;

    public Employee(String fullName, String position, String email, String phone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    /**
     * Выводит в консоль информацию об объекте
     */
    public void info(){
        System.out.println("ФИО: " + this.fullName + "\nДолжность: " + this.position + "\nEmail: " + this.email + "\nТелефон: " + this.phone + "\nЗарплата: " + this.salary + "\nВозраст: " + this.age);
    }


    /**
     * Поиск сотрудников старше 40 лет
     * @param employees
     */
    public static void checkEmployees(Employee[] employees) {
        for(int i = 0; i < employees.length; i++) {
            if (employees[i].age > 40) {
                employees[i].toString();
                System.out.println(employees[i]);
            }
        }
    }

}
