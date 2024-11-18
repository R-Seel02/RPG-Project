package Maps;

import Engine.GraphicsHandler;
import GameObject.Sprite;
import Level.Map;
import Tilesets.CommonTileset;

// Represents the map that is used as a background for the main menu and credits menu screen
public class TitleScreenMap extends Map {

    private Sprite player;

    public TitleScreenMap() {
        super("title_screen_map.txt", new CommonTileset());
        // Point catLocation = getMapTile(8, 5).getLocation().subtractX(6).subtractY(7);
        // player = new Sprite(ImageLoader.loadSubImage("Mage.png", Colors.MAGENTA, 0, 0, 24, 24));
        // player.setScale(3);
        // player.setImageEffect(ImageEffect.FLIP_HORIZONTAL);
        // player.setLocation(catLocation.x, catLocation.y);
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
        // player.draw(graphicsHandler);
    }
}
