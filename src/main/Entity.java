package main;

import render.RenderObject;
import world.Tickable;
import world.Ticker;

/**
 * Created by Adam Urish on 2/7/16.
 */
public abstract class Entity extends Tickable
{
    private int posX;
    private int posY;
    private RenderObject renderObject;
    public Entity(Ticker ticker)
    {
        super(ticker);
    }
    public int getPosX()
    {
        return posX;
    }
    public void setPosX(int posX)
    {
        this.posX = posX;
        renderObject.setX(posX);
    }
    public int getPosY()
    {
        return posY;
    }
    public void setPosY(int posY)
    {
        this.posY = posY;
        renderObject.setY(posY);
    }
    public void move(int x, int y)
    {
        this.setPosX(getPosX()+x);
        renderObject.setX(renderObject.getPosX()+x);
        this.setPosY(getPosY()+y);
        renderObject.setY(renderObject.getPosY()+y);
    }
    @Override
    public abstract void tick();
}
