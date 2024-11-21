package Scripts.TestMap;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.*;


public class SnowChestScript extends Script{

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasOpenedSnowChest", false));
                addScriptAction(new TextboxScriptAction() {{
                    addText("You have recived 6 coins from the chest");
                    
                
                }});
                
                
                addScriptAction(new ChangeFlagScriptAction("hasOpenedSnowChest", true));
                addScriptAction(new AddCoin("hasOpenedSnowChest",6));
                
            }});
            

            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasOpenedSnowChest", true));
                addScriptAction(new TextboxScriptAction() {{
                    addText("The chest is empty.");
                    
                }});
            }});

            
        }});

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
    
}

