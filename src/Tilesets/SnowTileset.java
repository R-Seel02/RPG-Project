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

        Frame snowBorderBFrame = new FrameBuilder(getSubImage(2,0))
                .withScale(tileScale)
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

        Frame snowBorderLFrame = new FrameBuilder(getSubImage(2,1))
                .withScale(tileScale)
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

        Frame snowBorderTLFrame = new FrameBuilder(getSubImage(2,2))
                .withScale(tileScale)
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

        Frame snowBorderBLFrame = new FrameBuilder(getSubImage(2,4))
                .withScale(tileScale)
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

        Frame icePondBRFrame = new FrameBuilder(getSubImage(3, 1))
                .withScale(tileScale)
                .build();
        MapTileBuilder icePondBRTile = new MapTileBuilder(icePondBRFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(icePondBRTile);

        Frame icePondTLFrame = new FrameBuilder(getSubImage(2, 3))
                .withScale(tileScale)
                .build();
        MapTileBuilder icePondTLTile = new MapTileBuilder(icePondTLFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(icePondTLTile);

        Frame icePondTRFrame = new FrameBuilder(getSubImage(3, 0))
                .withScale(tileScale)
                .build();
        MapTileBuilder icePondTRTile = new MapTileBuilder(icePondTRFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(icePondTRTile);

        // snow cabin tiles
        Frame cabinWallLFrame = new FrameBuilder(getSubImage(3, 2))
                .withScale(tileScale)
                .build();
        MapTileBuilder cabinWallLTile = new MapTileBuilder(cabinWallLFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(cabinWallLTile);

        Frame cabinWallRFrame = new FrameBuilder(getSubImage(3, 2))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();
        MapTileBuilder cabinWallRTile = new MapTileBuilder(cabinWallRFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(cabinWallRTile);

        Frame cabinWindowFrame = new FrameBuilder(getSubImage(3, 3))
                .withScale(tileScale)
                .build();
        MapTileBuilder cabinWindowTile = new MapTileBuilder(cabinWindowFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(cabinWindowTile);

        Frame cabinDoorFrame = new FrameBuilder(getSubImage(3, 4))
                .withScale(tileScale)
                .build();
        MapTileBuilder cabinDoorTile = new MapTileBuilder(cabinDoorFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(cabinDoorTile);

        Frame cabinRoofAngleLFrame = new FrameBuilder(getSubImage(4, 0))
                .withScale(tileScale)
                .build();
        MapTileBuilder cabinRoofAngleLTile = new MapTileBuilder(cabinRoofAngleLFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(cabinRoofAngleLTile);

        Frame cabinRoofAngleRFrame = new FrameBuilder(getSubImage(4, 0))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();
        MapTileBuilder cabinRoofAngleRTile = new MapTileBuilder(cabinRoofAngleRFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(cabinRoofAngleRTile);

        Frame cabinRoofLFrame = new FrameBuilder(getSubImage(4, 1))
                .withScale(tileScale)
                .build();
        MapTileBuilder cabinRoofLTile = new MapTileBuilder(snowFrame).withTopLayer(cabinRoofLFrame);
        mapTiles.add(cabinRoofLTile);

        Frame cabinRoofRFrame = new FrameBuilder(getSubImage(4, 1))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();
        MapTileBuilder cabinRoofRTile = new MapTileBuilder(snowFrame).withTopLayer(cabinRoofRFrame);
        mapTiles.add(cabinRoofRTile);

        Frame cabinWallFrame = new FrameBuilder(getSubImage(4, 2))
                .withScale(tileScale)
                .build();
        MapTileBuilder cabinWallTile = new MapTileBuilder(cabinWallFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(cabinWallTile);

        Frame combinedRoofLFrame = new FrameBuilder(getSubImage(4, 3))
                .withScale(tileScale)
                .build();
        MapTileBuilder combinedRoofLTile = new MapTileBuilder(snowFrame).withTopLayer(combinedRoofLFrame);
        mapTiles.add(combinedRoofLTile);

        Frame combinedRoofRFrame = new FrameBuilder(getSubImage(4, 3))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();
        MapTileBuilder combinedRoofRTile = new MapTileBuilder(snowFrame).withTopLayer(combinedRoofRFrame);
        mapTiles.add(combinedRoofRTile);

        Frame roofWallMiddleFrame = new FrameBuilder(getSubImage(4, 4))
                .withScale(tileScale)
                .build();
        MapTileBuilder roofWallMiddleTile = new MapTileBuilder(roofWallMiddleFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(roofWallMiddleTile);

        Frame cabinRoofMFrame = new FrameBuilder(getSubImage(5, 0))
                .withScale(tileScale)
                .build();
        MapTileBuilder cabinRoofMTile = new MapTileBuilder(snowFrame).withTopLayer(cabinRoofMFrame);
        mapTiles.add(cabinRoofMTile);

        Frame cabinRearRoofLFrame = new FrameBuilder(getSubImage(5, 2))
                .withScale(tileScale)
                .build();
        MapTileBuilder cabinRearRoofLTile = new MapTileBuilder(snowFrame).withTopLayer(cabinRearRoofLFrame);
        mapTiles.add(cabinRearRoofLTile);

        Frame cabinRearRoofRFrame = new FrameBuilder(getSubImage(5, 2))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();
        MapTileBuilder cabinRearRoofRTile = new MapTileBuilder(snowFrame).withTopLayer(cabinRearRoofRFrame);
        mapTiles.add(cabinRearRoofRTile);

        Frame brokenIceFrame = new FrameBuilder(getSubImage(5, 3))
                .withScale(tileScale)
                .build();
        MapTileBuilder brokenIceTile = new MapTileBuilder(brokenIceFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(brokenIceTile);
                

        return mapTiles;
    }
}
