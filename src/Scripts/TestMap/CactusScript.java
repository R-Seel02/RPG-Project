package Scripts.TestMap;

import java.util.ArrayList;

import Level.Enemy;
import Level.Script;
import ScriptActions.*;
import Utils.Direction;
import Utils.Visibility;


public class CactusScript extends Script {
    protected Enemy cactus = new Enemy("Cactus", 100, 5, 2, "CactusFight.png", 32, 40);
    int npcId = 2;

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCLockScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new ConditionalScriptAction());

        scriptActions.add(new TextboxScriptAction("..."));
        


        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestScaredGuy", true));
                addRequirement(new FlagRequirement("hasCompletedQuestScaredGuy", false));
                addRequirement(new FlagRequirement("hasFoughtCactus", false));
               


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("How could you tell I wasn't a normal cactus??"));
                    addScriptAction(new TextboxScriptAction("I can't let you run away alive!"));


                    scriptActions.add(new StartFightScriptAction(cactus));

                   scriptActions.add(new ChangeFlagScriptAction("isFighting", true));

                scriptActions.add(new IsEnemyDefeatedScript(cactus, "hasFoughtCactus"));

                scriptActions.add(new ConditionalScriptAction() {{
                    addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                        addRequirement(new FlagRequirement("hasFoughtCactus", true));
                addScriptAction(new TextboxScriptAction("Dammit! how are you so strong??."));
                addScriptAction(new TextboxScriptAction("*A small man jumps out of the cactus and runs away*"));
               // addScriptAction(new TextboxScriptAction("I'll get my revenge!!"));
                addScriptAction(new NPCWalkScriptAction(Direction.LEFT, 2000, 6));
                addScriptAction(new TextboxScriptAction("I'll get my revenge!!"));
            }});
        }});

                 }});

            }});

        }});

        // scriptActions.add(new ConditionalScriptAction() {{
        //     addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
        //         addRequirement(new FlagRequirement("hasCompletedQuest1", true));


        //          addScriptAction(new TextboxScriptAction() {{
        //             addScriptAction(new TextboxScriptAction("I wish you luck on your future journeys!"));
        //          }});
        //     }});

        // }});

     


        scriptActions.add(new NPCUnlockScriptAction());
        scriptActions.add(new UnlockPlayerScriptAction());
        

        return scriptActions;
    }
}
    