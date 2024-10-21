package Maps;

import EnhancedMapTiles.PushableRock;
import GameObject.Frame;
import Level.*;
import NPCs.Bug;
import NPCs.Chest;
import NPCs.Chest2;
import NPCs.Dinosaur;
import NPCs.TestNPC;

import NPCs.Amongus;
import NPCs.Bird;

import NPCs.Walrus;
import PickableObjects.ItemRock;
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

        Chest chest = new Chest(7, getMapTile(13, 10).getLocation());
        chest.setInteractScript(new ChestScript());
        npcs.add(chest);
        Chest2 chest2 = new Chest2(8, getMapTile(25, 12).getLocation());
        chest2.setInteractScript(new Chest2Script());
        npcs.add(chest2);

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

         ItemRock itemRock = new ItemRock(getMapTile(10, 3).getLocation(), new Frame(ImageLoader.load("Rock.png")));
         pickableObjects.add(itemRock);
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

