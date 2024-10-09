package ScriptActions;

import Level.MapEntity;
import Level.MapEntityStatus;
import Level.PickableObject;
import Level.ScriptState;
import Scripts.TestMap.RockScript;


public class AddEntity extends ScriptAction {
    protected PickableObject pickableObject;
   
    public AddEntity(PickableObject pickableObject){
        this.pickableObject= pickableObject;
    }
    @Override
    public ScriptState execute() {
       
        pickableObject.setMapEntityStatus(MapEntityStatus.ACTIVE);
        return ScriptState.COMPLETED;
    } 
}