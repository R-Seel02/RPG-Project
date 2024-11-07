package NPCs;

import java.util.HashMap;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.NPC;
import Level.Player;
import Utils.Direction;
import Utils.Point;

// This class is for the walrus NPC
public class Frog extends NPC {

    public Frog(int id, Point location) {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("Frog.png"), 20, 20), "STAND_RIGHT");
    }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("STAND_LEFT", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(0, 0),40)
                .withScale(2)
                .withBounds(2, 10, 2, 10)
                .build(),
            });
            put("STAND_RIGHT", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(0, 0),40)
                .withScale(2)
                .withBounds(2, 10, 2, 10)
                .build(),
           });
        }};
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }
}
