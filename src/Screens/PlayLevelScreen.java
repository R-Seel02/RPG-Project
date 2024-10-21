package Screens;

import Engine.GraphicsHandler;
import Engine.ImageLoader;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;
import GameObject.Rectangle;
import Level.*;
import Maps.TestMap;
import Players.Cat;
import ScriptActions.ChangeFlagScriptAction;
import Utils.Direction;
import Utils.ImageUtils;
import Utils.Point;
import SpriteFont.SpriteFont;
import java.awt.Color;

import javax.swing.Timer;

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
    protected SpriteFont sleepMessage;
    protected KeyLocker keyLocker = new KeyLocker();
    protected Timer timer = new Timer(20, null);
    protected int i = 0;
    //protected Rectangle healthBG;
    //protected Rectangle health;

    //quest stuff
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

        flagManager.addFlag("isSleeping", false);
        flagManager.addFlag("inShop", false);
        flagManager.addFlag("hasAxe", false);
        flagManager.addFlag("HasQuest", false);
        flagManager.addFlag("hasQuest1", false);
        flagManager.addFlag("hasCompletedQuest1", false);
        
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

        // set up blank sleep message
        sleepMessage = new SpriteFont("You sleep to recover your strength.", 450, 650, "Arial", 30, Color.white);
        sleepMessage.setOutlineColor(Color.black);
        sleepMessage.setOutlineThickness(2);

        

        

        // let pieces of map know which button to listen for as the "interact" button
        map.getTextbox().setInteractKey(player.getInteractKey());

        // preloads all scripts ahead of time rather than loading them dynamically
        // both are supported, however preloading is recommended
        map.preloadScripts();

        winScreen = new WinScreen(this);
        fightScreen = new FightScreen(this, player, "Walrus.png");
        shopScreen = new ShopScreen(this, this.player);

        // shop screen

        //quest stuff
        // quest1 = new SpriteFont("Retrieve the axe", 800, 75, "Arial", 30, Color.white);
        // quest1.setOutlineColor(Color.black);
        // quest1.setOutlineThickness(3);

    }

    public void update() {
        // based on screen state, perform specific actions
        switch (playLevelScreenState) {
            // if level is "running" update player and map to keep game logic for the platformer level going
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
        if (map.getFlagManager().isFlagSet("isSleeping")) {
            playLevelScreenState = PlayLevelScreenState.SLEEPING;
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
                // health bar
                graphicsHandler.drawFilledRectangleWithBorder(25, 25, 200, 25, Color.gray, Color.black, 3);
                graphicsHandler.drawFilledRectangle(25, 25, (player.getHealth() * 2), 25, Color.red);
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
            case SLEEPING:
                if(i == 0){
                    keyLocker.lockKey(Key.E);
                    keyLocker.lockKey(Key.UP);
                    keyLocker.lockKey(Key.DOWN);
                    keyLocker.lockKey(Key.LEFT);
                    keyLocker.lockKey(Key.RIGHT);
                }

                i++;

                if(i < 230){
                    int alphaLevel = i * 2;
                    if(alphaLevel > 255){
                        alphaLevel = 255;
                    }
                    map.draw(player, graphicsHandler);
                    coinCounter.draw(graphicsHandler);
                    quest1.draw(graphicsHandler);
                    // health bar
                    graphicsHandler.drawFilledRectangleWithBorder(25, 25, 200, 25, Color.gray, Color.black, 3);
                    graphicsHandler.drawFilledRectangle(25, 25, (player.getHealth() * 2), 25, Color.red);
                    graphicsHandler.drawFilledRectangle(0, 0, 1400, 800, new Color(0, 0, 0, alphaLevel));
                    sleepMessage.draw(graphicsHandler);
                }
                else{
                    i = 0;
                    player.heal(100);
                    keyLocker.unlockKey(Key.E);
                    keyLocker.unlockKey(Key.UP);
                    keyLocker.unlockKey(Key.DOWN);
                    keyLocker.unlockKey(Key.LEFT);
                    keyLocker.unlockKey(Key.RIGHT);
                    this.backToGame();
                }
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

    public void backToGame() {
        playLevelScreenState = PlayLevelScreenState.RUNNING;
        flagManager.unsetFlag("isFighting");
        flagManager.unsetFlag("inShop");
        flagManager.unsetFlag("isSleeping");
    }

    // This enum represents the different states this screen can be in
    private enum PlayLevelScreenState {
        // add shopping
        RUNNING, LEVEL_COMPLETED, FIGHTING, SHOPPING, SLEEPING
    }
}
