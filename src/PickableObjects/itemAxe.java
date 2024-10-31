package PickableObjects;

import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.SpriteSheet;
import Level.PickableObject;
import Utils.Point;

public class itemAxe extends PickableObject {

    public itemAxe (Point location, Frame frame){
        super(location, frame); new SpriteSheet(ImageLoader.load("Axe.png"), 24, 24);

    }
 }

