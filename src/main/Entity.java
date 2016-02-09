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
    public Entity(Ticker ticker, int startX, int startY)
    {
        super(ticker);
        posX = startX;
        posY = startY;
    }
    public void bindRenderObject(RenderObject renderObject)
    {
        this.renderObject = renderObject;
    }

    public int getPosX()
    {
        return posX;
    }
    public void setPosX(int posX)
    {
        this.posX = posX;
        if(renderObject != null)
        {
            renderObject.setX(posX);
        }
    }
    public int getPosY()
    {
        return posY;
    }
    public void setPosY(int posY)
    {
        this.posY = posY;
        if(renderObject!=null)
        {
            renderObject.setY(posY);
        }
    }
    public void move(int x, int y)
    {
        this.setPosX(getPosX()+x);
        this.setPosY(getPosY()+y);
        if(renderObject != null)
        {
            renderObject.setX(renderObject.getPosX() + x);
            renderObject.setY(renderObject.getPosY() + y);
        }
    }
    @Override
    public abstract void tick();
}
