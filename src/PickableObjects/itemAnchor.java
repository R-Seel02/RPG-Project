package PickableObjects;

import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.SpriteSheet;
import Level.PickableObject;
import Utils.Point;

public class itemAnchor extends PickableObject {

    public itemAnchor (Point location, Frame frame){
        super(location, frame); new SpriteSheet(ImageLoader.load("Anchor.png"), 24, 24);

    }
 }

