package Scripts.TestMap;

import java.util.ArrayList;

import javax.swing.event.SwingPropertyChangeSupport;

import Engine.ImageLoader;
import GameObject.Frame;
import Level.Enemy;
import Level.Items;
import Level.Script;
import ScriptActions.*;

// script for talking to walrus npc
// checkout the documentation website for a detailed guide on how this script works
public class SkeletonScript extends Script {
    protected Enemy skeleton = new Enemy("Skeleton", 25, 5, 2, "Skeleton.png", 24, 24);

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCLockScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());
        
        scriptActions.add(new ConditionalScriptAction() {{
            

            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                
                
                addRequirement(new FlagRequirement("skeletonDefeated", false));
                scriptActions.add(new TextboxScriptAction("RAHHHHHHHHHHHH!!!"));
                
            }});
            
              

        }});

        


        scriptActions.add(new ConditionalScriptAction() {{
            

            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                
                addRequirement(new FlagRequirement("hasQuestOldGuy", true));
                addRequirement(new FlagRequirement("skeletonDefeated", false));
                scriptActions.add(new StartFightScriptAction(skeleton));
                scriptActions.add(new ChangeFlagScriptAction("isFighting", true));
                scriptActions.add(new IsEnemyDefeatedScript(skeleton, "skeletonDefeated"));
                
            }});
            
              

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("skeletonDefeated", true));
                scriptActions.add(new TextboxScriptAction("These old bones can take no more fighting!!!"));
            }});
        }});
       
        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("skeletonDefeated", true));
                addRequirement(new FlagRequirement("hasStaff", false));

                
                addScriptAction(new ChangeFlagScriptAction("hasStaff", true));
                addScriptAction(new AddItem("hasStaff", new Items(11, new Frame(ImageLoader.load("Staff.png")), "Staff")));
            }});
        }});



        scriptActions.add(new NPCUnlockScriptAction());
        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
