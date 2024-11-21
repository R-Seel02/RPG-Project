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
public class TreeBossScript extends Script {
    protected Enemy treeBoss = new Enemy("TreeBoss", 150, 10, 2, "EntSprite.png", 100, 100);
    int npcId = 21;

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCLockScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new TextboxScriptAction("Hmph..."));
        scriptActions.add(new TextboxScriptAction("If you really want my key, you'll have to pry it from \nmy withered branches"));

        scriptActions.add(new StartFightScriptAction(treeBoss));

        scriptActions.add(new ChangeFlagScriptAction("isFighting", true));

        scriptActions.add(new IsEnemyDefeatedScript(treeBoss, "treeBossDefeated"));

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("treeBossDefeated", true));
                scriptActions.add(new TextboxScriptAction("Wow, you chopped down another tree, human.\nCongratulations, I suppose."));
                addScriptAction(new NPCChangeVisibilityScriptAction(Visibility.HIDDEN));
            }});
        }});





        scriptActions.add(new NPCUnlockScriptAction());
        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
