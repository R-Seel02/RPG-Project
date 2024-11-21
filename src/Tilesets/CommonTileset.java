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
public class CommonTileset extends Tileset {

    public CommonTileset() {
        super(ImageLoader.load("CommonTileset.png"), 16, 16, 3);
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

        // sign
        Frame signFrame = new FrameBuilder(getSubImage(3, 0))
                .withScale(tileScale)
                .withBounds(1, 2, 14, 14)
                .build();
        MapTileBuilder signTile = new MapTileBuilder(signFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(signTile);

        // sand
        Frame sandFrame = new FrameBuilder(getSubImage(0, 1))
                .withScale(tileScale)
                .build();
        MapTileBuilder sandTile = new MapTileBuilder(sandFrame);
        mapTiles.add(sandTile);

        // rock
        Frame rockFrame = new FrameBuilder(getSubImage(3, 1))
                .withScale(tileScale)
                .build();
        MapTileBuilder rockTile = new MapTileBuilder(rockFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(rockTile);

        // tree trunk with full hole
        Frame gravelFrame = new FrameBuilder(getSubImage(2, 2))
                .withScale(tileScale)
                .build();
        MapTileBuilder gravelTile = new MapTileBuilder(gravelFrame);
        mapTiles.add(gravelTile);

        // left end branch
        Frame leftEndBranchFrame = new FrameBuilder(getSubImage(2, 4))
                .withScale(tileScale)
                .withBounds(0, 6, 16, 4)
                .build();
        MapTileBuilder leftEndBranchTile = new MapTileBuilder(grassFrame)
                .withTopLayer(leftEndBranchFrame)
                .withTileType(TileType.PASSABLE);
        mapTiles.add(leftEndBranchTile);

        // right end branch
        Frame rightEndBranchFrame = new FrameBuilder(getSubImage(2, 4))
                .withScale(tileScale)
                .withBounds(0, 6, 16, 4)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();
        MapTileBuilder rightEndBranchTile = new MapTileBuilder(grassFrame)
                .withTopLayer(rightEndBranchFrame)
                .withTileType(TileType.PASSABLE);
        mapTiles.add(rightEndBranchTile);
        
        // tree trunk
        Frame treeTrunkFrame = new FrameBuilder(getSubImage(1, 0))
                .withScale(tileScale)
                .build();
        MapTileBuilder treeTrunkTile = new MapTileBuilder(grassFrame)
                .withTopLayer(treeTrunkFrame)
                .withTileType(TileType.PASSABLE);
        mapTiles.add(treeTrunkTile);

        // tree top leaves
        Frame treeTopLeavesFrame = new FrameBuilder(getSubImage(1, 1))
                .withScale(tileScale)
                .build();
        MapTileBuilder treeTopLeavesTile = new MapTileBuilder(grassFrame)
                .withTopLayer(treeTopLeavesFrame)
                .withTileType(TileType.PASSABLE);
        mapTiles.add(treeTopLeavesTile);
        
        // yellow flower
        Frame[] redFlowerFrames = new Frame[] {
                new FrameBuilder(getSubImage(1, 2), 65)
                    .withScale(tileScale)
                    .build(),
                new FrameBuilder(getSubImage(1, 3), 45)
                        .withScale(tileScale)
                        .build(),
                new FrameBuilder(getSubImage(1, 4), 25)
                        .withScale(tileScale)
                        .build(),
                new FrameBuilder(getSubImage(1, 3), 25)
                        .withScale(tileScale)
                        .build()
        };
        MapTileBuilder redFlowerTile = new MapTileBuilder(redFlowerFrames);
        mapTiles.add(redFlowerTile);

        // wall
        Frame[] blueFlowerFrames = new Frame[] {
                new FrameBuilder(getSubImage(0, 2), 100)
                        .withScale(tileScale)
                        .build(),
                new FrameBuilder(getSubImage(0, 3), 30)
                        .withScale(tileScale)
                        .build(),
                new FrameBuilder(getSubImage(0, 4), 40)
                        .withScale(tileScale)
                        .build(),
                new FrameBuilder(getSubImage(0, 3), 30)
                        .withScale(tileScale)
                        .build()
        };
        MapTileBuilder blueFlowerTile = new MapTileBuilder(blueFlowerFrames);
        mapTiles.add(blueFlowerTile);

        // middle branch
        Frame middleBranchFrame = new FrameBuilder(getSubImage(2, 3))
                .withScale(tileScale)
                .withBounds(0, 6, 16, 4)
                .build();
        MapTileBuilder middleBranchTile = new MapTileBuilder(grassFrame)
                .withTopLayer(middleBranchFrame)
                .withTileType(TileType.PASSABLE);
        mapTiles.add(middleBranchTile);

        // tree trunk bottom
        Frame treeTrunkBottomFrame = new FrameBuilder(getSubImage(2, 0))
                .withScale(tileScale)
                .build();
        MapTileBuilder treeTrunkBottomTile = new MapTileBuilder(treeTrunkBottomFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(treeTrunkBottomTile);

        // mushrooms
        Frame mushroomFrame = new FrameBuilder(getSubImage(2, 1))
                .withScale(tileScale)
                .build();
        MapTileBuilder mushroomTile = new MapTileBuilder(mushroomFrame)
                .withTileType(TileType.PASSABLE);
        mapTiles.add(mushroomTile);


        // grey rock
        Frame greyRockFrame = new FrameBuilder(getSubImage(3, 2))
                .withScale(tileScale)
                .build();
        MapTileBuilder greyRockTile = new MapTileBuilder(greyRockFrame)
                .withTileType(TileType.PASSABLE);
        mapTiles.add(greyRockTile);

        // throne top
        Frame throneTopFrame = new FrameBuilder(getSubImage(3, 3))
                .withScale(tileScale)
                .build();
        MapTileBuilder throneTopTile = new MapTileBuilder(throneTopFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(throneTopTile);

        // house body
        Frame houseBodyFrame = new FrameBuilder(getSubImage(3, 4))
                .withScale(tileScale)
                .build();
        MapTileBuilder houseBodyTile = new MapTileBuilder(houseBodyFrame)
                .withTopLayer(houseBodyFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(houseBodyTile);

        // house roof body
        Frame houseRoofBodyFrame = new FrameBuilder(getSubImage(4, 0))
                .withScale(tileScale)
                .build();
        MapTileBuilder houseRoofBodyTile = new MapTileBuilder(grassFrame)
                .withTopLayer(houseRoofBodyFrame)
                .withTileType(TileType.PASSABLE);
        mapTiles.add(houseRoofBodyTile);

        // left house roof
        Frame leftHouseRoofFrame = new FrameBuilder(getSubImage(4, 1))
                .withScale(tileScale)
                .build();
        MapTileBuilder leftHouseRoofTile = new MapTileBuilder(grassFrame)
                .withTopLayer(leftHouseRoofFrame)
                .withTileType(TileType.PASSABLE);
        mapTiles.add(leftHouseRoofTile);

        // right house roof
        Frame rightHouseRoofFrame = new FrameBuilder(getSubImage(4, 1))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();
        MapTileBuilder rightHouseRoofTile = new MapTileBuilder(grassFrame)
                .withTopLayer(rightHouseRoofFrame)
                .withTileType(TileType.PASSABLE);
        mapTiles.add(rightHouseRoofTile);

        // left window
        Frame leftWindowFrame = new FrameBuilder(getSubImage(4, 2))
                .withScale(tileScale)
                .build();
        MapTileBuilder leftWindowTile = new MapTileBuilder(leftWindowFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(leftWindowTile);

        // passable house body
        Frame passableHouseBodyFrame = new FrameBuilder(getSubImage(3, 4))
                .withScale(tileScale)
                .build();
        MapTileBuilder passableHouseBodyTile = new MapTileBuilder(passableHouseBodyFrame);
        mapTiles.add(passableHouseBodyTile);

        // door
        Frame doorFrame = new FrameBuilder(getSubImage(4, 3))
                .withScale(tileScale)
                .build();
        MapTileBuilder doorTile = new MapTileBuilder(doorFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(doorTile);

        // top water
        Frame[] topWaterFrames = new Frame[] {
            new FrameBuilder(getSubImage(5, 0), 65)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(5, 1), 65)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(5, 2), 65)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(5, 1), 65)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(5, 0), 65)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(5, 3), 65)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(5, 4), 65)
                    .withScale(tileScale)
                    .build(),
            new FrameBuilder(getSubImage(5, 3), 65)
                    .withScale(tileScale)
                    .build()
        };

        MapTileBuilder topWaterTile = new MapTileBuilder(topWaterFrames)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(topWaterTile);


        // horizontal gravel path
        Frame gravelPathHFrame = new FrameBuilder(getSubImage(0, 5))
                .withScale(tileScale)
                .build();
        MapTileBuilder gravelPathHTile = new MapTileBuilder(gravelPathHFrame);
        mapTiles.add(gravelPathHTile);

        // vertical gravel path
        Frame gravelPathVFrame = new FrameBuilder(getSubImage(1, 5))
                .withScale(tileScale)
                .build();
        MapTileBuilder gravelPathVTile = new MapTileBuilder(gravelPathVFrame);
        mapTiles.add(gravelPathVTile);

        // cross section gravel path
        Frame gravelPathXFrame = new FrameBuilder(getSubImage(2, 5))
                .withScale(tileScale)
                .build();
        MapTileBuilder gravelPathXTile = new MapTileBuilder(gravelPathXFrame);
        mapTiles.add(gravelPathXTile);

        // invisible barrier
        Frame barrierFrame = new FrameBuilder(getSubImage(3, 5))
                .withScale(tileScale)
                .build();
        MapTileBuilder barrierTile = new MapTileBuilder(barrierFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(barrierTile);

        Frame[] chimneyFrames = new Frame[] {
                new FrameBuilder(getSubImage(4, 5), 40)
                        .withScale(tileScale)
                        .build(),
                new FrameBuilder(getSubImage(5, 5), 40)
                        .withScale(tileScale)
                        .build()
        };

        MapTileBuilder chimneyTile = new MapTileBuilder(grassFrame).withTopLayer(chimneyFrames);
        mapTiles.add(chimneyTile);

        Frame logoTopTFrame = new FrameBuilder(getSubImage(0,6))
                .withScale(tileScale)
                .build();
        MapTileBuilder logoTopTTile = new MapTileBuilder(grassFrame).withTopLayer(logoTopTFrame);
        mapTiles.add(logoTopTTile);

        Frame logoBottomTFrame = new FrameBuilder(getSubImage(1,6))
                .withScale(tileScale)
                .build();
        MapTileBuilder logoBottomTTile = new MapTileBuilder(grassFrame).withTopLayer(logoBottomTFrame);
        mapTiles.add(logoBottomTTile);

        Frame logoHFrame = new FrameBuilder(getSubImage(0,7))
                .withScale(tileScale)
                .build();
        MapTileBuilder logoHTile = new MapTileBuilder(grassFrame).withTopLayer(logoHFrame);
        mapTiles.add(logoHTile);

        Frame logoIFrame = new FrameBuilder(getSubImage(0,8))
                .withScale(tileScale)
                .build();
        MapTileBuilder logoITile = new MapTileBuilder(grassFrame).withTopLayer(logoIFrame);
        mapTiles.add(logoITile);

        Frame logoMFrame = new FrameBuilder(getSubImage(1,7))
                .withScale(tileScale)
                .build();
        MapTileBuilder logoMTile = new MapTileBuilder(grassFrame).withTopLayer(logoMFrame);
        mapTiles.add(logoMTile);

        Frame logoNFrame = new FrameBuilder(getSubImage(1,8))
                .withScale(tileScale)
                .build();
        MapTileBuilder logoNTile = new MapTileBuilder(grassFrame).withTopLayer(logoNFrame);
        mapTiles.add(logoNTile);

        Frame logoEFrame = new FrameBuilder(getSubImage(2,7))
                .withScale(tileScale)
                .build();
        MapTileBuilder logoETile = new MapTileBuilder(grassFrame).withTopLayer(logoEFrame);
        mapTiles.add(logoETile);

        Frame logoUFrame = new FrameBuilder(getSubImage(2,8))
                .withScale(tileScale)
                .build();
        MapTileBuilder logoUTile = new MapTileBuilder(grassFrame).withTopLayer(logoUFrame);
        mapTiles.add(logoUTile);

        Frame logoRFrame = new FrameBuilder(getSubImage(2,6))
                .withScale(tileScale)
                .build();
        MapTileBuilder logoRTile = new MapTileBuilder(grassFrame).withTopLayer(logoRFrame);
        mapTiles.add(logoRTile);

        Frame logoTHFrame = new FrameBuilder(getSubImage(3,6))
                .withScale(tileScale)
                .build();
        MapTileBuilder logoTHTile = new MapTileBuilder(grassFrame).withTopLayer(logoTHFrame);
        mapTiles.add(logoTHTile);

        Frame logoELFrame = new FrameBuilder(getSubImage(3,7))
                .withScale(tileScale)
                .build();
        MapTileBuilder logoELTile = new MapTileBuilder(grassFrame).withTopLayer(logoELFrame);
        mapTiles.add(logoELTile);

        Frame logoEGEFrame = new FrameBuilder(getSubImage(3,8))
                .withScale(tileScale)
                .build();
        MapTileBuilder logoEGETile = new MapTileBuilder(grassFrame).withTopLayer(logoEGEFrame);
        mapTiles.add(logoEGETile);

        Frame logoNDFrame = new FrameBuilder(getSubImage(4,6))
                .withScale(tileScale)
                .build();
        MapTileBuilder logoNDTile = new MapTileBuilder(grassFrame).withTopLayer(logoNDFrame);
        mapTiles.add(logoNDTile);

        Frame logoOFFrame = new FrameBuilder(getSubImage(4,7))
                .withScale(tileScale)
                .build();
        MapTileBuilder logoOFTile = new MapTileBuilder(grassFrame).withTopLayer(logoOFFrame);
        mapTiles.add(logoOFTile);

        // snow portal frame
        Frame snowPortalTFrame = new FrameBuilder(getSubImage(4,8))
                .withScale(tileScale)
                .build();
        MapTileBuilder snowPortalTTile = new MapTileBuilder(snowPortalTFrame);
        mapTiles.add(snowPortalTTile);

        // pond
        Frame pondTLFrame = new FrameBuilder(getSubImage(5, 0))
                .withScale(tileScale)
                .build();
        MapTileBuilder pondTLTile = new MapTileBuilder(pondTLFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(pondTLTile);

        Frame pondTRFrame = new FrameBuilder(getSubImage(5, 0))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();
        MapTileBuilder pondTRTile = new MapTileBuilder(pondTRFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(pondTRTile);

        Frame pondBRFrame = new FrameBuilder(getSubImage(5, 1))
                .withScale(tileScale)
                .build();
        MapTileBuilder pondBRTile = new MapTileBuilder(pondBRFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(pondBRTile);

        Frame pondBLFrame = new FrameBuilder(getSubImage(5, 1))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();
        MapTileBuilder pondBLTile = new MapTileBuilder(pondBLFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(pondBLTile);

        Frame pondFrame = new FrameBuilder(getSubImage(5, 2))
                .withScale(tileScale)
                .build();
        MapTileBuilder pondTile = new MapTileBuilder(pondFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(pondTile);

        Frame pondLFrame = new FrameBuilder(getSubImage(5, 3))
                .withScale(tileScale)
                .build();
        MapTileBuilder pondLTile = new MapTileBuilder(pondLFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(pondLTile);

        Frame pondRFrame = new FrameBuilder(getSubImage(5, 3))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();
        MapTileBuilder pondRTile = new MapTileBuilder(pondRFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(pondRTile);

        Frame pondTFrame = new FrameBuilder(getSubImage(5, 4))
                .withScale(tileScale)
                .build();
        MapTileBuilder pondTTile = new MapTileBuilder(pondTFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(pondTTile);

        Frame pondBFrame = new FrameBuilder(getSubImage(5, 4))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_VERTICAL)
                .build();
        MapTileBuilder pondBTile = new MapTileBuilder(pondBFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(pondBTile);


        // fountain frames
        Frame[] fountainBLFrames = new Frame[] {
                new FrameBuilder(getSubImage(6, 0), 40)
                        .withScale(tileScale)
                        .build(),
                new FrameBuilder(getSubImage(6, 1), 40)
                        .withScale(tileScale)
                        .build()
        };
        MapTileBuilder fountainBLTiles = new MapTileBuilder(fountainBLFrames)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(fountainBLTiles);

        Frame[] fountainBRFrames = new Frame[] {
                new FrameBuilder(getSubImage(6, 0), 40)
                        .withScale(tileScale)
                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                        .build(),
                new FrameBuilder(getSubImage(6, 1), 40)
                        .withScale(tileScale)
                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                        .build()
        };
        MapTileBuilder fountainBRTiles = new MapTileBuilder(fountainBRFrames)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(fountainBRTiles);

        Frame[] fountainTLFrames = new Frame[] {
                new FrameBuilder(getSubImage(6, 2), 40)
                        .withScale(tileScale)
                        .build(),
                new FrameBuilder(getSubImage(6, 3), 40)
                        .withScale(tileScale)
                        .build()
        };
        MapTileBuilder fountainTLTiles = new MapTileBuilder(fountainTLFrames)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(fountainTLTiles);

        Frame[] fountainTRFrames = new Frame[] {
                new FrameBuilder(getSubImage(6, 2), 40)
                        .withScale(tileScale)
                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                        .build(),
                new FrameBuilder(getSubImage(6, 3), 40)
                        .withScale(tileScale)
                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                        .build()
        };
        MapTileBuilder fountainTRTiles = new MapTileBuilder(fountainTRFrames)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(fountainTRTiles);

        // snow portal frame
        Frame snowPortalBFrame = new FrameBuilder(getSubImage(4,8))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_VERTICAL)
                .build();
        MapTileBuilder snowPortalBTile = new MapTileBuilder(snowPortalBFrame);
        mapTiles.add(snowPortalBTile);


        // forest portal frames
        Frame forestPortalTFrame = new FrameBuilder(getSubImage(5,8))
                .withScale(tileScale)
                .build();
        MapTileBuilder forestPortalTTile = new MapTileBuilder(forestPortalTFrame);
        mapTiles.add(forestPortalTTile);

        Frame forestPortalBFrame = new FrameBuilder(getSubImage(5,8))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_VERTICAL)
                .build();
        MapTileBuilder forestPortalBTile = new MapTileBuilder(forestPortalBFrame);
        mapTiles.add(forestPortalBTile);

        // desert portal frames
        Frame desertPortalTFrame = new FrameBuilder(getSubImage(6,8))
                .withScale(tileScale)
                .build();
        MapTileBuilder desertPortalTTile = new MapTileBuilder(desertPortalTFrame);
        mapTiles.add(desertPortalTTile);

        Frame desertPortalBFrame = new FrameBuilder(getSubImage(6,8))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_VERTICAL)
                .build();
        MapTileBuilder desertPortalBTile = new MapTileBuilder(desertPortalBFrame);
        mapTiles.add(desertPortalBTile);

        // boss portal
        Frame bossPortalTFrame = new FrameBuilder(getSubImage(5, 7))
                .withScale(tileScale)
                .build();
        MapTileBuilder bossPortalTTile = new MapTileBuilder(bossPortalTFrame);
        mapTiles.add(bossPortalTTile);

        // grass border
        Frame grassBorderFrame = new FrameBuilder(getSubImage(0, 0))
                .withScale(tileScale)
                .build();
        MapTileBuilder grassBorderTile = new MapTileBuilder(grassBorderFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(grassBorderTile);

        // volcano portal frames
        Frame volcanoPortalTFrame = new FrameBuilder(getSubImage(6, 7))
                .withScale(tileScale)
                .build();
        MapTileBuilder volcanoPortalTTile = new MapTileBuilder(volcanoPortalTFrame);
        mapTiles.add(volcanoPortalTTile);

        Frame volcanoPortalBFrame = new FrameBuilder(getSubImage(6, 7))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_VERTICAL)
                .build();
        MapTileBuilder volcanoPortalBTile = new MapTileBuilder(volcanoPortalBFrame);
        mapTiles.add(volcanoPortalBTile);

        // background house body
        Frame houseBodyBGFrame = new FrameBuilder(getSubImage(3, 4))
                .withScale(tileScale)
                .build();
        MapTileBuilder houseBodyBGTile = new MapTileBuilder(houseBodyBGFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(houseBodyBGTile);

        // foreground house body
        Frame houseBodyFGFrame = new FrameBuilder(getSubImage(3, 4))
                .withScale(tileScale)
                .build();
        MapTileBuilder houseBodyFGTile = new MapTileBuilder(sandFrame).withTopLayer(houseBodyFGFrame);
        mapTiles.add(houseBodyFGTile);

        // castle tower tops
        Frame castleConeGrassLFrame = new FrameBuilder(getSubImage(6, 4))
                .withScale(tileScale)
                .build();
        MapTileBuilder castleConeGrassLTile = new MapTileBuilder(grassFrame).withTopLayer(castleConeGrassLFrame);
        mapTiles.add(castleConeGrassLTile);

        Frame castleConeGrassRFrame = new FrameBuilder(getSubImage(6, 4))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();
        MapTileBuilder castleConeGrassRTile = new MapTileBuilder(grassFrame).withTopLayer(castleConeGrassRFrame);
        mapTiles.add(castleConeGrassRTile);

        Frame castleConeStoneLFrame = new FrameBuilder(getSubImage(6, 4))
                .withScale(tileScale)
                .build();
        MapTileBuilder castleConeStoneLTile = new MapTileBuilder(houseBodyFrame).withTopLayer(castleConeStoneLFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(castleConeStoneLTile);

        Frame castleConeStoneRFrame = new FrameBuilder(getSubImage(6, 4))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();
        MapTileBuilder castleConeStoneRTile = new MapTileBuilder(houseBodyFrame).withTopLayer(castleConeStoneRFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(castleConeStoneRTile);

        Frame castleConeGravelLFrame = new FrameBuilder(getSubImage(6, 4))
                .withScale(tileScale)
                .build();
        MapTileBuilder castleConeGravelLTile = new MapTileBuilder(greyRockFrame).withTopLayer(castleConeGravelLFrame);
        mapTiles.add(castleConeGravelLTile);

        Frame castleConeGravelRFrame = new FrameBuilder(getSubImage(6, 4))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();
        MapTileBuilder castleConeGravelRTile = new MapTileBuilder(greyRockFrame).withTopLayer(castleConeGravelRFrame);
        mapTiles.add(castleConeGravelRTile);

        Frame castleConeFrame = new FrameBuilder(getSubImage(6, 5))
                .withScale(tileScale)
                .build();
        MapTileBuilder castleConeTile = new MapTileBuilder(grassFrame).withTopLayer(castleConeFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(castleConeTile);

        // boss portal bottom frame
        Frame bossPortalBFrame = new FrameBuilder(getSubImage(5, 7))
                .withImageEffect(ImageEffect.FLIP_VERTICAL)
                .withScale(tileScale)
                .build();
        MapTileBuilder bossPortalBTile = new MapTileBuilder(bossPortalBFrame);
        mapTiles.add(bossPortalBTile);

        // throne bottom
        Frame throneBottomFrame = new FrameBuilder(getSubImage(6, 6))
                .withScale(tileScale)
                .build();
        MapTileBuilder throneBottomTile = new MapTileBuilder(throneBottomFrame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(throneBottomTile);

        return mapTiles;
    }
}
