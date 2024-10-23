package Screens;

import Engine.GraphicsHandler;
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

    //quest stuff
    protected SpriteFont questBird;
    protected SpriteFont questFarmer;
    protected SpriteFont questWoman;
    protected SpriteFont questOldGuy;

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
        flagManager.addFlag("hasQuest", false);
        flagManager.addFlag("hasQuestBird", false);
        flagManager.addFlag("hasCompletedQuestBird", false);

        flagManager.addFlag("hasTalkedToChickenRed", false);
        flagManager.addFlag("hasTalkedToChickenGreen", false);
        flagManager.addFlag("hasTalkedToChickenYellow", false);
        flagManager.addFlag("hasTalkedToChickenBlue", false);
        flagManager.addFlag("hasTalkedToChickenOrange", false);
        flagManager.addFlag("hasQuestFarmer", false);
        flagManager.addFlag("hasCompletedQuestFarmer", false);

        flagManager.addFlag("hasQuestWoman", false);
        flagManager.addFlag("hasCompletedQuestWoman", false);
        flagManager.addFlag("hasBottle", false);
        flagManager.addFlag("hasWaterTome", false);
        flagManager.addFlag("hasAnchor", false);

        flagManager.addFlag("hasQuestOldGuy", false);
        flagManager.addFlag("hasCompletedQuestOldGuy", false);
        flagManager.addFlag("hasKilledSkeleton", false);


        
        
        // define/setup map
        map = new TestMap();
        map.setFlagManager(flagManager);

        // setup player
        player = new Cat(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
        player.setMap(map);
        playLevelScreenState = PlayLevelScreenState.RUNNING;
        player.setFacingDirection(Direction.LEFT);

        map.setPlayer(player);

        questBird = new SpriteFont("Retrieve the axe for the bird", 1000, 75, "Arial", 0, Color.white);
        questBird.setOutlineColor(Color.black);
        questBird.setOutlineThickness(3);

        questFarmer = new SpriteFont("Find the Farmer's Chickens", 1000, 75, "Arial", 0, Color.white);
        questFarmer.setOutlineColor(Color.black);
        questFarmer.setOutlineThickness(3);
        
        questWoman = new SpriteFont("Check the fountain for the woman.", 900, 75, "Arial", 0, Color.white);
        questWoman.setOutlineColor(Color.black);
        questWoman.setOutlineThickness(3);

        questOldGuy = new SpriteFont("Kill the skeleton in the forest.", 950, 75, "Arial", 0, Color.white);
        questOldGuy.setOutlineColor(Color.black);
        questOldGuy.setOutlineThickness(3);

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
        if (map.getFlagManager().isFlagSet("hasQuestBird")) {
            questBird.setFontSize(30);
        }
        if (map.getFlagManager().isFlagSet("hasCompletedQuestBird")) {
            questBird.setFontSize(0);
        }
        if (map.getFlagManager().isFlagSet("hasQuestFarmer")) {
            questFarmer.setFontSize(30);
        }
        if (map.getFlagManager().isFlagSet("hasCompletedQuestFarmer")) {
            questFarmer.setFontSize(0);
        }
        if (map.getFlagManager().isFlagSet("hasQuestWoman")) {
            questWoman.setFontSize(30);
        }
        if (map.getFlagManager().isFlagSet("hasCompletedQuestWoman")) {
            questWoman.setFontSize(0);
        }
        if (map.getFlagManager().isFlagSet("hasQuestOldGuy")) {
            questOldGuy.setFontSize(30);
        }
        if (map.getFlagManager().isFlagSet("hasCompletedQuestOldGuy")) {
            questOldGuy.setFontSize(0);
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
                questBird.draw(graphicsHandler);
                questFarmer.draw(graphicsHandler);
                questWoman.draw(graphicsHandler);
                questOldGuy.draw(graphicsHandler);
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
    }

    // This enum represents the different states this screen can be in
    private enum PlayLevelScreenState {
        // add shopping
        RUNNING, LEVEL_COMPLETED, FIGHTING, SHOPPING
    }
}
