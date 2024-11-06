package Screens;

import Engine.GraphicsHandler;
import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.*;
import Maps.SnowMap;
import Players.Mage;
import SpriteFont.SpriteFont;
import Utils.Direction;
import java.awt.Color;

// This class is for when the RPG game is actually being played
public class SnowLevelScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Map map;
    protected Player player;
    protected PlayLevelScreenState snowLevelScreenState;
    protected WinScreen winScreen;
    protected ShopScreen shopScreen;
    protected FightScreen fightScreen;
    protected FlagManager flagManager;
    protected SpriteFont coinCounter;
    protected PlayLevelScreen playLevelScreen;
    protected SnowLevelScreen snowBiome;


    //quest stuff
    protected SpriteFont quest1;

    public SnowLevelScreen(PlayLevelScreen playLevelScreen, Player player) {
        this.playLevelScreen = playLevelScreen;
        this.player = player;
        initialize();
    }

    public void initialize() {
        // setup state
        flagManager = new FlagManager();

        
        // define/setup map
        map = new SnowMap();
        map.setFlagManager(flagManager);
        flagManager.addFlag("atStartBiome", false);

        // setup player
        player = new Mage(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
        player.setMap(map);
        snowLevelScreenState = PlayLevelScreenState.RUNNING;
        player.setFacingDirection(Direction.LEFT);

        map.setPlayer(player);

        // set up coin counter text
        coinCounter = new SpriteFont("Coins: " + player.getCoinCount(), 1200, 20, "Arial", 40, Color.white);
        coinCounter.setOutlineColor(Color.black);
        coinCounter.setOutlineThickness(2);

        

        // let pieces of map know which button to listen for as the "interact" button
        map.getTextbox().setInteractKey(player.getInteractKey());

        // preloads all scripts ahead of time rather than loading them dynamically
        // both are supported, however preloading is recommended
        map.preloadScripts();

        // playLevelScreen = new PlayLevelScreen(screenCoordinator);


        // shop screen

        //quest stuff
        // quest1 = new SpriteFont("Retrieve the axe", 800, 75, "Arial", 30, Color.white);
        // quest1.setOutlineColor(Color.black);
        // quest1.setOutlineThickness(3);
        playLevelScreen = new PlayLevelScreen(screenCoordinator);

    }

    public void update() {
        // based on screen state, perform specific actions
        switch (snowLevelScreenState) {
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
            case START:
                playLevelScreen.update();
                break;
        }

        if (map.getFlagManager().isFlagSet("atStartBiome")) {
            snowLevelScreenState = PlayLevelScreenState.START;
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        // based on screen state, draw appropriate graphics
        switch (snowLevelScreenState) {
            case RUNNING:
                map.draw(player, graphicsHandler);
                coinCounter.draw(graphicsHandler);
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
            case START:
                playLevelScreen.draw(graphicsHandler);
                break;
        }
    }

    public PlayLevelScreenState getPlayLevelScreenState() {
        return snowLevelScreenState;
    }


    public void resetLevel() {
        initialize();
    }

    public void goBackToMenu() {
        screenCoordinator.setGameState(GameState.MENU);
    }

    public void backToGame() {
        snowLevelScreenState = PlayLevelScreenState.RUNNING;
    }

    // This enum represents the different states this screen can be in
    private enum PlayLevelScreenState {
        // add shopping
        RUNNING, LEVEL_COMPLETED, FIGHTING, SHOPPING, START
    }
}