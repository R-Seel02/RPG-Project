package Maps;

import EnhancedMapTiles.PushableRock;
import GameObject.Frame;
import Level.*;
import NPCs.Bug;
import NPCs.Dinosaur;
import NPCs.TestNPC;

import NPCs.Amongus;
import NPCs.Bird;

import NPCs.FarmerNPC;
import NPCs.ChickenRed;
import NPCs.ChickenYellow;
import NPCs.ChickenOrange;
import NPCs.ChickenBlue;
import NPCs.ChickenGreen;

import NPCs.QuestWoman;
import NPCs.Bottle;
import NPCs.Anchor;

import NPCs.OldGuy;
import NPCs.Skeleton;

import NPCs.Walrus;

import Scripts.SimpleTextScript;
import Scripts.TestMap.*;
import Tilesets.CommonTileset;
import java.util.ArrayList;

import Engine.ImageLoader;

// Represents a test map to be used in a level
public class TestMap extends Map {

    public TestMap() {
        super("test_map.txt", new CommonTileset());
        this.playerStartPosition = getMapTile(11, 17).getLocation();
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

        PushableRock pushableRock = new PushableRock(getMapTile(2, 7).getLocation());
        // enhancedMapTiles.add(pushableRock);

        return enhancedMapTiles;
    }

    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        Walrus walrus = new Walrus(1, getMapTile(4, 28).getLocation().subtractY(40));
        walrus.setInteractScript(new WalrusScript());
        npcs.add(walrus);

        Dinosaur dinosaur = new Dinosaur(2, getMapTile(13, 4).getLocation());
        dinosaur.setExistenceFlag("hasTalkedToDinosaur");
        dinosaur.setInteractScript(new DinoScript());
        npcs.add(dinosaur);
        
        Bug bug = new Bug(3, getMapTile(7, 12).getLocation().subtractX(20));
        bug.setInteractScript(new BugScript());
        npcs.add(bug);

        TestNPC testNPC = new TestNPC(4, getMapTile(10, 18).getLocation().subtractY(40));
        testNPC.setInteractScript(new TestNPCScript());
        npcs.add(testNPC);

        Amongus amongus = new Amongus(5, getMapTile(24, 19).getLocation().subtractY(40));
        amongus.setInteractScript(new AmongusScript3());
        npcs.add(amongus);

        Bird bird = new Bird(6, getMapTile(5, 20).getLocation().subtractY(40));
        bird.setInteractScript(new BirdScript2());
        npcs.add(bird);
        

        FarmerNPC farmerNPC = new FarmerNPC(7, getMapTile(15, 28).getLocation().subtractY(40));
        farmerNPC.setInteractScript(new QuestFarmerScript());
        npcs.add(farmerNPC);

        ChickenRed chickenRed = new ChickenRed(8, getMapTile(20, 25).getLocation().subtractY(40));
        //chickenRed.setExistenceFlag("hasTalkedToChickenRed");
        chickenRed.setInteractScript(new ChickenRedScript());
        npcs.add(chickenRed);

        ChickenYellow chickenYellow = new ChickenYellow(9, getMapTile(30, 25).getLocation().subtractY(40));
        //chickenRed.setExistenceFlag("hasTalkedToChickenRed");
        chickenYellow.setInteractScript(new ChickenYellowScript());
        npcs.add(chickenYellow);

        ChickenOrange chickenOrange = new ChickenOrange(10, getMapTile(30, 10).getLocation().subtractY(40));
        //chickenRed.setExistenceFlag("hasTalkedToChickenRed");
        chickenOrange.setInteractScript(new ChickenOrangeScript());
        npcs.add(chickenOrange);

          ChickenBlue chickenBlue = new ChickenBlue(11, getMapTile(8, 10).getLocation().subtractY(40));
          //chickenRed.setExistenceFlag("hasTalkedToChickenRed");
          chickenBlue.setInteractScript(new ChickenBlueScript());
          npcs.add(chickenBlue);

         ChickenGreen chickenGreen = new ChickenGreen(12, getMapTile(2, 30).getLocation().subtractY(40));
         //chickenRed.setExistenceFlag("hasTalkedToChickenRed");
         chickenGreen.setInteractScript(new ChickenGreenScript());
         npcs.add(chickenGreen);

         QuestWoman questWoman = new QuestWoman(13, getMapTile(22,5 ).getLocation().subtractY(40));
         questWoman.setInteractScript(new QuestWomanScript());
         npcs.add(questWoman);

         Bottle bottle = new Bottle(14, getMapTile(30, 5 ).getLocation().subtractY(40));
         bottle.setExistenceFlag("hasBottle");
         bottle.setInteractScript(new BottleScript());
         npcs.add(bottle);

         Anchor anchor = new Anchor(15, getMapTile(32, 5 ).getLocation().subtractY(40));
         anchor.setExistenceFlag("hasAnchor");
         anchor.setInteractScript(new AnchorScript());
         npcs.add(anchor);

         Skeleton skeleton = new Skeleton(16, getMapTile(20, 10 ).getLocation().subtractY(40));
         skeleton.setInteractScript(new SkeletonScript());
         npcs.add(skeleton);

         OldGuy oldGuy = new OldGuy(17, getMapTile(2, 15 ).getLocation().subtractY(40));
         oldGuy.setInteractScript(new QuestOldGuyScript());
         npcs.add(oldGuy);


        // shopkeeper id 5

        return npcs;
    }

    @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
        triggers.add(new Trigger(540, 830, 100, 10, new LostBallScript(), "hasLostBall"));
        triggers.add(new Trigger(540, 830, 10, 80, new LostBallScript(), "hasLostBall"));
        triggers.add(new Trigger(645, 830, 10, 80, new LostBallScript(), "hasLostBall"));
        triggers.add(new Trigger(540, 900, 100, 10, new LostBallScript(), "hasLostBall"));
        return triggers;
    }

    @Override
    public ArrayList<PickableObject> loadPickableObjects(){
         ArrayList<PickableObject> pickableObjects = new ArrayList<>();
         PickableObject pickableObject = new PickableObject(getMapTile(10, 3).getLocation(), new Frame(ImageLoader.load("Rock.png")));
         pickableObjects.add(pickableObject);

         
        //  pickableObject.setInteractScript(new RockScript(pickableObject));

         return pickableObjects;
 


    }

    @Override
    public void loadScripts() {
        getMapTile(21, 19).setInteractScript(new SimpleTextScript("Cat's house"));

        getMapTile(7, 26).setInteractScript(new SimpleTextScript("Walrus's house"));

        getMapTile(20, 4).setInteractScript(new SimpleTextScript("Dino's house"));

        getMapTile(2, 6).setInteractScript(new TreeScript());
    }
}

