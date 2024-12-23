package Maps;

import Level.*;
import NPCs.Bed;
import NPCs.CoalMan;
import NPCs.Fish;
import NPCs.SnowChest;
import NPCs.SnowChest2;
import NPCs.SnowChest3;
import NPCs.SnowChestFake;
import NPCs.Snowman;
import NPCs.SnowmanBoss;
import Scripts.TestMap.*;
import Tilesets.SnowTileset;
import java.util.ArrayList;

// Represents a test map to be used in a level
public class SnowMap extends Map {

    public SnowMap() {
        super("snow_map.txt", new SnowTileset());
        // this.playerStartPosition = getMapTile(17, 19).getLocation();
        // Portal is at x:2, y:15
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

        // PushableRock pushableRock = new PushableRock(getMapTile(2, 7).getLocation());
        // enhancedMapTiles.add(pushableRock);

        return enhancedMapTiles;
    }

    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        CoalMan coalMan = new CoalMan(1, getMapTile(17,16).getLocation().subtractY(40));
        coalMan.setInteractScript(new CoalManScript());
        npcs.add(coalMan);

        Snowman snowman = new Snowman(2, getMapTile(8, 2).getLocation().subtractY(40));
        snowman.setInteractScript(new SnowmanScript());
        npcs.add(snowman);

        Fish fish = new Fish(3, getMapTile(12, 12).getLocation().subtractY(40));
        fish.setInteractScript(new FishScript());
        npcs.add(fish);

        SnowmanBoss snowmanBoss = new SnowmanBoss(4, getMapTile(8, 12).getLocation());
        snowmanBoss.setInteractScript(new SnowmanBossScript());
        npcs.add(snowmanBoss);
        
        SnowChest snowChest = new SnowChest(5, getMapTile(28, 13).getLocation());
        snowChest.setInteractScript(new SnowChestScript());
        npcs.add(snowChest);

        SnowChest2 snowChest2 = new SnowChest2(6, getMapTile(14, 26).getLocation());
        snowChest2.setInteractScript(new SnowChestScript2());
        npcs.add(snowChest2);

        SnowChest3 snowChest3 = new SnowChest3(7, getMapTile(46, 23).getLocation());
        snowChest3.setInteractScript(new SnowChestScript3());
        npcs.add(snowChest3);

        SnowChestFake snowChestFake = new SnowChestFake(8, getMapTile(46, 35).getLocation());
        snowChestFake.setInteractScript(new SnowChestFakeScript());
        npcs.add(snowChestFake);

        Bed bed = new Bed(9, getMapTile(7, 22).getLocation().subtractY(40));
        bed.setInteractScript(new BedScript());
        npcs.add(bed);

        return npcs;
    }

    @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
        triggers.add(new Trigger(120, 100, 10, 80, new WarpStartScript()));
        triggers.add(new Trigger(2280, 100, 10, 80, new WarpDesertScript()));
        triggers.add(new Trigger(120, 250, 10, 80, new WarpForestScript()));
        return triggers;
    }

    // @Override
    // public ArrayList<PickableObject> loadPickableObjects(){
    //      ArrayList<PickableObject> pickableObjects = new ArrayList<>();
    //      PickableObject pickableObject = new PickableObject(getMapTile(10, 3).getLocation(), new Frame(ImageLoader.load("Rock.png")));
    //      pickableObjects.add(pickableObject);
    //     //  pickableObject.setInteractScript(new RockScript(pickableObject));

    //      return pickableObjects;
 


    // }

    @Override
    public void loadScripts() {
        
    }
}

