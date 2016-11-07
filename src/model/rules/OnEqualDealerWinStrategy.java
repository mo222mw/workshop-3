package model.rules;

import model.Player;

public class OnEqualDealerWinStrategy implements IWinStrategy
{
    @Override
    public boolean IsDealerWinner(Player a_dealer, Player a_player, int g_maxScore) {
        if (a_player.CalcScore() > g_maxScore)
        {
            return true;
        } else if (a_dealer.CalcScore() > g_maxScore) {
            return false;
        }
        return a_dealer.CalcScore() >= a_player.CalcScore();
    }
}
