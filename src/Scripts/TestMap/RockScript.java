package Scripts.TestMap;

import java.util.ArrayList;

import Level.MapEntityStatus;
import Level.PickableObject;
import Level.Script;
import ScriptActions.*;

public class RockScript extends Script {

    protected PickableObject pickableObject;

    
    
    public RockScript(PickableObject pickableObject){
        this.pickableObject = pickableObject;
    }

    @Override

    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());
        scriptActions.add(new NPCFacePlayerScriptAction());
        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasPickedupRock", false));
                addScriptAction(new TextboxScriptAction() {{
                    addText("You have picked up the rock ");
                    
                }});
                scriptActions.add(new RemoveEntity(pickableObject));
                addScriptAction(new ChangeFlagScriptAction("hasPickedUpRock", true));
            }});
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasPickedupRock", true));
                addScriptAction(new TextboxScriptAction("you have placed the rock down"));
            }});
            scriptActions.add(new AddEntity(pickableObject));
     
        }});
        scriptActions.add(new UnlockPlayerScriptAction());
        return scriptActions;
    }
    
}
