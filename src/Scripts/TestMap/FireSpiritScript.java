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
public class FireSpiritScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {

        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new LockPlayerScriptAction());

        // scriptActions.add(new TextboxScriptAction("*...*"));

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToFireSpirit", false));

                addScriptAction(new NPCFacePlayerScriptAction());
                addScriptAction(new TextboxScriptAction () {{
                    addText("...");
                }});
            }});
            
        }});
        

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestGolem", true));
                addRequirement(new FlagRequirement("hasCompletedQuestGolem", false));
                addRequirement(new FlagRequirement("hasTalkedToFireSpirit", false));

                addScriptAction(new WaitScriptAction(30));
                addScriptAction(new NPCFacePlayerScriptAction());
                addScriptAction(new TextboxScriptAction () {{
                    addText("umm can I help you?");
                    addText("WHAT! that golem is mad at my style?!");
                    addText("I'll teach him what real style is!");
                    addText("I swear I'll melt him where is he?");
                }});
                
                
                addScriptAction(new NPCWalkScriptAction(Direction.UP, 290, 4));
                addScriptAction(new NPCWalkScriptAction(Direction.RIGHT, 400, 4));
                addScriptAction(new NPCStandScriptAction(Direction.RIGHT));

                addScriptAction(new ChangeFlagScriptAction("hasTalkedToFireSpirit", true));
            }});
            
        }});


        scriptActions.add(new UnlockPlayerScriptAction());
        return scriptActions;
    }
}

