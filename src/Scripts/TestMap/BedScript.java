package Scripts.TestMap;

import Level.Script;
import ScriptActions.ChangeFlagScriptAction;
import ScriptActions.LockPlayerScriptAction;
import ScriptActions.NPCFacePlayerScriptAction;
import ScriptActions.ScriptAction;
import ScriptActions.UnlockPlayerScriptAction;
import java.util.ArrayList;


public class BedScript extends Script{
     @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        // scriptActions.add(new ConditionalScriptAction() {{
        //     addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
        //         addRequirement(new FlagRequirement("isSleeping", false));
        //         addScriptAction(new TextboxScriptAction() {{
        //             addText("You sleep to recover.");
        //         }});
        //         addScriptAction(new ChangeFlagScriptAction("isSleeping", true));
        //     }});
        // }});


        // scriptActions.add(new TextboxScriptAction() {{
        //     addText("You sleep to recover.");
        // }});


        scriptActions.add(new ChangeFlagScriptAction("isSleeping", true)); 
        
        // System.out.println("set true");
        // {{
        //     addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
        //         addRequirement(new FlagRequirement("hasTalkedToTestNPC", false));
        //         addScriptAction(new TextboxScriptAction() {{
        //             addText("OOGLY BOOGLY");
        //             addText("Bet I spooked ya there! hehe"); 
        //             addText("You want this coin?");
        //             //addText("Well too bad because I don't know how to give it to you.");
        //         }});
        //         addScriptAction(new ChangeFlagScriptAction("hasTalkedToTestNPC", true));
        //     }});

        //     addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
        //         addRequirement(new FlagRequirement("hasTalkedToTestNPC", true));
        //         //addScriptAction(new TextboxScriptAction("ahhhh I love my coin!"));
        //         addScriptAction(new TextboxScriptAction("Here ya go!"));
        //         // below line contains a created class that handles adding a coin, may be useful when it's more complicated
        //         addScriptAction(new AddCoin("hasTalkedToTestNPC"));

                
        //     }});


        // }});

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
