public class Deal {
    private int players = 0;
    public static void main(String[] args) {
        Deal deal = new Deal();
        Errors errors = new Errors();
        deal.players = errors.errorsLogic();


        DeckTools deckTool = new DeckTools();

        //Deck initialization
        deckTool.deckInitialization();

        //Deck shuffling
        deckTool.deckShuffling();

        //The shuffled deck is displayed
        deckTool.theShuffledDeckIsDisplayed(deal.players);
    }
}
