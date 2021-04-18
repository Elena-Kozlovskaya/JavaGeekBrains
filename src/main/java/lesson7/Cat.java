
package lesson7;

public class Cat {
    private  String name;
    private int appetite;
    private int satiety;

    public Cat(String name, int appetite, int satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;
    }

    public void info() {

        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", appetite=" + appetite +
                ", satiety=" + satiety +
                '}';
    }

    public String getName() {

        return this.name;
    }

    public void setName(String name) {

        this.name = name;
    }


    public int getAppetite() {

        return appetite;
    }

    public void setAppetite(int appetite) {

        this.appetite = appetite;
    }

    public int getSatiety() {

        return satiety;
    }

    public void setSatiety(int satiety) {

        this.satiety = satiety;
    }

    /**
     * Проверка сытости.
     * @return true
     */
    public boolean isSatiety() {
        return satiety > 0;
    }

    /**
     * Убавляет количество еды в тарелке, если удалось поесть, присваивает переменной сытость значение аппетита.
     * Если поесть не удалось, вызывает метод наполняющий тарелку.
     * @param plate
     */
    public void eat(Plate plate) {
        if (plate.decreaseCount(this.appetite)) {
            satiety = appetite;
            System.out.println(isSatiety());
        } else if (!isSatiety()) {
            System.out.println(isSatiety());
            System.out.println("Fill the plate! I'm hungry!");
            plate.fillThePlate();
        }
    }
}