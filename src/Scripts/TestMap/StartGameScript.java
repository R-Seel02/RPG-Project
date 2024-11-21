package Scripts.TestMap;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.*;


// trigger script at beginning of game to set that heavy emotional plot
// checkout the documentation website for a detailed guide on how this script works
public class StartGameScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new TextboxScriptAction() {{
            addText("[You wake up. Your head hurts.]");
            addText("Ugh... what happened last night? Why am I out here?");
            addText("It's all such a blur... I think King John Kingsley \nkicked my butt.");
            addText("I need to get revenge, but I'll never do it in this state. \nI need weapons.");
            addText("Not to mention that I won't even be able to get to him\n if I don't beat his minions.");
            addText("That guy needs to go. I need to do something...");
            addText("...why is my bed over there?");
        }});

        scriptActions.add(new ChangeFlagScriptAction("startGame", true));

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
