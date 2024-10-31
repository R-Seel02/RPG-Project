package PickableObjects;

import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.SpriteSheet;
import Level.PickableObject;
import Utils.Point;

public class itemKatana extends PickableObject {

    public itemKatana (Point location, Frame frame){
        super(location, frame); new SpriteSheet(ImageLoader.load("Katana.png"), 24, 24);

    }
 }

