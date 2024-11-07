package Scripts.TestMap;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.*;
import Utils.Direction;


public class FishScript extends Script {

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

        // scriptActions.add(new ConditionalScriptAction() {{
        //     addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
        //         addRequirement(new FlagRequirement("hasQuest", true));
        //         addRequirement(new FlagRequirement("hasQuestMuggedWoman", false));



        //          addScriptAction(new TextboxScriptAction() {{
        //             addScriptAction(new TextboxScriptAction("You already Have a Quest."));
        //          }});
        //     }});

        // }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasSavedFish", false));
                addRequirement(new FlagRequirement("hasFireTome ", false));
                addRequirement(new FlagRequirement("hasFishBlessing", false));
                addRequirement(new FlagRequirement("hasTalkedToFish", false));

                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("Theres a fish stuck under this ice..."));
                    addScriptAction(new TextboxScriptAction("If only I had something that could get \nrid of the ice."));
                 }});
            }});

        }});


        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("haFireTome", true));
                addRequirement(new FlagRequirement("hasSavedFish", false));

                addScriptAction(new WaitScriptAction(30));

                 addScriptAction(new NPCStandScriptAction(Direction.RIGHT));
                // scriptActions.add(new UnlockPlayerScriptAction());
                addScriptAction(new NPCWalkScriptAction(Direction.DOWN, 750, 4));
                addScriptAction(new NPCWalkScriptAction(Direction.LEFT, 670, 4));
                addScriptAction(new NPCStandScriptAction(Direction.RIGHT));
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasSavedFish", true));
                addRequirement(new FlagRequirement("hasTalkedToFish", true));
                addRequirement(new FlagRequirement("hasFishBlessing", true));

                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("Thank Thimineur I'm a fish, \notherwise I would have cold feet."));
                 }});
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasSavedFish", true));
                addRequirement(new FlagRequirement("hasTalkedToFish", true));
                addRequirement(new FlagRequirement("hasFishBlessing", false));


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("No redos bucko."));
                 }});
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasSavedFish", true));

                 addScriptAction(new TextboxScriptAction() {{
                    //addText("You seem worthy...");
                    addText("Sorry I can't give you much even though you save me, \nsince im a fish.");
                    addText("but I can give you a fish blessing.");
                    addText("Accept the fish blessing?", new String[] { "Yes", "No" });
                 }});
            }});   
        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasSavedFish", true));
                addRequirement(new CustomRequirement() {
                    @Override
                    public boolean isRequirementMet() {
                        int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                        return answer == 0;
        
                    }
                });

                 addScriptAction(new TextboxScriptAction() {{
                     addText("The fish twidles his toes in your direction,\n you feel warmer.");

                 }});
                addScriptAction(new ChangeFlagScriptAction("hasTalkedToFish", true));
                addScriptAction(new ChangeFlagScriptAction("hasFishBlessing", true));
            }});

            
        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasSavedFish", false));
                addRequirement(new CustomRequirement() {
                    @Override
                    public boolean isRequirementMet() {
                        int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                        return answer == 1;
        
                    }
                });

                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("Hmph, your loss."));
                 }});
                 addScriptAction(new ChangeFlagScriptAction("hasTalkedToFish", true));
            }});

        }});

        // scriptActions.add(new ConditionalScriptAction() {{
        //     addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
        //         addRequirement(new FlagRequirement("hasQuestMuggedWoman", true));
        //         addRequirement(new FlagRequirement("hasCompletedQuestMuggedWoman", false));
        //         addRequirement(new FlagRequirement("hasFoughtThug1", true));
        //         addRequirement(new FlagRequirement("hasFoughtThug2", true));
        //         addRequirement(new FlagRequirement("hasFoughtThug3", true));
               


        //          addScriptAction(new TextboxScriptAction() {{
        //             addScriptAction(new TextboxScriptAction("Ahh! you found it! you're such a splendid\nyoung adventurer."));
        //             addScriptAction(new TextboxScriptAction("Have these coins as a reward.\nsorry its so little for what you did."));

        //          }});
        //          addScriptAction(new ChangeFlagScriptAction("hasCompletedQuestMuggedWoman", true));
        //          addScriptAction(new ChangeFlagScriptAction("hasQuest", false));
        //     }});

        // }});

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
    