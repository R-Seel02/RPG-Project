package NPCs;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.NPC;
import Utils.Point;

import java.util.HashMap;

// This class is for the dinosaur NPC
public class ChickenRed extends NPC {

    public ChickenRed(int id, Point location) {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("ChickenRed.png"), 24, 24), "STAND_LEFT");
    }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("STAND_LEFT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(2)
                            .withBounds(4, 5, 10, 10)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .build()
            });
            put("STAND_RIGHT", new Frame[] {
                   new FrameBuilder(spriteSheet.getSprite(0, 0))
                           .withScale(2)
                           .withBounds(4, 5, 10, 10)
                           .build()
           });

            put("WALK_LEFT", new Frame[]{
                    new FrameBuilder(spriteSheet.getSprite(0, 0), 14)
                            .withScale(2)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(4, 5, 10, 10)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(0, 0), 14)
                            .withScale(2)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(4, 5, 10, 10)
                            .build()
            });

            put("WALK_RIGHT", new Frame[]{
                    new FrameBuilder(spriteSheet.getSprite(0, 0), 14)
                            .withScale(2)
                          
                            .withBounds(4, 5, 10, 10)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(0, 0), 14)
                            .withScale(2)
                          
                            .withBounds(4, 5, 10, 10)
                            .build()
            });
        }};
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }
}
