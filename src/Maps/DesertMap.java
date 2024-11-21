package Maps;

import Level.*;
import NPCs.Bed;
import NPCs.Cactus;
import NPCs.CactusBoss;
import NPCs.ScaredGuy;
import NPCs.Thief;
import Scripts.TestMap.*;
import Tilesets.DesertTileset;
import java.util.ArrayList;

// Represents a test map to be used in a level
public class DesertMap extends Map {

    public DesertMap() {
        super("desert_map.txt", new DesertTileset());
        this.playerStartPosition = getMapTile(5, 5).getLocation();
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

        CactusBoss cactusBoss = new CactusBoss(1, getMapTile(12, 8).getLocation());
        cactusBoss.setInteractScript(new CactusBossScript());
        npcs.add(cactusBoss);

        ScaredGuy scaredGuy = new ScaredGuy(2, getMapTile(18, 8).getLocation());
        scaredGuy.setInteractScript(new ScaredGuyScript());
        npcs.add(scaredGuy);

        Cactus cactus = new Cactus(3, getMapTile(24, 8).getLocation());
        cactus.setInteractScript(new CactusScript());
        npcs.add(cactus);

        Thief thief = new Thief(4, getMapTile(24, 15).getLocation());
        thief.setInteractScript(new ThiefScript());
        npcs.add(thief);

        Bed bed = new Bed(5, getMapTile(7, 22).getLocation().subtractY(40));
        bed.setInteractScript(new BedScript());
        npcs.add(bed);




        // shopkeeper id 5

        return npcs;
    }

    @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
        triggers.add(new Trigger(120, 100, 10, 80, new WarpStartScript()));
        triggers.add(new Trigger(1210, 1390, 30, 10, new WarpPyramidScript()));
        triggers.add(new Trigger(2280, 100, 10, 80, new WarpVolcanoScript()));
        triggers.add(new Trigger(120, 250, 10, 80, new WarpSnowScript()));
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

