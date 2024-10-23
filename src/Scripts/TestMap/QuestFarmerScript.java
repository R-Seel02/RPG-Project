package Scripts.TestMap;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.*;


public class QuestFarmerScript extends Script {

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
                addRequirement(new FlagRequirement("hasQuestFarmer", false));



                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("You already Have a Quest."));
                 }});
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasCompletedQuestFarmer", true));


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("Thanks for the help kiddo, \n hope those coins helped you out a bit"));
                 }});
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestFarmer", true));
                addRequirement(new FlagRequirement("hasCompletedQuestFarmer", false));
                addRequirement(new FlagRequirement("hasTalkedToChickenRed", false));
                addRequirement(new FlagRequirement("hasTalkedToChickenGreen", false));
                addRequirement(new FlagRequirement("hasTalkedToChickenYellow", false));
                addRequirement(new FlagRequirement("hasTalkedToChickenBlue", false));
                addRequirement(new FlagRequirement("hasTalkedToChickenOrange", false));


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("Have you found all my chickens yet?"));
                    addScriptAction(new TextboxScriptAction("No? well get back to searching \nthey couldn't have gone far."));
                 }});
                
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestFarmer", false));
                addRequirement(new FlagRequirement("hasQuest", false));

                 addScriptAction(new TextboxScriptAction() {{
                    //addText("You seem worthy...");
                    addText("Hello young traveler!");
                    addText("My good for nothing son \nlet all the chickens out of the coop.");
                    addText("Mind fetching all 5 of them for me?", new String[] { "Yes", "No" });
                 }});
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
                        return answer == 0;
        
                    }
                });

                 addScriptAction(new TextboxScriptAction() {{
                     addText("Thanks for the help, \nthey should all be around town somewhere.");
                     addText("You should check on the Red one first \n He'll probably head back.");
                     addText("good luck searching for them.");
                 }});
                addScriptAction(new ChangeFlagScriptAction("hasQuestFarmer", true));
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
                    addScriptAction(new TextboxScriptAction("Are you sure, I'll give you some coins!"));
                 }});
                
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestFarmer", true));
                addRequirement(new FlagRequirement("hasCompletedQuestFarmer", false));
                addRequirement(new FlagRequirement("hasTalkedToChickenRed", true));
                addRequirement(new FlagRequirement("hasTalkedToChickenGreen", true));
                addRequirement(new FlagRequirement("hasTalkedToChickenYellow", true));
                addRequirement(new FlagRequirement("hasTalkedToChickenBlue", true));
                addRequirement(new FlagRequirement("hasTalkedToChickenOrange", true));


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("Thanks a lot!"));
                    addScriptAction(new TextboxScriptAction("Have these coins as a reward!"));
                    addScriptAction(new AddCoin("hasQuestFarmer"));
                    addScriptAction(new WaitScriptAction(10));
                    addScriptAction(new AddCoin("hasQuestFarmer"));
                    addScriptAction(new WaitScriptAction(10));
                    addScriptAction(new AddCoin("hasQuestFarmer"));
                    addScriptAction(new WaitScriptAction(10));
                    addScriptAction(new AddCoin("hasQuestFarmer"));
                    addScriptAction(new WaitScriptAction(10));
                    addScriptAction(new AddCoin("hasQuestFarmer"));
                    addScriptAction(new TextboxScriptAction("Spend those coins wisely I'll see you around!"));
                 }});
                 addScriptAction(new ChangeFlagScriptAction("hasCompletedQuestFarmer", true));
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
    