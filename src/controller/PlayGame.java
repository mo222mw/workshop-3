package controller;

import model.IHandObserver;
import view.IView;
import model.Game;

public class PlayGame implements IHandObserver
{
    private Game a_game;
    private IView a_view;

    public PlayGame(Game a_game, IView a_view)
    {
        this.a_game = a_game;
        this.a_view = a_view;

        a_game.AddSubscriber(this);
    }

    public boolean Play(Game a_game, IView a_view)
    {
        a_view.DisplayWelcomeMessage();

        a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
        a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());

        if (a_game.IsGameOver())
        {
            a_view.DisplayGameOver(a_game.IsDealerWinner());
        }

        IView.Options input = a_view.GetInput();
        if(input == null)
            return true;

        switch(input)
        {
            case NEW_GAME:
                a_game.NewGame();
                break;

            case HIT:
                a_game.Hit();
                break;

            case STAND:
                a_game.Stand();
                break;

            case QUIT:
                return false;

            default:

        }
        return true;
    }

    @Override
    public void UpdateHand()
    {
        //Redraw interface:
        a_view.DisplayWelcomeMessage();
        a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
        a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());

        try{
            Thread.sleep(1500);
        }catch (InterruptedException e)
        {
            /* Optional error message:
                System.err.println("Pause was interrupted");
            */
        }
    }
}