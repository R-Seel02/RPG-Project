package ScriptActions;


import Level.Map;
import Level.MapEntity;
import Level.MapEntityStatus;
import Level.PickableObject;
import Level.ScriptState;



public class RemoveMapEntityScriptAction extends ScriptAction {

    private String entityName;

    public RemoveMapEntityScriptAction(String entityName) {
        this.entityName = entityName;
    }

    @Override
    public boolean execute() {
        Map currentMap = getCurrentMap();
        MapEntity entity = currentMap.getMapEntityStatus(entityName);
        
        if (entity != null) {
            entity.setMapEntityStatus(MapEntityStatus.REMOVED);
            return true;  // Indicates successful removal
        } else {
            return false;  // Indicates entity not found, action unsuccessful
        }
    }
}
