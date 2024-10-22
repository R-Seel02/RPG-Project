package Scripts.TestMap;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.*;


public class AmongusScript3 extends Script {

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

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasAxe", true));


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("No more axe :c"));
                    addScriptAction(new StartFightScriptAction("amongus.png"));
                    addScriptAction(new ChangeFlagScriptAction("isFighting", true));
                 }});
                
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuest1", true));
                addRequirement(new FlagRequirement("hasCompletetedQuest1", false));
                addRequirement(new FlagRequirement("hasAxe", false));

                 addScriptAction(new TextboxScriptAction() {{
                    addText("HeLLo!");
                    addText("YoU wAnT AxE?? ʘUʘ", new String[] { "Yes", "No" });
                 }});
            }});   
        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuest1", true));
                addRequirement(new FlagRequirement("hasCompletetedQuest1", false));
                addRequirement(new FlagRequirement("hasAxe", false));
                addRequirement(new CustomRequirement() {
                    @Override
                    public boolean isRequirementMet() {
                        int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                        return answer == 0;
        
                    }
                });

                 addScriptAction(new TextboxScriptAction() {{
                     addText("sus 0_0");
                 }});
                addScriptAction(new ChangeFlagScriptAction("hasAxe", true));
            }});

            
        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuest1", true));
                addRequirement(new FlagRequirement("hasCompletetedQuest1", false));
                addRequirement(new FlagRequirement("hasAxe", false));
                addRequirement(new CustomRequirement() {
                    @Override
                    public boolean isRequirementMet() {
                        int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                        return answer == 1;
        
                    }
                });

                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("mOrE aXe FoR mE!! (͡ ͡° ͜  ͡͡°)"));
                 }});
                
            }});

        }});

        // scriptActions.add(new ConditionalScriptAction() {{
        //     addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
        //         addRequirement(new FlagRequirement("hasAxe", true));


        //          addScriptAction(new TextboxScriptAction() {{
        //             addScriptAction(new TextboxScriptAction("No more axe :c"));
        //          }});
                
        //     }});

        // }});

     


        scriptActions.add(new NPCUnlockScriptAction());
        scriptActions.add(new UnlockPlayerScriptAction());
        

        return scriptActions;
    }
}