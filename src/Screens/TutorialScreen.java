package Screens;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;

import java.awt.*;

// This class is for the credits screen
public class TutorialScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Map background;
    protected KeyLocker keyLocker = new KeyLocker();
    protected SpriteFont howToMove, howToTextBox, howToInteract, howToInventory, howToMap;
    protected SpriteFont returnInstructionsLabel;

    public TutorialScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    @Override
    public void initialize() {
        // setup graphics on screen (background map, spritefont text)
        background = new TitleScreenMap();
        background.setAdjustCamera(false);
        howToMove = new SpriteFont("You can move using WASD.", 100, 150, "Book Antiqua", 30, Color.white);
        howToMove.setOutlineColor(Color.black);
        howToMove.setOutlineThickness(3);
        howToTextBox = new SpriteFont("Navigate menus with W and S. Select options in combat with A and D.", 100, 200, "Book Antiqua", 30, Color.white);
        howToTextBox.setOutlineColor(Color.black);
        howToTextBox.setOutlineThickness(3);
        howToInteract = new SpriteFont("Select options in menus, interact with NPCs, and pick up items using E.", 100, 250, "Book Antiqua", 30, Color.white);
        howToInteract.setOutlineColor(Color.black);
        howToInteract.setOutlineThickness(3);
        howToInventory = new SpriteFont("Open and close your inventory using I.", 100, 300, "Book Antiqua", 30, Color.white);
        howToInventory.setOutlineColor(Color.black);
        howToInventory.setOutlineThickness(3);
        howToMap = new SpriteFont("Open and close your map using M.", 100, 350, "Book Antiqua", 30, Color.white);
        howToMap.setOutlineColor(Color.black);
        howToMap.setOutlineThickness(3);
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
        howToInteract.draw(graphicsHandler);
        howToMove.draw(graphicsHandler);
        howToTextBox.draw(graphicsHandler);
        howToInventory.draw(graphicsHandler);
        howToMap.draw(graphicsHandler);
        returnInstructionsLabel.draw(graphicsHandler);
    }
}
