package Screens;

import Engine.*;
import GameObject.Sprite;
import Level.PickableObject;
import Level.Player;
import Players.Knight;
import SpriteFont.SpriteFont;
import java.awt.*;


public class InventoryScreen extends Screen {

    protected SpriteFont returnToGame;
    protected Sprite background;
    protected SpriteFont itemName;
    protected SpriteFont slotNumber;
    protected KeyLocker keyLocker = new KeyLocker();
    protected PlayLevelScreen playLevelScreen;
    protected Player player;
    protected int pointerLocationX;
    protected int pointerLocationY;
    protected int menuItemSelected = -1;
    protected int currentMenuItemHovered = 0;
    protected  int keyPressTimer;
    protected PickableObject pickableObject;
    protected PickableObject [] inventoryList;
  
    public InventoryScreen(PlayLevelScreen playLevelScreen, Knight player) {
        this.playLevelScreen = playLevelScreen;
        this.player = player;
        initialize();
    }

    @Override
    public void initialize() {
        
        
        background = new Sprite(ImageLoader.load("InventoryScreen.png"));
       

        
        returnToGame = new SpriteFont("", 136, 680, "Arial", 40, Color.white);
        keyPressTimer = 0;
        keyLocker.lockKey(Key.SPACE);
    }
 

    @Override
    public void update() {

        if (currentMenuItemHovered >= 1 ) {
            currentMenuItemHovered = 0;
        } else if (currentMenuItemHovered < 0) {
            currentMenuItemHovered = 3;
        }

        if (currentMenuItemHovered == 0) {
            returnToGame.setColor(Color.yellow);
            pointerLocationX = 136;
            pointerLocationY = 580;
        } 
        else{
            returnToGame.setColor(Color.white);
        }

        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }
        if (Keyboard.isKeyUp(Key.ESC)) {
            keyLocker.unlockKey(Key.ESC);
        }
        if (Keyboard.isKeyUp(Key.I)) {
            keyLocker.unlockKey(Key.I);
        }
    }
    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        


        background.draw(graphicsHandler);
        PickableObject[] inventoryList = player.getInventoryList(); 

        //logic to see if the inventory list is filled with valid pickableObject
        for (int i = 0; i < inventoryList.length; i++) {
            if (inventoryList[i] != null) {
                
                Sprite itemSprite = new Sprite(ImageLoader.load("Rock.png"), 210 + (i * 200), 68); // Adjust position for each item
                itemSprite.draw(graphicsHandler);
            }
        }
        returnToGame.draw(graphicsHandler);
        graphicsHandler.drawFilledRectangle(pointerLocationX, pointerLocationY, 25, 25, Color.yellow);
    }

    




}