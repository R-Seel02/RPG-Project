package Scripts.TestMap;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.*;

// script for talking to the test NPC
// checkout the documentation website for a detailed guide on how this script works
public class TestNPCScript extends Script{

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToTestNPC", false));
                addScriptAction(new TextboxScriptAction() {{
                    addText("OOGLY BOOGLY");
                    addText("Bet I spooked ya there! hehe"); 
                    addText("You want this coin?");
                    addText("Well to bad because I don't know how to give it to you.");
                }});
                addScriptAction(new ChangeFlagScriptAction("hasTalkedToTestNPC", true));
            }});

            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToTestNPC", true));
                addScriptAction(new TextboxScriptAction("ahhhh I love my coin!"));
            }});
        }});

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
    
}
