package Maps;

import Level.*;
import NPCs.CactusBoss;
import NPCs.RockBoss;
import Scripts.TestMap.CactusBossScript;
import Scripts.TestMap.RockBossScript;
import Scripts.TestMap.WarpStartScript;
import Tilesets.ForestTileset;
import java.util.ArrayList;

// Represents a test map to be used in a level
public class VolcanoMap extends Map {

    public VolcanoMap() {
        super("volcano_map.txt", new ForestTileset());
        // this.playerStartPosition = getMapTile(5, 5).getLocation();
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

        RockBoss rockBoss = new RockBoss(1, getMapTile(12, 8).getLocation());
        rockBoss.setInteractScript(new RockBossScript());
        npcs.add(rockBoss);

        // shopkeeper id 5

        return npcs;
    }

    @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
        triggers.add(new Trigger(120, 100, 10, 80, new WarpStartScript()));
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

