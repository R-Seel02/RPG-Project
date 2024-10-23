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
public class ChickenGreenScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {

        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
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

                addScriptAction(new WaitScriptAction(30));
                addScriptAction(new NPCFacePlayerScriptAction());
                addScriptAction(new TextboxScriptAction () {{
                    addText("ugh Blue is so annoying");
                    addText("I told him i'd give him 5 seeds if he did a backflip.");
                    addText("He took it way too seriously.");                
                    addText("I guess I'll give him them to keep him quiet.");
                    addText("Bye");
                }});
                addScriptAction(new NPCStandScriptAction(Direction.RIGHT));
                //scriptActions.add(new UnlockPlayerScriptAction());
                addScriptAction(new NPCWalkScriptAction(Direction.RIGHT, 550, 4));
                addScriptAction(new NPCWalkScriptAction(Direction.UP, 200, 4));
                addScriptAction(new NPCWalkScriptAction(Direction.RIGHT, 75, 4));
                addScriptAction(new NPCStandScriptAction(Direction.RIGHT));

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

                addScriptAction(new ChangeFlagScriptAction("hasTalkedToChickenGreen", true));
            }});
        }});


        scriptActions.add(new UnlockPlayerScriptAction());
        return scriptActions;
    }
}

