// package Scripts.TestMap;

// import java.util.ArrayList;

// import Level.MapEntityStatus;
// import Level.PickableObject;
// import Level.Script;
// import ScriptActions.*;

// public class RockScript extends Script {

//     protected PickableObject pickableObject;

    
    
//     public RockScript(PickableObject pickableObject){
//         this.pickableObject = pickableObject;
//     }

//     @Override

//     public ArrayList<ScriptAction> loadScriptActions() {
//         ArrayList<ScriptAction> scriptActions = new ArrayList<>();
//         scriptActions.add(new LockPlayerScriptAction());
//         scriptActions.add(new ConditionalScriptAction() {{
//             addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{

//                 addRequirement(new FlagRequirement("hasPickedupRock", false));
//                 addScriptAction(new TextboxScriptAction() {{
//                     addText("You have picked up the rock ");
                    
//                 }});
//                 addScriptAction(new ChangeFlagScriptAction("hasPickedUpRock", true));
//                 scriptActions.add(new RemoveEntity(pickableObject));
                
//             }});
           
//         }});
//         scriptActions.add(new ConditionalScriptAction() {{
//             addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
//                 addRequirement(new FlagRequirement("hasPickedupRock", true));
//                 addScriptAction(new TextboxScriptAction("you have placed the rock down"));
//             }});
//             scriptActions.add(new AddEntity(pickableObject));

        
     
//         }});

        
        
//         return scriptActions;
//     }
    
// }
