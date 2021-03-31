package lesson3;

import java.util.Arrays;

public class HomeWorkApp3 {
    public static void main(String[] args) {
        invertArray();
        fillArray();
        isLessThanSix();
        fillArrayDiagonals();
        System.out.println(Arrays.toString(returnArray(4, 3)));
        findMinAndMax();
        boolean t = isArrayPartsEqual(new int[] {1, 3, 1, 1, 2, 2});
        System.out.println(t);
        arrayShiftLeft(new int[]{1, 2, 3, 4, 5}, 2);
    }

    /**
     * Инверсия элементов целочисленного массива
     */
    private static void invertArray() {
        int[] array = {1, 1, 0, 0, 1, 0, 0};
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] == 0) ? 1 : 0;
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * Заполняет целочисленный массив длиной 100, значениями от 0 до 100
     */
    private static void fillArray() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * Значения меньше 6 умножить на 2
     */
    private static void isLessThanSix() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] = array[i] * 2;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * Заполняет диагональные элементы значением 1
     * Остальные тоже заполнила, так интереснее)
     */
    private static void fillArrayDiagonals() {
        int[][] array = new int[8][8];
        int max = array.length;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if ((j == i) | (j == (max - 1))) {
                    array[i][i] = 1;
                } else {
                    array[i][i] = 8;
                }
                System.out.print(array[i][i] + " ");
            }
            System.out.println();
            max--;
        }
    }

    /**
     * Заполняет одномерный массив
     * @param len длинна массива
     * @param initialValue значение для каждого элемента
     * @return одномерный массив
     */
    private static int[] returnArray(int len, int initialValue) {
        int[] array = new int[len];
        Arrays.fill(array, initialValue);
        return array;
    }

    /**
     * Поиск максимального и минимального элемента в массиве
     */
    private static void findMinAndMax() {
        int[] array = {1, 3, 7, -3, 10, 28};
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("Min element = " + min + " Max element = " + max);
    }

    /**
     * Определяет место в массиве, в котором сумма левой и правой части массива равны
     * @param array одномерный целочисленный массив
     * @return true
     */
    private static boolean isArrayPartsEqual(int[] array){
        int sumI = 0;
        int sumJ = 0;
        int n = 1;
        for (int i = array.length - n; i >= 0; i--) {
            sumI = sumI + array[i];
            for (int j = 0; j < array.length - n; j++) {
                sumJ = sumJ + array[j];
            }
            if (sumI == sumJ) {
                break;
            } else {
                sumJ = 0;
                n++;
            }
        } return (sumI == sumJ);
    }

    /**
     * Смещение элементов массива на n позиций влево
     * @param arr одномерный целочисленный массив
     * @param n количество позиций для смещения
     */
    public static void arrayShiftLeft(int[] arr, int n) {
        int temp;
        int index;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < arr.length; i++) {
                if (i + 1 > arr.length - 1) {
                    break;
                } else {
                    index = i + 1;
                }
                temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}





