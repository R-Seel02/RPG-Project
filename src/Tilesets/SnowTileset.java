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

        // tree frames
        Frame treeRootFrame = new FrameBuilder(getSubImage(5, 5))
                .withScale(tileScale)
                .build();
        MapTileBuilder treeRootTile = new MapTileBuilder(treeRootFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(treeRootTile);

        Frame treeTrunkFrame = new FrameBuilder(getSubImage(6, 5))
                .withScale(tileScale)
                .build();
        MapTileBuilder treeTrunkTile = new MapTileBuilder(snowFrame).withTopLayer(treeTrunkFrame);
        mapTiles.add(treeTrunkTile);

        Frame treeLeavesBLeftFrame = new FrameBuilder(getSubImage(0, 5))
                .withScale(tileScale)
                .build();
        MapTileBuilder treeLeavesBLeftTile = new MapTileBuilder(snowFrame).withTopLayer(treeLeavesBLeftFrame);
        mapTiles.add(treeLeavesBLeftTile);

        Frame treeLeavesBRightFrame = new FrameBuilder(getSubImage(0, 5))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();
        MapTileBuilder treeLeavesBRightTile = new MapTileBuilder(snowFrame).withTopLayer(treeLeavesBRightFrame);
        mapTiles.add(treeLeavesBRightTile);

        Frame treeLeavesTLeftFrame = new FrameBuilder(getSubImage(1, 5))
                .withScale(tileScale)
                .build();
        MapTileBuilder treeLeavesTLeftTile = new MapTileBuilder(snowFrame).withTopLayer(treeLeavesTLeftFrame);
        mapTiles.add(treeLeavesTLeftTile);

        Frame treeLeavesTRightFrame = new FrameBuilder(getSubImage(1, 5))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();
        MapTileBuilder treeLeavesTRightTile = new MapTileBuilder(snowFrame).withTopLayer(treeLeavesTRightFrame);
        mapTiles.add(treeLeavesTRightTile);

        Frame treeLeavesMFrame = new FrameBuilder(getSubImage(2, 5))
                .withScale(tileScale)
                .build();
        MapTileBuilder treeLeavesMTile = new MapTileBuilder(snowFrame).withTopLayer(treeLeavesMFrame);
        mapTiles.add(treeLeavesMTile);

        Frame treeTopFrame = new FrameBuilder(getSubImage(3, 5))
                .withScale(tileScale)
                .build();
        MapTileBuilder treeTopTile = new MapTileBuilder(snowFrame).withTopLayer(treeTopFrame);
        mapTiles.add(treeTopTile);

        Frame treeTopFullFrame = new FrameBuilder(getSubImage(4, 5))
                .withScale(tileScale)
                .build();
        MapTileBuilder treeTopFullTile = new MapTileBuilder(snowFrame).withTopLayer(treeTopFullFrame);
        mapTiles.add(treeTopFullTile);

        Frame treeFullLeavesFrame = new FrameBuilder(getSubImage(5, 4))
                .withScale(tileScale)
                .build();
        MapTileBuilder treeFullLeavesTile = new MapTileBuilder(snowFrame).withTopLayer(treeFullLeavesFrame);
        mapTiles.add(treeFullLeavesTile);

        // desert portal
        Frame desertPortalTFrame = new FrameBuilder(getSubImage(6, 0))
                .withScale(tileScale)
                .build();
        MapTileBuilder desertPortalTTile = new MapTileBuilder(desertPortalTFrame);
        mapTiles.add(desertPortalTTile);

        Frame desertPortalBFrame = new FrameBuilder(getSubImage(6, 0))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_VERTICAL)
                .build();
        MapTileBuilder desertPortalBTile = new MapTileBuilder(desertPortalBFrame);
        mapTiles.add(desertPortalBTile);
                

        return mapTiles;
    }
}
