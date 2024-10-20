package PickableObjects;

import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.SpriteSheet;
import Level.PickableObject;
import Utils.Point;

public class ItemRock extends PickableObject {

    public ItemRock(Point location, Frame frame){
        super(location, frame); new SpriteSheet(ImageLoader.load("Rock.png"), 14, 17);

    }
 }

