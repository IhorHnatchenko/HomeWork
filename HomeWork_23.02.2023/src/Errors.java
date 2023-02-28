import java.util.Scanner;

public class Errors {


    final Scanner sc = new Scanner(System.in);

    public int errorsLogic() {

        DeckTools deckTool = new DeckTools();

        int players;
        while (true) {
            System.out.print("Enter the number of players: ");
            if (sc.hasNextInt()) {
                players = sc.nextInt();
                if (deckTool.getCardsForPlayer() * players <= deckTool.getNumberOfCards()) {
                    break;
                } else {
                    if (players == 0) {
                        System.out.println("The game has been terminated.");
                        break;
                    } else if (players < 0) {
                        System.out.println("The number of players cannot be less than 0");
                    } else {
                        System.out.println("Too many players!");
                    }
                }
            } else {
                System.out.println("You have not entered a number, or your number is too large!");
            }
        }

        sc.close();
        return players;
    }
}