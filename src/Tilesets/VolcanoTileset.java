package Tilesets;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import Level.TileType;
import Level.Tileset;
import java.util.ArrayList;

// This class represents a "common" tileset of standard tiles defined in the CommonTileset.png file
public class VolcanoTileset extends Tileset {

    public VolcanoTileset() {
        super(ImageLoader.load("VolcanoTileset.png"), 16, 16, 3);
    }

    @Override
    public ArrayList<MapTileBuilder> defineTiles() {
        ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();

        // magma
        Frame sandFrame = new FrameBuilder(getSubImage(0, 0))
                .withScale(tileScale)
                .build();
        MapTileBuilder sandTile = new MapTileBuilder(sandFrame);
        mapTiles.add(sandTile);

        // portal frames
        Frame startingPortalTFrame = new FrameBuilder(getSubImage(0, 3))
                .withScale(tileScale)
                .build();
        MapTileBuilder startingPortalTTile = new MapTileBuilder(startingPortalTFrame);
        mapTiles.add(startingPortalTTile);

        Frame startingPortalBFrame = new FrameBuilder(getSubImage(0, 3))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_VERTICAL)
                .build();
        MapTileBuilder startingPortalBTile = new MapTileBuilder(startingPortalBFrame);
        mapTiles.add(startingPortalBTile);

        // lava
        Frame lavaFrame = new FrameBuilder(getSubImage(0, 1))
                .withScale(tileScale)
                .build();
        MapTileBuilder lavaTile = new MapTileBuilder(lavaFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(lavaTile);
        
        
        return mapTiles;
    }
}
