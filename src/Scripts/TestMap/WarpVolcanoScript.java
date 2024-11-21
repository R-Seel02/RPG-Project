package Scripts.TestMap;

import Level.Script;
import ScriptActions.*;
import java.util.ArrayList;


// trigger script at beginning of game to set that heavy emotional plot
// checkout the documentation website for a detailed guide on how this script works
public class WarpVolcanoScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("unlockedVolcano", false));

                addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("You must reach the Volcano Biome to unlock this portal."));
                }});
                scriptActions.add(new UnlockPlayerScriptAction());
                addScriptAction(new WaitScriptAction(60));
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("unlockedVolcano", true));

                 addScriptAction(new TextboxScriptAction() {{
                    addText("You approach a glowing portal. \nIt emits a blazing inferno.");
                    addText("Would you like to travel to the Volcano Biome?", new String[] { "Yes", "No" });
                 }});
            }});   
        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("unlockedVolcano", true));
                addRequirement(new CustomRequirement() {
                    @Override
                    public boolean isRequirementMet() {
                        int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                        return answer == 0;
        
                    }
                });

                 addScriptAction(new TextboxScriptAction() {{
                     addText("Traveling to... Volcano Biome.");
                 }});
                 scriptActions.add(new UnlockPlayerScriptAction());
                 scriptActions.add(new ChangeFlagScriptAction("atVolcanoBiome", true));
            }});

            
        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("unlockedVolcano", true));
                addRequirement(new CustomRequirement() {
                    @Override
                    public boolean isRequirementMet() {
                        int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                        return answer == 1;
        
                    }
                });
                addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("You walk away from the flaming portal."));
                }});
                scriptActions.add(new UnlockPlayerScriptAction());
                addScriptAction(new WaitScriptAction(60));
            }});

        }});


        

        return scriptActions;
    }
}
