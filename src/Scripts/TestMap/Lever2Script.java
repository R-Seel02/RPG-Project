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

//use existence scripts or flags for the individual levers as to remove the hitbox of the levers as to not let players abuse using a single lever.
//change direction of npc to change hide sprite then remove its interact box so the player cannot use the lever twice.

// script for talking to dino npc
// checkout the documentation website for a detailed guide on how this script works
public class Lever2Script extends Script {
    protected Enemy rats = new Enemy("rats", 50, 5, 2, "Rats.png", 40, 40);

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {

        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());


        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestThief", true));
                addRequirement(new FlagRequirement("hasTotem",false));
                addRequirement(new FlagRequirement("hitLever2",false));
                addRequirement(new FlagRequirement("hasPulledLever1",false));
                addRequirement(new FlagRequirement("hasPulledLever2",false));
                addRequirement(new FlagRequirement("hasPulledLever3",false));

                addScriptAction(new TextboxScriptAction () {{
                    addText("*You pulled lever one of three, not much happens*");
                }});

        
                addScriptAction(new ChangeFlagScriptAction("hasPulledLever1", true));
                addScriptAction(new ChangeFlagScriptAction("hitLever2", true));
                addScriptAction(new NPCStandScriptAction(Direction.RIGHT));
            }});
        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestThief", true));
                addRequirement(new FlagRequirement("hasTotem",false));
                addRequirement(new FlagRequirement("hitLever2",false));
                addRequirement(new FlagRequirement("hasPulledLever1",true));
                addRequirement(new FlagRequirement("hasPulledLever2",false));
                addRequirement(new FlagRequirement("hasPulledLever3",false));

                addScriptAction(new TextboxScriptAction () {{
                    addText("*You attempt to pull the second lever until\nYou can hear something behind you*");
                    addText("*Three hungry rats approach*");
                    addText("GIVE US YA MONEY BOY!");
                }});
                    scriptActions.add(new StartFightScriptAction(rats));

        scriptActions.add(new ChangeFlagScriptAction("isFighting", true));

        addScriptAction(new TextboxScriptAction () {{
        addText("*The rats run away and you pull the lever*");
    }});

        
                addScriptAction(new ChangeFlagScriptAction("hasPulledLever2", true));
                addScriptAction(new ChangeFlagScriptAction("hitLever2", true));
                addScriptAction(new NPCStandScriptAction(Direction.RIGHT));
            }});
        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestThief", true));
                addRequirement(new FlagRequirement("hasTotem",false));
                addRequirement(new FlagRequirement("hitLever2",false));
                addRequirement(new FlagRequirement("hasPulledLever1",true));
                addRequirement(new FlagRequirement("hasPulledLever2",true));
                addRequirement(new FlagRequirement("hasPulledLever3",false));

                addScriptAction(new TextboxScriptAction () {{
                    addText("*You pulled the third lever...*");
                    addText("*You hear noise in the middle of the pyramid\n maybe something happened*");
                    //initiate fight
                }});
                // change direction to be the totem image
        
                addScriptAction(new ChangeFlagScriptAction("hasPulledLever3", true));
                addScriptAction(new ChangeFlagScriptAction("hitLever2", true));
                addScriptAction(new NPCStandScriptAction(Direction.RIGHT));
            }});
        }});


        scriptActions.add(new UnlockPlayerScriptAction());
        return scriptActions;
    }
}

