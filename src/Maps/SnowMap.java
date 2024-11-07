package Maps;

import Engine.ImageLoader;
import GameObject.Frame;
import Level.*;

import PickableObjects.ItemRock;
import Scripts.SimpleTextScript;
import Scripts.TestMap.*;
import Tilesets.SnowTileset;
import java.util.ArrayList;

import NPCs.Bed;
import NPCs.Chest;
import NPCs.Chest2;

import NPCs.CoalMan;
import NPCs.Snowman;
import NPCs.Fish;

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

        CoalMan coalMan = new CoalMan(1, getMapTile(2,2).getLocation().subtractY(40));
        coalMan.setInteractScript(new CoalManScript());
        npcs.add(coalMan);

        Snowman snowman = new Snowman(2, getMapTile(8, 2).getLocation().subtractY(40));
        snowman.setInteractScript(new SnowmanScript());
        npcs.add(snowman);

        Fish fish = new Fish(3, getMapTile(12, 12).getLocation().subtractY(40));
        fish.setInteractScript(new FishScript());
        npcs.add(fish);

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

