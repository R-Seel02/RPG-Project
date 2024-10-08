package Screens;

import Engine.GraphicsHandler;
import Engine.ImageLoader;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Game.GameState;
import GameObject.Sprite;
import GameObject.SpriteSheet;
import Level.Player;
import NPCs.Bug;
import SpriteFont.SpriteFont;

import java.awt.Color;

public class ShopScreen extends Screen{

    protected PlayLevelScreen playLevelScreen;
    protected Player player;
    protected KeyLocker keyLocker = new KeyLocker();
    protected int currentMenuItemHovered = 0;
    protected int menuItemSelected = -1;
    protected SpriteFont shopkeeperMessage;
    protected SpriteFont coinCounter;
    protected SpriteFont choice1;
    protected SpriteFont choice2;
    protected SpriteFont choice3;
    protected SpriteFont returnToGame;
    protected Sprite background;
    protected Sprite shopkeeper;
    protected SpriteSheet shopkeeperSheet;
    protected int keyPressTimer;
    protected int pointerLocationX;
    protected int pointerLocationY;

    public ShopScreen(PlayLevelScreen playLevelScreen, Player player) {
        this.playLevelScreen = playLevelScreen;
        this.player = player;
        initialize();
    }

    @Override
    public void initialize() {
        background = new Sprite(ImageLoader.load("ShopBackgroundV2.png"));
        shopkeeperSheet = new SpriteSheet(ImageLoader.load("Bug.png"), 24, 15);
        shopkeeper = new Sprite(shopkeeperSheet.getSprite(0,0));
        shopkeeper.setX(325);
        shopkeeper.setY(225);
        shopkeeper.setScale(5);
        coinCounter = new SpriteFont("Coins: " + player.getCoinCount(), 700, 20, "Arial", 20, Color.white);
        coinCounter.setOutlineColor(Color.black);
        coinCounter.setOutlineThickness(2);
        shopkeeperMessage = new SpriteFont("", 220, 100, "Arial", 30, Color.white);
        choice1 = new SpriteFont("-1 coin", 50, 100, "Arial", 25, Color.white);
        choice2 = new SpriteFont("-2 coins", 50, 225, "Arial", 25, Color.white);
        choice3 = new SpriteFont("-3 coins", 50, 325, "Arial", 25, Color.white);
        returnToGame = new SpriteFont("Leave?", 50, 450, "Arial", 25, Color.white);
        keyPressTimer = 0;
        keyLocker.lockKey(Key.SPACE);
    }

    @Override
    public void update() {
        if (Keyboard.isKeyDown(Key.DOWN) && keyPressTimer == 0) {
            keyPressTimer = 20;
            currentMenuItemHovered++;
        } else if (Keyboard.isKeyDown(Key.UP) && keyPressTimer == 0) {
            keyPressTimer = 20;
            currentMenuItemHovered--;
        }
        else {
            if (keyPressTimer > 0) {
                keyPressTimer--;
            }
        }

        if (currentMenuItemHovered > 3) {
            currentMenuItemHovered = 0;
        } else if (currentMenuItemHovered < 0) {
            currentMenuItemHovered = 3;
        }

        if (currentMenuItemHovered == 0) {
            choice1.setColor(Color.yellow);
            choice2.setColor(Color.white);
            choice3.setColor(Color.white);
            returnToGame.setColor(Color.white);
            pointerLocationX = 15;
            pointerLocationY = 100;
        } 
        else if (currentMenuItemHovered == 1) {
            choice1.setColor(Color.white);
            choice2.setColor(Color.yellow);
            choice3.setColor(Color.white);
            returnToGame.setColor(Color.white);
            pointerLocationX = 15;
            pointerLocationY = 225;
        }
        else if (currentMenuItemHovered == 2) {
            choice1.setColor(Color.white);
            choice2.setColor(Color.white);
            choice3.setColor(Color.yellow);
            returnToGame.setColor(Color.white);
            pointerLocationX = 15;
            pointerLocationY = 325;
        }
        else if (currentMenuItemHovered == 3) {
            choice1.setColor(Color.white);
            choice2.setColor(Color.white);
            choice3.setColor(Color.white);
            returnToGame.setColor(Color.yellow);
            pointerLocationX = 15;
            pointerLocationY = 450;
        }

        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }
        if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE) && keyPressTimer == 0) {
            keyPressTimer = 25;
            menuItemSelected = currentMenuItemHovered;
            if (menuItemSelected == 0) {
                if(player.getCoinCount() >= 1){
                    player.setCoinCount(player.getCoinCount() - 1);
                    shopkeeperMessage.setText("Thanks for the coins pal.");
                    coinCounter.setText("Coins: " + player.getCoinCount());
                }
                else{
                    shopkeeperMessage.setText("What do I look like, a charity?");
                }
            } else if (menuItemSelected == 1) {
                if(player.getCoinCount() >= 2){
                    player.setCoinCount(player.getCoinCount() - 2);
                    shopkeeperMessage.setText("Thanks for the coins pal.");
                    coinCounter.setText("Coins: " + player.getCoinCount());
                }
                else{
                    shopkeeperMessage.setText("What do I look like, a charity?");
                } 
            }
            else if (menuItemSelected == 2) {
                if(player.getCoinCount() >= 3){
                    player.setCoinCount(player.getCoinCount() - 3);
                    shopkeeperMessage.setText("Thanks for the coins pal.");
                    coinCounter.setText("Coins: " + player.getCoinCount());
                }
                else{
                    shopkeeperMessage.setText("What do I look like, a charity?");
                } 
            }
            if (menuItemSelected == 3) {
                shopkeeperMessage.setText("");
                playLevelScreen.backToGame();
            }
        }
        else {
            if (keyPressTimer > 0) {
                keyPressTimer--;
            }
        }
    }


    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        coinCounter.setText("Coins: " + player.getCoinCount());
        background.draw(graphicsHandler);
        shopkeeper.draw(graphicsHandler);
        choice1.draw(graphicsHandler);
        choice2.draw(graphicsHandler);
        choice3.draw(graphicsHandler);
        shopkeeperMessage.draw(graphicsHandler);
        coinCounter.draw(graphicsHandler);
        returnToGame.draw(graphicsHandler);
        graphicsHandler.drawFilledRectangle(pointerLocationX, pointerLocationY, 20, 20, Color.yellow);
    }
    
}
