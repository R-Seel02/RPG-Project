package Maps;

import Level.*;
import Scripts.TestMap.*;
import Tilesets.DesertTileset;
import java.util.ArrayList;

import NPCs.Cactus;
import NPCs.Lever;
import NPCs.Totem;

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

        Lever lever1 = new Lever(1, getMapTile(7, 3).getLocation());
        lever1.setInteractScript(new Lever1Script());
        npcs.add(lever1);

        Lever lever2 = new Lever(2, getMapTile(7, 18).getLocation());
        lever2.setInteractScript(new Lever2Script());
        npcs.add(lever2);

        Lever lever3 = new Lever(3, getMapTile(14, 10).getLocation());
        lever3.setInteractScript(new Lever3Script());
        npcs.add(lever3);

        Totem totem = new Totem(4, getMapTile(10, 4).getLocation());
        totem.setInteractScript(new TotemScript());
        npcs.add(totem);
        // shopkeeper id 5

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

