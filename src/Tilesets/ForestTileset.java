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
public class ForestTileset extends Tileset {

    public ForestTileset() {
        super(ImageLoader.load("ForestTileset.png"), 16, 16, 3);
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

        // portal frames
        Frame portalTFrame = new FrameBuilder(getSubImage(0, 3))
                .withScale(tileScale)
                .build();
        MapTileBuilder portalTTile = new MapTileBuilder(portalTFrame);
        mapTiles.add(portalTTile);

        Frame portalBFrame = new FrameBuilder(getSubImage(0, 3))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_VERTICAL)
                .build();
        MapTileBuilder portalBTile = new MapTileBuilder(portalBFrame);
        mapTiles.add(portalBTile);

        // tree frames
        Frame treeRootFrame = new FrameBuilder(getSubImage(0, 4))
                .withScale(tileScale)
                .build();
        MapTileBuilder treeRootTile = new MapTileBuilder(treeRootFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(treeRootTile);

        Frame treeTrunkFrame = new FrameBuilder(getSubImage(1, 3))
                .withScale(tileScale)
                .build();
        MapTileBuilder treeTrunkTile = new MapTileBuilder(grassFrame).withTopLayer(treeTrunkFrame);
        mapTiles.add(treeTrunkTile);

        Frame treeLeavesBLeftFrame = new FrameBuilder(getSubImage(2, 0))
                .withScale(tileScale)
                .build();
        MapTileBuilder treeLeavesBLeftTile = new MapTileBuilder(grassFrame).withTopLayer(treeLeavesBLeftFrame);
        mapTiles.add(treeLeavesBLeftTile);

        Frame treeLeavesBRightFrame = new FrameBuilder(getSubImage(2, 0))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();
        MapTileBuilder treeLeavesBRightTile = new MapTileBuilder(grassFrame).withTopLayer(treeLeavesBRightFrame);
        mapTiles.add(treeLeavesBRightTile);

        Frame treeLeavesTLeftFrame = new FrameBuilder(getSubImage(2, 1))
                .withScale(tileScale)
                .build();
        MapTileBuilder treeLeavesTLeftTile = new MapTileBuilder(grassFrame).withTopLayer(treeLeavesTLeftFrame);
        mapTiles.add(treeLeavesTLeftTile);

        Frame treeLeavesTRightFrame = new FrameBuilder(getSubImage(2, 1))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();
        MapTileBuilder treeLeavesTRightTile = new MapTileBuilder(grassFrame).withTopLayer(treeLeavesTRightFrame);
        mapTiles.add(treeLeavesTRightTile);

        Frame treeLeavesMFrame = new FrameBuilder(getSubImage(2, 2))
                .withScale(tileScale)
                .build();
        MapTileBuilder treeLeavesMTile = new MapTileBuilder(grassFrame).withTopLayer(treeLeavesMFrame);
        mapTiles.add(treeLeavesMTile);

        Frame treeTopFrame = new FrameBuilder(getSubImage(2, 3))
                .withScale(tileScale)
                .build();
        MapTileBuilder treeTopTile = new MapTileBuilder(grassFrame).withTopLayer(treeTopFrame);
        mapTiles.add(treeTopTile);

        Frame treeTopFullFrame = new FrameBuilder(getSubImage(2, 4))
                .withScale(tileScale)
                .build();
        MapTileBuilder treeTopFullTile = new MapTileBuilder(grassFrame).withTopLayer(treeTopFullFrame);
        mapTiles.add(treeTopFullTile);

        Frame treeFullLeavesFrame = new FrameBuilder(getSubImage(3, 0))
                .withScale(tileScale)
                .build();
        MapTileBuilder treeFullLeavesTile = new MapTileBuilder(grassFrame).withTopLayer(treeFullLeavesFrame);
        mapTiles.add(treeFullLeavesTile);

        // snow portal
        Frame snowPortalTFrame = new FrameBuilder(getSubImage(3, 1))
                .withScale(tileScale)
                .build();
        MapTileBuilder snowPortalTTile = new MapTileBuilder(snowPortalTFrame);
        mapTiles.add(snowPortalTTile);

        Frame snowPortalBFrame = new FrameBuilder(getSubImage(3, 1))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_VERTICAL)
                .build();
        MapTileBuilder snowPortalBTile = new MapTileBuilder(snowPortalBFrame);
        mapTiles.add(snowPortalBTile);

        
        
        return mapTiles;
    }
}
