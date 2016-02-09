package main;

import render.AnimatedRenderObject;
import render.RenderObject;
import render.StaticRenderObject;
import util.KeyHelper;
import world.Tickable;
import world.World;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Adam Urish on 2/7/16.
 */
public class GameWrapper
{
    private static World world;
    private RenderEngine engine;
    public enum RenderObjectTypes {Static,Animated}
    public GameWrapper(RenderEngine engine)
    {
        this.engine = engine;
    }
    public World generateWorld()
    {
        if(world == null)
        {
            world = new World();
            return world;
        }
        else
        {
            return world;
        }
    }
    public static void main(String args[])
    {
        GameWrapper g = null;
        JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(300,300);
        JPanel j = new JPanel();
        j.setSize(300,300);
        j.setVisible(true);
        jf.add(j);
        jf.setVisible(true);
        RenderEngine renderEngine = null;
        try
        {
            renderEngine = new RenderEngine(j,60,new File("src/output/"));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        g = new GameWrapper(renderEngine);
        TestEntity testEntity = new TestEntity(g.generateWorld().getTicker(),20,20);
        String[] textures = {"src/textures/floor.png"};
        g.addTickable(testEntity,textures,testEntity.getPosX(),testEntity.getPosY(),RenderObjectTypes.Static,0);


    }
    public boolean addTickable(Entity entity, String filePath[], int x, int y,RenderObjectTypes renderObjectTypes,int delay)
    {
        RenderObject renderObject = null;
        if(renderObjectTypes == RenderObjectTypes.Static)
        {
            try
            {
                renderObject = new StaticRenderObject(filePath[0],x,y);
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        else if(renderObjectTypes == RenderObjectTypes.Animated)
        {
            try
            {
                renderObject = new AnimatedRenderObject(x,y,filePath,delay);
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        if(renderObject != null)
        {
            entity.bindRenderObject(renderObject);
            return true;
        }
        else
        {
            return false;
        }
    }
}
