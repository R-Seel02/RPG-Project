package Screens;

import Engine.*;
import SpriteFont.SpriteFont;

import java.awt.*;

// This class is for the fight level screen
public class FightScreen extends Screen {
    protected SpriteFont fightMessage;
    protected SpriteFont instructions;
    protected KeyLocker keyLocker = new KeyLocker();
    protected PlayLevelScreen playLevelScreen;

    public FightScreen(PlayLevelScreen playLevelScreen) {
        this.playLevelScreen = playLevelScreen;
        initialize();
    }

    @Override
    public void initialize() {
        fightMessage = new SpriteFont("This is a placeholder fight screen.", 150, 239, "Arial", 30, Color.white);
        instructions = new SpriteFont("Press Escape to go back to the game.", 160, 279,"Arial", 20, Color.white);
        keyLocker.lockKey(Key.ESC);
    }

    @Override
    public void update() {

        if (Keyboard.isKeyUp(Key.ESC)) {
            keyLocker.unlockKey(Key.ESC);
        }

        // if escape is pressed, return to the game
        if (Keyboard.isKeyDown(Key.ESC) && !keyLocker.isKeyLocked(Key.ESC)) {
            playLevelScreen.backToGame();
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), Color.black);
        fightMessage.draw(graphicsHandler);
        instructions.draw(graphicsHandler);
    }
}
