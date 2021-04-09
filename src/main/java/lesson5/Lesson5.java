package lesson5;

public class Lesson5 {
    public static void main(String[] args) {

        Employee employee = new Employee("Васильев Василий Васильевич", "Пуп земли", "trueGod@index.com","89008880000", 1000000, 33);

        Employee[] employees = new Employee[5];

        employees[0] = new Employee("Иванов Иван Иванович", "Директор", "ivivivan@index.com", "89092346145", 100000, 45);
        employees[1] = new Employee("Петров Петр Петрович", "Ведущий инженер", "petpetpetr@index.com", "89234567234", 90000, 42);
        employees[2] = new Employee("Сидоров Сидор Сидорович", "Инженер", "sisisidor@index.com", "89227686475", 50000, 34);
        employees[3] = new Employee("Александров Александр Александрович", "Бухгалтер", "alalalex@index.com", "89213647586", 85000, 38);
        employees[4] = new Employee("Иванова Ирина Александровна", "Секретарь", "ivalirina@index.com", "89127986378", 55000, 41);

        employee.info();
        System.out.println();

        Employee.checkEmployees(employees);

    }
}