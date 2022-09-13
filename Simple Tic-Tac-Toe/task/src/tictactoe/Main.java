package tictactoe;

import java.util.Scanner;

public class Main {

    public static int countP(String[] arr, String player) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(player)) total++;
        }
        return total;
    }

    public static boolean hasSpace(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(" ")) return true;
        }
        return false;
    }

    public static boolean hasWon(String[] arr, String player) {
        if (arr[0].equals(player) && arr[1].equals(player) && arr[2].equals(player)) return true;
        else if (arr[3].equals(player) && arr[4].equals(player) && arr[5].equals(player)) return true;
        else if (arr[6].equals(player) && arr[7].equals(player) && arr[8].equals(player)) return true;
        else if (arr[0].equals(player) && arr[3].equals(player) && arr[6].equals(player)) return true;
        else if (arr[1].equals(player) && arr[4].equals(player) && arr[7].equals(player)) return true;
        else if (arr[2].equals(player) && arr[5].equals(player) && arr[8].equals(player)) return true;
        else if (arr[0].equals(player) && arr[4].equals(player) && arr[8].equals(player)) return true;
        else if (arr[6].equals(player) && arr[4].equals(player) && arr[2].equals(player)) return true;
        else return false;
    }

    public static boolean checkGame(String[] array) {
        if (hasSpace(array)) {
            // check X if has 3
            if (hasWon(array, "X") && !hasWon(array, "O")) {
                System.out.println("X wins");
                return true;
            }
                // check O if has 3
            else if (hasWon(array, "O") && !hasWon(array, "X")) {
                System.out.println("O wins");
                return true;
            }
                // else game not finished
            //else if (countP(array, "X") - countP(array, "O") == 0) System.out.println("Game not finished");
            //else System.out.println("Impossible");
        } else {
            // check X if has 3
            if (hasWon(array, "X")){
                System.out.println("X wins");
                return true;
            }
                // check O if has 3
            else if (hasWon(array, "O")){
                System.out.println("O wins");
                return true;
            }
                // draw+
//            else if ((countP(array, "X") == 3 && countP(array, "O") == 3)
//                    || (countP(array, "X") - countP(array, "O") > 1)
//                    || (countP(array, "O") - countP(array, "X") > 1)) System.out.println("Impossible");
            else {
                System.out.println("Draw");
                return true;
            }
        }
        return false;
    }

    public static void printBoard(String[] array) {
        System.out.println("---------");

        for (int x = 0; x < array.length; x++) {
            if (x == 0 || x == 3 || x == 6) {
                System.out.print("| ");
            }
            System.out.print(array[x].toUpperCase() + " ");

            if (x == 2 || x == 5 || x == 8) {
                System.out.print("|");
                System.out.println();
            }
        }

        System.out.println("---------");
    }

    public static boolean isNumber(String str) {
        if (str == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] array = {" "," "," "," "," "," "," "," "," "};
        String turn = "X";

        while (true) {

            String location = scanner.nextLine();
            String[] locationArray = location.split(" ");
            if (!isNumber(locationArray[0]) || !isNumber(locationArray[1])) {
                System.out.println("You should enter numbers!");
                continue;
            }

            int x = Integer.parseInt(locationArray[1]);
            int y = Integer.parseInt(locationArray[0]);

            if (x < 1 || x > 3 || y < 1 || y > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }


            int index = x - 1 + ((y - 1) * 3);
            if (!array[index].equals(" ")) {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            array[index] = turn;
            printBoard(array);

            if (checkGame(array)) break;

            if (turn.equals("X")) {
                turn = "O";
            } else {
                turn = "X";
            }

        }

    }
}
