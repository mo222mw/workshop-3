package model.rules;

import model.Deck;
import model.Dealer;
import model.Player;

class InternationalNewGameStrategy implements INewGameStrategy {

    public boolean NewGame(Dealer a_dealer, Player a_player)
    {

        a_dealer.DealCard(a_player, true);
        a_dealer.DealCard(a_dealer, true);
        a_dealer.DealCard(a_player, true);

        /*
            Card c;

            c = a_deck.GetCard();
            c.Show(true);
            a_player.GiveCard(c);

            c = a_deck.GetCard();
            c.Show(true);
            a_dealer.GiveCard(c);

            c = a_deck.GetCard();
            c.Show(true);
            a_player.GiveCard(c);
        */

        return true;
    }
}