package Scripts.TestMap;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.*;
import Utils.Visibility;


public class Thug2Script extends Script {

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
               


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("Sorry bro I don't have the purse,\n I'm just in their gang cuz I thought they were cool."));

                addScriptAction(new TextboxScriptAction("*The thug shows you he doesn't have the purse\nthen walks away*"));

                 }});
                 addScriptAction(new NPCChangeVisibilityScriptAction(Visibility.HIDDEN));
                 addScriptAction(new ChangeFlagScriptAction("hasFoughtThug2", true));
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestMuggedWoman", true));
                addRequirement(new FlagRequirement("hasCompletedQuestMuggedWoman", false));
                addRequirement(new FlagRequirement("hasPurse", false));
                addRequirement(new FlagRequirement("hasFoughtThug1", true));
                addRequirement(new FlagRequirement("hasFoughtThug3", true));
               


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("You beat the other two guys...\n I guess they're not as cool as I thought they were."));
                    addScriptAction(new TextboxScriptAction("Here's the purse, its not worth fighting over."));
                    addScriptAction(new TextboxScriptAction("*The thug hands you the purse and walks away*"));
                 }});
                 addScriptAction(new NPCChangeVisibilityScriptAction(Visibility.HIDDEN));
                 addScriptAction(new ChangeFlagScriptAction("hasFoughtThug2", true));
                 addScriptAction(new ChangeFlagScriptAction("hasFoughtAllThugs", true));
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
    