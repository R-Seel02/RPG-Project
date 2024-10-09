package Maps;

import EnhancedMapTiles.PushableRock;
import Level.*;
import NPCs.Bug;
import NPCs.Dinosaur;
import NPCs.TestNPC;
<<<<<<< HEAD
import NPCs.Amongus;
import NPCs.Bird;
=======
import NPCs.Walrus;
>>>>>>> 72ab50925ea5a486df47380c788b1960ad08fcf4
import Scripts.SimpleTextScript;
import Scripts.TestMap.*;
import Tilesets.CommonTileset;
import java.util.ArrayList;

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

        Amongus amongus = new Amongus(5, getMapTile(30, 18).getLocation().subtractY(40));
        amongus.setInteractScript(new AmongusScript3());
        npcs.add(amongus);

        Bird bird = new Bird(6, getMapTile(5, 20).getLocation().subtractY(40));
        bird.setInteractScript(new BirdScript2());
        npcs.add(bird);

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
    public void loadScripts() {
        getMapTile(21, 19).setInteractScript(new SimpleTextScript("Cat's house"));

        getMapTile(7, 26).setInteractScript(new SimpleTextScript("Walrus's house"));

        getMapTile(20, 4).setInteractScript(new SimpleTextScript("Dino's house"));

        getMapTile(2, 6).setInteractScript(new TreeScript());
    }
}

