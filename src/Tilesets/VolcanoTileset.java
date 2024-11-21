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
        Frame obsidianFrame = new FrameBuilder(getSubImage(0, 0))
                .withScale(tileScale)
                .build();
        MapTileBuilder obsidianTile = new MapTileBuilder(obsidianFrame);
        mapTiles.add(obsidianTile);

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

        // boss portal
        Frame bossPortalTFrame = new FrameBuilder(getSubImage(0, 4))
                .withScale(tileScale)
                .build();
        MapTileBuilder bossPortalTTile = new MapTileBuilder(bossPortalTFrame);
        mapTiles.add(bossPortalTTile);

        Frame bossPortalBFrame = new FrameBuilder(getSubImage(0, 4))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_VERTICAL)
                .build();
        MapTileBuilder bossPortalBTile = new MapTileBuilder(bossPortalBFrame);
        mapTiles.add(bossPortalBTile);

        // volcano tiles
        Frame volcano1Frame = new FrameBuilder(getSubImage(1, 1))
                .withScale(tileScale)
                .build();
        MapTileBuilder volcano1Tile = new MapTileBuilder(volcano1Frame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(volcano1Tile);
        
        Frame volcano2Frame = new FrameBuilder(getSubImage(1, 2))
                .withScale(tileScale)
                .build();
        MapTileBuilder volcano2Tile = new MapTileBuilder(volcano2Frame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(volcano2Tile);

        Frame volcano3Frame = new FrameBuilder(getSubImage(1, 3))
                .withScale(tileScale)
                .build();
        MapTileBuilder volcano3Tile = new MapTileBuilder(volcano3Frame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(volcano3Tile);

        Frame volcano4Frame = new FrameBuilder(getSubImage(1, 4))
                .withScale(tileScale)
                .build();
        MapTileBuilder volcano4Tile = new MapTileBuilder(volcano4Frame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(volcano4Tile);

        Frame volcano5Frame = new FrameBuilder(getSubImage(1, 5))
                .withScale(tileScale)
                .build();
        MapTileBuilder volcano5Tile = new MapTileBuilder(obsidianFrame)
                .withTopLayer(volcano5Frame);
        mapTiles.add(volcano5Tile);

        Frame volcano6Frame = new FrameBuilder(getSubImage(2, 0))
                .withScale(tileScale)
                .build();
        MapTileBuilder volcano6Tile = new MapTileBuilder(volcano6Frame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(volcano6Tile);

        Frame volcano7Frame = new FrameBuilder(getSubImage(2, 1))
                .withScale(tileScale)
                .build();
        MapTileBuilder volcano7Tile = new MapTileBuilder(volcano7Frame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(volcano7Tile);

        Frame volcano8Frame = new FrameBuilder(getSubImage(2, 2))
                .withScale(tileScale)
                .build();
        MapTileBuilder volcano8Tile = new MapTileBuilder(obsidianFrame)
                .withTopLayer(volcano8Frame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(volcano8Tile);

        Frame volcano9Frame = new FrameBuilder(getSubImage(2, 3))
                .withScale(tileScale)
                .build();
        MapTileBuilder volcano9Tile = new MapTileBuilder(volcano9Frame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(volcano9Tile);

        Frame volcano10Frame = new FrameBuilder(getSubImage(2, 4))
                .withScale(tileScale)
                .build();
        MapTileBuilder volcano10Tile = new MapTileBuilder(volcano10Frame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(volcano10Tile);

        Frame volcano11Frame = new FrameBuilder(getSubImage(2, 5))
                .withScale(tileScale)
                .build();
        MapTileBuilder volcano11Tile = new MapTileBuilder(obsidianFrame)
                .withTopLayer(volcano11Frame);
        mapTiles.add(volcano11Tile);

        Frame volcano12Frame = new FrameBuilder(getSubImage(3, 0))
                .withScale(tileScale)
                .build();
        MapTileBuilder volcano12Tile = new MapTileBuilder(volcano12Frame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(volcano12Tile);

        Frame volcano13Frame = new FrameBuilder(getSubImage(3, 1))
                .withScale(tileScale)
                .build();
        MapTileBuilder volcano13Tile = new MapTileBuilder(obsidianFrame)
                .withTopLayer(volcano13Frame)
                .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(volcano13Tile);

        Frame volcano14Frame = new FrameBuilder(getSubImage(3, 2))
                .withScale(tileScale)
                .build();
        MapTileBuilder volcano14Tile = new MapTileBuilder(obsidianFrame)
                .withTopLayer(volcano14Frame);
        mapTiles.add(volcano14Tile);

        Frame volcano15Frame = new FrameBuilder(getSubImage(3, 3))
                .withScale(tileScale)
                .build();
        MapTileBuilder volcano15Tile = new MapTileBuilder(obsidianFrame)
                .withTopLayer(volcano15Frame);
        mapTiles.add(volcano15Tile);

        Frame volcano16Frame = new FrameBuilder(getSubImage(3, 4))
                .withScale(tileScale)
                .build();
        MapTileBuilder volcano16Tile = new MapTileBuilder(obsidianFrame)
                .withTopLayer(volcano16Frame);
        mapTiles.add(volcano16Tile);

        Frame volcano17Frame = new FrameBuilder(getSubImage(3, 5))
                .withScale(tileScale)
                .build();
        MapTileBuilder volcano17Tile = new MapTileBuilder(obsidianFrame)
                .withTopLayer(volcano17Frame);
        mapTiles.add(volcano17Tile);

        Frame volcano18Frame = new FrameBuilder(getSubImage(0, 5))
                .withScale(tileScale)
                .build();
        MapTileBuilder volcano18Tile = new MapTileBuilder(obsidianFrame)
                .withTopLayer(volcano18Frame);
        mapTiles.add(volcano18Tile);
        
        return mapTiles;
    }
}
