package Scripts.TestMap;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.*;
import Utils.Direction;


public class SnowmanScript extends Script {

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
                addRequirement(new FlagRequirement("hasQuestSnowman", false));



                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("You already Have a Quest."));
                 }});
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuest", true));
                addRequirement(new FlagRequirement("hasQuestSnowman", true));
                addRequirement(new FlagRequirement("hasCoal", false));



                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("Snowmen can't talk."));
                 }});
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasCompletedQuestSnowman", true));


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("Thanks for taking that book off my stick hands,\nit almost made me melt."));
                 }});
            }});

        }});


        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestSnowman", false));
                addRequirement(new FlagRequirement("hasQuest", false));

                 addScriptAction(new TextboxScriptAction() {{
                    //addText("You seem worthy...");
                    addText("Hey you!");
                    addText("Mind collectiong some coals for me, \nSome man took mine.");
                    addText("Help it?", new String[] { "Yes", "No" });
                 }});
            }});   
        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestSnowman", false));
                addRequirement(new FlagRequirement("hasQuest", false));
                addRequirement(new CustomRequirement() {
                    @Override
                    public boolean isRequirementMet() {
                        int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                        return answer == 0;
        
                    }
                });

                 addScriptAction(new TextboxScriptAction() {{
                     addText("They should be by that cabin over there.");
                     addText("Try not to get caught by him.");

                 }});
                addScriptAction(new ChangeFlagScriptAction("hasQuestSnowman", true));
                addScriptAction(new ChangeFlagScriptAction("hasQuest", true));
            }});

            
        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestSnowman", false));
                addRequirement(new FlagRequirement("hasQuest", false));
                addRequirement(new CustomRequirement() {
                    @Override
                    public boolean isRequirementMet() {
                        int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                        return answer == 1;
        
                    }
                });

                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("If only I could walk over there and \ngrab them myself."));
                 }});
                
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestSnowman", true));
                addRequirement(new FlagRequirement("hasCompletedQuestSnowman", false));
                addRequirement(new FlagRequirement("hasCoal", true));
               


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new NPCStandScriptAction(Direction.LEFT));
                    addScriptAction(new TextboxScriptAction("Wow thanks a lot!."));
                    addScriptAction(new TextboxScriptAction("I can look happy again! :)."));
                    addScriptAction(new TextboxScriptAction("The coal theif apologizes to me?"));
                    addScriptAction(new TextboxScriptAction("I'd care but im a snowman,\nI don't have a brain to reason with."));
                    addScriptAction(new TextboxScriptAction("Im gonna go back to doing snowman things."));
                    addScriptAction(new TextboxScriptAction("Have this book for helping me.\nI can't use it anyway."));

                 }});
                 addScriptAction(new ChangeFlagScriptAction("hasCompletedQuestSnowman", true));
                 addScriptAction(new ChangeFlagScriptAction("hasQuest", false));
                 addScriptAction(new ChangeFlagScriptAction("hasFireTome", true));
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
    