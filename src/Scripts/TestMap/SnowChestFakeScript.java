package Scripts.TestMap;

import java.util.ArrayList;

import Level.Enemy;
import Level.Script;
import ScriptActions.*;
import Utils.Visibility;


public class SnowChestFakeScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCLockScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new ConditionalScriptAction());
        

        

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasOpenedSnowChest", true));
                addRequirement(new FlagRequirement("hasOpenedSnowChest2", true));
                addRequirement(new FlagRequirement("hasOpenedSnowChest3", true));
               


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("Ahh a Greedy one? \n I guess I'll have to teach you a lesson on taking too much"));
                    addScriptAction(new TextboxScriptAction("Let me show you how a reeaalll pro fights."));

                    scriptActions.add(new StartFightScriptAction(new Enemy("FakeChest", 120, 4, 7, "TreasureChest.png", 24, 24)));

                scriptActions.add(new ChangeFlagScriptAction("isFighting", true));

                
                addScriptAction(new TextboxScriptAction("You may be greedy but you sure are good at fighting"));

                 }});
                 addScriptAction(new NPCChangeVisibilityScriptAction(Visibility.HIDDEN));
                 addScriptAction(new ChangeFlagScriptAction("hasFoughtChest", true));
                
            }});

        }});

        
        scriptActions.add(new NPCUnlockScriptAction());
        scriptActions.add(new UnlockPlayerScriptAction());
        

        return scriptActions;
    }
}