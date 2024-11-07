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
public class PurpleFlowerScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {

        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());


        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestPlagueDoctor", true));
                addRequirement(new FlagRequirement("hasCauldron",true));
                addRequirement(new FlagRequirement("hasFrog", true));
                addRequirement(new FlagRequirement("hasPurpleFlower", false));
                addScriptAction(new TextboxScriptAction () {{
                    addText("You grab the purple flower,\nyou're amazed by how good it smells.");
                }});

               
                addScriptAction(new NPCChangeVisibilityScriptAction(Visibility.HIDDEN));
                addScriptAction(new ChangeFlagScriptAction("hasPurpleFlower", true));
            }});
        }});


        scriptActions.add(new UnlockPlayerScriptAction());
        return scriptActions;
    }
}

