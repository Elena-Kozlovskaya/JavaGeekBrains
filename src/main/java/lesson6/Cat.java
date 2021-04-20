package lesson6;

public class Cat extends Animal {
    private final int AB_TO_SWIM = 0;
    private final int AB_TO_RUN = 200;
    private static int catCount = 0;

    public Cat(String name) {
        super(name);
        catCount++;
    }

    public int getAB_TO_SWIM() {
        return AB_TO_SWIM;
    }

    public int getAB_TO_RUN() {
        return AB_TO_RUN;
    }

    public static int getCatCount() {
        return catCount;
    }

    public static void setCatCount(int catCount) {
        Cat.catCount++;
        Cat.catCount = catCount;
    }

    @Override
    public void swim(int distance) {
        if (distance >= AB_TO_SWIM) {
            System.out.println(name + " can't swim");
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