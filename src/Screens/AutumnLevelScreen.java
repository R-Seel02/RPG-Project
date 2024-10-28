package Screens;

import Engine.GraphicsHandler;
import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.*;
import Maps.SnowMap;
import Players.Knight;
import SpriteFont.SpriteFont;
import Utils.Direction;
import java.awt.Color;

// This class is for when the RPG game is actually being played
public class AutumnLevelScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Map map;
    protected Knight player;
    protected PlayLevelScreenState playLevelScreenState;
    protected WinScreen winScreen;
    protected ShopScreen shopScreen;
    protected FightScreen fightScreen;
    protected FlagManager flagManager;
    protected SpriteFont coinCounter;
    protected PlayLevelScreen playLevelScreen;
    protected SnowLevelScreen snowBiome;

    //quest stuff
    protected SpriteFont quest1;

    public AutumnLevelScreen(PlayLevelScreen playLevelScreen, Knight player) {
        this.playLevelScreen = playLevelScreen;
        this.player = player;
        initialize();
    }

    public void initialize() {
        // setup state
        // flagManager = new FlagManager();

        
        // define/setup map
        map = new SnowMap();
        map.setFlagManager(flagManager);

        // setup player
        player = new Knight(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
        player.setMap(map);
        playLevelScreenState = PlayLevelScreenState.RUNNING;
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
    }

    public void draw(GraphicsHandler graphicsHandler) {
        // based on screen state, draw appropriate graphics
        switch (playLevelScreenState) {
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
            case SNOW_BIOME:
                snowBiome.draw(graphicsHandler);
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
    }

    // This enum represents the different states this screen can be in
    private enum PlayLevelScreenState {
        // add shopping
        RUNNING, LEVEL_COMPLETED, FIGHTING, SHOPPING, SNOW_BIOME
    }
}
