package PickableObjects;

import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.SpriteSheet;
import Level.PickableObject;
import Utils.Point;

public class itemKnife extends PickableObject {

    public itemKnife (Point location, Frame frame){
        super(location, frame); new SpriteSheet(ImageLoader.load("Knife.png"), 24, 24);

    }
 }

