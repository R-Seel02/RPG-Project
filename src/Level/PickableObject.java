package Level;

import GameObject.Frame;
import Utils.Point;


public class PickableObject extends MapEntity{

    public PickableObject(Point location, Frame frame) {
        super(location.x, location.y, frame);
    }

    public void update(Player player){
        

    }

}