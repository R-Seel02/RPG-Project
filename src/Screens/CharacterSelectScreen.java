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
    protected KeyLocker keyLocker = new KeyLocker();
    protected int currentMenuItemHovered = 0;
    protected int menuItemSelected = -1;
    protected int keyPressTimer;
    protected ScreenCoordinator screenCoordinator;

    public CharacterSelectScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
        initialize();
    }

    @Override
    public void initialize() {
        character1 = new SpriteFont("Assassin?", 200, 400, "Arial", 40, Color.white);
        character2 = new SpriteFont("Warrior?", 500, 400, "Arial", 40, Color.white);
        character3 = new SpriteFont("Mystery Character?", 800, 400, "Arial", 40, Color.white);
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
            character2.setColor(Color.white);
            character3.setColor(Color.white);
        } 
        else if (currentMenuItemHovered == 1) {
            character1.setColor(Color.white);
            character2.setColor(Color.yellow);
            character3.setColor(Color.white);
        }
        else if (currentMenuItemHovered == 2) {
            character1.setColor(Color.white);
            character2.setColor(Color.white);
            character3.setColor(Color.yellow);
        }

        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }
        if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE) && keyPressTimer == 0) {
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
        character1.draw(graphicsHandler);
        character2.draw(graphicsHandler);
        character3.draw(graphicsHandler);
    }

}