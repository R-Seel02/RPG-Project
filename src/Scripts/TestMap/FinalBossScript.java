package Scripts.TestMap;

import java.util.ArrayList;

import javax.swing.event.SwingPropertyChangeSupport;

import Engine.ImageLoader;
import GameObject.Frame;
import Level.Enemy;
import Level.Items;
import Level.Script;
import ScriptActions.*;
import Utils.Visibility;

// script for talking to walrus npc
// checkout the documentation website for a detailed guide on how this script works
public class FinalBossScript extends Script {
    protected Enemy finalBoss = new Enemy("FinalBoss", 150, 5, 2, "King_John_Kingsley.png", 100, 100);
    int npcId = 1;

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCLockScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new TextboxScriptAction("Do you know who I am? I'm King John Kingsley!"));
        scriptActions.add(new TextboxScriptAction("You're gonna be lightweight baby!"));

        scriptActions.add(new StartFightScriptAction(finalBoss));

        scriptActions.add(new ChangeFlagScriptAction("isFighting", true));

        scriptActions.add(new IsEnemyDefeatedScript(finalBoss, "finalBossDefeated"));

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("finalBossDefeated", true));
                scriptActions.add(new TextboxScriptAction("Light... weight... baby....."));
                addScriptAction(new NPCChangeVisibilityScriptAction(Visibility.HIDDEN));
            }});
        }});





        scriptActions.add(new NPCUnlockScriptAction());
        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
