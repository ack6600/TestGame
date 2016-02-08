package util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Adam Urish on 2/7/16.
 */
public class KeyHelper implements KeyListener
{
    private boolean isPressed;
    private char keyToPress;
    private Runnable toRun;
    public KeyHelper(char key,Runnable toRun)
    {
        keyToPress = key;
        isPressed = false;
        this.toRun = toRun;
    }
    public boolean getButtonState()
    {
        return isPressed;
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyChar() == keyToPress)
        {
            isPressed = true;
            toRun.run();
        }

    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        if (e.getKeyChar() == keyToPress)
        {
            isPressed = false;
        }
    }
}
