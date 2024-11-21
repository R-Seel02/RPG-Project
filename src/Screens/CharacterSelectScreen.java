package Screens;

import Engine.GraphicsHandler;
import Engine.ImageLoader;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;
import GameObject.Sprite;
import GameObject.SpriteSheet;
import Level.Player;
import SpriteFont.SpriteFont;
import Game.ScreenCoordinator;

import java.awt.Color;

public class CharacterSelectScreen extends Screen {
    protected SpriteFont character1;
    protected SpriteFont character2;
    protected SpriteFont character3;

    protected SpriteFont character1Desc;
    protected SpriteFont character2Desc;
    protected SpriteFont character3Desc;

    protected Sprite background;
    protected Sprite assassin;
    protected Sprite knight;
    protected Sprite mage;
    protected KeyLocker keyLocker = new KeyLocker();
    protected int currentMenuItemHovered = 0;
    protected int menuItemSelected = -1;
    protected int keyPressTimer = 20;
    protected ScreenCoordinator screenCoordinator;

    public CharacterSelectScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
        initialize();
    }

    @Override
    public void initialize() {
        background = new Sprite(ImageLoader.load("CharacterSelectScreen.png"));


        assassin = new Sprite(new SpriteSheet(ImageLoader.load("Assassin.png"), 24, 24).getSprite(0,0));
        assassin.setX(110);
        assassin.setY(250);
        assassin.setScale(10);

        knight = new Sprite(new SpriteSheet(ImageLoader.load("Knight.png"), 24, 24).getSprite(0,0));
        knight.setX(575);
        knight.setY(250);
        knight.setScale(10);

        mage = new Sprite(new SpriteSheet(ImageLoader.load("Mage.png"), 24, 24).getSprite(0,0));
        mage.setX(1050);
        mage.setY(250);
        mage.setScale(10);


        character1 = new SpriteFont("Assassin", 150, 600, "Arial", 40, Color.white);
        character2 = new SpriteFont("Warrior", 625, 600, "Arial", 40, Color.white);
        character3 = new SpriteFont("Mage", 1100, 600, "Arial", 40, Color.white);

        character1Desc = new SpriteFont("(average crit % and hp)", 125, 650, "Arial", 20, Color.white);
        character2Desc = new SpriteFont("(low crit %, high hp)", 600, 650, "Arial", 20, Color.white);
        character3Desc = new SpriteFont("(high crit %, low hp)", 1075, 650, "Arial", 20, Color.white);

    }

    @Override
    public void update() {
        if (Keyboard.isKeyDown(Key.D) && keyPressTimer == 0) {
            keyPressTimer = 20;
            currentMenuItemHovered++;
        } else if (Keyboard.isKeyDown(Key.A) && keyPressTimer == 0) {
            keyPressTimer = 20;
            currentMenuItemHovered--;
        }
        else {
            if (keyPressTimer > 0) {
                keyPressTimer--;
            }
        }

        if (currentMenuItemHovered > 2) {
            currentMenuItemHovered = 0;
        } else if (currentMenuItemHovered < 0) {
            currentMenuItemHovered = 2;
        }

        if (currentMenuItemHovered == 0) {
            character1.setColor(Color.yellow);
            character1Desc.setColor(Color.yellow);
            character2.setColor(Color.white);
            character2Desc.setColor(Color.white);
            character3.setColor(Color.white);
            character3Desc.setColor(Color.white);
        } 
        else if (currentMenuItemHovered == 1) {
            character1.setColor(Color.white);
            character1Desc.setColor(Color.white);
            character2.setColor(Color.yellow);
            character2Desc.setColor(Color.yellow);
            character3.setColor(Color.white);
            character3Desc.setColor(Color.white);
        }
        else if (currentMenuItemHovered == 2) {
            character1.setColor(Color.white);
            character1Desc.setColor(Color.white);
            character2.setColor(Color.white);
            character2Desc.setColor(Color.white);
            character3.setColor(Color.yellow);
            character3Desc.setColor(Color.yellow);
        }

        if (Keyboard.isKeyUp(Key.E)) {
            keyLocker.unlockKey(Key.E);
        }
        if (!keyLocker.isKeyLocked(Key.E) && Keyboard.isKeyDown(Key.E) && keyPressTimer == 0) {
            System.out.println("here?");
            keyPressTimer = 25;
            menuItemSelected = currentMenuItemHovered;
            screenCoordinator.setGameState(GameState.LEVEL, menuItemSelected);
            
        }
        else {
            if (keyPressTimer > 0) {
                keyPressTimer--;
            }
        }
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        assassin.draw(graphicsHandler);
        knight.draw(graphicsHandler);
        mage.draw(graphicsHandler);
        character1.draw(graphicsHandler);
        character2.draw(graphicsHandler);
        character3.draw(graphicsHandler);
        character1Desc.draw(graphicsHandler);
        character2Desc.draw(graphicsHandler);
        character3Desc.draw(graphicsHandler);
        
    }

}