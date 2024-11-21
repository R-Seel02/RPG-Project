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
public class RockBossScript extends Script {
    protected Enemy rockBoss = new Enemy("RockBoss", 225, 15, 2, "FireRockSprite.png", 100, 100);
    int npcId = 1;

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCLockScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new TextboxScriptAction("Urg..."));
        scriptActions.add(new TextboxScriptAction("Rock smash."));

        scriptActions.add(new StartFightScriptAction(rockBoss));

        scriptActions.add(new ChangeFlagScriptAction("isFighting", true));

        scriptActions.add(new IsEnemyDefeatedScript(rockBoss, "rockBossDefeated"));

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("rockBossDefeated", true));
                scriptActions.add(new TextboxScriptAction("Huff. You're tough."));
                addScriptAction(new NPCChangeVisibilityScriptAction(Visibility.HIDDEN));
            }});
        }});





        scriptActions.add(new NPCUnlockScriptAction());
        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
