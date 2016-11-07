package view;

import java.util.HashMap;
import java.util.Map;

public class SwedishView implements IView
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

        System.out.println("Hej Black Jack Världen");
        System.out.println("----------------------");
        System.out.println("Skriv 'p' för att Spela, 'h' för nytt kort, 's' för att stanna 'q' för att avsluta\n");
    }
        
    public Options GetInput()
    {
        try
        {
            int c = System.in.read();
            while (c == '\r' || c =='\n')
                c = System.in.read();

            return char2Option.get(c);
        } catch (java.io.IOException e)
        {
            System.out.println("" + e);
            return null;
        }
    }
        
    public void DisplayCard(model.Card a_card)
    {
        if (a_card.GetColor() == model.Card.Color.Hidden)
        {
            System.out.println("Dolt Kort");
        }
        else
        {
            String colors[] =
                { "Hjärter", "Spader", "Ruter", "Klöver" };
            String values[] =
                { "två", "tre", "fyra", "fem", "sex", "sju", "åtta", "nio", "tio", "knekt", "dam", "kung", "ess" };
            System.out.println("" + colors[a_card.GetColor().ordinal()] + " " + values[a_card.GetValue().ordinal()]);
        }
    }
    public void DisplayPlayerHand(Iterable<model.Card> a_hand, int a_score)
    {
        DisplayHand("Spelare", a_hand, a_score);
    }
    public void DisplayDealerHand(Iterable<model.Card> a_hand, int a_score)
    {
        DisplayHand("Croupier", a_hand, a_score);
    }
    public void DisplayGameOver(boolean a_dealerIsWinner)
    {
        System.out.println("Slut: ");
        if (a_dealerIsWinner)
        {
            System.out.println("Croupiern Vann!");
        }
        else
        {
            System.out.println("Du vann!");
        }
    }

    private void DisplayHand(String a_name, Iterable<model.Card> a_hand, int a_score)
    {
        System.out.println(a_name + " Har: " + a_score);
        for(model.Card c : a_hand)
        {
            DisplayCard(c);
        }
        System.out.println("Poäng: " + a_score);
        System.out.println("");
    }
}
