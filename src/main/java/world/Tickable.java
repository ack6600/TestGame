package world;

import main.GameWrapper;

/**
 * Created by Adam Urish on 2/7/16.
 */
public abstract class Tickable
{
    public Tickable(Ticker ticker)
    {
        ticker.addToTickList(this);

    }

    public abstract void tick();

}
