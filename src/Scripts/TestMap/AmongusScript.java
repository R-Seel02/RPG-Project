package Scripts.TestMap;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.*;

// script for talking to bug npc
// checkout the documentation website for a detailed guide on how this script works
public class AmongusScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCLockScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        

        scriptActions.add(new TextboxScriptAction() {{
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
                        // && player.getCoinCount() > 0
                    }
                });

                 addScriptAction(new TextboxScriptAction() {{
                     addText("sus 0_0");
                     
                //     //addText("I'm going to let you in on a little secret...\nYou can push some rocks out of the way.");
                //     addText("Thanks for spending your money!");
                //     // below line contains a created class that handles removing a coin, may be useful when it's more complicated
                //     //addScriptAction(new RemoveCoin(0));
                 }});
                addScriptAction(new ChangeFlagScriptAction("hasAxe", true));
                addScriptAction(new ChangeFlagScriptAction("hasCompletedQuest1", true));
                addScriptAction(new ChangeFlagScriptAction("hasQuest", false));
            }});

            // addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
            //     addRequirement(new CustomRequirement() {
            //         @Override
            //         public boolean isRequirementMet() {
            //             int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
            //             return answer == 0 && player.getCoinCount() < 1;
            //         }
            //     });

            //     addScriptAction(new TextboxScriptAction() {{
            //         //addText("I knew you were a cool cat!");
            //         //addText("I'm going to let you in on a little secret...\nYou can push some rocks out of the way.");
            //         addScriptAction(new TextboxScriptAction("... Hey man"));
            //     }});
            // }});

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

        scriptActions.add(new NPCUnlockScriptAction());
        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
    