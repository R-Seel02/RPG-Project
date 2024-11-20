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

// This class is for a test NPC
public class SalamanderOther extends NPC {

    public SalamanderOther(int id, Point location) {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("SalamanderBaby.png"), 18, 18), "STAND_RIGHT");
    }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("STAND_LEFT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(3)
                            .withBounds(0, 5, 15, 15)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .build()
            });
            put("STAND_RIGHT", new Frame[] {
                   new FrameBuilder(spriteSheet.getSprite(0, 0))
                           .withScale(3)
                           .withBounds(0, 5, 20, 5)
                           .build()
           });
            put("WALK_LEFT", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(0, 1), 20)
                        .withScale(3)
                        .withBounds(3, 5, 18, 20)
                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(1, 0), 20)
                        .withScale(3)
                        .withBounds(3, 5, 18, 20)
                        .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                        .build()
            });
            put("WALK_RIGHT", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(0, 1), 20)
                        .withScale(3)
                        .withBounds(3, 5, 18, 20)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(1, 0), 20)
                        .withScale(3)
                        .withBounds(3, 5, 18, 20)
                        .build()
            });
        }};
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }
    
}
