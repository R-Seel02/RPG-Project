package ScriptActions;

import Level.MapEntity;
import Level.MapEntityStatus;
import Level.PickableObject;
import Level.Player;
import Level.ScriptState;




public class AddItem extends ScriptAction {
    protected String flagName;
    protected PickableObject item;
   
   
    public AddItem(String flagName, PickableObject item){
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