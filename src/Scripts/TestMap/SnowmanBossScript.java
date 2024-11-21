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
public class SnowmanBossScript extends Script {
    protected Enemy snowmanBoss = new Enemy("SnowmanBoss", 175, 14, 3, "EvilSnowmanSprite.png", 100, 100);
    int npcId = 4;

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCLockScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new TextboxScriptAction("Nyehehe..."));
        scriptActions.add(new TextboxScriptAction("If you want my key, you'll have to answer my riddles \nthree..."));
        scriptActions.add(new TextboxScriptAction("Just kidding! Let's fight!"));

        scriptActions.add(new StartFightScriptAction(snowmanBoss));

        scriptActions.add(new ChangeFlagScriptAction("isFighting", true));

        scriptActions.add(new IsEnemyDefeatedScript(snowmanBoss, "snowmanBossDefeated"));

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("snowmanBossDefeated", true));
                scriptActions.add(new TextboxScriptAction("So this is what melting feels like..."));
                addScriptAction(new NPCChangeVisibilityScriptAction(Visibility.HIDDEN));
            }});
        }});





        scriptActions.add(new NPCUnlockScriptAction());
        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
