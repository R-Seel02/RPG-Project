package Scripts.TestMap;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.*;



public class DesertChestScript extends Script{

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasOpenedDesertChest", false));
                addScriptAction(new TextboxScriptAction() {{
                    addText("You have recived 1 coins from the chest");
                    
                
                }});
                
                
                addScriptAction(new ChangeFlagScriptAction("hasOpenedDesertChest", true));
                addScriptAction(new AddCoin("hasOpenedDesertChest",1));
                
            }});
            

            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasOpenedDesertChest", true));
                addScriptAction(new TextboxScriptAction() {{
                    addText("The chest is empty.");
                    
                }});
            }});

            
        }});

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
    
}