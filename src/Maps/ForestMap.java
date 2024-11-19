package Maps;

import Level.*;
import Scripts.TestMap.*;
import Tilesets.ForestTileset;
import java.util.ArrayList;

import NPCs.CoalMan;
import NPCs.PlagueDoctor;
import NPCs.Cauldron;
import NPCs.Frog;
import NPCs.PurpleFlower;
import NPCs.Vial;
import NPCs.Eyeball;

import NPCs.MuggedWoman;
import NPCs.Thug1;
import NPCs.Thug2;
import NPCs.Thug3;
import NPCs.TreeBoss;

// Represents a test map to be used in a level
public class ForestMap extends Map {

    public ForestMap() {
        super("forest_map.txt", new ForestTileset());
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

        PlagueDoctor plagueDoctor = new PlagueDoctor(1, getMapTile(8,2).getLocation().subtractY(40));
        plagueDoctor.setInteractScript(new PlagueDoctorScript());
        npcs.add(plagueDoctor);

        Cauldron cauldron = new Cauldron(2, getMapTile(10,2).getLocation().subtractY(40));
        cauldron.setInteractScript(new CauldronScript());
        npcs.add(cauldron);

        Frog frog = new Frog(2, getMapTile(14,2).getLocation().subtractY(40));
        frog.setInteractScript(new FrogScript());
        npcs.add(frog);

        PurpleFlower purpleFlower = new PurpleFlower(2, getMapTile(18,2).getLocation().subtractY(40));
        purpleFlower.setInteractScript(new PurpleFlowerScript());
        npcs.add(purpleFlower);

        Vial vial = new Vial(2, getMapTile(22,2).getLocation().subtractY(40));
        vial.setInteractScript(new VialScript());
        npcs.add(vial);

        Eyeball eyeBall = new Eyeball(2, getMapTile(26,2).getLocation().subtractY(40));
        eyeBall.setInteractScript(new EyeballScript());
        npcs.add(eyeBall);

        MuggedWoman muggedWoman = new MuggedWoman(2, getMapTile(7,10).getLocation().subtractY(40));
        muggedWoman.setInteractScript(new MuggedWomanScript());
        npcs.add(muggedWoman);

        Thug1 thug1 = new Thug1(2, getMapTile(10,10).getLocation().subtractY(40));
        thug1.setInteractScript(new Thug1Script());
        npcs.add(thug1);

        Thug2 thug2 = new Thug2(2, getMapTile(15,10).getLocation().subtractY(40));
        thug2.setInteractScript(new Thug2Script());
        npcs.add(thug2);

        Thug3 thug3 = new Thug3(2, getMapTile(15,15).getLocation().subtractY(40));
        thug3.setInteractScript(new Thug3Script());
        npcs.add(thug3);

        TreeBoss treeBoss = new TreeBoss(21, getMapTile(20, 20).getLocation());
        treeBoss.setInteractScript(new TreeBossScript());
        npcs.add(treeBoss);
        

        

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

