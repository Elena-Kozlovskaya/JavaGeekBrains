package lesson6;

public class AnimalApp {
    public static void main(String[] args) {

        Animal cat = new Cat("Barsik");
        Animal dog = new Dog("Sharik");
        Animal dog1 = new Dog ("Bobik");
        Animal[] animals = new Animal[]{cat, dog, dog1};
        for(Animal a : animals){
            a.run(400);
            a.swim(20);
        }

        System.out.println("Created of all animals: " + Animal.getAnimalCount());
        System.out.println("Created cats: " + Cat.getCatCount());
        System.out.println("Created dogs: " + Dog.getDogCount());


    }
}