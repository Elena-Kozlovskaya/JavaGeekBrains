package lesson6;

public class Dog extends Animal {
    private final int AB_TO_SWIM = 10;
    private final int AB_TO_RUN = 500;
    private static int dogCount = 0;


    public Dog(String name) {
        super(name);
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }

    public static void setDogCount(int dogCount) {
        Dog.dogCount++;
        Dog.dogCount = dogCount;
    }



    @Override
    public void swim(int distance) {
        if(distance <= AB_TO_SWIM) {
            super.swim(distance);
        } else if (distance > AB_TO_SWIM) {
            super.swim(AB_TO_SWIM);
        }
    }

    @Override
    public void run(int distance) {
        if(distance <= AB_TO_RUN) {
            super.run(distance);
        } else if (distance > AB_TO_RUN) {
            super.run(AB_TO_RUN);
        }
    }
}