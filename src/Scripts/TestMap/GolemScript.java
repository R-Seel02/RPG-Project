package Scripts.TestMap;

import java.util.ArrayList;

import Level.Enemy;
import Level.Script;
import ScriptActions.*;
import Utils.Direction;


public class GolemScript extends Script {
    protected Enemy golemAndSpirit = new Enemy("Golem and Spirit", 100, 5, 2, "GolemAndSpirit.png", 40, 30);

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCLockScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new ConditionalScriptAction());
        
        //addScriptAction(new TextboxScriptAction("If I remember correctly, \n the note said theres a weapon somewhere aquatic."));
        //addScriptAction(new TextboxScriptAction("Who knows what was going through my head that night."));
        
        // scriptActions.add(new TextboxScriptAction() {{
        //     addText("You seem worthy...");
        //     addText("Would you like to go on a journey?", new String[] { "Yes", "No" });
        // }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuest", true));
                addRequirement(new FlagRequirement("hasQuestGolem", false));



                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("You already Have a Quest."));
                 }});
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasCompletedGolem", true));


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("Thanks for linking us up bro you were a huge help!"));
                    
                 }});
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestGolem", true));
                addRequirement(new FlagRequirement("hasCompletedQuestGolem", false));
                addRequirement(new FlagRequirement("hasQuest", true));
                addRequirement(new FlagRequirement("hasTalkedToFireSpirit", false));


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("How have you not found him yet bro?\n hes literally on fire."));

                 }});
                
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestGolem", false));
                addRequirement(new FlagRequirement("hasQuest", false));

                 addScriptAction(new TextboxScriptAction() {{
                    //addText("You seem worthy...");
                    addText("*He seems troubled... help him out?*", new String[] { "Yes", "No" });
                 }});
            }});   
        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestGolem", false));
                addRequirement(new FlagRequirement("hasQuest", false));
                addRequirement(new CustomRequirement() {
                    @Override
                    public boolean isRequirementMet() {
                        int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                        return answer == 0;
        
                    }
                });

                 addScriptAction(new TextboxScriptAction() {{
                     addText("Huh?.. Hey! stop eavsedropping!");
                     addText("I'm mad right now because that fire spirit\nmelted my rock sculpture!");
                     addText("You know what! tell him to meet me\nat the lava pools We're gonna settle this!");


                     //have him walk to the lava pools.
                 }});
                 addScriptAction(new NPCWalkScriptAction(Direction.DOWN, 200, 4));
                addScriptAction(new NPCWalkScriptAction(Direction.RIGHT, 460, 4));
                addScriptAction(new NPCStandScriptAction(Direction.RIGHT));
                addScriptAction(new ChangeFlagScriptAction("hasQuestGolem", true));
                addScriptAction(new ChangeFlagScriptAction("hasQuest", true));
            }});

            
        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestGolem", false));
                addRequirement(new FlagRequirement("hasQuest", false));
                addRequirement(new CustomRequirement() {
                    @Override
                    public boolean isRequirementMet() {
                        int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                        return answer == 1;
        
                    }
                });

                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("*You walk away as to not aggravate him more.*"));
                 }});
                
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestGolem", true));
                addRequirement(new FlagRequirement("hasTalkedToFireSpirit", true));
                addRequirement(new FlagRequirement("hasCompletedQuestGolem", false));


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("So you finally showed up! so why'd you do it\n why'd you destroy my sculpture!"));
                    addScriptAction(new TextboxScriptAction("I was just tryna add cool flames to it...  bro\n it would've looked fireeeee."));
                    addScriptAction(new TextboxScriptAction("Honestly that would've made the sculpture\nlook crazy good bro you got good taste."));
                    addScriptAction(new TextboxScriptAction("Thanks brooo \nthats what i've been saying about your sculptures."));
                    addScriptAction(new TextboxScriptAction("For real bro thanks man, I'm still mad though\n I need someone to fight!"));
                    addScriptAction(new TextboxScriptAction("Same here bro\nbut we can't fight eachother we're too chill now."));
                    addScriptAction(new TextboxScriptAction("I know bro... how about we just fight him!"));
                    addScriptAction(new TextboxScriptAction("Yea lets show him how its done!"));
                    scriptActions.add(new StartFightScriptAction(golemAndSpirit));

        scriptActions.add(new ChangeFlagScriptAction("isFighting", true));
                    addScriptAction(new TextboxScriptAction("Wow bro you're, like, hella strong."));
                    addScriptAction(new TextboxScriptAction("For real bro like respect."));
                    addScriptAction(new TextboxScriptAction("Here bro take this book I found by the lava rivers.\n I'm not smart enough to read it but I'm sure you are."));
                    addScriptAction(new TextboxScriptAction("Have a good one bro."));
                 }});
                 addScriptAction(new ChangeFlagScriptAction("hasCompletedQuestGolem", true));
                 addScriptAction(new ChangeFlagScriptAction("hasQuest", false));
            }});

        }});

        // scriptActions.add(new ConditionalScriptAction() {{
        //     addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
        //         addRequirement(new FlagRequirement("hasCompletedQuest1", true));


        //          addScriptAction(new TextboxScriptAction() {{
        //             addScriptAction(new TextboxScriptAction("I wish you luck on your future journeys!"));
        //          }});
        //     }});

        // }});

     


        scriptActions.add(new NPCUnlockScriptAction());
        scriptActions.add(new UnlockPlayerScriptAction());
        

        return scriptActions;
    }
}
    