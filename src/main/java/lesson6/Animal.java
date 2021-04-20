package lesson6;

public class Animal {
    protected String name;
    private static int animalCount = 0;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public static void setAnimalCount(int animalCount) {
        Animal.animalCount++;
        Animal.animalCount = animalCount;
    }

    public void swim(int distance) {
        if (distance >= 0) {
            System.out.println(name + " swam " + distance + " meters");
        } else {
            System.out.println("The distance value must be a positive number");
        }
    }
    public void run(int distance) {
        if (distance >= 0) {
            System.out.println(name + " ran " + distance + " meters");
        } else {
            System.out.println("The distance value must be a positive number");
        }
    }
}