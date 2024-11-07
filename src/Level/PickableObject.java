package Level;

import Engine.Key;
import Engine.Keyboard;
import GameObject.Frame;
import GameObject.SpriteSheet;
import Utils.Point;




public class PickableObject extends MapEntity {
    protected Key INTERACT_KEY = Key.E;
    protected PickableObject pickableObject;
    protected PickableObject [] inventoryList;

    public PickableObject(Point location, Frame frame) {
        super(location.x, location.y, frame);
    }


    public void update(Player player){
         

        // magnitude of distance from object to player
        double distance = Math.sqrt(Math.pow(x - player.getX(), 2) + Math.pow(y - player.getY(), 2));
        
        if(this.inventoryList  == null){
            this.inventoryList = new PickableObject[15];
        
        }

        if (distance <= 55 && Keyboard.isKeyDown(INTERACT_KEY)) {
            this.setMapEntityStatus(MapEntityStatus.REMOVED);
            
            player.addToInventory(this);
            

        }
        
        super.update();

    }

}