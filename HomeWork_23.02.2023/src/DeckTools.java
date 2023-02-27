import java.util.Random;
import java.util.Scanner;

public class DeckTools {
    Errors errors = new Errors();
    final Random random = new Random();
    Suits[] suits = Suits.values();
    Rank[] rank = Rank.values();
    final int cardsForPlayer = 5;
    final int numberOfCards = Suits.values().length * Rank.values().length; // number of cards

    public void showNumberOfCards() {
        System.out.println(numberOfCards);
    }

    String[] deck = new String[numberOfCards];

    public void deckInitialization() {
        for (int i = 0; i < Rank.values().length; i++) {
            for (int j = 0; j < Suits.values().length; j++) {
                deck[Suits.values().length * i + j] = rank[i] + " " + suits[j];
            }
        }
    }

    public void deckShuffling() {
        for (int i = 0; i < numberOfCards; i++) {
            int card = i + (random.nextInt(numberOfCards - i)); // random card in the deck
            String temp = deck[card];
            deck[card] = deck[i];
            deck[i] = temp;
        }
    }
    int players;




    public void theShuffledDeckIsDisplayed() {
        errors.setPlayers(players);
        for (int i = 0; i < errors.getPlayers() * cardsForPlayer; i++) {
            System.out.println(deck[i]);

            if (i % cardsForPlayer == cardsForPlayer - 1)
                System.out.println();
        }
    }

    public int getNumberOfCards() {
        return numberOfCards;
    }


    public int getCardsForPlayer() {
        return cardsForPlayer;
    }
}
