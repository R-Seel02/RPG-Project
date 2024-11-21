package Maps;

import Level.*;
import NPCs.Chest;
import NPCs.DesertChest;
import Scripts.TestMap.ChestScript;
import Scripts.TestMap.DesertChestScript;
import Scripts.TestMap.LeavePyramidScript;
import Tilesets.DesertTileset;
import java.util.ArrayList;

// Represents a test map to be used in a level
public class PyramidMap extends Map {

    public PyramidMap() {
        super("pyramid_map.txt", new DesertTileset());
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

        DesertChest desertChest = new DesertChest(1, getMapTile(2, 5).getLocation());
        desertChest.setInteractScript(new DesertChestScript());
        npcs.add(desertChest);

        

        return npcs;
    }

    @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
        triggers.add(new Trigger(480, 910, 30, 10, new LeavePyramidScript()));
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

