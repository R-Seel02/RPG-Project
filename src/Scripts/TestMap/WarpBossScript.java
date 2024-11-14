package Scripts.TestMap;

import Level.Script;
import ScriptActions.*;
import java.util.ArrayList;


// trigger script at beginning of game to set that heavy emotional plot
// checkout the documentation website for a detailed guide on how this script works
public class WarpBossScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new TextboxScriptAction() {{
            addText("You approach a glowing portal. \nAn ominous prescense is felt.");
            addText("Would you like to travel to the Boss Room?", new String[] { "Yes", "No" });
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
                     addText("Traveling to... Boss Room.");
                 }});
                 scriptActions.add(new UnlockPlayerScriptAction());
                 scriptActions.add(new ChangeFlagScriptAction("atBossRoom", true));
            }});

            
        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new CustomRequirement() {
                    @Override
                    public boolean isRequirementMet() {
                        int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                        return answer == 1;
        
                    }
                });
                addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("You walk away from the ominous portal."));
                }});
                scriptActions.add(new UnlockPlayerScriptAction());
                addScriptAction(new WaitScriptAction(60));
            }});

        }});


        

        return scriptActions;
    }
}
