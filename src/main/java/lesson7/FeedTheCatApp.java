package lesson7;


public class FeedTheCatApp {
    public static void main(String[] args) {
        Plate plate = new Plate(150);
        Cat cat = new Cat("Vasiliy", 30,0);
        Cat cat1 = new Cat("Georg", 50,0);
        Cat cat2 = new Cat("Tom", 20,0);
        Cat cat3 = new Cat("Filip", 80,0);
        Cat[] cats = new Cat[] {cat, cat1, cat2, cat3};

        for (Cat c : cats) {
            c.info();
            plate.info();
            do {
                c.eat(plate);
            }
            while (!c.isSatiety());
        }
    }
}
