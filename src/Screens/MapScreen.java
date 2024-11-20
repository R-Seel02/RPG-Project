package Screens;

import Engine.*;
import GameObject.Sprite;
import SpriteFont.SpriteFont;
import java.awt.*;


public class MapScreen extends Screen {

    protected SpriteFont returnToGame;
    protected Sprite background;
    protected KeyLocker keyLocker = new KeyLocker();
   // protected PlayLevelScreen playLevelScreen;
  
    public  MapScreen() {
        //this.playLevelScreen = playLevelScreen;
       // this.player = player;
        initialize();
    }

    @Override
    public void initialize() {
        
        background = new Sprite(ImageLoader.load("NewInventoryScreen.png"));
        
    }
 

    @Override
    public void update() {

        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }
        if (Keyboard.isKeyUp(Key.ESC)) {
            keyLocker.unlockKey(Key.ESC);
        }
        if (Keyboard.isKeyUp(Key.M)) {
            keyLocker.unlockKey(Key.M);
        }

    }


    @Override
    public void draw(GraphicsHandler graphicsHandler) {

        background.draw(graphicsHandler);
   
    }

}