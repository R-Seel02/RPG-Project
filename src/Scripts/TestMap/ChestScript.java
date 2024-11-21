package Scripts.TestMap;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.*;


public class ChestScript extends Script{

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasOpenedChest", false));
                addScriptAction(new TextboxScriptAction() {{
                    addText("You have recived 7 coins from the chest");
                    
                
                }});
                
                
                addScriptAction(new ChangeFlagScriptAction("hasOpenedChest", true));
                addScriptAction(new AddCoin("hasOpenedChest",7));
                
            }});
            

            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasOpenedChest", true));
                addScriptAction(new TextboxScriptAction() {{
                    addText("The chest is empty.");
                    
                }});
            }});

            
        }});

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
    
}

