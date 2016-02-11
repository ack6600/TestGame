package world;

import main.Entity;
import main.GameWrapper;
import main.RenderEngine;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Adam Urish on 2/7/16.
 */
public class World
{
    private Ticker ticker;
    public World()
    {
        ticker = new Ticker();
        Thread tickThread = new Thread(ticker);
        tickThread.start();
    }
    public void addToTicker(Tickable t)
    {
        ticker.addToTickList(t);
    }
    public Ticker getTicker()
    {
        return ticker;
    }

}
