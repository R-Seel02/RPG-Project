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

        // pyramid
        Frame pyramidDoorFrame = new FrameBuilder(getSubImage(0, 2))
                .withScale(tileScale)
                .build();
        MapTileBuilder pyramidDoorTile = new MapTileBuilder(pyramidDoorFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(pyramidDoorTile);
        
        Frame pyramidDoorLFrame = new FrameBuilder(getSubImage(0, 4))
                .withScale(tileScale)
                .build();
        MapTileBuilder pyramidDoorLTile = new MapTileBuilder(pyramidDoorLFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(pyramidDoorLTile);

        Frame pyramidDoorRFrame = new FrameBuilder(getSubImage(0, 4))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();
        MapTileBuilder pyramidDoorRTile = new MapTileBuilder(pyramidDoorRFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(pyramidDoorRTile);

        Frame pyramidDoorTLFrame = new FrameBuilder(getSubImage(1, 0))
                .withScale(tileScale)
                .build();
        MapTileBuilder pyramidDoorTLTile = new MapTileBuilder(pyramidDoorTLFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(pyramidDoorTLTile);

        Frame pyramidDoorTRFrame = new FrameBuilder(getSubImage(1, 0))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();
        MapTileBuilder pyramidDoorTRTile = new MapTileBuilder(pyramidDoorTRFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(pyramidDoorTRTile);

        Frame pyramidDoorTMiddleFrame = new FrameBuilder(getSubImage(1, 1))
                .withScale(tileScale)
                .build();
        MapTileBuilder pyramidDoorTMiddleTile = new MapTileBuilder(pyramidDoorTMiddleFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(pyramidDoorTMiddleTile);

        Frame pyramidFloorFrame = new FrameBuilder(getSubImage(1, 2))
                .withScale(tileScale)
                .build();
        MapTileBuilder pyramidFloorTile = new MapTileBuilder(pyramidFloorFrame);
        mapTiles.add(pyramidFloorTile);

        Frame pyramidWallFrame = new FrameBuilder(getSubImage(1, 3))
                .withScale(tileScale)
                .build();
        MapTileBuilder pyramidWallTile = new MapTileBuilder(pyramidWallFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(pyramidWallTile);
        
        return mapTiles;
    }
}
