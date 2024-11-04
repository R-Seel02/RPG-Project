package PickableObjects;

import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.SpriteSheet;
import Level.PickableObject;
import Utils.Point;

public class ItemKatana extends PickableObject {

    public ItemKatana (Point location, Frame frame){
        super(location, frame); new SpriteSheet(ImageLoader.load("Katana.png"), 24, 24);

    }
 }

