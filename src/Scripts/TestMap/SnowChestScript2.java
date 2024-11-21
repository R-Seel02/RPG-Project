package Scripts.TestMap;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.*;


public class SnowChestScript2 extends Script{

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasOpenedSnowChest2", false));
                addScriptAction(new TextboxScriptAction() {{
                    addText("You have recived 8 coins from the chest");
                    
                
                }});
                
                
                addScriptAction(new ChangeFlagScriptAction("hasOpenedSnowChest2", true));
                addScriptAction(new AddCoin("hasOpenedSnowChest2",8));
                
            }});
            

            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasOpenedSnowChest2", true));
                addScriptAction(new TextboxScriptAction() {{
                    addText("The chest is empty.");
                    
                }});
            }});

            
        }});

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
    
}

