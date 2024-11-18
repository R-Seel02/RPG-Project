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
public class DesertTileset extends Tileset {

    public DesertTileset() {
        super(ImageLoader.load("DesertTileset.png"), 16, 16, 3);
    }

    @Override
    public ArrayList<MapTileBuilder> defineTiles() {
        ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();

        // sand
        Frame sandFrame = new FrameBuilder(getSubImage(0, 0))
                .withScale(tileScale)
                .build();
        MapTileBuilder sandTile = new MapTileBuilder(sandFrame);
        mapTiles.add(sandTile);

        // border
        Frame sandBorderFrame = new FrameBuilder(getSubImage(0, 1))
                .withScale(tileScale)
                .build();
        MapTileBuilder sandBorderTile = new MapTileBuilder(sandBorderFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(sandBorderTile);

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
        
        
        return mapTiles;
    }
}
