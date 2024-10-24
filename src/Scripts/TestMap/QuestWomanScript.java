package Scripts.TestMap;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.*;


public class QuestWomanScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCLockScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new ConditionalScriptAction());
        
        //addScriptAction(new TextboxScriptAction("If I remember correctly, \n the note said theres a weapon somewhere aquatic."));
        //addScriptAction(new TextboxScriptAction("Who knows what was going through my head that night."));
        
        // scriptActions.add(new TextboxScriptAction() {{
        //     addText("You seem worthy...");
        //     addText("Would you like to go on a journey?", new String[] { "Yes", "No" });
        // }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuest", true));
                addRequirement(new FlagRequirement("hasQuestWoman", false));



                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("You already Have a Quest."));
                 }});
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasCompletedQuestWoman", true));


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("I could really go for some root beer right about now."));
                    addScriptAction(new TextboxScriptAction("Might have to head to the inn later."));
                 }});
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestWoman", true));
                addRequirement(new FlagRequirement("hasCompletedQuestWoman", false));
                addRequirement(new FlagRequirement("hasBottle", false));
                addRequirement(new FlagRequirement("hasQuest", true));


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("Still haven't found it yet?"));
                    addScriptAction(new TextboxScriptAction("Pretty sure its still in the fountain."));
                    addScriptAction(new TextboxScriptAction("objects can't move themselves afterall."));
                    addScriptAction(new TextboxScriptAction("right?"));
                 }});
                
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestWoman", false));
                addRequirement(new FlagRequirement("hasQuest", false));

                 addScriptAction(new TextboxScriptAction() {{
                    //addText("You seem worthy...");
                    addText("You mind helping me out a bit?", new String[] { "Yes", "No" });
                 }});
            }});   
        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestWoman", false));
                addRequirement(new FlagRequirement("hasQuest", false));
                addRequirement(new CustomRequirement() {
                    @Override
                    public boolean isRequirementMet() {
                        int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                        return answer == 0;
        
                    }
                });

                 addScriptAction(new TextboxScriptAction() {{
                     addText("My mind is a bit fuzzy from last night but I think \nI dropped something in the fountain last night.");
                     addText("Mind fetching it for me.");
                     addText("I'll reward you if you do.");
                 }});
                addScriptAction(new ChangeFlagScriptAction("hasQuestWoman", true));
                addScriptAction(new ChangeFlagScriptAction("hasQuest", true));
            }});

            
        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestWoman", false));
                addRequirement(new FlagRequirement("hasQuest", false));
                addRequirement(new CustomRequirement() {
                    @Override
                    public boolean isRequirementMet() {
                        int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                        return answer == 1;
        
                    }
                });

                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("damn..."));
                 }});
                
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestWoman", true));
                addRequirement(new FlagRequirement("hasBottle", true));
                addRequirement(new FlagRequirement("hasCompletedQuestWoman", false));


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("So this is what I dropped in there?"));
                    addScriptAction(new TextboxScriptAction("Theres a note in it?"));
                    addScriptAction(new TextboxScriptAction("The lord of the deep..."));
                    addScriptAction(new TextboxScriptAction("may his weapon awaken to unleash \ndevestation upon the evils of this world."));
                    addScriptAction(new TextboxScriptAction("The day he is retrieved from his aquatic domain \nwill be their reckoning"));
                    addScriptAction(new TextboxScriptAction("Mrs. Richardson"));
                    addScriptAction(new TextboxScriptAction("I wrote this... \n wow..."));
                    addScriptAction(new TextboxScriptAction("I should stop drinking all that root beer at the inn..."));
                    addScriptAction(new TextboxScriptAction("Sorry to waste your time with something like this..."));
                    addScriptAction(new TextboxScriptAction("Have some coins in return."));
                 }});
                 addScriptAction(new ChangeFlagScriptAction("hasCompletedQuestWoman", true));
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
    