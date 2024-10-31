package PickableObjects;

import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.SpriteSheet;
import Level.PickableObject;
import Utils.Point;

public class itemStaff extends PickableObject {

    public itemStaff (Point location, Frame frame){
        super(location, frame); new SpriteSheet(ImageLoader.load("Staff.png"), 24, 24);

    }
 }

