package Scripts.TestMap;

import java.util.ArrayList;

import Level.Enemy;
import Level.Script;
import ScriptActions.*;
import Utils.Visibility;


public class Thug3Script extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCLockScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new ConditionalScriptAction());
        

        

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestMuggedWoman", true));
                addRequirement(new FlagRequirement("hasCompletedQuestMuggedWoman", false));
                addRequirement(new FlagRequirement("hasPurse", false));
                addRequirement(new FlagRequirement("hasFoughtThug2", true));
                addRequirement(new FlagRequirement("hasFoughtThug1", true));
               


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("YOU BEAT FRIENDS??"));
                    addScriptAction(new TextboxScriptAction("ME ATTACK!!"));


                    scriptActions.add(new StartFightScriptAction(new Enemy("Thug", 100, 5, 2, "Thug3.png", 30, 30)));

                scriptActions.add(new ChangeFlagScriptAction("isFighting", true));

                addScriptAction(new TextboxScriptAction("ME KILL YOU NEXT TIME."));
                addScriptAction(new TextboxScriptAction("The thug throws the purse at you and leaves*"));


                 }});
                 addScriptAction(new NPCChangeVisibilityScriptAction(Visibility.HIDDEN));
                 addScriptAction(new ChangeFlagScriptAction("hasFoughtThug3", true));
                 addScriptAction(new ChangeFlagScriptAction("hasFoughtAllThugs", true));
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestMuggedWoman", true));
                addRequirement(new FlagRequirement("hasCompletedQuestMuggedWoman", false));
                addRequirement(new FlagRequirement("hasPurse", false));
                addRequirement(new FlagRequirement("hasFoughtThug3", false));
               


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("FIGHT ME!"));

                    scriptActions.add(new StartFightScriptAction(new Enemy("Thug", 100, 5, 2, "Thug3.png", 30, 30)));

                scriptActions.add(new ChangeFlagScriptAction("isFighting", true));

                addScriptAction(new TextboxScriptAction("NOT FAIR."));
                addScriptAction(new TextboxScriptAction("*The thug angrily stomps away*"));

                 }});
                 addScriptAction(new NPCChangeVisibilityScriptAction(Visibility.HIDDEN));
                 addScriptAction(new ChangeFlagScriptAction("hasFoughtThug3", true));
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
    
