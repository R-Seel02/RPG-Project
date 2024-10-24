package Scripts.TestMap;

import java.util.ArrayList;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import GameObject.Frame;
import Level.*;
import ScriptActions.*;

import Utils.Direction;
import Utils.Point;
import Utils.Visibility;

// script for talking to dino npc
// checkout the documentation website for a detailed guide on how this script works
public class ChickenBlueScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {

        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new NPCFacePlayerScriptAction());
        scriptActions.add(new LockPlayerScriptAction());
        scriptActions.add(new TextboxScriptAction("*Chicken Noises*"));

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestFarmer", true));
                addRequirement(new FlagRequirement("hasCompletedQuestFarmer", false));
                addRequirement(new FlagRequirement("hasTalkedToChickenRed", true));
                addRequirement(new FlagRequirement("hasTalkedToChickenYellow", true));
                addRequirement(new FlagRequirement("hasTalkedToChickenOrange", true));
                addRequirement(new FlagRequirement("hasTalkedToChickenBlue", true));
                addRequirement(new FlagRequirement("hasTalkedToChickenGreen", false));


                 addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new TextboxScriptAction("You can't find green?\n he tends to hang out on the beach."));
                    addScriptAction(new TextboxScriptAction("Hurry up and find him\n I want what he owes me."));
                 }});
            }});

        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasQuestFarmer", true));
                addRequirement(new FlagRequirement("hasCompletedQuestFarmer", false));
                addRequirement(new FlagRequirement("hasTalkedToChickenRed", true));
                addRequirement(new FlagRequirement("hasTalkedToChickenYellow", true));
                addRequirement(new FlagRequirement("hasTalkedToChickenOrange", true));
                addRequirement(new FlagRequirement("hasTalkedToChickenBlue", false));

                addScriptAction(new WaitScriptAction(30));
                addScriptAction(new NPCFacePlayerScriptAction());
                addScriptAction(new TextboxScriptAction () {{
                    addText("Orange asked for me?");
                    addText("Didn't know bro was THAT chill.");
                    addText("Think you could grab green for me?\n He has owes me a solid.");                
                    addText("I'll catch you around.");
                }});
                addScriptAction(new NPCStandScriptAction(Direction.LEFT));
                //scriptActions.add(new UnlockPlayerScriptAction());
                addScriptAction(new NPCWalkScriptAction(Direction.DOWN, 750, 4));
                addScriptAction(new NPCWalkScriptAction(Direction.RIGHT, 430, 4));
                addScriptAction(new NPCStandScriptAction(Direction.LEFT));

                // addScriptAction(new ScriptAction() {
                //     @Override
                //     public ScriptState execute() {
                //         // change door to the open door map tile
                //         Frame openDoorFrame = new FrameBuilder(map.getTileset().getSubImage(4, 4), 0)
                //             .withScale(map.getTileset().getTileScale())
                //             .build();

                //         Point location = map.getMapTile(17, 4).getLocation();

                //         MapTile mapTile = new MapTileBuilder(openDoorFrame)
                //             .withTileType(TileType.NOT_PASSABLE)
                //             .build(location.x, location.y);

                //         map.setMapTile(17, 4, mapTile);
                //         return ScriptState.COMPLETED;
                //     }
                // });

                //addScriptAction(new NPCWalkScriptAction(Direction.UP, 50, 2));
                //addScriptAction(new NPCChangeVisibilityScriptAction(Visibility.HIDDEN));

                // addScriptAction(new ScriptAction() {
                //     @Override
                //     public ScriptState execute() {
                //         // change door back to the closed door map tile
                //         Frame doorFrame = new FrameBuilder(map.getTileset().getSubImage(4, 3), 0)
                //             .withScale(map.getTileset().getTileScale())
                //             .build();

                //         Point location = map.getMapTile(17, 4).getLocation();

                //         MapTile mapTile = new MapTileBuilder(doorFrame)
                //             .withTileType(TileType.NOT_PASSABLE)
                //             .build(location.x, location.y);

                //         map.setMapTile(17, 4, mapTile);
                //         return ScriptState.COMPLETED;
                //     }
                // });

                addScriptAction(new ChangeFlagScriptAction("hasTalkedToChickenBlue", true));
            }});
        }});


        scriptActions.add(new UnlockPlayerScriptAction());
        return scriptActions;
    }
}

