package Scripts.TestMap;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.*;

// script for talking to walrus npc
// checkout the documentation website for a detailed guide on how this script works
public class SkeletonScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCLockScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());
        
        scriptActions.add(new TextboxScriptAction("RAHHHHHHHHHHHH!!!"));

        scriptActions.add(new StartFightScriptAction("Skeleton.png"));

        scriptActions.add(new ChangeFlagScriptAction("isFighting", true));


        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestOldGuy", true));
                addRequirement(new FlagRequirement("hasCompletedQuestOldGuy", false));
                addRequirement(new FlagRequirement("hasFoughtSkeleton", false));
                 scriptActions.add(new ChangeFlagScriptAction("hasFoughtSkeleton", true));
                 scriptActions.add(new ChangeFlagScriptAction("hasQuest", false));
            }});

        }});


        scriptActions.add(new NPCUnlockScriptAction());
        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
