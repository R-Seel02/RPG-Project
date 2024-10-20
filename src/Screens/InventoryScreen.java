package Screens;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import GameObject.Sprite;
import GameObject.SpriteSheet;
import Level.Map;
import Level.PickableObject;
import Level.Player;
import Maps.FightMap;
import Maps.TitleScreenMap;
import Players.Cat;
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
    protected Sprite item1;
    protected Sprite item2;
    protected Sprite item3;
    protected Sprite item4;
    protected Sprite item5;
    protected Sprite item6;
    protected Sprite item7;
    protected Sprite item8;
    protected Sprite item9;
    protected Sprite item10;
    protected Sprite item11;
    protected Sprite item12;
    protected Sprite item13;
    protected Sprite item14;
    protected Sprite item15;

    public InventoryScreen(PlayLevelScreen playLevelScreen, PickableObject pickableObject) {
        this.playLevelScreen = playLevelScreen;
        this.pickableObject = pickableObject;
        initialize();
    }

    @Override
    public void initialize() {
        background = new Sprite(ImageLoader.load("InventoryScreen.png"));
        if (isInInventoryList("0", inventoryList)) {
            item1 = new Sprite(ImageLoader.load("Rock.png"), 14, 17);
        }
        if (isInInventoryList("1", inventoryList)) {
            item2 = new Sprite(ImageLoader.load("Rock.png"), 14, 17);
        }
        if (isInInventoryList("2", inventoryList)) {
            item3 = new Sprite(ImageLoader.load("Rock.png"), 14, 17);
        }
        if (isInInventoryList("3", inventoryList)) {
            item4 = new Sprite(ImageLoader.load("Rock.png"), 14, 17);
        }
        if (isInInventoryList("4", inventoryList)) {
            item5 = new Sprite(ImageLoader.load("Rock.png"), 14, 17);
        }
        if (isInInventoryList("5", inventoryList)) {
            item6 = new Sprite(ImageLoader.load("Rock.png"), 14, 17);
        }
        if (isInInventoryList("6", inventoryList)) {
            item7 = new Sprite(ImageLoader.load("Rock.png"), 14, 17);
        }
        if (isInInventoryList("7", inventoryList)) {
            item8 = new Sprite(ImageLoader.load("Rock.png"), 14, 17);
        }
        if (isInInventoryList("8", inventoryList)) {
            item9 = new Sprite(ImageLoader.load("Rock.png"), 14, 17);
        }
        if (isInInventoryList("9", inventoryList)) {
            item10 = new Sprite(ImageLoader.load("Rock.png"), 14, 17);
        }
        if (isInInventoryList("10", inventoryList)) {
            item11 = new Sprite(ImageLoader.load("Rock.png"), 14, 17);
        }
        if (isInInventoryList("11", inventoryList)) {
            item12 = new Sprite(ImageLoader.load("Rock.png"), 14, 17);
        }
        if (isInInventoryList("12", inventoryList)) {
            item13 = new Sprite(ImageLoader.load("Rock.png"), 14, 17);
        }
        if (isInInventoryList("13", inventoryList)) {
            item14 = new Sprite(ImageLoader.load("Rock.png"), 14, 17);
        }
        if (isInInventoryList("14", inventoryList)) {
            item15 = new Sprite(ImageLoader.load("Rock.png"), 14, 17);
        }

        
        returnToGame = new SpriteFont("Leave?", 136, 580, "Arial", 40, Color.white);
        keyPressTimer = 0;
        keyLocker.lockKey(Key.SPACE);
    }
    private boolean isInInventoryList(String item, PickableObject[] inventoryList) {
        for (PickableObject inventoryItem : inventoryList) {
            if (inventoryItem != null && inventoryItem.equals(item)) {
                return true;
            }
        }
        return false;
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

        // if space is pressed, reset level. if escape is pressed, go back to main menu
        if (Keyboard.isKeyDown(Key.SPACE) && !keyLocker.isKeyLocked(Key.SPACE)) {
            playLevelScreen.resetLevel();
        } else if (Keyboard.isKeyDown(Key.ESC) && !keyLocker.isKeyLocked(Key.ESC)) {
            playLevelScreen.goBackToMenu();
        }
    }
    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        item1.draw(graphicsHandler);
        item2.draw(graphicsHandler);
        item3.draw(graphicsHandler);
        item4.draw(graphicsHandler);
        item5.draw(graphicsHandler);
        item6.draw(graphicsHandler);
        item7.draw(graphicsHandler);
        item8.draw(graphicsHandler);
        item9.draw(graphicsHandler);
        item10.draw(graphicsHandler);
        item11.draw(graphicsHandler);
        item12.draw(graphicsHandler);
        item13.draw(graphicsHandler);
        item14.draw(graphicsHandler);
        item15.draw(graphicsHandler);

        background.draw(graphicsHandler);
        returnToGame.draw(graphicsHandler);
        graphicsHandler.drawFilledRectangle(pointerLocationX, pointerLocationY, 25, 25, Color.yellow);
    }

    




}