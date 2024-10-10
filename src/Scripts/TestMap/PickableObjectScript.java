package Scripts.TestMap;

package Scripts.TestMap;

import java.util.ArrayList;
import Level.Script;
import ScriptActions.*;

public class PickableObjectScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        
        scriptActions.add(new LockPlayerScriptAction());
        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasPickedUpObject", false));
                addScriptAction(new TextboxScriptAction("You found a special object!"));
                addScriptAction(new ChangeFlagScriptAction("hasPickedUpObject", true));
                addScriptAction(new RemoveMapEntityScriptAction("PickableObject"));
            }});

            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasPickedUpObject", true));
                addScriptAction(new TextboxScriptAction("This object has already been picked up."));
            }});
        }});

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
