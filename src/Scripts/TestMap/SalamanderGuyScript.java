package Scripts.TestMap;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.*;
import Utils.Direction;


public class SalamanderGuyScript extends Script {

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

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuest", true));
                addRequirement(new FlagRequirement("hasQuestSalamanderGuy", false));



                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("You already Have a Quest."));
                 }});
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasCompletedQuestSalamanderGuy", true));


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("I'm so happy now I might just do a little jig!!"));
                    addScriptAction(new NPCWalkScriptAction(Direction.LEFT, 0, 0));
                    //make him dance.
                 }});
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestSalamanderGuy", true));
                addRequirement(new FlagRequirement("hasCompletedQuestSalamanderGuy", false));
                addRequirement(new FlagRequirement("hasSalamander1", false));
                addRequirement(new FlagRequirement("hasSalamander2", false));
                addRequirement(new FlagRequirement("hasSalamander3", false));


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("Pretty sure Charles is still on the loose."));
                    addScriptAction(new TextboxScriptAction("He should be behind the volcano."));
                    addScriptAction(new TextboxScriptAction("He loves those natural lava springs."));
                 }});
                
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestSalamanderGuy", true));
                addRequirement(new FlagRequirement("hasCompletedQuestSalamanderGuy", false));
                addRequirement(new FlagRequirement("hasSalamander1", true));
                addRequirement(new FlagRequirement("hasSalamander2", false));
                addRequirement(new FlagRequirement("hasSalamander3", false));


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("Have you found Gregory yet?."));
                    addScriptAction(new TextboxScriptAction("Hes probably behind a rock somewhere hes very shy."));
                 }});
                 addScriptAction(new ChangeFlagScriptAction("return1", true));
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestSalamanderGuy", true));
                addRequirement(new FlagRequirement("hasCompletedQuestSalamanderGuy", false));
                addRequirement(new FlagRequirement("hasSalamander1", true));
                addRequirement(new FlagRequirement("hasSalamander2", true));
                addRequirement(new FlagRequirement("hasSalamander3", false));


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("Jeremy is a slipery one."));
                    addScriptAction(new TextboxScriptAction("try to get in his way to catch him!"));
                 }});
                 addScriptAction(new ChangeFlagScriptAction("return2", true));
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestSalamanderGuy", false));
                addRequirement(new FlagRequirement("hasQuest", false));

                 addScriptAction(new TextboxScriptAction() {{
                    //addText("You seem worthy...");
                    addText("Exscuse me young adventurer!");
                    addText("Mind running a task for me I'm a little busy!.");
                    addText("It won't take long!", new String[] { "Yes", "No" });
                 }});
            }});   
        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestSalamanderGuy", false));
                addRequirement(new FlagRequirement("hasQuest", false));
                addRequirement(new CustomRequirement() {
                    @Override
                    public boolean isRequirementMet() {
                        int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                        return answer == 0;
        
                    }
                });

                 addScriptAction(new TextboxScriptAction() {{
                     addText("Thanks a lot for the help.");
                     addText("I've been trying to catch some salamanders nearby\nbut they're all too hard to catch..");
                     addText("Think you could find 3 of them for me.");
                     addText("The first one should be by the volcano somewhere.\nI call him Charles.");
                     addText("He tends to hang out around the lava springs,\nbe careful not to burn yourself!");
                 }});
                addScriptAction(new ChangeFlagScriptAction("hasQuestSalamanderGuy", true));
                addScriptAction(new ChangeFlagScriptAction("hasQuest", true));
            }});

            
        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestFarmer", false));
                addRequirement(new FlagRequirement("hasQuest", false));
                addRequirement(new CustomRequirement() {
                    @Override
                    public boolean isRequirementMet() {
                        int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                        return answer == 1;
        
                    }
                });

                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("You sure?? I'll help you out in return!"));
                 }});
                
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestSalamanderGuy", true));
                addRequirement(new FlagRequirement("hasCompletedQuestSalamanderGuy", false));
                addRequirement(new FlagRequirement("hasSalamander1", true));
                addRequirement(new FlagRequirement("hasSalamander2", true));
                addRequirement(new FlagRequirement("hasSalamander3", true));

                 addScriptAction(new TextboxScriptAction() {{
                    
                    addScriptAction(new TextboxScriptAction("I trust you a lot adventurer!\nI'm sure you could beat that evil king!"));
                    addScriptAction(new TextboxScriptAction("I think its time I show you who I really am."));
                    addScriptAction(new NPCStandScriptAction(Direction.RIGHT));
                    addScriptAction(new TextboxScriptAction("*You hear a zipper sound.\nIt was a salamander in a human costume??*"));
                    addScriptAction(new TextboxScriptAction("The evil king hates salamanders so I had to hide.\nBut with you around I feel so safe."));
                    addScriptAction(new TextboxScriptAction("thanks a lot adventurer!"));
                    addScriptAction(new TextboxScriptAction("Have this book in return\n I'm sure it'll be of good use to you."));
                    addScriptAction(new TextboxScriptAction("Good luck beating up that evil king\n I'll be rooting for you!"));
                 }});
                 addScriptAction(new ChangeFlagScriptAction("hasCompletedQuestSalamanderGuy", true));
                 addScriptAction(new ChangeFlagScriptAction("return3", true));
                 addScriptAction(new ChangeFlagScriptAction("hasQuest", false));
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
    