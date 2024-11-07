package Scripts.TestMap;

import java.util.ArrayList;

import Level.Enemy;
import Level.Script;
import ScriptActions.*;
import Utils.Visibility;


public class Thug1Script extends Script {

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
                addRequirement(new FlagRequirement("hasFoughtThug3", true));
               


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("So you beat my two bros? \n hmph, they're not real brawling champs anyways."));
                    addScriptAction(new TextboxScriptAction("Let me show you how a reeaalll pro fights."));

                    scriptActions.add(new StartFightScriptAction(new Enemy("Thug", 75, 7, 2, "Thug1.png")));

                scriptActions.add(new ChangeFlagScriptAction("isFighting", true));

                addScriptAction(new TextboxScriptAction("Jeez bro you could've mentioned you were a pro \nbrawler I would've just given the purse back."));
                addScriptAction(new TextboxScriptAction("I'll get you next time for sure!."));
                addScriptAction(new TextboxScriptAction("*The thug runs away, dropping the purse*"));

                 }});
                 addScriptAction(new NPCChangeVisibilityScriptAction(Visibility.HIDDEN));
                 addScriptAction(new ChangeFlagScriptAction("hasFoughtThug1", true));
                 addScriptAction(new ChangeFlagScriptAction("hasFoughtAllThugs", true));
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestMuggedWoman", true));
                addRequirement(new FlagRequirement("hasCompletedQuestMuggedWoman", false));
                addRequirement(new FlagRequirement("hasPurse", false));
                addRequirement(new FlagRequirement("hasFoughtThug1", false));
               


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("So you want that purse back\nWell lets brawl for it!"));

                    scriptActions.add(new StartFightScriptAction(new Enemy("Thug", 75, 7, 2, "Thug1.png")));

                scriptActions.add(new ChangeFlagScriptAction("isFighting", true));

                addScriptAction(new TextboxScriptAction("Holy Thimineur you're quite the brawling champ!."));
                addScriptAction(new TextboxScriptAction("Too bad for you I don't have the purse.\n Better luck next time."));
                addScriptAction(new TextboxScriptAction("*The thug runs away*"));

                 }});
                 addScriptAction(new NPCChangeVisibilityScriptAction(Visibility.HIDDEN));
                 addScriptAction(new ChangeFlagScriptAction("hasFoughtThug1", true));
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
    