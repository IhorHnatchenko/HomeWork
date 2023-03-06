import java.util.Scanner;

public class Main {
    private static final int FIELD_SIZE = 10;
    //{countDeck - index 0, countShip - index 1}
    private static final int[][] SHIPS = {{4, 1}, {3, 2}, {2, 3}, {1, 4}};

    public static void main(String[] args) {

        String playerOne;
        String playerTwo;


        Scanner scanner = new Scanner(System.in);
        System.out.print("Player one, enter your name: ");
        playerOne = scanner.nextLine();
        System.out.print("Player two, enter your name: ");
        playerTwo = scanner.nextLine();
        System.out.println("---- " + playerOne + " VS " + playerTwo + " ----");
        char[] topOfMap = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        char[][] mainFieldPlayerOne = new char[FIELD_SIZE][FIELD_SIZE];
        char[][] mainFieldPlayerTwo = new char[FIELD_SIZE][FIELD_SIZE];

        char[][] extraEnemyFieldOne = new char[FIELD_SIZE][FIELD_SIZE];
        char[][] extraEnemyFieldTwo = new char[FIELD_SIZE][FIELD_SIZE];

        System.out.println("Add ships on field.");
        fillPlayerField(mainFieldPlayerOne, topOfMap);
        System.out.println("Add ships on field.");
        fillPlayerField(mainFieldPlayerTwo, topOfMap);

        //startGame(playerOne, playerTwo, mainFieldPlayerOne, mainFieldPlayerTwo, topOfMap, extraEnemyFieldOne, extraEnemyFieldTwo);
        System.out.println();
        System.out.println("---------- START GAME ----------");
        System.out.println("Field player " + playerOne);
        printField(mainFieldPlayerOne, topOfMap);
        System.out.println();
        System.out.println("Field Player " + playerTwo);
        printField(mainFieldPlayerTwo, topOfMap);
        System.out.println();


        while (true) {
            makeTurn(playerOne, extraEnemyFieldOne, topOfMap, mainFieldPlayerOne);
            if (mainCounterOfWin(playerOne, playerTwo, extraEnemyFieldOne, extraEnemyFieldTwo)) {
                break;
            }
            makeTurn(playerTwo, extraEnemyFieldTwo, topOfMap, mainFieldPlayerTwo);
            if (mainCounterOfWin(playerOne, playerTwo, extraEnemyFieldOne, extraEnemyFieldTwo)) {
                break;
            }
        }
    }

    private static boolean mainCounterOfWin(String playerOne, String playerTwo, char[][] extraEnemyFieldOne, char[][] extraEnemyFieldTwo) {


        int countBreakDeckOne = 0;
        for (char[] chars : extraEnemyFieldOne) {
            for (char aChar : chars) {
                if (aChar == 2) {
                    countBreakDeckOne++;
                }
            }
        }

        int countBreakDeckTwo = 0;
        for (char[] chars : extraEnemyFieldTwo) {
            for (char aChar : chars) {
                if (aChar == 2) {
                    countBreakDeckTwo++;
                }
            }
        }

        if (countBreakDeckOne >= 20) {
            System.out.println(playerOne + " WIN!!!");
            return true;
        }
        if (countBreakDeckTwo >= 20) {
            System.out.println(playerTwo + " WIN!!!");
            return true;
        }
        return false;
    }

