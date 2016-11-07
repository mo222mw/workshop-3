package view;

public interface IView
{
    enum Options { NEW_GAME, STAND, HIT, QUIT }

    void DisplayWelcomeMessage();
    Options GetInput();
    void DisplayCard(model.Card a_card);
    void DisplayPlayerHand(Iterable<model.Card> a_hand, int a_score);
    void DisplayDealerHand(Iterable<model.Card> a_hand, int a_score);
    void DisplayGameOver(boolean a_dealerIsWinner);
}