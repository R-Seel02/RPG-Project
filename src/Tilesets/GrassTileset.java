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
public class GrassTileset extends Tileset {

    public GrassTileset() {
        super(ImageLoader.load("GrassTileset.png"), 16, 16, 3);
    }

    @Override
    public ArrayList<MapTileBuilder> defineTiles() {
        ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();

        // grass
        Frame grassFrame = new FrameBuilder(getSubImage(0, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder grassTile = new MapTileBuilder(grassFrame);

        mapTiles.add(grassTile);

        // grass biome world borders
        Frame grassBBorderFrame = new FrameBuilder(getSubImage(0, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder grassBTile = new MapTileBuilder(grassBBorderFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(grassBTile);

        Frame grassTBorderFrame = new FrameBuilder(getSubImage(0, 1))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_VERTICAL)
                .build();

        MapTileBuilder grassTBorderTile = new MapTileBuilder(grassTBorderFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(grassTBorderTile);

        Frame grassLBorderFrame = new FrameBuilder(getSubImage(0,2))
                .withScale(tileScale)
                .build();

        MapTileBuilder grassLBorderTile = new MapTileBuilder(grassLBorderFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(grassLBorderTile);

        Frame grassRBorderFrame = new FrameBuilder(getSubImage(0, 2))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder grassRBorderTile = new MapTileBuilder(grassRBorderFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(grassRBorderTile);

        Frame grassBRBorderFrame = new FrameBuilder(getSubImage(1, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder grassBRBorderTile = new MapTileBuilder(grassBRBorderFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(grassBRBorderTile);

        Frame grassBLBorderFrame = new FrameBuilder(getSubImage(1, 0))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_VERTICAL)
                .build();

        MapTileBuilder grassBLBorderTile = new MapTileBuilder(grassBLBorderFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(grassBLBorderTile);

        Frame grassTLBorderFrame = new FrameBuilder(getSubImage(1, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder grassTLBorderTile = new MapTileBuilder(grassTLBorderFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(grassTLBorderTile);

        Frame grassTRBorderFrame = new FrameBuilder(getSubImage(1, 1))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_VERTICAL)
                .build();

        MapTileBuilder grassTRBorderTile = new MapTileBuilder(grassTRBorderFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(grassTRBorderTile);

        // small pond
        Frame smallPondFrame = new FrameBuilder(getSubImage(1, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder smallPondTile = new MapTileBuilder(smallPondFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(smallPondTile);

        
        
        return mapTiles;
    }
}
