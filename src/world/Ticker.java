package world;

import java.util.ArrayList;

/**
 * Created by Adam Urish on 2/7/16.
 */
public class Ticker implements Runnable
{
    private ArrayList<Tickable> tickList;
    public Ticker()
    {
        tickList = new ArrayList<Tickable>(0);
    }
    public void addToTickList(Tickable t)
    {
        tickList.add(t);
    }
    @Override
    public void run()
    {
        while (true) {
            for (Tickable t : tickList)
            {
                t.tick();
            }
        }

    }
}
