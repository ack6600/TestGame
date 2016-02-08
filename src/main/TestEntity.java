package main;

import world.Ticker;

/**
 * Created by Adam Urish on 2/7/16.
 */
public class TestEntity extends Entity
{
    @Override
    public void tick()
    {

    }
    public void print(String toPrint)
    {
        System.out.println(toPrint);
    }

    public TestEntity(Ticker ticker)
    {
        super(ticker);
    }
}
