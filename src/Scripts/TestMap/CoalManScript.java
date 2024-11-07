package Scripts.TestMap;

import java.util.ArrayList;

import Level.Enemy;
import Level.Script;
import ScriptActions.*;
import Utils.Direction;


public class CoalManScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCLockScriptAction());

        //scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new ConditionalScriptAction());
        
      //farmer chicken finding man
        
        // scriptActions.add(new TextboxScriptAction() {{
        //     addText("You seem worthy...");
        //     addText("Would you like to go on a journey?", new String[] { "Yes", "No" });
        // }});

        // scriptActions.add(new ConditionalScriptAction() {{
        //     addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
        //         addRequirement(new FlagRequirement("hasQuest", true));
        //         addRequirement(new FlagRequirement("hasQuestSnowMan", false));



        //          addScriptAction(new TextboxScriptAction() {{
        //             addScriptAction(new TextboxScriptAction("You already Have a Quest."));
        //          }});
        //     }});

        // }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasCoal", true));


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("Come back anytime you need more coals!."));
                 }});
            }});

        }});


        // scriptActions.add(new ConditionalScriptAction() {{
        //     addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
        //         addRequirement(new FlagRequirement("hasQuestSnowman", false));
        //         addRequirement(new FlagRequirement("hasQuest", false));

        //          addScriptAction(new TextboxScriptAction() {{
        //             //addText("You seem worthy...");
        //             addText("Hey you!");
        //             addText("Mind collectiong some coals for me, \nSome man took mine.");
        //             addText("Help it?", new String[] { "Yes", "No" });
        //          }});
        //     }});   
        // }});

        // scriptActions.add(new ConditionalScriptAction() {{
        //     addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
        //         addRequirement(new FlagRequirement("hasQuestSnowman", false));
        //         addRequirement(new FlagRequirement("hasQuest", false));
        //         addRequirement(new CustomRequirement() {
        //             @Override
        //             public boolean isRequirementMet() {
        //                 int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
        //                 return answer == 0;
        
        //             }
        //         });

        //          addScriptAction(new TextboxScriptAction() {{
        //              addText("They should be by that cabin over there.");
        //              addText("Try not to get caught by him.");

        //          }});
        //         addScriptAction(new ChangeFlagScriptAction("hasQuestSnowman", true));
        //         addScriptAction(new ChangeFlagScriptAction("hasQuest", true));
        //     }});

            
        // }});

        // scriptActions.add(new ConditionalScriptAction() {{
        //     addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
        //         addRequirement(new FlagRequirement("hasQuestSnowman", false));
        //         addRequirement(new FlagRequirement("hasQuest", false));
        //         addRequirement(new CustomRequirement() {
        //             @Override
        //             public boolean isRequirementMet() {
        //                 int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
        //                 return answer == 1;
        
        //             }
        //         });

        //          addScriptAction(new TextboxScriptAction() {{
        //             addScriptAction(new TextboxScriptAction("If only I could walk over there and \ngrab them myself."));
        //          }});
                
        //     }});

        // }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestSnowman", true));
                addRequirement(new FlagRequirement("hasCompletedQuestSnowman", false));
                addRequirement(new FlagRequirement("hasCoal", false));
               


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("You reach your hand into the bucket of coals."));
                    addScriptAction(new WaitScriptAction(70));
                    addScriptAction(new TextboxScriptAction("Hey you there!"));
                    addScriptAction(new TextboxScriptAction("Stop trying to rob me of my coals!"));

                    scriptActions.add(new StartFightScriptAction(new Enemy("CoalMan", 75, 10, 2, "CoalManFight.png", 30, 30)));
                    addScriptAction(new NPCStandScriptAction(Direction.RIGHT));
                scriptActions.add(new ChangeFlagScriptAction("isFighting", true));
                

                addScriptAction(new TextboxScriptAction("Wow you're strong you really kicked my but there."));
                addScriptAction(new TextboxScriptAction("Take all the coals you want you deserve them."));
                addScriptAction(new TextboxScriptAction("Think you could say sorry to that snowman for me."));
                addScriptAction(new TextboxScriptAction("Lifes rough with that evil king running the kingdom\n and I couldn't just freeze to death this winter."));

                 }});
                 addScriptAction(new ChangeFlagScriptAction("hasCoal", true));
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
    