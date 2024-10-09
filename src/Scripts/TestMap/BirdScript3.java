package Scripts.TestMap;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.*;


public class BirdScript3 extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCLockScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new ConditionalScriptAction());
        

        
        // scriptActions.add(new TextboxScriptAction() {{
        //     addText("You seem worthy...");
        //     addText("Would you like to go on a journey?", new String[] { "Yes", "No" });
        // }});


        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuest1", false));

                 addScriptAction(new TextboxScriptAction() {{
                    addText("You seem worthy...");
                    addText("Would you like to go on a journey?", new String[] { "Yes", "No" });
                 }});
            }});  
            
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
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
                addScriptAction(new ChangeFlagScriptAction("hasQuest1", true));
                addScriptAction(new ChangeFlagScriptAction("hasQuest", true));
            }});

            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
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

            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuest1", true));
                addRequirement(new FlagRequirement("hasCompletedQuest1", false));


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("It appears that you have yet to find my axe..."));
                    addScriptAction(new TextboxScriptAction("I believe the RED man still has it."));
                 }});
                
            }});
            
        }});

        // scriptActions.add(new ConditionalScriptAction() {{
        //     addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
        //         addRequirement(new FlagRequirement("hasQuest1", false));
        //         addRequirement(new CustomRequirement() {
        //             @Override
        //             public boolean isRequirementMet() {
        //                 int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
        //                 return answer == 0;
        
        //             }
        //         });

        //          addScriptAction(new TextboxScriptAction() {{
        //              addText("My axe has been taken by the RED man...");
        //              addText("please retrieve it for me.");
        //          }});
        //         addScriptAction(new ChangeFlagScriptAction("hasQuest1", true));
        //         addScriptAction(new ChangeFlagScriptAction("hasQuest", true));
        //     }});

            
        // }});

        // scriptActions.add(new ConditionalScriptAction() {{
        //     addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
        //         addRequirement(new CustomRequirement() {
        //             @Override
        //             public boolean isRequirementMet() {
        //                 int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
        //                 return answer == 1;
        
        //             }
        //         });

        //          addScriptAction(new TextboxScriptAction() {{
        //             addScriptAction(new TextboxScriptAction("What a pity..."));
        //          }});
                
        //     }});

        // }});

        // scriptActions.add(new ConditionalScriptAction() {{
        //     addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
        //         addRequirement(new FlagRequirement("hasQuest1", true));
        //         addRequirement(new FlagRequirement("hasCompletedQuest1", false));


        //          addScriptAction(new TextboxScriptAction() {{
        //             addScriptAction(new TextboxScriptAction("It appears that you have yet to find my axe..."));
        //             addScriptAction(new TextboxScriptAction("I believe the RED man still has it."));
        //          }});
                
        //     }});

        // }});


        scriptActions.add(new NPCUnlockScriptAction());
        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
    