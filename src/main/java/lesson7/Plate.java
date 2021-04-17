package lesson7;

public class Plate {

    private int foodCount;


    public Plate(int foodCount) {
        this.foodCount = foodCount;
    }

    public int getFoodCount() {
        return foodCount;
    }

    public void setFoodCount(int foodCount) {
        this.foodCount = foodCount;
    }

    public boolean decreaseCount(int appetite) {
        if (isPlateValid(appetite)) {
            foodCount -= appetite;
            return true;
        } else {
            System.out.println("There is too little food on the plate");
            return false;
        }
    }


    public void info() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Plate{" +
                "foodCount=" + foodCount +
                '}';
    }

    /**
     * Проверка соответсвия количества еды в тарелке аппетиту.
     * @param appetite
     * @return true
     */
    private boolean isPlateValid(int appetite) {
        if (foodCount >= appetite) {
            return true;
        }
        return false;
    }

    /**
     * Наполнение тарелки.
     */
    public void fillThePlate(){
        setFoodCount(150);
        info();
    }

}