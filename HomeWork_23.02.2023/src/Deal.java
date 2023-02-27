import java.util.Random;
import java.util.Scanner;

public class Deal {
    public static void main(String[] args) {

        Errors errors = new Errors();
        errors.errorsLogic();

        DeckTools deckTool = new DeckTools();

        //Deck initialization
        deckTool.deckInitialization();

        //Deck shuffling
        deckTool.deckShuffling();

        //The shuffled deck is displayed
        deckTool.theShuffledDeckIsDisplayed();
    }

}