package Screens;

import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.*;
import Maps.TestMap;
import Players.Cat;
import ScriptActions.ChangeFlagScriptAction;
import Utils.Direction;
import Utils.Point;
import SpriteFont.SpriteFont;
import java.awt.Color;

// This class is for when the RPG game is actually being played
public class PlayLevelScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Map map;
    protected Cat player;
    protected PlayLevelScreenState playLevelScreenState;
    protected WinScreen winScreen;
    protected ShopScreen shopScreen;
    protected FightScreen fightScreen;
    protected FlagManager flagManager;
    protected SpriteFont coinCounter;
    protected InventoryScreen inventoryScreen;
    protected PickableObject itemRock;
    protected KeyLocker keyLocker = new KeyLocker(); // Initialize KeyLocker for key press handling


    // quest stuff
    protected SpriteFont quest1;

    public PlayLevelScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    public void initialize() {
        // setup state
        flagManager = new FlagManager();
        flagManager.addFlag("hasLostBall", false);
        flagManager.addFlag("hasTalkedToWalrus", false);
        flagManager.addFlag("hasTalkedToDinosaur", false);
        flagManager.addFlag("hasFoundBall", false);
        flagManager.addFlag("hasTalkedToTestNPC", false);
        flagManager.addFlag("isFighting", false);
        flagManager.addFlag("hasPickedupRock", false);

        flagManager.addFlag("inShop", false);
        flagManager.addFlag("hasAxe", false);
        flagManager.addFlag("HasQuest", false);
        flagManager.addFlag("hasQuest1", false);
        flagManager.addFlag("hasCompletedQuest1", false);
        flagManager.addFlag("hasOpenedChest", false);
        flagManager.addFlag("hasOpenedChest2", false);
        flagManager.addFlag("InInventory", false);

        // define/setup map
        map = new TestMap();
        map.setFlagManager(flagManager);

        // setup player
        player = new Cat(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
        player.setMap(map);
        playLevelScreenState = PlayLevelScreenState.RUNNING;
        player.setFacingDirection(Direction.LEFT);

        map.setPlayer(player);

        quest1 = new SpriteFont("Retrieve the axe for the bird", 1000, 75, "Arial", 0, Color.white);
        quest1.setOutlineColor(Color.black);
        quest1.setOutlineThickness(3);

        // set up coin counter text
        coinCounter = new SpriteFont("Coins: " + player.getCoinCount(), 1200, 20, "Arial", 40, Color.white);
        coinCounter.setOutlineColor(Color.black);
        coinCounter.setOutlineThickness(2);

        // let pieces of map know which button to listen for as the "interact" button
        map.getTextbox().setInteractKey(player.getInteractKey());

        // preloads all scripts ahead of time rather than loading them dynamically
        // both are supported, however preloading is recommended
        map.preloadScripts();

        winScreen = new WinScreen(this);
        fightScreen = new FightScreen(this, player, "Walrus.png");
        shopScreen = new ShopScreen(this, this.player);
        inventoryScreen = new InventoryScreen(this, player);

        // shop screen

        // quest stuff
        // quest1 = new SpriteFont("Retrieve the axe", 800, 75, "Arial", 30,
        // Color.white);
        // quest1.setOutlineColor(Color.black);
        // quest1.setOutlineThickness(3);

    }

    public void update() {
        
        Object playLevelScreen;
        if (Keyboard.isKeyDown(Key.I) && !keyLocker.isKeyLocked(Key.I)) {
            if (playLevelScreenState == PlayLevelScreenState.RUNNING) {
                playLevelScreenState = PlayLevelScreenState.INVENTORY; // Switch to inventory
            } else if (playLevelScreenState == PlayLevelScreenState.INVENTORY) {
                playLevelScreenState = PlayLevelScreenState.RUNNING; // Switch back to the game
            }
            keyLocker.lockKey(Key.I); 
        }
    
        if (Keyboard.isKeyUp(Key.I)) {
            keyLocker.unlockKey(Key.I); // Unlock the key once it's released
        }

        // based on screen state, perform specific actions
        switch (playLevelScreenState) {
            // if level is "running" update player and map to keep game logic for the
            // platformer level going
            case RUNNING:
                player.update();
                map.update(player);
                coinCounter.setText("Coins: " + player.getCoinCount());
                break;
            // if level has been completed, bring up level cleared screen
            case LEVEL_COMPLETED:
                winScreen.update();
                break;
            // if the player is fighting, change the screen to a fight screen
            case FIGHTING:
                fightScreen.update();
                break;
            // if the player enters the shop, change to the shop screen
            case SHOPPING:
                shopScreen.update();
                break;
            case INVENTORY:
                inventoryScreen.update();
                break;
        }

        // if flag is set at any point during gameplay, game is "won"
        if (map.getFlagManager().isFlagSet("hasFoundBall")) {
            playLevelScreenState = PlayLevelScreenState.LEVEL_COMPLETED;
        }

        if (map.getFlagManager().isFlagSet("isFighting")) {
            playLevelScreenState = PlayLevelScreenState.FIGHTING;
        }

        if (map.getFlagManager().isFlagSet("inShop")) {
            playLevelScreenState = PlayLevelScreenState.SHOPPING;
        }
        if (map.getFlagManager().isFlagSet("hasQuest1")) {
            quest1.setFontSize(30);
        }
        if (map.getFlagManager().isFlagSet("hasCompletedQuest1")) {
            quest1.setFontSize(0);
        }
        if (map.getFlagManager().isFlagSet("InInventory")) {
            playLevelScreenState = PlayLevelScreenState.INVENTORY;
        }

        // if (map.getFlagManager().isFlagSet("")) {

        // }

    }

    public void draw(GraphicsHandler graphicsHandler) {
        // based on screen state, draw appropriate graphics
        switch (playLevelScreenState) {
            case RUNNING:
                map.draw(player, graphicsHandler);
                coinCounter.draw(graphicsHandler);
                quest1.draw(graphicsHandler);
                break;
            case LEVEL_COMPLETED:
                winScreen.draw(graphicsHandler);
                break;
            case FIGHTING:
                fightScreen.draw(graphicsHandler);
                break;
            case SHOPPING:
                shopScreen.draw(graphicsHandler);
                break;
            case INVENTORY:
                inventoryScreen.draw(graphicsHandler);
                break;
        }
    }

    public PlayLevelScreenState getPlayLevelScreenState() {
        return playLevelScreenState;
    }

    public void resetLevel() {
        initialize();
    }

    public void goBackToMenu() {
        screenCoordinator.setGameState(GameState.MENU);
    }

    public void goToInventory() {
        screenCoordinator.setGameState(GameState.INVENTORY);
    }

    public void backToGame() {
        playLevelScreenState = PlayLevelScreenState.RUNNING;
        flagManager.unsetFlag("isFighting");
        flagManager.unsetFlag("inShop");
        flagManager.unsetFlag("InInventory");
    }

    // This enum represents the different states this screen can be in
    private enum PlayLevelScreenState {
        // add shopping & inventory
        RUNNING, LEVEL_COMPLETED, FIGHTING, SHOPPING, INVENTORY
    }
}
