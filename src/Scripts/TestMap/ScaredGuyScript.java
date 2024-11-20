package Scripts.TestMap;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.*;


public class ScaredGuyScript extends Script {

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
                addRequirement(new FlagRequirement("hasQuestScaredGuy", false));



                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("You already Have a Quest."));
                 }});
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasCompletedQuestScaredGuy", true));


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("Chester better watch his back next time.\nI'll be sure to prank him next."));
                 }});
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestScaredGuy", true));
                addRequirement(new FlagRequirement("hasCompletedQuestScaredGuy", false));
                addRequirement(new FlagRequirement("hasFoughtCactus", false));


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("Have you killed it yet?"));
                    addScriptAction(new TextboxScriptAction("NO?!?! He could be watching us as we speak!!."));
                    addScriptAction(new TextboxScriptAction("FIND HIM!"));
                 }});
                
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestScaredGuy", false));
                addRequirement(new FlagRequirement("hasQuest", false));

                 addScriptAction(new TextboxScriptAction() {{
                    //addText("You seem worthy...");
                    addText("Hey kiddo, I got a quest for you?", new String[] { "Yes", "No" });
                 }});
            }});   
        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestScaredGuy", false));
                addRequirement(new FlagRequirement("hasQuest", false));
                addRequirement(new CustomRequirement() {
                    @Override
                    public boolean isRequirementMet() {
                        int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                        return answer == 0;
        
                    }
                });

                 addScriptAction(new TextboxScriptAction() {{
                     addText("I could swear one of these cacti moves everynight.");
                     addText("I don't know which one though my age is getting\nthe best of me.");
                     addText("But I believe it has a flower on it.");
                     addText("Find it please and I'll reward you handsomly.");
                 }});
                addScriptAction(new ChangeFlagScriptAction("hasQuestScaredGuy", true));
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
                    addScriptAction(new TextboxScriptAction("I don't blame you, but watch your back around here\nyou never know who might sneak up on you."));
                 }});
                
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestScaredGuy", true));
                addRequirement(new FlagRequirement("hasFoughtCactus", true));
                addRequirement(new FlagRequirement("hasCompletedQuestScaredGuy", false));


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("You beat it up??\namazing!"));
                    addScriptAction(new TextboxScriptAction("There was a small man in the cactus??."));
                    addScriptAction(new TextboxScriptAction("Dammit that must've been CHESTER!"));
                    addScriptAction(new TextboxScriptAction("I've lost so much sleep over his petty little pranks."));
                    addScriptAction(new TextboxScriptAction("Well Chester aside, thanks for the help."));
                    addScriptAction(new TextboxScriptAction("Have these coins and this weapon as a reward \nfor halting his shenanigans."));
                    addScriptAction(new TextboxScriptAction("Hope you'll put that weapon to good use!"));
                 }});
                 addScriptAction(new ChangeFlagScriptAction("hasCompletedQuestScaredGuy", true));
                 addScriptAction(new ChangeFlagScriptAction("hasQuest", false));
                 addScriptAction(new AddCoin("hasCompletedQuestScaredGuy",20));
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
    