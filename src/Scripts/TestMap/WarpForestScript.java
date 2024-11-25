package Scripts.TestMap;

import Level.Script;
import ScriptActions.*;
import java.util.ArrayList;


// trigger script at beginning of game to set that heavy emotional plot
// checkout the documentation website for a detailed guide on how this script works
public class WarpForestScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new TextboxScriptAction() {{
            addText("You approach a glowing portal. \nThe sounds of trees blowing are coming out.");
            addText("Would you like to travel to the Forest Biome?", new String[] {"Yes", "No"});
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
                     addText("Traveling to... Forest Biome.");
                 }});
                 scriptActions.add(new UnlockPlayerScriptAction());
                //  scriptActions.add(new ChangeFlagScriptAction("unlockedSnow", true));
                 scriptActions.add(new ChangeFlagScriptAction("atForestBiome", true));
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
                    addScriptAction(new TextboxScriptAction("You walk away from the windy portal."));
                }});
                scriptActions.add(new UnlockPlayerScriptAction());
                addScriptAction(new WaitScriptAction(60));
            }});

        }});

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
