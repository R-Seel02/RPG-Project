package Screens;

import Engine.GraphicsHandler;
import Engine.ImageLoader;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import GameObject.Sprite;
import GameObject.SpriteSheet;
import Level.Player;
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
    protected Sprite[] shopkeepers = new Sprite[60];
    protected Sprite healthPotion;
    protected Sprite damagePotion;
    protected Sprite defensePotion;
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
        shopkeeper.setX(600);
        shopkeeper.setY(250);
        shopkeeper.setScale(10);
        coinCounter = new SpriteFont("Coins: " + player.getCoinCount(), 1200, 20, "Arial", 40, Color.white);
        coinCounter.setOutlineColor(Color.black);
        coinCounter.setOutlineThickness(2);
        shopkeeperMessage = new SpriteFont("", 500, 125, "Arial", 30, Color.white);
        choice1 = new SpriteFont("Health Potion (2 coins)", 165, 125, "Arial", 20, Color.white);
        choice2 = new SpriteFont("Damage Potion (3 coins)", 165, 300, "Arial", 20, Color.white);
        choice3 = new SpriteFont("Defense Potion (5 coins)", 165, 425, "Arial", 20, Color.white);
        returnToGame = new SpriteFont("Leave?", 50, 575, "Arial", 40, Color.white);

        // health potion
        healthPotion = new Sprite(ImageLoader.load("HealthPotion.png"));
        healthPotion.setX(75);
        healthPotion.setY(90);
        healthPotion.setScale(3);

        // defense potion
        damagePotion = new Sprite(ImageLoader.load("DamagePotion.png"));
        damagePotion.setX(75);
        damagePotion.setY(235);
        damagePotion.setScale(3);

        // damage potion
        defensePotion = new Sprite(ImageLoader.load("DefensePotion.png"));
        defensePotion.setX(75);
        defensePotion.setY(385);
        defensePotion.setScale(3);

        keyPressTimer = 0;
        keyLocker.lockKey(Key.SPACE);
    }

    @Override
    public void update() {
        
        if (Keyboard.isKeyDown(Key.S) && keyPressTimer == 0) {
            keyPressTimer = 20;
            currentMenuItemHovered++;
        } else if (Keyboard.isKeyDown(Key.W) && keyPressTimer == 0) {
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
            healthPotion.setImage(ImageLoader.load("healthPotionHovered.png"));
            damagePotion.setImage(ImageLoader.load("damagePotion.png"));
            defensePotion.setImage(ImageLoader.load("defensePotion.png"));
            returnToGame.setColor(Color.white);
        } 
        else if (currentMenuItemHovered == 1) {
            healthPotion.setImage(ImageLoader.load("healthPotion.png"));
            damagePotion.setImage(ImageLoader.load("damagePotionHovered.png"));
            defensePotion.setImage(ImageLoader.load("defensePotion.png"));
            returnToGame.setColor(Color.white);
        }
        else if (currentMenuItemHovered == 2) {
            healthPotion.setImage(ImageLoader.load("healthPotion.png"));
            damagePotion.setImage(ImageLoader.load("damagePotion.png"));
            defensePotion.setImage(ImageLoader.load("defensePotionHovered.png"));
            returnToGame.setColor(Color.white);
        }
        else if (currentMenuItemHovered == 3) {
            healthPotion.setImage(ImageLoader.load("healthPotion.png"));
            damagePotion.setImage(ImageLoader.load("damagePotion.png"));
            defensePotion.setImage(ImageLoader.load("defensePotion.png"));
            returnToGame.setColor(Color.yellow);
        }

        if (Keyboard.isKeyUp(Key.E)) {
            keyLocker.unlockKey(Key.E);
        }
        if (!keyLocker.isKeyLocked(Key.E) && Keyboard.isKeyDown(Key.E) && keyPressTimer == 0) {
            keyPressTimer = 25;
            menuItemSelected = currentMenuItemHovered;
            if (menuItemSelected == 0) {
                if(player.getCoinCount() >= 2){
                    player.setCoinCount(player.getCoinCount() - 2);
                    player.addHealthPot();
                    shopkeeperMessage.setText("Thanks for the coins pal. (+1 Health Pot)");
                    coinCounter.setText("Coins: " + player.getCoinCount());
                }
                else{
                    shopkeeperMessage.setText("What do I look like, a charity?");
                }
            } else if (menuItemSelected == 1) {
                if(player.getCoinCount() >= 3){
                    player.setCoinCount(player.getCoinCount() - 3);
                    player.addDamagePot();
                    shopkeeperMessage.setText("Thanks for the coins pal. (+1 Damage Pot)");
                    coinCounter.setText("Coins: " + player.getCoinCount());
                }
                else{
                    shopkeeperMessage.setText("What do I look like, a charity?");
                } 
            }
            else if (menuItemSelected == 2) {
                if(player.getCoinCount() >= 5){
                    player.setCoinCount(player.getCoinCount() - 5);
                    player.addDefensePot();
                    shopkeeperMessage.setText("Thanks for the coins pal. (+1 Defense Pot)");
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
        healthPotion.draw(graphicsHandler);
        damagePotion.draw(graphicsHandler);
        defensePotion.draw(graphicsHandler);
        choice1.draw(graphicsHandler);
        choice2.draw(graphicsHandler);
        choice3.draw(graphicsHandler);
        shopkeeperMessage.draw(graphicsHandler);
        coinCounter.draw(graphicsHandler);
        returnToGame.draw(graphicsHandler);
        //graphicsHandler.drawFilledRectangle(pointerLocationX, pointerLocationY, 25, 25, Color.yellow);
        graphicsHandler.drawFilledRectangleWithBorder(25, 25, 200, 25, Color.gray, Color.black, 3);
        graphicsHandler.drawFilledRectangle(25, 25, (player.getHealth() * 2), 25, new Color(190, 0, 0));
    }
    
}
