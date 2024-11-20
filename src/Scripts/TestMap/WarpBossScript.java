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
        
        scriptActions.add(new ConditionalScriptAction());

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("treeBossDefeated", false));
                addRequirement(new FlagRequirement("snowmanBossDefeated", false));
                addRequirement(new FlagRequirement("cactusBossDefeated", false));
                addRequirement(new FlagRequirement("rockBossDefeated", false));

                addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("You still need to defeat the following bosses:\nTree Boss, Snowman Boss, Cactus Boss, Rock Boss."));
                }});
                scriptActions.add(new UnlockPlayerScriptAction());
                addScriptAction(new WaitScriptAction(60));
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("treeBossDefeated", true));
                addRequirement(new FlagRequirement("snowmanBossDefeated", false));
                addRequirement(new FlagRequirement("cactusBossDefeated", false));
                addRequirement(new FlagRequirement("rockBossDefeated", false));

                addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("You still need to defeat the following bosses:\nSnowman Boss, Cactus Boss, Rock Boss"));
                }});
                scriptActions.add(new UnlockPlayerScriptAction());
                addScriptAction(new WaitScriptAction(60));
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("treeBossDefeated", false));
                addRequirement(new FlagRequirement("snowmanBossDefeated", true));
                addRequirement(new FlagRequirement("cactusBossDefeated", false));
                addRequirement(new FlagRequirement("rockBossDefeated", false));

                addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("You still need to defeat the following bosses:\nTree Boss, Cactus Boss, Rock Boss."));
                }});
                scriptActions.add(new UnlockPlayerScriptAction());
                addScriptAction(new WaitScriptAction(60));
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("treeBossDefeated", false));
                addRequirement(new FlagRequirement("snowmanBossDefeated", false));
                addRequirement(new FlagRequirement("cactusBossDefeated", true));
                addRequirement(new FlagRequirement("rockBossDefeated", false));

                addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("You still need to defeat the following bosses:\nTree Boss, Snowman Boss, Rock Boss."));
                }});
                scriptActions.add(new UnlockPlayerScriptAction());
                addScriptAction(new WaitScriptAction(60));
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("treeBossDefeated", false));
                addRequirement(new FlagRequirement("snowmanBossDefeated", false));
                addRequirement(new FlagRequirement("cactusBossDefeated", false));
                addRequirement(new FlagRequirement("rockBossDefeated", true));

                addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("You still need to defeat the following bosses:\nTree Boss, Snowman Boss, Cactus Boss."));
                }});
                scriptActions.add(new UnlockPlayerScriptAction());
                addScriptAction(new WaitScriptAction(60));
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("treeBossDefeated", true));
                addRequirement(new FlagRequirement("snowmanBossDefeated", true));
                addRequirement(new FlagRequirement("cactusBossDefeated", false));
                addRequirement(new FlagRequirement("rockBossDefeated", false));

                addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("You still need to defeat the following bosses:\nCactus Boss, Rock Boss."));
                }});
                scriptActions.add(new UnlockPlayerScriptAction());
                addScriptAction(new WaitScriptAction(60));
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("treeBossDefeated", false));
                addRequirement(new FlagRequirement("snowmanBossDefeated", true));
                addRequirement(new FlagRequirement("cactusBossDefeated", true));
                addRequirement(new FlagRequirement("rockBossDefeated", false));

                addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("You still need to defeat the following bosses:\nTree Boss, Rock Boss."));
                }});
                scriptActions.add(new UnlockPlayerScriptAction());
                addScriptAction(new WaitScriptAction(60));
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("treeBossDefeated", false));
                addRequirement(new FlagRequirement("snowmanBossDefeated", false));
                addRequirement(new FlagRequirement("cactusBossDefeated", true));
                addRequirement(new FlagRequirement("rockBossDefeated", true));

                addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("You still need to defeat the following bosses:\nTree Boss, Snowman Boss."));
                }});
                scriptActions.add(new UnlockPlayerScriptAction());
                addScriptAction(new WaitScriptAction(60));
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("treeBossDefeated", true));
                addRequirement(new FlagRequirement("snowmanBossDefeated", false));
                addRequirement(new FlagRequirement("cactusBossDefeated", true));
                addRequirement(new FlagRequirement("rockBossDefeated", false));

                addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("You still need to defeat the following bosses:\nSnowman Boss, Rock Boss."));
                }});
                scriptActions.add(new UnlockPlayerScriptAction());
                addScriptAction(new WaitScriptAction(60));
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("treeBossDefeated", true));
                addRequirement(new FlagRequirement("snowmanBossDefeated", false));
                addRequirement(new FlagRequirement("cactusBossDefeated", false));
                addRequirement(new FlagRequirement("rockBossDefeated", true));

                addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("You still need to defeat the following bosses:\nSnowman Boss, Cactus Boss."));
                }});
                scriptActions.add(new UnlockPlayerScriptAction());
                addScriptAction(new WaitScriptAction(60));
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("treeBossDefeated", false));
                addRequirement(new FlagRequirement("snowmanBossDefeated", true));
                addRequirement(new FlagRequirement("cactusBossDefeated", false));
                addRequirement(new FlagRequirement("rockBossDefeated", true));

                addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("You still need to defeat the following bosses:\nTree Boss, Cactus Boss."));
                }});
                scriptActions.add(new UnlockPlayerScriptAction());
                addScriptAction(new WaitScriptAction(60));
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("treeBossDefeated", true));
                addRequirement(new FlagRequirement("snowmanBossDefeated", true));
                addRequirement(new FlagRequirement("cactusBossDefeated", true));
                addRequirement(new FlagRequirement("rockBossDefeated", false));

                addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("You still need to defeat the last boss:\nRock Boss."));
                }});
                scriptActions.add(new UnlockPlayerScriptAction());
                addScriptAction(new WaitScriptAction(60));
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("treeBossDefeated", true));
                addRequirement(new FlagRequirement("snowmanBossDefeated", false));
                addRequirement(new FlagRequirement("cactusBossDefeated", true));
                addRequirement(new FlagRequirement("rockBossDefeated", true));

                addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("You still need to defeat the last boss:\nSnowman Boss."));
                }});
                scriptActions.add(new UnlockPlayerScriptAction());
                addScriptAction(new WaitScriptAction(60));
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("treeBossDefeated", false));
                addRequirement(new FlagRequirement("snowmanBossDefeated", true));
                addRequirement(new FlagRequirement("cactusBossDefeated", true));
                addRequirement(new FlagRequirement("rockBossDefeated", true));

                addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("You still need to defeat the last boss.\nTree Boss."));
                }});
                scriptActions.add(new UnlockPlayerScriptAction());
                addScriptAction(new WaitScriptAction(60));
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("treeBossDefeated", true));
                addRequirement(new FlagRequirement("snowmanBossDefeated", true));
                addRequirement(new FlagRequirement("cactusBossDefeated", false));
                addRequirement(new FlagRequirement("rockBossDefeated", true));

                addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("You still need to defeat the last boss:\nCactus Boss."));
                }});
                scriptActions.add(new UnlockPlayerScriptAction());
                addScriptAction(new WaitScriptAction(60));
            }});

        }});

        // scriptActions.add(new ConditionalScriptAction() {{
        //     addConditionalScriptActionGroup(new ConditionalScriptActionGroup()) {
        //         addRequirement(new FlagRequirement("treeBossDefeated", true));
        //         // addText("You approach a glowing portal. \nAn ominous prescense is felt.");
        //         // addText("Would you like to travel to the Boss Room?", new String[] { "Yes", "No" });
        //     }
            
        // }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("treeBossDefeated", true));
                addRequirement(new FlagRequirement("snowmanBossDefeated", true));
                addRequirement(new FlagRequirement("cactusBossDefeated", true));
                addRequirement(new FlagRequirement("rockBossDefeated", true));

                 addScriptAction(new TextboxScriptAction() {{
                    addText("You approach a glowing portal. \nAn ominous prescense is felt.");
                    addText("Would you like to travel to the Boss Room?", new String[] { "Yes", "No" });
                 }});
            }});   
        }});

        // scriptActions.add(new ConditionalScriptAction() {{
        //     addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
        //         addRequirement(new CustomRequirement() {
        //             @Override
        //             public boolean isRequirementMet() {
        //                 int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
        //                 return answer == 0;
        
        //             }
        //         });

        //          addScriptAction(new TextboxScriptAction() {{
        //              addText("Traveling to... Boss Room.");
        //          }});
        //          scriptActions.add(new UnlockPlayerScriptAction());
        //          scriptActions.add(new ChangeFlagScriptAction("atBossRoom", true));
        //     }});

            
        // }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("treeBossDefeated", true));
                addRequirement(new FlagRequirement("snowmanBossDefeated", true));
                addRequirement(new FlagRequirement("cactusBossDefeated", true));
                addRequirement(new FlagRequirement("rockBossDefeated", true));
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
                addScriptAction(new ChangeFlagScriptAction("atBossRoom", true));
            }});
        }});

        // scriptActions.add(new ConditionalScriptAction() {{
        //     addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
        //         addRequirement(new CustomRequirement() {
        //             @Override
        //             public boolean isRequirementMet() {
        //                 int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
        //                 return answer == 1;
        
        //             }
        //         });
        //         addScriptAction(new TextboxScriptAction() {{
        //             addScriptAction(new TextboxScriptAction("You walk away from the ominous portal."));
        //         }});
        //         scriptActions.add(new UnlockPlayerScriptAction());
        //         addScriptAction(new WaitScriptAction(60));
        //     }});

        // }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("treeBossDefeated", true));
                addRequirement(new FlagRequirement("snowmanBossDefeated", true));
                addRequirement(new FlagRequirement("cactusBossDefeated", true));
                addRequirement(new FlagRequirement("rockBossDefeated", true));
                addRequirement(new CustomRequirement() {
                    @Override
                    public boolean isRequirementMet() {
                        int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                        return answer == 1;
        
                    }
                });

                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("You walk away from the ominous portal."));
                    scriptActions.add(new UnlockPlayerScriptAction());
                    addScriptAction(new WaitScriptAction(60));
                 }});
            }});
        }});

        return scriptActions;
    }
}
