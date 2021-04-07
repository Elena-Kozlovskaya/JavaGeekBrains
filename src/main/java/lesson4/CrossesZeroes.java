package lesson4;

import java.util.Random;
import java.util.Scanner;



public class CrossesZeroes {
    public static char[][] map;
    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 4;

    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static final char DOT_EMPTY = '*';

    public static final Scanner scanner = new Scanner(System.in);
    public static final Random random = new Random();

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= map.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < map.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }
        if (map[x][y] == DOT_EMPTY) {
            return true;
        }
        return false;
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате Х Y:");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[x][y] = DOT_X;
    }

    public static void aiTurn() {
        int x, y;
        if (!canBlock(DOT_X)) {
            do {
                System.out.println("Введите координаты в формате Х Y:");
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            } while (!isCellValid(x, y));
            System.out.printf("Искусственный интелект ходит: : %d %d", x + 1, y + 1);
            System.out.println();
            map[x][y] = DOT_O;
        }
    }

    /**
     * Проверка линий на возможность заблокировать победный ход человека
     * @param dot DOT_X
     * @return true; переход в метод, определяющий координаты и выполняющий ход компьютера
     */
    public static boolean canBlock(char dot) {
        int countVert = 0;
        int countHor = 0;
        int countLeftDiag = 0;
        int countRightDiag = 0;
        int i, j = 0;
        for (i = 0; i < map.length; i++) {
            if (map[i][i] == dot) {
                countLeftDiag++;
            }
            if (map[i][i] == DOT_O) {
                countLeftDiag--;
            }
            if (map[i][map.length - 1 - i] == dot) {
                countRightDiag++;
            }
            if (map[i][map.length - 1 - i] == DOT_O) {
                countRightDiag--;
            }
        }
        if (countRightDiag == DOTS_TO_WIN - 1) {
            blockCellRightDiag();
            return true;
        }
        if (countLeftDiag == DOTS_TO_WIN - 1) {
            blockCellLeftDiag();
            return true;
        }

        for (i = 0; i < map.length; i++) {
            for (j = 0; j < map[i].length; j++) {
                if (map[i][j] == dot) {
                    countHor++;
                }
                if (map[i][j] == DOT_O) {
                    countHor--;
                }
            }
            if (countHor == DOTS_TO_WIN - 1) {
                i = i;
                blockCellHor(i);
                return true;
            }
            countHor = 0;
        }

        for (i = 0; i < map.length; i++) {
            for (j = 0; j < map[i].length; j++) {
                if (map[j][i] == dot) {
                    countVert++;
                }
                if (map[j][i] == DOT_O) {
                    countVert--;
                }
                if (countVert == DOTS_TO_WIN - 1) {
                    i = i;
                    blockCellVert(i);
                    return true;
                }
            }
            countVert = 0;
        }
        return false;
    }

    /**
     * Определение координат по левой основной диагонали и выполнение хода компьтера для блокировки победы человека
     */
    public static void blockCellLeftDiag() {
        int i;
        for (i = 0; i < map.length; i++) {
            if (map[i][i] == DOT_EMPTY) {
                map[i][i] = DOT_O;
                break;
            }
        }
        System.out.println("Введите координаты в формате Х Y:");
        System.out.printf("Кожаный мешок я знаю твои планы! Вот тебе: : %d %d", i + 1, i + 1);
        System.out.println();
    }

    /**
     * Определение координат по правой основной диагонали и выполнение хода компьтера для блокировки победы человека
     */
    public static void blockCellRightDiag() {
        int i;
        for ( i = 0; i < map.length; i++) {
            if (map[i][map.length - 1 - i] == DOT_EMPTY) {
                map[i][map.length - 1 - i] = DOT_O;
                break;
            }
        }
        System.out.println("Введите координаты в формате Х Y:");
        System.out.printf("Кожаный мешок я знаю твои планы! Вот тебе: : %d %d", i + 1, (map.length - 1 - i) + 1);
        System.out.println();
    }

    /**
     * Определение координат по горизонтали и выполнение хода компьтера для блокировки победы человека
     * @param i номер горизонтали
     */
    public static void blockCellHor(int i) {
        int j = 0;
        for (j = 0; j <= map.length - 1; j++) {
            if (map[i][j] == DOT_EMPTY) {
                map[i][j] = DOT_O;
                break;
            }
        }
        System.out.println("Введите координаты в формате Х Y:");
        System.out.printf("Кожаный мешок я знаю твои планы! Вот тебе: : %d %d", i + 1, j + 1);
        System.out.println();
    }

    /**
     * Определение координат по вертикали и выполнение хода компьтера для блокировки победы человека
     * @param i номер вертикали
     */
    public static void blockCellVert(int i) {
        int j;
        for (j = 0; j <= map.length - 1; j++) {
            if (map[j][i] == DOT_EMPTY) {
                map[j][i] = DOT_O;
                break;
            }
        }
        System.out.println("Введите координаты в формате Х Y:");
        System.out.printf("Кожаный мешок я знаю твои планы! Вот тебе: : %d %d", j + 1, i + 1);
        System.out.println();
    }


    public static boolean checkWin(char dot) {
        int countVert = 0;
        int countHor = 0;
        int countDiag1 = 0;
        int countDiag2 = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i][i] == dot) {
                countDiag1++;
            }
            if (map[i][map.length - 1 - i] == dot) {
                countDiag2++;
            }
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == dot) {
                    countHor++;
                }
                if (map[j][i] == dot) {
                    countVert++;
                }
            }
            if (countVert == DOTS_TO_WIN | countHor == DOTS_TO_WIN | countDiag1 == DOTS_TO_WIN |  countDiag2 == DOTS_TO_WIN) {
                return true;
            } else {
                countHor = 0;
                countVert = 0;
            }
        }
        return false;
    }

    public static boolean isFull() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void play() {
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Выиграл человек!");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья!");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Кожаный мешок, я победил!");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья!");
                break;
            }
        }
    }

    public static void main (String[]args) {
        initMap();
        printMap();
        play();
    }
}

