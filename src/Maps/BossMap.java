package Maps;

import Level.*;
import NPCs.FinalBoss;
import Scripts.TestMap.FinalBossScript;
import Scripts.TestMap.WarpStartScript;
import Tilesets.CommonTileset;
import java.util.ArrayList;

// Represents a test map to be used in a level
public class BossMap extends Map {

    public BossMap() {
        super("boss_map.txt", new CommonTileset());
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

        FinalBoss finalBoss = new FinalBoss(1, getMapTile(13, 3).getLocation());
        finalBoss.setInteractScript(new FinalBossScript());
        npcs.add(finalBoss);

        // shopkeeper id 5

        return npcs;
    }

    @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
        triggers.add(new Trigger(675, 820, 40, 85, new WarpStartScript()));
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