    private static void makeTurn(String player, char[][] extraEnemyFiled, char[] topOfMap, char[][] field) {
        int extraCounterForWin = 0;
        int x;
        int y;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(player + " make your turn.");
            int coordX = 1;
            int coordXS = 0;
            int coordY = 1;
            for (int j = 0; j < FIELD_SIZE; ++j) {
                if (j == 0) {
                    System.out.print("███ ");
                }
                System.out.print(topOfMap[coordXS++]);
                System.out.print(" ");
            }
            System.out.println();

            for (int j = 0; j < FIELD_SIZE; ++j) {
                if (j == 0) {
                    System.out.print("███ ");
                }
                System.out.print(coordX++);
                System.out.print(" ");
            }
            System.out.println();

            for (int i = 0; i < FIELD_SIZE; ++i) {
                if (i < 9) {
                    System.out.print(coordY++ + " | ");
                } else {
                    System.out.print(coordY++ + "| ");
                }
                for (int j = 0; j < FIELD_SIZE; ++j) {
                    if (extraEnemyFiled[i][j] == 0) {
                        System.out.print("W ");
                    } else if (extraEnemyFiled[i][j] == 1) {
                        System.out.print("* ");
                    } else if (extraEnemyFiled[i][j] == 2) {
                        System.out.print("X ");
                    }
                }
                System.out.println("|");

            }
            System.out.print("Enter x: ");
            x = scanner.nextInt();
            System.out.print("Enter y: ");
            y = scanner.nextInt();
            x--;
            y--;
            if (field[x][y] == 1) {
                System.out.println("HIT!!! Make your turn again.");
                extraEnemyFiled[x][y] = 2;
                extraCounterForWin++;
                if (extraCounterForWin == 20) {
                    break;
                }
            } else{
                System.out.println("Mis. Your opponents turn.");
                extraEnemyFiled[x][y] = 1;
                break;
            }

        }
    }

    private static boolean validationCoordinate(char[][] field, int x, int y, int direction, int shipDeck) {
        //check field border
        if (direction == 1) {
            if (x + shipDeck > field.length) {
                return false;
            }
        }
        if (direction == 2) {
            if (y + shipDeck > field[0].length) {
                return false;
            }
        }

        while (shipDeck != 0) {
            for (int i = 0; i < shipDeck; i++) {
                int xi = 0;
                int yi = 0;
                if (direction == 1) {
                    xi = i;
                } else {
                    yi = i;
                }
                if (x + 1 + xi < field.length && x + 1 + xi >= 0) {
                    if (field[x + 1 + xi][y + yi] != 0) {
                        return false;
                    }
                }
                if (x - 1 + xi < field.length && x - 1 + xi >= 0) {
                    if (field[x - 1 + xi][y + yi] != 0) {
                        return false;
                    }
                }

                if (y + 1 + yi < field.length && y + 1 + yi >= 0) {
                    if (field[x + xi][y + 1 + yi] != 0) {
                        return false;
                    }
                }
                if (y - 1 + yi < field.length && y - 1 + yi >= 0) {
                    if (field[x + xi][y - 1 + yi] != 0) {
                        return false;
                    }
                }
            }
            shipDeck--;
        }


        return true;
    }

    private static void fillPlayerField(char[][] field, char[] topOfMpa) {
        Scanner scInt = new Scanner(System.in);
        int shipCount;
        int shipDeck;
        printField(field, topOfMpa);
        for (int[] ship : SHIPS) {
            shipCount = ship[1];
            for (int j = 0; j < shipCount; j++) {
                shipDeck = ship[0];

                boolean resultCheck = false;
                while (!resultCheck) {
                    int x;
                    int y;
                    //ask first (x,y)
                    System.out.println("Now deck -> " + shipDeck);
                    System.out.println("Now count ->" + shipCount);
                    System.out.print("Enter x: ");
                    x = scInt.nextInt();
                    System.out.print("Enter y: ");
                    y = scInt.nextInt();
                    int direction;
                    //ask direction (1-horizont, 2-vertikal
                    System.out.println("Enter direction:");
                    System.out.println("1-Vertical, 2-Horizontal");
                    System.out.println("If you enter something more then 2. It will be Horizontal");
                    System.out.print("-->>");
                    direction = scInt.nextInt();
                    //field[x][y] = 1;
                    x--;
                    y--;
                    if (!validationCoordinate(field, x, y, direction, shipDeck)) {
                        System.out.println("------ Wrong x or y. -------");
                        continue;
                    }
                    for (int s = 0; s < shipDeck; s++) {
                        if (direction == 1) {
                            field[x + s][y] = 1;
                        } else {
                            field[x][y + s] = 1;
                        }
                    }

                    resultCheck = true;
                    printField(field, topOfMpa);
                }
            }
        }
    }

    private static void printField(char[][] field, char[] topOfMap) {
        int coordX = 1;
        int coordXS = 0;
        int coordY = 1;
        for (int j = 0; j < FIELD_SIZE; ++j) {
            if (j == 0) {
                System.out.print("███ ");
            }
            System.out.print(topOfMap[coordXS++]);
            System.out.print(" ");
        }
        System.out.println();

        for (int j = 0; j < FIELD_SIZE; ++j) {
            if (j == 0) {
                System.out.print("███ ");
            }
            System.out.print(coordX++);
            System.out.print(" ");
        }
        System.out.println();

        for (int i = 0; i < FIELD_SIZE; ++i) {
            if (i < 9) {
                System.out.print(coordY++ + " | ");
            } else {
                System.out.print(coordY++ + "| ");
            }
            for (int j = 0; j < FIELD_SIZE; ++j) {
                if (field[i][j] == 0) {
                    System.out.print("W ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println("|");

        }
    }

}