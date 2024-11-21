package Scripts.TestMap;

import Level.Script;
import ScriptActions.*;
import java.util.ArrayList;


// trigger script at beginning of game to set that heavy emotional plot
// checkout the documentation website for a detailed guide on how this script works
public class WarpDesertScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("unlockedDesert", false));

                addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("You must reach the Desert Biome to unlock this portal."));
                }});
                scriptActions.add(new UnlockPlayerScriptAction());
                addScriptAction(new WaitScriptAction(60));
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("unlockedDesert", true));

                 addScriptAction(new TextboxScriptAction() {{
                    addText("You approach a glowing portal. It emits a dry heat.");
                    addText("Would you like to travel to the Desert Biome?", new String[] { "Yes", "No" });
                 }});
            }});   
        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("unlockedDesert", true));
                addRequirement(new CustomRequirement() {
                    @Override
                    public boolean isRequirementMet() {
                        int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                        return answer == 0;
        
                    }
                });

                 addScriptAction(new TextboxScriptAction() {{
                     addText("Traveling to... Desert Biome.");
                 }});
                 scriptActions.add(new UnlockPlayerScriptAction());
                 scriptActions.add(new ChangeFlagScriptAction("unlockedVolcano", true));
                 scriptActions.add(new ChangeFlagScriptAction("atDesertBiome", true));
            }});

            
        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("unlockedDesert", true));
                addRequirement(new CustomRequirement() {
                    @Override
                    public boolean isRequirementMet() {
                        int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                        return answer == 1;
        
                    }
                });
                addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("You walk away from the dry portal."));
                }});
                scriptActions.add(new UnlockPlayerScriptAction());
                addScriptAction(new WaitScriptAction(60));
            }});

        }});


        

        return scriptActions;
    }
}
