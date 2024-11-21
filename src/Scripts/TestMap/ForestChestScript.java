package Scripts.TestMap;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.*;


public class ForestChestScript extends Script{

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasOpenedForestChest", false));
                addScriptAction(new TextboxScriptAction() {{
                    addText("You have recived 15 coins from the chest");
                    
                
                }});
                
                
                addScriptAction(new ChangeFlagScriptAction("hasOpenedForestChest", true));
                addScriptAction(new AddCoin("hasOpenedForestChest",15));
                
            }});
            

            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasOpenedForestChest", true));
                addScriptAction(new TextboxScriptAction() {{
                    addText("The chest is empty.");
                    
                }});
            }});

            
        }});

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
    
}

