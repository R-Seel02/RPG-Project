package Maps;

import Level.*;
import Scripts.TestMap.*;
import Tilesets.VolcanoTileset;
import java.util.ArrayList;

import NPCs.RockBoss;
import NPCs.SalamanderGuy;
import NPCs.SalamanderOther;
import NPCs.Salamander3;

// Represents a test map to be used in a level
public class VolcanoMap extends Map {

    public VolcanoMap() {
        super("volcano_map.txt", new VolcanoTileset());
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

        SalamanderGuy salamanderGuy = new SalamanderGuy(2, getMapTile(18, 8).getLocation());
        salamanderGuy.setInteractScript(new SalamanderGuyScript());
        npcs.add(salamanderGuy);

        SalamanderOther salamander1 = new SalamanderOther(3, getMapTile(24, 5).getLocation());
        salamander1.setInteractScript(new Salamander1Script());
        npcs.add(salamander1);

        SalamanderOther salamander2 = new SalamanderOther(4, getMapTile(10, 15).getLocation());
        salamander2.setInteractScript(new Salamander2Script());
        npcs.add(salamander2);

        Salamander3 salamander3 = new Salamander3(5, getMapTile(24, 15).getLocation());
        salamander3.setInteractScript(new Salamander3Script());
        npcs.add(salamander3);

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

