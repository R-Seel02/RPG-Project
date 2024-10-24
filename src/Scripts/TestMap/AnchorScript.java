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
public class AnchorScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {

        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());


        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasCompletedQuestWoman", true));
                addRequirement(new FlagRequirement("hasWaterTome", false));
                addScriptAction(new TextboxScriptAction () {{
                    addText("You can see an object in the water \n but it is too deep to reach.");
                    addText("If only there was a way for you to move water.");
                }});

               
                //addScriptAction(new NPCChangeVisibilityScriptAction(Visibility.HIDDEN));
                //addScriptAction(new ChangeFlagScriptAction("hasBottle", true));
            }});
        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasCompletedQuestWoman", true));
                addRequirement(new FlagRequirement("hasWaterTome", true));
                addScriptAction(new TextboxScriptAction () {{
                    addText("You use the water tome to \n lift the object out of the water");
                    addText("*You've obtained the dread anchor*");
                }});

               
                addScriptAction(new NPCChangeVisibilityScriptAction(Visibility.HIDDEN));
                addScriptAction(new ChangeFlagScriptAction("hasAnchor", true));
            }});
        }});



        scriptActions.add(new UnlockPlayerScriptAction());
        return scriptActions;
    }
}

