package model.rules;

import model.Player;

public class Soft17HitStrategy implements IHitStrategy
{
    private final int g_hitLimit = 17;

    @Override
    public boolean DoHit(Player a_dealer)
    {
        boolean hasSoft17 = (a_dealer.CalcScore() == g_hitLimit) && a_dealer.HasAce();

        return a_dealer.CalcScore() < g_hitLimit || hasSoft17;
    }
}
