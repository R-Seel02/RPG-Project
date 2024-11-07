package Screens;

import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.*;
import Maps.ForestMap;
import Maps.SnowMap;
import Maps.StartingMap;
import Players.Assassin;
import Players.Knight;
import Players.Mage;
import SpriteFont.SpriteFont;
import Utils.Direction;
import java.awt.Color;
import javax.swing.Timer;

// This class is for when the RPG game is actually being played
public class PlayLevelScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Map startMap, snowMap, forestMap;
    protected Map currMap;
    protected Player player, newPlayer;
    protected PlayLevelScreenState playLevelScreenState;
    protected WinScreen winScreen;
    protected FailScreen failScreen;
    protected ShopScreen shopScreen;
    protected FightScreen fightScreen;
    // protected SnowLevelScreen snowScreen;
    protected FlagManager flagManager;
    protected SpriteFont coinCounter;
    protected InventoryScreen inventoryScreen;
    protected PickableObject itemRock;
    protected KeyLocker keyLocker = new KeyLocker();
    protected SpriteFont sleepMessage;
    protected Keyboard keyboard;

    //quest stuff
    protected SpriteFont questBird;
    protected SpriteFont questFarmer;
    protected SpriteFont questWoman;
    protected SpriteFont questOldGuy;

    //combat stuff
    protected Enemy currentEnemy;
    protected int characterChoice;

    
    protected Timer timer = new Timer(20, null);
    protected int i = 0;
    //protected Rectangle healthBG;
    //protected Rectangle health;
   


    // quest stuff
    protected SpriteFont quest1;

    public PlayLevelScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    public PlayLevelScreen(ScreenCoordinator screenCoordinator, int characterChoice) {
        this.screenCoordinator = screenCoordinator;
        this.characterChoice = characterChoice;
    }

    public void initialize() {
        // setup state
        flagManager = new FlagManager();
        flagManager.addFlag("atSnowBiome", false);
        flagManager.addFlag("atStartBiome", false);
        flagManager.addFlag("atForestBiome", false);
        flagManager.addFlag("hasTalkedToWalrus", false);
        flagManager.addFlag("hasTalkedToDinosaur", false);
        // flagManager.addFlag("hasFoundBall", false);
        flagManager.addFlag("hasTalkedToTestNPC", false);
        flagManager.addFlag("isFighting", false);
        flagManager.addFlag("hasPickedup]", false);
        flagManager.addFlag("playerDied", false);

        flagManager.addFlag("isSleeping", false);
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
        flagManager.addFlag("hasFoughtSkeleton", false);
        flagManager.addFlag("hasBeatenSeb", false);
        
        
        flagManager.addFlag("HasQuest", false);
        flagManager.addFlag("hasQuest1", false);
        flagManager.addFlag("hasCompletedQuest1", false);
        flagManager.addFlag("hasOpenedChest", false);
        flagManager.addFlag("hasOpenedChest2", false);
        flagManager.addFlag("InInventory", false);

        // define/setup map       
        startMap = new StartingMap();
        startMap.setFlagManager(flagManager);
        snowMap = new SnowMap();
        snowMap.setFlagManager(flagManager);
        forestMap = new ForestMap();
        forestMap.setFlagManager(flagManager);
        currMap = startMap;
        // setup player
        switch(characterChoice){
            case(0):
                player = new Assassin(800, 860);
                break;
            case(1):
                player = new Knight(800, 860);
                break;
            case(2):
                player = new Mage(800, 860);
                break;
            
        }
        
        // player = new Mage(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
        player.setMap(currMap);
        playLevelScreenState = PlayLevelScreenState.RUNNING;
        player.setFacingDirection(Direction.LEFT);

        currMap.setPlayer(player);

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

        // set up blank sleep message
        sleepMessage = new SpriteFont("You sleep to recover your strength.", 450, 650, "Arial", 30, Color.white);
        sleepMessage.setOutlineColor(Color.black);
        sleepMessage.setOutlineThickness(2);
        
        //initialize enemy
        currentEnemy = new Enemy("default", 1, 1, 1, "error.png");

        // let pieces of map know which button to listen for as the "interact" button
        currMap.getTextbox().setInteractKey(player.getInteractKey());

        // preloads all scripts ahead of time rather than loading them dynamically
        // both are supported, however preloading is recommended
        currMap.preloadScripts();

        winScreen = new WinScreen(this);
        fightScreen = new FightScreen(this, player, currentEnemy);
        shopScreen = new ShopScreen(this, this.player);
        inventoryScreen = new InventoryScreen(this, player);
        failScreen = new FailScreen(this);
    }

    public void update() {
        
        // Object playLevelScreen;
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
                currMap.update(player);
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
            case SLEEPING:
                break;
        }

        // if flag is set at any point during gameplay, game is "won"
        // if (map.getFlagManager().isFlagSet("hasFoundBall")) {
        //     playLevelScreenState = PlayLevelScreenState.LEVEL_COMPLETED;
        // }

        

        if (currMap.getFlagManager().isFlagSet("isFighting")) {
            if(!fightScreen.getCurrentEnemy().equals(currMap.getCurrentEnemy())){
                this.currentEnemy = currMap.getCurrentEnemy();
                setFightScreen(currentEnemy);
                System.out.println("set enemy");
            }
            playLevelScreenState = PlayLevelScreenState.FIGHTING;
        }
        if(currMap.getFlagManager().isFlagSet("playerDied")){
            playLevelScreenState = PlayLevelScreenState.FAIL;
        }
        if (currMap.getFlagManager().isFlagSet("inShop")) {
            playLevelScreenState = PlayLevelScreenState.SHOPPING;
        }

        if (currMap.getFlagManager().isFlagSet("hasQuestBird")) {
            questBird.setFontSize(30);
        }
        if (currMap.getFlagManager().isFlagSet("hasCompletedQuestBird")) {
            questBird.setFontSize(0);
        }
        if (currMap.getFlagManager().isFlagSet("hasQuestFarmer")) {
            questFarmer.setFontSize(30);
        }
        if (currMap.getFlagManager().isFlagSet("hasCompletedQuestFarmer")) {
            questFarmer.setFontSize(0);
        }
        if (currMap.getFlagManager().isFlagSet("hasQuestWoman")) {
            questWoman.setFontSize(30);
        }
        if (currMap.getFlagManager().isFlagSet("hasCompletedQuestWoman")) {
            questWoman.setFontSize(0);
        }
        if (currMap.getFlagManager().isFlagSet("hasQuestOldGuy")) {
            questOldGuy.setFontSize(30);
        }
        if (currMap.getFlagManager().isFlagSet("hasCompletedQuestOldGuy")) {
            questOldGuy.setFontSize(0);
        }
        
        if (currMap.getFlagManager().isFlagSet("InInventory")) {
            playLevelScreenState = PlayLevelScreenState.INVENTORY;
        }

        if (currMap.getFlagManager().isFlagSet("isSleeping")) {
            playLevelScreenState = PlayLevelScreenState.SLEEPING;
        }

        if (currMap.getFlagManager().isFlagSet("atSnowBiome")) {
            currMap = snowMap;
            player.setMap(snowMap);
            snowMap.setPlayer(player);
            player.setLocation(150,100);
            snowMap.getTextbox().setInteractKey(player.getInteractKey());
            snowMap.preloadScripts();
            flagManager.unsetFlag("atSnowBiome");
        }

        if (currMap.getFlagManager().isFlagSet("atForestBiome")) {
            currMap = forestMap;
            player.setMap(forestMap);
            forestMap.setPlayer(player);
            player.setLocation(150,100);
            forestMap.getTextbox().setInteractKey(player.getInteractKey());
            forestMap.preloadScripts();
            flagManager.unsetFlag("atForestBiome");
        }

        if (currMap.getFlagManager().isFlagSet("atStartBiome")) {
            currMap = startMap;
            player.setMap(startMap);
            startMap.setPlayer(player);
            player.setLocation(800,860);
            startMap.preloadScripts();
            flagManager.unsetFlag("atStartBiome");
        }
        
        
    }

    public int getCharacterSelection(){
        return this.characterChoice;
    }

    public void draw(GraphicsHandler graphicsHandler) {
        // based on screen state, draw appropriate graphics
        switch (playLevelScreenState) {
            case RUNNING:
                currMap.draw(player, graphicsHandler);
                coinCounter.draw(graphicsHandler);
                questBird.draw(graphicsHandler);
                questFarmer.draw(graphicsHandler);
                questWoman.draw(graphicsHandler);
                questOldGuy.draw(graphicsHandler);
                // health bar
                graphicsHandler.drawFilledRectangleWithBorder(25, 25, player.getMaxHealth() * 2, 25, Color.gray, Color.black, 3);
                graphicsHandler.drawFilledRectangle(25, 25, (player.getHealth() * 2), 25, new Color(190, 0, 0));
                break;
            case LEVEL_COMPLETED:
                winScreen.draw(graphicsHandler);
                break;
            case FAIL:
                failScreen.draw(graphicsHandler);
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
            // case SNOW:
            //     map = new SnowMap();
            //     break;
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
                    currMap.draw(player, graphicsHandler);
                    coinCounter.draw(graphicsHandler);
                    //quest1.draw(graphicsHandler);
                    // health bar
                    graphicsHandler.drawFilledRectangleWithBorder(25, 25, 200, 25, Color.gray, Color.black, 3);
                    graphicsHandler.drawFilledRectangle(25, 25, (player.getHealth() * 2), 25, new Color(190, 0, 0));
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

    public void goToInventory() {
        screenCoordinator.setGameState(GameState.INVENTORY);
    }

    public void backToGame() {
        playLevelScreenState = PlayLevelScreenState.RUNNING;
        flagManager.unsetFlag("isFighting");
        flagManager.unsetFlag("inShop");
        flagManager.unsetFlag("InInventory");
        flagManager.unsetFlag("isSleeping");
    }

    public void setFightScreen(Enemy enemy){
        fightScreen = new FightScreen(this, player, enemy);
    }

    public Enemy getCurrentEnemy(){
        return this.currentEnemy;
    }

    // This enum represents the different states this screen can be in
    private enum PlayLevelScreenState {
        // add shopping
        RUNNING, LEVEL_COMPLETED, FIGHTING, SHOPPING, SLEEPING, INVENTORY, FAIL
    }
}
