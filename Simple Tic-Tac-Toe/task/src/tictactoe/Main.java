package tictactoe;

import java.util.Scanner;

public class Main {
    private static void printField(char[][] field) {
        System.out.println("---------");
        System.out.println("| " + field[0][0] + " " + field[0][1] + " " + field[0][2] + " |");
        System.out.println("| " + field[1][0] + " " + field[1][1] + " " + field[1][2] + " |");
        System.out.println("| " + field[2][0] + " " + field[2][1] + " " + field[2][2] + " |");
        System.out.println("---------");

    }

    private static boolean checkGameState(char[][] field) {
        //проверка состояния игры
        int xwins = 0;
        int owins = 0;
        int emptycells = 0;
        int x = 0;
        int o = 0;

        //подсчет побед х
        for (int i = 0; i < 3; i++) {
            if (field[i][0] == 'X' && field[i][1] == 'X' && field[i][2] == 'X') {
                xwins++;
            }
            if (field[0][i] == 'X' && field[1][i] == 'X' && field[2][i] == 'X') {
                xwins++;
            }
        }
        if (field[0][0] == 'X' && field[1][1] == 'X' && field[2][2] == 'X') {
            xwins++;
        }
        if (field[2][0] == 'X' && field[1][1] == 'X' && field[0][2] == 'X') {
            xwins++;
        }
        //подсчет побех о
        for (int i = 0; i < 3; i++) {
            if (field[i][0] == 'O' && field[i][1] == 'O' && field[i][2] == 'O') {
                owins++;
            }
            if (field[0][i] == 'O' && field[1][i] == 'O' && field[2][i] == 'O') {
                owins++;
            }
        }
        if (field[0][0] == 'O' && field[1][1] == 'O' && field[2][2] == 'O') {
            owins++;
        }
        if (field[2][0] == 'O' && field[1][1] == 'O' && field[0][2] == 'O') {
            owins++;
        }
        //подсчет пустых клеток
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j] == 'X') {
                    x++;
                } else if (field[i][j] == 'O') {
                    o++;
                } else {
                    emptycells++;
                }
            }
        }
        if (Math.abs(x - o) > 1) {
            System.out.println("Impossible");
            return true;
        } else {
            if (owins == 0 && xwins == 0) {
                if (emptycells == 0) {
                    System.out.println("Draw");
                    return true;
                } else {
                    //System.out.println("Game not finished");
                    return false;
                }
            }
            if (owins == 1 && xwins == 0) {
                System.out.println("O wins");
                return true;
            }
            if (owins == 0 && xwins == 1) {
                System.out.println("X wins");
                return true;
            }
            if (owins != 0 && xwins != 0) {
                System.out.println("Impossible");
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] field = new char[3][3];
        //запишем поле в массив
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = ' ';
                k++;
            }
        }
        printField(field);
        boolean isXMove = true;
        while (true) {
            int x = 0;
            int y = 0;

            boolean isCorrectInput = false;
            while (!isCorrectInput) {
                try {
                    String input = scanner.nextLine();
                    String inputArr[] = input.split(" ");
                    x = Integer.parseInt(inputArr[0]);
                    y = Integer.parseInt(inputArr[1]);


                } catch (Exception e) {
                    System.out.println("You should enter numbers!");
                }
                if (x > 3 || x < 1 || y > 3 || y < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                if (field[x - 1][y - 1] != 'X' && field[x - 1][y - 1] != 'O') {
                    field[x - 1][y - 1] = isXMove ? 'X' : 'O';
                    isXMove = !isXMove;
                    printField(field);
                    isCorrectInput = true;

                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }
            }
            if (checkGameState(field)) {
                break;
            }

        }
        /*

        /*System.out.println(x);
        System.out.println(o);
        System.out.println(emptycells);*/
    }
}
