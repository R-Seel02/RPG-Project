package Scripts.TestMap;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.*;


public class PlagueDoctorScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCLockScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new ConditionalScriptAction());
        
      //farmer chicken finding man
        
        // scriptActions.add(new TextboxScriptAction() {{
        //     addText("You seem worthy...");
        //     addText("Would you like to go on a journey?", new String[] { "Yes", "No" });
        // }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuest", true));
                addRequirement(new FlagRequirement("hasQuestPlagueDoctor", false));



                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("You already Have a Quest."));
                 }});
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasCompletedQuestPlagueDoctor", true));


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("Ahhh! The reliable fellow has returned!"));
                    addScriptAction(new TextboxScriptAction("I hope thine has put my masterpiece to good use!"));
                 }});
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestPlagueDoctor", true));
                addRequirement(new FlagRequirement("hasCompletedQuestPlagueDoctor", false));
                addRequirement(new FlagRequirement("hasCauldron", true));
                addRequirement(new FlagRequirement("hasFrog", false));
                addRequirement(new FlagRequirement("hasPurpleFlower", false));
                addRequirement(new FlagRequirement("hasVial", false));
                addRequirement(new FlagRequirement("hasEyeball", false));
                


                 addScriptAction(new TextboxScriptAction() {{
                    addText("Marvelous! If thine wouldn't mind finding me a frog.");
                    addText("My potion would falter without it.");
                    addText("Be on your way.");
                 }});
                 addScriptAction(new ChangeFlagScriptAction("textCauldron", true));
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestPlagueDoctor", true));
                addRequirement(new FlagRequirement("hasCompletedQuestPlagueDoctor", false));
                addRequirement(new FlagRequirement("hasCauldron", true));
                addRequirement(new FlagRequirement("hasFrog", true));
                addRequirement(new FlagRequirement("hasPurpleFlower", false));
                addRequirement(new FlagRequirement("hasVial", false));
                addRequirement(new FlagRequirement("hasEyeball", false));
                


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("What a wonderful specimen!"));
                    addScriptAction(new TextboxScriptAction("I now require a Purple flower!"));
                    addScriptAction(new TextboxScriptAction("The stench of my masterpiece would be deplorable\n without it."));
                 }});
                 addScriptAction(new ChangeFlagScriptAction("textFrog", true));
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestPlagueDoctor", true));
                addRequirement(new FlagRequirement("hasCompletedQuestPlagueDoctor", false));
                addRequirement(new FlagRequirement("hasCauldron", true));
                addRequirement(new FlagRequirement("hasFrog", true));
                addRequirement(new FlagRequirement("hasPurpleFlower", true));
                addRequirement(new FlagRequirement("hasVial", false));
                addRequirement(new FlagRequirement("hasEyeball", false));
                


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("The scent of this flower is splendid!"));
                    addScriptAction(new TextboxScriptAction("Find me a vial now."));
                    addScriptAction(new TextboxScriptAction("We need something to store it in of course!"));
                 }});
                 addScriptAction(new ChangeFlagScriptAction("textPurpleFlower", true));
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestPlagueDoctor", true));
                addRequirement(new FlagRequirement("hasCompletedQuestPlagueDoctor", false));
                addRequirement(new FlagRequirement("hasCauldron", true));
                addRequirement(new FlagRequirement("hasFrog", true));
                addRequirement(new FlagRequirement("hasPurpleFlower", true));
                addRequirement(new FlagRequirement("hasVial", true));
                addRequirement(new FlagRequirement("hasEyeball", false));
                


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("This vial is so sturdy a dragon \n could never break it!"));
                    addScriptAction(new TextboxScriptAction("Now for the hardest task of them all!"));
                    addScriptAction(new TextboxScriptAction("Collect the living Eyeball of the forest for me."));
                    addScriptAction(new TextboxScriptAction("It should prove quite the challenge but I \ntrust your resilience"));
                 }});
                 addScriptAction(new ChangeFlagScriptAction("textVial", true));
            }});

        }});


        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestPlagueDoctor", false));
                addRequirement(new FlagRequirement("hasQuest", false));

                 addScriptAction(new TextboxScriptAction() {{
                    //addText("You seem worthy...");
                    addText("Hello Good Sire!");
                    addText("I'm in the process of making the most\n exquisite potion known to man!");
                    addText("Would you like to help thine fellow for a reward \n perchance!");
                    addText("Help him?", new String[] { "Yes", "No" });
                 }});
            }});   
        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestPlagueDoctor", false));
                addRequirement(new FlagRequirement("hasQuest", false));
                addRequirement(new CustomRequirement() {
                    @Override
                    public boolean isRequirementMet() {
                        int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                        return answer == 0;
        
                    }
                });

                 addScriptAction(new TextboxScriptAction() {{
                     addText("I knew you were a fine young adventurer!");
                     addText("Fetch me the witches cauldron.");
                     addText("Just be cautious when claiming it.");
                     addText("Witches can be unpredictable.");
                 }});
                addScriptAction(new ChangeFlagScriptAction("hasQuestPlagueDoctor", true));
                addScriptAction(new ChangeFlagScriptAction("hasQuest", true));
            }});

            
        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestPlagueDoctor", false));
                addRequirement(new FlagRequirement("hasQuest", false));
                addRequirement(new CustomRequirement() {
                    @Override
                    public boolean isRequirementMet() {
                        int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                        return answer == 1;
        
                    }
                });

                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("Hmph! you'll regret this!"));
                 }});
                
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestPlagueDoctor", true));
                addRequirement(new FlagRequirement("hasCompletedQuestFarmer", false));
                addRequirement(new FlagRequirement("hasCauldron", true));
                addRequirement(new FlagRequirement("hasFrog", true));
                addRequirement(new FlagRequirement("hasPurpleFlower", true));
                addRequirement(new FlagRequirement("hasVial", true));
                addRequirement(new FlagRequirement("hasEyeball", true));
               


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("Finally, my creation can finally be completed!"));
                    addScriptAction(new WaitScriptAction(100));
                    addScriptAction(new TextboxScriptAction("Superb! The concoction wroked!"));
                    addScriptAction(new TextboxScriptAction("You've impressed me greatly young adventurer."));
                    addScriptAction(new TextboxScriptAction("Have this portion of my masterpiece in exchange \n for your service!"));
                    addScriptAction(new TextboxScriptAction("Enjoy your travels!"));
                 }});
                 addScriptAction(new ChangeFlagScriptAction("hasCompletedQuestPlagueDoctor", true));
                 addScriptAction(new ChangeFlagScriptAction("hasQuest", false));
                 addScriptAction(new ChangeFlagScriptAction("textEyeball", true));
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
    