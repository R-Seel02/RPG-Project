package Scripts.TestMap;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.*;

// script for talking to walrus npc
// checkout the documentation website for a detailed guide on how this script works
public class WalrusScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToWalrus", false));
                addScriptAction(new TextboxScriptAction() {{
                    addText("Hello, good sire!");
                    addText("Such a lovely day.");
                    addText("Feel free to stay a while!");
                }});
                addScriptAction(new ChangeFlagScriptAction("hasTalkedToWalrus", true));
            }});

            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToWalrus", true));
                addScriptAction(new TextboxScriptAction("You want a duel, you say?"));
                addScriptAction(new TextboxScriptAction("Have at thee!"));
                addScriptAction(new StartFightScriptAction("Walrus.png"));
                addScriptAction(new ChangeFlagScriptAction("isFighting", true));
            }});
        }});

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
