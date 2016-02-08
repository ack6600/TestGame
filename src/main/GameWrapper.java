package main;

import render.StaticRenderObject;
import util.KeyHelper;
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
        TestEntity testEntity = new TestEntity(g.generateWorld().getTicker());
        testEntity.setPosX(100);
        StaticRenderObject staticRenderObject = null;
        try
        {
            staticRenderObject = new StaticRenderObject("src/textures/floor.png",testEntity.getPosX(),testEntity.getPosY());
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        renderEngine.addObject(staticRenderObject);


    }
    public void addObject(Entity entity, String filePath, int x, int y)
    {

    }
}
