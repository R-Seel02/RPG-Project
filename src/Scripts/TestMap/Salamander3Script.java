package Scripts.TestMap;

import java.util.ArrayList;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import GameObject.Frame;
import Level.*;
import ScriptActions.*;

import Utils.Direction;
import Utils.Point;
import Utils.Visibility;

// script for talking to dino npc
// checkout the documentation website for a detailed guide on how this script works
public class Salamander3Script extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {

        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());


        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestSalamanderGuy", true));
                addRequirement(new FlagRequirement("hasSalamander1", true));
                addRequirement(new FlagRequirement("hasSalamander2", true));
                addScriptAction(new TextboxScriptAction () {{
                    addText("Oi man you're in my way!");
                    addText("Pfft that geezer had to get you to catch me\nbecause hes slow what a loser.");
                    addText("Guess I'll zoom over to him before he gets mad at me.");
                }});

               
                addScriptAction(new NPCChangeVisibilityScriptAction(Visibility.HIDDEN));
                addScriptAction(new ChangeFlagScriptAction("hasSalamander3", true));
            }});
        }});


        scriptActions.add(new UnlockPlayerScriptAction());
        return scriptActions;
    }
}

