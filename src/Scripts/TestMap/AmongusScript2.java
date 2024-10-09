package Scripts.TestMap;

import java.util.ArrayList;


import Level.*;
import ScriptActions.*;



// script for talking to dino npc
// checkout the documentation website for a detailed guide on how this script works
public class AmongusScript2 extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {

        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCLockScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new TextboxScriptAction("..."));

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuest1", true));

                addScriptAction(new TextboxScriptAction() {{
                    addText("Hello!");
                    addText("YoU wAnT AxE?? ʘUʘ", new String[] { "Yes", "No" });
                }});
        
                scriptActions.add(new ConditionalScriptAction() {{
                    addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
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
                        //addScriptAction(new ChangeFlagScriptAction("hasAxe", true));
                        addScriptAction(new ChangeFlagScriptAction("hasCompletedQuest1", true));
                        addScriptAction(new ChangeFlagScriptAction("hasQuest", false));
                    }});
        
                   
        
                    addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                        addRequirement(new CustomRequirement() {
                            @Override
                            public boolean isRequirementMet() {
                                int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                                return answer == 1;
                            }
                        });
                        
                        addScriptAction(new TextboxScriptAction("mOrE aXe FoR mE!! (͡ ͡° ͜  ͡͡°)"));
                    }});
                }});
                


                
            }});
        }});


        scriptActions.add(new UnlockPlayerScriptAction());
        return scriptActions;
    }
}

