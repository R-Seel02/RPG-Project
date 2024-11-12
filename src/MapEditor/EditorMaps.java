package MapEditor;

import Level.Map;
import Maps.CaveMap;
import Maps.DesertMap;
import Maps.ForestMap;
import Maps.SnowMap;
import Maps.StartingMap;
import Maps.TitleScreenMap;
import Maps.FightMap;
import java.util.ArrayList;

public class EditorMaps {
    public static ArrayList<String> getMapNames() {
        return new ArrayList<String>() {{
            add("StartingMap");
            add("TitleScreen");
            add("SnowMap");
            add("ForestMap");
            add("DesertMap");
            add("CaveMap");
            add("FightMap");
        }};
    }

    public static Map getMapByName(String mapName) {
        switch(mapName) {
            case "StartingMap":
                return new StartingMap();
            case "TitleScreen":
                return new TitleScreenMap();
            case "SnowMap":
                return new SnowMap();
            case "ForestMap":
                return new ForestMap();
            case "DesertMap":
                return new DesertMap();
            case "CaveMap":
                return new CaveMap();
            case "FightMap":
                return new FightMap();
            default:
                throw new RuntimeException("Unrecognized map name");
        }
    }
}
