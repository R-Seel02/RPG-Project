package MapEditor;

import Level.Map;
import Maps.SnowMap;
import Maps.TestMap;
import Maps.TitleScreenMap;
import Maps.GrassMap;
import java.util.ArrayList;

public class EditorMaps {
    public static ArrayList<String> getMapNames() {
        return new ArrayList<String>() {{
            add("TestMap");
            add("TitleScreen");
            add("SnowMap");
            add("GrassMap");
        }};
    }

    public static Map getMapByName(String mapName) {
        switch(mapName) {
            case "TestMap":
                return new TestMap();
            case "TitleScreen":
                return new TitleScreenMap();
            case "SnowMap":
                return new SnowMap();
            case "GrassMap":
                return new GrassMap();
            default:
                throw new RuntimeException("Unrecognized map name");
        }
    }
}
