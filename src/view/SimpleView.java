package view;

import java.util.HashMap;
import java.util.Map;

public class SimpleView implements IView
{
    private final Map<Integer, Options> char2Option = new HashMap<Integer, Options>()
    {{
        put((int) 'p', Options.NEW_GAME);
        put((int) 'h', Options.HIT);
        put((int) 's', Options.STAND);
        put((int) 'q', Options.QUIT);
    }};

    public void DisplayWelcomeMessage()
    {
      for(int i = 0; i < 50; i++) {System.out.print("\n");};
      System.out.println("Hello Black Jack World");
      System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
    }

    public Options GetInput()
    {
        try
        {
            int c = System.in.read();
            while (c == '\r' || c =='\n')
                c = System.in.read();

            return char2Option.get(c);
        } catch (java.io.IOException e) {
            System.out.println("" + e);
        return null;
      }
    }

    public void DisplayCard(model.Card a_card)
    {
        System.out.println("" + a_card.GetValue() + " of " + a_card.GetColor());
    }

    public void DisplayPlayerHand(Iterable<model.Card> a_hand, int a_score)
    {
        DisplayHand("Player", a_hand, a_score);
    }

    public void DisplayDealerHand(Iterable<model.Card> a_hand, int a_score)
    {
        DisplayHand("Dealer", a_hand, a_score);
    }

    private void DisplayHand(String a_name, Iterable<model.Card> a_hand, int a_score)
    {
        System.out.println(a_name + " Has: ");
        for(model.Card c : a_hand)
        {
            DisplayCard(c);
        }
        System.out.println("Score: " + a_score);
        System.out.println("");
    }

    public void DisplayGameOver(boolean a_dealerIsWinner)
    {
        System.out.println("GameOver: ");
        if (a_dealerIsWinner)
        {
            System.out.println("Dealer Won!");
        }
        else
        {
            System.out.println("You Won!");
        }

    }
}
