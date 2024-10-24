package Scripts.TestMap;

import Level.Script;
import ScriptActions.*;
import java.util.ArrayList;

// script for talking to walrus npc
// checkout the documentation website for a detailed guide on how this script works
public class PortalScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("atSnowBiome", false));
                addScriptAction(new TextboxScriptAction() {{
                    addText("Traveling to Snow Biome...");
                }});
                addScriptAction(new ChangeFlagScriptAction("atSnowBiome", true));
            }});

            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("atSnowBiome", true));
            }});
        }});

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
