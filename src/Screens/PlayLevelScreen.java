package Screens;

import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.*;
import Maps.BossMap;
import Maps.DesertMap;
import Maps.ForestMap;
import Maps.PyramidMap;
import Maps.SnowMap;
import Maps.StartingMap;
import Maps.VolcanoMap;
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
    protected Map startMap, snowMap, forestMap, desertMap, volcanoMap, bossMap, pyramidMap;
    protected Map currMap;
    protected Player player, newPlayer;
    protected PlayLevelScreenState playLevelScreenState;
    protected WinScreen winScreen;
    protected FailScreen failScreen;
    protected ShopScreen shopScreen;
    protected FightScreen fightScreen;
    protected MapScreen mapScreen;
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
    protected SpriteFont questSnowman;
    protected SpriteFont questPlagueDoctorCauldron;
    protected SpriteFont questPlagueDoctorFrog;
    protected SpriteFont questPlagueDoctorPurpleFlower;
    protected SpriteFont questPlagueDoctorEyeball;
    protected SpriteFont questPlagueDoctorVial;
    protected SpriteFont questMuggedWoman;
    protected SpriteFont questScaredGuy;
    protected SpriteFont questThief;
    protected SpriteFont returnTotem;
    protected SpriteFont questGolem;
    protected SpriteFont watchTheFight;
    protected SpriteFont returnToSalamanderGuy;
    protected SpriteFont charles;
    protected SpriteFont jeremy;
    protected SpriteFont gregory;

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

        // biome flags
        flagManager.addFlag("atSnowBiome", false);
        flagManager.addFlag("atStartBiome", false);
        flagManager.addFlag("atForestBiome", false);
        flagManager.addFlag("atDesertBiome", false);
        flagManager.addFlag("atVolcanoBiome", false);
        flagManager.addFlag("atBossRoom", false);
        flagManager.addFlag("atPyramid", false);
        flagManager.addFlag("leftPyramid", false);
        flagManager.addFlag("unlockedSnow", false);
        flagManager.addFlag("unlockedDesert", false);
        flagManager.addFlag("unlockedVolcano", false);
        flagManager.addFlag("unlockedBoss", false);


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

        //forest biome Quests/NPCS
        flagManager.addFlag("hasQuestPlagueDoctor", false);
        flagManager.addFlag("hasCompletedQuestPlagueDoctor", false);
        flagManager.addFlag("hasFrog", false);
        flagManager.addFlag("hasPurpleFlower", false);
        flagManager.addFlag("hasVial", false);
        flagManager.addFlag("hasEyeball", false);
        flagManager.addFlag("hasCauldron", false);
        flagManager.addFlag("textFrog", false);
        flagManager.addFlag("textPurpleFlower", false);
        flagManager.addFlag("textVial", false);
        flagManager.addFlag("textEyeball", false);
        flagManager.addFlag("textCauldron", false);

        flagManager.addFlag("hasQuestMuggedWoman", false);
        flagManager.addFlag("hasCompletedQuestMuggedWoman", false);
        flagManager.addFlag("hasFoughtThug1", false);
        flagManager.addFlag("hasFoughtThug2", false);
        flagManager.addFlag("hasFoughtThug3", false);
        flagManager.addFlag("hasFoughtAllThugs", false);
        flagManager.addFlag("hasPurse", false);

        //Winter biome Quests/NPCS
        flagManager.addFlag("hasQuestSnowman", false);
        flagManager.addFlag("hasCompletedQuestSnowman", false);
        flagManager.addFlag("hasCoal", false);
        flagManager.addFlag("hasFireTome", false);
        flagManager.addFlag("hasSavedFish", false);
        flagManager.addFlag("hasTalkedToFish", false);
        flagManager.addFlag("hasFishBlessing", false);

        //Desert biome Quests/NPCS
        flagManager.addFlag("hasQuestThief", false);
        flagManager.addFlag("hasCompletedQuestThief", false);
        flagManager.addFlag("hasPulledLever1", false);
        flagManager.addFlag("hasPulledLever2", false);
        flagManager.addFlag("hasPulledLever3", false);
        flagManager.addFlag("hitLever1", false);
        flagManager.addFlag("hitLever2", false);
        flagManager.addFlag("hitLever3", false);
        flagManager.addFlag("hasTotem", false);

        flagManager.addFlag("hasQuestScaredGuy", false);
        flagManager.addFlag("hasCompletedQuestScaredGuy", false);
        flagManager.addFlag("hasFoughtCactus", false);

        //lava biome
        flagManager.addFlag("hasQuestSalamanderGuy", false);
        flagManager.addFlag("hasCompletedQuestSalamanderGuy", false);
        flagManager.addFlag("hasSalamander1", false);
        flagManager.addFlag("hasSalamander2", false);
        flagManager.addFlag("hasSalamander3", false);
        flagManager.addFlag("return1", false);
        flagManager.addFlag("return2", false);
        flagManager.addFlag("return3", false);
        //after finding all of the salamanders the guy takes his off human skin and shows hes salamander then cares for kids (happy ending very wholesome but creepy C:)
        //he feels safe showing hes a salamander since he trusts you can take down the evil king
        //mention how he evil king doesnt like salamanders (speciesism lol)

        flagManager.addFlag("hasQuestGolem", false);
        flagManager.addFlag("hasCompletedQuestGolem", false);
        flagManager.addFlag("hasTalkedToFireSpirit", false);
        flagManager.addFlag("hasTalkedToGolem", false);
        flagManager.addFlag("hasFoughtGroup", false);
        // have both meet up then they decide to fight you then you all make friends when you win then they give you something.
        



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
        flagManager.addFlag("hasStaff", false);

        // bosses
        flagManager.addFlag("treeBossDefeated", false);
        flagManager.addFlag("snowmanBossDefeated", false);
        flagManager.addFlag("cactusBossDefeated", false);
        flagManager.addFlag("rockBossDefeated", false);
        flagManager.addFlag("finalBossDefeated", false);

        // enemies
        flagManager.addFlag("skeletonDefeated", false);

        flagManager.addFlag("inMap", false);


        // define/setup map       
        startMap = new StartingMap();
        startMap.setFlagManager(flagManager);
        snowMap = new SnowMap();
        snowMap.setFlagManager(flagManager);
        forestMap = new ForestMap();
        forestMap.setFlagManager(flagManager);
        desertMap = new DesertMap();
        desertMap.setFlagManager(flagManager);
        bossMap = new BossMap();
        bossMap.setFlagManager(flagManager);
        volcanoMap = new VolcanoMap();
        volcanoMap.setFlagManager(flagManager);
        pyramidMap = new PyramidMap();
        pyramidMap.setFlagManager(flagManager);
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

        questSnowman = new SpriteFont("Find the coal for the snowman.", 950, 75, "Arial", 0, Color.white);
        questSnowman.setOutlineColor(Color.black);
        questSnowman.setOutlineThickness(3);

        questPlagueDoctorCauldron = new SpriteFont("Find the Cauldron for the plague doctor.", 825, 75, "Arial", 0, Color.white);
        questPlagueDoctorCauldron.setOutlineColor(Color.black);
        questPlagueDoctorCauldron.setOutlineThickness(3);
        questPlagueDoctorFrog = new SpriteFont("Find the Frog for the plague doctor.", 875, 75, "Arial", 0, Color.white);
        questPlagueDoctorFrog.setOutlineColor(Color.black);
        questPlagueDoctorFrog.setOutlineThickness(3);
        questPlagueDoctorPurpleFlower = new SpriteFont("Find the Purple Flower for the plague doctor.", 775, 75, "Arial", 0, Color.white);
        questPlagueDoctorPurpleFlower.setOutlineColor(Color.black);
        questPlagueDoctorPurpleFlower.setOutlineThickness(3);
        questPlagueDoctorEyeball = new SpriteFont("Find the Eyeball for the plague doctor.", 870, 75, "Arial", 0, Color.white);
        questPlagueDoctorEyeball.setOutlineColor(Color.black);
        questPlagueDoctorEyeball.setOutlineThickness(3);
        questPlagueDoctorVial = new SpriteFont("Find the Vial for the plague doctor.", 875, 75, "Arial", 0, Color.white);
        questPlagueDoctorVial.setOutlineColor(Color.black);
        questPlagueDoctorVial.setOutlineThickness(3);

        questMuggedWoman = new SpriteFont("Find the womans purse.", 1025, 75, "Arial", 0, Color.white);
        questMuggedWoman.setOutlineColor(Color.black);
        questMuggedWoman.setOutlineThickness(3);

        questScaredGuy = new SpriteFont("Defeat the Cactus.", 1100, 75, "Arial", 0, Color.white);
        questScaredGuy.setOutlineColor(Color.black);
        questScaredGuy.setOutlineThickness(3);

        questThief = new SpriteFont("Take the item from the pyramid.", 950, 75, "Arial", 0, Color.white);
        questThief.setOutlineColor(Color.black);
        questThief.setOutlineThickness(3);

        returnTotem = new SpriteFont("return the totem to the thief.", 1000, 75, "Arial", 0, Color.white);
        returnTotem.setOutlineColor(Color.black);
        returnTotem.setOutlineThickness(3);

        questGolem = new SpriteFont("Talk to the Fire Spirit.", 1000, 75, "Arial", 0, Color.white);
        questGolem.setOutlineColor(Color.black);
        questGolem.setOutlineThickness(3);

        watchTheFight = new SpriteFont("Talk to the Golem.", 1100, 75, "Arial", 0, Color.white);
        watchTheFight.setOutlineColor(Color.black);
        watchTheFight.setOutlineThickness(3);

        returnToSalamanderGuy = new SpriteFont("Return to the man.", 1100, 75, "Arial", 0, Color.white);
        returnToSalamanderGuy.setOutlineColor(Color.black);
        returnToSalamanderGuy.setOutlineThickness(3);

        charles = new SpriteFont("find Charles.", 1100, 75, "Arial", 0, Color.white);
        charles.setOutlineColor(Color.black);
        charles.setOutlineThickness(3);

        jeremy = new SpriteFont("find jeremy.", 1100, 75, "Arial", 0, Color.white);
        jeremy.setOutlineColor(Color.black);
        jeremy.setOutlineThickness(3);

        gregory = new SpriteFont("find gregory.", 1100, 75, "Arial", 0, Color.white);
        gregory.setOutlineColor(Color.black);
        gregory.setOutlineThickness(3);

        // set up coin counter text
        coinCounter = new SpriteFont("Coins: " + player.getCoinCount(), 1200, 20, "Arial", 40, Color.white);
        coinCounter.setOutlineColor(Color.black);
        coinCounter.setOutlineThickness(2);

        // set up blank sleep message
        sleepMessage = new SpriteFont("You sleep to recover your strength.", 450, 650, "Arial", 30, Color.white);
        sleepMessage.setOutlineColor(Color.black);
        sleepMessage.setOutlineThickness(2);
        
        //initialize enemy
        currentEnemy = new Enemy("default", 1, 1, 1, "error.png", 24, 24);

        // let pieces of map know which button to listen for as the "interact" button
        currMap.getTextbox().setInteractKey(player.getInteractKey());

        // preloads all scripts ahead of time rather than loading them dynamically
        // both are supported, however preloading is recommended
        currMap.preloadScripts();

        winScreen = new WinScreen(this);
        fightScreen = new FightScreen(this, player, currentEnemy);
        shopScreen = new ShopScreen(this, this.player);
        inventoryScreen = new InventoryScreen(this, player);
        mapScreen = new MapScreen();
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

        if (Keyboard.isKeyDown(Key.M) && !keyLocker.isKeyLocked(Key.M)) {
            if (playLevelScreenState == PlayLevelScreenState.RUNNING) {
                playLevelScreenState = PlayLevelScreenState.MAP; // Switch to inventory
            } else if (playLevelScreenState == PlayLevelScreenState.MAP) {
                playLevelScreenState = PlayLevelScreenState.RUNNING; // Switch back to the game
            }
            keyLocker.lockKey(Key.M); 
        }
    
        if (Keyboard.isKeyUp(Key.M)) {
            keyLocker.unlockKey(Key.M); // Unlock the key once it's released
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
            case MAP:
                mapScreen.update();
                break;
            case SLEEPING:
                break;
            case FAIL:
                failScreen.update();
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
                    //System.out.println("set enemy");
            }
            if(!currentEnemy.isDead()){
            playLevelScreenState = PlayLevelScreenState.FIGHTING;
            }
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
        if (currMap.getFlagManager().isFlagSet("hasQuestSnowman")) {
            questSnowman.setFontSize(30);
        }
        if (currMap.getFlagManager().isFlagSet("hasCompletedQuestSnowman")) {
            questSnowman.setFontSize(0);
        }
        if (currMap.getFlagManager().isFlagSet("hasQuestMuggedWoman")) {
            questMuggedWoman.setFontSize(30);
        }
        if (currMap.getFlagManager().isFlagSet("hasCompletedQuestMuggedWoman")) {
            questMuggedWoman.setFontSize(0);
        }
        

        //plague doc stuff
        if (currMap.getFlagManager().isFlagSet("hasQuestPlagueDoctor")) {
            questPlagueDoctorCauldron.setFontSize(30);
        }
        if (currMap.getFlagManager().isFlagSet("textCauldron")) {
            questPlagueDoctorCauldron.setFontSize(0);
        }
        if (currMap.getFlagManager().isFlagSet("textCauldron")) {
            questPlagueDoctorFrog.setFontSize(30);
        }
        if (currMap.getFlagManager().isFlagSet("textFrog")) {
            questPlagueDoctorFrog.setFontSize(0);
        }
        if (currMap.getFlagManager().isFlagSet("textFrog")) {
            questPlagueDoctorPurpleFlower.setFontSize(30);
        }
        if (currMap.getFlagManager().isFlagSet("textPurpleFlower")) {
            questPlagueDoctorPurpleFlower.setFontSize(0);
        }
        if (currMap.getFlagManager().isFlagSet("textPurpleFlower")) {
            questPlagueDoctorVial.setFontSize(30);
        }
        if (currMap.getFlagManager().isFlagSet("textVial")) {
            questPlagueDoctorVial.setFontSize(0);
        }
        if (currMap.getFlagManager().isFlagSet("textVial")) {
            questPlagueDoctorEyeball.setFontSize(30);
        }
        if (currMap.getFlagManager().isFlagSet("textEyeball")) {
            questPlagueDoctorEyeball.setFontSize(0);
        }

        if (currMap.getFlagManager().isFlagSet("hasQuestScaredGuy")) {
            questScaredGuy.setFontSize(30);
        }
        if (currMap.getFlagManager().isFlagSet("hasCompletedQuestScaredGuy")) {
            questScaredGuy.setFontSize(0);
        }

        if (currMap.getFlagManager().isFlagSet("hasQuestThief")) {
            questThief.setFontSize(30);
        }
        if (currMap.getFlagManager().isFlagSet("hasTotem")) {
            questThief.setFontSize(0);
            returnTotem.setFontSize(30);
        }
        if (currMap.getFlagManager().isFlagSet("hasCompletedQuestThief")) {
            returnTotem.setFontSize(0);
        }

        if (currMap.getFlagManager().isFlagSet("hasQuestGolem")) {
            questGolem.setFontSize(30);
        }
        if (currMap.getFlagManager().isFlagSet("hasTalkedToFireSpirit")) {
            questGolem.setFontSize(0);
            watchTheFight.setFontSize(30);
        }
        if (currMap.getFlagManager().isFlagSet("hasCompletedQuestGolem")) {
            watchTheFight.setFontSize(0);
        }


        if (currMap.getFlagManager().isFlagSet("hasQuestSalamanderGuy")) {
            charles.setFontSize(30);
        }
        if (currMap.getFlagManager().isFlagSet("hasSalamander1")) {
            charles.setFontSize(0);
            returnToSalamanderGuy.setFontSize(30);
        }
        if (currMap.getFlagManager().isFlagSet("return1")) {
            gregory.setFontSize(30);
            returnToSalamanderGuy.setFontSize(0);
        }
        if (currMap.getFlagManager().isFlagSet("hasSalamander2")) {
            gregory.setFontSize(0);
            returnToSalamanderGuy.setFontSize(30);
        }
        if (currMap.getFlagManager().isFlagSet("return2")) {
            jeremy.setFontSize(30);
            returnToSalamanderGuy.setFontSize(0);
        }
        if (currMap.getFlagManager().isFlagSet("hasSalamander3")) {
            jeremy.setFontSize(0);
            returnToSalamanderGuy.setFontSize(30);
        }
        if (currMap.getFlagManager().isFlagSet("return3")) {
            returnToSalamanderGuy.setFontSize(0);
        }




        if (currMap.getFlagManager().isFlagSet("InInventory")) {
            playLevelScreenState = PlayLevelScreenState.INVENTORY;
        }

        if (currMap.getFlagManager().isFlagSet("isSleeping")) {
            playLevelScreenState = PlayLevelScreenState.SLEEPING;
        }

        if (currMap.getFlagManager().isFlagSet("atSnowBiome")) {
            currMap = snowMap;
            player.setMap(currMap);
            currMap.setPlayer(player);
            player.setLocation(150, 100);
            currMap.getTextbox().setInteractKey(player.getInteractKey());
            currMap.preloadScripts();
            flagManager.unsetFlag("atSnowBiome");
        }

        if (currMap.getFlagManager().isFlagSet("atForestBiome")) {
            currMap = forestMap;
            player.setMap(currMap);
            currMap.setPlayer(player);
            player.setLocation(150, 100);
            currMap.getTextbox().setInteractKey(player.getInteractKey());
            currMap.preloadScripts();
            flagManager.unsetFlag("atForestBiome");
        }

        if (currMap.getFlagManager().isFlagSet("atDesertBiome")) {
            currMap = desertMap;
            player.setMap(currMap);
            currMap.setPlayer(player);
            player.setLocation(150, 100);
            currMap.getTextbox().setInteractKey(player.getInteractKey());
            currMap.preloadScripts();
            flagManager.unsetFlag("atDesertBiome");
        }

        if (currMap.getFlagManager().isFlagSet("atVolcanoBiome")) {
            currMap = volcanoMap;
            player.setMap(currMap);
            currMap.setPlayer(player);
            player.setLocation(150, 100);
            currMap.getTextbox().setInteractKey(player.getInteractKey());
            currMap.preloadScripts();
            flagManager.unsetFlag("atVolcanoBiome");
        }

        if (currMap.getFlagManager().isFlagSet("atBossRoom")) {
            currMap = bossMap;
            player.setMap(currMap);
            currMap.setPlayer(player);
            player.setLocation(660, 790);
            currMap.getTextbox().setInteractKey(player.getInteractKey());
            currMap.preloadScripts();
            flagManager.unsetFlag("atBossRoom");
        }

        if (currMap.getFlagManager().isFlagSet("atPyramid")) {
            currMap = pyramidMap;
            player.setMap(currMap);
            currMap.setPlayer(player);
            player.setLocation(450, 830);
            currMap.getTextbox().setInteractKey(player.getInteractKey());
            currMap.preloadScripts();
            flagManager.unsetFlag("atPyramid");
        }

        if (currMap.getFlagManager().isFlagSet("leftPyramid")) {
            currMap = desertMap;
            player.setMap(currMap);
            currMap.setPlayer(player);
            player.setLocation(1185, 1370);
            currMap.getTextbox().setInteractKey(player.getInteractKey());
            currMap.preloadScripts();
            flagManager.unsetFlag("leftPyramid");
        }

        if (currMap.getFlagManager().isFlagSet("atStartBiome")) {
            currMap = startMap;
            player.setMap(currMap);
            currMap.setPlayer(player);
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
                questSnowman.draw(graphicsHandler);
                questMuggedWoman.draw(graphicsHandler);
                questScaredGuy.draw(graphicsHandler);
                questThief.draw(graphicsHandler);
                returnTotem.draw(graphicsHandler);
                questGolem.draw(graphicsHandler);
                watchTheFight.draw(graphicsHandler);
                returnToSalamanderGuy.draw(graphicsHandler);
                charles.draw(graphicsHandler);
                gregory.draw(graphicsHandler);
                jeremy.draw(graphicsHandler);

                //plague doc stuff
                questPlagueDoctorCauldron.draw(graphicsHandler);
                questPlagueDoctorFrog.draw(graphicsHandler);
                questPlagueDoctorPurpleFlower.draw(graphicsHandler);
                questPlagueDoctorVial.draw(graphicsHandler);
                questPlagueDoctorEyeball.draw(graphicsHandler);

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
            case MAP:
                mapScreen.draw(graphicsHandler);
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

    public void goToMap() {
        screenCoordinator.setGameState(GameState.MAP);
    }

    public void backToGame() {
        playLevelScreenState = PlayLevelScreenState.RUNNING;
        flagManager.unsetFlag("isFighting");
        flagManager.unsetFlag("inShop");
        flagManager.unsetFlag("InInventory");
        flagManager.unsetFlag("isSleeping");
        flagManager.unsetFlag("inMap");
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
        RUNNING, LEVEL_COMPLETED, FIGHTING, SHOPPING, SLEEPING, INVENTORY, FAIL, MAP
    }
}
