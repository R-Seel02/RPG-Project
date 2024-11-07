package ScriptActions;

import Level.Items;
import Level.MapEntity;
import Level.MapEntityStatus;
import Level.PickableObject;
import Level.Player;
import Level.ScriptState;




public class AddItem extends ScriptAction {
    protected String flagName;
    protected Items item;
   
   
    public AddItem(String flagName, Items item){
        this.item = item;
        this.flagName = flagName;
    }
    @Override
    public ScriptState execute() {
        if (player.addToInventory(item)) {
            
            return ScriptState.COMPLETED;  
        } else {
  
            return ScriptState.RUNNING;  
        }
    } 
}