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

public class SalamanderGuy extends NPC {
    //private int totalAmountMoved = 0;
    private Direction direction = Direction.RIGHT;
    //private float speed = 1;
    
    public SalamanderGuy(int id, Point location) {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("SalamanderGuy.png"), 30, 30), "STAND_LEFT");
    }

    // this code makes the bug npc walk back and forth (left to right)
  //  @Override
    // public void performAction(Player player) {
    //     // if bug has not yet moved 90 pixels in one direction, move bug forward
    //     if (totalAmountMoved < 300) {
    //         float amountMoved = moveXHandleCollision(speed * direction.getVelocity());
    //         totalAmountMoved += Math.abs(amountMoved);
    //     }

    //     // else if bug has already moved 90 pixels in one direction, flip the bug's direction
    //     else {
    //         totalAmountMoved = 0;
    //         if (direction == Direction.LEFT) {
    //             direction = Direction.RIGHT;
    //         }
    //         else {
    //             direction = Direction.LEFT;
    //         }
    //     }

    //     // based off of the bugs current walking direction, set its animation to match
    //     if (direction == Direction.RIGHT) {
    //         currentAnimationName = "WALK_RIGHT";
    //     }
    //     else {
    //         currentAnimationName = "WALK_LEFT";
    //     }
    // }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("STAND_LEFT", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(0, 0))
                    .withScale(3)
                    .withBounds(3, 5, 18, 30)
                    
                    .build()
            });
            put("STAND_RIGHT", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(0, 1))
                    .withScale(3)
                    .withBounds(3, 5, 18, 20)
                    //.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                    .build()
           });
           put("WALK_LEFT", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(1, 1), 20)
                        .withScale(3)
                        .withBounds(3, 5, 18, 20)
                        //.withImageEffect(ImageEffect.FLIP_HORIZONTAL) 
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(1, 0), 20)
                        .withScale(3)
                        .withBounds(3, 5, 18, 20)
                        //.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                        .build()
            });
            put("WALK_RIGHT", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(0, 1), 20)
                        .withScale(3)
                        .withBounds(3, 5, 18, 20)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(0, 0), 20)
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
