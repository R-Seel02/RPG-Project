package Scripts.TestMap;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.*;


// trigger script at beginning of game to set that heavy emotional plot
// checkout the documentation website for a detailed guide on how this script works
public class LostBallScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new TextboxScriptAction() {{
            addText("Another fine day in the land of Thimineur.");
            addText("I wonder if anyone has anything for me to do.");
            addText("Perchance.");
        }});

        scriptActions.add(new ChangeFlagScriptAction("hasLostBall", true));

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
