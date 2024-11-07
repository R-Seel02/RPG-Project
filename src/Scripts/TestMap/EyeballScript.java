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
public class EyeballScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {

        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());


        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestPlagueDoctor", true));
                addRequirement(new FlagRequirement("hasCauldron",true));
                addRequirement(new FlagRequirement("hasFrog", true));
                addRequirement(new FlagRequirement("hasPurpleFlower", true));
                addRequirement(new FlagRequirement("hasVial", true));
                addRequirement(new FlagRequirement("hasEyeball", false));
                addScriptAction(new TextboxScriptAction () {{
                    addText("You walk up to the floating eyeball.");
                    addText("It hisses and then charges at you.");
                }});

                scriptActions.add(new StartFightScriptAction(new Enemy("Eyeball", 50, 5, 2, "Eyeball.png", 40, 20)));

                scriptActions.add(new ChangeFlagScriptAction("isFighting", true));


                addScriptAction(new NPCChangeVisibilityScriptAction(Visibility.HIDDEN));
                addScriptAction(new ChangeFlagScriptAction("hasEyeball", true));
            }});
        }});


        scriptActions.add(new UnlockPlayerScriptAction());
        return scriptActions;
    }
}

