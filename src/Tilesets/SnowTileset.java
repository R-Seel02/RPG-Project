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
public class SnowTileset extends Tileset {

    public SnowTileset() {
        super(ImageLoader.load("SnowTileset.png"), 16, 16, 3);
    }

    @Override
    public ArrayList<MapTileBuilder> defineTiles() {
        ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();

        // snow
        Frame snowFrame = new FrameBuilder(getSubImage(0, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder snowTile = new MapTileBuilder(snowFrame);

        mapTiles.add(snowTile);

        // icy water border
        Frame iceBorderFrame = new FrameBuilder(getSubImage(1,2))
                .withScale(tileScale)
                .build();

        MapTileBuilder iceBorderTile = new MapTileBuilder(iceBorderFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(iceBorderTile);


        // barrier
        Frame barrierFrame = new FrameBuilder(getSubImage(0,1))
                .withScale(tileScale)
                .build();

        MapTileBuilder barrierTile = new MapTileBuilder(barrierFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(barrierTile);

        // ice puddle
        Frame icePuddleFrame = new FrameBuilder(getSubImage(0,2))
                .withScale(tileScale)
                .build();

        MapTileBuilder icePuddleTile = new MapTileBuilder(icePuddleFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(icePuddleTile);



        // snow edges of map
        Frame snowBorderTFrame = new FrameBuilder(getSubImage(0,3))
                .withScale(tileScale)
                .build();

        MapTileBuilder snowBorderTTile = new MapTileBuilder(snowBorderTFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(snowBorderTTile);

        Frame snowBorderBFrame = new FrameBuilder(getSubImage(0,3))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_VERTICAL)
                .build();

        MapTileBuilder snowBorderBTile = new MapTileBuilder(snowBorderBFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(snowBorderBTile);

        Frame snowBorderRFrame = new FrameBuilder(getSubImage(0,4))
                .withScale(tileScale)
                .build();

        MapTileBuilder snowBorderRTile = new MapTileBuilder(snowBorderRFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(snowBorderRTile);

        Frame snowBorderLFrame = new FrameBuilder(getSubImage(0,4))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder snowBorderLTile = new MapTileBuilder(snowBorderLFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(snowBorderLTile);

        Frame snowBorderTRFrame = new FrameBuilder(getSubImage(1,0))
                .withScale(tileScale)
                .build();

        MapTileBuilder snowBorderTRTile = new MapTileBuilder(snowBorderTRFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(snowBorderTRTile);

        Frame snowBorderTLFrame = new FrameBuilder(getSubImage(1,0))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder snowBorderTLTile = new MapTileBuilder(snowBorderTLFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(snowBorderTLTile);

        Frame snowBorderBRFrame = new FrameBuilder(getSubImage(1,1))
                .withScale(tileScale)
                .build();

        MapTileBuilder snowBorderBRTile = new MapTileBuilder(snowBorderBRFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(snowBorderBRTile);

        Frame snowBorderBLFrame = new FrameBuilder(getSubImage(1,1))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder snowBorderBLTile = new MapTileBuilder(snowBorderBLFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(snowBorderBLTile);



        
        // grass biome portal
        Frame grassPortalTFrame = new FrameBuilder(getSubImage(1, 3))
                .withScale(tileScale)
                .build();
        MapTileBuilder grassPortalTTile = new MapTileBuilder(grassPortalTFrame);
        mapTiles.add(grassPortalTTile);

        Frame grassPortalBFrame = new FrameBuilder(getSubImage(1, 3))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_VERTICAL)
                .build();
        MapTileBuilder grassPortalBTile = new MapTileBuilder(grassPortalBFrame);
        mapTiles.add(grassPortalBTile);

        // ice pond tiles
        Frame icePondBLFrame = new FrameBuilder(getSubImage(1, 4))
                .withScale(tileScale)
                .build();
        MapTileBuilder icePondBLTile = new MapTileBuilder(icePondBLFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(icePondBLTile);

        Frame icePondBRFrame = new FrameBuilder(getSubImage(1, 4))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();
        MapTileBuilder icePondBRTile = new MapTileBuilder(icePondBRFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(icePondBRTile);

        Frame icePondTLFrame = new FrameBuilder(getSubImage(1, 4))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_VERTICAL)
                .build();
        MapTileBuilder icePondTLTile = new MapTileBuilder(icePondTLFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(icePondTLTile);

        Frame icePondTRFrame = new FrameBuilder(getSubImage(1, 4))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_H_AND_V)
                .build();
        MapTileBuilder icePondTRTile = new MapTileBuilder(icePondTRFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(icePondTRTile);

        
        return mapTiles;
    }
}
