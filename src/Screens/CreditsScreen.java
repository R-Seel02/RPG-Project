package Screens;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;

import java.awt.*;

// This class is for the credits screen
public class CreditsScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Map background;
    protected KeyLocker keyLocker = new KeyLocker();
    protected SpriteFont creditsLabel;
    protected SpriteFont createdByLabel;
    protected SpriteFont devLabel;
    protected SpriteFont cascadeLabel;
    protected SpriteFont returnInstructionsLabel;

    public CreditsScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    @Override
    public void initialize() {
        // setup graphics on screen (background map, spritefont text)
        background = new TitleScreenMap();
        background.setAdjustCamera(false);
        creditsLabel = new SpriteFont("Credits", 15, 7, "Book Antiqua", 30, Color.white);
        creditsLabel.setOutlineColor(Color.black);
        creditsLabel.setOutlineThickness(3);
        createdByLabel = new SpriteFont("Base game created by Alex Thimineur", 130, 121, "Book Antiqua", 20, Color.white);
        createdByLabel.setOutlineColor(Color.black);
        createdByLabel.setOutlineThickness(3);
        devLabel = new SpriteFont("The Legend of Thimineur brought to you by Team Cascade.", 130, 150, "Book Antiqua", 22, Color.white);
        devLabel.setOutlineColor(Color.black);
        devLabel.setOutlineThickness(3);
        cascadeLabel = new SpriteFont("Team Cascade is: Max Cheezic, Matther Wheeler, Ryan Seely, Mark Pfister, Pierce Conway", 130, 200, "Book Antiqua", 25, Color.white);
        cascadeLabel.setOutlineColor(Color.black);
        cascadeLabel.setOutlineThickness(3);
        returnInstructionsLabel = new SpriteFont("Press Space to return to the menu", 20, 532, "Book Antiqua", 30, Color.white);
        returnInstructionsLabel.setOutlineColor(Color.black);
        returnInstructionsLabel.setOutlineThickness(3);
        keyLocker.lockKey(Key.SPACE);
    }

    public void update() {
        background.update(null);

        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }

        // if space is pressed, go back to main menu
        if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) {
            screenCoordinator.setGameState(GameState.MENU);
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        creditsLabel.draw(graphicsHandler);
        createdByLabel.draw(graphicsHandler);
        devLabel.draw(graphicsHandler);
        cascadeLabel.draw(graphicsHandler);
        returnInstructionsLabel.draw(graphicsHandler);
    }
}
