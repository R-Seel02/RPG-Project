package Scripts.TestMap;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.*;


public class BirdScript2 extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCLockScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new ConditionalScriptAction());

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestFarmer", true));
                addRequirement(new FlagRequirement("hasCompletedQuestFarmer", false));
                addRequirement(new FlagRequirement("hasTalkedToChickenRed", true));
                addRequirement(new FlagRequirement("hasTalkedToChickenYellow", true));
                addRequirement(new FlagRequirement("hasTalkedToChickenOrange", true));
                addRequirement(new FlagRequirement("hasTalkedToChickenBlue", false));


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("I'm not a chicken..."));
                 }});
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuest", true));
                addRequirement(new FlagRequirement("hasQuestBird", false));



                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("You already Have a Quest."));
                 }});
            }});

        }});

        
      
        
        // scriptActions.add(new TextboxScriptAction() {{
        //     addText("You seem worthy...");
        //     addText("Would you like to go on a journey?", new String[] { "Yes", "No" });
        // }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasCompletedQuestBird", true));


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("I wish you luck on your future journeys!"));
                 }});
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestBird", true));
                addRequirement(new FlagRequirement("hasCompletedQuestBird", false));
                addRequirement(new FlagRequirement("hasAxe", false));


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("It appears that you have yet to find my axe..."));
                    addScriptAction(new TextboxScriptAction("I believe the RED man still has it."));
                 }});
                
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestBird", false));
                addRequirement(new FlagRequirement("hasQuest", false));

                 addScriptAction(new TextboxScriptAction() {{
                    addText("You seem worthy...");
                    addText("Would you like to go on a journey?", new String[] { "Yes", "No" });
                 }});
            }});   
        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestBird", false));
                addRequirement(new FlagRequirement("hasQuest", false));
                addRequirement(new CustomRequirement() {
                    @Override
                    public boolean isRequirementMet() {
                        int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                        return answer == 0;
        
                    }
                });

                 addScriptAction(new TextboxScriptAction() {{
                     addText("My axe has been taken by the RED man...");
                     addText("please retrieve it for me.");
                 }});
                addScriptAction(new ChangeFlagScriptAction("hasQuestBird", true));
                addScriptAction(new ChangeFlagScriptAction("hasQuest", true));
            }});

            
        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestBird", false));
                addRequirement(new FlagRequirement("hasQuest", false));
                addRequirement(new CustomRequirement() {
                    @Override
                    public boolean isRequirementMet() {
                        int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                        return answer == 1;
        
                    }
                });

                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("What a pity..."));
                 }});
                
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestBird", true));
                addRequirement(new FlagRequirement("hasAxe", true));
                addRequirement(new FlagRequirement("hasCompletedQuestBird", false));


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("Well done!"));
                    addScriptAction(new TextboxScriptAction("As a token of my appreciation you can keep the axe."));
                 }});
                 addScriptAction(new ChangeFlagScriptAction("hasCompletedQuestBird", true));
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
    