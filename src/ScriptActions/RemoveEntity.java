package ScriptActions;

import Level.MapEntity;
import Level.MapEntityStatus;
import Level.PickableObject;
import Level.ScriptState;
import Scripts.TestMap.RockScript;



public class RemoveEntity extends ScriptAction {
    protected PickableObject pickableObject;
   
    public RemoveEntity(PickableObject pickableObject){
        this.pickableObject= pickableObject;
    }
    @Override
    public ScriptState execute() {
       
        pickableObject.setMapEntityStatus(MapEntityStatus.REMOVED);
        return ScriptState.COMPLETED;
    } 
}