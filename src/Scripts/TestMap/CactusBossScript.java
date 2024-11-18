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
public class CactusBossScript extends Script {
    protected Enemy cactusBoss = new Enemy("CactusBoss", 150, 5, 2, "CactuswardSprite.png", 100, 100);
    int npcId = 1;

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCLockScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new TextboxScriptAction("HELLO..."));
        scriptActions.add(new TextboxScriptAction("I'm a prickly cactus. Let's fight."));

        scriptActions.add(new StartFightScriptAction(cactusBoss));

        scriptActions.add(new ChangeFlagScriptAction("isFighting", true));

        scriptActions.add(new IsEnemyDefeatedScript(cactusBoss, "cactusBossDefeated"));

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("cactusBossDefeated", true));
                scriptActions.add(new TextboxScriptAction("Ow, man."));
                addScriptAction(new NPCChangeVisibilityScriptAction(Visibility.HIDDEN));
            }});
        }});





        scriptActions.add(new NPCUnlockScriptAction());
        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
