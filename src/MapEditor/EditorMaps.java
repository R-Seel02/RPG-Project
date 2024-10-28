package MapEditor;

import Level.Map;
import Maps.AutumnMap;
import Maps.CaveMap;
import Maps.GrassMap;
import Maps.SnowMap;
import Maps.StartingMap;
import Maps.TitleScreenMap;
import java.util.ArrayList;

public class EditorMaps {
    public static ArrayList<String> getMapNames() {
        return new ArrayList<String>() {{
            add("StartingMap");
            add("TitleScreen");
            add("SnowMap");
            add("GrassMap");
            add("AutumnMap");
            add("CaveMap");
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
            case "GrassMap":
                return new GrassMap();
            case "AutumnMap":
                return new AutumnMap();
            case "CaveMap":
                return new CaveMap();
            default:
                throw new RuntimeException("Unrecognized map name");
        }
    }
}
